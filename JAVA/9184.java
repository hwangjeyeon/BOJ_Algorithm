import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 있는 대로 구현하고, dp로 교체만 해준다. 이때 범위 검사를 한번 해주기 위해 맨앞에 검사를 하나 추가했다.
 * - 참고: https://st-lab.tistory.com/190
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n^3)
 *
 */


public class Main {

    static int[][][] dp = new int[21][21][21];
    static int w (int a, int b, int c){

        if(inRange(a, b, c) && dp[a][b][c] != 0){
            return dp[a][b][c];
        }

        if(a<=0 || b <= 0 || c <= 0){
            return 1;
        }

        if(a>20 || b >20 || c > 20){
            return dp[20][20][20] = w(20,20,20);
        }

        if(a<b && b < c){
            return dp[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
        }

        return dp[a][b][c] = w(a-1, b,c) + w(a-1,b-1,c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

    static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1 && c == -1){
                break;
            }

            bw.write("w(" + a + ", " + b + ", " + c + ") = " + w(a,b,c) + "\n");
        }

        br.close();
        bw.close();
    }

}

