import java.util.*;

class 위장 {
    public int solution(String[][] clothes) {
        HashMap<String, List<String>> hm = new HashMap<>();

        for (String[] item : clothes){
            String key = item[1];
            String value = item[0];

            if (hm.containsKey(key)) hm.get(key).add(value);
            else {
                List<String> arr = new ArrayList<>();
                arr.add(value);
                hm.put(key, arr);
            }
        }
        int answer = 1;
        for (String key : hm.keySet()){
            answer *= hm.get(key).size() + 1;
        }
        return answer - 1;
    }
}