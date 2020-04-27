package Matrix;

import java.util.ArrayList;

import Data.MatrixData;

public class BooleanMatrix {
	static void booleanMatrix(int r, int c, int mat[][])
    {
        //Your code here
		MatrixProblems.matrixPrint(mat);
		 int row[] = new int[r];
		 int col[] = new int[c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(mat[i][j]==1) {
					row[i]=1;
					col[j]=1;
				}
			}
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(row[i]==1||col[j]==1) {
					mat[i][j]=1;
					System.out.print(mat[i][j]+" ");
				}else {
					System.out.print(mat[i][j]+" ");
				}
			}
			System.out.println();
		}
//		
//		MatrixProblems.matrixPrint(mat);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		booleanMatrix(MatrixData.booleanMat.length, MatrixData.booleanMat[0].length,MatrixData.booleanMat);
	}

}
