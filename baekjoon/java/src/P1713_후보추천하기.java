import java.util.*;

public class p1713 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Person> frame = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < m; i++){
            int x = sc.nextInt();
            if (frame.size() < n){
                boolean flag = false;
                for (Person p : frame){
                    if (p.who == x){
                        p.cnt++;
                        flag = true;
                        break;
                    }
                }
                if (!flag){
                    frame.add(new Person(index, x, 1));
                }
            }
            else {
                boolean flag = false;
                for (Person p : frame){
                    if (p.who == x){
                        p.cnt++;
                        flag = true;
                        break;
                    }
                }
                if (!flag){
                    Collections.sort(frame, (p1, p2) ->{
                        if (p1.cnt == p2.cnt){
                            return p1.index - p2.index;
                        }
                        return p1.cnt - p2.cnt;
                    });
                    frame.remove(0);
                    frame.add(new Person(index, x, 1));
                }
            }
            index++;
        }
        Collections.sort(frame, (p1, p2) ->{
            return p1.who - p2.who;
        });
        for (int i = 0; i < n; i++){
            System.out.printf("%d ", frame.get(i).who);
        }
    }
}

class Person{
    int index;
    int who;
    int cnt;

    public Person(int index, int who, int cnt) {
        this.index = index;
        this.who = who;
        this.cnt = cnt;
    }
}