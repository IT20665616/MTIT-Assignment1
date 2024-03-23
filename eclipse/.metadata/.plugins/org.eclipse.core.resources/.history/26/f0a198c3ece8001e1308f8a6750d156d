package gradingsubscriber;

import gradingpublisher.GradingPublish;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class GradingSubscriberActivator implements BundleActivator {

	ServiceReference serviceReference;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Grading Subscriber Start");
		serviceReference = context.getServiceReference(GradingPublish.class.getName());
		GradingPublish gradingPublish = (GradingPublish) context.getService(serviceReference);
		
//		servicePublish.chooseAnOption();
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Grading Subscriber stop");
		context.ungetService(serviceReference);
	}

}
