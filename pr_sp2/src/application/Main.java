package application;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	Button transmit;
	Button receive;
	
	@Override
	public void start(Stage primaryStage) {
		
		transmit = new Button("Simulate transmision");
		
		try {

			Stage newStage = new Stage();
			TransmissionList tl = new TransmissionList();
			tl.create(newStage);
			
			tl.add();
			
			newStage.show();

			VBox root = new VBox();
			
			EventHandler handler = new EventHandler(){

				@Override
				public void handle(Event event) {				
					if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
					
						tl.add("Archivo de audio", "audio_icon_template.png");
						
					}

				}

			};
			
			transmit.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
			
			root.getChildren().add(transmit);
			
			Scene scene = new Scene(root, 200, 200);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
