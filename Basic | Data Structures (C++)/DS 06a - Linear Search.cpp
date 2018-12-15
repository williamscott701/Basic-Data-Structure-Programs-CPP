#include<iostream> //required header file   Linear Search
using namespace std;
void main() //the main function
{
 int n,i,j,p,k=0,t=0; //initialising the required variables
 cout<<"Enter the size of array\n";
 cin>>n; //getting the size of he array
 int a[50];
 cout<<"Enter The data\n";
 for(i=0;i<n;i++) //getting the elements into the array using a for loop
  cin>>a[i];
 cout<<"Enter The data to search its position\n";
 cin>>p; //asking for the data to search its position
 for(j=0;j<n;j++) //selecting an element in the order and operating as follows
 {
  if(a[j]==p) //checking the condition
  {
   cout<<"The Data is at: "<<j+1<<"\n"; //if the data matches, diaplaying the position
   k=1; //doing this just to make sure that the data is present
   t=t+1; //counting the number of times the data repeated
  }
 }
 if(t==0) 
  cout<<"";
 else //displaying the number of times repeated
  cout<<"The Entered data is repeated "<<t<<" times\n";
 if(k==0) //if data not found k remains 0
  cout<<"Data Not Found\n"; //displaying that the data is not found
}





