import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *  * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * y축 x축 모두 가까운 쪽을 구한 뒤에, x축과 y축 중 더 경계선과 가까운 쪽을 출력한다.
 * 
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 *
 */




public class Main {

    //static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int ansx;
        int ansy;
        if(w-x < x){
            ansx = w-x;
        }else{
            ansx = x;
        }
        if(h-y < y){
            ansy = h-y;
        }else{
            ansy = y;
        }

        if(ansx < ansy){
            bw.write(ansx + "");
        }else{
            bw.write(ansy + "");
        }


        br.close();
        bw.close();
    }


}
