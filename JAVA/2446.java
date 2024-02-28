import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 똑같은 재귀함수를 인수와 종료조건만 다르게해서 메인 영역에서 두번 호출하면 되는 문제이다.
 * - 첫번째는 n이 0보다 작을때를 종료조건으로 한다
 * - 이전 문제 재귀함수랑 다르게 빈칸이 먼저 반복문으로 출력되게 한다
 * - 재귀 인수는 n-2, count+1이다
 * - 두번째는 반대로 해주면 된다. 단 종료조건은 count<=0으로 해준다.
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {
    static StringBuilder sb = new StringBuilder();
    static void star1(int n, int count){
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
        star1(n-2, count+1);
    }
    static void star2(int n, int count){
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
        star2(n+2, count-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        star1(2*n-1, 0 );
        star2(3, n-2);

        bw.write(sb.toString()+"");

        br.close();
        bw.close();
    }

}

