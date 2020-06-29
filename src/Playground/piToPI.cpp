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
void piToPI(string &s,int i){
    if(i==s.length()-1){
        return;
    }
    if(s.substr(i,2)=="pi"){
        string temp=s;
        s=s.substr(0,i)+"3.14"+temp.substr(i+2);
    }
    piToPI(s,i+1);


 //   cout<<s<<endl;
}



void solve(){
    string x="iabv";
    
    piToPI(x,0);
    cout<<x<<endl;
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
