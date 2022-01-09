package com.binarySearch;

public class Find_in_mountainArray {
    public static void main(String[] args) {
          int arr[]={1,3,4,5,6,2,0};
          int target=3;
        System.out.println(search(arr,target));
    }
    static public int search(int []arr,int target)
    {
        int peak=peakIndexInMountArray(arr);
        int firstTry=orderAgnosticBS(arr,target,0,peak); //firstly searching in ascending side
        if(firstTry != -1)
        {
            return firstTry;
        }
        //try to search in second half
        return orderAgnosticBS(arr,target,peak+1,arr.length-1);
    }

    static public int peakIndexInMountArray(int[] arr)
    {
        int start=0;
        int end=arr.length-1;

        while(start < end)
        {
            int mid=start + (end - start)/2;
            if(arr[mid] > arr[mid+1])
            {
                //you are in decreasing part of array
                //this may be the ans,but look at left it can be there too
                //this is why end !=  mid - 1
                end=mid; //checking left hand side
            }else{
                //you are in ascending of the array,and u will find the ans at right
                start=mid+1;// bcoz we know that mid+1 element > mid elelemnt
            }
        }
        //in the end,start is going to be == end and pointing to the largest number because of the 2 checks above
        //start and end are always trying to find max element in the two above checks
        //hence, when they are pointing to just one element,that is the maximum one bcoz that is what the check says
        //more elaboration:at every point of time for start and end,they have the best possible answer till that time
        //and if we are saying that only one item is remaining,hence cuz of above line that is the best possible ans
        return end; //or return start both are equal
    }
    static int orderAgnosticBS(int[] arr,int target,int start,int end)
    {

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
