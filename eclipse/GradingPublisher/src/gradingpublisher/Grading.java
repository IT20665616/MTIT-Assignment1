package gradingpublisher;

public class Grading {
	private String name;
    private String id;
    private String grade;
    private String comments;


    public Grading(String id, String name, String grade, String comments) {
        this.name = name;
        this.id = id;
        this.grade = grade;
        this.comments = comments;
    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}

	

}
