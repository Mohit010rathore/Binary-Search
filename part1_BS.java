package com.binarySearch;

public class part1_BS {
    public static void main(String[] args) {
        int[] arr={1,12,23,34,55,56,767};
        int target=34;
        int ans=binarySearch(arr,target);
        System.out.println(ans);

    }
    //return the index
    //return -1 if it is does not exist
    static int binarySearch(int [] arr,int target){
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
         return -1;
    }

}
