import java.util.Scanner;

//public class P12327_Disk_Scheduling {
//    private static Scanner sc;
//    private static UserSolution userSolution = new UserSolution();
//
//    private static int mSeed;
//    private static int mrand(int num)
//    {
//        mSeed = mSeed * 1103515245 + 37209;
//        if (mSeed < 0) mSeed *= -1;
//        return ((mSeed >> 8) % num);
//    }
//    private static final int CMD_REQUEST = 0;
//    private static final int CMD_FCFS = 1;
//    private static final int CMD_SSTF = 2;
//    private static final int CMD_LOOK = 3;
//    private static final int CMD_CLOOK = 4;
//
//    private static final int MAX = 100000;
//    private static final int SAMPLE_SIZE = 200;
//
//    private static int track_size;
//    private static int track_head;
//    private static int answer[] = new int[MAX];
//    private static int answer_size;
//    private static int answer_idx;
//    private static int req_q[] = new int[MAX];
//    private static int req_size;
//    private static int req_idx;
//    private static int cmd_q[] = new int[MAX*2];
//    private static int cmd_size;
//    private static int cmd_idx;
//
//    private static boolean flag[] = new boolean[MAX];
//
//    private static void load_data(int tc){
//        track_size = sc.nextInt();
//        track_head = sc.nextInt();
//
//        if(tc <= 4){
//            req_size = sc.nextInt();
//            for(int i = 0; i < req_size; ++i) req_q[i] = sc.nextInt();
//            cmd_size = sc.nextInt();
//            for(int i = 0; i < cmd_size; ++i) cmd_q[i] = sc.nextInt();
//            answer_size = sc.nextInt();
//            for(int i = 0; i < answer_size; ++i) answer[i] = sc.nextInt();
//        }
//        else{
//            req_size = sc.nextInt();
//            answer_size = sc.nextInt();
//            for(int i = 0; i < answer_size; ++i) answer[i] = sc.nextInt();
//            mSeed = sc.nextInt();
//            cmd_size = req_size + answer_size;
//        }
//    }
//
//
//    private static int run(int tc){
//        answer_idx = req_idx = cmd_idx = 0;
//        int correct = 0;
//        int cmd = 0;
//        int user_answer = 0;
//        int new_track = 0;
//        int req_cnt = 0;
//
//        for(int i = 0; i < track_size; ++i) flag[i] = false;
//
//        while(req_size != req_cnt || (tc <= 4 && cmd_size != cmd_idx)){
//            if(tc <= 4)	cmd = cmd_q[cmd_idx++];
//            else cmd = mrand(9);
//
//            user_answer = -1;
//
//            if(CMD_FCFS <= cmd && CMD_CLOOK >= cmd && (req_cnt - answer_idx) > 0){
//                if(cmd == CMD_FCFS) user_answer = userSolution.fcfs();
//                else if(cmd == CMD_SSTF) user_answer = userSolution.sstf();
//                else if(cmd == CMD_LOOK) user_answer = userSolution.look();
//                else user_answer = userSolution.clook();
//
//                if(answer[answer_idx++] == user_answer)	++correct;
//            }
//            else{
//                if(tc <= 4) new_track = req_q[req_idx++];
//                else{
//                    new_track = mrand(track_size);
//                    while(flag[new_track]) {
//                        ++new_track;
//                        if(new_track == track_size) new_track = 0;
//                    }
//                }
//
//                userSolution.request(new_track);
//                flag[new_track] = true;
//                ++req_cnt;
//            }
//        }
//
//        return correct;
//    }
//
//    public static void main(String arg[]) throws Exception {
//        //System.setIn(new java.io.FileInputStream("sample_input.txt"));
//        sc = new Scanner(System.in);
//
//        int total_score = 0;
//        int T = sc.nextInt();
//
//        for(int tc = 1; tc <= T; ++tc){
//            load_data(tc);
//            userSolution.init(track_size, track_head);
//            int score = run(tc);
//            System.out.println("#" + tc + " " + score);
//            total_score += score;
//        }
//        System.out.println("Total Score: " + total_score);
//        sc.close();
//    }
//}

class P12327_UserSolution {

    class Node {
        int track;
        Node next_req;
        Node prev_req;
        Node next_track;
        Node prev_track;

        public Node(int track){
            this.track = track;
            this.next_req = null;
            this.prev_req = null;
            this.next_track = null;
            this.prev_track = null;
        }
    }

    private static int MAX = 100000;
    private static int header;
    Node reqHead;
    Node reqTail;
    Node trackHead;
    Node trackTail;
    boolean flag;

    public void init(int track_size, int head){
        header = head;
        reqHead = new Node(-1);
        reqTail = new Node(100001);
        trackHead = new Node(-1);
        trackTail = new Node(100001);

        reqHead.next_req = reqTail;
        trackHead.next_track = trackTail;
        reqTail.prev_req = reqHead;
        trackTail.prev_track = trackHead;
        flag = false;
    }

    public void arrange(Node target){
        Node prevReq = target.prev_req;
        Node nextReq = target.next_req;
        Node prevTrack = target.prev_track;
        Node nextTrack = target.next_track;

        prevReq.next_req = nextReq;
        nextReq.prev_req = prevReq;
        prevTrack.next_track = nextTrack;
        nextTrack.prev_track = prevTrack;
    }
    public void addReq(Node newNode){
        Node target = trackHead;
        while (target.next_track != null){
            target = target.next_track;
            if (newNode.track > target.track) continue;
            else break;
        }
        Node prev = target.prev_track;
        newNode.next_track = target;
        target.prev_track = newNode;
        newNode.prev_track = prev;
        prev.next_track = newNode;
    }

    public void request(int track){
        Node newNode = new Node(track);
        Node prev = reqTail.prev_req;
        prev.next_req = newNode;
        newNode.prev_req = prev;
        newNode.next_req = reqTail;
        reqTail.prev_req = newNode;

        addReq(newNode);

//        test();
    }

    public int fcfs(){
        Node target = reqHead.next_req;
        header = target.track;
        arrange(target);
        return header;
    }

    public Node find(){
        Node target = trackHead;
        while (target.next_track != null){
            target = target.next_track;
            if (header > target.track) continue;
            else break;
        }
        if (target.next_track == null){
            return target.prev_track;
        }
        if (target.prev_track.prev_track == null){
            return target;
        }
        Node prev = target.prev_track;
        int left = prev.track - header;
        int right = target.track - header;
        left = left * left;
        right = right * right;
        if (right < left) return target;
        else return prev;
    }

    public int sstf(){
        Node target = find();
        header = target.track;
        arrange(target);
//        System.out.println("sstf");
//        System.out.println(header);
//        test();
        return header;
    }

    public int look(){
        Node target = trackHead;
        while (target.next_track != null){
            target = target.next_track;
            if (header > target.track) continue;
            else break;
        }
        if (flag){
            if (target.next_track == null){
                flag = !flag;
                target = target.prev_track;
            }
            arrange(target);
            header = target.track;
            return header;
        }
        else {
            target = target.prev_track;
            if (target.prev_track == null){
                flag = !flag;
                target = target.next_track;
            }
            arrange(target);
            header = target.track;
            return header;
        }
    }

    public int clook(){
        Node target = trackHead;
        while (target.next_track != null){
            target = target.next_track;
            if (header > target.track) continue;
            else break;
        }
        target = target.prev_track;
        if (target.prev_track == null){
            target = trackTail.prev_track;
        }
        header = target.track;
        arrange(target);
        return header;
    }

    public void test(){
        Node tmp = reqHead.next_req;
        System.out.println("req");
        while(tmp.next_req != null){
            System.out.printf("%d ", tmp.track);
            tmp = tmp.next_req;
        }
        System.out.println("\n");
        System.out.println("track");
        tmp = trackHead.next_track;
        while(tmp.next_track != null){
            System.out.printf("%d ", tmp.track);
            tmp = tmp.next_track;
        }
        System.out.println("\n");
    }
}
