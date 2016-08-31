package me.roryclaasen.blood.graphics.sprite;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Sprite {
	private Image image;
	private boolean failed = false;;

	public Sprite(String ref) {
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

	public boolean isFailed() {
		return failed;
	}
}
