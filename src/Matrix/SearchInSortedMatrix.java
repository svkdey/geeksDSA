package Matrix;

public class SearchInSortedMatrix {
	public static void search(int arr[][],int x) {
		int i=0,j=arr[0].length-1;
		while(i<arr.length&&j>=0) {
			if(arr[i][j]==x) {
				System.out.println(i+ " "+j);
				return;
			}else if(arr[i][j]>x) {
				j--;
			}else {
				i++;
			}
		}
		System.out.println("not found");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		search(new int[][] {{18 ,21 ,27 ,38 ,55 ,67}},55);
	}

}
