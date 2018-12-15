Problem:
Given an array A of integers and an integer k, write a program that returns true if given array can be partitioned into pairs such that sum of every pair is divisible by k, otherwise return false.

I/p format:
nk
a[0] a[1] ... a[n-1] 
O/p format : True/False

Sample case 1:
44
2 222
O/p: True
Explanation : pairs are (2,2), (2,2)

Sample case 2:
46
9 573
O/p: True
Explanation : pairs are (9,3),(5,7)

Sample case 3: 
46
23 5 6 12
O/p: False
No pair possible

P.S
Array contains positive integers only. Program should run in O(n) time complexity
