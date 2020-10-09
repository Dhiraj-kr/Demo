package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class ThreeVowels {

	public static void main(String arg[]) {
		List<String> lstStr=new ArrayList<>();
		lstStr.add("lflff");
		lstStr.add("aijkl");
		lstStr.add("aiehvg");
		lstStr.add("aijjjl");
		
		List<Character> vowels= Arrays.asList('a','e','i','o','u');
		
		Optional<String> opStr=lstStr.stream().filter(s->{
			char[] chArr=s.toCharArray();
			for(int i=0;i<chArr.length-2;i++) {
				if(vowels.contains(chArr[i]) && vowels.contains(chArr[i+1]) && vowels.contains(chArr[i+2]))
					return true;
			}
			return false;
		}).findFirst();
		
		if(opStr.isPresent()) {
			System.out.println(opStr.get());
		}

	}
}