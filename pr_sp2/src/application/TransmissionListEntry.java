package application;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class TransmissionListEntry {

	HBox h;
	VBox v;
	ProgressBar pb; 
	TransmissionList parent;
	Button cancel; 
	
	public TransmissionListEntry(String fileName, String imageName) {
		URL resource = getClass().getResource("incoming_file_layout.fxml");
		try {
			h = FXMLLoader.load(resource);
			v = (VBox) h.getChildren().get(1);
			pb = (ProgressBar) v.getChildren().get(1);
			cancel = (Button) h.getChildren().get(3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((Text)h.lookup("#fileName")).setText(fileName);	
		((ImageView)h.lookup("#fileIcon")).setImage(new Image(getClass().getResource("icon.png").toExternalForm()));
		
		cancel.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {				
			if(event.getEventType() == MouseEvent.MOUSE_CLICKED){
				parent.remove(this);
			}

		});
		
	}
	
	void setParent(TransmissionList list){
		this.parent = list;
	}
	
	void setProgress(double d){
		pb.setProgress(d);
	}
}
