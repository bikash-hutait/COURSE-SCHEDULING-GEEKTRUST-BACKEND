package com.geektrust.backend.commands;

import static org.mockito.ArgumentMatchers.anyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("CommandInvokerTest")
@ExtendWith(MockitoExtension.class)
public class CommandInvokerTest {
    private CommandInvoker commandInvoker;

    @Mock
    AddCourseCommand addCourseCommand;
    @Mock
    RegisterCourseCommand registerCommand;
    @Mock
    AllotCourseCommand allotCommand;    
    @Mock
    CancelCourseCommand cancelCommand;

    @BeforeEach
    void setup(){
        commandInvoker = new CommandInvoker();
       
        commandInvoker.register("ADD-COURSE-OFFERING",addCourseCommand);
        commandInvoker.register("REGISTER",registerCommand);
        commandInvoker.register("ALLOT",allotCommand);
        commandInvoker.register("CANCEL",cancelCommand);
       
    }

    @Test
    @DisplayName("executeCommand method Should Execute Command Given CommandName and List of tokens")
    public void executeCommand_GivenNameAndTokens_ShouldExecuteCommand() {
        commandInvoker.executeCommand("ADD-COURSE-OFFERING",anyList());
        commandInvoker.executeCommand("REGISTER",anyList());
        commandInvoker.executeCommand("ALLOT",anyList());
        commandInvoker.executeCommand("CANCEL",anyList());       
        
       
    }
}
