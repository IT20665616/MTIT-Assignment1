package osgi_attendancepublisher;

public interface AttendancePublish {
	
	void addAttendance(String caurseId, String StudentId, String attendance );
	void updateAttendance(String caurseId, String StudentId, String attendance );
	void deleteAttendance(String id);
    Attendance getAttendanceById(String id);
    void selectOption();

}
