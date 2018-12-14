
#include<iostream>
#include<conio.h>

using namespace std;
	
class linkedlist
{
 struct node
	{
	 int data;
	 node *next;
	}*p;
public:
	linkedlist()
	{
	 p=NULL;
	}

	void addback()
	{
	 int num;
	 node *temp,*r;
	 cout<<"Enter Data to add in the end\n";
	 cin>>num;
	 if(p==NULL)
	 {
	  temp=new node;
	  temp->data=num;
	  temp->next=NULL;
	  p=temp;
	 }
	 else
	 {
	  temp=p;
	  while(temp->next!=NULL)
		  temp=temp->next;
	  r=new node;
	  r->data=num;
	  r->next=NULL;
	  temp->next=r;
	 }
	}

	void addfront()
	{
	 int num;
	 cout<<"Enter data to add in the front\n";
	 cin>>num;
	 node *temp;
	 temp=new node;
	 temp->data=num;
	 temp->next=p;
	 p=temp;
	}

	void deletefront()
	{
		cout<<p->data<<" Is Deleted";
		p=p->next;
	}

	void deleteback()
	{
	 if(p==NULL)
		 cout<<"List Empty\n";
	 else
	 {
	  node *temp,*temp1;
	  temp=p;temp1=p;
	   while(temp->next!=NULL)
	   {
	    temp1=temp1->next;
	    temp=temp1->next;
	   }
	  cout<<temp->data<<" Is Deleted\n";
	  temp1->next =NULL;
	  delete temp;
	 }
	}

	void display()
	{
	 node *temp;
	 temp=p;
	 cout<<"\nData:\n";
	 cout<<temp->data<<"  ";
	 do
	 {
	  temp=temp->next;
	  cout<<temp->data<<"  ";
	 }while(temp->next!=NULL);
	}
};

void main()
{
 linkedlist l;
 int choice,option;
 do
 {
  cout<<"\n\nEnter Your Choice\n1.Add front\n2.Add Back\n3.Delete front\n4.Delete back\n5.Display\n";
  cin>>option;
  switch(option)
  {
	  case 1: l.addfront();	
	  break;
	  case 2: l.addback();
	  break;
	  case 3: l.deletefront();
	  break;
	  case 4: l.deleteback();
	  break;
	  case 5: l.display();
	  break;
	  default: 
		  cout<<"Wronge Entry";
		  break;
  }
  cout<<"\nIf You want to continue press 1 \n";
  cin>>choice;
 }while(choice==1);
}
