package entities;

import java.util.Random;

import weapons.Fist;
import armour.Skin;


public class Enemy extends Entity{
	
	
	public Enemy() {
		this.initilaize();
	}
	
	public void initilaize() {
		Random randomGenerator = new Random();
		
		int randomInt = randomGenerator.nextInt(29) + 1;
		xCoordinate = randomInt;
		randomInt = randomGenerator.nextInt(29) + 1;
		yCoordinate = randomInt;
		
		health = 10;
		displayCharacter = 'X';
		weapon = new Fist();
		armour = new Skin();
	}
	
}
