package Algorithms.GreedyBasic;

import java.util.Arrays;
import java.util.Collections;

/*
1.greedy algos some times fails to give optimal solution
genaral pattern:

--->getOptimalSolution(item arr[],int n){
    selectionProcess();
    result=0;
    while(all iteams are not gone through){
        i=selectItem();
        if(feasible){
            result.add(i)
        }
    }
}

 */
public class MinimumCoinToTargetRupees {

    //complexity : o(n + nlog n)
    public static int minimumCoinToTargetRupeesImpl(Integer arr[],int size,int target){
        //Sort
        int res=0;
        Arrays.sort(arr, Collections.reverseOrder());

        for(int i=0;i<size;i++){
            if(target>0){
                int numberOfCoin=(int)Math.floor(target/arr[i]);
                System.out.println(numberOfCoin+" coins of "+arr[i]);
                res+=numberOfCoin;
                target=target-numberOfCoin*arr[i];
            }
            if(target==0){
                break;
            }
        }


        return res;
    }

    public static void main(String[] args) {
        Integer arr[]={5,10,2,1};
        System.out.println(minimumCoinToTargetRupeesImpl(arr,arr.length,25));
    }
}
