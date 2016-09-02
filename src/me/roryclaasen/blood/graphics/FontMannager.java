package me.roryclaasen.blood.graphics;

import java.awt.FontFormatException;
import java.io.IOException;

import org.newdawn.slick.TrueTypeFont;

import net.gogo98901.log.Log;

public class FontMannager {
	public static TrueTypeFont spaceman, ka1;

	public static void load() {
		ka1 = loadFont("font/ka1.ttf", 25F);
		//spaceman = loadFont("font/SPACEMAN.ttf", 50F);
	}

	private static TrueTypeFont loadFont(String ref, float size) {
		Log.info("loading font '" + ref + "'");
		try {
			java.awt.Font javaFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, org.newdawn.slick.util.ResourceLoader.getResourceAsStream(ref));
			return new TrueTypeFont(javaFont.deriveFont(size), false);
		} catch (FontFormatException | IOException e) {
			Log.warn("failed to load font '" + ref + "'");
		}
		return null;
	}
}
