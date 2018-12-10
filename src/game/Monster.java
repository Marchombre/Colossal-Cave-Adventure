package game;
/**
 * <b>Monster is an abstract class that extends Character and represents a monster that will face the hero.</b>
 * <p>
 * A monster is characterized by the following informations:
 * <ul>
 * <li> A name that is not alterable.</li>
 * <li> damages that the monster inflicts to the player.<li>
 * @author azazga media
 *@version 1.0
 */
public abstract class Monster extends Character {
/**
 * The name of the monster.
 * @see Monster#getName()
 */
	protected String name;
	/**
	 * The damages inflicted by the player.
	 * @see Monster#getDamages()
	 */
	protected int damages;
	/**
	 * The constructor of the monster
	 * <p>At the construction of a monster the attribute alive is set to true</p>
	 */
	public Monster() {
		this.alive = true;
	}
/**
 * Returns the name of the monster
 * @return the name of the monster as a string
 */
	public String getName(){
		return this.name;
	}
/**
 * Returns the damages that the monster inflicts
 * @return the damages as an integer
 */
	public int getDamages() {
		return this.damages;
	}

}
