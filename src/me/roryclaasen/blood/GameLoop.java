package me.roryclaasen.blood;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import me.roryclaasen.blood.graphics.GameCanvas;
import net.gogo98901.log.Log;
import net.roryclaasen.language.LangUtil;

public class GameLoop extends StateBasedGame {

	private GameCanvas canvas;

	public GameLoop() {
		super(LangUtil.get("game.title"));
		Log.info("Created GameLoop [" + this.getTitle() + "]");

		canvas = new GameCanvas(this);
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		canvas.initStates();
	}

	public GameCanvas getCanvas() {
		return canvas;
	}
}
