package com.dsk.sparsearray;

/**
 * @Auther:代柿焜
 * @Date：2019/6/4 0004
 * @version:1.0
 */
public class SparseArray {
    public static void main(String args[]){
        //创建一个11*11的二维数组
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        //输出原始的二维数组
        System.out.println("原始的二维数组：");
        for(int[] row:chessArr1){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //将原始的二维数组转换成稀疏数组
        //1.遍历数组，得到非0的个数
        int sum=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0)
                    sum++;
            }
        }
        System.out.println("sum="+sum);
        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        //3.遍历二维数组将非零的值存放到稀疏数组中去
        int count=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }

            }
        }
        //4.输出稀疏数组
        System.out.println("得到的稀疏数组为：");
        for (int i=0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        //将稀疏数组恢复二维数组
        //1.先读取稀疏数组
        int chessArr2[][] =new int[sparseArr[0][0]][sparseArr[0][1]];
        //2.赋值
        for(int i=1;i<sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        //输出恢复后的二维数组
        System.out.println("恢复后的二维数组：");
        for(int[] row :chessArr2){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }
}
