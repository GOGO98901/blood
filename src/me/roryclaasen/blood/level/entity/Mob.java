package me.roryclaasen.blood.level.entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

import me.roryclaasen.blood.graphics.sprite.Sprite;

public abstract class Mob extends Entity {

	protected Vector2f size;

	protected Sprite sprite;

	public Mob() {
		this(0, 0);
	}

	public Mob(float x, float y) {
		this(x, y, 32, 32);
	}

	public Mob(float x, float y, float width, float height) {
		super(x, y);
		size = new Vector2f(width, height);
	}

	@Override
	public abstract void update(int delta);

	public abstract void render(Graphics g);

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public Vector2f getSize() {
		return size;
	}

	public void setSize(Vector2f size) {
		this.size = size;
	}

	public void setSize(float width, float height) {
		setSize(new Vector2f(width, height));
	}
}
