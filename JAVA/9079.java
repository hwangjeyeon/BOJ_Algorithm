import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 나올 수 있는 8가지 경우의 수를 idx로 하고, count에 선택된 개수를 누적하는 백트래킹으로 푸는 문제였다
 * 2. 매 재귀마다 모든 원소가 같은지 확인하고 같으면 ans에 최소값을 넣어준다
 * 3. 가로를 뒤집는 경우 3가지 세로를 뒤집는 경우 3가지, 대각선 2가지는 count+1을 해주며, 아예 선택 안하는 경우도 존재하는데 이때는 count는 증가시키지 않고 idx만 증가시킨다
 * 4. 완성한 결과를 테스트 케이스마다 출력하면 정답이 된다
 *
 *
 * 시간복잡도: O(9*8*3)
 * 공간복잡도: O(3*3)
 *
 */




public class Main {


    static int ans = Integer.MAX_VALUE;
    static boolean[][] visited = new boolean[3][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            visited = new boolean[3][3];
            for (int j = 0; j < 3; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 3; k++) {
                    char a = st.nextToken().charAt(0);
                    if(a == 'T'){
                        visited[j][k] = true;
                    }
                }
            }
            ans = Integer.MAX_VALUE;
            backtracking(0,0);
            if(ans == Integer.MAX_VALUE){
                bw.write("-1\n");
            }else{
                bw.write(ans+"\n");
            }

        }

        br.close();
        bw.close();
    }

    private static void backtracking(int count, int idx) {
        if(chk()){
            ans = Math.min(ans, count);
            return;
        }

        if(idx == 8){
            return;
        }

        backtracking(count, idx+1);
        if(idx < 3){
            for (int i = 0; i < 3; i++) {
                visited[idx][i] = !visited[idx][i];
            }
            backtracking(count+1, idx+1);
            for (int i = 0; i < 3; i++) {
                visited[idx][i] = !visited[idx][i];
            }
        }else if(idx < 6){
            for (int i = 0; i < 3; i++) {
                visited[i][idx-3] = !visited[i][idx-3];
            }
            backtracking(count+1, idx+1);
            for (int i = 0; i < 3; i++) {
                visited[i][idx-3] = !visited[i][idx-3];
            }
        }else if(idx == 6){
            for (int i = 0; i < 3; i++) {
                visited[i][i] = !visited[i][i];
            }
            backtracking(count+1, idx+1);
            for (int i = 0; i < 3; i++) {
                visited[i][i] = !visited[i][i];
            }
        }else{
            for (int i = 0; i < 3; i++) {
                visited[i][2-i] = !visited[i][2-i];
            }
            backtracking(count+1, idx+1);
            for (int i = 0; i < 3; i++) {
                visited[i][2-i] = !visited[i][2-i];
            }

        }

    }

    private static boolean chk() {
        boolean isFirst = visited[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(visited[i][j] != isFirst){
                    return false;
                }
            }
        }
        return true;
    }
}

