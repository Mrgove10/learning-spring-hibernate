package org.epsi.b3.simplewebapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Singleton {
    ApplicationContext myApplicationContext = new AnnotationConfigApplicationContext("org.epsi");

    public ApplicationContext GetApplicationContext(){
        return myApplicationContext;
    }
}