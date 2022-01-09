package com.binarySearch;

//Given a character array letters that is sorted in non-decreasing order and a character target
//,return the smallest character in the array that is larger than target.
//Note: that the letters wrap around.
//for example,if target=='z' and letters==['a','b'],the answer is 'a'.
//if there is no character in the array that is larger than the target element,than return the first index
public class part2_Q3_smallestLetter {
    public static void main(String[] args)   {
       char[] letters={'c','f','g','x'};
       int target='j';
       char ans=SmallestLetter(letters,target);
        System.out.println(ans);
    }
    static char SmallestLetter(char[] letters, int target){

        int start=0;
        int end=letters.length-1;

        while(start <= end)
        {
            //find the middle element
            //int mid=(start+end)/2; might be possible that (start + end) exceeds the range of integer
            int mid=start+(end-start)/2;//it is better way to find mid

            if(target < letters[mid])
            {
                end=mid-1; //start will remain same
            }else
            {
                start=mid+1;
            }
        }
        return letters[start % letters.length];
    }
}
