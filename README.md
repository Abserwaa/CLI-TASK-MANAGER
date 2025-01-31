# Project Title

✅CLI Task Tracker

A simple and efficient command-line application for tracking tasks. This tool allows users to create, update, delete, and manage tasks directly from the terminal.

🚀  ## Features
-Add new tasks with descriptions

-Update task descriptions

-Delete tasks by ID

-Mark tasks as "in-progress" or "done"

-List tasks with optional status filters

🛠️ ## Installation
Clone this repository:
git clone <https://github.com/your-username/cli-task-tracker.git>
cd cli-task-tracker

Compile the project using Maven:
mvn clean compile  

Run the application:
mvn exec:java -Dexec.mainClass="TaskModules.TaskCLI"  

📚 Example Session

&gt; add Write weekly report  
Task added successfully (ID: 1)  

&gt;list  

1. Write weekly report [todo]  

&gt; mark-in-progress 1  
Task marked as in-progress.  

&gt;list  

1. Write weekly report [in-progress]  

&gt; mark-done 1  
Task marked as done.  

&gt; list done  

1. Write weekly report [done]  

&gt; exit  
Goodbye!  
