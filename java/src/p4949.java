import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.IOException;


public class p4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        while (true) {
            String input = br.readLine();
            if (input.equals(".")) {
                break;
            }
            stack.clear();
            boolean flag = true;

            for (int i = 0; i < input.length(); i++) {
                char item = input.charAt(i);
                if (item == '(') {
                    stack.push(item);
                } else if (item == '[') {
                    stack.push(item);
                } else if (item == ')') {
                    if (stack.isEmpty() || (stack.pop() != '(')) {
                        flag = false;
                        break;
                    }
                } else if (item == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
