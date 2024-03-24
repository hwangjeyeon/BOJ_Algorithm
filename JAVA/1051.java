import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 *
 *
 *
 * 문제 해결:
 * 1. 직사각형에서 둘 중 길이가 더 짧은 것이 정사각형의 길이가 될 것이다.
 * 2. 이것을 기준으로 해당 길이부터 1씩 줄여나가면서 정사각형이 될 수 있는 경우를 탐색한다
 * 3. 0 ~ n-pivot와 0 ~ m-pivot만큼 순회하면서, 현재 위치를 기준으로 잡고 현재위치에서 가로 방향과 세로방향 그리고 대각선 방향만 탐색하면 된다.
 * 4. 가능한 가장 큰 정사각형부터 점차 줄여나가므로 발견하면 출력하고 종료한다.
 * 5. 만약 순회에서 발견하지 못하면 pivot은 1이 될테니 1을 출력하면 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(m)
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] field = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(input[j]);
            }
        }

        int pivot = Math.min(n,m);
        while(pivot > 1){
            for (int i = 0; i <= n - pivot; i++) {
                for (int j = 0; j <= m - pivot; j++) {
                    int tmp = field[i][j];
                    if(tmp == field[i][j+pivot-1] && tmp == field[i+pivot-1][j] && tmp == field[i+pivot-1][j+pivot-1]){
                        bw.write((pivot*pivot)+"");
                        br.close();
                        bw.close();
                        return;
                    }
                }
            }
            pivot--;
        }
        bw.write((pivot*pivot)+"");


        br.close();
        bw.close();
    }

}
