import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 재귀
 * 1. 함수식: spy(미션표 배열, 시작일, 종료일, 최소진척도, 현재 진척도, 이전 위치 x좌표)
 * 2. base Condition: 시작일과 종료일이 같아졌을 때 -> 현재 진척도가 최소 진척도보다 크면 count값 증가
 * 3. 재귀식: spy(미션표 배열, 시작일+1, 종료일, 최소진척도, 현재진척도 + field[i][j], 이전 위치 x좌표)
 * 
 *
 * 문제 해결:
 *
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(logn)
 *
 *
 */

public class Main {

    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] missions = new int[2][3];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                missions[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        spy(missions, 0, n, m, 0, -1);

        bw.write(count+"");

        br.close();
        bw.close();
    }

    private static void spy(int[][] missions, int start, int n, int m, int work, int x) {
        if(start == n){
            if(work >= m){
                count++;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if(x == j){
                    spy(missions, start+1, n,m, work + missions[i][j]/2, j);
                }else{
                    spy(missions, start+1, n,m, work + missions[i][j],j);
                }

            }
        }
    }

}
