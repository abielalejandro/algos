package com.example;

public class DetectAllPower2 {
    
    boolean arePowerOf2(int[] powers) {
        int result=0;
        for (int i=0; i<powers.length; i++) {
            for(int j=0;j<powers[i]; j++) {
                result ^= j;
            }            
            System.err.println(result); 
        }

        System.err.println(result); 
        return result==0;
    }
}
