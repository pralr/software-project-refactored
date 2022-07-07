package entities;

abstract class Funcionalities {
	
	protected String name;
	protected String description;

	abstract public void create();
	abstract public void update();
	abstract public boolean get();
	abstract public void delete();
	
}
