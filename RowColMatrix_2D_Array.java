package com.binarySearch;

import java.util.Arrays;

public class RowColMatrix_2D_Array {

    public static void main(String[] args) {
           int [][] arr={
                   {10,20,30,40},
                   {15,25,35,45},
                   {28,29,37,49},
                   {33,34,38,50}
           };

        System.out.println(Arrays.toString(search(arr,40))); //this will return me an array
    }
    static int [] search(int [][] matrix , int target)
    {
        int r = 0 ;
        int c = matrix.length-1 ;

        while(r < matrix.length && c>=0)
        {
            if(matrix[r][c] == target){
                return new int[]{r,c};
            }
            if(matrix[r][c] < target)
            {
                r++;
            }
            if(matrix[r][c] > target)
            {
                c--;
            }
        }
        return new int[]{-1,-1};
    }
}
