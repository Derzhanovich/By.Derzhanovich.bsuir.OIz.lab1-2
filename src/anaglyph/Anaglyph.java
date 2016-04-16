package anaglyph;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import main.ReadCreateImage;

public class Anaglyph implements ActionListener {

	private String nameNewImage = null;
	private BufferedImage leftImage = null;
	private BufferedImage rightImage = null;
	private BufferedImage anaglyphImage = null;
	private int red;
	private int green;
	private int blue;
	private int rgb;
	ReadCreateImage image = new ReadCreateImage();

	public Anaglyph(File fLeft, File fRight) {
		leftImage = image.readImage(fLeft);
		rightImage = image.readImage(fRight);
	}

	public void actionPerformed(ActionEvent e) {
		nameNewImage = "src/images/Anaglyph.jpg";

		anaglyphImage = new BufferedImage(leftImage.getWidth(),
				leftImage.getHeight(), BufferedImage.TYPE_INT_BGR);

		for (int x = 0; x < anaglyphImage.getWidth(); x++) {
			for (int y = 0; y < anaglyphImage.getHeight(); y++) {

				Color colorLeft = new Color(leftImage.getRGB(x, y));
				Color colorRight = new Color(rightImage.getRGB(x, y));

				red = colorLeft.getRed();
				green = colorRight.getGreen();
				blue = colorRight.getBlue();

				rgb = (red << 16) | (green << 8) | blue;

				anaglyphImage.setRGB(x, y, rgb);
			}
		}
		image.createNewImage(nameNewImage, anaglyphImage);
	}
}
