#include<iostream>		//Quick Sort

using namespace std;

int partition(int a[30], int l, int r)
{
	int temp, p, i, j;
	p = a[l];
	i = l;
	j = r + 1;
	do
	{
		do
		{
			i++;
		} while (a[i]<p);
		do
		{
			j--;
		} while (a[j]>p);
		temp = a[i];              //swap a[i] and a[j]
		a[i] = a[j];
		a[j] = temp;
	} while (i<j);
	temp = a[i];                 //swap a[i] and a[j]
	a[i] = a[j];
	a[j] = temp;
	temp = a[l];                 //swap a[l] and a[j]
	a[l] = a[j];
	a[j] = temp;
	return j;
}

void quicksort(int a[30], int l, int r)
{
	int s;
	if (l<r)
	{
		s = partition(a, l, r);
		quicksort(a, l, s - 1);
		quicksort(a, s + 1, r);
	}
}

int main()
{
	int  a[30], n, k = 0;
	cout << "\n\nEnter the size of the array: ";
	cin >> n;
	cout << "\n\nEnter the elements\n";
	for (int i = 0; i<n; i++)
		cin >> a[i];
	quicksort(a, k, n - 1);
	cout << "\nSorted Array:\n";
	for (int i = 0; i < n; i++)
		cout << a[i] << " ";
	return 0;
}
