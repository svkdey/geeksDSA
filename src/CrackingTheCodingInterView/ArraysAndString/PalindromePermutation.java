package CrackingTheCodingInterView.ArraysAndString;

public class PalindromePermutation {
	public static void palindromePermutationImpl(String s) {
		String str=String.join("",s.split(" "));
		
		char c[] = str.toCharArray();
		System.out.println(palindromePermutationImplUtil(c, 0, c.length - 1));
	}

	public static boolean palindromePermutationImplUtil(char arr[], int start, int end) {
		if (start == end) {
			return ifPermutation(arr, 0, arr.length-1);
		}
		for (int i = start; i <= end; i++) {
			swap(arr, start, i);
			if (palindromePermutationImplUtil(arr, start + 1, end)) {
				return true;
			}
			swap(arr, start, i);
		}
		return false;
	}

	public static void swap(char arr[], int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static boolean ifPermutation(char arr[], int start, int end) {
		while (end > start) {
			if (arr[start] != arr[end]) {
				return false;
			}
			end--;
			start++;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		palindromePermutationImpl("tactcoa");
	}

}
