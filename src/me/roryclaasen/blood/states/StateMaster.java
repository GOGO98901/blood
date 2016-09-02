package me.roryclaasen.blood.states;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import me.roryclaasen.blood.GameLoop;
import me.roryclaasen.blood.GameMaster;
import me.roryclaasen.blood.graphics.FontMannager;
import net.gogo98901.log.Log;

public class StateMaster {
	private GameLoop gameLoop;

	public enum StateNames {
		MENU, GAME;

		public void changeTo() {
			GameMaster.getLoop().getCanvas().getStateMaster().changeTo(this);
		}
	}

	private Map<StateNames, StateBase> states = new HashMap<StateNames, StateBase>();

	private StateNames current;

	public StateMaster(GameLoop gameLoop) {
		this.gameLoop = gameLoop;

		states.put(StateNames.MENU, new StateMenu(StateNames.MENU));
		states.put(StateNames.GAME, new StateGame(StateNames.GAME));
	}

	public void changeTo(StateNames name) {
		if (states.containsKey(name)) {
			Log.info("Changing state to " + name);
			current = name;
			gameLoop.enterState(name.ordinal(), new FadeOutTransition(), new FadeInTransition());
		} else {
			Log.warn("No states has been added with the key '" + name + "'");
		}
	}

	public void init() {
		Iterator<StateBase> list = states.values().iterator();
		while (list.hasNext()) {
			StateBase state = list.next();
			Log.info("Adding state " + state.getName());
			gameLoop.addState(state);
		}
		gameLoop.enterState(StateNames.MENU.ordinal());
		FontMannager.load();
	}

	public StateNames getCurrent() {
		return current;
	}
}
