package me.roryclaasen.blood;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import me.roryclaasen.blood.graphics.GameCanvas;
import me.roryclaasen.blood.handler.GameHandler;
import net.gogo98901.log.Log;
import net.roryclaasen.language.LangUtil;

public class GameLoop extends StateBasedGame {

	private GameCanvas canvas;

	private GameHandler inputHandlers;

	public GameLoop() {
		super(LangUtil.get("game.title"));
		Log.info("Created GameLoop [" + this.getTitle() + "]");

		canvas = new GameCanvas(this);
		inputHandlers = new GameHandler();
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		inputHandlers.addInputDevices(container);
		canvas.initStates();
	}

	public GameCanvas getCanvas() {
		return canvas;
	}

	public GameHandler getInputHandlers() {
		return inputHandlers;
	}
}
