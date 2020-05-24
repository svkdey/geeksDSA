package Algorithms;

import java.util.*;

public class PickingNumber {
    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(Integer i:a){
            if(hm.containsKey(i)){
                hm.put(i,hm.get(i)+1);
            }else{
                hm.put(i,1);
            }
        }
        int maxCount=0;
        for(Map.Entry<Integer,Integer> l:hm.entrySet()){
            Map.Entry<Integer,Integer> item=l;
            int freq1=hm.containsKey(l.getKey()-1)?hm.get(l.getKey()-1):0;
            int freq2=hm.containsKey(l.getKey()+1)?hm.get(l.getKey()+1):0;
            int tolatFreq1=l.getValue()+freq1;
            int tolatFreq2=l.getValue()+freq2;
            maxCount=Math.max(tolatFreq1,Math.max(maxCount,tolatFreq2));

        }

        return maxCount;
    }

    public static void main(String[] args) {
        ArrayList<Integer> l=new ArrayList<>();
        int arr[]={1,1,2,2,4,4,5,5,5};
        for(Integer i:arr){
            l.add(i);
        }
        System.out.println(pickingNumbers(l));
    }
}
