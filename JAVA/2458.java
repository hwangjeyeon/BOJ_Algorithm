import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 플로이드 워셜로 풀 수 있다
 * 2. 일단 n의 크기가 작고.. (사실 정 계산하면 시간초과긴 하다.) 시작지점과 목표지점이 이어져있지 않지만 중간지점을 거쳐서 목표지점으로 갈 수 있다면 시작지점과 목표지점이 이어졌다고 판단해야한다
 * 3. 따라서 플로이드 워셜로 풀 수 있는 문제다
 * 4. 플로이드 워셜로 두 정점이 연결되어있는지만 판단하면 되기때문에 2차원 배열과 boolean 타입으로 선언해서 데이터를 관리한다
 * 5. 참고로 이 문제의 그래프는 단방향 그래프다
 * 6. 이어서 플로이드 어셜을 통해 중간지점을 통해 이어질 수 있는 정점을 이어준다
 * 7. 이제 이 지점이 자신을 제외한 모든 지점과 연결되어있는지 판단해야한다
 * 8. 정점크기를 갖는 count 배열을 선언한다. int형 타입으로 선언해서 얼마나 이어져 있는지 판단한다
 * 9. 이중포문을 돌면서 현재 지점으로 들어오거나 현재지점에서 나가나는 간선의 개수를 세어준다
 * 10. 그리고 최종적으로 모든 정점을 확인하며, 만약 현재 정점의 연결 간선의 개수가 자신을 제외한 개수인 n-1과 같다면 정답의 개수를 증가시킨다
 * 11. 완성한 ans를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^3)
 * 공간복잡도: O(n^2)
 *
 */

public class Main {

    static boolean[][] lists;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lists = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a][b] = true;
        }
        floydWarshall();

        int[] count = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(lists[i][j] || lists[j][i]) {
                    count[i]++;
                }
            }
        }
        int ans = 0;
        for (int a : count) {
            if(a == n-1){
                ans++;
            }
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void floydWarshall() {
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if(lists[i][k] && lists[k][j]){
                        lists[i][j] = true;
                    }
                }
            }
        }
    }
}
