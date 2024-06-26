package osgi_coursesubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import osgi_coursepublisher.CoursePublish;

public class CourseSubscriberActivator implements BundleActivator {

    ServiceReference<CoursePublish> serviceReference;

    public void start(BundleContext context) throws Exception {
        System.out.println("Course Subscriber Start");
        // Get service reference
        serviceReference = context.getServiceReference(CoursePublish.class);
        if (serviceReference != null) {
            // Get service object
            CoursePublish coursePublish = context.getService(serviceReference);
            // Use the service...
            if (coursePublish != null) {
                coursePublish.chooseOption();
            }
        }
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Course Subscriber stop");
        // Unget the service
        if (serviceReference != null) {
            context.ungetService(serviceReference);
        }
    }
}
