package game;

public abstract class Monster extends Character {

	protected String name;
	protected int hit;
	
	public Monster() {
		
	}

	public String getName(){
		return this.name;
	}

	public int getHit() {
		return this.hit;
	}

}
