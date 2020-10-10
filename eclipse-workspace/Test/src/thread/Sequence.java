package thread;

import java.util.concurrent.Semaphore;

public class Sequence {
	
    private volatile Integer count = 1;
    private volatile Integer threadIdToRun = 1;
    private Object object = new Object();
    
    Semaphore s1=new Semaphore(1);
    Semaphore s2=new Semaphore(0);
    Semaphore s3=new Semaphore(0);

    public static void main(String[] args) {

    	Sequence testClass = new Sequence();
        Thread t1 = new Thread(testClass.new Printer(1));
        Thread t2 = new Thread(testClass.new Printer(2));
        Thread t3 = new Thread(testClass.new Printer(3));

        t1.start();
        t2.start();
        t3.start();
        
        System.out.println("-----------------------");

        PrintSequenceRunnable runnable1=new PrintSequenceRunnable(1);
        PrintSequenceRunnable runnable2=new PrintSequenceRunnable(2);
        PrintSequenceRunnable runnable3=new PrintSequenceRunnable(0);
        t1=new Thread(runnable1,"T1");
        t2=new Thread(runnable2,"T2");
        t3=new Thread(runnable3,"T3");
        t1.start();
        t2.start();
        t3.start();   
        
        System.out.println("-----------------------");
        
        //new Thread(testClass.new PrintSequenceRunnableSem(1,1)).start();
        //new Thread(testClass.new PrintSequenceRunnableSem(2,2)).start();
        //new Thread(testClass.new PrintSequenceRunnableSem(3,3)).start();

    }

    class Printer implements Runnable {

        private int threadId;

        public Printer(int threadId) {
            super();
            this.threadId = threadId;
        }

        @Override
        public void run() {
            try {
                while (count <= 20) {
                    synchronized (object) {
                        if (threadId != threadIdToRun) {
                            object.wait();
                        } else {
                            System.out.println("Thread " + threadId + " printed " + count);
                            count += 1;

                            if (threadId == 1)
                                threadIdToRun = 2;
                            else if (threadId == 2)
                                threadIdToRun = 3;
                            else if (threadId == 3)
                                threadIdToRun = 1;

                            object.notifyAll();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    
    class PrintSequenceRunnableSem implements Runnable{
   	 
    	public int PRINT_NUMBERS_UPTO=10;
    	private int threadId;
    	private volatile int num;
    	
    	public PrintSequenceRunnableSem(int threadId, int num) {
             super();
             this.threadId = threadId;
             this.num=num;
        }
    	 
    	@Override
    	public void run() {
    		 if (num <= 20) {
	               if(threadId==1) {
		            	try {
							s1.acquire();
							System.out.println("Thread " + threadId + " printed " + num+3);
						    num += 3;
						    s2.release();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
	               }
	               else if(threadId==2) {
	            	   try {
							s2.acquire();
							System.out.println("Thread " + threadId + " printed " + num+3);
						    num += 3;
						    s3.release();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
	               }
	               else {
	            	   try {
							s3.acquire();
							System.out.println("Thread " + threadId + " printed " + num+3);
						    num += 3;
						    s1.release();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
	               }
	            	 
    		 }
    	}
    }
    

}

class PrintSequenceRunnable implements Runnable{
	 
	public int PRINT_NUMBERS_UPTO=10;
	static int  number=1;
	int remainder;
	static Object lock=new Object();
	 
	PrintSequenceRunnable(int remainder)
	{
		this.remainder=remainder;
	}
	 
	@Override
	public void run() {
		while (number < PRINT_NUMBERS_UPTO-1) {
			synchronized (lock) {
			while (number % 3 != remainder) { // wait for numbers other than remainder
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				lock.notifyAll();
			}
		}
	}
}
 



