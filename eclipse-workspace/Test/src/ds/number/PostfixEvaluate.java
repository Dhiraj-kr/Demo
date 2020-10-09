package ds.number;

import java.util.Stack;

public class PostfixEvaluate {
    public static void main(String[] args) {
    	infixToPostfix("( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )");
    	evaluate("( 2 ( ( 3 4 + ) ( 5 6 * ) * ) + ) ");	
    	evaluate2("2 3 4 + 5 6 * * + ");
    }
    
    public static void evaluate(String str) {
        Stack<String> ops  = new Stack<>();
        Stack<Double> vals = new Stack<>();
        
        String[] strArr=str.split(" ");
        
        for(int i=0;i<strArr.length;i++) {
            String s = strArr[i];
            if      (s.equals("("))               ;
            else if (s.equals("+"))    ops.push(s);
            else if (s.equals("-"))    ops.push(s);
            else if (s.equals("*"))    ops.push(s);
            else if (s.equals("/"))    ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) 
            {
                String op = ops.pop();
                double v = vals.pop();
                if      (op.equals("+"))    v = vals.pop() + v;
                else if (op.equals("-"))    v = vals.pop() - v;
                else if (op.equals("*"))    v = vals.pop() * v;
                else if (op.equals("/"))    v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            else 
            	vals.push(Double.parseDouble(s));
        }
        System.out.println(vals.pop());
    }
    
    public static void evaluate2(String str) {
        Stack<Integer> stack = new Stack<>();

        String[] strArr=str.split(" ");
        
        for(int i=0;i<strArr.length;i++) {
            String s = strArr[i];
            if      (s.equals("+")) stack.push(stack.pop() + stack.pop());
            else if (s.equals("*")) stack.push(stack.pop() * stack.pop());
            else stack.push(Integer.parseInt(s));
        }
        System.out.println(stack.pop());
    }

    public static void infixToPostfix(String str) {
    	
        Stack<String> stack = new Stack<>();
        
        String[] strArr=str.split(" ");
        
        for(int i=0;i<strArr.length;i++) {
            String s = strArr[i];
            if(s.equals("+")) 
            	stack.push(s);
            else if(s.equals("*")) 
            	stack.push(s);
            else if(s.equals(")")) 
            	System.out.print(stack.pop() + " ");
            else if(s.equals("(")) {
            	//do nothing
            }
            else 
            	System.out.print(s + " ");
        }
        System.out.println();
    }

}
