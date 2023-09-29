import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author amintesn
 *
 */
public class FXMainPane extends VBox {

	private Button button1, button2, button3, button4, button5;
	private Label label;
	private TextField textField;
	
	private HBox hBox1, hBox2;
	
	DataManager datamanager = new DataManager();
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		button1 = new Button("Button 1");
		button2 = new Button("Button 2");
		button3 = new Button("Button 3");
		button4 = new Button("Button 4");
		button5 = new Button("Button 5");
		label = new Label("Label");
		textField = new TextField();

		hBox1 = new HBox();
		hBox2 = new HBox();
		
		class ButtonHandler implements EventHandler<ActionEvent> {
	        public void handle(ActionEvent event) {
	            Button source = (Button) event.getSource();

	            if (source == button1) {
	            	String response = datamanager.getHello();
	                textField.setText(response);
	            } else if (source == button2) {
	                String response = datamanager.getHowdy();
	                textField.setText(response);
	            } else if (source == button3) {
	                String response = datamanager.getChinese();
	                textField.setText(response);
	            } else if (source == button4) {
	                textField.setText("");
	            } else if (source == button5) {
	                Platform.exit();
	                System.exit(0);
	            }
	        }
	    }
		
		hBox1.getChildren().addAll(label, textField);
		hBox2.getChildren().addAll(button1, button2, button3, button4, button5);
		getChildren().addAll(hBox1, hBox2);
		
	}
}
	
