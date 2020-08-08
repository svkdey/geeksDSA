import java.util.ArrayList;

public class Playground {
	private static void combinaton(int arr[],int n,int start,ArrayList<Integer> list) {
		if(n==2) {
			System.out.println(list);
			return;
	}
		for(int i=start;i<n;i++) {
			list.add(arr[i]);
			combinaton(arr, n,start+1, list);
			//back
			list.remove(list.size()-1);
		}
		
		
		
//---->		combinaton(arr, n-1, list);
		
		

	}
	
	public static void main(String[] args) {
		int arr[]= {1,2,3};
		combinaton(arr,arr.length,0,new ArrayList<>());
	}
}
