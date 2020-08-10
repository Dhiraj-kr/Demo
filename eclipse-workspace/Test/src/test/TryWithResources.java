package test;

public class TryWithResources {

	public static void main(String[] args) throws Exception {

		try ( OpenDoor door = new OpenDoor() ) {
			door.swing(); //this throws a SwingExecption
		}
		catch (Exception e) { 
			System.out.println("Caught Exception: " + e.getClass());
			int suppressedCount = e.getSuppressed().length;
			for (int i=0; i<suppressedCount; i++){
				System.out.println("Suppressed: " + e.getSuppressed()[i]);
			}
		}
		finally {
			System.out.println("I'm putting a sweater on, regardless. ");
		}
	}
}

class OpenDoor implements AutoCloseable {

	public OpenDoor() throws Exception {	//constructor can throw exception but it didn't threw here
		System.out.println("The door is open.");
	}
	public void swing() throws Exception {
		System.out.println("The door is becoming unhinged.");
		throw new SwingException();
	}

	public void close() throws Exception {		//It will be called by Java
		System.out.println("The door is closed.");
		throw new CloseException(); // throwing CloseException 
	}
}

class OpenException extends Exception {}
class SwingException extends Exception {}
class CloseException extends Exception {}