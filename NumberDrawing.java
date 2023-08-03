import java.util.*;
import java.util.concurrent.*;

public final class NumberDrawing{
	
	private static Set<Integer> setOfNumbersDrawn=new HashSet<>();//this would consist of the set of numbers drawn during the game!
	
	// public static void main(String[]args){
	// 	Scanner sc=new Scanner(System.in);
	// 	int choice=0;
	// 	while(choice!=3){
	// 		showChoices();
	// 		System.out.print("Enter your choice: ");
	// 		choice=sc.nextInt();
			
	// 		if(choice==1){
	// 			//draw the next number
	// 			drawNextNumber();
	// 		}
	// 		else if(choice==2){
	// 			//display all the numbers that have been drawn!
	// 			displayAllNumbersDrawn();
	// 		}
	// 		else if(choice==3){
	// 			//end the game!
	// 			System.out.println("GAME OVERRR");
	// 			System.exit(1);
	// 		}
	// 		else{
	// 			System.out.println("Wrong choice!!");
	// 		}
	// 	}
			
	// }
	// private static void showChoices(){
	// 	System.out.println("1------>Next Number");
	// 	System.out.println("2------>List of Numbers Drawn");
	// 	System.out.println("3------>End Game");
	// }
	//just for checking purposes!
	// private static void displayAllNumbersDrawn(){
	// 	for(Integer number:setOfNumbersDrawn){
	// 		System.out.print(number+" , ");
	// 	}
	// }

	//this method would return the shallow copy of the Set of numebers drawn!
	public static Set<Integer> getSetOfNumbersDrawn(){
		return new Set<Integer>(this.setOfNumbersDrawn);
	}

	//this method would draw the next number!
	public static int drawNextNumber(){
		ThreadLocalRandom random=ThreadLocalRandom.current();
		int numberDrawn=random.nextInt(1,91);//return a random number between 1-90(both included)
		//if the number is already drawn,redraw a number..
		while(setOfNumbersDrawn.contains(numberDrawn) || numberDrawn==0){
			numberDrawn=random.nextInt(1,91);
		}
		//add it to the setOfDrawn numbers..
		setOfNumbersDrawn.add(numberDrawn);
		//System.out.println();
		//System.out.println("Number Drawn: "+numberDrawn);
		//after all the numbers are drawn!
		//if(setOfNumbersDrawn.size()==90){
		//	System.out.println("Size fulll!");
			//displayAllNumbersDrawn();
			//System.exit(1);
		//}
		return numberDrawn;
	}
}
/*
*take the list of members of the that would like to play the game!
*next,when that list is ready,provide each member with the ticket
*This ticket would consist of 15 numbers between 1-90(included) 
*Next when the game would begin..
*the application must display a list of random number between 1-90(included).

*A random number is drawn and if it has already been drawn(by checking its presence in a set),it would be redrawn!
->LOGIC OF DRAWING THE NUMBER ABOVE..DONE

*Displaying list of numbers that have already drawn..must be printed in a sorting order!!
->LOGIC FOR LIST OF NUMBERS DRAWN ABOVE...DONE

->The only thing remaining here is the list of members that would be added that would be achieved through socket programming!

->Here,a host would begin the game and a secret code would be generated and any members that want to enter the game must enter this secret code!
->when the host clicks on to start game..each one woule be provided with a ticket and the game would begin!

->claim button must be given to all the players and and end game button to the admin!

->The only thing remaining is to display the ticket for all the participants!!!
*15 random numbers between 1-90
*each range ex 20-30/1-10/30-40...max 3 numbers..DONE

*random number between 1-90(both included)
add into the setOfDrawns and check if it isnt contained,else draw random new one again!!DONE
*
*/