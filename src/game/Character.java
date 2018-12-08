package game;

public abstract class Character {

	protected int life;
	protected boolean alive;

	public void beHit(int h) {this.life = this.life - h;}
	
	public int getLife() {return this.life;}

	public boolean isAlive(){return this.alive;}

	public void die(){this.alive = false;}
}
