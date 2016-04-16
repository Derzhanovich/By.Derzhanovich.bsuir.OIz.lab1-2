package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ReadCreateImage {

	String nameNewImage = null;
	File fResult = null;
	BufferedImage rImage = null;
	JFrame frame = new JFrame();

	public File createNewImage(String nameNewImage, BufferedImage resultImage) {
		try {
			fResult = new File(nameNewImage);
			ImageIO.write(resultImage, "jpg", fResult);
			JOptionPane.showMessageDialog(frame, "Файл успешно создан." + "\n"
					+ nameNewImage);
		} catch (IOException e) {
			System.out.println(e);
		}

		return fResult;
	}

	public BufferedImage readImage(File f) {
		try {
			rImage = ImageIO.read(f);
		} catch (IOException e) {
			System.out.println(e);
		}
		return rImage;
	}
}
