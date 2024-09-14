import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 문제 이해만 잘 하면 쉬운 문제다
 * 2. 두번째 줄에 주어지는 완성된 배열의 값들은 세번째 D배열의 각 인덱스의 값의 위치에서 온 원소들이다
 * 3. 그렇다면 임시 배열 하나 만들어두고 k만큼 돌면서 n만큼 순회하여 d인덱스의 있는 값들을 임시배열의 인덱스로 하며, 그 위치에 완성된 배열의 원소값을 넣는다면 문제가 해결 될 것이다
 * 4. 단 임시배열의 값들로 완성된 배열의 원소값들을 순회의 끝자락에서 한번 업데이트 해줘야한다
 * 5. 이렇게 한다면 완성된 임시배열을 출력했을 때, 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(k * n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] darr = new int[n];
        for (int i = 0; i < n; i++) {
            darr[i] = Integer.parseInt(st.nextToken());
        }
        int[] tmp = new int[n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                tmp[darr[j]-1] = arr[j];
            }

            for (int j = 0; j < n; j++) {
                arr[j] = tmp[j];
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(tmp[i]+" ");
        }

        br.close();
        bw.close();
    }
}

