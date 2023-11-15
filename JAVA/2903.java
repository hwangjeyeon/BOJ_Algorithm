import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법: 
 * - 다음 규칙을 알면 된다. 이전 값에 -1한 값 만큼 그 다음 값에 더한 뒤, 제곱하면 된다
 * ex) 이전 값이 3일 경우 다음 값은 2만큼 더한 5 -> 제곱해서 25가 정답이 된다.
 *
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 *
 */




public class Main {

    //static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        arr[1] = 3;
        for(int i=2; i<n+1; i++){
            arr[i] = 2*arr[i-1]-1;
        }


        bw.write((int)Math.pow(arr[n],2) + "");

        br.close();
        bw.close();
    }


}
