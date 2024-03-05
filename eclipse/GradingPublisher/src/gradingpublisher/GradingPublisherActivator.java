package gradingpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class GradingPublisherActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Grades Publisher Start");
		GradingPublish gradingPublish = new GradingPublishImpl();
		serviceRegistration = context.registerService(GradingPublish.class.getName(), gradingPublish, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Grades Publisher stopped");
		serviceRegistration.unregister();
	}

}
