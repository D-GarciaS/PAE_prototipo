package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;

import javafx.embed.swing.SwingFXUtils;
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
			h.getStyleClass().add("hbox");
			v = (VBox) h.getChildren().get(1);
			pb = (ProgressBar) v.getChildren().get(1);
			
			cancel = (Button) h.getChildren().get(3);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((Text)h.lookup("#fileName")).setText(fileName);	
		
		 Image fxImage = getFileIcon("icon.png");
         ImageView imageView = new ImageView(fxImage);
		
		
		((ImageView)h.lookup("#fileIcon")).setImage(getFileIcon("icon.png"));
		
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
	
	
	private static javax.swing.Icon getJSwingIconFromFileSystem(File file) {

        // Windows {
        FileSystemView view = FileSystemView.getFileSystemView();
        javax.swing.Icon icon = view.getSystemIcon(file);
        // }

        // OS X {
        //final javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
        //javax.swing.Icon icon = fc.getUI().getFileView(fc).getIcon(file);
        // }

        return icon;
    }
	
    static HashMap<String, Image> mapOfFileExtToSmallIcon = new HashMap<String, Image>();
	
    private static String getFileExt(String fname) {
        String ext = ".";
        int p = fname.lastIndexOf('.');
        if (p >= 0) {
            ext = fname.substring(p);
        }
        return ext.toLowerCase();
    }
	
    private static Image getFileIcon(String fname) {
        final String ext = getFileExt(fname);

        Image fileIcon = mapOfFileExtToSmallIcon.get(ext);
        if (fileIcon == null) {

            javax.swing.Icon jswingIcon = null; 

            File file = new File(fname);
            if (file.exists()) {
                jswingIcon = getJSwingIconFromFileSystem(file);
            }
            else {
                File tempFile = null;
                try {
                    tempFile = File.createTempFile("icon", ext);
                    jswingIcon = getJSwingIconFromFileSystem(tempFile);
                }
                catch (IOException ignored) {
                    // Cannot create temporary file. 
                }
                finally {
                    if (tempFile != null) tempFile.delete();
                }
            }

            if (jswingIcon != null) {
                fileIcon = jswingIconToImage(jswingIcon);
                mapOfFileExtToSmallIcon.put(ext, fileIcon);
            }
        }

        return fileIcon;
    }

    private static Image jswingIconToImage(javax.swing.Icon jswingIcon) {
        BufferedImage bufferedImage = new BufferedImage(jswingIcon.getIconWidth(), jswingIcon.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB);
        jswingIcon.paintIcon(null, bufferedImage.getGraphics(), 0, 0);
        return SwingFXUtils.toFXImage(bufferedImage, null);
    }

	
}
