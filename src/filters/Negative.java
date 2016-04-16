package filters;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import main.ReadCreateImage;

public class Negative implements ActionListener {
	
	private BufferedImage currentImage = null;
	private String nameNewImage = null;
	ReadCreateImage image  = new ReadCreateImage();
	private int rgb;
	
	public Negative(File fNova) {
		currentImage = image.readImage(fNova);
	}

	public void actionPerformed(ActionEvent e) {
		nameNewImage = "src/images/Negative.jpg";

		for (int x = 0; x < currentImage.getWidth(); x++) {
			for (int y = 0; y < currentImage.getHeight(); y++) {
				rgb = currentImage.getRGB(x, y);
				Color color = new Color(rgb, true);
				color = new Color(255 - color.getRed(), 255 - color.getGreen(),	255 - color.getBlue());
				currentImage.setRGB(x, y, color.getRGB());	
			}
		}
		image.createNewImage(nameNewImage, currentImage);
	}
}
