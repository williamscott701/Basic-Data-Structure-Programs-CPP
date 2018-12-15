Problem : Is it BST?

Given the postorder and inorder footprints of a binary tree.

a) Build the unique binary tree from these traversal footprints and print out the preorder footprint.

b) Verify whether the tree you have obtained is a binary search tree. Program should output all the nodes at which the BST property is violated. 
Algorithm should visit each node exactly once and should use minimum extra space.

Example:
Input :
> Please Enter Postorder :
1 2 10 7 8 11 9 5
> Please Enter Inorder : 1 2 5 7 10 9 8 11 Output :
Preorder :
5 2 1 9 7 10 11 8

Output:
Not a binary search tree Violated at 2, 9