
import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 테스트케이스마다 배열 만들고 오름차순 정렬을 해준다
 * 2. 맨 처음 인덱스 값과 마지막 인덱스 값을 출력하면 정답이 된다
 *
 * - 문제 해결:
 *
 *
 *
 * 시간복잡도: O(T x n)
 * 공간복잡도: O(n)
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            bw.write(arr[0] + " " + arr[n-1]+"\n");
        }

        br.close();
        bw.close();
    }
}

