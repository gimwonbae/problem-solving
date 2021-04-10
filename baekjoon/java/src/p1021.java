import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1021 {
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < n+1; i++){
            deque.add(i);
        }
        int count = 0;

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (true) {
                Iterator<Integer> it = deque.iterator();
                int index = 0;
                while (it.hasNext()) {
                    if (it.next() == num) {
                        break;
                    }
                    index++;
                }

                if (index == 0) {
                    deque.pollFirst();
                    break;
                } else if (index > deque.size() / 2) {
                    deque.addFirst(deque.removeLast());
                    count++;
                } else {
                    deque.addLast(deque.removeFirst());
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
