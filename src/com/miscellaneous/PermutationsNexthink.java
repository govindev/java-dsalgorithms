package com.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PermutationsNexthink {
    private static final String[] sortTexts = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    public static void main(String[] args) {
        printSortTexts(27);
    }

    private static void printSortTexts(int n) {
//        String[] texts = getSortTexts(n);
//        String[] texts = getSortTextsNaive(n);
//        for (String text : texts) {
//            System.out.println(text);
//        }

        Iterator<String> itr = getSortTextsIterator().iterator();
        int total = 0;
        while (itr.hasNext()) {
            total++;
            System.out.println(itr.next());
        }
        System.out.println("Total : " + total);

    }

    private static String[] getSortTextsNaive(int numberOfTexts) {
        int i = 0;
        List<String> list = new ArrayList<>();
        for (String str : sortTexts) {
            list.add(str);
        }
        while (list.size() <= numberOfTexts) {
            String curr = list.get(i++);
            for (String str : sortTexts) {
                list.add(curr + str);
            }
        }
        String[] strs = list.stream().toArray(String[]::new);
        Arrays.sort(strs);
        return strs;
    }

    private static String[] getSortTexts(int numberOfTexts) {
        if (numberOfTexts <= sortTexts.length) return sortTexts;

        int maxSortTextRequired = 1, n = 1;
        while (maxSortTextRequired < numberOfTexts) {
            maxSortTextRequired *= ++n;
        }
        return permutations(Arrays.copyOfRange(sortTexts, 0, n), numberOfTexts).stream().toArray(String[] ::new);
    }

    private static List<String> permutations(String[] strings, int requiredPermutations) {
        List<String> permutations = new ArrayList<>();
        func(strings, 0, permutations, requiredPermutations);
        return permutations;
    }

    private static void func(String[] strings, int ind, List<String> permutations, int requiredPermutations) {
        if (ind == strings.length) {
            StringBuilder permutation = new StringBuilder();
            for (String num : strings) {
                permutation.append(num);
            }
            permutations.add(permutation.toString());
            return;
        }
        if (permutations.size() >= requiredPermutations) {
            return;
        }

        for (int i = ind; i < strings.length; i++) {
            swap(i, ind, strings);
            func(strings, ind+1, permutations, requiredPermutations);
            swap(i, ind, strings);
        }
    }

    private static void swap(int i, int j, String[] arr) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static Iterable<String> getSortTextsIterator() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    int i = 0;
                    int j = 0;
                    int k = 0;
                    @Override
                    public boolean hasNext() {
                        return !(i == 25 && j == 25 && k == 25);
                    }

                    @Override
                    public String next() {
                        StringBuilder s = new StringBuilder();
                        if (k < 25) {
                            k++;
                        } else if (j < 25) {
                            k = 0;
                            j++;
                        } else if (i < 25) {
                            k = 0;
                            j = 0;
                            i++;
                        } else {
                            throw new RuntimeException("No more elements");
                        }
                        s.append(sortTexts[i]).append(sortTexts[j]).append(sortTexts[k]);
                        return s.toString();
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                };
            }
        };
    }
}


