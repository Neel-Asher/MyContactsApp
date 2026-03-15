package com.mycontactapp.contact.history;

import java.util.Stack;

import com.mycontactapp.contact.command.ContactCommand;

public class CommandHistory {

    private Stack<ContactCommand> undoStack = new Stack<>();

    private Stack<ContactCommand> redoStack = new Stack<>();

    public void execute(ContactCommand command){

        command.execute();

        undoStack.push(command);

        redoStack.clear();
    }

    public void undo(){

        if(!undoStack.isEmpty()){

            ContactCommand cmd = undoStack.pop();

            cmd.undo();

            redoStack.push(cmd);
        }
    }

    public void redo(){

        if(!redoStack.isEmpty()){

            ContactCommand cmd = redoStack.pop();

            cmd.execute();

            undoStack.push(cmd);
        }
    }
}