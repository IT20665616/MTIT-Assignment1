package gradingpublisher;

public interface GradingPublish {
	void addGrade(String courseId, String studentId, String grade, String comments);

	void updateGrade(String courseId, String studentId, String grade, String comments);

	void removeGrade(String courseId, String studentId);

	String getGrade(String courseId, String studentId);
}
