package me.roryclaasen.blood.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import me.roryclaasen.blood.GameMaster;

public abstract class StateBase extends BasicGameState {

	protected static final int width, height;
	private final StateMaster.StateNames name;
	static {
		width = GameMaster.SIZE.width;
		height = GameMaster.SIZE.width;
	}

	public StateBase(StateMaster.StateNames name) {
		this.name = name;
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		GameMaster.getLoop().getInputHandlers().keyboard.update();
		update(delta);
	}
	
	public abstract void update(int delta);

	@Override
	public abstract void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException;

	public StateMaster.StateNames getName() {
		return name;
	}

	@Override
	public int getID() {
		return name.ordinal();
	}
}
