package techgig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCardApp {

	public static void main(String[] args) {
		
		int nCards = 40;// 10;
		int nChances= 3;// 1;
		String wCards="16";//"-1";
		String bCards="2,25";//"7";
		
		String allCombinations = allCombinations(nCards,nChances,wCards,bCards);
		
		System.out.println("Output:: "+allCombinations);
	}
	
	public static String allCombinations(int nCards,int nChances,String wCards,String bCards){
		
		if( (nCards<10 || nCards >100) || (nChances<1 || nChances >10000)){
			return null;
		}
	
		StringBuilder sb = null;
		List<String> opList = new ArrayList<String>();
		int[] output = new int[nCards];
		for(int i=0;i<output.length;i++){
			output[i]=-1;
		}
		
		if(!wCards.equals("-1")){
			for(String token:wCards.split(",")){
				output[Integer.parseInt(token.trim())-1]=1;
			}
		}
		
		if(!bCards.equals("-1")){
			for(String token:bCards.split(",")){
				output[Integer.parseInt(token.trim())-1]=0;
			}
		}
		
		int a=0,b=0,c=0,d=0;
		for(int n=0;n<16;n++){
			GambleCards cards = new GambleCards(nCards);
			d=n%2;c=(n/2)%2;b=(n/4)%2;a=(n/8)%2;
			if(a+b+c+d>nChances){
				continue;
			}
			if(a==1) cards.applyOperation(CardOperations.ALL_FILPPED);
			if(b==1) cards.applyOperation(CardOperations.ODD_FLIPPED);
			if(c==1) cards.applyOperation(CardOperations.EVEN_FLIPPED);
			if(d==1) cards.applyOperation(CardOperations.SPCL_FILPPED);
			if(cards.outputMatched(output) && !opList.contains(cards.toString())){
				opList.add(cards.toString());
			}
		}
		
		Collections.sort(opList);
		
		for(String str:opList){
			if(sb==null){
				sb = new StringBuilder();
			}else{
				sb.append("#");
			}
			sb.append(str);
		}
		return sb.toString();
	}

	
	
}

class GambleCards{
		
	private int[] cards;
		
	GambleCards(int n){
		this.cards = new int[n];
		for(int i=0;i<cards.length;i++){
			this.cards[i]=1;
		}
	}
	
	public void applyOperation(CardOperations operation){
		
		if(operation == CardOperations.ALL_FILPPED){
			for(int i=0;i<cards.length;i++){
				cards[i] =  cards[i] == 0 ? 1: 0;
			}
		}else if(operation == CardOperations.ODD_FLIPPED){
			for(int i=0;i<cards.length;i++){
				if((i+1)%2!=0){
					cards[i] =  cards[i] == 0 ? 1: 0;
				}
			}
		}else if(operation == CardOperations.EVEN_FLIPPED){
			for(int i=0;i<cards.length;i++){
				if((i+1)%2==0){
					cards[i] =  cards[i] == 0 ? 1: 0;
				}
			}
		}else if(operation == CardOperations.SPCL_FILPPED){
			for(int i=0;i<cards.length;i++){
				if(i%3==0){
					cards[i] =  cards[i] == 0 ? 1: 0;
				}
			}
		}		
	}
	
	//-1,doesn't matter , don't compare
	public boolean outputMatched(int[] output){
		boolean flag = true;
		
		for(int i=0;i<output.length;i++){
			if(output[i] !=-1 && output[i]!=cards[i]){
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder(cards.length);
		for(int a:cards){
			sb.append(a);
		}
		return sb.toString();
	}
}

enum CardOperations{
	ALL_FILPPED,ODD_FLIPPED,EVEN_FLIPPED,SPCL_FILPPED
}
