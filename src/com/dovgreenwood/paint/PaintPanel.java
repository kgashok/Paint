package com.dovgreenwood.paint;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {

	public final static int HEIGHT = 500;
	public final static int WIDTH = 500;
	
	public PaintPanel() {
		this.setLayout(new BorderLayout());
		ColorPicker p = new ColorPicker();
		final Canvas c = new Canvas(p);
		add(p, BorderLayout.NORTH);
		add(c, BorderLayout.CENTER);
		JPanel savePanel = ImageDatabase.savePanel(c);
		add(savePanel, BorderLayout.SOUTH);
	}
	
}
