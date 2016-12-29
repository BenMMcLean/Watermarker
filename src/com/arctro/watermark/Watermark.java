package com.arctro.watermark;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Adds a text watermark to a provided image
 * @author Ben McLean
 */
public class Watermark {
	/**
	 * Add a text watermark to a provided image, with a specified font
	 * @param b The image to apply the watermark to
	 * @param text The text to add
	 * @param f The font to use
	 * @return The image with a watermark applied
	 */
	public static BufferedImage apply(BufferedImage b, String text, Font f){
		//Init canvas
		Graphics2D g = b.createGraphics();
		//Set the font
		g.setFont(f);
		
		//Set background color
		g.setColor(Color.BLACK);
		
		//Used to calcualte the background size and position
		FontMetrics m = g.getFontMetrics();
		//Draw background with 4px padding
		g.fillRect(0, b.getHeight() - m.getHeight(), m.stringWidth(text) + 8, m.getHeight() + 8);
		
		//Draw text
		g.setColor(Color.WHITE);
		g.drawString(text, 4, b.getHeight() - (m.getHeight()/4));
		
		//Finish
		g.dispose();
		
		//Return watermarked image
		return b;
	}
	
	/**
	 * Add a text watermark to a provided image
	 * @param b The image to apply the watermark to
	 * @param text The text to add
	 * @return The image with a watermark applied
	 */
	public static BufferedImage apply(BufferedImage b, String text){
		//Use arial with 20pt font
		return apply(b, text, new Font("arial", Font.PLAIN, 20));
	}
}
