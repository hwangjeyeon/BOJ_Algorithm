import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 덱을 써서 지정한 수 - 1 만큼 맨 앞의 수를 빼서 뒤에 넣어주면 된다
 * 2. 그리고 맨 앞에 있는 수를 출력하는 것을 게임 횟수만큼 반복하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(num*T)
 * 공간복잡도: O(2*n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        Deque<Integer> de = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2*n; i++) {
            de.addLast(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num-1; j++) {
                de.addLast(de.pollFirst());
            }
            bw.write(de.peekFirst() + " ");
        }

        br.close();
        bw.close();
    }
}
