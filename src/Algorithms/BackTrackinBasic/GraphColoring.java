package Algorithms.BackTrackinBasic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import Data.GraphData;

public class GraphColoring {
	static class ColorVertexPair{
		int vertex;char color;

		public ColorVertexPair(int vertex, char color) {
			super();
			this.vertex = vertex;
			this.color = color;
		}
		public ColorVertexPair() {
			
		}
		@Override
		public String toString() {
			return "ColorVertexPair [vertex=" + vertex + ", color=" + color + "]";
		}
		
	}
	public static boolean ifCanbeColored(ArrayList<ArrayList<Integer>> adjList,char colors[],HashMap<Integer,Character> visited,int vertex,ColorVertexPair cv) {
		HashSet<Character> set=new HashSet<Character>();
		for(int v:adjList.get(vertex)) {
			if(visited.containsKey(v)) {
				set.add(visited.get(v));
			}
		}
		if(colors.length==set.size()) {
			return false;
		}else {
			for(char c:colors) {
				if(!set.contains(c)) {
					cv.vertex=vertex;
					cv.color=c;
					break;
				}
			}
			return true;
		}
	}
	public static boolean GraphColoringImpl(ArrayList<ArrayList<Integer>> adjList,char colors[],HashMap<Integer,Character> visited,ColorVertexPair cv) {
		// TODO Auto-generated constructor stub
		System.out.println(cv.vertex);
		visited.put(cv.vertex, cv.color);
		for(int v:adjList.get(cv.vertex)) {
			if(!visited.containsKey(v)){
				ColorVertexPair tempCvColorVertexPair=new ColorVertexPair();
				if(ifCanbeColored(adjList,colors,visited,v,tempCvColorVertexPair)) {
					GraphColoringImpl(adjList, colors, visited,tempCvColorVertexPair );
					
				}else {
					return  false;
				}
			}
			/*if(visited.get(v)==visited.get(cv.vertex)) {
				return false;
			}*/
			
		}
		return true;
		
	}
	public static void solve(ArrayList<ArrayList<Integer>> adjList,char colors[]) {
		HashMap<Integer,Character> visited=new HashMap<Integer, Character>();
		ColorVertexPair cv=new ColorVertexPair(0, colors[0]);
		boolean res=GraphColoringImpl(adjList, colors, visited, cv);
		
		System.out.println(visited);
		System.out.println(res);
		
		
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adjList =GraphData.getGraph().adjList;
		System.out.println(adjList);
		char[] colors= {'R','G','B'};
		
		solve(adjList, colors);
	}

}
