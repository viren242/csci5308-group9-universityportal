package edu.dalhousie.controllers;

import edu.dalhousie.business.AddNewApplication.constants.StringConstants;
import edu.dalhousie.business.AddNewApplication.controller.AddNewApplicationForAdmissionFactory;
import edu.dalhousie.business.AddNewApplication.controller.IAddNewApplicationForAdmission;
import edu.dalhousie.business.dalmembership.controller.menu.MenuImplementation;
import edu.dalhousie.business.events.controller.EventApplication;
import edu.dalhousie.business.Feedback.controllers.FeedbackMenuFactory;
import edu.dalhousie.business.Feedback.controllers.IFeedbackMenu;
import edu.dalhousie.business.RoommateFinder.controller.IRoommateFinder;
import edu.dalhousie.business.RoommateFinder.controller.RoommateFinderFactory;
import edu.dalhousie.business.Scholarship.controller.ScholarshipMenu;
import edu.dalhousie.business.tender.controller.Tender.Tender;
import edu.dalhousie.business.courseregistration.controller.CourseRegistration;
import edu.dalhousie.business.facilitybooking.controller.FacilityBooking;
import edu.dalhousie.business.sportnomination.controller.SportsNomination;
import edu.dalhousie.business.viewprofile.controller.ViewProfile;
import edu.dalhousie.presentation.StudentView;
import edu.dalhousie.utilities.PrintHeading;

public class StudentMainClass {
    StudentView view = new StudentView();
    private static final String addNewApplication = "Add new application for admission";
    private static final String profile = "Profile (Personal information and course details)";
    private static final String listOfCourses = "List of courses for registration";
    private static final String feePaymentDetails = "Fee payment details";
    private static final String feedback = "Feedback";
    private static final String applyForScholarship = "Apply for scholarships";
    private static final String organizeEvents = "Organize events";
    private static final String roommateFinder = "Roommate finder";
    private static final String healthReimbursement = "Health Reimbursement";
    private static final String nominationForSports = "Nomination for sports";
    private static final String tender = "Organize e-tender";
    private static final String dalMembership = "Dalhousie student card";
    private static final String facilityBooking = "Facility booking";
    private static final String logout = "Logout";

    public void displayStudentMenu() throws Exception {
        while (true) {
            PrintHeading.printHeadingForTheScreen("Student Menu", 45);

            view.showMessage("1. " + addNewApplication);
            view.showMessage("2. " + profile);
            view.showMessage("3. " + listOfCourses);
            view.showMessage("4. " + feePaymentDetails);
            view.showMessage("5. " + feedback);
            view.showMessage("6. " + applyForScholarship);
            view.showMessage("7. " + organizeEvents);
            view.showMessage("8. " + roommateFinder);
            view.showMessage("10. " + nominationForSports);
            view.showMessage("11. " + tender);
            view.showMessage("12. " + dalMembership);
            view.showMessage("13. " + facilityBooking);
            view.showMessage("14. " + logout);

            System.out.println("Enter your choice\n");
            int choice = view.getInt();
            switch (choice) {
                case 1:
                    IAddNewApplicationForAdmission addNewApplicationForAdmission = AddNewApplicationForAdmissionFactory.createAddNewApplicationForAdmission(StringConstants.kAddNewApplication);
                    addNewApplicationForAdmission.showNewForm();
                    break;
                case 2:
                    ViewProfile viewProfile = new ViewProfile();
                    viewProfile.viewProfilePage("student");
                    break;
                case 3:
                    CourseRegistration courseRegistration = new CourseRegistration();
                    courseRegistration.registerForCourses();
                    break;
                case 4:
                    FeesPaymentDetailsMenu feesPaymentDetails = new FeesPaymentDetailsMenu();
                    feesPaymentDetails.showPaymentInformationMenu();
                    break;
                case 5:
                    IFeedbackMenu feedbackMenu = FeedbackMenuFactory.getFeedbackMenu(StringConstants.kFeedbackMenu);
                    feedbackMenu.displayFeedbackMenu();
                    break;
                case 6:
                    ScholarshipMenu scholarshipMenu = new ScholarshipMenu();
                    scholarshipMenu.displayMenu();
                    break;
                case 7:
                    EventApplication eventApplication = new EventApplication();
                    eventApplication.hostEvent();
                    break;
                case 8:
                    IRoommateFinder roommateFinder = RoommateFinderFactory.getRoommateFinder(StringConstants.kRoommateFinder);
                    roommateFinder.displayForm();
                    break;
                case 9:
                    //call method
                    System.out.println("You selected 9");
                    break;
                case 10:
                    SportsNomination sportsNomination = new SportsNomination();
                    sportsNomination.viewSportsNomination();
                    break;
                case 11:
                    Tender tender = new Tender();
                    tender.getTenderData();
                    break;
                case 12:
                    MenuImplementation menu = new MenuImplementation();
                    menu.start();
                    break;
                case 13:
                    FacilityBooking facilityBooking = new FacilityBooking();
                    facilityBooking.startFacilityBookingService();
                    break;
                case 14:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}