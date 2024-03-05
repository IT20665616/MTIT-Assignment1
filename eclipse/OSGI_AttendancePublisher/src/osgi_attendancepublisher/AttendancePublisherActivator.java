package osgi_attendancepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class AttendancePublisherActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Attencance Publisher Start");
		AttendancePublish attendancePublish = new AttendancePublishImpl();
		serviceRegistration = context.registerService(AttendancePublish.class.getName(), attendancePublish, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Attendance Publisher stopped");
		serviceRegistration.unregister();
	}

}
