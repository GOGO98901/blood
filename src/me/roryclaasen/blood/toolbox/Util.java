package me.roryclaasen.blood.toolbox;

public class Util {

	private Util() {}

	public static int abs(double value) {
		if (value == 0) return 0;
		if (value > 1) return 1;
		return -1;
	}
}
