package cs1302.p2;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.image.Image;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
    
public class OpenMenu extends Menu
{
    private MenuItem open1 = new MenuItem ("Open Image 1");
    private MenuItem open2 = new MenuItem ("Open Image 2");
    private ImageManager imgManager;

    public OpenMenu(ImageManager imgManager)
    {
	super("Open");

	this.imgManager = imgManager;

	//Add open2 later.
	getItems().add(open1);
	getItems().add(open2);

	open1.setOnAction(event -> open(0));
	open2.setOnAction(event -> open(1));
    } // OpenMenu()

    private void open(int index)
    {
	FileChooser fileChooser = new FileChooser();
	ExtensionFilter imgFilter = new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.bmp");

	fileChooser.setTitle("Open Image File");
	fileChooser.getExtensionFilters().add(imgFilter);

	File selectedFile = fileChooser.showOpenDialog(null); //TODO - Pass stage from Driver.

	/* Tests the following conditions
	 * 1. File isn't null (it exists)
	 * 2. We have permission to read the selected file. 
	 */
	if (selectedFile != null &&
	    selectedFile.canRead())
	{
	    try {
		FileInputStream imgIS = new FileInputStream(selectedFile);
		Image loadedImg = new Image(imgIS);
		imgManager.setImage(loadedImg, index);
	    } catch (FileNotFoundException e) {

	    }
	}
    } // Open()
} // OpenMenu