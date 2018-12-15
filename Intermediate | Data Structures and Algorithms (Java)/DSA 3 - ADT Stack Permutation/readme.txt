Problem Statement:

PART I
Implement the queue and stack ADT using an array or a linked list. You may choose to use a singly, doubly-linked list or a circular linked list. The interfaces are given at the end. All the operations should be carried out in O(1) time. You may assume that the total size of the stack/queue never exceeds 1024. You are not allowed to use the inbuilt Stack/Queue classes of Java.

PART II
We have two queues, the input queue Q1 and the output queue Q2, and one stack S. We are only allowed to dequeue from Q1 and we are only allowed to enqueue into the output queue Q2. We are allowed to both push into and pop from the stack. Consider that we have the numbers 1 2 3 4 5 6 enqueued in Q1. Suppose we perform the following sequence of operations. 

enqueue(Q2, dequeue(Q1)) 
push(S, dequeue(Q1)) 
enqueue(Q2, dequeue (Q1)) 
push(S, dequeue(Q1)) 
enqueue(Q2, pop(S)) 
enqueue(Q2, pop(S)) 
enqueue(Q2, dequeue(Q1)) 
enqueue(Q2, dequeue(Q1))

then the output queue contains 1 3 4 2 5 6. This is an example of what we call a stack permutation i.e. a stack permutation is a ordering of numbers from 1 to n that can be obtained from the initial ordering 1 2 ··· n by a sequence of stack operations as described above. To clarify this, note that 1 5 3 4 2 6 is not a stack permutation. 

Intuitively, this is because to enqueue 5 into Q2 after 1 we would have to push 2 3 4 into the stack which would then be output in the order 4 3 2, not in the order 3 4 2. 

You will be given a permutation of n numbers and asked to check if it is a stack permutation or not.

for number n and a permutation, if it is a stack permutation program will have to return the sequence of operations that formed that permutation. If it is not a permutation, program will have to say it is not a permutation, and will have to give the reason why. Program should explain clearly where the sequence of operations fail to form the given permutation.