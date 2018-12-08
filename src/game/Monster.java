package game;

public abstract class Monster extends Character {

	protected String name;
	protected int damages;
	
	public Monster() {
		this.alive = true;
	}

	public String getName(){
		return this.name;
	}

	public int getDamages() {
		return this.damages;
	}

}
