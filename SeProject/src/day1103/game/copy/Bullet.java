package day1103.game.copy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public class Bullet extends GameObject{
	GamePanel gamePanel;
	
	public Bullet(GamePanel gamePanel, Image img, int x, int y, int width, int height, int velX, int velY) {
		super(img, x, y, width, height, velX, velY);
		this.gamePanel = gamePanel;
	}

	//총알에 알맞는 물리량변화 코드 작성
	public void tick() {
		this.x+=this.velX;
		this.rect.x=x;
		this.rect.y=y;
		
		//화면밖으로 나가면, 화살을  BulletArray에서 제거해야, 그려질 대상이 되지 않음..
		//또한 BulletArray의 크기를 줄여놓아야, 추후 충돌검사시 반복문의 횟수를 줄일 수 있음..
		if(this.x > GamePanel.WIDTH) {
			gamePanel.bulletList.remove(this);//나를 리스트에서 지워주세요~~
		}
		
		//총알 충돌 검사
		collisionCheck();
	}
	
	public void collisionCheck() {
		for(int i=0;i<gamePanel.enemyList.size();i++) {
			Enemy enemy=gamePanel.enemyList.get(i);
			if(this.rect.intersects(enemy.rect)) {
				System.out.println("충돌 발견!!");
				gamePanel.bulletList.remove(this);//나를 리스트에서 지워주세요~~
				gamePanel.enemyList.remove(enemy);
			}
		}
	}
	
	
	//총알에 맞는 그래픽 처리..
	public void render(Graphics2D g2) {
		g2.drawRect(rect.x, rect.y, rect.width, rect.height);
		g2.drawImage(img, x, y, null);
	}
}







