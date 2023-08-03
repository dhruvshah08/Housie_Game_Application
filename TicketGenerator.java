import java.util.*;
import java.util.concurrent.*;

public class TicketGenerator{
	private static int ticket_number=0;
	private int columnNumber=0;
	private Integer[] arrOfNumbers=new Integer[15];
	private Integer[][] displayOfNos=new Integer[3][9];
	private Set<Range> setOfRanges=new TreeSet<>();
	private int index=0;
	static ThreadLocalRandom random=ThreadLocalRandom.current();
	static 
	{
		generateTicketNumber();
	}
	TicketGenerator(){
		generateRandom();
	}
	private static void generateTicketNumber(){
		ticket_number+=1;//increment the ticket number each time by 1
	}
	
	//public static void main(String[]args){
		//generateRandom();
	//}
	
	public Ticket getTicket(){
		return Ticket.generateTicket(ticket_number,displayOfNos);
	}

	protected void generateRandom(){
		createRanges();
		//printRanges();
		generateFirstNine();
		//printNumbersDrawn();
		generateNextSix();
		//printNumbersDrawn();
		arrangeNumbers();
		//System.out.println("-----------------------------------------------------------------------------------------------------");
		//displayInFashion();
	}
	
	protected void createRanges(){
		//1-9 10-19 20-29 30-39 40-49 50-59 60-69 70-79 80-90
		int i,j;
		for(i=1,j=9;i<=80;i+=10,j+=10){
			if(i==11){
				i-=1;
			}
			if(i==80){
				j+=1;
			}
			setOfRanges.add(new Range(i,j));
		}
	}
	private void generateFirstNine(){
		for(Range range:setOfRanges){
			int numberDrawn=random.nextInt(range.getStartIndex(),range.getEndIndex()+1);
			arrOfNumbers[index]=numberDrawn;
			range.add(numberDrawn);
			index++;
		}
	}
	private void generateNextSix(){
		for(int i=0;i<6;i++){
			int numberDrawn=random.nextInt(1,91);
			Range range=getRangeOf(numberDrawn);
			if(!checkPresence(numberDrawn)){
				if(range.add(numberDrawn)){
					arrOfNumbers[index]=numberDrawn;
					index++;
				}
				else{
					i-=1;
				}
			}else{
				i-=1;
			}
		}
	} 	
	protected final boolean checkPresence(int number){
		for(int i=0;i<index;i++){
			if(number==arrOfNumbers[i])
				return true;
		}
		return false;
	}
	protected final Range getRangeOf(int number){
		for(Range range:setOfRanges){
			if(number>=range.getStartIndex() && number<=range.getEndIndex()){
				return range;
			}
		}
		return null;
	}
	protected final void arrangeNumbers(){
		//here iterate through the set getting each range and in each of the 
		for(Range range:setOfRanges){
			Integer[] arr=range.getNumbers();
			Arrays.sort(arr);
			// System.out.println();
			// for(int k=0;k<arr.length;k++){
			// 	System.out.print(arr[k]+" , ");
			// }
			// System.out.println();
			displayNumbers(arr);
		}
		//so now all the numbers in the array have been sorted!
		//the next task here is to now just fill it in the 2d array
	}
	protected void displayNumbers(Integer[] arr){
		//now,we'll be arranging in the array
		//column would be the index and the row would be changed!!
		//conditions here..fistly check the size of the array if size is one then add it any where
		//if size is 3 then add it periodically
		Set<Integer> rowsGenerated=new HashSet<>();
		if(arr.length==1){
			int rowNumberDrawn=random.nextInt(0,3);
			displayOfNos[rowNumberDrawn][columnNumber]=arr[0];
		}else if(arr.length==2){
			int rowNumber1=random.nextInt(0,2);
			//System.out.println(rowNumber1+" "+index+" "+arr[0]);
			displayOfNos[rowNumber1][columnNumber]=arr[0];
			int rowNumber2=random.nextInt(rowNumber1+1,3);
			//System.out.println(rowNumber2+" "+index+" "+arr[1]);
			displayOfNos[rowNumber2][columnNumber]=arr[1];
			//here the real logic begins..
			//2 numbers have to be drawn one between 0/1
			//and second between noDrawn and 2 and then assign it to the array!!
		}else if(arr.length==3){
			for(int i=0;i<3;i++){
				displayOfNos[i][columnNumber]=arr[i];
			}
		}
		columnNumber++;
	}
	
	// private  void displayInFashion(){
	// 	System.out.println("Total size:"+index);
	// 	for(int i=0;i<3;i++){
	// 		for(int j=0;j<9;j++){
	// 			if(displayOfNos[i][j]!=null){	
	// 				System.out.print(displayOfNos[i][j]+" ");
	// 			}else{
	// 				System.out.print(" ");
	// 			}
	// 		}
	// 		System.out.println();
	// 	}
	// }
	// private void printRanges(){
	// 	for(Range range:setOfRanges){
	// 		System.out.println(range.getStartIndex()+" to "+range.getEndIndex());
	// 	}
	// }
	// public void printNumbersDrawn(){
	// 	for(Integer numberDrawn:arrOfNumbers){
	// 		System.out.print(numberDrawn+" , ");
	// 	}
	// }
}
/*
*The ticket class would consist of a ticket number that would be unique(during a game)
*It would also consist of an array that would consist of 15 different numbers!
*max 3 from each range ex 0-10 and so onn  
*first draw one number from each set...so 9 are drawn and then draw rest 6 numbers such that each set wouldn't have>3 nos
*Create a class with start and end Index as it's params and have an array of size 3 and store these objects in a set in this class
*iterate and draw one from each
*then draw any 6 nos..and check if size of array in each set is not full each time the element has been drawn!..DONE
*Only now shape in a 2D Array!!..DONE
*/