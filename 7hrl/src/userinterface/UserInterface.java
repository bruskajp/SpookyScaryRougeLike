package userinterface;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import entities.*;

import board.Board;

public class UserInterface {
	public void begin(){
		Board board = new Board();
		Scanner scanner = new Scanner(System.in);
		Character command = ' ';
		int playerIndex;
		playerIndex = board.addEntity(new Player());
		board.setEntityCoordinates(playerIndex, board.getEntity(playerIndex).getyCoordinate(), board.getEntity(playerIndex).getxCoordinate());
		
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(4) + 1;
		LinkedList<Integer> enemyIndexes = new LinkedList<Integer>();
		for(int index = 0; index < randomInt; ++index){
			enemyIndexes.add(board.addEntity(new Enemy()));
			for(int index2 = 0; index2 < enemyIndexes.size() - 1; ++index2){
				while((board.getEntity(enemyIndexes.get(index)).getxCoordinate() == board.getEntity(enemyIndexes.get(index2)).getxCoordinate()) 
						|| (board.getEntity(enemyIndexes.get(index)).getyCoordinate() == board.getEntity(enemyIndexes.get(index2)).getyCoordinate())
						|| (board.getEntity(enemyIndexes.get(index)).getxCoordinate() == board.getEntity(playerIndex).getxCoordinate())
						|| (board.getEntity(enemyIndexes.get(index)).getyCoordinate() == board.getEntity(playerIndex).getyCoordinate())){
					board.getEntity(enemyIndexes.get(index)).setCoordinates(randomGenerator.nextInt(29) + 1, randomGenerator.nextInt(29) + 1);
				}
			}
		}
		for(Integer temporaryEnemyIndexes : enemyIndexes){
			board.setEntityCoordinates(temporaryEnemyIndexes, board.getEntity(temporaryEnemyIndexes).getyCoordinate(), board.getEntity(temporaryEnemyIndexes).getxCoordinate());
		}
		
		
		while(true){
			board.display();
			String input = scanner.nextLine();
			command = input.charAt(0);
			
			switch(command){
				case 'q':
					scanner.close();
					System.exit(1);
				case 'm':
					char direction = input.charAt(2);
					int yCoordinate;
					int xCoordinate;
					switch(direction){
						case 'w':			
							yCoordinate = board.getEntity(playerIndex).getyCoordinate() - 1;
							xCoordinate = board.getEntity(playerIndex).getxCoordinate();
							for(int index = 0; index < enemyIndexes.size(); ++index){
								if((yCoordinate <= 0) || ((xCoordinate == board.getEntity(enemyIndexes.get(index)).getxCoordinate()) && (yCoordinate == board.getEntity(enemyIndexes.get(index)).getyCoordinate()))){
									yCoordinate += 1;
								}
							}
							board.setEntityCoordinates(playerIndex, xCoordinate, yCoordinate);
							break;
						case 's':
							yCoordinate = board.getEntity(playerIndex).getyCoordinate() + 1;
							xCoordinate = board.getEntity(playerIndex).getxCoordinate();
							for(int index = 0; index < enemyIndexes.size(); ++index){
								if((yCoordinate >= 31) || ((xCoordinate == board.getEntity(enemyIndexes.get(index)).getxCoordinate()) && (yCoordinate == board.getEntity(enemyIndexes.get(index)).getyCoordinate()))){
									yCoordinate -= 1;
								}
							}
							board.setEntityCoordinates(playerIndex, xCoordinate, yCoordinate);
							break;
						case 'a':
							yCoordinate = board.getEntity(playerIndex).getyCoordinate();
							xCoordinate = board.getEntity(playerIndex).getxCoordinate() - 1;
							for(int index = 0; index < enemyIndexes.size(); ++index){
								if((xCoordinate <= 0) || ((xCoordinate == board.getEntity(enemyIndexes.get(index)).getxCoordinate()) && (yCoordinate == board.getEntity(enemyIndexes.get(index)).getyCoordinate()))){
									xCoordinate += 1;
								}
							}
							board.setEntityCoordinates(playerIndex, xCoordinate, yCoordinate);
							break;
						case 'd':
							yCoordinate = board.getEntity(playerIndex).getyCoordinate();
							xCoordinate = board.getEntity(playerIndex).getxCoordinate() + 1;
							for(int index = 0; index < enemyIndexes.size(); ++index){
								if((xCoordinate >= 31) || ((xCoordinate == board.getEntity(enemyIndexes.get(index)).getxCoordinate()) && (yCoordinate == board.getEntity(enemyIndexes.get(index)).getyCoordinate()))){
									xCoordinate -= 1;
								}
							}
							board.setEntityCoordinates(playerIndex, xCoordinate, yCoordinate);
							break;
						default: 
							System.out.println("Invalid Direction");
					}
					break;
				default:
					System.out.println("Invalid Option");
					break;
			}
				
		}
	}
}

