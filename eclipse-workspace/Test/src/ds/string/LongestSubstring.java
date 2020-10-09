package ds.string;

import java.util.HashSet;
import java.util.Set;

//Longest substring of non repeating characters
public class LongestSubstring {
 
    private Set<String> subStrList = new HashSet<>();
    private int finalSubStrSize = 0;
    
    public static void main(String a[]){
    	LongestSubstring mls = new LongestSubstring();
        System.out.println(mls.getLongestSubstr("java2novice"));
        //First iteration: flags set for {j,a,v} then a comes for which flag is already set
        //substring-jav
        // reset flag for all characters before first occurrence of repeating character
        //i.e j in this case, final: {a,v}; j variable set to 2(index after first occurrence of repeating character)

        //Second iteration: flags set for {2,n,o} then v comes for which flag is already set
        //substring-va2no
        //j set to 3
        
        //Third iteration: flags set for {i,c,e} then index reach last
        //substring-a2novice
        
        System.out.println(mls.getLongestSubstr("java_language_is_sweet"));
        System.out.println(mls.getLongestSubstr("java_java_java_java"));
        System.out.println(mls.getLongestSubstr("abcabcbb"));
    }
     
    public Set<String> getLongestSubstr(String input){
        //reset instance variables
        subStrList.clear();
        finalSubStrSize = 0;
        // have a boolean flag on each character ascii value
        boolean[] flag = new boolean[256];
        int j = 0;
        char[] inputCharArr = input.toCharArray();
        for (int i = 0; i < inputCharArr.length; i++) {
            char c = inputCharArr[i];
            if (flag[c]) {
                extractSubString(inputCharArr,j,i);
                for (int k = j; k < i; k++) {
                    if (inputCharArr[k] == c) {
                        j = k + 1;
                        break;
                    }
                    flag[inputCharArr[k]] = false;
                }   
            } else {
                flag[c] = true;
            }
        }
        extractSubString(inputCharArr,j,inputCharArr.length);
        return subStrList;
    }
     
    private String extractSubString(char[] inputArr, int start, int end){
         
        StringBuilder sb = new StringBuilder();
        for(int i=start;i<end;i++){
            sb.append(inputArr[i]);
        }
        String subStr = sb.toString();
        if(subStr.length() > finalSubStrSize){
            finalSubStrSize = subStr.length();
            subStrList.clear();
            subStrList.add(subStr);
        } else if(subStr.length() == finalSubStrSize){
            subStrList.add(subStr);
        }
         
        return sb.toString();
    }
 
}