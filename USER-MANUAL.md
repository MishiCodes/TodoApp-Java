# User manual
This is the user manual for the TodoList project.

## 1. Main menu
When the user starts the application, the main menu is displayed:

```
>>> Welcome to TodoList

TODO APPLICATION'S MAIN MENU
----------------------------

You have 3 pending todo(s) and 1 completed todo(s)

>> Pick an option:
>> (1) Show Todo List (by date or project)
>> (2) Add New Todo
>> (3) Edit Todo (update, mark as done, remove)
>> (4) Save and Quit

>> Please enter your choice [1-4]: 
```

On the top of the menu, the application displays the number of pending todo and completed todo:

```
>> You have 3 pending todo(s) and 1 completed todo(s)
```

If an invalid option is selected (5 or 6, for instance), a message is displayed as well as the main menu (after the user pressed Enter):

```
>>> Command not found. Please enter a choice from given options.
```

If the user presses:

(1) a **show menu** is displayed; that menu allows the user to see the todos in the todo list;

(2) user is able to add new todo to the todo list;

(3) user can **edit menu** is displayed; that menu allows the user to edit an existing todo;

(4) the application saves the current list of todos and quits.

## 2. Show menu
If the user pressed (1), the show menu is displayed:

 ```
 DISPLAY MENU FOR ALL TODOS
 --------------------------
 
 >> Pick an option:
 >> (1) Display Todo List sorted by date
 >> (2) Display Todo List sorted by project
 
 >> Please enter your choice [1-2]: 
 ```

If the user presses:

(1) - a list of todos sorted by date is displayed;

```
Total Todos = 3		 (Completed = 0		 Pending = 3 )
DUE-DATE        TITLE                               PROJECT              COMPLETED 
--------        -----                               -------              --------- 
2020-03-29      Go for Laundry                      Home                 No        
2020-03-31      Go for Car Wash                     Car                  No        
2020-04-01      Go to ibrary to return book         Library              No    
```

(2) - a list of todos sorted by project is displayed.

```
Total Todos = 3		 (Completed = 0		 Pending = 3 )
PROJECT              TITLE                               DUE-DATE        COMPLETED 
-------              -----                               --------        --------- 
Car                  Go for Car Wash                     2020-03-31      No        
Home                 Go for Laundry                      2020-03-29      No        
Library              Go to ibrary to return book         2020-04-01      No 
```

After displaying the list of todos and once the user pressed Enter, the application returns to main menu.


## 3. Add new todo
If the user pressed (2), to add a new todo to the todo list, the following sequence of actions is displayed:
* the application requests user to insert a todo title:

```
>>> Todo Title  : 
````

* and to insert a project title:

```
>>> Project Name:
```

* finally, requests user to insert a due date:

```
>>> Due Date (Format: 2020-03-21) : 
```

Once the 3 fields were inserted, a new todo was created and added to the todo list:

```
>>> Todo has been added successfully
```
Example of a todo added is: 

```
>> Please enter your choice [1-4]: 
2
Enter the following values for a todo:
>>> Todo Title  : 
Go for Laundry
>>> Project Name: 
Home
>>> Due Date (Format: 2020-03-21) : 
2020-03-29
>>> Todo has been added successfully
```

´´´
**NOTICE**: the fields can't be empty and the date must have the format yyyy-MM-dd, and the date cannot be past date. If past date is passed, this error appears:

## 4. Edit menu
If the user pressed (3), the edit menu is displayed:

```
>> Please enter your choice [1-4]: 
3
>>> Type a Todo ID to be EDITED and press ENTER key: 

ID   TITLE                               PROJECT              DUE-DATE        COMPLETED 
--   -----                               -------              --------        --------- 
1    Go for Laundry                      Home                 2020-03-29      No        
2    Go for Car Wash                     Car                  2020-03-31      No        
3    Do leaning                          Home                 2020-03-27      No        
4    Go to ibrary to return book         Library              2020-04-01      No        
```
And the user must select the index of a todo to be edited:

```
3
>>> Todo ID 3  is selected:
Title     : Do leaning
Project   : Home
Status    : NOT COMPLETED
Due Date  : 2020-03-27


EDIT MENU FOR TODOS
-------------------

>> Pick an option:
>> (1) Modify selected todo
>> (2) Mark selected todo as Completed
>> (3) Mark selected todo as Pending
>> (4) Delete selected todo
>> (5) Display main menu

>> Please enter your choice [1-4]: 
1
```
The application will then request the user to insert a todo title, a project title and a due date. Same sequence of actions as explained in `2. Add new task`. The only difference is that, during edit, a field can be skipped (not edited) by simply pressing Enter (leaving the field empty).

```
Enter the following values to edit a todo:
In case if you do not wish to edit the any of the value, press ENTER key!
>>> Task Title  : 
Do cleaning
>>> Project Name: 

>>> Due Date (e.g 2020-03-31) : 

>>> Todo is Edited successfully
``` 
 
(2) - a list of todos with index is displayed and the user must select the index of a task to be marked as done (as above); once an index was selected, the application changes the task status to "Done":

```
EDIT MENU FOR TODOS
-------------------

>> Pick an option:
>> (1) Modify selected todo
>> (2) Mark selected todo as Completed
>> (3) Mark selected todo as Pending
>> (4) Delete selected todo
>> (5) Display main menu

>> Please enter your choice [1-4]: 
2
>>> Todo ID 3 is marked as Completed
```

(3) - a list of todo with index is displayed and the user must select the index of a todo to be removed (as above); once an index was selected, the application removes the task from the todo list:

```
>>> Type a Todo ID to be EDITED and press ENTER key: 

ID   TITLE                               PROJECT              DUE-DATE        COMPLETED 
--   -----                               -------              --------        --------- 
1    Go for Laundry                      Home                 2020-03-29      No        
2    Go for Car Wash                     Car                  2020-03-31      No        
3    Do cleaning                         Home                 2020-03-27      Yes       
4    Go to ibrary to return book         Library              2020-04-01      No        
3
>>> Todo ID 3  is selected:
Title     : Do cleaning
Project   : Home
Status    : Completed
Due Date  : 2020-03-27


EDIT MENU FOR TODOS
-------------------

>> Pick an option:
>> (1) Modify selected todo
>> (2) Mark selected todo as Completed
>> (3) Mark selected todo as Pending
>> (4) Delete selected todo
>> (5) Display main menu

>> Please enter your choice [1-4]: 
4
>>> Todo ID 3 is Deleted
```

## 5. Save and quit
If the user pressed (4), the todo list is saved in a file (loaded to the program when the user starts the application next time) and the program stops execution:

```
>> Todos are saved successfully
>> Welcome next time, Bye
```
