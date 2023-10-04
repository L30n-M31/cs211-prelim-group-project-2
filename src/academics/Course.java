/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package academics;

public class Course {
    private String courseName;
    private String courseCode;
    private String classCode;
    private String instructor;
    private int year;
    private String semester;
    private double units;

    public Course(String courseName, String courseCode, String classCode, String instructor, int year, String semester, double units) {
        setCourseName(courseName);
        setCourseCode(courseCode);
        setClassCode(classCode);
        setInstructor(instructor);
        setYear(year);
        setSemester(semester);
        setUnits(units);
    } // end of constructor

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getClassCode() {
        return classCode;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }

    public double getUnits() {
        return units;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setUnits(double units) {
        this.units = units;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Course course)) return false;
        return (courseCode + "," + classCode).equalsIgnoreCase
                (course.getCourseCode() + "," + course.getClassCode());
    } // end of equals method

    @Override
    public String toString() {
        return courseName + "," + courseCode + "," + classCode + "," + instructor + "," + semester + "," + units;
    } // end of toString method
} // end of Course class
