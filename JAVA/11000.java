import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 클래스로 도출할 수 있는 것들은 클래스로 도출하자
 * - times[n][2] 이런식의 배열 말고 Pair 형태의 변수가 있을 경우 클래스 필드로 만들어준 뒤 time[n]에 넣어주자
 * - 배열을 정렬해주어야한다. 시작시간을 기준으로 정렬하고 싶으므로 (o1,o2) -> o1.start - o2.start 람다 함수를 이용해서 오름차순 정렬을 해준다.
 * - 그 다음 우선순위 큐를 이용해서 종료시간을 우선순위 큐에 넣어주고, 만약 넣어줄 때, 맨 앞에 있는 값이 시작시간이 종료시간보다 크거나 같으면 우선순위 큐에서 빼준다.
 * - 순회할때마다 끝나는 시간을 넣어주는데 우선순위 큐이므로 알아서 정렬 되어서 따로 신경 쓸 필요가 없다.
 * - 이 방식으로 n까지 순회해서 넣어주고 이제 남은 우선순위 큐의 크기를 출력하면 정답이 된다.
 * - 강의가 시작할때동안 우선순위 큐에 있는 강의들은 끝나지 않았기 때문이다
 *
 * - 우선순위 큐 활용과 클래스 분리에 대해 생각을 하지 못해서 힌트를 보고 푼 문제다.
 * - 앞으로 우선순위 큐 활용 하는 문제를 더 많이 접하고 활룡하는 연습을 해야겠다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */
class Lecture{
    int start;
    int end;

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Lecture[] times = new Lecture[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            times[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(times, (o1, o2) -> o1.start - o2.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(times[0].end);

        for (int i = 1; i < n; i++) {
            if(pq.peek() <= times[i].start){
                pq.poll();
            }

            pq.offer(times[i].end);
        }

        bw.write(String.valueOf(pq.size()));

        br.close();
        bw.close();
    }


}

