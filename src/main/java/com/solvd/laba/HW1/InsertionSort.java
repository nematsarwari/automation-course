package com.solvd.laba.HW1;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {

        int[] nums = new int[args.length];
        if(args.length == 0){
            System.out.println("NO ARGUMENT");
        }else {
        for (int i = 0; i < args.length; i++){
            nums[i] = Integer.parseInt(args[i]);
            System.out.println("Before");
            System.out.println(Arrays.toString(nums));
            System.out.println("After");
            System.out.println(Arrays.toString(insertionSort(nums)));
        }
        }





    }
    static int[] insertionSort(int[] input){
        for(int i = 1; i < input.length; i++){
            int current = input[i];
            int j = i-1;
            while (j >= 0 && input[j] > current){
                input[j + 1] = input[j];
                j--;
            }
            input[j + 1] = current;
        }
        return input;
    }
}
