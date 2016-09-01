package me.roryclaasen.blood.level.entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

import me.roryclaasen.blood.graphics.sprite.Sprite;
import me.roryclaasen.blood.level.GameLevel;
import me.roryclaasen.blood.level.Map;

public abstract class Mob extends Entity {

	protected float speed = 1F;

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

	protected void move(float xa, float ya) {
		if (xa == 0 && ya == 0) return;
		Map map = GameLevel.getCurrentMap();
		checkMove(map, xa, 0);
		checkMove(map, 0, ya);
	}

	private void checkMove(Map map, float xa, float ya) {
		float tx = position.x + xa;
		float ty = position.y + ya;
		if (!map.getTile((int) Math.round(tx / 64), (int) Math.round(ty / 64)).isSolid()) {
			position.set(tx, ty);
		}
	}

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

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
}
