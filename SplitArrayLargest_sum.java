package com.binarySearch;

public class SplitArrayLargest_sum {
    public static void main(String[] args) {
        int arr[]={7,2,5,8,10};
        int m=2;
        int ans=splitArray(arr,m);
        System.out.println(ans);

    }

    public static int splitArray(int [] nums, int m)
    {
        int start=0;
        int end=0;

        for(int i=0;i< nums.length; i++)
        {
            start=Math.max(start,nums[i]); //in the end of the loop this will contain the  max item from the array
            end += nums[i];
        }

        //binary search
        while(start < end)
        {
            //try for the middle as potentials ans
            int mid=start + (end - start)/2;

            //calculatee how many pieces you can divide this in with this max sum
            int sum=0;
            int  pieces= 1;
            for(int num : nums)
            {
                if(sum + num > mid)
                {
                    //you cannot add this in this subarray, make new one
                    //say you add this num in new subarray,then sum=num
                    sum=num;
                    pieces ++;
                }else{
                    sum += num; //else just keep adding in this
                }
            }
            if(pieces > m)
            {
                start= mid + 1;

            }else{
                end = mid;
            }
        }
        return end; //here start == end
    }
}
