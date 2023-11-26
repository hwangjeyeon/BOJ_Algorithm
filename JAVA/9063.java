import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - x좌표 y좌표 최대 최소를 각각 구한뒤 최대에서 최소를 빼준 각 x좌표와 y좌표를 곱하면 된다
 * - 한가지 주의할 점이 음수도 입력 범위에 있기 때문에 각각을 곱하기 전에 절대값으로 바꾼 다음 곱해야한다.
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int maxX = -10001;
        int minX = 10001;
        int maxY = -10001;
        int minY = 10001;
        int nowX;
        int nowY;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            nowX = Integer.parseInt(st.nextToken());
            nowY = Integer.parseInt(st.nextToken());
            if(maxX < nowX){
                maxX = nowX;
            }

            if(nowX < minX){
                minX = nowX;
            }

            if(maxY < nowY){
                maxY = nowY;
            }

            if(nowY < minY){
                minY = nowY;
            }
        }

        StringBuilder sb = new StringBuilder().append(Math.abs(maxX-minX) * Math.abs(maxY - minY));
        bw.write(sb.toString());


        br.close();
        bw.close();
    }

}
