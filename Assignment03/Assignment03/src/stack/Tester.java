package stack;

public class Tester {
	public static void main(String args[]) {
		
		Stack st = new Stack();
		st.push(10);
		st.push(20);
		st.push(30);
		st.display();
		
		System.out.println("Peeked element:"+st.peek());
		System.out.println("Popped element:"+st.pop());
		System.out.println("Peeked element:"+st.peek());
	}

}
