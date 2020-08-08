package LeetCode;

import java.util.HashMap;

public class LeetCode1357 {
	class Cashier {
		int k=0;
		int n=-1;
		
		int discount=0;
		HashMap<Integer, Integer> priceChart=null;
	    public Cashier(int n, int discount, int[] products, int[] prices) {
	    	this.n = n;
	    	
			this.discount = discount;
			priceChart=new HashMap<Integer, Integer>();
			for(int i=0;i<products.length;i++) {
	        	priceChart.put(products[i], prices[i]);
	        	
	        }
	    }
	    
	    

		public double getBill(int[] product, int[] amount) {
	        k++;
	        double sum=0;
	        for(int i=0;i<product.length;i++) {
	        	sum+=amount[i]*(priceChart.get(product[i]));
	        	
	        }
	        if(k==n) {
	        	sum=(sum-(sum*discount)/100);
	        	k=0;
	        }
	        return sum;
	    }
	}

}
