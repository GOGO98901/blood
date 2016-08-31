package me.roryclaasen.blood.graphics;

import java.awt.Dimension;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import me.roryclaasen.blood.GameLoop;

public class DisplayMaster {
	private AppGameContainer container;
	private final Dimension size;

	public DisplayMaster(int width, int height) {
		this.size = new Dimension(width, height);
	}

	public void create(GameLoop gameloop) throws SlickException {
		container = new AppGameContainer(gameloop);
		container.setDisplayMode(size.width, size.height, false);
	}

	public void start() throws SlickException {
		container.start();
	}
}
