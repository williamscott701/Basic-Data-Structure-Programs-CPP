#include <iostream>    //Merge Sort
using namespace std;
void merge(int*,int*,int,int,int);
void mergesort(int *a, int*b, int low, int high)
{                   //main Mersort Function
    int mid;
    if(low<high)  //Checking The Condition
    {
        mid=(low+high)/2;    //splitting
        mergesort(a,b,low,mid);  //The Left Half
        mergesort(a,b,mid+1,high); //The Right Half
        merge(a,b,low,mid,high);  //Merging
    }
}
void merge(int *a, int *b, int low, int mid, int high)
{     //Function to merge
    int h,i,j,k;
    h=low;
    i=low;
    j=mid+1;
    while((h<=mid)&&(j<=high))
    {    //checking the condition
        if(a[h]<=a[j])
        {
            b[i]=a[h];
            h++;
        }
        else
        {
            b[i]=a[j];
            j++;
        }
        i++;
    }
    if(h>mid) //if mid is less
    {
        for(k=j; k<=high; k++)
        {
            b[i]=a[k];
            i++;
        }
    }
    else  //if mid is greater
    {
        for(k=h; k<=mid; k++)
        {
            b[i]=a[k];
            i++;
        }
    }
    for(k=low; k<=high; k++)  //copying
		a[k]=b[k];
}
int main()  //main function
{
	cout<<"\tUR12CS135- Merge Sort\n\n";
    int a[100];
    int b[100], num, i;
	cout<<"Enter Total Number Of Elements: ";
	cin>>num;
	for(i=0; i<num; i++)
        cin>>a[i];
    mergesort(a,b,0,num-1); //sending to the main merge function
    for(i=0; i<num; i++)
        cout<<a[i]<<" ";
    cout<<endl;
}

