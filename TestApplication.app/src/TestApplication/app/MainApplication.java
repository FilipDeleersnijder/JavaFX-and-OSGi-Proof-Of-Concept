package TestApplication.app;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.osgi.util.AbstractJFXApplication;

public class MainApplication extends AbstractJFXApplication implements ApplicationService {
	
	private Scene s;
	
	public MainApplication(){
		
	}
	
	protected void jfxStart(IApplicationContext applicationContext, Application jfxApplication, Stage primaryStage) {
	
		s = new Scene(new Group(new Label("Hello World")));
		primaryStage.setScene(s);
		primaryStage.setWidth(300);
		primaryStage.setHeight(400);
		primaryStage.setTitle("Hello World");
		primaryStage.show();
		
		Activator.getInstance().setApplication(this);
		
		Activator.getInstance().getBundleContext().registerService(ApplicationService.class, this, null);
	}
	
	public void addButton(Button but){
		((Group)s.getRoot()).getChildren().add(but);
	}
}
