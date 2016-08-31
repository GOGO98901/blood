package me.roryclaasen.blood.graphics;

import me.roryclaasen.blood.GameLoop;
import me.roryclaasen.blood.states.StateMaster;

public class GameCanvas {

	private StateMaster states;

	public GameCanvas(GameLoop gameLoop) {
		states = new StateMaster(gameLoop);
	}

	public void initStates() {
		states.init();
	}

	public StateMaster getStateMaster() {
		return states;
	}
}
