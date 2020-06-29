package Algorithms.GreedyBasic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//spoj baised

public class BiasStandings {
	public static void solve(HashMap<String, Integer> hm) {
		System.out.println(hm);
		ArrayList<Map.Entry<String, Integer>> list=new ArrayList<Map.Entry<String,Integer>>(hm.entrySet());
		Comparator<Map.Entry<String, Integer>> rule=(a,b)->{
			return a.getValue()-b.getValue();
		};
		Collections.sort(list,rule);
		System.out.println(list);
		int badness=0;
		for(int i=0;i<list.size();i++) {
			badness+=Math.abs(list.get(i).getValue()-i);
		}
		System.out.println(badness);
	}
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("team1",0);
		hm.put("team2",0);
		hm.put("team3",0);
//		hm.put("team4",0);
//		hm.put("team5",4);
//		hm.put("team6",6);
//		hm.put("team7",6);
		
		
		solve(hm);
		
	}
}
