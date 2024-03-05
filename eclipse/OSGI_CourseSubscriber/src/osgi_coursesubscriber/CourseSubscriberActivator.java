package osgi_coursesubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import osgi_coursepublisher.CoursePublish;

public class CourseSubscriberActivator implements BundleActivator {

	ServiceReference serviceReference;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Course Subscriber Start");
		serviceReference = context.getServiceReference(CoursePublish.class.getName());
		CoursePublish coursePublish = (CoursePublish) context.getService(serviceReference);
		
//		servicePublish.chooseAnOption();
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Course Subscriber stop");
		context.ungetService(serviceReference);
	}

}
