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

//recusive pattern
int TileNumber(int n){
    if(n==0) return 0;
    if(n>0&&n<4) return 1;
    if(n==4) return 2;
    else{
       return  TileNumber(n-1)+TileNumber(n-4);
    }

}



void solve(){
    cout<<TileNumber(7);
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
