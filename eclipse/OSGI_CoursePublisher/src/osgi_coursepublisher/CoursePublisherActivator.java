package osgi_coursepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class CoursePublisherActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Course Publisher Start");
		CoursePublish coursePublish = new CoursePublishImpl();
		serviceRegistration = context.registerService(CoursePublish.class.getName(), coursePublish, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Course Publisher stopped");
		serviceRegistration.unregister();
	}

}
