package me.roryclaasen.blood;

import java.awt.Dimension;
import java.io.IOException;

import org.newdawn.slick.SlickException;

import me.roryclaasen.blood.graphics.DisplayMaster;
import net.gogo98901.log.Log;
import net.roryclaasen.language.LangUtil;
import net.roryclaasen.language.LanguageFile;

public class GameMaster {
	public final static Dimension SIZE = new Dimension(800, 500);
	private GameMaster master;
	private GameLoop loop;

	private DisplayMaster display;

	public GameMaster() {
		master = this;
	}

	public boolean init() {
		try {
			Log.info("Setting language file");
			LanguageFile enUK = new LanguageFile("lang/EN_UK.lang");
			LangUtil.setLanguageFileAndRead(enUK);

			display = new DisplayMaster(SIZE.width, SIZE.height);
			return true;
		} catch (IOException e) {
			Log.stackTrace(e);
			return false;
		}
	}

	public void start(GameLoop loop) {
		try {
			this.loop = loop;
			display.create(loop);
			display.start();
		} catch (SlickException e) {
			Log.stackTrace(e);
		}
	}
}
