package main;

import java.awt.Color;
import java.io.File;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import anaglyph.Anaglyph;
import filters.Grayscale;
import filters.Negative;
import filters.Sepia;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel buttonPanel;
	private JButton anaglyphButton;
	private JButton negativeButton;
	private JButton grayscaleButton;
	private JButton sepiaButton;
	private Box boxFilters;

	File fLeft = new File("src/images/11.jpg");
	File fRight = new File("src/images/22.jpg");

	Frame() {
		anaglyphButton = new JButton("Анаглиф");
		negativeButton = new JButton("Негатив");
		grayscaleButton = new JButton("Черно-белое");
		sepiaButton = new JButton("Сепия");

		buttonPanel = new JPanel();

		boxFilters = Box.createVerticalBox();
		boxFilters.setBorder(new TitledBorder("Фильтры"));

		boxFilters.add(negativeButton);
		boxFilters.add(grayscaleButton);
		boxFilters.add(sepiaButton);

		buttonPanel.setBackground(Color.WHITE);

		buttonPanel.add(anaglyphButton);
		buttonPanel.add(boxFilters);

		add(buttonPanel);

		anaglyphButton.addActionListener(new Anaglyph(fLeft, fRight));
		negativeButton.addActionListener(new Negative(fLeft));
		grayscaleButton.addActionListener(new Grayscale(fLeft));
		sepiaButton.addActionListener(new Sepia(fLeft));
	}
}