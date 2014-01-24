package com.dovgreenwood.paint;

import javax.swing.JFrame;

public class Entry extends JFrame {

	public Entry() {
		setSize(PaintPanel.WIDTH, PaintPanel.HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Paint");
		add(new PaintPanel());
		setVisible(true);
	}
	
	public static void main(String [] args) {
		Entry e = new Entry();
	}
}
