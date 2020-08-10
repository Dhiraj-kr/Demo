package test;

public enum TestEnum {
	
    INSTANCE;
	
    int value;
    
    private TestEnum() {		//constructor is by default private also, we can explicitly define also
    	value=2;
    	System.out.println("Inside enum constructor");
    }
    
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    
}
class Test2{
	public static void main(String arg[]) {
		TestEnum.INSTANCE.getValue();
	}
}