package com.binarySearch;

public class part1_OrderAgnostic_binary_search {
    public static void main(String[] args) {
        int[] arr={98,87,76,65,43,32,21,12,11};
        int target=76;
        int ans=orderAgnosticBS(arr,target);
        System.out.println(ans);

    }
    static int orderAgnosticBS(int[] arr,int target)
    {
        int start=0;
        int end=arr.length-1;

        //find whether the array is sorted in ascending or descending
        boolean isAsc;
        if (arr[start] < arr[end]){
            isAsc=true;
        }else{
            isAsc=false;
        }

        while(start <= end)
        {
            //find the middle element
            //int mid=(start+end)/2; might be possible that (start + end) exceeds the range of integer
            int mid=start+(end-start)/2;//it is better way to find mid

            if(arr[mid]== target)
            {
                return mid;
            }
            if(isAsc)
            {
                if(target < arr[mid])
                {
                    end=mid-1; //start will remain same
                }else if(target > arr[mid])
                {
                    start=mid+1;
                }
            }else{
                if(target > arr[mid])
                {
                    end=mid-1; //start will remain same
                }else if(target < arr[mid])
                {
                    start=mid+1;
                }
            }
        }
        return -1;
    }
}
