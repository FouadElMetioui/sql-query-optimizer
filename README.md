<p align="center">
	<img src="https://user-images.githubusercontent.com/101653735/202849820-dfeaabcf-4dd9-4452-a847-5a767462fd9d.png" >
</p>

# SQL Query Optimizer

This is an implementation of a SQL Query Optimizer application for **Oracle Database** using indexes and plans.

**Tools :** SpringBoot, Angular, Oracle19c, JdbcTemplate.

## Table of contents

[Application Demo](#application-demo)
* [Home Page](#home-page)
* [Optimized Query](#optimized-query)
* [Optimizing a Simple Query](#optimizing-a-simple-query)
* [Multicolumn Index](#multicolumn-index)
* [Bad Query](#bad-query)
* [Creators](#creators)

## Application Demo

### Home Page

The home page of this application contains one button to open the sql textarea.

<p align="center">
	<img width="960" alt="1" src="https://user-images.githubusercontent.com/101653735/213432566-9d1f0222-2cb4-4432-a25b-09571a2770fc.png">
</p>

### Optimized Query

In order to optimize a query you just have to enter the query in the textarea.

<p align="center">
	<img width="960" alt="1" src="https://user-images.githubusercontent.com/101653735/213433073-035c2b59-af3b-4798-afb3-9c51f19709ab.png">
</p>

The query we want to optimize already optimize so an alert message will show and tell you that and also the plan and the result of the query will show.

<p align="center">
	<img width="960" alt="1" src="https://user-images.githubusercontent.com/101653735/213433500-c8e8baba-d6c8-48ee-87b4-b62720e6cff9.png">
</p>

<p align="center">
	<img width="960" alt="1" src="https://user-images.githubusercontent.com/101653735/213433912-5c780d36-74f3-4793-a089-a4c498e0bef9.png">
</p>

### Optimizing a Simple Query 

Now let's enter a query that need optimization:

<p align="center">
	<img width="960" alt="1" src="https://user-images.githubusercontent.com/101653735/213434165-08354a58-f19b-4c8b-b82c-04a7e796d628.png">
</p>

The plan and the result of the query:

<p align="center">
	<img width="960" alt="1" src="https://user-images.githubusercontent.com/101653735/213434846-795e1e05-d6b5-4eb6-87d6-b78d5be3e650.png">
</p>

<p align="center">
	<img width="960" alt="1" src="https://user-images.githubusercontent.com/101653735/213434877-ed8b62dc-d712-4b8b-b5a1-7b5e4445eb7d.png">
</p>

And this is the index we used to optimize the query and also we give the plan after optimization:

<p align="center">
	<img width="960" alt="1" src="https://user-images.githubusercontent.com/101653735/213435538-59bc72e7-c485-4e39-8139-964623506fbf.png">
</p>

### Multicolumn Index

If we have a query used two columns of the table we have to add a multicolumn index like in this example:

<p align="center">
	<img width="960" alt="1" src="https://user-images.githubusercontent.com/101653735/213436031-89bcf465-bf14-4336-9ade-cf9bbd71fcbb.png">
</p>

The index and the plan after optimization:

<p align="center">
	<img width="960" alt="1" src="https://user-images.githubusercontent.com/101653735/213436428-f631d491-ce98-442b-ba24-2a586fc31d89.png">
</p>

### Bad Query

If you enter a bad query an alert will show and tell you that we aren't able to analyse the query:

<p align="center">
	<img width="960" alt="1" src="https://user-images.githubusercontent.com/101653735/213437525-41735d0c-c9f6-4366-86a4-f0bd4da6a459.png">
</p>

## Creators

* <a href="https://github.com/ahmed-bentajhamyani">BENTAJ HAMYANI Ahmed</a>

* <a href="https://github.com/FouadElMetioui">EL METIOUI Fouad</a>

* <a href="https://github.com/Nafia-AKDI">AKDI Nafia</a>

* <a href="https://github.com/ELKRISSIAchraf">ELKRISSI Achraf</a>
