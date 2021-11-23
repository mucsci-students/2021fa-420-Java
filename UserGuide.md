# Commands
#####The parentheses in the signature is one argument

add class - creates a new unique class * the name must be alphanumeric and not already exist.
            Signature: add class (name)

delete class - deletes a preexisting class * the class must already exist to delete it.
            Signature: delete class (name)

rename class - takes a class and provides a new name * the name must not already exist as another class and it's new name must be alphanumeric.
            Signature: rename class (old name) (new name)

add method - creates a new method for a class
            Signature:  add method (class name) (method name) (method type)

delete method - deletes a method from a class
            Signature: delete method (class name) (method name)

delete all methods - Deletes all methods in a given UML Class.
            Signature: delete all methods (class name)

rename method - renames a method in a class
            Signature: rename method (class name) (old name) (new name)

add field - creates a new field for a class
            Signature: add field (class name) (field name) (field type)

delete field - deletes a field from a class
            Signature: delete field (class name) (field name)

rename field - renames a field from a class
            Signature: rename field (class name) (old name) (new name)

add parameter - creates a parameter in a method for a class
            Signature: add parameter (class name) (method name) (parameter name) (parameter type)

delete parameter - deletes a parameter from a method in a class
            Signature: delete parameter (class name) (method name) (parameter name)

delete all parameters - deletes all the paramaters in a given method
            Signature: delete all parameter (class name) (method name)

change parameter - changes a parameter in a method in a class
            Signature: change parameter (class name) (method name) (old parameter name) (new parameter name) (parameter type)

add relation - creates a relationship between two classes
            Signature: add relation (source class name) (destination class name) (relationship type)

delete relation - deletes a relationship between two classes
            Signature: delete relation (source class name) (destination class name)

change relationship type - changes a relationship type
            Signature: change relation (source class name) (destination class name) (New relationship type)

list classes - lists all the classes made
            Signature: list classes

list contents - lists the contents of a specific class
            Signature: list contents

list relationships - lists relationships between all classes
            Signature: list relationships

save - saves current uml file
            Signature: save

load - loads a uml file
            Signature: load

help - provides a list of commands usable commands
            Signature: help

exit - exists the program
            Signature: exit

GUI - opens the GUI
            Signature: gui
            
undo - undos last action
            signature: undo

redo - redos last action
            signature: redo
    
screenshot - takes a screenshot of uml
            signature: screenshot (location of directory where saving)

set position - sets the position of a uml box
            signature: set position (class name) (x-coordinate) (y-coordinate)

# GUI

##### In the GUI, the commands listed above will accessible via button click on the far left of the GUI.
            
### Steps For Using GUI Buttons

        1. Find the commands you would like to run and click on that button
        2. Once you've clicked on a button you'll be prompted for information, sometimes you'll be prompted for multiple things at once
        3. Enter the information being prompted in the specified text boxes
        4. Action completed
    
### User Interaction

        1. All class boxes are able to be dragged by being clicked on and moved to a new location
        2. Arrows are visible once a relation is created between two classes. These arrows will move with the class boxes
        3. For saving, click the save button and if the file doesn't already exist a new one will be created and you will
           be prompted to name the new file
        4. For loading, you will be prompted to enter a file in your directory

# CLI
##### In the CLI the commands listed above will need to be typed

### Steps For Using CLI

        1. Find and type the command in the terminal that you would like to run (commands listed above) and press enter
        2. After each command you will be prompted for more information, fill out the prompts according to your desired result
        3. If the user wants to type the commands faster, there is a tab completion option where the user can hit the tab key
           and it will autocomplete the command
           
