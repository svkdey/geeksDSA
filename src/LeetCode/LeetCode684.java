package LeetCode;

public class LeetCode684 {
	static class DisJointSet{
		int arr[]=null;

		public DisJointSet(int size) {
			super();
			this.arr = new int[size+1];
			for(int i=0;i<=size;i++) {
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
	 public int[] findRedundantConnection(int[][] edges) {
	        DisJointSet dsa=new DisJointSet(edges.length);
	        
	        for(int edge[]:edges) {
	        	if(dsa.isconnected(edge[0], edge[1])) {
	        		return edge;
	        	}else {
	        		dsa.Union(edge[0], edge[1]);
	        	}
	        }
	        return new int[0];
	    }
}
