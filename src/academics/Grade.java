/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package academics;

public class Grade {
    private String courseName;
    private String courseCode;
    private int prelimGrade;
    private int midtermGrade;
    private int tentativeFinalGrade;
    private int finalGrade;

    public Grade(String courseName, String courseCode, int prelimGrade, int midtermGrade, int tentativeFinalGrade, int finalGrade) {
        setCourseName(courseName);
        setCourseCode(courseCode);
        setPrelimGrade(prelimGrade);
        setMidtermGrade(midtermGrade);
        setTentativeFinalGrade(tentativeFinalGrade);
        setFinalGrade(finalGrade);
    } // end of constructor

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getPrelimGrade() {
        return prelimGrade;
    }

    public int getMidtermGrade() {
        return midtermGrade;
    }

    public int getTentativeFinalGrade() {
        return tentativeFinalGrade;
    }

    public int getFinalGrade() {
        return finalGrade;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setPrelimGrade(int prelimGrade) {
        this.prelimGrade = prelimGrade;
    }

    public void setMidtermGrade(int midtermGrade) {
        this.midtermGrade = midtermGrade;
    }

    public void setTentativeFinalGrade(int tentativeFinalGrade) {
        this.tentativeFinalGrade = tentativeFinalGrade;
    }

    public void setFinalGrade(int finalGrade) {
        this.finalGrade = finalGrade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Grade grade)) return false;
        return (courseName + "," + courseCode).equalsIgnoreCase
                (grade.getCourseName() + "," + grade.getCourseCode());
    } // end of equals method

    public String toString() {
        return courseName + "," + courseCode + "," + prelimGrade + "," + midtermGrade + "," + tentativeFinalGrade + "," + finalGrade;
    } // end of toString method
} // end of Grade class
