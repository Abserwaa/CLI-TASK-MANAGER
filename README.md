# Project Title

## ✅ CLI Task Tracker

A simple and efficient command-line application for tracking tasks. This tool allows users to create, update, delete, and manage tasks directly from the terminal.

## 🚀 Features  

- Add new tasks with descriptions  
- Update task descriptions  
- Delete tasks by ID  
- Mark tasks as "in-progress" or "done"  
- List tasks with optional status filters  

## 🛠️ Installation  

1. Clone this repository:  

    ```bash
    git clone <https://github.com/your-username/cli-task-tracker.git>  
    cd cli-task-tracker
    ```

2. Compile the project using Maven:
  
    ```bash
    mvn clean compile
    ```

3. Run the application:  

    ```bash
    mvn exec:java -Dexec.mainClass="TaskModules.TaskCLI"
    ```

## 🏷️ Usage

| **Command**        | **Description** |
|--------------------|-----------------|
| add `<description>`| Adds a new task |
| update`<id> <desc>`| Updates the description of a task by ID               |
|  delete `<id>`     | Deletes a task by ID|
| mark-in-progress `<id>`| Marks a task as "in-progress" |
| mark-done `<id>`   | Marks a task as "done" |
|list                | Lists all tasks|
|list `<filter>`     | Lists tasks by status("todo","done")|
|exit                | Exits the application|

## 📚 Example Session  

```bash

> add Write weekly report  
Task added successfully (ID: 1)  

> list  
1. Write weekly report [todo]  

> mark-in-progress 1  
Task marked as in-progress.  

> list  
1. Write weekly report [in-progress]  

> mark-done 1  
Task marked as done.  

> list done  
1. Write weekly report [done]  

> exit  
Goodbye!

