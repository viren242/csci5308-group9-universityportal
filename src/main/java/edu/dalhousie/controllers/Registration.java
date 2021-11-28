package edu.dalhousie.controllers;

import edu.dalhousie.database.RegistrationApi;
import edu.dalhousie.models.RegistrationModel;
import edu.dalhousie.presentation.RegistrationView;
import edu.dalhousie.presentation.StudentView;
import edu.dalhousie.utilities.Utility;

public class Registration {
    StudentView view;
    WelcomeClass welcome;
    RegistrationModel registrationModel;
    RegistrationView registrationView;
    RegistrationApi registrationApi;

    public Registration() {
        view = new StudentView();
        welcome = new WelcomeClass();
        registrationModel = new RegistrationModel();
        registrationView = new RegistrationView();
        registrationApi = new RegistrationApi();
    }

    private String createUsername(String firstName, String lastName) {
        return firstName + "." + lastName;
    }

    public void registerUser(String typeOfRegistration) {
        int userChoice;
        String title = typeOfRegistration.equals("student") ? "Register as a student" : "Register as a faculty";

        Utility.printHeadingForTheScreen(title, 38);

        registrationView.renderRegistrationForm(registrationModel);
        registrationModel.setUsername(createUsername(registrationModel.getFirstName(), registrationModel.getLastName()));

        view.showMessage("\nVerifying your details...");
        int result = registrationApi.saveUserDetails(registrationModel);
        if (result == 0) {
            view.showMessage("Details verified...\n");
            view.showMessage("Your username is \"" + registrationModel.getUsername() + "\".");
            view.showMessage("\nPlease login using your username and password to access your portal.\n");
        } else {
            view.showMessage("Something went wrong, please try again...\n");
        }

        view.showMessage("Press '0' to go back");
        userChoice = view.getInt();
        if (userChoice == 0) {
            welcome.displayWelcomeScreen();
        }
    }
}
