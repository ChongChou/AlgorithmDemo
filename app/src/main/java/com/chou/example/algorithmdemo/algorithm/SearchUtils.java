package com.chou.example.algorithmdemo.algorithm;

import java.util.Arrays;

/**
 * Created by zhouchong on 2018/2/8.
 * 二分查找：在有序数组中，查找特定元素的索引
 */

public class SearchUtils {
    /**
     * 升序数组中，查找某个元素
     * while循环实现
     * @param key   要查找的元素
     * @param array 排好序的数组
     * @return 找到了，返回该元素下标；否则返回-1
     */
    public static int binarySearch(int key, int[] array) {
        System.out.println("BinarySearch======>array = " + Arrays.toString(array) + ", key = " + key);
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            System.out.println("BinarySearch======>low = " + low + "， high = " + high + ", mid = " + mid + ", arr[mid] = " + array[mid]);
            if (array[mid] < key) {
                low = mid + 1;
            } else if (array[mid] > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归实现二分查找
     * @param key 查找的key值
     * @param array 数组
     * @return 索引值，未找到返回-1
     */
    public static int binarySearchRecursive(int key, int[] array) {
        System.out.println("BinarySearchRecursive======>sourceArray = " + Arrays.toString(array) + ", key = " + key);
        return binarySearchRecursive(key, array, 0, array.length - 1);
    }

    /**
     * 递归方法
     * @param key   要查找的值
     * @param array 数组
     * @param low   下限
     * @param high  上限
     * @return 找到返回index，否则返回-1
     */
    private static int binarySearchRecursive(int key, int[] array, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (high - low) / 2 + low;
        System.out.println("BinarySearchRecursive======>low = " + low + ", high = " + high + ", mid = " + mid + ", a[mid] = " + array[mid]);
        if (key > array[mid]) {
            low = mid + 1;
        } else if (key < array[mid]) {
            high = mid - 1;
        } else {
            return mid;
        }
        return binarySearchRecursive(key, array, low, high);
    }
}
