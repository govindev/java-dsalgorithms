package com.miscellaneous;

public class LcmAndGcd {
    static Long[] lcmAndGcd(Long A , Long B) {
        Long[] res = new Long[2];

        // res[0] = lcmNaive(A, B);
        // res[1] = gcdNaive(A, B);


        // res[1] = gcdEuclidin(A, B);
        // res[0] = (A*B) / res[1];


        res[1] = gcdEuclidinOptimized(A, B);
        res[0] = (A*B) / res[1];

        return res;
    }

    static Long gcdEuclidinOptimized(Long A, Long B) {
        if (B == 0) return A;
        return gcdEuclidinOptimized(B, A%B);
    }

    static Long gcdEuclidin(Long A, Long B) {
        while (A != B) {
            if (A > B) {
                A = A-B;
            } else {
                B = B-A;
            }
        }
        return A;
    }

    static Long lcmNaive(Long A, Long B) {
        Long lcm = Math.max(A, B);
        while(true) {
            if (lcm%A == 0 && lcm%B == 0) {
                return lcm;
            }
            lcm++;
        }
    }

    static Long gcdNaive(Long A, Long B) {
        Long gcd = Math.min(A, B);
        while (true) {
            if (A%gcd == 0 && B%gcd == 0) {
                return gcd;
            }
            gcd--;
        }
    }
}
