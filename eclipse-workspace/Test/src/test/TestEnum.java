package test;

public enum TestEnum {
	
    INSTANCE;
	
    int value;
    
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    
    private TestEnum() {
    	value=2;
    	System.out.println("Inside enum constructor");
    }
}
class Test2{
	public static void main(String arg[]) {
		TestEnum.INSTANCE.getValue();
	}
}