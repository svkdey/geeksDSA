package Algorithms.GreedyBasic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class Pair {
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
public class ActivelySelection {
/*
How does Greedy Choice work for Activities sorted according to finish time?
Let the given set of activities be S = {1, 2, 3, ..n} and activities be sorted by finish time.
The greedy choice is to always pick activity 1. How come the activity 1 always provides one of the optimal solutions.
We can prove it by showing that if there is another solution B with the first activity other than 1, then there is also
a solution A of the same size with activity 1 as the first activity. Let the first activity selected by B be k,
then there always exist A = {B – {k}} U {1}.(Note that the activities in B
are independent and k has smallest finishing time among all. Since k is not 1, finish(k) >= finish(1)).

 */
//o(n + nln n)
    private static void activelySelectionImpl(ArrayList<Pair> list) {
        ArrayList<Pair> result=new ArrayList<>();

        Comparator<Pair> c=(Pair o1,Pair o2) -> o1.end-o2.end;
        Collections.sort(list,c);

        result.add(list.get(0));
        int resultIdx=0;
        for(int i=1;i<list.size();i++){
            Pair lastPairInResult=result.get(resultIdx);
            Pair currentPair=list.get(i);

            if(lastPairInResult.end>currentPair.start){
                //don't include anything
            }else{
                result.add(currentPair);
                resultIdx++;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        ArrayList<Pair> list = new ArrayList<>();
        list.add(new Pair(1, 2));
        list.add(new Pair(3, 4));
        list.add(new Pair(2, 6));
        list.add(new Pair(5, 7));
        list.add(new Pair(8, 9));
        list.add(new Pair(5, 9));
        activelySelectionImpl(list);


    }



}
