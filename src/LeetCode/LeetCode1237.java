package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1237 {
	 public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
		  List<List<Integer>> ans=new ArrayList<List<Integer>>();
		  
		  for(int i=1;i<=z;i++) {
			  int sol=getSol(i,customfunction,z);
			  if(sol!=-1) {
				  List<Integer> ll=new ArrayList<Integer>();
				  ll.add(i);
				  ll.add(sol);
                 ans.add(ll);
              
			  }
		  }
		  return ans;
	    }
   
    public int getSol(int i,CustomFunction customfunction, int z) {
		  int start=1,end=z;
		  int ans=-1;
		  while(end>=start) {
			  int mid=start+(end-start)/2;
			 if(customfunction.f(i,mid)==z) {
				  ans=mid;
				  break;
			  }else if(customfunction.f(i,mid)>z) {
				 end=mid-1;
				  
			  }else {
				  start=mid+1;
			  }
		  }
		  return ans;
		  
	  }
}
