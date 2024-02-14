import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 라인 스위핑 문제라고 한다. 소마 코테 이후에 알고리즘 개념 공부할 때, 라인 스위핑 + 공간 스위핑 개념 학습 후 관련 문제 풀어보자
 * - 시작점을 기준으로 오름차순 정렬을 하는데, 같으면 끝점을 기준으로 정렬을 한다
 * - 이어서 비교하는데 먼저 기준이 되는 시작과 끝을 맨 처음 좌표 값으로 설정해준다
 * - 이제 순회를 통해 비교하는데 현재 좌표의 시작점이 끝점보다 작으면, 현재 끝점과 현재 좌표의 끝점중 더 큰 값을 현재 끝점으로 설정해준다
 * - 만약 크거나 같다면 새로운 선분이 시작하는것이므로 ans에 end-start를 더해주고 start와 end를 각각 현재 좌표의 start와 end로 초기화해준다
 * - 이렇게 순회를 마치고 나서 마지막 선분의 길이를 추가로 갱신하고 ans를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */
class Line{
    int start;
    int end;

    public Line(int start, int end) {
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
        Line[] lines = new Line[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines[i] = new Line(a,b);
        }
        Arrays.sort(lines, (o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);

        int start = lines[0].start;
        int end = lines[0].end;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if(lines[i].start < end){
                end = Math.max(end, lines[i].end);
            }else{
                ans += end - start;
                start = lines[i].start;
                end = lines[i].end;
            }
        }
        ans += end - start;
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

