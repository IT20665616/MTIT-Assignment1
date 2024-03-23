package osgi_attendanceconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import osgi_attendancepublisher.AttendancePublish;

public class AttendanceConsumerActivator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("Student Consumer Start");
		serviceReference = context.getServiceReference(AttendancePublish.class.getName());
		AttendancePublish attendancePublish = (AttendancePublish) context.getService(serviceReference);
		
		if (attendancePublish != null) {
			attendancePublish.selectOption();
        }
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Student Consumer stop");
		context.ungetService(serviceReference);
	}

}
