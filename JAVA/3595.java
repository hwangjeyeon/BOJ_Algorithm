import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 3중 포문 돌려서 가능한 가장 작은 값을 찾으면 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 0;
        int c = 0;
        long min = 987654321;
        long size = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < i+1; j++) {
                if(i*j > n){
                    break;
                }
                for (int k = 1; k < j+1; k++) {
                    if(i*j*k > n){
                        break;
                    }

                    if(i*j*k == n){
                        size = i*j + j*k + k*i;
                        if(size < min){
                            min = size;
                            a = i;
                            b = j;
                            c = k;
                        }
                    }
                }
            }
        }
        bw.write(a + " " + b + " " + c);

        br.close();
        bw.close();
    }

}
