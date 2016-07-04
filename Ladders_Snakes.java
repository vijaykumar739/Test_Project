import java.util.*;
public class Ladders_Snakes {
	int[][] array_table =new int[101][3];
	int Position_A=0,Position_B=0;
    
	void table_formation(){
		
		int cell,count=1;
	 for(cell=1;cell<=100;cell++){
				 array_table[cell][0]=count;
				 count=count+1;
			 }
		 
	 //for_ladder_info
	 
	array_table[3][1]=1; //for_ladder_starting_point_at_3
	array_table[3][2]=51;//for_ladder_ending_point_at_3	
	
	array_table[6][1]=1; //for_ladder_starting_point_at_6
	array_table[6][2]=27;//for_ladder_ending_point_at_6
	
	array_table[20][1]=1; //for_ladder_starting_point_at_20
	array_table[20][2]=70;//for_ladder_ending_point_at_20
	
	array_table[36][1]=1; //for_ladder_starting_point_at_36
	array_table[36][2]=55;//for_ladder_ending_point_at_36
	
	array_table[63][1]=1; //for_ladder_starting_point_at_63
	array_table[63][2]=95;//for_ladder_ending_point_at_63
	
	array_table[68][1]=1; //for_ladder_starting_point_at_68
	array_table[68][2]=98;//for_ladder_ending_point_at_68
	
	//For snake_info
	array_table[25][1]=2; //for_snake_starting_point_at_25
	array_table[25][2]=5;//for_snake_ending_point_at_25
	
	array_table[34][1]=2; //for_snake_starting_point_at_34
	array_table[34][2]=1;//for_snake_ending_point_at_34
	
	array_table[65][1]=2; //for_snake_starting_point_at_65
	array_table[65][2]=52;//for_snake_ending_point_at_65
	
	array_table[87][1]=2; //for_snake_starting_point_at_86
	array_table[87][2]=57;//for_snake_ending_point_at_86
	
	array_table[91][1]=2; //for_snake_starting_point_at_91
	array_table[91][2]=61;//for_snake_ending_point_at_91
	
	array_table[99][1]=2; //for_snake_starting_point_at_99
	array_table[99][2]=69;//for_snake_ending_point_at_99
	 	
	}
	void play_sn_ld_A(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Player_A turns ");
		String str = scan.nextLine(); 	
		int position=dies_gen();
		System.out.println("got num"+position);
		if( (position+Position_A)<100 && array_table[position+Position_A][1]==1){
			Position_A=array_table[Position_A+position][2];
			System.out.println("U Got Ladder u Sit At"+Position_A+"\n");
			play_sn_ld_A();
		}
		else if((position+Position_A)<100 && array_table[position+Position_A][1]==2) {
			Position_A=array_table[Position_A+position][2];
			System.out.println("U Got Snake U Sit At"+Position_A+"\n");	
			play_sn_ld_B();
		}
		else{
			Position_A=Position_A+position;
			if(Position_A>100){
				Position_A=Position_A-position;
				System.out.println("U Stay at"+Position_A+"\n");
				play_sn_ld_B();
			}
			if(Position_A==100){
				System.out.println("Congrats A won the Game");	
				System.exit(0);
			}
			else{
			System.out.println("U Sit at"+Position_A+"\n");
			play_sn_ld_B();
			}	
		}
	}
	void play_sn_ld_B(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Player_B turns ");
		String str = scan.nextLine(); 	
		int position=dies_gen();
		System.out.println("got num"+position);
		if((position+Position_B)<100 && array_table[position+Position_B][1]==1){			
			Position_B=array_table[Position_B+position][2];
			System.out.println("U Got Ladder U Sit At"+Position_B+"\n");
			play_sn_ld_B();
		}
		else if((position+Position_B)<100 && array_table[position+Position_B][1]==2){
			Position_B=array_table[Position_B+position][2];
			System.out.println("U Got Snake U Sit At"+Position_B+"\n");		
			play_sn_ld_A();
		}
		else{
			Position_B=Position_B+position;
			if(Position_B>100){
				Position_B=Position_B-position;
				System.out.println("U Stay at"+Position_B+"\n");
				play_sn_ld_A();
			}
			if(Position_B==100){
				System.out.println("Congrats B won the Game");
				System.exit(0);
			}
			else{
			System.out.println("U Sit at"+Position_B+"\n");
			play_sn_ld_A();
			}
		}
	}
	
	int dies_gen(){

		double i=Math.random()*10;
		int i1=(int)(i%6)+1;
		return i1;
	}
	
public static void main(String args[]){
	
	Ladders_Snakes obj=new Ladders_Snakes();
	obj.table_formation();
	obj.play_sn_ld_A();
		}
}
	

