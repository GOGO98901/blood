package me.roryclaasen.blood.level.entity;

import org.newdawn.slick.geom.Vector2f;

public abstract class Entity {
	protected Vector2f position;

	public Entity() {
		this(0, 0);
	}

	public Entity(float x, float y) {
		this(new Vector2f(x, y));
	}

	public Entity(Vector2f position) {
		this.position = position;
	}

	public abstract void update(int delta);

	public void setPosition(float x, float y) {
		this.setPosition(new Vector2f(x, y));
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}

	public Vector2f getPosition() {
		return position;
	}
}
