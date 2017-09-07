package application;

import java.awt.List;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

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
	ArrayList<TransmissionListEntry> entries = new ArrayList<>();
	VBox lista =  new VBox();
	
	public TransmissionList() {
			
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
		
		TransmissionListEntry entry = new TransmissionListEntry(fileName, imageName);
		entry.setParent(this);
		entries.add(entry);
		lista.getChildren().addAll(entry.h);
		
	}
	
	void remove(TransmissionListEntry entry){
		int index = entries.indexOf(entry);
		lista.getChildren().remove(index);
		entries.remove(index);
	}
	
	void create(Stage primaryStage){
		try {
			root.setContent(lista);
			
			Scene scene = new Scene(root,500,900);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
