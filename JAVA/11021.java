import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 현재 너무 바빠서 공부 못하는중... 일단 최소 경시대회나 최대 학술제까지는 단계별 해결 문제만 푸는걸로...
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * 너무 쉬운 문제라 생략
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write("Case #" + (i+1) + ": " + (a+b) + "\n");
        }

        br.close();
        bw.close();
    }

}
