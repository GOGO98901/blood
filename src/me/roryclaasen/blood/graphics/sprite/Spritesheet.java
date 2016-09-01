package me.roryclaasen.blood.graphics.sprite;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Spritesheet {
	private Image image;
	private boolean failed = false;

	public Spritesheet(String ref) {
		try {
			image = new Image(ref);
		} catch (SlickException e) {
			e.printStackTrace();
			failed = true;
		}
	}

	public Image getImage() {
		return image;
	}

	public Sprite getSprite(int x, int y) {
		return getSprite(x, y, 64, 64);
	}

	public Sprite getSprite(int x, int y, int width, int height) {
		if (failed) return null;
		return new Sprite(image.getSubImage(x, y, width, height));
	}

	public boolean hasFailed() {
		return failed;
	}
}
