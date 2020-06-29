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
int bikingWays(int n){
    if(n<=0) return 0;
    if(n==1) return 1;
    //one goes alone ..so left ppl will go f(n-1 ) ways.
    //if couple goes  one can choose other one guy in N-1^C1 ways*f(n-2);
    else return bikingWays(n-1)+((n-1)*bikingWays(n-2));
}



void solve(){
    cout<<bikingWays(3)<<endl;
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
