package com.binarySearch;

public class Search_In_RotatedSortedArray {
    public static void main(String[] args) {
        int arr[]={4,5,6,7,0,1,2};
        int target=5;
        System.out.println(search(arr,target));
    }

    static public  int search(int[] nums,int target)
    {
        int pivot = findPivot(nums);

        //if you did not find a pivot,it means the array is not rotated
        if(pivot == -1)
        {
            //just do noraml binary search,bcoz array is not rotated
            return binarySearch(nums,target,0,nums.length-1);
        }
        //if pivot is found,you have found 2 asc sorted arrays
        if(nums[pivot]==target)
        {
            return pivot;
        }
        if(target >= nums[0])
        {
            return binarySearch(nums,target,0,pivot-1);
        }

        return binarySearch(nums,target,pivot+1,nums.length-1);

    }

    //this will not work for duplicate values
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
            if(mid > start && arr[mid] < arr[mid-1]) //we will confirm that mid index is not out of bound
            {
                return mid-1 ;
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
