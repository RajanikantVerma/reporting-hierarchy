# reporting-hierarchy
A Java based program to analyze an organizational structure and identify potential improvements.

## Key Pointers
### A csv file based input 

  find out managers who earn less than they should, and by how much.
  
  find out managers earn more than they should, and by how much.
  
  find out employees have a reporting line which is too long, and by how much.


##### Solution:
Output can be found by running Main method of file ReportingHierarchy with provided below **Input**

**Input** :  /reporting-hierarchy/src/main/resources/reporting.csv

**Output**: consideration if CEO is manager of employee then reporting Line is zero.

Brett Hardleaf have reporting Line : 2

Joe Doe is CEO

Martin Chekov have reporting Line : 0

Alice Hasacat have reporting Line : 1

Bob Ronstad have reporting Line : 0


Joe Doe have salary 60000, earning at least 20% more than the average salary of its direct subordinates, but no more than 50% more than that average.

Martin Chekov have salary 45000, earning less than he/she should by 15000

Alice Hasacat have salary 50000, earning at least 20% more than the average salary of its direct subordinates, but no more than 50% more than that average.








