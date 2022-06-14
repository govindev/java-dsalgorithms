package com.gfg.dsalgo.mathematics;

public class GeekNumber {
    static int geekNumber(int number){
        for (int i = 2; i*i <= number && number > 1; i++) {
            int power = 0;
            while (number%i == 0) {
                number = number/i;
                power++;
                if (power > 1) return 0;
            }
        }
        return 1;
    }
}
