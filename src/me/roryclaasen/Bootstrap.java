package me.roryclaasen;

import javax.swing.UIManager;

import me.roryclaasen.blood.GameLoop;
import me.roryclaasen.blood.GameMaster;
import net.gogo98901.log.Level;
import net.gogo98901.log.Log;
import net.gogo98901.popup.Dialogs;
import net.gogo98901.util.Data;

public class Bootstrap {

	private static GameMaster master;

	public static void main(String[] args) {
		if (init()) {
			master = new GameMaster();
			if (master.init()) {
				master.start(new GameLoop());
			}
		}
	}

	private static boolean init() {
		try {
			Log.setUseDate(false);
			Log.setSave(true);
			Dialogs.setPrintToConsole(false);
			try {
				Data.setDefultLookAndFeel();
			} catch (Exception e) {
				Log.stackTrace(Level.SEVERE, e);
			}
			Log.info("Look and feel set to " + UIManager.getLookAndFeel());
			Log.info("Program variables set up");

			Log.info("Initialization... Done");
			return true;
		} catch (Exception e) {
			Log.severe("Initialization... Failed");
			Log.stackTrace(Level.SEVERE, e);
			return false;
		}
	}
}
