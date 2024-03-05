package osgi_studentinformationconsumer;

public interface StudentInterface {
	
	void displayStudentInfo(String id);
    void addStudent(String name, String id, String department);
    void updateStudent(String id, String name, String department);
    void deleteStudent(String id);

}
