package Algorithms.GreedyBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Jobs {
    int deadline;
    int profit;

    public Jobs(int deadline, int profit) {
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Jobs{" +
                "deadline=" + deadline +
                ", profit=" + profit +
                '}';
    }
}

public class JobScheduling {
    // o( nln n + n^2)
    public static void jobSchedulingImpl(ArrayList<Jobs> list) {
        Comparator<Jobs> profitSort = (Jobs o1, Jobs o2) -> o2.profit - o1.profit;

        Collections.sort(list, profitSort);
        boolean[] slot = new boolean[list.size()];
        int maxProfit = 0;
        System.out.println(list);
        ArrayList<Jobs> result = new ArrayList<>();
        // loop through each job
        for (int i = 0; i < list.size(); i++) {
            //find its place in slots array
            //System.out.println(list.get(i).deadline);

            //Math.min(list.size(), list.get(i).deadline) - 1
            //this code highlights that max it will go to deadline date and check if any date is available or not

            //selection phase of code
            for (int j = Math.min(list.size(), list.get(i).deadline) - 1; j >= 0; j--) {
                //for that item slot before time line is available or not
                //if yes. give that slot

                //solution inclusion part
                if (slot[j] == false) {
                    result.add(list.get(i));
                    slot[j] = true;
                    maxProfit += list.get(i).profit;
                    break;
                }
            }

        }

        System.out.println(result + " " + "total profit " + maxProfit);

    }

    public static void main(String[] args) {
        ArrayList<Jobs> list = new ArrayList<>();
        list.add(new Jobs(2, 50));
        list.add(new Jobs(2, 60));
        list.add(new Jobs(3, 20));
        list.add(new Jobs(3, 30));
        ArrayList<Jobs> list1 = new ArrayList<>();
        list1.add(new Jobs(2, 100));
        list1.add(new Jobs(1, 50));
        list1.add(new Jobs(2, 10));
        list1.add(new Jobs(1, 20));
        list1.add(new Jobs(3, 30));
        ArrayList<Jobs> list2 = new ArrayList<>();
        list2.add(new Jobs(4, 70));
        list2.add(new Jobs(1, 80));
        list2.add(new Jobs(1, 30));
        list2.add(new Jobs(1, 100));
        jobSchedulingImpl(list1);
    }
}
