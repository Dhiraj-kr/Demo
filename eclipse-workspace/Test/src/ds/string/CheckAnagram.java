package ds.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckAnagram {

	public static void main(String[] args) {
		
		List<Integer> lst=stringAnagram(Arrays.asList("abc","def"),Arrays.asList("fgh","cba","bca"));
		lst.forEach(System.out::println);
		
		char str1[] = ("geeksforgeeks").toCharArray(); 
        char str2[] = ("forgeeksgeeks").toCharArray(); 
  
        if (areAnagram(str1, str2)) 
            System.out.println("The two strings are anagram of each other"); 
        else
            System.out.println("The two strings are not anagram of each other");
        
        String str3 = "bcadeh", str4 = "hea"; 
        System.out.println(countDeletions(str3, str4)); 


	}
	
	//The function is expected to return an INTEGER_ARRAY. 
	//To return all anagrams of query which are present in dictionary
	public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        query=getLenPlusValue(query);
        dictionary=getLenPlusValue(dictionary);

        Map<String, Integer> dicMap=new HashMap<>();

        for(String dic: dictionary){
            if(dicMap.containsKey(dic)){
                dicMap.put(dic,dicMap.get(dic)+1);
            }
            else{
                dicMap.put(dic,1);
            }
        }
        List<Integer> result=new ArrayList<>();

        for(String q: query){
            Integer i=dicMap.get(q);
            if(i!=null){
                result.add(i);
            }
            else{
                result.add(0);
            }
        }
        return result;
    }

    private static List<String> getLenPlusValue(List<String> strs) {
        // Write your code here
        List<String> lst=new ArrayList<>();
        for(String str: strs){
         
            char[] chArr=str.toCharArray();
            Arrays.sort(chArr);
            
            lst.add(String.valueOf(chArr));
        }
        return lst;
    }


    static boolean areAnagram(char str1[], char str2[]) 
    { 
    	if (str1.length != str2.length) 
            return false; 
    	
        // Create 2 count arrays and initialize 
        // all values as 0 
        int count1[] = new int[256]; 
        Arrays.fill(count1, 0); 
        int count2[] = new int[256]; 
        Arrays.fill(count2, 0); 
        int i; 
  
        // For each character in input strings, 
        // increment count in the corresponding 
        // count array 
        for (i = 0; i < str1.length && i < str2.length; i++) { 
            count1[str1[i]]++; 
            count2[str2[i]]++; 
        } 
  
        // Compare count arrays 
        for (i = 0; i < 256; i++) 
            if (count1[i] != count2[i]) 
                return false; 
  
        return true; 
    } 

    
    /*
   Remove minimum number of characters so that two strings become anagram
   
     Input : str1 = "bcadeh" str2 = "hea"
Output: 3
We need to remove b, c and d from str1.

Input : str1 = "cddgk" str2 = "gcd"
Output: 2

Input : str1 = "bca" str2 = "acb"
Output: 0

     */
    static int countDeletions(String str1, String str2) { 
        int arr[] = new int[256]; 
        for (int i = 0; i < str1.length(); i++) { 
            arr[str1.charAt(i) - 'a']++; 
        } 
  
        for (int i = 0; i < str2.length(); i++) { 
            arr[str2.charAt(i) - 'a']--; 
        } 
  
        int ans = 0; 
        for (int i = 0; i < 256; i++) { 
            ans += Math.abs(arr[i]); 
        } 
        return ans; 
    } 
  
   


}
