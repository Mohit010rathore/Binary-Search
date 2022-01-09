package com.binarySearch;

public class RotationCount {
    public static void main(String[] args) {
         int [] arr={4,5,6,7,0,1,2};
        System.out.println(countRotations(arr));
    }

    private static int countRotations(int[] arr) {
        int pivot=findPivot(arr);

        return pivot+1;
    }
    //use this for non-duplicates
    static int findPivot(int[] arr)
    {
        int start=0;
        int end=arr.length-1;

        while(start <= end)
        {
            int mid= start + (end-start) / 2;
            //4 cases over here
            //case 1
            if(mid < end && arr[mid] > arr[mid+1]) //we will confirm that mid index is not out of bound
            {
                return mid;
            }
            //case 2
            if(mid > end && arr[mid] < arr[mid+1]) //we will confirm that mid index is not out of bound
            {
                return mid;
            }
            //case 3
            //will search in first half of the array
            //for duplicate value it will fail here,all start end and mid are same
            if(arr[mid] <= arr[start])
            {
                end=mid-1;
            }else{ //case 4-will search in 2nd half of the array
                start=mid+1;
            }

        }
        return -1;
    }

    //use this for duplicates
    static int findPivotWithDuplicates(int[] arr)
    {
        int start=0;
        int end=arr.length-1;

        while(start <= end)
        {
            int mid= start + (end-start) / 2;
            //4 cases over here
            //case 1
            if(mid < end && arr[mid] > arr[mid+1]) //we will confirm that mid index is not out of bound
            {
                return mid;
            }
            //case 2
            if(mid > end && arr[mid] < arr[mid+1]) //we will confirm that mid index is not out of bound
            {
                return mid;
            }
            //case 3
            //will search in first half of the array
            //if elemnets  at middle ,start,end are equal then just skip the duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end])
            {
                //skip the du[licates
                //NOTE:what if these elements at start and end were the pivot??
                //check if start is pivot
                if(arr[start] > arr[start+1])//start will be pivot when its next element is smaller
                {
                    return start;
                }
                start++;//skipping the duplicates

                //check whether end is pivot
                if(arr[end] > arr[end-1])
                {
                    return end-1;
                }
                end--;
            }
            //left side is sorted, so pivot be in right
            if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end]))
            {
                start=mid + 1; //means left is sortedin asc order,so pivot is in right
            }else{
                end=mid - 1;
            }


        }
        return -1;
    }

    static int binarySearch(int [] arr,int target,int start,int end){

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
