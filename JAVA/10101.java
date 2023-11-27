import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * - 그냥 조건문으로 풀면 되는 문제.
 *
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 *
 */




public class Main {

    //    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        if(a+b+c != 180){
            bw.write("Error");
        }else if(a==60 && b==60 && c==60){
            bw.write("Equilateral");
        }else if(a+b+c == 180 && (a==b || b==c || a==c)){
            bw.write("Isosceles");
        }else if(a+b+c == 180 && a!=b && b!=c && a!=c){
            bw.write("Scalene");
        }


        br.close();
        bw.close();
    }


}
