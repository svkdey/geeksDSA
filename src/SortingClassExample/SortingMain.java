package SortingClassExample;

import java.util.ArrayList;

import java.util.Comparator;

import java.util.stream.Collectors;

public class SortingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<State> list = new ArrayList<State>();
		ArrayList<String> dist1 = new ArrayList<>();
		ArrayList<String> dist2 = new ArrayList<>();
		dist1.add("Kolkata");
		dist1.add("Durgapur");
		dist2.add("Pune");
		dist2.add("Mumbai");
		State s1 = new State("WestBengal", dist1);
		State s2 = new State("Maharastra", dist2);

		list.add(s1);
		list.add(s2);
		Comparator<State> compareByStateName = Comparator.comparing((State s) -> s.name);
		Comparator<String> compareByDistName = Comparator.comparing((String s) -> s);
		ArrayList<State> sortedList = (ArrayList<State>) list.stream().sorted(compareByStateName)
				.collect(Collectors.toList());
		for (State s : list) {
			ArrayList<String> distList = (ArrayList<String>) s.dist.stream().sorted(compareByDistName)
					.collect(Collectors.toList());
			s.dist = distList;
		}
		System.out.println(sortedList);

	}

}
