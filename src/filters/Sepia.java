package filters;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import main.ReadCreateImage;

public class Sepia implements ActionListener {

	private String nameNewImage = null;
	private BufferedImage currentImage = null;
	ReadCreateImage image = new ReadCreateImage();
	private int rgb;
	private int red;
	private int green;
	private int blue;
	private int interimRed;
	private int interimGreen;
	private int interimBlue;

	public Sepia(File fNova) {
		currentImage = image.readImage(fNova);
	}

	public void actionPerformed(ActionEvent e) {
		nameNewImage = "src/images/Sepia.jpg";

		for (int x = 0; x < currentImage.getWidth(); x++) {
			for (int y = 0; y < currentImage.getHeight(); y++) {

				rgb = currentImage.getRGB(x, y);

				red = new Color(currentImage.getRGB(x, y)).getRed();
				green = new Color(currentImage.getRGB(x, y)).getGreen();
				blue = new Color(currentImage.getRGB(x, y)).getBlue();

				interimRed = (int) (0.393 * red + 0.769 * green + 0.189 * blue);
				interimGreen = (int) (0.349 * red + 0.686 * green + 0.168 * blue);
				interimBlue = (int) (0.272 * red + 0.534 * green + 0.131 * blue);

				if (interimRed > 255) {
					red = 255;
				} else {
					red = interimRed;
				}

				if (interimGreen > 255) {
					green = 255;
				} else {
					green = interimGreen;
				}

				if (interimBlue > 255) {
					blue = 255;
				} else {
					blue = interimBlue;
				}

				rgb = (red << 16) | (green << 8) | blue;

				currentImage.setRGB(x, y, rgb);
			}
		}

		image.createNewImage(nameNewImage, currentImage);
	}
}
