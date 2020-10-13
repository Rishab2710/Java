import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
	
	public static void main(String[] args){
		
				Random num = new Random();
				Scanner input = new Scanner(System.in);
				boolean i = true;
				int cmptscr=0;
				int playerscr=0;
				
				
				while(i) {
					
					
							System.out.print("scissor(0),rock(1),paper(2): ");
				      	    int x = input.nextInt();
							int y = num.nextInt(3);
					
								switch(y){
								case 0:
									System.out.print("Computer is scissor.");
									break;
				
								case 1:
									System.out.print("Computer is rock.");
									break;
											
								case 2:
									System.out.print("Computer is paper.");
									break;
				
								}
								
							
		
							switch(x) {
							
							case 0 :
								System.out.print("You are scissor.");
								if(y==2) {
									
									playerscr++;
									System.out.println(" You won.");
									System.out.println(" ");
									
								}
								
								else if(y==x){
									System.out.println(" It's a draw.");
									System.out.println(" ");
									
								}
								else {
									cmptscr++;
									System.out.println(" You lost.");
									System.out.println(" ");
								}
								break;
								
							case 1 :
								System.out.print("You are rock.");
								if(y==0) {
									
									playerscr++;
									System.out.println(" You won.");
									System.out.println(" ");	 
								}
								
								else if(y==x){
									System.out.println(" It's a draw.");
									System.out.println(" ");
									
								}
							
								else {
									System.out.println(" You lost.");
									System.out.println(" ");
									cmptscr++;
								}
								break;
								
							case 2 :
								System.out.print("You are paper.");
								
								if(y==1) {
									playerscr++;
									System.out.println(" You won.");
									System.out.println(" ");
									
								}
								
								else if(y==x){
									System.out.println(" It's a draw.");
									System.out.println(" ");
								
								}
							
								else {	
									cmptscr++;
									System.out.println(" You lost.");
									System.out.println(" ");
								}
								
								break;
								
								default:
									System.out.println("Invalid option");
									System.out.println(" ");
									break;
							}
							if((playerscr>cmptscr)&&(playerscr==2)){
								System.out.println("You win the game");
								i = false;
							}
							
							else if((playerscr<cmptscr)&&(cmptscr==2)) {
								System.out.println("You lost the game");
								i = false;
							}
							
										
							else
								i=true;
					}
	
						
			}
	
}
