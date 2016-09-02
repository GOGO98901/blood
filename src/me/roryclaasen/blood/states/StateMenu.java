package me.roryclaasen.blood.states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import me.roryclaasen.blood.GameMaster;
import me.roryclaasen.blood.graphics.FontMannager;
import me.roryclaasen.blood.handler.HandlerKeyboard;
import me.roryclaasen.blood.states.StateMaster.StateNames;
import net.roryclaasen.language.LangUtil;

public class StateMenu extends StateBase {

	private Image logo;
	private float logoScale = 0.8f;

	public StateMenu(StateNames name) {
		super(name);
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		logo = new Image("textures/logo.png", false, Image.FILTER_NEAREST);
	}

	@Override
	public void update(int delta) {
		if (HandlerKeyboard.space) {
			StateMaster.StateNames.GAME.changeTo();
		}
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.setColor(Color.white);
		g.fillRect(0, 0, GameMaster.SIZE.width, GameMaster.SIZE.height);
		g.drawImage(logo.getScaledCopy(logoScale), (GameMaster.SIZE.width - (logo.getWidth() * logoScale)) / 2, (GameMaster.SIZE.height - (logo.getHeight() * logoScale)) / 4);
		g.setColor(Color.black);
		g.setFont(FontMannager.ka1);
		g.drawString(LangUtil.get("game.state.menu"), GameMaster.SIZE.width / 4, ((GameMaster.SIZE.height - (logo.getHeight() * logoScale)) / 4) * 6);
	}
}
