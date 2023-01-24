package com.sdesheet.striver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSequencingProblem {
    public static void main(String[] args) {
        // 1 4 20
        // 2 1 10
        // 3 1 40
        // 4 1 30
        Job[] arr = new Job[4];
        arr[0] = new Job(1, 4, 20);
        arr[1] = new Job(2, 1, 10);
        arr[2] = new Job(3, 1, 40);
        arr[3] = new Job(4, 1, 30);

        // 1 2 100
        // 2 1 19
        // 3 2 27
        // 4 1 25
        // 5 1 15
        JobScheduling(arr, 4);
    }

    //Function to find the maximum profit and the number of jobs done.
    static int[] JobScheduling(Job arr[], int n)
    {
        List<Job> jobs = new ArrayList<>();
        int maxDeadline = Integer.MIN_VALUE;
        for (Job job : arr) {
            jobs.add(job);
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }
        // System.out.println("max deadline is : " + maxDeadline);
        JobComparator comparator = new JobComparator();
        Collections.sort(jobs, comparator);
        int[] deadlines = new int[maxDeadline+1];

        int lastJobId = 0, totalProfit = jobs.get(lastJobId).profit, count = 1;
        deadlines[jobs.get(lastJobId).deadline] = 1;
        for (int i = 1; i < jobs.size(); i++) {
            Job job = jobs.get(i);
            int j = job.deadline;
            while (j > 0) {
                if (deadlines[j] == 0) {
                    lastJobId = i;
                    totalProfit += jobs.get(lastJobId).profit;
                    count++;
                    deadlines[j] = 1;
                    break;
                }
                j--;
            }
        }
        return new int[] {count, totalProfit};
    }
}

class JobComparator implements Comparator<Job> {
    @Override
    public int compare(Job job1, Job job2) {
        if (job1.profit > job2.profit) return -1;
        else if (job1.profit < job2.profit) return 1;
        else if (job1.deadline > job2.deadline) return -1;
        else return 1;
    }
}

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

