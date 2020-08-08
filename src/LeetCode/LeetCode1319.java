package LeetCode;

import java.util.Arrays;

import LeetCode.LeetCode684.DisJointSet;

public class LeetCode1319 {
	static class DisJointSet{
		int arr[]=null;

		public DisJointSet(int size) {
			super();
			this.arr = new int[size];
			for(int i=0;i<size;i++) {
				arr[i]=i;
			}
		}
		
		public void Union(int x,int y){
			int x_root=find(x);
			int y_root=find(y);
			if(x_root!=y_root) {
				arr[x_root]=y;
			}
		}
		public int find(int x){
			if(arr[x]==x) {
				return x;
			}else {
				return arr[x]=find(arr[x]);
			}
			
		}
		public boolean isconnected(int x,int y){
			return find(x)==find(y);
		}
		
		
	}
	  public static int makeConnected(int n, int[][] connections) {
		  DisJointSet dsa=new DisJointSet(n);
		  if(n-1>connections.length){
		        return -1;
		    }
	        for(int edge[]:connections) {
	        	
	        		dsa.Union(edge[0], edge[1]);
	        	
	        }
	        System.out.println(Arrays.toString(dsa.arr));
	        int ans=0;
	        for(int i=0;i<n;i++) {
	        	if(dsa.arr[i]==i) {
	        		ans++;
	        	}
	        }
	        System.out.println(ans-1);
	        return ans-1;
	      
	    }
	  public static void main(String[] args) {
		 int n = 4, connections[][] = {{0,1},{0,2},{1,2}};
		 makeConnected(n, connections);
	}
}
