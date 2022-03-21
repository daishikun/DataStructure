package com.dsk.learn;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Test {

    /**
     * 对数器
     */
    public static void main(String[] args) {
        int testTime = 500000;
        int size = 10;
        int value = 100;
        boolean success = true;
        for (int i = 0; i < testTime; ++i) {
            int[] arr1 = generateRandomArray(size, value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr2);
            bubbleSort(arr1);
            rightMethod(arr2);
            if (!isEqual(arr1, arr2)) {
                success = false;
                System.out.println(Arrays.toString(arr3));
                break;
            }
        }
        System.out.println(success ? "Nice" : "Fack");
    }

    /**
     * 生成随机的数组
     *
     * @param size  数组的个数
     * @param value 数组里面值的限制
     * @return int[] 返回生成的数组
     */
    public static int[] generateRandomArray(int size, int value) {
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (int) ((value + 1) * Math.random()) - (int) ((value + 1) * Math.random());
        }
        return arr;
    }

    /**
     * 绝对正确的方法排序
     *
     * @param arr 原始数组
     */
    public static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 拷贝数组
     *
     * @param arr 原始数组
     * @return 拷贝数组
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null)
            return null;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 判断数组是否相同
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 是否相同
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
            return false;
        if (arr1 == null) // arr2 一定为null
            return true;
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; ++i) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 冒泡法排序
     *
     * @param arr 原始数组
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; --end) {
            for (int i = 0; i < end; ++i) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }


    /**
     * 选择法排序
     *
     * @param arr 原始数组
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length - 1; ++j) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length - 1; ++i) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; --j) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
