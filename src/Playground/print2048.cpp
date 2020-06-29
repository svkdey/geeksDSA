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

unordered_map<int,string> mp;
void makeMapping(){
    mp.insert(make_pair(0,"zero"));
    mp.insert(make_pair(1,"one"));
    mp.insert(make_pair(2,"two"));
    mp.insert(make_pair(3,"three"));
    mp.insert(make_pair(4,"four"));
    mp.insert(make_pair(5,"five"));
    mp.insert(make_pair(6,"six"));
    mp.insert(make_pair(7,"seven"));
    mp.insert(make_pair(8,"eight"));
    mp.insert(make_pair(9,"nine"));
    }
void getNumber(int n){
    if(n==0) return;
    int val=n%10;
    n=n/10;
    getNumber(n);
     cout<<mp[val]<<" ";
    return ;

}

void printNumber(int number){
    makeMapping();
    getNumber(number);
     
    

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
