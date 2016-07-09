package paligame;
import java.util.Scanner;
public class PlayGame implements Table{
	
	int Position_A=0,Position_B=0;
//	int array_table[][] =new int[101][3];
	void Tableinfo (int rows,int columns){
		int count=1,cell;
		for(cell=1;cell<=rows*columns;cell++){
			 array_table[cell][0]=count;
			 count=count+1;
		 }
	}
	void playA(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Player_A turns ");
		scan.nextLine(); 	
		int position=diesGen();
		System.out.println("got num"+position);
		if( (position+Position_A)<100 && array_table[position+Position_A][1]==1){
			Position_A=array_table[Position_A+position][2];
			System.out.println("U Got Ladder u Sit At"+Position_A+"\n");
			playA();
		}
		else if((position+Position_A)<100 && array_table[position+Position_A][1]==2) {
			Position_A=array_table[Position_A+position][2];
			System.out.println("U Got Snake U Sit At"+Position_A+"\n");	
			playB();
		}
		else{
			Position_A=Position_A+position;
			if(Position_A>100){
				Position_A=Position_A-position;
				System.out.println("U Stay at"+Position_A+"\n");
				playB();
			}
			if(Position_A==100){
				System.out.println("Congrats A won the Game");	
				System.exit(0);
			}
			else{
			System.out.println("U Sit at"+Position_A+"\n");
			playB();
			}	
		}
	}
	void playB(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Player_B turns ");
		scan.nextLine(); 	
		int position=diesGen();
		System.out.println("got num"+position);
		if((position+Position_B)<100 && array_table[position+Position_B][1]==1){			
			Position_B=array_table[Position_B+position][2];
			System.out.println("U Got Ladder U Sit At"+Position_B+"\n");
			playB();
		}
		else if((position+Position_B)<100 && array_table[position+Position_B][1]==2){
			Position_B=array_table[Position_B+position][2];
			System.out.println("U Got Snake U Sit At"+Position_B+"\n");		
			playA();
		}
		else{
			Position_B=Position_B+position;
			if(Position_B>100){
				Position_B=Position_B-position;
				System.out.println("U Stay at"+Position_B+"\n");
				playA();
			}
			if(Position_B==100){
				System.out.println("Congrats B won the Game");
				System.exit(0);
			}
			else{
			System.out.println("U Sit at"+Position_B+"\n");
			playA();
			}
		}
	}
	int diesGen(){
	
			double i=Math.random()*10;
			int i1=(int)(i%6)+1;
			return i1;
		}
	public static void main(String args[]){
		PlayGame obj=new PlayGame();	
		obj.Tableinfo(10,10);
		new LaddersInfo();
		new SnakesInfo();
		obj.playA();
		
	}
	

}
