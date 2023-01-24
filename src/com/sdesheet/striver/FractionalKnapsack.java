package com.sdesheet.striver;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        Arrays.sort(arr, new ItemComparator());

        double maxTotalValue = 0;

        for (Item item : arr) {
            if (W <= 0) return maxTotalValue;
            if (W >= item.weight) {
                maxTotalValue += item.value;
                W -= item.weight;
            } else {
                maxTotalValue += (double)W * ((double)item.value / (double)item.weight);
                W = 0;
            }
        }
        return maxTotalValue;
    }
}


class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item i1, Item i2) {
        double r2 = (double)i2.value/(double)i2.weight;
        double r1 = (double)i1.value/(double)i1.weight;
        if (r1 < r2) return 1;
        else return -1;
    }
}