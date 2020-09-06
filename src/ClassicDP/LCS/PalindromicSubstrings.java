package ClassicDP.LCS;

public class PalindromicSubstrings {
	 public int countSubstrings(String s) {
	        int n = s.length();
			int dp[][] = new int[n][n];
	        int totalPallindromes=0;
	        
			for (int i = 0; i < n; i++) {
				dp[i][i] = 1;totalPallindromes++;
			}
			
			
			for (int i = 0; i < n - 1; i++) {
				if (s.charAt(i) == s.charAt(i + 1)) {
					dp[i][i + 1] = 1;
	                totalPallindromes++;
				}
			}
			
			  
	        for (int subLen = 2; subLen < n; subLen++) {
	            
	            for (int i = 0; i < n - subLen; i++) {
	                
	                int j = i + subLen;
	                
	                if (dp[i + 1][j - 1]==1 && s.charAt(i) == s.charAt(j)) {
	                    dp[i][j] = 1;
	                    totalPallindromes++;
	                }
	            }
	        }        
			// for (int i = 0; i < n; i++) {
			// 	System.out.println(Arrays.toString(dp[i]));
			// }
			
			return totalPallindromes;
	    }
}
