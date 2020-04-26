package Playground;

public class DigitOfFactorial {
	public static int digitsInFactorial(int N) {
		double digits = 0;
		for (int i = 1; i <= N; i++) {
			digits += Math.log10((double)i);
		}
	         return (int)Math.floor(digits)+1;
	}
	static void boundaryTraversal(int n1, int m1, int a[][])
    {
        //Your code here
        if(n1==1){
            for(int i=0;i<m1;i++){
            	 System.out.println("called n1");
                 System.out.print(a[0][i]+" ");
            }
        }
        else if(m1==1){
           for(int i=0;i<n1;i++){
        	   System.out.println("called m1");
                 System.out.print(a[i][0]+" ");
            } 
        }
        else{
            int start=0,left=0,right=m1-1,end=n1-1;
       
            for(int i=0;i<=right;i++){
                System.out.print(a[start][i]+" ");
            }
            start++;
            
            for(int i=start;i<=end;i++){
                System.out.print(a[i][right]+" ");
            }
            right--;
            
            for(int i=right;i>=left;i--){
                System.out.print(a[end][i]+" ");
            }
            end--;
            for(int i=end;i>=start;i--){
                System.out.print(a[i][left]+" ");
            }
            left++;
            
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println("-----------------------");
//		System.out.println(digitsInFactorial(10));
		int arr[][]= {{1},{2},{3},{4}};
		boundaryTraversal(4,1, arr);
	}

}
