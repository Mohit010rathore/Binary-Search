package com.binarySearch;

//doubling the size and finding the range
//T.C=logN
public class Question_5_position_in_infinite_sorted_array {
    public static void main(String[] args) {
        int[] arr={3,5,6,7,10,11,12,15,20,23,30,34,36,37};
        int target=12;
        System.out.println(findingRange(arr,target));

    }
    static int findingRange(int[] arr, int target)
    {
        //first find the range
        //first start with a box of 2
        int start=0;
        int end=1;
        //condition for the target to lie in the range
        //we will keep doubling the size,while my target element is greater than my end
        while(target > arr[end])
        {
            int newStart=end+1;
            //double the box
            //end=previous end + sizeofbox*2
            end=end + ( end - start + 1)*2;
            start=newStart;
        }
        // at this point we have updated low
        // and high indices, thus use binary
        // search between them
        return binarySearch(arr,target,start,end);


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
