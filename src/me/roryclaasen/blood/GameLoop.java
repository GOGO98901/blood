package me.roryclaasen.blood;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import net.gogo98901.log.Log;
import net.roryclaasen.language.LangUtil;

public class GameLoop extends StateBasedGame {
	
	public GameLoop() {
		super(LangUtil.get("game.title"));
		Log.info("Created GameLoop [" + this.getTitle() + "]");
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
	}
}
