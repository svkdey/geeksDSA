package Algorithms.BackTrackinBasic;

public class BlackAndWhite {
    public static boolean ifSave(int x,int y,int n,int m){
        if(x>=0&&x<n&&y>=0&&y<m){
            return true;
        }else{
            return false;
        }
    }
    public static void impl(int n,int m){
        int safePos=0;
        int totalPos=n*m-1;
       // System.out.println(totalPos);
        int dr[]={2,2,-2,-2,1,-1,1,-1};
        int dc[]={1,-1,1,-1,2,2,-2,-2};
        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){
                int unsafe=0;
                for(int c=0;c<dr.length;c++){
                    int x=i+dr[c];
                    int y=j+dc[c];
                    if(ifSave(x,y,n,m)){
                        unsafe++;
                    }
                }
                safePos+=totalPos-unsafe;

            }




        }
        System.out.println(safePos);
    }

    public static void main(String[] args) {
        impl(2,2);
        impl(2,3);
        impl(4,5);
    }
}
