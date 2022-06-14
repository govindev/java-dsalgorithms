package com.gfg.dsalgo.mathematics;

public class GeekNumber {
    static int geekNumber(int number){
        if (number <= 1) return 1;
        int power = 0;
        while (number%2 == 0) {
            number = number/2;
            power++;
            if (power > 1) return 0;
        }
        power = 0;
        while (number%3 == 0) {
            number = number/3;
            power++;
            if (power > 1) return 0;
        }
        for (int i = 5; i*i <= number; i=i+6) {
            power = 0;
            while (number%i == 0) {
                number = number/i;
                power++;
                if (power > 1) return 0;
            }
            power = 0;
            while (number%(i+2) == 0) {
                number = number/(i+2);
                power++;
                if (power > 1) return 0;
            }
        }
        return 1;
    }
}
