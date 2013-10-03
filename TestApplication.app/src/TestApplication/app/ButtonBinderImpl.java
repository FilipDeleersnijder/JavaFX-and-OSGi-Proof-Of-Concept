package TestApplication.app;

import java.util.LinkedList;
import java.util.List;

import javafx.application.Platform;
import javafx.scene.control.Button;
import testapplication.buttonprovider.ButtonProvider;

public class ButtonBinderImpl {

	List<ButtonProvider> buttons;
	ApplicationService as;
	
	public ButtonBinderImpl(){
		buttons = new LinkedList<ButtonProvider>();
	}

	public List<ButtonProvider> getButtons() {
		return buttons;
	}

	public void setButtons(List<ButtonProvider> buttons) {
		this.buttons = buttons;
	}

	public void bindButtonProvider(final ButtonProvider provider){
		buttons.add(provider);
		if(as != null){
			
			final Button btn = provider.getButton();
			
			Platform.runLater(new Runnable() {
				
				@Override
				public void run() {
					as.addButton(btn);
				}
			});
		}
			
	}
	
	public void unbindButtonProvider(ButtonProvider provider){
		buttons.remove(provider);
	}
	
	public void bindApplicationService(final ApplicationService as){
		this.as = as; 
		
		for (ButtonProvider bp : buttons) {
			
			final Button btn = bp.getButton();
			
			Platform.runLater(new Runnable() {
				
				@Override
				public void run() {
					as.addButton(btn);
				}
			});
		}
	}
	
	public void unbindApplicationService(ApplicationService as){
		
	}
}
