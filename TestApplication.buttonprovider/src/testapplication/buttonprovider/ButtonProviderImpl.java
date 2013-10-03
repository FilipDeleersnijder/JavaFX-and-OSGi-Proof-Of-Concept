package testapplication.buttonprovider;

import javafx.scene.control.Button;

public class ButtonProviderImpl implements ButtonProvider{

	@Override
	public Button getButton() {
		Button btn = new Button();
		btn.setText("I am a button");
		return btn;
	}

}
