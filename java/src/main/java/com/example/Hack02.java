package com.example;

/*
 * Check if every row and every columns contains every number
 * A Matrix n*n is valid if every rows and column has then number from 
 * 1 to N inclusive
 * Example: [[1,2,3],[3,1,2],[2,3,1]]  == true
 */
public class Hack02 {

    private int sum(int[][] input, int index, int n) {
        int tr = 0;
        int tc = 0;
        for(int c =0;c<n; c++) {
            tr+=input[index][c];
            tc+=input[c][index];
        }
        return tr+tc;
    }

    public boolean isValid(int[][] input) {
        int n = input.length;
        if (n==0) return true;
        
        int r=0;
        int max = ((n*n) + n)/2;

        max *=2;
        while(r<n) {
            int t = sum(input,r,n);
            if (t!=max) return false;
            r++;
        }
        return true;
    }

}
