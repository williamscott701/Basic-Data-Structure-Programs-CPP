//Insertion Sort
#include<iostream>
using namespace std;
void insertSort(int a[],int c);
int main()
{
        int x,i,n;
        int arr[50];
        cout<<"\tUR12CS135 - Insertion Sort\n\n";
		cout<<"Enter The Number Of Elements: ";
		cin>>n;
        cout<<"\nEnter the elements:\n";
        for(i=0;i<n;i++)   //Getting The Values
			cin>>arr[i];
        insertSort(arr,n);   //Passing elements to a function for sorting
        cout<<"\nSorted Elements:\n";
        for(i=0;i<n;i++)   //displaying the sorted elements   
			cout<<"   "<<arr[i];
		cout<<"\n";
        return 0;
}
void insertSort(int a[],int c)
{
        int i,j,temp;
        for(i=1;i<c;i++) //from the first to the last
        {
                temp=a[i];
                j=i-1;
                while(temp<a[j]&&j>=0)  //shifting if true
                {
                        a[j+1]=a[j];
                        j--;
                }
                a[j+1]=temp;
        }
}

