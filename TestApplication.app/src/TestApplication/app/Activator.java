package TestApplication.app;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator{
	
	private static Activator act;
	private static MainApplication app;
	private BundleContext bc;
	
	public Activator(){
		Activator.act = this;
	}
	
	public static Activator getInstance(){
		return act;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("TestApplication.app Bundle started ");
		bc = context;
	}
	
	public BundleContext getBundleContext(){
		return bc;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void setApplication(MainApplication app){
		Activator.app = app;
	}
	
	public MainApplication getApplication(){
		return Activator.app;
	}

}
