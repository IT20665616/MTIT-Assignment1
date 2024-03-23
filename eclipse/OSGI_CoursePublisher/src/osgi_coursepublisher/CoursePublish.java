package osgi_coursepublisher;

public interface CoursePublish {
//	void enrollStudent(String courseId, String studentId);
//    void removeStudent(String courseId, String studentId);
//    String[] getEnrolledStudents(String courseId);
    
	void addCourse(String caurseId, String name, String department);
	void updateCourse(String id, String name, String department);
	void deleteCourse(String id);
    Course getCourseById(String id);
    void chooseOption();

}
