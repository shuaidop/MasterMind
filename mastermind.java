import java.util.*;

public class mastermind {
	public ArrayList<Integer> list=new ArrayList<Integer>();
//Create the constructor	
	public mastermind(ArrayList<Integer> list) {

		this.list=list;

	}
	ArrayList <String> L;
//the method to generate the link that will use to generate all the possibility of game
	public static ArrayList<String> generateLink(ArrayList<String> k,ArrayList<String> c,int length){
		//recursion to create the list
		ArrayList<String> L1=new ArrayList<String>();
		if(length==1){ 
//the basis case
			return k;
		}
		for(int i=0;i<=(k.size()-1);i++){
			for(int b=0;b<=(c.size()-1);b++){
				L1.add(k.get(i)+c.get(b));
			}
		}
		k.clear();
		for(int i=0;i<=(L1.size()-1);i++){
			k.add(L1.get(i)) ; 

		}
		length--;
		//the recursion part
		return generateLink(k, c, length);
	}

//the response method using all the compare methods to choose the items which can have the same result when compare with the computer stated guess
	public static ArrayList<String> response(ArrayList<String> k, String p,int rcrp,int wcrp,int l){
		ArrayList<String> list=new ArrayList<String>();
		ArrayList<String> list2=new ArrayList<String>();
		//if the return item is not null then add all in to the list, right color and right position
		for(int i=0;i<=(k.size()-1);i++){
			if(compare01(k.get(i),p,rcrp, l)!=null)
			{	
				list.add(compare01(k.get(i),p,rcrp, l));
			}
		}
		//the second compare method to compare the right color but wrong position
		for(int n=0;n<=(list.size()-1);n++){
			if(compare02( list.get(n),p, wcrp,l)!=null){
				list2.add(compare02( list.get(n),p, wcrp,l));

			}
		}

//return the final list
		return list2;

	}


//the first compare method which is as same as the nextMove which assignment said
	public static String compare01(String q,String p,int rcrp,int l){
		int num=0;
		for(int o=0;o<=l;o++){

			if(q.charAt(o)==p.charAt(o)){

				num++;

			}
		}
		if(num==rcrp){
			return q;
		}else{
			return null;
		}
	}





	//the second compare method which is as same as the nextMove which assignment said
	
	public static String compare02(String q,String p,int wcrp,int l){
		int num=0;
		//use the String Buffer to store the string temporarily 
		StringBuffer m=new StringBuffer(q);
		for(int o=0;o<=l;o++){

			for(int i=0;i<=l;i++){
				if(p.charAt(i)==m.charAt(i)){
					m.replace(i, i+1, "v");
					//System.out.println("M "+m);
				}
				else if (p.charAt(o)==m.charAt(i)){



					num++;
					m.replace(i, i+1, "v"); //System.out.println("M 2 "+m);System.out.println("Number "+num);
					break;

				}
			}
		}
		if(num==wcrp){
			return q;
		}else{
			return null;
		}
	}






// the new Game method to restart the game
	public static boolean newGame(String n) {

		if(n.equals("Y")){
			return true;
		}else{
			return false;
		}
	}   // Reset the game

}
