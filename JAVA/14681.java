import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * 너무 쉬운 문제라 생략
 *
 * 시간복잡도:
 * 공간복잡도:
 *
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        if(x > 0 && y>0){
            bw.write(1 + "");
        }else if(x <0 && y <0){
            bw.write(3 + "");
        }else if(x > 0 && y < 0){
            bw.write(4 + "");
        }else if(x < 0 && y > 0){
            bw.write(2 + "");
        }

        br.close();
        bw.close();
    }

}
