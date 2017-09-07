package application;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TransmissionList {
	ScrollPane root = new ScrollPane();
	VBox lista =  new VBox();
	
	public TransmissionList() {
			
	}
	
	void add(){
		Text text;
		URL resource = getClass().getResource("incoming_file_layout.fxml");
		HBox h = null;
		try {
			h = FXMLLoader.load(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		lista.getChildren().addAll(h);
		
	}
	
	void add(String fileName){
		
		URL resource = getClass().getResource("incoming_file_layout.fxml");
		HBox h = null;
		try {
			h = FXMLLoader.load(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((Text)h.lookup("#fileName")).setText(fileName);		
		
		lista.getChildren().addAll(h);
	}
	
	
	void add(String fileName, String imageName){
		
		URL resource = getClass().getResource("incoming_file_layout.fxml");
		HBox h = null;
		try {
			h = FXMLLoader.load(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((Text)h.lookup("#fileName")).setText(fileName);	
		((ImageView)h.lookup("#fileIcon")).setImage(new Image(getClass().getResource("icon.png").toExternalForm()));
		
		lista.getChildren().addAll(h);
		
	}
	
	void create(Stage primaryStage){
		try {
			TransmissionListEntry h = new TransmissionListEntry();
			lista.getChildren().addAll(h.h);

			root.setContent(lista);
			
			Scene scene = new Scene(root,800,900);


			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
