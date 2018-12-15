#include<iostream>
using namespace std;
void push();
void pop();
void display();
int stack[5];
int top=-1;
int main()
{
 int schoice, data, choice;
 do
  {
   cout<<"Enter Your Choice:\n1.Push\n2.Pop\n3.Display\n";
   cin>>schoice;
   switch(schoice)
   {
    case 1: push();
           break;
    case 2: pop();
           break;
    case 3: display();
           break;
    default: cout<<"Invalid Choice\n";
             break;

   }
   cout<<"\nPress 1 to continue\n";
   cin>>choice;
  }while(choice==1);
 return 0;
}

void push()
{
 int data;
 if(top==2)
 {
  cout<<"\nStack overflow\n";
 }
 else
  {
   cout<<"\nEnter The data to be inserted:\n";
   cin>>data;   top++;
   stack[top]=data;
  }
}

void pop()
{
 if(top==-1)
  {
   cout<<"\nStack is Empty\n";
  }
 else
 {
  cout<<"popped out element is: "<<stack[top]<<"\n";
  top--;
 }
}

void display()
{
 int i;
 if(top==-1)
 {
  cout<<"\nStack is empty\n";
 }
 else
  {
   cout<<"\nData stored in stack are\nThe data displayed are from the top to bottom\n";
   for(i=0;i<=top;i++)
   {
    cout<<stack[i]<<"\n";
   }
  }
}