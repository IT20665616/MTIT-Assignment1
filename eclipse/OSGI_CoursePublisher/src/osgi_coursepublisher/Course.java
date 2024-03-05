package osgi_coursepublisher;

public class Course {
	private String name;
    private String id;
    private String department;

    public Course(String id, String name, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
