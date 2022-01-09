package com.binarySearch;

public class Question6_peakIndex_in_Mountain_Array {
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,7,2};
        System.out.println(peakIndexInMountArray(arr));

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

}
