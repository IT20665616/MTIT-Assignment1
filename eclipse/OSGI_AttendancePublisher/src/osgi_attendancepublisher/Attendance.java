package osgi_attendancepublisher;

public class Attendance {
	
	private String courseID;
    private String StudentId;
    private String attendance;

    public Attendance(String courseID, String StudentId, String attendance) {
        this.courseID = courseID;
        this.StudentId = StudentId;
        this.attendance = attendance;
    }

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getStudentId() {
		return StudentId;
	}

	public void setStudentId(String studentId) {
		StudentId = studentId;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}


}
