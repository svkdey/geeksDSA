1.**diff utility like** GIT perforece
2.**update s1 to s2**
3.**shortest common supersequence** 
idea is find LCS then insert the missing item of s1 
and insert the missing item of s2

//length can be calculated as lcs.length+(s1.len-lcs.len)+(s2.len-lcs.len);

4.**longest palindromic subsequence** 
_Algorithm:_
s1
s2=reverse(s1);


5.**longest repeating subsequence**

6.**Optimized LCS**

7.**Print LCS**

**LIS**
8.minimum delete to make array sorted 
 solution :arr.length -lis.length

**9.Max sum of increasing subseqences**
solution: sum(tail)

**10. Maximum length of Bitonic subsequence** 

algo:
1st compute left to right LIS(lis)
2nd compute right to left LIS(lds)
-Max(lis[i]-lds[i]);

**11.Building bridges** 
sort(arr on basis of 1st value(if a.1st value=b.2nd value) the sort on s2nd value)
FindListOnBasedOn 2nd value
thats the ans
We can't use greedy!

**12.Longest chain pairs**
sort based on 1st value
LIS based on arr[i].1st-arr[j].second

//activity selection problem ie greedy

13.
  

