package weapons;

public abstract class Weapon {
	
	int damage = 1;

	public int getDamage() {
		return damage;
	}

	protected void setDamage(int damage) {
		this.damage = damage;
	}
	
}
