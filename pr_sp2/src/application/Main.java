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
	Button increment;
	Button receive;
	
	double pr = 0;
	
	@Override
	public void start(Stage primaryStage) {
		
		transmit = new Button("Simulate transmision");
		increment = new Button("Incrementar");
		
		try {

			Stage newStage = new Stage();
			TransmissionList tl = new TransmissionList();
			tl.create(newStage);
			
			
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

			
			increment.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {				
				if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
					pr += 0.1;
					tl.entries.get(0).setProgress(pr);
					
				}

			});
			
			
			
			root.getChildren().addAll(transmit, increment);
			
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
