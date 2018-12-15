//Bubble Sort									
#include<iostream>
#include<conio.h>
using namespace std;
void main()
{
	int a[100],n,i,j,t; //initialising required variables
	cout<<"\t\tBubble Sort\n\nEnter The Number of Elements: ";
	cin>>n;
	cout<<"\nEnter The Elements:\n";
	for(i=0;i<n;i++)
		cin>>a[i];  //getting the required elements
	for(i=0;i<n;i++)
	{                         //selecting the basic elements
		for(j=0;j<n-1;j++)
		{                    //selecting the pair
			if(a[j+1]<a[j])  //comparing the pair
			{
				t=a[j];           
				a[j]=a[j+1];    //swaping if condition satisfies
				a[j+1]=t;
			}
		}
	}
	cout<<"\nThe Sorted Elements Are:\n";
	for(i=0;i<n;i++)    //displaying the elements
		cout<<a[i]<<"\n";
}
