import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class p3425 {
    static Stack<Long> goStack = new Stack();
    static List<Command> commands = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            while(true){
                String input = sc.next();

                if (input.equals("QUIT")){
                    return;
                } else if (input.equals("END")){
                    break;
                } else {
                    long param = 0;
                    if (input.equals("NUM")){
                        param = sc.nextLong();
                    }
                    commands.add(new Command(input, param));
                }
            }
            int numLength = sc.nextInt();
            for (int i = 0; i < numLength; i++){
                long input = sc.nextLong();
                goStack.push(input);
                boolean flag = false;

                for (Command command : commands){
                    if (flag) break;
                    switch (command.cmd) {
                        case "NUM":
                            goStack.push(command.param);
                            break;
                        case "POP":
                            if (!goStack.isEmpty()){
                                goStack.pop();
                            }
                            else {
                                flag = true;
                                break;
                            }
                            break;
                        case "INV":
                            if (!goStack.isEmpty()){
                                long x = goStack.pop();
                                goStack.push(x * -1);
                            }
                            else {
                                flag = true;
                                break;
                            }
                            break;
                        case "DUP":
                            if (!goStack.isEmpty()){
                                long x = goStack.peek();
                                goStack.push(x);
                            }
                            else {
                                flag = true;
                                break;
                            }
                            break;
                        case "SWP":
                            if (goStack.size() >= 2){
                                long first = goStack.pop();
                                long second = goStack.pop();
                                goStack.push(first);
                                goStack.push(second);
                            }
                            else {
                                flag = true;
                                break;
                            }
                            break;
                        case "ADD":
                            if (goStack.size() >= 2){
                                long first = goStack.pop();
                                long second = goStack.pop();
                                long sum = first + second;
                                if (Math.abs(sum) <= 1000000000){
                                    goStack.push(sum);
                                }
                                else{
                                    flag = true;
                                    break;
                                }
                            }
                            else {
                                flag = true;
                                break;
                            }
                            break;
                        case "SUB":
                            if (goStack.size() >= 2){
                                long first = goStack.pop();
                                long second = goStack.pop();
                                long sum = second - first;
                                if (Math.abs(sum) <= 1000000000){
                                    goStack.push(sum);
                                }
                                else{
                                    flag = true;
                                    break;
                                }
                            }
                            else {
                                flag = true;
                                break;
                            }
                            break;
                        case "MUL":
                            if (goStack.size() >= 2){
                                long first = goStack.pop();
                                long second = goStack.pop();
                                long sum = first * second;
                                if (Math.abs(sum) <= 1000000000){
                                    goStack.push(sum);
                                }
                                else{
                                    flag = true;
                                    break;
                                }
                            }
                            else {
                                flag = true;
                                break;
                            }
                            break;
                        case "DIV":
                            if (goStack.size() >= 2){
                                long first = goStack.pop();
                                long second = goStack.pop();
                                if (first == 0){
                                    flag = true;
                                    break;
                                }
                                long x = Math.abs(second) / Math.abs(first);

                                if (first * second < 0){
                                    goStack.push(-x);
                                }
                                else {
                                    goStack.push(x);
                                }
                            }
                            else {
                                flag = true;
                                break;
                            }
                            break;
                        case "MOD":
                            if (goStack.size() >= 2){
                                long first = goStack.pop();
                                long second = goStack.pop();
                                if (first == 0){
                                    flag = true;
                                    break;
                                }
                                long x = Math.abs(second) % Math.abs(first);

                                if (second < 0){
                                    goStack.push(-x);
                                }
                                else {
                                    goStack.push(x);
                                }
                            }
                            else {
                                flag = true;
                                break;
                            }
                            break;
                    }
                }
                if (flag || goStack.size() != 1){
                    System.out.println("ERROR");
                }
                else {
                    System.out.println(goStack.pop());
                }
                goStack.clear();
            }
            commands.clear();
            System.out.println();
        }
    }
}

class Command {
    String cmd;
    long param;

    public Command(String cmd, long param) {
        this.cmd = cmd;
        this.param = param;
    }
}