
public static String combinationOfCards(int input1,int input2,String input3,String input4)
    {
	    
	    int n=input1;
	    BitSet input=new BitSet(n);
	    StringBuffer result= new StringBuffer();
	    
	    String []whiteArr=new String[2];
	    String []blackArr=new String[2];
	    
	    if(!input3.equals("-1"))
	        whiteArr=input3.split(",");
	        
	    if(!input4.equals("-1"))
	        blackArr=input4.split(",");

	    boolean allDone=false,oddDone=false,evenDone=false,pDone=false,oddPDone=false,evenPDone=false,pFlipDone=false,inputDone=false;
	    
	    for(int j=0; j<input2;j++){
	        
	        BitSet temp=new BitSet(n);
	        temp.flip(0,input1);
	            
	        if(!allDone){
	          
	            temp.flip(0,input1);
	            allDone=	append(result,temp,whiteArr,blackArr,input1,input2);
	        }
	        else if(!evenPDone){
	
	            for(int k=1;k<n;k+=2)
	                temp.flip(k);
	            for(int l=1;l<n;l=(int)3l+1)
	                temp.flip(l);
	            
	            evenPDone=	            append(result,temp,whiteArr,blackArr,input1,input2);
	        }
	        else if(!oddDone){
	            for(int k=0;k<n;k+=2)
	                temp.flip(k);         
	            oddDone=	            append(result,temp,whiteArr,blackArr,input1,input2);
	        }
	        else if(!pDone){
	            for(int l=1;l<n;l=(int)3l+1)
	               temp.flip(l);         
	            pDone=	            append(result,temp,whiteArr,blackArr,input1,input2);
	        }
	        else if(!pFlipDone){
	            for(int l=1;l<n;l=(int)3l+1)
	                temp.flip(l);
		        temp.flip(0,input1);	          
	            pFlipDone=	            append(result,temp,whiteArr,blackArr,input1,input2);
	        }
	        else if(!evenDone){
	            for(int k=1;k<n;k+=2)
	                temp.flip(k);	           
	            evenDone=	            append(result,temp,whiteArr,blackArr,input1,input2);
	        }
	        else if(oddPDone){
	            for(int k=0;k<n;k+=2)
	                temp.flip(k);
	            for(int l=1;l<n;l=(int)3l+1)
	                temp.flip(l);	            
	            oddPDone=	            append(result,temp,whiteArr,blackArr,input1,input2);
	        }
	        else if(inputDone){
	            	         
	            inputDone=	            append(result,temp,whiteArr,blackArr,input1,input2);
	        }
	    }
	    return result.substring(0,result.length()-1).toString();
	  
    }
     static boolean append(StringBuffer result,BitSet temp,String[] whiteArr,String [] blackArr,int input3,int input4){
            boolean pass=true;
	        if(input3 !=-1){
	                for(int i=0;i<whiteArr.length;i++){
	                    if(!temp.get( Integer.parseInt(whiteArr[i])) ){
	                        pass=false;
	                        break;
	                    }
	                }
		    }
		    if(input4 !=-1){
	                for(int i=0;i<blackArr.length;i++){
	                    if(temp.get(Integer.parseInt(blackArr[i]))){
	                        pass=false;
	                        break;
	                    }
	                }
		    }
	               
	        if(pass){
	                 result.append(temp.toString()).append("#");
	                 return true;
	           }
	           return false;
     }