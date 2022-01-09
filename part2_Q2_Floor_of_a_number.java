package com.binarySearch;

//Q2:Find Floor of a number
//floor-greatest number which is smallest or=target
//in this question return end in place of -1

public class part2_Q2_Floor_of_a_number {
    public static void main(String[] args) {
        int[] arr={1,12,23,34,55,56,767};
        int target=500;
        int ans=Floor_of_a_Number(arr,target);
        System.out.println(ans);
    }
    static int Floor_of_a_Number(int [] arr,int target){
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
        return end; //only change in return statement
    }
}
