package techgig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCardApp2 {

	public static void main(String[] args) {
		
		int nCards = 10;
		int nChances= 1;
		String wCards="-1";
		String bCards="7";
		
		nCards=40;nChances=3;wCards="16";bCards="2,25";
		
		
		String allCombinations = allCombinations(nCards,nChances,wCards,bCards);
		
		System.out.println("Output:: "+allCombinations);
	}
	
	public static String allCombinations(int nCards,int nChances,String wCards,String bCards){
		
		//check input constraints
		if( (nCards<10 || nCards >100) || (nChances<1 || nChances >10000)){
			return null;
		}
		
		//create a output array to match final result
		int[] output = new int[nCards];
		for(int i=0;i<output.length;i++){
			output[i]=-1;
		}
		
		if(!wCards.equals("-1")){
			String[] tokens= wCards.split(",");
			if(tokens.length>2){
				return null;
			}
			for(String token:tokens){
				output[Integer.parseInt(token)-1]=1;
			}
		}
		
		if(!bCards.equals("-1")){
			String[] tokens= bCards.split(",");
			if(tokens.length>2){
				return null;
			}
			for(String token:tokens){
				output[Integer.parseInt(token)-1]=0;
			}
		}
		
		
		
		List<String> opList = new ArrayList<String>();
		int a=0,b=0,c=0,d=0;
		int[] cards = new int[nCards];
		
		for(int n=0;n<16;n++){
			
			//set all cards initially white
			for(int i=0;i<cards.length;i++){
				cards[i]=1;
			}
			
			//get effective number of each action
			d=n%2;c=(n/2)%2;b=(n/4)%2;a=(n/8)%2;
			
			if(a+b+c+d>nChances){
				continue;
			}
			
			if(a==1) applyOperation(cards,1);
			if(b==1) applyOperation(cards,2);
			if(c==1) applyOperation(cards,3);
			if(d==1) applyOperation(cards,4);
			
			//if matches output then add into output
			String result = toString(cards);
			if(outputMatched(cards,output) && !opList.contains(result)){
				opList.add(result);
			}
		}
		
		//set patterns in numerical ascending order
		Collections.sort(opList);
		
		//covert array list to '#' delimited string
		StringBuilder sb = null;
		for(String str:opList){
			if(sb==null){
				sb = new StringBuilder();
			}else{
				sb.append("#");
			}
			sb.append(str);
		}
		return sb==null? null :sb.toString();
	}

	//apply the action
	public static void applyOperation(int[] cards,int operation){
		
		if(operation == 1){//all flipped
			for(int i=0;i<cards.length;i++){
				cards[i] =  cards[i] == 0 ? 1: 0;
			}
		}else if(operation == 2){//odd flipped
			for(int i=0;i<cards.length;i++){
				if((i+1)%2!=0){
					cards[i] =  cards[i] == 0 ? 1: 0;
				}
			}
		}else if(operation == 3){//even flipped
			for(int i=0;i<cards.length;i++){
				if((i+1)%2==0){
					cards[i] =  cards[i] == 0 ? 1: 0;
				}
			}
		}else if(operation == 4){//3k+1 flipped
			for(int i=0;i<cards.length;i++){
				if(i%3==0){
					cards[i] =  cards[i] == 0 ? 1: 0;
				}
			}
		}		
	}
	
	
	//check if matched with required output pattern
	public static boolean outputMatched(int[] cards,int[] output){
		boolean flag = true;
		
		for(int i=0;i<output.length;i++){
			if(output[i] !=-1 && output[i]!=cards[i]){
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	//covert integer array to string
	public static String toString(int[] cards){
		StringBuilder sb = new StringBuilder(cards.length);
		for(int a:cards){
			sb.append(a);
		}
		return sb.toString();
	}
	
}


