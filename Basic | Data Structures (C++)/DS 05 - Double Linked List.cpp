#include<iostream>
using namespace std;

int data;

struct node
{
	int info;
	struct node *next;
	struct node *prev;
}*list,*head;

//adding an element to the front of the list
void insertbeg()
{
	node *ptr = new node;
	cout<<"\nEnter your data : ";
	cin>>ptr->info;
	list=head;
	if(list==NULL)
	{
		head=ptr;
		ptr->next=NULL;
		ptr->prev=NULL;
	}
	else
	{
		ptr->next=list;
		ptr->prev=NULL;
		list->prev=ptr;
		head=ptr;
	}
}

//Insertion new node at the end
void insertend()
{
	node *ptr = new node;
	cout<<"\nEnter your data to be inserted at end : ";
	cin>>ptr->info;
	list=head;
	if(list==NULL)
	{
		head=ptr;
		ptr->next = NULL;
		ptr->prev =NULL;
	}
	else
	{
		while(list->next!= NULL)
		{
			list =list->next;
		}
		list->next=ptr;
		ptr->prev=list;
		ptr->next=NULL;
	}
}

//Deletion of the first node
void deletebeg()
{
	list=head;
	list->next->prev=NULL;
	head=list->next;
}

//Deletion of middle node
void deletemid()
{
	int delmid;
	int i;
	cout<<"\nenter the position of number to be deleted\n";
	cin>>delmid;
	node *temp,*rear;
	temp=list;rear=list;
	for(i=0;i<delmid-2;i++)
	{
		temp=temp->next;
		rear=temp->next;

		if (temp==NULL)
			return;
	}
	temp->next=rear->next;
	rear->next=NULL;
	delete rear;
}

//Deletion of the last node
void deleteend()
{
	list=head;
	while(list->next->next!=NULL)
	{
		list=list->next;
	}
	list->next=NULL;
}

void display()
{
	node *ptr = new node;
	list=head;
	if(head==NULL){
		cout<<"\nNothing to Display\n";
	}
	else
	{
		cout<<"\n\nThe contents of list:\n";
		while(list!=NULL)
		{
			cout<<list->info<<"   ";
			if(list->next == NULL)
			{
				ptr=list;
			}
			list=list->next;
		}
	}
}

int main()
{
	int c, ch;
	do
	{
		cout<<"\n\n1.Insertion at front\n2.Insertion at back\n3.Deletion at front\n4.Deletion at back end\n5.Display\n6.Exit\n7.Delete middle element\n";
		cout<<"\nEnter your choice: ";
		cin>>c;
		switch(c)
		{
		case 1:insertbeg();
			break;
		case 2:insertend();
			break;
		case 3:deletebeg();
			break;
		case 4:deleteend();
			break;
		case 5:display();
			break;
		case 6:exit(0);
			break;
		case 7:deletemid();
			break;
		default:
			cout<<"\nEnter valid choice\n";
			break;
		}
		cout<<"\nPress 1 if you want to continue ";
		cin>>ch;
	}
	while(ch==1);
	return 0;
}



