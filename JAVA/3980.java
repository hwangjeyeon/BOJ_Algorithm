import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 깔끔하게 백트래킹으로 푸는 문제다
 * 2. 11 * 11 크기의 int형 타입의 2차원 배열을 만들어주고, 각 선수의 포지션 능력 데이터를 관리한다
 * 3. 방문 체크를 위한 11크기의 배열과 백트래킹 결과를 담을 리스트를 하나 만들어준다
 * 4. 백트래킹 메소드를 만드는데 depth와 sum을 파라미터로 받는다.
 * 5. 각 백트래킹마다 11만큼 순회를 돌면서 현재 깊이에서의 선수별 능력치를 확인한다
 * 6. 이때 방문하지 않았고 0이 아닌 경우에만 방문 체크 후 재귀문을 돌려서 현재 선수의 능력치를 sum에 더하고 depth도 증가시킨다
 * 7. 재귀문이 끝나면 방문배열 체크를 해제한다
 * 8. base condition은 depth가 11이 되었을 때이며, 리스트에 완성한 sum을 넣어주고 종료한다
 * 9. 완성한 리스트를 내림차순 정렬하고 첫번째 인덱스의 값을 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(11^5)
 * 공간복잡도: O(11*11)
 *
 */


public class Main {

    static int[][] arr = new int[11][11];
    static boolean[] visited;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 11; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 11; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            list = new ArrayList<>();
            visited = new boolean[11];
            backtracking(0, 0);
            list.sort(Collections.reverseOrder());
            bw.write(list.get(0)+"\n");
        }

        br.close();
        bw.close();
    }

    private static void backtracking(int depth, int sum) {
        if(depth == 11){
            list.add(sum);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if(!visited[i] && arr[i][depth] != 0){
                visited[i] = true;
                backtracking(depth+1, sum + arr[i][depth]);
                visited[i] = false;
            }
        }

    }
}

