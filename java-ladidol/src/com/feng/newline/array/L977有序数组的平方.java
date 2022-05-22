package com.feng.newline.array;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L977有序数组的平方
 * @author: Ladidol
 * @description: 如果没错的话，应该还有个不新建数组的方式。
 * @date: 2022/5/21 23:18
 * @version: 1.0
 */
public class L977有序数组的平方 {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(new L977().sortedSquares(nums)));
    }
}
class L977 {
    public int[] sortedSquares(int[] nums) {
        //往左往右, 一次比较
        int left = 0;
        int right = nums.length-1;
        int k = right;//从最后开始来,倒着写;
        int[] newNums = new int[nums.length];
        while(left<=right){
            if (nums[left]*nums[left]<=nums[right]*nums[right]){
                newNums[k]=nums[right]*nums[right];
                k--;
                right--;
            }else {
                newNums[k]=nums[left]*nums[left];
                k--;
                left++;
            }
        }
        return newNums;
    }
}
