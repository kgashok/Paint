package com.dovgreenwood.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class ColorPicker extends JPanel {

	private Color [] colors = {
		Color.RED,
		Color.BLACK,
		Color.BLUE,
		Color.WHITE,
		Color.ORANGE,
		Color.YELLOW,
		Color.PINK,
		Color.CYAN
	};
	
	int index = 0;
	
	public ColorPicker() {
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				index = e.getX() / (PaintPanel.WIDTH / colors.length);
				repaint();
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < colors.length; i++) {
			g.setColor(colors[i]);
			g.fillRect(i * (PaintPanel.WIDTH/colors.length), 0, PaintPanel.WIDTH/colors.length, 100);
			g.setColor(Color.BLACK);
			g.drawRect(i * (PaintPanel.WIDTH/colors.length), 0, PaintPanel.WIDTH/colors.length, 100);
		}
		g.setColor(Color.GRAY);
		g.drawRect(index * (PaintPanel.WIDTH/colors.length), 0, PaintPanel.WIDTH/colors.length, 100);
	}
	
	public Color getSelected() {
		return colors[index];
	}
	
}
