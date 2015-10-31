package userinterface;

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
							if(yCoordinate <= 0){
								yCoordinate += 1;
							}
							xCoordinate = board.getEntity(playerIndex).getxCoordinate();
							board.setEntityCoordinates(playerIndex, xCoordinate, yCoordinate);
							break;
						case 's':
							yCoordinate = board.getEntity(playerIndex).getyCoordinate() + 1;
							if(yCoordinate >= 31){
								yCoordinate -= 1;
							}
							xCoordinate = board.getEntity(playerIndex).getxCoordinate();
							board.setEntityCoordinates(playerIndex, xCoordinate, yCoordinate);
							break;
						case 'a':
							yCoordinate = board.getEntity(playerIndex).getyCoordinate();
							xCoordinate = board.getEntity(playerIndex).getxCoordinate() - 1;
							if(xCoordinate <= 0){
								xCoordinate += 1;
							}
							board.setEntityCoordinates(playerIndex, xCoordinate, yCoordinate);
							break;
						case 'd':
							yCoordinate = board.getEntity(playerIndex).getyCoordinate();
							xCoordinate = board.getEntity(playerIndex).getxCoordinate() + 1;
							if(xCoordinate >= 31){
								xCoordinate -= 1;
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

