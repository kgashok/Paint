package com.dovgreenwood.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private Color [][] canvas = new Color [PaintPanel.WIDTH][PaintPanel.HEIGHT];
	
	private ColorPicker colorGetter;
	
	public Canvas(ColorPicker colorGetter) {
		this.colorGetter = colorGetter;
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				putDot(e.getX(), e.getY());
			}
		});
		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				putDot(e.getX(), e.getY());
			}
		});
	}

	private void putDot(int x, int y) {
		try {
			canvas[x][y] = colorGetter.getSelected();
		}
		catch(ArrayIndexOutOfBoundsException e) {
		}
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.WHITE);
		for(int x = 0; x < PaintPanel.WIDTH; x++) {
			for(int y = 0; y < PaintPanel.HEIGHT; y++) {
				if(canvas[x][y] != null) {
					g.setColor(canvas[x][y]);
					g.fillRect(x, y, 5, 5);
				}
			}
		}
	}
	
	public Color[][] getCanvas() {
		return canvas;
	}
	
	public void setCanvas(Color [][] newCanvas) {
		canvas = newCanvas;
	}
	
}
