#include<iostream> //required header file    Binary Search
using namespace std;
void swap(int *p,int *t) //function to swap two values using pointers
{
	 int temp; //declaring a temporary variable
	 temp=*p;  //exchanging the values
	 *p=*t;
	 *t=temp;
}

int main() //main function
{
	int i,n,j,k,s,e,f; //initialising the required variables
	cout<<"Enter the size of array\n";
	cin>>n; //getting the size of array
	int a[50];
	cout<<"Enter The data\n";
	for(i=0;i<n;i++) //getting the values into the array
		cin>>a[i];
	for(i=0;i<n;i++) //selecting an element and comparing as follows
		{
			for(j=0;j<n;j++) //comparing all the other elements with the selected element
				{
					if (a[i]<a[j]) //checking the condition
						swap(&a[i],&a[j]); //sending the values to the swap function
			    }
		 }
	cout<<"Entered Data in ascending order is:\n";
	for(k=0;k<n;k++) //displaying the data in ascending order
		cout<<a[k]<<"\n";
	cout<<"Enter The data to search\n";
	cin>>f; //getting the value to search its position
	int m,l=0,r=n-1; //initialising the required variables
	while(l<=r) //taking the required condition
	{
		m=(l+r)/2; //taking the mean of l and r as m
		if(f>a[m]) // checking if the requred data is above the a[m] position
			l=m+1; //shifting the l as m+1
		else if(f<a[m]) //checking if the data is below a[m]
			r=m-1; //shifting r to m-1
		else if(f==a[m]) //if both the above conditions do not satisfy it is exactly at a[m]
		{
			cout<<"Its Position is "<<m+1<<"\n";//displaying its position
			break;
		}
		else
			cout<<"The Required data is not found\n"; //displaying not found if not matched to any of the data
	}
}

