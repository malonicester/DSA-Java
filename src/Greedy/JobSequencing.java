package Greedy;

import java.util.Arrays;

public class JobSequencing {
    public static void main(String[] args) {
        Job[] jobs = {new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 40), new Job(4, 1, 30)};
        int[]ans = jobSequencing(jobs);
        System.out.println(Arrays.toString(ans));
    }

    static int[] jobSequencing(Job[] jobs) {
        int profit = 0;
        int maxJobs = 0;
        boolean[]done = new boolean[jobs.length];
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        for (int i = 0; i < jobs.length; i++) {
            for(int j = Math.min(jobs.length-1,jobs[i].deadline-1);j>=0;j--){
                if(!done[j]){
                    done[j] = true;
                    maxJobs++;
                    profit+=jobs[i].profit;
                    break;
                }
            }
        }
        return new int[]{maxJobs,profit};
    }
}

class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", deadline=" + deadline +
                ", profit=" + profit +
                '}';
    }
}
