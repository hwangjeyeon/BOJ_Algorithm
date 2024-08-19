import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 8방 DFS를 이용하면 쉽게 풀 수 있는 문제다
 * 2. 약간 변형을 시켜서 문제의 조건에 맞도록 범위를 벗어나면 다시 반대편 위치로 돌아가도록 한뒤, dfs를 재귀로 반복한다
 * 3. find의 값이랑 현재 완성한 문자열이 같다면 ans를 증가시키고 종료하며, depth가 find길이랑 같다면 종료한다
 * 4. 모든 지점을 대상으로 시작지점으로 한 뒤, 그 지점의 문자를 시작 문자로 넘겨야 한다.
 * 5. 이 문제에서 중복된 find 문자를 줄 수 있으므로 Map을 사용해서 ans 값을 등록해야한다
 * 6. dfs 실행 전에 만약 키로 등록되어 있다면 그 값을 출력하면 된다. 이렇게 안하면 시간초과가 발생한다..
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n*m*|S|*8)
 * 공간복잡도: O(n*m)
 *
 */

public class Main {

    static char[][] arr;
    static String find;
    static int ans = 0;
    static int[] dy = {-1,-1,-1, 0,0, 1,1,1};
    static int[] dx = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            find = br.readLine();
            ans = 0;
            if(map.containsKey(find)) {
                bw.write(map.get(find)+"\n");
                continue;
            }
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    dfs(j,l, n, m, find.length(), String.valueOf(arr[j][l]), 1);
                }
            }
            map.put(find, ans);
            bw.write(ans+"\n");
        }

        br.close();
        bw.close();
    }

    private static void dfs(int y, int x, int n, int m, int length, String s, int depth) {

        if(s.equals(find)){
            ans++;
            return;
        }

        if(depth == length){
            return;
        }


        for (int i = 0; i < 8; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if(ny < 0){
                ny = n-1;
            }

            if(nx < 0){
                nx = m-1;
            }

            if(ny >= n){
                ny = 0;
            }

            if(nx >= m){
                nx = 0;
            }

            dfs(ny,nx,n,m,length,s + arr[ny][nx], depth+1);
        }

    }

}

