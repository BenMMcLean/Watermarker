package com.arctro.watermark;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Watermark {
	public static BufferedImage apply(BufferedImage b, String text, Font f){
		Graphics2D g = b.createGraphics();
		g.setFont(f);
		g.setColor(Color.BLACK);
		
		FontMetrics m = g.getFontMetrics();
		g.fillRect(0, b.getHeight() - m.getHeight(), m.stringWidth(text) + 8, m.getHeight() + 8);
		
		g.setColor(Color.WHITE);
		g.drawString(text, 4, b.getHeight() - (m.getHeight()/4));
		
		g.dispose();
		
		return b;
	}
	
	public static BufferedImage apply(BufferedImage b, String text){
		return apply(b, text, new Font("arial", Font.PLAIN, 20));
	}
}
