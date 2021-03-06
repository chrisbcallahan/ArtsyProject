package cs1302.p2;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;
import java.util.ArrayList;

public class ImageManager
{
    private ArrayList<SimpleObjectProperty<Image>> images;
    private int maxNumOfImages;
    
    ImageManager(int maxNumOfImages)
    {
	this.images = new ArrayList();
	this.maxNumOfImages = maxNumOfImages;
    }

    public Image getImage(int index)
    {
	return images.get(index).getValue();
    }

    public SimpleObjectProperty<Image> getImageProperty(int index)
    {
	return images.get(index);
    }

    public int getNumOfImages()
    {
	return this.images.size();
    }

    public int getMaxNumOfImages()
    {
	return this.maxNumOfImages;
    }

    public void addImage(Image img)
    {
	SimpleObjectProperty<Image> imgProperty = new SimpleObjectProperty<Image>(img);
	images.add(imgProperty);
    }

    public void setImage(Image img, int index)
    {
	this.images.get(index).set(img);
    }
}