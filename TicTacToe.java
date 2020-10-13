import java.util.*;

public class TicTacToe {
	public static void main(String[] args) {   //Main method
		
		char[] [] gameBoard= {                               //2D Array To build Game Board
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},	
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '} 		
			};
		
		printGameBoard(gameBoard);
		int [] boardPos = { 0,0,0,0,0,0,0,0,0};        //Initialized Board Position in 1D in order to fill it later
		int [] player1 = new int[9];				// Initialized the number of elements one player can contain
		int [] player2 = new int[9];
		Scanner scan = new Scanner(System.in);
		while(true) {					//Loop In Order to take inputs repeatedly
			while(true) {				//Loop In Order to take player1 inputs repeatedly
				System.out.print("Enter player1 cell(1-9): ");
				int pos1 = scan.nextInt();
				if(availablePos(pos1, boardPos)) {		//Loop for preventing the user to overwrite a position	
					while(true) {  //Loop for  taking inputs for number which are available are available 
						int x;
						System.out.print("Enter number from 1-9 player1: ");
						x = scan.nextInt();
						if(availableNumber(x,boardPos)) {   //conditional statement for checking the available number by calling method in it
							boardPos[pos1-1]=x;
							placePiece(gameBoard,pos1,x);  //calling method
							player1[pos1-1]=x;
							break;
						}
						else {
							System.out.println("Number already taken select another number");
						}
					}
					printGameBoard(gameBoard);   //calling method
					break;
				}
				else {
					System.out.println("Position already taken");
				}
			}
			if(checkWinner(player1)) {
				int turn =0;    //Counting turns and to tell the number of turns used after victory
				for(int i=0;i<9;i++) {
					if(player1[i]!=0) {
						turn++;
					}
				}
				System.out.println("Player1 wins in "+turn+" turns!!");
				break;
			}
			if(checkDraw(boardPos)) {
				System.out.println("MatchDraw!!");
				break;
			}
			while(true) {                    //Loop In Order to take player2 inputs repeatedly
				System.out.print("Enter player2 cell(1-9): ");
				int pos2 = scan.nextInt();
				if(availablePos(pos2, boardPos)) {       //Loop for preventing the user to overwrite a position	
					while(true) {
						int x;
						System.out.print("Enter number from 1-9 player2: ");
						x = scan.nextInt();
						if(availableNumber(x,boardPos)) {   //conditional statement for checking the available number by calling method in it
							boardPos[pos2-1]=x;
							placePiece(gameBoard,pos2,x);    //calling method
							player2[pos2-1]=x;
							break;
						}
						else {
							System.out.println("Number already taken select another number");
						}
					}
					printGameBoard(gameBoard);   //calling method
					break;
				}
				else {
					System.out.println("Position already taken");
				}
			}
			if(checkWinner(player2)) {   //Counting turns and to tell the number of turns used after victory
				int turn1 =0;
				for(int i=0;i<9;i++) {
					if(player2[i]!=0) {
						turn1++;
					}
				}
				System.out.println("Player2 wins in "+turn1+" turns!!");
				break;
			}
			if(checkDraw(boardPos)) {		//Method to check draw
				System.out.println("MatchDraw!!");
				break;
			}
		}
	}
		
	public static void printGameBoard(char[] [] gameBoard) {    //Method declared to print the game board
		for(char[] row: gameBoard){
			for(char c: row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void placePiece(char[][] gameBoard,int pos, int x) {  //Placing the number in game board
		switch(pos) {
			case 1:
				gameBoard[0][0] = (char)(x + '0'); //Converting into ASCII code
				break;
			case 2:
				gameBoard[0][2] =(char)(x + '0');//Converting into ASCII code
				break;
			case 3:
				gameBoard[0][4] =(char)(x + '0');//Converting into ASCII code
				break;
			case 4:
				gameBoard[2][0] =(char)(x + '0');//Converting into ASCII code
				break;
			case 5:
				gameBoard[2][2] =(char)(x + '0');//Converting into ASCII code
				break;
			case 6:
				gameBoard[2][4] =(char)(x + '0');//Converting into ASCII code
				break;
			case 7:
				gameBoard[4][0]=(char)(x + '0');//Converting into ASCII code
				break;
			case 8:
				gameBoard[4][2] =(char)(x + '0');//Converting into ASCII code
				break;
			case 9:
				gameBoard[4][4] =(char)(x + '0');//Converting into ASCII code
				break;
			default:
				
		}
	}
			
	public static boolean availablePos(int pos,int boardPos[]) {  //Method to check available place in game board in order to prevent the same position to be used
		if(boardPos[pos-1]==0) {
			return true;
		}
		else {
			return false;
		}
	}
			
	public static boolean availableNumber(int number,int boardPos[]) {  //Method to check available number for inserting in cell
		for(int y=0;y<9;y++) {
			if(boardPos[y]==number) {
				return false;
			}
		}
			return true;
	}
	
	public static boolean checkDraw(int boardPos[]) {  //Method to check draw possibility 
		for(int y=0;y<9;y++) {
			if(boardPos[y]==0) {
				return false;
			}
		}
			return true;
	}
	
	public static boolean checkWinner(int playerBoard[]) {            // Method to check winner 
		return ((playerBoard[0] + playerBoard[1] + playerBoard[2] == 15) ||
				(playerBoard[3] + playerBoard[4] + playerBoard[5] == 15) ||
				(playerBoard[6] + playerBoard[7] + playerBoard[8] == 15) ||
				(playerBoard[0] + playerBoard[3] + playerBoard[6] == 15) ||
				(playerBoard[1] + playerBoard[4] + playerBoard[7] == 15) ||
				(playerBoard[2] + playerBoard[5] + playerBoard[8] == 15) ||
				(playerBoard[0] + playerBoard[4] + playerBoard[8] == 15) ||
				(playerBoard[2] + playerBoard[4] + playerBoard[6] == 15));
	}		
}
