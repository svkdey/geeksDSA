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



void getNumber(string s,int n,int i,int &sum){
    if(n==s.length()) return;
    
    getNumber(s,n+1,i-1,sum);

      
    sum+=1*pow(10,i)*(s[n]-'0');
    
    return ;

}

void printNumber(int number){
    int sum=0;
    
    getNumber("1234",0,3,sum);
     cout<<sum;
    

}



void solve(){
    printNumber(2048);
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
