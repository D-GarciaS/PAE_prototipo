package application;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

public class TransmissionListEntry {

	HBox h;
	public TransmissionListEntry() {
		URL resource = getClass().getResource("incoming_file_layout.fxml");
		try {
			h = FXMLLoader.load(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
