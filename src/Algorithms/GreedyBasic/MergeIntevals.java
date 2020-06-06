package Algorithms.GreedyBasic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class MergeIntervals {
    public static class Pair extends Object{
        int start;int end;
        public Pair(int s,int e){
            start=s;end=e;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    //how to check two interval operlaps?

    public static void implMergeInterVal( ArrayList<Pair> list){

        Comparator comparator=Comparator.comparing((Pair p)->p.start);
        Collections.sort(list,comparator);
        //x1,x2.... xn-1 ,xn
        //m1..mn-1,xn  if mn-1 will merge with xn if xn.start >mn-1.end
        //else it will not merge

        System.out.println(list);
        int res=0;
        for(int i=1;i<list.size();i++){
            if(list.get(res).end>list.get(i).start){

                list.get(res).end=Math.max(list.get(res).end,list.get(i).end);
                list.get(res).start=Math.min(list.get(res).start,list.get(i).start);

            }
            else{
                res++;
                list.get(res).end=list.get(i).end;
                list.get(res).start=list.get(i).start;
            }
        }
    for(int i=0;i<=res;i++) {
        System.out.println(list.get(i));
    }
    }

    public static void main(String[] args) {
        ArrayList<Pair> list=new ArrayList<>();
        list.add(new Pair(5,10));
        list.add(new Pair(3,15));
        list.add(new Pair(18,30));
        list.add(new Pair(2,7));

        implMergeInterVal(list);
    }
}
