package string;

public class Replace {

	//Also do it using recursion
	public static void main(String []args){
        
        String str="fsfdsfdsfdsfgfdg";
                   
        StringBuffer sb=new StringBuffer(str);
        
        String rch="r";		//replace character
        int start=0,end=sb.length();
        
        int idx=sb.indexOf("f",start);
    
        System.out.println("Index:"+idx);
        
        String left, previous="",temp;

        while(idx != -1){
             
             if(idx !=0){
                 previous=sb.substring(0,idx); 		
                 System.out.println("Index Not 0, previous: "+previous);
             }
             left=sb.substring(idx+1,end);		// 1(one) can be replaced with length of substring to be replaced
             System.out.println("Left: "+left);
	
             if(idx !=0){
                temp=previous.concat(rch).concat(left);
                sb=new StringBuffer(temp);
             }
             else{
                 temp=rch.concat(left);
                 sb=new StringBuffer(temp);
             }
             System.out.println("sb: "+sb);
             start=idx+1;
             idx=sb.indexOf("f",start);
             System.out.println("Index:"+idx);
        }
        System.out.println(sb);
     }

}
