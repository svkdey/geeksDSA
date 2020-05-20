package Algorithms.GreedyBasic;

import javax.swing.text.html.parser.Entity;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
//class Pair {
//    int weight;
//    int end;
//
//    public Pair(int start, int end) {
//        this.start = start;
//        this.end = end;
//    }
//
//    @Override
//    public String toString() {
//        return "Pair{" +
//                "start=" + start +
//                ", end=" + end +
//                '}';
//    }
//}
public class FractionalKnapsacProblem {
    public static void fractionalKnapsacProblemImpl(int weight[], int price[], int targetWeight) {
        TreeMap<Float,Integer> tm=new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<weight.length;i++){
            float rsPerKg=((float)price[i]/weight[i]);
            tm.put(rsPerKg,weight[i]);
        }
        int result=0;
        for(Map.Entry<Float,Integer> val:tm.entrySet()){
            if(targetWeight>0){
                if(targetWeight>val.getValue()){
                    System.out.println(val.getValue()+" kgs of rs "+val.getKey()+" rs/kg");
                    targetWeight-=val.getValue();
                    result+=val.getValue()*val.getKey();
                }else{
                    int reamaingKGs=targetWeight;
                    System.out.println(reamaingKGs+" kgs of rs "+val.getKey()+" rs/kg");

                    targetWeight-=targetWeight;
                    result+=reamaingKGs*val.getKey();
                }

            }
            if(targetWeight==0){
                break;
            }
        }
        System.out.println(result);

    }

    public static void main(String[] args) {
        int weight[]={50,20,30};
        int values[]={600,500,400};
        fractionalKnapsacProblemImpl(weight,values,70);
    }
}
