package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			ScrollPane root = new ScrollPane();
			VBox lista =  new VBox();
			
			Rectangle n0 = new Rectangle(100,30);
			Rectangle n1 = new Rectangle(100,30);
			Rectangle n2 = new Rectangle(100,30);
			Rectangle n3 = new Rectangle(100,30);

			lista.getChildren().addAll(n0,n1,n2,n3);
			
			root.setContent(lista);
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
