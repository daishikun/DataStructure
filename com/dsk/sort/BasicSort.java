package com.dsk.sort;

import java.util.Arrays;

/**
 * 排序算法
 * 一、比较类排序
 * （一）、交换排序
 * 1.冒泡排序
 * 2.快速排序
 * （二）、插入排序
 * 1.简单插入排序
 * 2.希尔排序
 * （三）、选择排序
 * 1.简单选择排序
 * 2.堆排序
 * （四）、归并排序
 * 1.两路归并排序
 * 2.多路归并排序
 * 二、非比较类排序
 * （一）、计数排序
 * （二）、桶排序
 * （三）、基数排序
 */
public class BasicSort {
    /**
     * 冒泡排序
     * 1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 3.针对所有的元素重复以上的步骤，除了最后一个；
     * 4.重复步骤1~3，直到排序完成。
     * 时间复杂度（平均） O(n**2)
     * 时间复杂度 （最坏）O(n**2)
     * 时间复杂度 （最好）O(n)
     * 空间复杂度  O(1)
     * 稳定性     稳定
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

    /**
     * 快速排序
     * 1.从数列中挑出一个元素，称为 “基准”（pivot）；
     * 2.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
     * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * 时间复杂度（平均） O(n*logN)
     * 时间复杂度 （最坏）O(n**2)
     * 时间复杂度 （最好）O(n*logN)
     * 空间复杂度  O(n*logN)
     * 稳定性     不稳定
     */
    public static int[] quickSort(int[] arr, int left, int right) {
        int partitionIndex;
        if (left < right) {
            partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    // 确定基准
    public static int partition(int[] arr, int left, int right) {    // 分区操作
        int pivot = left,                     // 设定基准值（pivot）
                index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    // 交换值
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 简单插入排序
     * 1.从第一个元素开始，该元素可以认为已经被排序；
     * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 5.将新元素插入到该位置后；
     * 6.重复步骤2~5。
     * 时间复杂度（平均） O(n**2)
     * 时间复杂度 （最坏）O(n**2)
     * 时间复杂度 （最好）O(n)
     * 空间复杂度  O(1)
     * 稳定性     稳定
     */
    public static int[] insertionSort(int[] arr) {
        int preIndex, current;
        for (int i = 1; i < arr.length; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }


    /**
     * 希尔排序
     * 1.选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     * 2.按增量序列个数k，对序列进行k 趟排序；
     * 3.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
     * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * 时间复杂度（平均） O(n**1.3)
     * 时间复杂度 （最坏）O(n**2)
     * 时间复杂度 （最好）O(n)
     * 空间复杂度  O(1)
     * 稳定性     不稳定
     */
    public static int[] shellSort(int[] arr) {
        int len = arr.length;
        for (int gap = len / 2; gap > 0; gap = gap / 2) {
            // 多个分组交替执行
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = arr[i];
                while (j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = current;
            }
        }
        return arr;
    }

    /**
     * 简单选择排序
     * 1.初始状态：无序区为R[1..n]，有序区为空；
     * 2.第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
     * 3.该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)
     * 分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；n-1趟结束，数组有序化了。
     * 时间复杂度（平均） O(n**2)
     * 时间复杂度 （最坏）O(n**2)
     * 时间复杂度 （最好）O(n**2)
     * 空间复杂度  O(1)
     * 稳定性     不稳定
     */
    public static int[] selectionSort(int[] arr) {
        int len = arr.length;
        int minIndex, temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {    // 寻找最小的数
                    minIndex = j;                // 将最小数的索引保存
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    /**
     * 堆排序
     * 1.将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
     * 2.将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),
     * 且满足R[1,2…n-1]<=R[n]；
     * 3.由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，
     * 然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。
     * 不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
     */

    public static int len;
    public static void buildMaxHeap(int[] arr) {  // 建立大顶堆
        len = arr.length;
        for (int i = len/2; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    public static void heapify(int[] arr, int i) {    // 堆调整
        int left = 2 * i + 1,
                right = 2 * i + 2,
                largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest);
        }
    }

    public static int[] heapSort(int[] arr) {
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 7, 9};
        int[] a1 = bubbleSort(arr);
        int[] a2 = quickSort(arr,0,arr.length-1);
        int[] a3 = insertionSort(arr);
        int[] a4 = shellSort(arr);
        int[] a5 = selectionSort(arr);
        int[] a6 = heapSort(arr);
        System.out.println(Arrays.toString(a6));
    }
}
