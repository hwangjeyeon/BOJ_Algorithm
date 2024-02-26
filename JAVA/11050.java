import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - nCk = n-1Ck-1 + n-1Ck 공식을 재귀 함수로 구현하여 풀었다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    static int factorial(int n, int k){

        if(n==k || k== 0){
            return 1;
        }


        return factorial(n-1,k-1) + factorial(n-1, k);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int ans = factorial(n,k);
        bw.write(ans+"");


        br.close();
        bw.close();
    }

}

