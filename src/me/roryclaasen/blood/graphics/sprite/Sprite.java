package me.roryclaasen.blood.graphics.sprite;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Sprite {
	private Image image;
	private boolean failed = false;

	public Sprite(String ref) {
		try {
			image = new Image(ref);
		} catch (SlickException e) {
			e.printStackTrace();
			failed = true;
		}
	}

	public Sprite(Image image) {
		this.image = image;
	}

	public Image getImage() {
		return image;
	}

	public boolean hasFailed() {
		return failed;
	}

	public int getWidth() {
		return image.getWidth();
	}

	public int getHeight() {
		return image.getHeight();
	}
}
