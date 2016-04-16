package filters;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import main.ReadCreateImage;

public class Grayscale implements ActionListener {

	private String nameNewImage = null;
	private BufferedImage currentImage = null;
	ReadCreateImage image  = new ReadCreateImage();
	private int red;
	private int green;
	private int blue;
	private int rgb;
	private int newRed;
	private int newGreen;
	private int newBlue;
	
	
	public Grayscale(File fNova) {
		currentImage = image.readImage(fNova);
	}

	public void actionPerformed(ActionEvent e) {
		nameNewImage = "src/images/Grayscale.jpg";

		for (int y = 0; y < currentImage.getHeight(); y++) {
			for (int x = 0; x < currentImage.getWidth(); x++) {

				rgb = currentImage.getRGB(x, y);

				red = new Color(currentImage.getRGB(x, y)).getRed();
				green = new Color(currentImage.getRGB(x, y)).getGreen();
				blue = new Color(currentImage.getRGB(x, y)).getBlue();

				newRed = (int) (0.3 * red + 0.59 * green + 0.11 * blue);
				newGreen = (int) (0.3 * red + 0.59 * green + 0.11 * blue);
				newBlue = (int) (0.3 * red + 0.59 * green + 0.11 * blue);
				
				rgb = (newRed << 16) | (newGreen << 8) | newBlue;

				currentImage.setRGB(x, y, rgb);
			}
		}

		image.createNewImage(nameNewImage, currentImage);
	}
}
