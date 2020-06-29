#include <bits/stdc++.h>
#include <iostream>
#include <cstdlib>
#include <string>
#include <cmath>
#include <vector>
#include <sstream>
#include <numeric>
#include <ctime>

using namespace std;
//if {2,1,1,}---> {1,2,1}--->{1,1,2} all considered as same.

//this is same as coin change problem,
int step(int arr[],int n,int target){
    if(target<0) return 0;
    if(target==0) return 1;
    if(target>0&&n<0) return 0;
    else return step(arr,n,target-arr[n-1])+step(arr,n-1,target);

}
//if {2,1,1,}---> {1,2,1}--->{1,1,2} all considered as differnt.
int stepMultiple(int arr[],int n,int target){
    if(target<0) return 0;
    if(target==0) return 1;
    int ans=0;
    for(int i=0;i<n;i++ ){
    
        ans+=stepMultiple(arr,n,target-arr[i]);
    }
    return ans;

}
int stepMultiple(int target){
    if(target<0) return 0;
    if(target==0) return 1;
  
   
    return stepMultiple(target-1)+stepMultiple(target-2)+stepMultiple(target-3);

}




void solve(){
    int arr[]={1,2,3};
    cout<<stepMultiple(arr,3,5)<<endl;
    cout<<stepMultiple(5)<<endl;
}

int main() {
#ifndef ONLINE_JUDGE
    freopen("Input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    freopen("Error.txt", "w", stderr);
#endif

    solve();
    return 0;
}
