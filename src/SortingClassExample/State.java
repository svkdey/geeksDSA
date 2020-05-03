package SortingClassExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class State {
	String name;
	ArrayList<String> dist;
	public State(String string, ArrayList<String> dist1) {
		// TODO Auto-generated constructor stub
		this.name=string;
		this.dist=dist1;
	}

		@Override
	public String toString() {
		return "State [name=" + name + ", dist=" + dist + "]";
	}

}
