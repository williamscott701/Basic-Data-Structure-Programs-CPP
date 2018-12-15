Program to construct a MaxHeap of Students with Name as key lexicographically, with operations such as insert, delete, heapify ad comparator.

Student Class:
FIRST name :String
LAST name : String
CoursesTaken : List of Strings

Operations:
Insert() - register a new student in the system.
Maximum() – returns the student with maximum priority but do NOT remove it from the system.
Extract-Max() – return the student with maximum priority AND remove it from the system.
Delete(string firstname, String lastname) – delete the user with given name from the system.
Show() – displays all users of the system.

Input:
INSERT firstname lastname <list of courses, space separated> MAXIMUM
EXTRACT-MAX
DELETE firstname lastname
SHOW

Trivia:
1. There will NOT be any two students with the same name.
2. Operation string as well as student names or course names are case insensitive
3. Handle all corner cases such as deleting a student name when the student is not present, requesting a max in empty heap etc.
4. Make valid assumptions which are not mentioned in the problem statement and submit it in a separate file along with your assignment.
5. Create proper ReadMe file for the assignment.
6. Assignment should be submitted on backpack and contain all binaries as well as source code in a single zip file.