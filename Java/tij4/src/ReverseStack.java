import java.util.Stack;

public class ReverseStack {
	public static void main(String[] args) {
		Stack<String> team = new Stack<String>();
		team.push("E");
		team.push("M");
		team.push("A");
		team.push("T");
		team.push("2");

		reverse(team);

		while(!team.isEmpty()) {
			System.out.print(team.pop() + " ");
		}
	}

	static void reverse(Stack<String> s) {
		if(!s.isEmpty()){
			String tmp = s.pop();
			reverse(s);	
			insertBottom(s,tmp);
		}
	}
	
	static void insertBottom(Stack<String> s, String str) {
		if(s.isEmpty()) {
			s.push(str);
		} else {
			String x = s.pop();
			insertBottom(s, str);
			s.push(x);
		}
	}
}
