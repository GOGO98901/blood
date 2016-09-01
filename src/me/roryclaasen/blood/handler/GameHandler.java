package me.roryclaasen.blood.handler;

import org.newdawn.slick.GameContainer;

public class GameHandler {
	public HandlerKeyboard keyboard;
	public HandlerMouse mouse;

	public GameHandler() {
		keyboard = new HandlerKeyboard();
		mouse = new HandlerMouse();
	}

	public void addInputDevices(GameContainer container) {
		container.getInput().addKeyListener(keyboard);
		container.getInput().addMouseListener(mouse);

	}
}
