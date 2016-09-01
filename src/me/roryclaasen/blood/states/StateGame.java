package me.roryclaasen.blood.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import me.roryclaasen.blood.level.GameLevel;
import me.roryclaasen.blood.states.StateMaster.StateNames;

public class StateGame extends StateBase {

	private GameLevel level;

	public StateGame(StateNames name) {
		super(name);
		newLevel();
	}

	public void newLevel() {
		level = null;
		level = new GameLevel();
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		level.init();
	}

	@Override
	public void update(int delta) {
		level.update(delta);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		level.render(g);
	}
}
