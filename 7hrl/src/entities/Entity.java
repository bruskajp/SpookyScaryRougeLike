package entities;

import java.util.Vector;

import weapons.Fist;
import weapons.Weapon;
import armour.Armour;
import armour.Skin;
import items.Item;

public class Entity{
	int xCoordinate;
	int yCoordinate;
	int health;
	Character displayCharacter;
	Weapon weapon;
	Armour armour;
	Vector<Item> inventory;
	
	public Entity() {
		this.initilaize();
	}
	
	public void initilaize() {
		xCoordinate = 0;
		yCoordinate = 0;
		health = 10;
		displayCharacter = '!';
		weapon = new Fist();
		armour = new Skin();
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public Character getDisplayCharacter() {
		return displayCharacter;
	}
	
	public void setCoordinates(int xCoordinate, int yCoordinate){
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
}
