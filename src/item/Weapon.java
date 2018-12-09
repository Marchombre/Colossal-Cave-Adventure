package item;

public abstract class Weapon extends Item {

	int damages;

	public Weapon() {
		super();
	}

	public int getDamages() {
		return this.damages;
	}

	public void use(){}

}
