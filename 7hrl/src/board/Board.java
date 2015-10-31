package board;

import java.io.IOException;
import java.util.LinkedList;

import entities.Entity;
import items.Item;

public class Board {
	Character[][] board;
	LinkedList<Entity> entities;
	LinkedList<Item> items;
	final String operatingSystem = System.getProperty("os.name");
	
	public Board() {
		initialize();
	}
	
	public void initialize(){
		board = new Character[32][32];
		int xPosition = 0;
		int yPosition = 0;
		entities = new LinkedList<Entity>();
		items = new LinkedList<Item>();
		
		for(xPosition = 0; xPosition < board.length; ++xPosition){
			board[xPosition][yPosition] = '-';
		}
		
		yPosition = 31;
		for(xPosition = 0; xPosition < board.length; ++xPosition){
			board[xPosition][yPosition] = '-';
		}
		
		xPosition = 0;
		for(yPosition = 1; yPosition < (board.length - 1); ++yPosition){
			board[xPosition][yPosition] = '|';
		}
		
		xPosition = 31;
		for(yPosition = 1; yPosition < (board.length - 1); ++yPosition){
			board[xPosition][yPosition] = '|';
		}
		
		for(yPosition = 1; yPosition < (board.length - 1); ++yPosition){
			for(xPosition = 1; xPosition < (board[0].length - 1); ++xPosition){
				board[xPosition][yPosition] = ' ';
			}
		}
		
	}
	
	public Character getCharacterAtPosition(int xPosition, int yPosition){
		return board[xPosition][yPosition];
	}
	
	public int addEntity(Entity entity){
		entities.add(entity);
		return (entities.size()-1);
	}
	
	public Entity getEntity(int index) {
		return entities.get(index);
	}

	public void setEntityCoordinates(int index, int xCoordinate, int yCoordinate) {
		board[entities.get(index).getxCoordinate()][entities.get(index).getyCoordinate()] = ' ';
		this.entities.get(index).setxCoordinate(xCoordinate);
		this.entities.get(index).setyCoordinate(yCoordinate);
		board[entities.get(index).getxCoordinate()][entities.get(index).getyCoordinate()] = entities.get(index).getDisplayCharacter();
	}
	
	public int addItem(Item item){
		items.add(item);
		return (items.size()-1);
	}

	public Item getItem(int index) {
		return items.get(index);
	}

	public void setItems(int index, int xCoordinate, int yCoordinate) {
		board[items.get(index).getxCoordinate()][items.get(index).getyCoordinate()] = ' ';
		this.items.get(index).setxCoordinate(xCoordinate);
		this.items.get(index).setyCoordinate(yCoordinate);
		board[items.get(index).getxCoordinate()][items.get(index).getyCoordinate()] = entities.get(index).getDisplayCharacter();
	}

	public void display(){
		try {
		    Thread.sleep(100);
		    clearScreen();
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		for(int yPosition = 0; yPosition < board.length; ++yPosition){
			for(int xPosition = 0; xPosition < board[0].length; ++xPosition){
				System.out.print(getCharacterAtPosition(xPosition, yPosition));
			}
			System.out.print('\n');
		}
	}
	
	private void clearScreen(){
		try{
			if (operatingSystem .contains("Windows")) {
			    Runtime.getRuntime().exec("cls");
			}
			else {
			    Runtime.getRuntime().exec("clear");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		/* for(int yPosition = 0; yPosition < board.length; ++yPosition){
			for(int xPosition = 0; xPosition < board[0].length; ++xPosition){
				System.out.print("\b");
			}
			System.out.print('\n');
		} */
		
		for(int counter = 0; counter < 41; ++counter ){
			System.out.println();
		}
		
	}
	
}
