package Algorithms;


import java.util.*;

//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
public class AliceAndGame {
    //o(nln n)
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

        ArrayList<Integer> pq = new ArrayList<>();

        for (int i = 0; i < scores.length; i++) {
            if(!pq.contains(scores[i])) {
                pq.add(scores[i]);
            }
        }


        int result[] = new int[alice.length];
        int j = 0;

        for (int i : alice) {
            if (!pq.contains(i)) {
                pq.add(i);
            }
            Collections.sort(pq);

            int idx = Collections.binarySearch(pq, i);

            result[j]=(pq.size() - idx);j++;
            pq.remove(idx);

        }

        return result;

    }
    //o(n)
    static int[] climbingLeaderboardImproved(int[] scores, int[] alice) {

//       find the position where it should be added
        ArrayList<Integer> ranks=new ArrayList<>();
        ranks.add(scores[0]);
        for(int i=1;i<scores.length;i++){
            if(scores[i]!=scores[i-1]){
                ranks.add(scores[i]);
            }
        }
        ArrayList<Integer> result=new ArrayList<>();
    //    System.out.println(ranks);
        for(int i=0;i<alice.length;i++){
            int item=alice[i];
            int r=ranks.size()+1;
            for(int j=ranks.size()-1;j>=0;j--){
                if(r>=1&&item>=ranks.get(j)){
                    r--;
                }else{
                    break;
                }
            }
            result.add(r);
        }

//        int [] res={};
        int[] array = result.stream().mapToInt(i->i).toArray();
        return array;
    }

    public static void main(String[] args) {
        int scores[] = {100, 100, 50, 40, 40 ,20, 10};
        int alice[] = {5, 25, 50, 120};
        climbingLeaderboardImproved(scores, alice);
        System.out.println((int)'a');
    }
}
