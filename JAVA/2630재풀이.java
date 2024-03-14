import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * 재귀
 * 1. 함수 형태 confetti(field, x,y, size)
 * 2. base Condition 특정 조건에 해당하는 경우 해당 좌표에 해당하는 배열의 값 증가시키고 종료
 * -> 모든 주어진 크기만큼 배열의 모든 좌표를 돌아 같은값으로만 이루어져있는지 확인
 * 3. 재귀식
 * 분할정복으로 4번 돌아주면 된다
 * confetti(field, x,y, size/2);
 * confetti(field, x,y+size/2, size/2);
 * confetti(field, x+size/2,y, size/2);
 * confetti(field, x+size/2,y+size/2, size/2);
 *
 * - 문제 해결:
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */


public class Main {
    static int[] ans = {0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] field = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        confetti(field, 0,0, n);

        for (int an : ans) {
            bw.write(an+"\n");
        }

        br.close();
        bw.close();
    }

    private static void confetti(int[][] field, int x, int y, int size) {
        if(sameColor(field, x,y, size)){
            ans[field[y][x]]++;
            return;
        }

        int newSize = size / 2;
        confetti(field, x,y, newSize);
        confetti(field, x,y+ newSize, newSize);
        confetti(field, x+ newSize,y, newSize);
        confetti(field, x+ newSize,y + newSize, newSize);

    }

    private static boolean sameColor(int[][] field, int x, int y, int size) {
        int now = field[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if(field[i][j] != now){
                    return false;
                }
            }
        }


        return true;
    }

}

