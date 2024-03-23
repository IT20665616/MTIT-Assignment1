package osgi_coursepublisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoursePublishImpl implements CoursePublish {

    private Map<String, Course> courseMap;

    public CoursePublishImpl() {
    }
    

    @Override
    public void addCourse(String id, String name, String department) {
    	Course course = new Course(name, id, department);
        courseMap.put(id, course);
    }

    @Override
    public void updateCourse(String id, String name, String department) {
        if (courseMap.containsKey(id)) {
        	Course course = new Course(name, id, department);
            courseMap.put(id, course);
        }
    }

    @Override
    public void deleteCourse(String id) {
        courseMap.remove(id);
    }

    @Override
    public Course getCourseById(String id) {
        return courseMap.get(id);
    }


	@Override
	public void chooseOption() {
		// TODO Auto-generated method stub
		courseMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        
        Course courseCC = new Course("1","Clour Computing","IT");
        Course courseDB = new Course("2","Database Management","IT");
        Course courseSE = new Course("3","Software Engineering","IT");
        Course courseN = new Course("4","Networking","IT");
        Course courseSys = new Course("5","System Engineering","IT");
        
        courseMap.put("1", courseCC);
        courseMap.put("2", courseDB);
        courseMap.put("3", courseSE);
        courseMap.put("4", courseN);
        courseMap.put("5", courseSys);

        while (true) {
        	System.out.println("\n"
        			         + "Welcome to Course Enrolment\n\n");
        	System.out.println("List of Courses:");
        	System.out.println("ID    |    Name                        |    Department");
        	System.out.println("---------------------------------------------------------");
        	for (Map.Entry<String, Course> entry : courseMap.entrySet()) {
        	    Course course = entry.getValue();
        	    System.out.printf("%-5s | %-30s | %-15s\n", course.getId(), course.getName(), course.getDepartment());
        	}
            System.out.println("\nChoose an Option:");
            System.out.println("1. Add new Course to the List");
            System.out.println("2. Update Existing Course");
            System.out.println("3. Remove Courses");
            System.out.println("4. View Course by ID");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nEnter course ID:");
                    String name = scanner.nextLine();
                    System.out.println("Enter course Name:");
                    String id = scanner.nextLine();
                    System.out.println("Enter course department:");
                    String department = scanner.nextLine();
                    
                    System.out.println("\nCourse Successfully Added !");
                    break;
                case 2:
                    System.out.println("Enter course ID:");
                    String courseId = scanner.nextLine();
                    Course course = getCourseById(courseId);
                    if (course != null) {
                        System.out.println("Course Details:");
                        System.out.println("Name: " + course.getName());
                        System.out.println("ID: " + course.getId());
                        System.out.println("Department: " + course.getDepartment());

                        System.out.println("\nEnter updated course name:");
                        String updateName = scanner.nextLine();
                        System.out.println("Enter updated course department:");
                        String updateDept = scanner.nextLine();
                        updateCourse(courseId, updateName, updateDept);
                        System.out.println("\nCourse Successfully Updated !");
                    } else {
                        System.out.println("Course with ID " + courseId + " not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter course ID to delete:");
                    String deleteId = scanner.nextLine();
                    deleteCourse(deleteId);
                    System.out.println("\nCourse Successfully Deleted !");
                    break;
                case 4:
                    System.out.println("Enter course ID:");
                    String viewId = scanner.nextLine();
                    Course viewedCourse = getCourseById(viewId);
                    if (viewedCourse != null) {
                        System.out.println("Course Details:");
                        System.out.println("Name: " + viewedCourse.getName());
                        System.out.println("ID: " + viewedCourse.getId());
                        System.out.println("Department: " + viewedCourse.getDepartment());
                    } else {
                        System.out.println("Course with ID " + viewId + " not found.");
                    }
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
		
	}
}
