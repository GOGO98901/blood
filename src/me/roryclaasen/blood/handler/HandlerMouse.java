package me.roryclaasen.blood.handler;

import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;

import me.roryclaasen.blood.toolbox.Util;

public class HandlerMouse implements MouseListener {

	public static final int BTN_LEFT = 0;
	public static final int BTN_WHEEL = 2;
	public static final int BTN_RIGHT = 1;
	public static final int BTN_MOUSE3 = 3;
	public static final int BTN_MOUSE4 = 4;

	private static int x, y;
	private static int button = -1;
	private static int wheel;

	protected HandlerMouse() {}

	@Override
	public void setInput(Input input) {}

	@Override
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	public void inputEnded() {}

	@Override
	public void inputStarted() {}

	@Override
	public void mouseWheelMoved(int change) {
		wheel += change;
		@SuppressWarnings("unused")
		int steps = Util.abs(change);
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {}

	@Override
	public void mousePressed(int button, int x, int y) {
		HandlerMouse.button = button;
	}

	@Override
	public void mouseReleased(int button, int x, int y) {
		HandlerMouse.button = -1;
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		x = newx;
		y = newy;
	}

	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
		x = newx;
		y = newy;
	}

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}

	public static int getButton() {
		return button;
	}

	public static int getWheel() {
		return wheel;
	}
}
