package stringDSA;

public class Isomorphic {
	public static boolean areIsomorphic(String s1, String s2){
		// xxy zza
		if (s1.length() != s2.length())
			return false;
		int hash1[] = new int[256];
		int hash2[] = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			// if visiting for 1st time
			// x->z && z->x mapping occures
			if (hash1[(int) s1.charAt(i)] == 0 && hash2[(int) s2.charAt(i)] == 0) {
				hash1[(int) s1.charAt(i)] = (int) s2.charAt(i);
				hash2[(int) s2.charAt(i)] = (int) s1.charAt(i);
			}

//    	  already visisted

			else {
				// when x comes 2nd time it should map to z and zshould x .if it is not return
				// flase
				if (hash1[(int) s1.charAt(i)] != s2.charAt(i) && hash2[(int) s2.charAt(i)] != s1.charAt(i)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
