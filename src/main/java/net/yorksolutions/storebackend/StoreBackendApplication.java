package net.yorksolutions.storebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// decorators - annotation
@SpringBootApplication // informs the application that we are using spring boot
public class StoreBackendApplication {

    // Object-oriented programming - programming based around classes and objects, i guess
    // Why use it?
    //   makes thing scalable and reusable
    //   keeps code organized
    //   conducive to breaking down the problem into smaller problems
    // problem - we want to create the same kind of object over and over
    // class - template for an object
    // problem - we have variable that needs to be associated with each other
    // object - instance of a class
    // object - group of fields/data/methods
    // method is a function inside of a class
    // static - can be called w/o an existing object

    public static void main(String[] args) {
        // SpringApplication.run scan the given class
        // Get the package that that class is defined in
        // Look at all classes in that package for Spring Annotations
        //
        SpringApplication.run(StoreBackendApplication.class, args);
    }

}
