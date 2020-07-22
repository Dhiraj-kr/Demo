package test;

public class MultipleExceptions {
	 
    public static void main(String[] args)
    {
            sampleMethod();
    }
 
    public static void sampleMethod()
                    //throws Throwable  //No need to do this
    {
        try
        {
            //Do some processing which throws NullPointerException; I am sending directly
			/*
			 * if(false) { throw new IOException(); }
			 */
            throw new NullPointerException();
            
        }
        //You can catch multiple exception added after 'pipe' character
        
		/*
		 * catch(IOException ex) { System.out.println("In Null Pointer Catch"); throw
		 * ex; }
		 */
        catch(NullPointerException | IndexOutOfBoundsException ex)
        {
        	System.out.println("In Null Pointer Catch");
            throw ex;
        }
        //Now method sampleMethod() do not need to have 'throws' clause
        catch(Throwable ex)
        {
        	System.out.println("In General Exception Catch");
            throw ex;
        }
    }
}