import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1.간단한 정렬 문제. 구분할 수 있는 num만 추가해주면 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */
class Pair{
    int num;
    int score;

    public Pair(int num, int score) {
        this.num = num;
        this.score = score;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Pair[] arr = new Pair[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = new Pair(i+1, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(arr, (o1, o2) -> {
            return o2.score - o1.score;
        });
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += arr[i].score;
        }
        bw.write(sum + "\n");

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(arr[i].num);
        }
        Collections.sort(list);

        for (Integer i : list) {
            bw.write(i + " ");
        }
        
        br.close();
        bw.close();
    }

}
