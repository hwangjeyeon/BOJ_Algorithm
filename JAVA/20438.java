import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 탐색 + 누적합 문제다
 * 2. -1은 조는 학생, 1은 출석한 학생, 0은 출석하지 않은 학생으로 판단한다
 * 3. 미리 조는 학생을 체크한 뒤, 이후 출석 호명 학생이 -1인 경우 스킵한다
 * 4. 아닌 경우 출석체크 한 다음, 그 학생의 배수만큼 n+2번 학생까지 탐색해서 출석체크해준다
 * 5. 여기까지 문제는 없으나 출력할때는 시간초과 위험이 있다. 시간제한이 0.1이기 때문이다
 * 6. 왜냐하면 n은 5천이라 이중포문도 상관없지만 m은 5만이라 n*m은 0.1초를 넘는다
 * 7. 따라서 누적합 방식으로 n+3의 크기를 갖는 배열을 만들고, 3부터 시작해서 자신의 이전까지 출석하지 않은 학생수를 세어서 보관한다
 * 8. 이후 s와 e를 입력받고, ans[e] - ans[s-1]의 값을 출력한다. 이때 s-1을 해줘야지 s에서 자기자신을 포함한 수까지 빼지 않는다
 * 9. 이렇게 하면 m만큼 진행하므로 시간제한의 걱정이 없으며, 출력을 m만큼 하므로 꼭 '\n'을 출력에 포함하자
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] visited = new int[50_001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int a = Integer.parseInt(st.nextToken());
            visited[a] = -1;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(visited[a] == -1){
               continue;
            }
            visited[a] = 1;
            for (int j = a; j <= n+2; j+=a) {
                if(visited[j] == -1 || visited[j] == 1){
                    continue;
                }
                visited[j] = 1;
            }
        }
        int[] ans = new int[n+3];
        for (int i = 3; i < n + 3; i++) {
            for (int j = 3; j <= i; j++) {
                if(visited[j] != 1){
                    ans[i]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write((ans[e] - ans[s-1]) + "\n");
        }



        br.close();
        bw.close();
    }

}
