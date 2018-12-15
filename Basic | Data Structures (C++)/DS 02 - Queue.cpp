#include<iostream>
using namespace std;
void insert();
void del();
void display();
int rear=-1,front=-1,queue[3];
int main()
{
 int schoice, data, choice;
 do
  {
   cout<<"Enter Your Choice:\n1.Insert\n2.Delete\n3.Display\n";
   cin>>schoice;
   switch(schoice)
   {
    case 1: insert();
            break;
    case 2: del();
            break;
    case 3: display();
            break;
    default: cout<<"Invalid Choice\n";
             break;

   }
   cout<<"\nPress Anykey to continue And 0 To Abort\n";
   cin>>choice;
  }while(choice!=0);
 return 0;
}

void insert()
{
 int data;
 if(rear==2)
 {
  cout<<"\nQueue overflow\n";
  return;
 }
 if(front==-1)
  front=0;
 cout<<"\nEnter The data to be inserted:\n";
 cin>>data;
rear++;
 queue[rear]=data;
}

void del()
{
 int j;
 if(front==-1)
  cout<<"\nQueue is Empty\n";
 else if(rear==front)
 {
  cout<<"deleted element is: "<<queue[front]<<"\n";
 }
 else if(rear+1==front)
 {
  cout<<"Nothing to delete, Queue resetted\n";
  rear=front=-1;
 }
 else
  cout<<"deleted element is: "<<queue[front]<<"\n";
 front++;
}

void display()
{
 int i;
 if((front==-1)&&(rear==-1))
 {
  cout<<"\nQueue is empty\n";
 }
 else
  {
   cout<<"\nData stored in queue are\nThe data displayed are from the top to bottom\n";
   for(i=front;i<=rear;i++)
   {
    cout<<queue[i]<<"\n";
   }
  }
}
