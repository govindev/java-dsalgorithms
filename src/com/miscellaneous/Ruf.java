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
//        power();
//        checkIfArrayIsSorted();
//        int longest = longest(new int[]{10, 12, 14, 7, 8});
//        System.out.println("longest : " + longest);
        // int min = minimumFlips(new int[]{1,0,0,0, 1, 1,0,0, 1});
        // System.out.println("Minimum number of flips required are : " + min);
        // printFibonaci(10);
        // printNBonaci(4, 9);

//        System.out.println(findRightInd(new int[] {1, 1, 2, 2, 2, 2, 3}, 7, 2));
//        System.out.println(findLeftInd(new int[] {1, 1, 2, 2, 2, 2, 3}, 7, 2));
        // printSeries(4, 9);
        minGroupFlips("00011110001110");
    }
    static int minGroupFlips(String arr) {
        int count = 0;
        for (int i = 1; i < arr.length(); i++) {
            if (arr.charAt(i) != arr.charAt(0) && arr.charAt(i) != arr.charAt(i-1)) {
                count++;
            }
        }
        System.out.println("Minimum number of group flips required are : " + count);
        return count;
    }

    static void printSeries(int n, int m) {
        m++;
        int[] series = new int[m];
        for (int i = 0; i < n-1; i++) {
            series[i] = 0;
        }
        series[n-1] = 1;
        int sum = 1;
        for (int i = n; i < m; i++) {
            series[i] = sum;
            sum = sum + series[i] - series[i-n];
        }
        // Print
        for (int i = 0; i < m; i++) {
            System.out.print(series[i] + ",");
        }
    }



    private static int findLeftInd(int[] arr, int n, int x) {
        int left = 0, right = n-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (arr[mid] >= x) {
                if (mid != 0 && arr[mid-1] == x)
                    right = mid-1;
                else return mid;
            }
            else left = mid+1;
        }
        return -1;
    }

    private static int findRightInd(int[] arr, int n, int x) {
        int left = 0, right = n-1;
        while (left < right) {
            int mid = (left+right)/2;
            if (arr[mid] > x) right = mid-1;
            else {
                if (mid != n-1 && arr[mid+1] == x)
                    left = mid+1;
                else return mid;
            }
        }
        return -1;
    }

    private static int findElementInInfiniteArray(int[] arr, int s) {
        if (arr[0] == s) return 0;
        int h = 1;
        while (arr[h] < s) {
            h = h*2;
        }
        if (arr[h] == s) return h;
        int low = h/2 + 1, high = h-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (arr[mid] == s) return mid;
            if (arr[mid] > s) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }

    private static void printNBonaci(int n, int k) {
        int[] nums = new int[k];
        nums[n-1] = 1;
        int sum = 1;
        for (int i = n; i < k; i++) {
            nums[i] = sum;
            sum -= nums[i-n];
            sum += nums[i];
        }

        // Print
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + ", ");
        }
    }

    private static void printFibonaci(int k) {
        int first = 0, second = 1;
        System.out.print("0, 1, ");
        for (int i = 2; i < k; i++) {
            int newSecond = first+second;
            first = second;
            second = newSecond;
            System.out.print(newSecond + ", ");
        }
    }

    private static int minimumFlipsEfficient(int[] arr) {
        int i = 1;
        for (; i < arr.length; i++) {
            if (arr[i] != arr[0]) break;
        }
        if (i == arr.length-1) return 0;
        int flipCount = 1;
        for (int j = i+1; j < arr.length ; j++) {
            if (arr[j] != arr[j-1] && arr[j] == arr[i]) {
                flipCount++;
            }
        }
        return flipCount;
    }

    private static int minimumFlips(int[] arr) {
        int zeroFlipCount = 0;
        int oneFliptCount = 0;
        if (arr[0] == 1) oneFliptCount++;
        else zeroFlipCount++;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] != arr[i]) {
                if (arr[i] == 1) oneFliptCount++;
                else zeroFlipCount++;
            }
        }
        return Math.min(oneFliptCount, zeroFlipCount);
    }

    private static int longest(int[] arr) {
        int res = 1;
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1]%2 != arr[i]%2) count++;
            else count = 1;
            res = Math.max(count, res);
        }
        return res;
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






















