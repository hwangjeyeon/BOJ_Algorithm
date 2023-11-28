import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * 조건문 순서 잘 맞춰서 작성하면 된다.
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
        StringTokenizer st;
        int a;
        int b;
        int c;
        while(true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a + b + c == 0){
                break;
            }
            if(a >= b+c || b >= a+c || c >= b+a){
                bw.write("Invalid\n");
            }else if(a == b && b == c){
                bw.write("Equilateral\n");
            }else if(a==b || b==c || a==c){
                bw.write("Isosceles\n");
            }else if(a != b && b!=c && a!=c){
                bw.write("Scalene\n");
            }

        }



        br.close();
        bw.close();
    }


}
