import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 음수영역을 고려해 확장한 방문배열을 하나 만들어서 case별로 체크한다
 * 2. 최종적으로 배열을 순회해서 true의 개수를 세어준뒤 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nowY = 1000;
        int nowX = 1000;
        int l = Integer.parseInt(br.readLine());
        String s = br.readLine();
        boolean[][] arr = new boolean[2001][2001];
        arr[1000][1000] = true;

        for (int i = 0; i < l; i++) {
            switch (s.charAt(i)) {
                case 'S':
                    nowY--;
                    arr[nowY][nowX] = true;
                    break;
                case 'E':
                    nowX++;
                    arr[nowY][nowX] = true;
                    break;
                case 'N':
                    nowY++;
                    arr[nowY][nowX] = true;
                    break;
                case 'W':
                    nowX--;
                    arr[nowY][nowX] = true;
                    break;
            }
        }

        int ans = 0;
        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) {
                if(arr[i][j]){
                    ans++;
                }
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}
