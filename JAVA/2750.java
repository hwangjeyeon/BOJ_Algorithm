import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * - 자바 Array와 Stream라이브러리를 사용하여 해결하였다
 * - stream.sorted()는 값을 반환한다는 사실을 꼭 명심하자
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 *
 */




public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        arr = Arrays.stream(arr).sorted().toArray();

        for(int i=0; i<n; i++){
            bw.write(arr[i] + "\n");
        }

        br.close();
        bw.close();
    }


}
