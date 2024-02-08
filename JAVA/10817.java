import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 배열로 입력받고 오름차순 정렬한 뒤에 1번 인덱스의 값을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        bw.write(String.valueOf(arr[1]));

        br.close();
        bw.close();
    }
}

