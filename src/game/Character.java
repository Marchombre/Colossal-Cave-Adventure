package game;
/**
 * <b>Character is an abstract class that represents any type character in the game.</b>
 *  <p>
 *  A character is characterized by the following informations:
 *  <ul>
 *  <li>An attribute life which is alterable and shows how much life the character has left.</li>
 *  <li> An attribute alive which is alterable tells if the player is still alive or not.</li>
 *  </ul>
 *  </p>
 *  @author azazga media
 *  @version 1.0
  */
public abstract class Character {
/**
 * How much life the character has left. This attribute is alterable.
 * @see Character#getLife()
 * @see Character#beHit(int)
 */
	protected int life;
	/**
	 * Tells if the character is still alive or not. This attribute is alterable.
	 * @see Character#isAlive()
	 * @see Character#die()
	 */
	protected boolean alive;
/**
 * subtract life from the character
 * @param h
 * how much life is subtracted from the character
 */
	public void beHit(int h) {this.life = this.life - h;}
	/**
	 * Returns the life of the character
	 * @return the life of the character as in integer
	 */
	public int getLife() {return this.life;}
	/**
	 * says if the character is still alive
	 * @return a boolean that says if the character is still alive
	 */
	public boolean isAlive(){return this.alive;}
/**
 * kills the character
 */
	public void die(){this.alive = false;}
}
