package com.binarySearch;
//Q:  Ceiling of a number
//ceiling=smallest element in an array,greater or equal to the target element

import static com.binarySearch.part1_BS.binarySearch;

public class part2_Q1_Ceiling_of_a_num {
    public static void main(String[] args) {
        //if in a problem statement u are given a sorted array and do something with it
        //try using binary search most of the time u will get the answer
        int[] arr={1,12,23,34,55,56,767};
        int target=500;
        int ans=Ceiling_of_a_Number(arr,target);
        System.out.println(ans);

    }
    static int Ceiling_of_a_Number(int [] arr,int target){
        //but what if the target is greater than the greatest number in the array
        if(target> arr[arr.length-1])
        {
            return -1;
        }

        int start=0;
        int end=arr.length-1;

        while(start <= end)
        {
            //find the middle element
            //int mid=(start+end)/2; might be possible that (start + end) exceeds the range of integer
            int mid=start+(end-start)/2;//it is better way to find mid

            if(target < arr[mid])
            {
                end=mid-1; //start will remain same
            }else if(target > arr[mid])
            {
                start=mid+1;
            }else{
                //ans found
                return  mid;
            }

        }
        return start; //only change in return statement
    }

}
