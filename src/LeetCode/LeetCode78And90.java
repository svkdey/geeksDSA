package LeetCode;

import java.util.*;

public class LeetCode78And90 {
	public static List<List<Integer>> subsetsWithDup(int[] array) {
        HashSet<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>();
        Arrays.sort(array); //with out short will give wrong value
        backTrack(array,0,set,new ArrayList<Integer>());
        return new ArrayList<List<Integer>>(set);
    }
    public static void backTrack(int[] array,int i, HashSet<ArrayList<Integer>> set, ArrayList<Integer> list) {
        if (i == array.length) {
            set.add(new ArrayList<>(list));
            return;
        }



        // use array[i]
        list.add(array[i]);
        backTrack(array, i + 1, set, list);
        list.remove(list.size() - 1);
        // don't use array[i]
        backTrack(array, i + 1, set, list);


    }

    public static void main(String[] args) {
        int arr[]={4,4,4,1,4};
        System.out.println(subsetsWithDup(arr).size());
    }
}
