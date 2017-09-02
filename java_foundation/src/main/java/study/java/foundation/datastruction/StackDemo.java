package study.java.foundation.datastruction;

import java.util.Stack;

public class StackDemo {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Stack stack = new Stack();
		
		stack.push("12");
		stack.push("89");
		
		
		
		stack.isEmpty();
		stack.iterator();
		stack.get(1);
		stack.add("56");
		stack.contains("12");
		stack.empty();
//		stack.forEach(new Consumer(){
//
//			public void accept(Object t) {
//				
//			}});
		stack.toArray();
		stack.add(0, "1");
		
		for(int i = 0; i <= stack.size(); i++){
			System.out.println(stack.pop());
		}
		
		
		
        String peek = (String) stack.peek();
		
		String pop = (String) stack.pop();
		System.out.println(peek + " " + pop);
		
	}
}
