package entities;

import java.util.Vector;

import weapons.*;
import armour.*;
import items.*;

public class Player extends Entity{
	
	public Player() {
		this.initilaize();
	}
	
	public void initilaize() {
		xCoordinate = 5;
		yCoordinate = 5;
		
		health = 10;
		displayCharacter = '@';
		weapon = new Fist();
		armour = new Skin();
	}
}
