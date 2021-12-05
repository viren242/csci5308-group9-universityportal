package edu.dalhousie.business.Feedback.controllers;

import edu.dalhousie.business.Feedback.business.FeedbackUserInputValidation;
import edu.dalhousie.business.Feedback.business.IFeedbackUserInputValidation;
import edu.dalhousie.business.Feedback.constants.StringConstants;
import edu.dalhousie.business.Feedback.model.FeedbackUserInputValidationModel;
import edu.dalhousie.presentation.StudentView;

import java.io.IOException;
import java.sql.SQLException;

public class FeedbackMenu implements IFeedbackMenu{

    StudentView view;
    int choice = 0;
    IFeedbackUserInputValidation feedbackUserInputValidation;
    FeedbackUserInputValidationModel validation;

    public FeedbackMenu() {
        view = new StudentView();
        feedbackUserInputValidation = new FeedbackUserInputValidation();
        validation = new FeedbackUserInputValidationModel();
    }

    public void displayFeedbackMenu() throws SQLException, IOException {
        view.showMessage(StringConstants.kProvideFeedback);
        view.showMessage(StringConstants.kReadFeedbackOfTheCourse);
        view.showMessage(StringConstants.kSentimentalAnalysisOfFeedback);
        view.showMessage(StringConstants.kBackToStudentMenu);
        view.showMessage(StringConstants.kEnterYourChoice);
        choice = view.getInt();
        validation = feedbackUserInputValidation.validateFeedbackMenuInput(choice);
        if(!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                choice = view.getInt();
                validation = feedbackUserInputValidation.validateFeedbackMenuInput(choice);
            }
        }
        EFeedbackMenuOptions.valueOf(StringConstants.kEFeedbackMenuOptionsSuffix + String.valueOf(choice)).displayFeedback();
    }

}
