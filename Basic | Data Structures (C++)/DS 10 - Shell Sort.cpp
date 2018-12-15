//Shell Sort

#include<iostream>
using namespace std;
void read(int a[10],int n) 
{ 
	cout << "reading\n"; 
	for(int i=0;i < n;i++) 
		cin >> a[i]; 
} 
void display(int a[10],int n) 
{ 
	for(int i=0;i < n;i++) 
		cout << a[i] <<"  "; 
} 
void shellsort(int a[10],int n) 
{ 
	int gap=n/2; 
	do 
	{ 
		int swap; 
		do 
		{ 
			swap=0; 
			for(int i=0;i < n-gap;i++) 
				if(a[i] > a[i+gap]) 
				{ 
					int t=a[i]; 
					a[i]=a[i+gap]; 
					a[i+gap]=t; 
					swap=1; 
				} 
		} 
		while(swap);
	} 
	while(gap=gap/2); 
} 
void main() 
{ 
	int a[10]; 
	int n; 
	cout<<"UR12CS135 - Shell Sort\n\nEnter : "; 
	cin>>n; 
	read(a,n); 
	cout<<"Before sorting\n"; 
	display(a,n); 
	shellsort(a,n); 
	cout<<"\n\nAfter sorting\n"; 
	display(a,n);  
} 


