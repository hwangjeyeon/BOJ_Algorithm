import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 클래스로 선언한뒤, 큐에다가 넣고 주어진 대로 구현하면 되는 문제다
 * 2. 큐의 크기가 1보다 큰동안 반복하면서, 큐에서 하나 뽑은 값의 num-1만큼 순회하고 큐에서 빼서 다시 넣어주낟
 * 3. 순회 종료 후, 큐에서 한번 더 빼준다
 * 4. 최종적으로 남은 큐의 peek의 name을 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n/2 * 학번합산)
 * 공간복잡도: O(n)
 *
 */
class Member{
    String name;
    int num;

    public Member(String name, int num) {
        this.name = name;
        this.num = num;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Queue<Member> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            q.add(new Member(s, num));
        }

        while(q.size() > 1){
            Member m = q.poll();
            for (int i = 0; i < m.num - 1; i++) {
                Member m1 = q.poll();
                q.add(m1);
            }
            q.poll();
        }
        bw.write(q.poll().name+"");

        br.close();
        bw.close();
    }
}
