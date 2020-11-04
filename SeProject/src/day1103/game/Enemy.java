package day1103.game;

import java.awt.Graphics2D;
import java.awt.Image;

public class Enemy extends GameObject{

	public Enemy(Image img, int x, int y, int width, int height, int velX, int velY) {
		super(img, x, y, width, height, velX, velY);
	}
	
	public void tick() {
		//우측끝에서, 좌측으로 이동..
		this.x += this.velX;
	}
	public void render(Graphics2D g2) {
		g2.drawImage(img, x, y, null);
	}

}
