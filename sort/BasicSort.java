package sort;

import java.util.Arrays;

/**
 * 排序算法
 * 一、比较类排序
 *      （一）、交换排序
 *              1.冒泡排序
 *              2.快速排序
 *      （二）、插入排序
 *              1.简单插入排序
 *              2.希尔排序
 *      （三）、选择排序
 *              1.简单选择排序
 *              2.堆排序
 *      （四）、归并排序
 *              1.两路归并排序
 *              2.多路归并排序
 * 二、非比较类排序
 *      （一）、计数排序
 *      （二）、桶排序
 *      （三）、基数排序
 */
public class BasicSort {
    /**
     * 冒泡排序
     * @return 排完序的数组
     */
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int [] arr = {3,6,1,7,9};
        int[]  a  = bubbleSort(arr);
        System.out.println(Arrays.toString(a));
    }
}
