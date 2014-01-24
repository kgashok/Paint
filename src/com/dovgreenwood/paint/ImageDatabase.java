package com.dovgreenwood.paint;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ImageDatabase {

	public static void save(Color [][] canvas) {
		String file = JOptionPane.showInputDialog("File to save to . . . (no extension)");
		try {
			ObjectOutputStream out = new ObjectOutputStream(
									 new BufferedOutputStream(
									 new FileOutputStream(file + ".dat")));
			out.writeObject(canvas);
			out.flush();
			out.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "There was an error while saving the image.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static Color [][] load() {
		Color [][] canvas = new Color [PaintPanel.WIDTH][PaintPanel.HEIGHT];
		String file = JOptionPane.showInputDialog("File to save to . . . (no extension)");
		try {
			ObjectInputStream in = new ObjectInputStream(
									 new BufferedInputStream(
									 new FileInputStream(file + ".dat")));
			canvas = (Color[][]) in.readObject();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error: file does not exist", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return canvas;
	}
	
	public static JPanel savePanel(final Canvas c) {
		JPanel rVal = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton save = new JButton("SAVE");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save(c.getCanvas());
			}
		});
		JButton load = new JButton("LOAD");
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.setCanvas(load());
				c.repaint();
			}
		});
		rVal.add(save);
		rVal.add(load);
		return rVal;
	}

}
