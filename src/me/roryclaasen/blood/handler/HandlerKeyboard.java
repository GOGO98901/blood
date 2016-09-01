package me.roryclaasen.blood.handler;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public class HandlerKeyboard implements KeyListener {

	private static boolean[] keys = new boolean[250];

	public static boolean grave, esc, F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12;
	public static boolean no1, no2, no3, no4, no5, no6, no7, no8, no9, no0;
	public static boolean q, w, e, r, t, y, u, i, o, p;
	public static boolean a, s, d, f, g, h, j, k, l;
	public static boolean z, x, c, v, b, n, m;
	public static boolean arrowUp, arrowDown, arrowLeft, arrowRight;
	public static boolean ctrl, alt, space;

	public void update() {
		grave = keys[Input.KEY_GRAVE];
		esc = keys[Input.KEY_ESCAPE];
		F1 = keys[Input.KEY_F1];
		F2 = keys[Input.KEY_F2];
		F3 = keys[Input.KEY_F3];
		F4 = keys[Input.KEY_F4];
		F5 = keys[Input.KEY_F5];
		F6 = keys[Input.KEY_F6];
		F7 = keys[Input.KEY_F7];
		F8 = keys[Input.KEY_F8];
		F9 = keys[Input.KEY_F9];
		F10 = keys[Input.KEY_F10];
		F11 = keys[Input.KEY_F11];
		F12 = keys[Input.KEY_F12];

		no0 = keys[Input.KEY_0];
		no1 = keys[Input.KEY_1];
		no2 = keys[Input.KEY_2];
		no3 = keys[Input.KEY_3];
		no4 = keys[Input.KEY_4];
		no5 = keys[Input.KEY_5];
		no6 = keys[Input.KEY_6];
		no7 = keys[Input.KEY_7];
		no8 = keys[Input.KEY_8];
		no9 = keys[Input.KEY_9];

		q = keys[Input.KEY_Q];
		w = keys[Input.KEY_W];
		e = keys[Input.KEY_E];
		r = keys[Input.KEY_R];
		t = keys[Input.KEY_T];
		y = keys[Input.KEY_Y];
		u = keys[Input.KEY_U];
		i = keys[Input.KEY_I];
		o = keys[Input.KEY_O];
		p = keys[Input.KEY_P];

		a = keys[Input.KEY_A];
		s = keys[Input.KEY_S];
		d = keys[Input.KEY_D];
		f = keys[Input.KEY_F];
		g = keys[Input.KEY_G];
		h = keys[Input.KEY_H];
		j = keys[Input.KEY_J];
		k = keys[Input.KEY_K];
		l = keys[Input.KEY_L];
		z = keys[Input.KEY_Z];
		x = keys[Input.KEY_X];
		c = keys[Input.KEY_C];
		v = keys[Input.KEY_V];
		b = keys[Input.KEY_B];
		n = keys[Input.KEY_N];
		m = keys[Input.KEY_M];

		arrowUp = keys[Input.KEY_UP];
		arrowDown = keys[Input.KEY_DOWN];
		arrowLeft = keys[Input.KEY_LEFT];
		arrowRight = keys[Input.KEY_RIGHT];

		ctrl = keys[Input.KEY_LCONTROL] || keys[Input.KEY_RCONTROL];
		alt = keys[Input.KEY_LALT] || keys[Input.KEY_RALT];
		space = keys[Input.KEY_SPACE];
	}

	/**
	 * NOTE: This will only return true if supported in HandlerKeyboard
	 * 
	 * @param code
	 *        - Key code
	 * @return if it is pressed
	 */
	public static boolean get(int code) {
		if (code < 0 && code > keys.length) return false;
		return keys[code];
	}

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
	public void keyPressed(int key, char c) {
		try {
			keys[key] = true;
		} catch (Exception e) {
			// java.lang.ArrayIndexOutOfBoundsException
			// Log.stackTrace(e);
		}
	}

	@Override
	public void keyReleased(int key, char c) {
		try {
			keys[key] = false;
		} catch (Exception e) {
			// java.lang.ArrayIndexOutOfBoundsException
			// Log.stackTrace(e);
		}
	}
}
