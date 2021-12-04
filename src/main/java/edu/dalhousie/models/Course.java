package edu.dalhousie.models;

public class Course {
    private int courseId;
    private String courseName;
    private int availableSeats;
    private int preRequisiteCourseId;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getPreRequisiteCourseId() {
        return preRequisiteCourseId;
    }

    public void setPreRequisiteCourseId(int preRequisiteCourseId) {
        this.preRequisiteCourseId = preRequisiteCourseId;
    }
}