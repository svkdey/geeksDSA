package stringDSA;

import java.util.Arrays;

public class ExcelColumn {
    public static String ExcelColumnImpl(int n) {
        int arr[] = new int[1000];
        int i = 0;
        while (n != 0) {
            arr[i] = n % 26;
            n = n / 26;
            i++;
        }
//		System.out.println(Arrays.toString(arr));
        // Step 2: Getting rid of 0, as 0 is
        // not part of number system
        for (int j = 0; j < i - 1; j++) {
            if (arr[j] <= 0) {
                arr[j] += 26;
                //substacting 1 from last next number
                arr[j + 1] = arr[j + 1] - 1;
            }
        }
        String s = "";
        for (int j = i; j >= 0; j--) {
            if (arr[j] > 0) {
                s += (char) ('A' + (arr[j] - 1));
            }
        }
        return s;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(ExcelColumnImpl(1));
//		System.out.println(ExcelColumnImpl(26));
        System.out.println(ExcelColumnImpl(27));
//		System.out.println(ExcelColumnImpl(51));
//		System.out.println(ExcelColumnImpl(52));
//		System.out.println(ExcelColumnImpl(702));
//		System.out.println(ExcelColumnImpl(705));
        System.out.println(ExcelColumnImpl(9705774));
//
//		System.out.println((char)98);
    }

}
