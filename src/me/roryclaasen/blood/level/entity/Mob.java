package me.roryclaasen.blood.level.entity;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import me.roryclaasen.blood.graphics.sprite.Sprite;
import me.roryclaasen.blood.level.GameLevel;
import me.roryclaasen.blood.level.Map;

public abstract class Mob extends Entity {

	protected float speed = 1F;

	protected Vector2f size;
	protected float rotation = 0f;;

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

	public void render(int x_off, int y_off, Graphics g) {
		if (sprite != null) {
			Image image = sprite.getImage();
			image.setCenterOfRotation(image.getWidth() / 2, image.getHeight() / 2);
			image.setRotation(rotation);
			g.drawImage(sprite.getImage(), x_off + position.x - (image.getWidth() / 2), y_off + position.y - (image.getHeight() / 2));
		}
	}

	protected void move(float xa, float ya) {
		if (xa == 0 && ya == 0) return;
		Map map = GameLevel.getCurrentMap();
		checkMove(map, xa, 0);
		checkMove(map, 0, ya);
	}

	private void checkMove(Map map, float xa, float ya) {
		float tx = position.x + xa;
		float ty = position.y + ya;
		int offset = Math.max(sprite.getWidth() / 2, sprite.getHeight() / 2);
		Vector2f tilePosition = new Vector2f(Math.round((tx - offset) / 64), Math.round((ty - offset) / 64));
		if (!map.getTile((int) tilePosition.x, (int) tilePosition.y).isSolid()) {
			position.set(tx, ty);
		} else {
			if (this instanceof Projectile) {
				remove();
			}
		}
	}

	public Mob setSprite(Sprite sprite) {
		this.sprite = sprite;
		return this;
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

	public float getDistanceFrom(Entity entity) {
		return getDistanceFrom(entity.position);
	}

	public float getDistanceFrom(Vector2f track) {
		return (float) Math.abs((Math.pow(position.x - track.x, 2) + Math.pow(position.y - track.y, 2)));
	}
}
