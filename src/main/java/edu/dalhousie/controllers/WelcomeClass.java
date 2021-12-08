package edu.dalhousie.controllers;

import edu.dalhousie.business.registration.controller.IRegistration;
import edu.dalhousie.business.registration.controller.RegistrationFactory;
import edu.dalhousie.presentation.StudentView;
import edu.dalhousie.utilities.PrintHeading;

public class WelcomeClass {
    private int choice;
    private static final String registerAsStudent = "Register as a Student";
    private static final String registerAsFaculty = "Register as a Faculty";
    private static final String loginAsStudent = "Login as a Student";
    private static final String loginAsFaculty = "Login as a Faculty";
    private static final String exit = "Exit";

    public void displayWelcomeScreen() throws Exception {
        StudentView view = new StudentView();
        StudentMainClass student = new StudentMainClass();
        FacultyMainClass faculty = new FacultyMainClass();
        Login login = new Login();
        User user;
        UserSession userSession = UserSession.getInstance();

        while (true) {
            PrintHeading.printHeadingForTheScreen("Welcome to university portal", 35);

            view.showMessage("1. " + registerAsStudent);
            view.showMessage("2. " + registerAsFaculty);
            view.showMessage("3. " + loginAsStudent);
            view.showMessage("4. " + loginAsFaculty);
            view.showMessage("5. " + exit);
            view.showMessage("\nEnter your choice:");
            choice = view.getInt();

            switch (choice) {
                case 1:
//                student.displayStudentMenu();
                    IRegistration studentRegistration = RegistrationFactory.getInstance().getRegistration();
                    studentRegistration.registerUser("STUDENT");
                    break;
                case 2:
                    IRegistration facultyRegistration = RegistrationFactory.getInstance().getRegistration();
                    facultyRegistration.registerUser("FACULTY");
                    break;
                case 3:
                    user = login.loginUser("STUDENT");
                    if (user != null) {
                        userSession.newUserSession(user);
                        student.displayStudentMenu();
                    }
                    break;
                case 4:
                    user = login.loginUser("FACULTY");
                    if (user != null) {
                        userSession.newUserSession(user);
                        faculty.displayFacultyMenu();
                    }
                    break;
                case 5:
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}