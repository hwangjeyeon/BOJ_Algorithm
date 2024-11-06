import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. n이 작기 떄문에 완전탐색으로 해결 가능
 * 2. n^2만큼 순회하면서 2인 지점 발견
 * 3. 다시 n^2을 추가로 돌면서 1인 지점을 찾고, 거리를 계산.
 * 4. sum 변수에 거리 합산 저장
 * 5. 합산된 값과 현재 지점을 리스트에 저장
 * 6. 이후 리스트의 합산된 값을 기준으로, 오름차순 정렬.
 * 7. 오름차순 정렬된 리스트를 m만큼 순회를 돌면서 ans 배열에 합산 저장
 * 8. ans 출력
 * => 2가 m보다 많을 때, 모순 발생 -> 5 2일때, 해당 로직으로는 9가 나오지만 반례를 따졌을 때 7이 최소값이 되어야 함
 *
 * - 고민하는 다른 방법
 * 1. 2번 지점들을 백트래킹을 통해 선정한다
 * 2. base condition에서 n^2*m 루프를 통해 각 지점에 대한 치킨거리를 구하고 합산한다
 * 3. min값과 비교해서 최소값을 갱신한다.
 * -> 시간초과 발생할 것이다. ((n^2)^m) -> n의 최대 50, m의 최대 13 -> 2500^13이므로 시간초과 발생한다
 *
 * - 고민하는 또다른 방법
 * 1. 미리 치킨집들을 리스트에 넣고 조합을 할까? -> 각 조합마다 (n^2)^m이 되는게 문제니까 미리 각 위치를 리스트에 뽑아 넣고 m^m되도록 한 뒤에 base condition에서 처리하면 되지 않나?
 * -> 최악의 경우 100^13이라서 이것도 안됨... 백트래킹은 아예 선택지가 아닌 것일까??
 *
 *
 *
 * - 문제 해결:
 * 1. 미리 집들의 위치랑, 치킨집의 위치를 리스트로 뽑아 놓는다
 * 2. 내가 시간복잡도를 잘못 계산하였다. 조합이니까 13^13이 아니다! 13Cm이다 -> 최악의 경우? 13C6, 13C7
 * 3. 이러면 계산이 가능하다. 집 위치에 대해서 base condition에서만 확인가능하기에 굳이 리스트로 안 뽑아놔도 되겠지만, 시간복잡도를 줄이기 위해 미리 빼서 리스트에 넣어둔다
 * 4. 방문 배열로 선택된 치킨집 여부를 선택하자
 * 5. base conditino에 도달했을 때, 집의 개수만큼 돌면서 치킨집의 개수를 모두 확인한다. 이때, 치킨 거리를 구하기 위해 임시 변수로 min을 선언하고 최소값을 찾는다
 * 6. 각 집별로 찾은 최소값을 합산하는 sum 변수를 미리 선언해두고 합산한다
 * 7. ans와 sum을 비교해서 더 작은 값을 ans에 넣는다
 * 8. 완성한 ans를 출력하면 정답이 된다.
 *
 * 시간복잡도: O((치킨집개수_C_3) * 집의 개수 * 치킨집 개수)
 * 공간복잡도: O(n^2)
 *
 */

public class Main {

    static int[][] arr;
    static int ans = Integer.MAX_VALUE;
    static ArrayList<int[]> home;
    static ArrayList<int[]> chick;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        home = new ArrayList<>();
        chick = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1){
                    home.add(new int[]{i, j});
                }
                if(arr[i][j] == 2){
                    chick.add(new int[]{i, j});
                }
            }
        }
        visited = new boolean[chick.size()];
        backtracking(0, m, 0);


        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void backtracking(int start, int m, int depth) {
        if(depth == m){
            int sum = 0;
            for (int i = 0; i < home.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < chick.size(); j++) {
                    if(visited[j]){
                        min = Math.min(min, Math.abs(home.get(i)[0] - chick.get(j)[0]) + Math.abs(home.get(i)[1] - chick.get(j)[1]));
                    }
                }
                sum += min;
            }

            ans = Math.min(ans, sum);
            return;
        }

        for (int i = start; i < chick.size(); i++) {
            visited[i] = true;
            backtracking(i+1, m, depth+1);
            visited[i] = false;
        }

    }
}

