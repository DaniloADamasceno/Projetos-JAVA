package com.danilo;


import com.danilo.service.UserRegistrationService;

public class MainApplication {
    public static void main(String[] args) {
        try {
            UserRegistrationService.run();
        }catch (Exception exceptionRunError) {
            System.out.println("Error: " + exceptionRunError.getMessage());
        }
    }
}