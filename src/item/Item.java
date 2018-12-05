package item;

public abstract class Item {

    protected String name;

	public String getName(){
	    return this.name;
    }

    protected abstract void use();
}
