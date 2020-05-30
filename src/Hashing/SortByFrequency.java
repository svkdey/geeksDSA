package Hashing;

import java.util.*;
import java.util.Map.Entry;

import Data.ArrayData;

public class SortByFrequency {
    static <K, V extends Comparable<? super V>> List<Entry<K, V>> entriesSortedByValuesByDesending(Map<K, V> map) {

        List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K, V>>(map.entrySet());

        Collections.sort(sortedEntries, new Comparator<Entry<K, V>>() {
            @Override
            public int compare(Entry<K, V> e1, Entry<K, V> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        return sortedEntries;
    }

    static <K, V extends Comparable<? super V>> List<Entry<K, V>> entriesSortedByValuesByAscending(Map<K, V> map) {

        List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K, V>>(map.entrySet());

        Collections.sort(sortedEntries, new Comparator<Entry<K, V>>() {
            @Override
            public int compare(Entry<K, V> e1, Entry<K, V> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        });

        return sortedEntries;
    }

    static <K, V extends Comparable<? super V>> List<Entry<K, V>> entriesSortedByValuesByDesendingOrderMinComesFirst(Map<K, V> map) {

        List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K, V>>(map.entrySet());

        Collections.sort(sortedEntries, new Comparator<Entry<K, V>>() {
            @Override
            public int compare(Entry<K, V> e1, Entry<K, V> e2) {
                if (e2.getValue() != e1.getValue()) {
                    return e2.getValue().compareTo(e1.getValue());
                } else {
                    return ((Integer) e1.getKey()).compareTo((Integer) e2.getKey());
                }
            }
        });

        return sortedEntries;
    }

    static void sortByFreq(int arr[], int n) {
        // add your code here
        TreeMap<Integer, Integer> mp = new TreeMap<Integer, Integer>();
        for (int i : arr) {
            if(mp.containsKey(i)){
                mp.put(i,mp.get(i)+1);
            }else{
                mp.put(i,1);
            }
        }
        System.out.println(mp);
        ArrayList<Map.Entry<Integer,Integer>> list=new ArrayList<Map.Entry<Integer,Integer>>();
        for(Map.Entry<Integer,Integer> l:mp.entrySet()){
            list.add(l);
        }
        System.out.println(list);
        Comparator<Map.Entry<Integer,Integer>> c=(o1, o2) -> o2.getValue()-o1.getValue();
        Collections.sort(list,c);
        System.out.println(list);
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int arr[]={5, 5, 4, 6, 4};
        sortByFreq(arr,arr.length);
    }

}
