package me.roryclaasen.blood.graphics;

import java.awt.FontFormatException;
import java.io.IOException;

import org.newdawn.slick.TrueTypeFont;

import net.gogo98901.log.Log;

public class FontMannager {
	public static TrueTypeFont spaceman = loadFont("font/SPACEMAN.ttf");

	private static TrueTypeFont loadFont(String ref) {
		Log.info("loading font '" + ref + "'");
		try {
			java.awt.Font javaFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, org.newdawn.slick.util.ResourceLoader.getResourceAsStream(ref));
			javaFont.deriveFont(50F);
			return new TrueTypeFont(javaFont, false);
		} catch (FontFormatException | IOException e) {
			Log.warn("failed to load font '" + ref + "'");
		}
		return null;
	}
}
