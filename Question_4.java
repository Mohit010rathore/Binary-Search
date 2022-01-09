package com.binarySearch;

import java.util.Arrays;

//find first and last position of element in sorted array
public class Question_4 {
    public static void main(String[] args) {
         int[] nums={1,2,3,3,3,4,5,6};
         int target=3;

        System.out.println(Arrays.toString(searchRange(nums,target)));
    }
    static public int[] searchRange(int[] nums,int target)
    {
        int[] ans={-1,-1};
        //check for first occurence if target first
        int start=search(nums,target,true);
        int end=search(nums,target,false);

        ans[0] = start;
        ans[1] = end;

        return ans;
    }
    //this function just return the index value of target
    static public int search(int[] nums,int target,boolean findStartIndex){
        int ans=0;//letting our potential ans -1

        //check for first occurence if target first
        int start=0;
        int end=nums.length-1;

        while(start <= end)
        {
            int mid=start+(end-start)/2;//it is better way to find mid

            if(target < nums[mid])
            {
                end=mid-1; //start will remain same
            }else if(target > nums[mid])
            {
                start=mid+1;
            }else{
                //potential ans found
                //here we can find more target element before and after mid element
                ans=mid;
                if(findStartIndex)
                {
                    end=mid-1;
                }else{
                    start=mid +1;
                }
            }
        }
        return ans;
    }
}
