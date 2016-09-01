package me.roryclaasen.blood.level.entity;

public class Enemy extends Mob {
	
	public Enemy() {
		super(100, 100);
	}

	@Override
	public void update(int delta) {

	}

	public void setAngleToTarget(Entity entity) {
		rotation = (float) Math.toDegrees(Math.atan2((entity.position.x - (position.y)), (entity.position.y - (position.x))));
	}
}
