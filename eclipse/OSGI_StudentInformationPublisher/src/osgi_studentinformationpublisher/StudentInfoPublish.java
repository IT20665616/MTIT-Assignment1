package osgi_studentinformationpublisher;


public interface StudentInfoPublish {
	
	void addStudent(String name, String id, String department);
    void updateStudent(String id, String name, String department);
    void deleteStudent(String id);
    Student getStudentById(String id);
    void chooseOption();

}
