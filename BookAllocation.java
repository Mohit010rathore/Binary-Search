package com.binarySearch;

import java.util.ArrayList;

public class BookAllocation {
    public static boolean isPossible(ArrayList<Integer> arr, int n, int m,int mid){
        int studentCount = 1;
        int pageSum = 0;

        for(int i =0 ;i<n;i++){
            if(pageSum+arr.get(i) <= mid){
                pageSum += arr.get(i);
            }else{
                studentCount ++;
                if(studentCount > m || arr.get(i) > mid){
                    return false;
                }
                pageSum = arr.get(i);
            }
        }
        return true;
    }
    public static int allocateBooks(ArrayList<Integer> arr, int n, int m) {
        int s = 0;
        int sum = 0;
        for(int i =0;i<n;i++){
            sum += arr.get(i);
        }
        int e =sum;
        int ans = -1;

        while(s <= e){
            int mid = s + (e-s)/2;
            //checking if this mid value is a possible solution of not-> in isPossible function
            if(isPossible(arr,n,m,mid)){
                ans = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return ans;
    }
}
