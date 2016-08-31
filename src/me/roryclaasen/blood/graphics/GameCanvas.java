package me.roryclaasen.blood.graphics;

import me.roryclaasen.blood.GameLoop;
import me.roryclaasen.blood.states.StateMaster;
import me.roryclaasen.blood.states.StateMaster.StateNames;

public class GameCanvas {

	private StateMaster states;

	public GameCanvas(GameLoop gameLoop) {
		states = new StateMaster(gameLoop);
	}

	public void initStates() {
		states.init();
		
		states.changeTo(StateNames.GAME); // TODO Make a menu!
	}

	public StateMaster getStateMaster() {
		return states;
	}
}
