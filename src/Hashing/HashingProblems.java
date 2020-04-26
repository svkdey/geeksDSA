package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashingProblems {
	public static LinkedHashMap<Integer, Integer> getFrequency(int[] arr,int start,int end) {
//		HashMap<Integer, Integer> m=new HashMap<>();
		LinkedHashMap<Integer, Integer> m = new LinkedHashMap<>();
		for (int i = start; i <end; i++) {
			if (!m.containsKey(arr[i])) {
				m.put(arr[i], 1);
			} else {
				m.put(arr[i], (m.get(arr[i]) + 1));
				
			}
		}
		
		return m;
	}

	public static int noOfdistinctElement(int[] arr,int start,int end) {
		HashMap<Integer, Integer> m = getFrequency(arr,0,arr.length);
//		System.out.println(m.size());
		return m.size();
	}

	public static void frequency(int[] arr) {
		LinkedHashMap<Integer, Integer> m = getFrequency(arr,0,arr.length);
		System.out.println(m);
	}

	public static void intersectionOf2Array(int[] arr1, int arr2[]) {
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			if (!m.containsKey(arr1[i])) {
				m.put(arr1[i], 1);
			}
		}
		for (int i = 0; i < arr2.length; i++) {
			if (m.containsKey(arr2[i])) {
				set.add(arr2[i]);
			}
		}
		System.out.println(set);

	}

	public static void union(int[] arr1, int arr2[]) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			set.add(arr1[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			set.add(arr2[i]);
		}
		System.out.println(set.size());
	}
	 public static String findMaxFrequenelement(int arr[],int n){
	        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	        for(int i=0;i<n;i++){
	            if(hm.containsKey(arr[i])){
	                hm.put(arr[i],hm.get(arr[i])+1);
	            }else{
	                 hm.put(arr[i],1);
	            }
	        }
	        int maxEle=arr[0];
	        int maxFreq=hm.get(arr[0]);
	        for(Entry<Integer,Integer> item:hm.entrySet()) {
	        	if(item.getValue()>maxFreq) {
	        		maxFreq=item.getValue();
	        		maxEle=item.getKey();
	        		
	        	}
	        }
	        return maxEle+" "+maxFreq;
	    }
	  public static void get1stRepeatedElement (int arr[]) {
	        int find=0;
	        LinkedHashMap<Integer, Integer> m = new LinkedHashMap<>();
	        LinkedHashMap<Integer, Integer> idx = new LinkedHashMap<>();
			for (int i = 0; i <arr.length; i++) {
				if (!m.containsKey(arr[i])) {
					m.put(arr[i], 1);
					idx.put(arr[i], i);
				} else {
					m.put(arr[i], (m.get(arr[i]) + 1));
					
				}
			}
			System.out.println(m+" "+idx);
		    for(Entry<Integer,Integer> item:m.entrySet()) {
		        	if(item.getValue()>1) {
		        		System.out.println(idx.get(item.getKey()));
		        		find=1;
		        		break;
		        	}
		       }
		     if(find==0){System.out.println(-1);} 
	    }
	  static void findEqual(int a[],int b[]){
	        int same=1;
	        HashMap<Integer,Integer> hm1=new HashMap<>();
	        for(int i=0;i<a.length;i++){
	            if(hm1.containsKey(a[i])){
	                hm1.put(a[i],hm1.get(a[i])+1);
	            }else{
	                hm1.put(a[i],1);
	            }
	        }
	        HashMap<Integer,Integer> hm2=new HashMap<>();
	        for(int i=0;i<b.length;i++){
	            if(hm2.containsKey(b[i])){
	                hm2.put(b[i],hm2.get(b[i])+1);
	            }else{
	                hm2.put(b[i],1);
	            }
	        }
	        if(hm1.size()==hm2.size()){
	            for(Map.Entry<Integer,Integer> item:hm1.entrySet()){
	                if(item.getValue()!=hm1.get(item.getKey())){
	                    same=0;
	                    break;
	                }
	            }
	            
	        }else{
	            same=0;
	        }
	        System.out.println(same);
	    } 
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		noOfdistinctElement(new int[] { 1, 2, 3, 3, 4, 4, 5 },0,7);
//		frequency(new int[] { 1, 9, 2, 3, 3, 4, 4, 5 });
//		intersectionOf2Array(new int[] { 1, 9, 2, 3, 3, 4, 4, 5 }, new int[] { 1, 9, 4, 4, 5 });
//		union(new int[] {3,3,3 }, new int[] {3,3 });
//		System.out.println(findMaxFrequenelement(new int[] { 2 ,3, 4, 5, 5 }, 5));
//		get1stRepeatedElement(new int[] {1 ,5 ,3 ,4 ,3 ,5 ,6});
		findEqual(new int[] {8, 9, 7 ,5, 3, 1}, new int[] {5 ,4 ,2, 5, 1, 7});
	}
	

}
