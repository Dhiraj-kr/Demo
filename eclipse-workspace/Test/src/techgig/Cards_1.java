
public static String combinationOfCards(int input1,int input2,String input3,String input4)
    {
	    //Write code here
	   // StringBuffer pat=new StringBuffer();
	    int n=Integer.parseInt(input1);
	    BitSet input=new BitSet(n);
	    StringBuffer finalStr=new StringBuffer();
	    
	    int white=0,black=0;
	    String []whiteArr=new String[2];
	    String []blackArr=new String[2];
	    
	    if(input3 == -1)
	        white=-1;
	    else
	        whiteArr=input3.split(",");
	        
	    if(input4 == -1)
	        black=-1;
	    else
	        blackArr=input4.split(",");
	        
	    
	    
	    //for(int i=0;i<input1.length();i++){
	      // pat.append("1");
	   // }
	    
	    int flipAllOutput=0,oddOutput=0,evenOutput=0,flipPatternOutput=0;
	    boolean allDone=false,oddDone=false,evenDone=false,pDone=false,oddPDone=false,evenPDone=false,pFlipDone=false,inputDone=false;
	    
	    for(int j=0; j<input2.length();j++){
	        if(!allDone){
	            //allDone=checkFlipAll(input,finalStr,input3,input4);
	            BitSet temp=new BitSet(n)
	            temp.flip(0,input1.length());
	            boolean pass=true;
	            if(white != -1){
	                for(int i=0;i<whiteArr.length;i++){
	                    if(!temp.get(whiteArr[i]){
	                        pass=false;
	                        break;
	                    }
	                }
	                for(int i=0;i<blackArr.length;i++){
	                    if(temp.get(blackArr[i])){
	                        pass=false;
	                        break;
	                    }
	                }
	                if(pass){
	                    finalStr.append(temp.toString()).append("#");
	                }
	            }
	            
	            
	        }
	        else if(!evenPDone){
	            evenPDone=checkEvenP(input,finalStr,input3,input4);
	        }
	        else if(!oddDone){
	            oddDone=checkOdd(input,finalStr,input3,input4);
	        }
	        else if(!pDone){
	            pDone=checkP(input,finalStr,input3,input4);
	        }
	        else if(!pFlipDone){
	            pFlipDone=checkPFlip(input,finalStr,input3,input4);
	        }
	        else if(!oddDone){
	            oddDone=checkOdd(input,finalStr,input3,input4);
	        }
	        else if(oddPDone){
	            oddPDone=checkOddP(input,finalStr,input3,input4);
	        }
	        else if(inputDone){
	            inputDone=checkInput(input,finalStr,input3,input4);
	        }
	    }
	    return finalStr.toString();
	  
    }
    static checkFlipAll(StringBuffer finalStr,String input3, String input4){
        
    }