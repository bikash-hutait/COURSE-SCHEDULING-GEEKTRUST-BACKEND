package com.geektrust.backend.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geektrust.backend.exceptions.NoSuchCommandException;;

public class CommandInvoker {
    private static final Map<String, ICommand> commandMap = new HashMap<>();

    // Register the command into the HashMap
    public void register(String commandName, ICommand command){
        commandMap.put(commandName,command);
    }

    // Get the registered Command
    private ICommand get(String commandName){
        return commandMap.get(commandName);
    }

    // Execute the registered Command
    public void executeCommand(String commandName, List<String> tokens) throws NoSuchCommandException {
        ICommand command = get(commandName);
        try {
            if(command != null){
                command.execute(tokens);
            }
        } catch (NoSuchCommandException e) {
            System.out.println("No Such Command Found");
        }
        
    
    }

}