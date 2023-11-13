import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * 자바 진법 변환 정리
 * 10진수 -> n진수
 * - String 자료형이 필요하다
 * -> String ans = Integer.toString(숫자, 지수);
 *
 * n진수 -> 10진수
 * String 형 n진수를 int형으로 바꿈
 * -> Integer.parseInt(숫자, 지수);
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
        int count = Integer.parseInt(st.nextToken());
        int base = Integer.parseInt(st.nextToken());
        String ans = Integer.toString(count,base).toUpperCase();

        bw.write(ans+"");


        br.close();
        bw.close();
    }


}
