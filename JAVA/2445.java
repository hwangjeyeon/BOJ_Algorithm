import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 똑같은 재귀함수를 인수와 종료조건만 다르게해서 메인 영역에서 두번 호출하면 되는 문제이다.
 * 
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

        for (int i = 0; i < n; i++) {
            sb.append("*");
        }

        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }

        for (int i = 0; i < n; i++) {
            sb.append("*");
        }

        sb.append("\n");
        star1(n+1, count-2);
    }
    static void star2(int n, int count){
        if(n <= 0){
            return;
        }

        for (int i = 0; i < n; i++) {
            sb.append("*");
        }

        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }

        for (int i = 0; i < n; i++) {
            sb.append("*");
        }

        sb.append("\n");
        star2(n-1, count+2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        star1(1,2*(n-1));
        star2(n-1, 2);

        bw.write(sb.toString()+"");

        br.close();
        bw.close();
    }

}

