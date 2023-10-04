/**
 * @author: Leung, Leonhard
 * Date: 10/04/2023
 */

package academics;

public class Schedule {
    private String courseName;
    private String courseCode;
    private String startTime;
    private String endTime;
    private String days;
    private String roomNumber;

    public Schedule (String courseName, String courseCode, String startTime, String endTime, String days, String roomNumber) {
        setCourseName(courseName);
        setCourseCode(courseCode);
        setStartTime(startTime);
        setEndTime(endTime);
        setDays(days);
        setRoomNumber(roomNumber);
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getDays() {
        return days;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Schedule schedule)) return false;
        return (courseName + "," + courseCode).equalsIgnoreCase
                (schedule.getCourseName() + "," + schedule.getCourseCode());
    } // end of equals method

    public String toString() {
        return courseName + "," + courseCode + "," + startTime + "," + endTime + "," + days + "," + roomNumber;
    } // end of toString method
} // end of Schedule class
