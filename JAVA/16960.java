import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 리스트배열과 방문배열 사용해서 완탐하면 되는 문제다
 * 2. 스위치에 연결된 램프가 여러개이므로, 리스트 배열을 사용해서 관리해준다
 * 3. 이후 먼저 n-1개를 선택하기 위해 n개중 하나만 제외했을때의 모든 경우를 순회한다
 * 4. 그 안에서 모든 스위치를 확인하며, 연결된 램프들을 방문체크처리한다
 * 5. 방문했으면 스킵한다
 * 6. 완성한 뒤, 다시 램프를 순회하며 모두 켜졌는지 확인하고 켜졌다면 1을 출력한 뒤 탈출한다
 * 7. 참고로 방문배열은 제외할 스위치를 선택할 때마다 초기화해야한다. 이렇게 해야지 다른 탐색에 영향을 주지 않기 때문이다
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n^2 + m)
 * 공간복잡도: O(n)
 *
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            boolean[] visited = new boolean[m+1];
            for (int j = 1; j < n + 1; j++) {
                if(i == j){
                    continue;
                }
                for (int k = 0; k < list[j].size(); k++) {
                    visited[list[j].get(k)] = true;
                }
            }
            boolean isOk = true;
            for (int j = 1; j < m + 1; j++) {
                if(!visited[j]){
                    isOk = false;
                    break;
                }
            }
            if(isOk){
                ans = 1;
                break;
            }
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
