package me.roryclaasen.blood.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import me.roryclaasen.blood.states.StateMaster.StateNames;

public class StateMenu extends StateBase {

	public StateMenu(StateNames name) {
		super(name);
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {}

	@Override
	public void update(int delta) {}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.setColor(Color.white);
		g.fillRect(10, 10, 500, 500);
	}
}
