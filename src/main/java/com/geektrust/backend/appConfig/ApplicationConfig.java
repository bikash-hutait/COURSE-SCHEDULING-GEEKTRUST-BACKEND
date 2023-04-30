package com.geektrust.backend.appConfig;

import com.geektrust.backend.commands.AddCourseCommand;
import com.geektrust.backend.commands.AllotCourseCommand;
import com.geektrust.backend.commands.CancelCourseCommand;
import com.geektrust.backend.commands.CommandInvoker;
import com.geektrust.backend.commands.RegisterCourseCommand;
import com.geektrust.backend.repositories.CourseRepository;
import com.geektrust.backend.repositories.EmployeeRepository;
import com.geektrust.backend.repositories.ICourseRepository;
import com.geektrust.backend.repositories.IEmployeeRepository;
import com.geektrust.backend.repositories.IRegistrationRepository;
import com.geektrust.backend.repositories.RegistrationRepository;
import com.geektrust.backend.services.CourseService;
import com.geektrust.backend.services.ICourseService;
import com.geektrust.backend.services.IRegistrationService;
import com.geektrust.backend.services.RegistrationService;

public class ApplicationConfig {
    private final ICourseRepository courseRepository = new CourseRepository();
    private final IEmployeeRepository employeeRepository = new EmployeeRepository();
    private final IRegistrationRepository registrationRepository = new RegistrationRepository();
       
    private final ICourseService courseService = new CourseService(courseRepository, employeeRepository,registrationRepository);
    private final IRegistrationService registrationService = new RegistrationService(courseRepository, employeeRepository, registrationRepository);


    private final AddCourseCommand addCourseOfferingCommand = new AddCourseCommand(courseService);
    private final RegisterCourseCommand registerCommand = new RegisterCourseCommand(registrationService);
    private final AllotCourseCommand allotCommand = new AllotCourseCommand(courseService);
    private final CancelCourseCommand cancelCommand = new CancelCourseCommand(courseService);
    
    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("ADD-COURSE-OFFERING",addCourseOfferingCommand);
        commandInvoker.register("REGISTER",registerCommand);
        commandInvoker.register("ALLOT",allotCommand);
        commandInvoker.register("CANCEL",cancelCommand);
       
       
        return commandInvoker;
    }



    
}