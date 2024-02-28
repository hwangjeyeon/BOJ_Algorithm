import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 이전 재귀 문제와 종료조건도 그렇고 재귀 인수도 다 비슷한 문제다
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {
    static StringBuilder sb = new StringBuilder();
    static void star1(int n, int count){
        if(count < 0){
            return;
        }

        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }

        for (int i = 0; i < n; i++) {
            sb.append("*");
        }

        sb.append("\n");
        star1(n+1, count-1);
    }

    static void star2(int n, int count){
        if(n < 0){
            return;
        }

        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }

        for (int i = 0; i < n; i++) {
            sb.append("*");
        }

        sb.append("\n");
        star2(n-1, count+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        star1(1, n-1);
        star2(n-1, 1);


        bw.write(sb.toString()+"");

        br.close();
        bw.close();
    }

}

