package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Sequence {
	
	static Semaphore s1=new Semaphore(1);
    static Semaphore s2=new Semaphore(0);
    static Semaphore s3=new Semaphore(0);
	
    public static void main(String[] args) throws InterruptedException {

    	Sequence seq = new Sequence();
    	System.out.println("Method 1--");
    	printSeq1(seq);
    	System.out.println("Method 2--");
    	printSeq2();
    	System.out.println("Method 3--");
    	printSeq3();
    	System.out.println("Method 4--");
    	
    	s1=new Semaphore(1);
        s2=new Semaphore(0);
        s3=new Semaphore(0);
        
    	printSeq4(seq);
    }
    
	//Not working
	private static void printSeq4(Sequence seq) {
		new Thread(seq.new PrintSequenceRunnableSem(1,1)).start();
        new Thread(seq.new PrintSequenceRunnableSem(2,2)).start();
        new Thread(seq.new PrintSequenceRunnableSem(3,3)).start();
		
	}

	private static void printSeq3() throws InterruptedException {
		 AtomicInteger a1=new AtomicInteger(1);
		 Thread t1=new Thread(()->{
	        	
	        	while (a1.get() <= 20) {
		        	try {
						s1.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		        	System.out.println("Thread id-"+Thread.currentThread().getName()+",prints- "+a1.getAndAdd(3));
		        	s2.release();
	        	}
	     });
	     t1.start();
	        
	     AtomicInteger a2=new AtomicInteger(2);
	     Thread t2=new Thread(()->{
	        	
	        	while (a2.get() <= 20) {
		        	try {
						s2.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		        	System.out.println("Thread id-"+Thread.currentThread().getName()+",prints- "+a2.getAndAdd(3));
		        	s3.release();
	        	}
	     });
	     t2.start();
	        
	     AtomicInteger a3=new AtomicInteger(3);
	     Thread t3=new Thread(()->{
	        	
	        	while (a3.get() <= 20) {
		        	try {
						s3.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		        	System.out.println("Thread id-"+Thread.currentThread().getName()+",prints- "+a3.getAndAdd(3));
		        	s1.release();
	        	}
	     });
	     t3.start();
	        
	     t1.join();
	     t2.join();
	     t3.join();		
	}
	private static void printSeq2() throws InterruptedException {
		PrintSequenceRunnable runnable1=new PrintSequenceRunnable(1);
        PrintSequenceRunnable runnable2=new PrintSequenceRunnable(2);
        PrintSequenceRunnable runnable3=new PrintSequenceRunnable(0);
        
        Thread t1=new Thread(runnable1,"T1");
        Thread t2=new Thread(runnable2,"T2");
        Thread t3=new Thread(runnable3,"T3");
        
        t1.start();
        t2.start();
        t3.start();   
        
        t1.join();
        t2.join();
        t3.join();		
	}
	private static void printSeq1(Sequence seq) throws InterruptedException {
		Thread t1 = new Thread(seq.new Printer(1));
        Thread t2 = new Thread(seq.new Printer(2));
        Thread t3 = new Thread(seq.new Printer(3));

        t1.start();
        t2.start();
        t3.start();
        
        t1.join();
        t2.join();
        t3.join();		
	}
	private volatile Integer threadIdToRun = 1;//volatile is important
    private volatile Integer count = 1;	//Outer class variable accessible to inner class objects, volatile is also important
    private Object object = new Object();//To synchronise
    
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
      	 
    	public int PRINT_NUMBERS_UPTO=20;
    	private int threadId;
    	private volatile int num;
    	
    	public PrintSequenceRunnableSem(int threadId, int num) {
             super();
             this.threadId = threadId;
             this.num=num;
        }
    	 
    	@Override
    	public void run() {
    		 while (num <= PRINT_NUMBERS_UPTO) {
	               if(threadId==1) {
		            	try {
							s1.acquire();
							System.out.println("Thread " + threadId + " printed " + num);
							num += 3;
						    s2.release();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
	               }
	               else if(threadId==2) {
	            	   try {
							s2.acquire();
							System.out.println("Thread " + threadId + " printed " + num);
							num += 3;
						    s3.release();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
	               }
	               else {
	            	   try {
							s3.acquire();
							System.out.println("Thread " + threadId + " printed " + num);
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
	 
	public int PRINT_NUMBERS_UPTO=20;
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