package item;
/**
 *<b>Item is an abstract class that represents an item in the game.</b>
 *<p>
 *It is characterized by:
 *<ul>
 *<li> a Name </li>
 *</ul>
 * @author azazga media
 *
 */
public abstract class Item {
/**
 *The name of the Item
 */
    protected String name;
/**
 * Returns the name of the item
 * @return The name of the item as a string
 */
	public String getName(){
	    return this.name;
    }

}
