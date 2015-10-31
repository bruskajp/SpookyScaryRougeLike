package armour;

public abstract class Armour {
	
	int damageReduction = 0;

	public int getDamageReduction() {
		return damageReduction;
	}

	protected void setDamageReduction(int damageReduction) {
		this.damageReduction = damageReduction;
	}
	
}
