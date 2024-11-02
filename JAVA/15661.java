import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 부분집합을 이용하여 해결할 수 있는 풀이다. 조합으로도 해결할 수 있는데, 그것은 다음에 다시 도전할 때 시도해볼 방법이다
 * 2. 의무참석이 아니고 팀원수가 같지 않아도 되지만 최소 한명 선택되어야한다가 부분집합을 선언하는 핵심 키워드이다
 * 3. 한쪽 팀의 공집합이 충분히 나올 수 있다. 팀원별 팀원 정보를 출력해야한다면 고려해야겠지만 여기서는 팀원의 차이만을 구하면 된다
 * 4. 공집합일 때 팀원의 차이는 최소값이 나올 수가 없다. 따라서 고려하지 않아도 된다
 * 5. 굳이 파라미터에 리스트나 배열, 문자열을 둬서 넘길 필요가 없다. 팀이 두개밖에 없기 때문에 방문배열만으로도 충분히 해결 가능하다
 * 6. 부분 집합은 선택하냐 안하냐로 나눠서 풀 수 있다. 따라서 백트래킹 두개를 두고, 방문배열 체크 후 돌리는 재귀함수와 해제 후 돌리는 재귀함수를 작성하면 된다
 * 7. depth가 n일 때는 start와 link 변수를 0으로 초기화하여 선언한 뒤에 n만큼 순회를 돌면서 방문 체크 여부에 따라 각각의 숫자를 증가시키면된다
 * 8. 단 7번의 경우 i와 j가 같은 경우가 있는데, 그 경우는 동일한 사람을 선택한 것이므로  continue 해주면 된다
 * 9. 완성한 start - link의 절댓값을 ans와 비교하여 더 작은 값으로 교체해준다
 * 10. 완성한 ans를 출력하면 정답이 된다.
 *
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(2^n)
 * 공간복잡도: O(n^2)
 *
 */

public class Main {

    static int ans = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n];
        backtracking(n, 0);

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void backtracking(int n, int depth){
        if(depth == n){
            int start = 0;
            int link = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    if(visited[i] != visited[j]){
                        continue;
                    }
                    if(visited[i]){
                        start += arr[i][j] + arr[j][i];
                    }else{
                        link += arr[i][j] + arr[j][i];
                    }
                }
            }
            ans = Math.min(ans, Math.abs(start - link));
            return;
        }
        visited[depth] = true;
        backtracking(n,depth+1);
        visited[depth] = false;
        backtracking(n, depth+1);
    }

}

