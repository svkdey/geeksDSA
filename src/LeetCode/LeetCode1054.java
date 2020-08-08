package LeetCode;

import java.util.*;

public class LeetCode1054 {
	static class Freq {
		int value, freq;

		public Freq(int value, int freq) {
			super();
			this.value = value;
			this.freq = freq;
		}

		@Override
		public String toString() {
			return "Freq [value=" + value + ", freq=" + freq + "]";
		}

	}

	public static int[] rearrangeBarcodes(int[] barcodes) {
		Comparator<Freq> rule = (a, b) -> {
			return b.freq - a.freq;
		};
		PriorityQueue<Freq> pq = new PriorityQueue<Freq>(rule);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int bar : barcodes) {
			map.put(bar, map.getOrDefault(bar, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> x : map.entrySet()) {
			pq.add(new Freq(x.getKey(), x.getValue()));
		}

		int ans[] = new int[barcodes.length];
		int i = 0;
		Freq prev=null;
		while (i != barcodes.length) {
			Freq f=pq.remove();
			ans[i++]=f.value;
			f.freq--;
			if(prev!=null) {
				pq.add(prev);
			}
			if(f.freq>0) {
				prev=f;
			}
			else {
				prev=null;
			}
			
			
		}
		System.out.println(Arrays.toString(ans));
		return ans;

	}

	public static void main(String[] args) {
		int barcodes[] = { 1,1,1,1,2,2,3,3};
		rearrangeBarcodes(barcodes);

	}
}
