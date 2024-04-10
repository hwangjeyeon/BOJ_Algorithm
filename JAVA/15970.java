import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 각 좌표의 속성을 클래스로 따로 만들어서 관리하였다
 * 2. 그리고 이중 포문을 통해 각 좌표와 색깔이 같은 좌표중에서 가장 거리가 짧은 좌표를 구하고 ans에 더해준다
 * 3. 완성한 ans를 출력하면 정답이 된다.
 *
 * 문제 해결:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 *
 */
class Point{
    int position;
    int color;

    public Point(int position, int color) {
        this.position = position;
        this.color = color;
    }
}


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Point[] arr = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            arr[i] = new Point(pos, col);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if(i==j){
                    continue;
                }

                if(arr[i].color == arr[j].color){
                    min = Math.min(Math.abs(arr[i].position - arr[j].position), min);
                }
            }
            ans += min;
        }
        bw.write(ans+"");


        br.close();
        bw.close();
    }

}
