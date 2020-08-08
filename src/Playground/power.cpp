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
//o(n)
int power(int x,int n){
	if(n==0) return 1;
	else return x*power(x,n-1);
}
//log(n)
int quick_pow(int x,int n){
	if(n==0) return 1;
	int smallerAns=quick_pow(x,n/2);
	smallerAns*=smallerAns;

	if(n%2==1){
		smallerAns*=x;
	}
	
	return smallerAns;

	
}
void solve(){
int t,x,n;
	cin>>t;
	while(t-- >0){
		cin>>x>>n;
		cout<<quick_pow(x,n)<<endl;
	}	
	
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
