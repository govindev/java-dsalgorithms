package com.miscellaneous;

public class Ruf {
    public static void main(String[] args) {
        int a = 4, b = 6;
//        int res = Math.max(a, b);
//        while(true) {
//            if(res%a == 0 && res%b == 0) {
//                System.out.println(res);
//                break;
//            }
//            res++;
//        }

//        int lcm = (a*b) / gcdEuclidian(a,b);
//        System.out.println(lcm);

        // printDivisors(55);
        // count();
      //  printPrimeFactors(12);
        power();
        checkIfArrayIsSorted();
    }

    private static void checkIfArrayIsSorted() {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
    }

    private static void power() {
        int x = 10, n = 2;
        long res = x;
        for (int i = 1; i < n; i++) {
            res *= x;
        }
        System.out.println(res);
    }

    private static int pow(int x, int n) {
        // recursive solution
        if (n == 0) return 1;
        int res = 1;
        if (n%2 == 0) {
            res = pow(x, n/2);
            return res*res;
        } else {
            return pow(x, n-1) * x;
        }
    }

    private static int powIterative(int x, int n) {
        // Iterative approach
        int res = x;
        while(n > 0) {
            if (n%2 == 0) {
                res = res * x;
            }
            x = x*x;
            n = n/2;
        }
        return res;
    }

    private static void printPrimeFactors(int n) {
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                int x = i;
                while (n%x == 0 && x < n) {
                    System.out.println(i);
                    x = i*i;
                }
            }
        }

        for (int i = 2; i*i <= n; i++) {
            if (isPrime(i))
            while(n%i == 0) {
                System.out.println(i);
                n = n/i;
            }
        }
    }


    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n%2 == 0 || n%3 == 0) return false;
        for (int i = 5; i*i <= n; i=i+6) {
            if (n%i == 0 || n%(i+2) == 0) return false;
        }
        return true;
    }

//    private static int gcd(int a, int b) {
//        int res = Math.min(a, b);
//        while(res > 0) {
//            if (a%res == 0 && b%res == 0) return res;
//            res--;
//        }
//        return 1;
//    }

    private static int gcdEuclidian(int a, int b) {
        if (b == 0) return a;
        return gcdEuclidian(b, a%b);
    }


    private static void printDivisors(int num) {
        for (int i = 1; i <= num; i++) {
            if (num%i==0)
            System.out.println(i);
        }


        // With the idea of divisors appear in pairs
        for ( int i = 1; i*i <= num; i++) {
            if (num%i == 0) {
                System.out.println(i);
                if (i != num/i) {
                    System.out.println(num/i);
                }
            }

        }

        // For printing them in the ascending order
        int i = 1;
        for (; i*i <= num; i++) {
            if (num%i == 0) {
                System.out.println(i);
            }
        }
        for (; i>1; i--) {
            if (num%i == 0) {
                System.out.println(num/i);
            }
        }

        // Factorial of a number
        int fact = 1;
        for (i = 1; i <= num; i++) {
            fact *= i;
        }



    }

    private static void count() {
        fact();

        int n = 1234567891;
        System.out.println(Math.floor(Math.log10(n) + 1));
        // Digits of a number
        int count = 0;
        while (n!=0) {
            count++;
            n = n/10;
        }
        System.out.println(count);
    }

    private static void fact() {
        int num = 20;
        long fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        System.out.println(fact);

    }
}






















