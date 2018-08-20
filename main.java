import java.util.*;

public class main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		boolean  newgame=true;
		while(newgame){
			//create new lists which contain the colors
			ArrayList<String> L=new ArrayList<String>();
			L.add("A");
			L.add("B");
			L.add("C");
			L.add("D");
			L.add("E");
			L.add("F");
			ArrayList<String> L1=new ArrayList<String>();
			L1.add("A");
			L1.add("B");
			L1.add("C");
			L1.add("D");
			L1.add("E");
			L1.add("F");
			boolean start=true;
//choose the position number that you want to have
			System.out.println("Please enter the position number from 2 to 4 and think a combination with the color A,B,C,D,E,F ");
			int n=scan.nextInt();
			int l=n-1;
			String p2;
			{if(n==4){
				p2="AABB";
			}else if(n==3){
				p2="AAB";
			}else{
				p2="AB";
			}
			}
			//the guess first made by the computer
			System.out.println("I guess is"+p2);
			//choose whether the guess is true
			System.out.println("If the answer is correct please enter Y or enter n if is not correct");
			String g=scan.next();

//if true then break the beak by letting the boolean statement 
			if(g.equals("Y")){
				System.out.println("The computer wins and answer is "+p2);
				start=false;
			}else{
				//enter the the right color wrong position and right color and wrong position
				System.out.println("Please enter the number of items which has the correct color and correct position");
				int rcrp1=scan.nextInt();
				System.out.println("Please enter the number of items which has the correct color but wrong position");
				int wcrp1=scan.nextInt();
//use the response method to create list
				ArrayList<String> listn=new ArrayList<String>();
				listn=mastermind.response(mastermind.generateLink(L,L1,n),  p2,rcrp1,wcrp1,l);

//enter the while loop when the size is not 1
				while(listn.size()!=1){

					String p1=listn.get(0);

					System.out.println("I guess is "+p1);
					System.out.println("If the answer is correct please enter Y");
					String c=scan.next();
					if(c.equals("Y")){
						System.out.println("The computer wins the game and the answer is "+p1);
						start=false;
						break;
					}else{
						System.out.println("Please enter again the number of items which has the correct color and correct position");
						int rcrp=scan.nextInt();

						System.out.println("Please enter again the number of items which has the correct color but wrong position");

						int wcrp=scan.nextInt();
						listn=mastermind.response(listn, p1,rcrp,wcrp,l);
						//System.out.println("Size "+listn.toString());
					}
				}
				//use the method to start the new game
				if(start){
					System.out.println("Computer guess is"+listn.toString());
				}
			}
			System.out.println("Do you want to start a new game? ");
			String j=scan.next();
			newgame=mastermind.newGame(j);

		}
		System.out.println("GAME OVER!!!!!!");
	}

}
