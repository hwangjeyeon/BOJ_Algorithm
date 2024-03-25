import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 예상 순위를 배열에 넣고, 오름차순 정렬을 해준다
 * 2. 순위는 1부터 매기므로, 그 차이를 줄이려면 오름차순 정렬을 통해 가장 작은 값부터 순위를 매겨줘야한다
 * 3. 이제 순회를 통해 주어진식인 배열의 값 - (i+1)의 절댓값을 ans에 넣어주자
 * 4. 이떄 주의할점은 ans는 long 타입으로 지정해주어야한다. 최악의 경우를 생각했을 때, 입력값이 모두 50만이면, int형 범위를 충분히 벗어날 수 있기 떄문이다.
 * 5. 주어진 배열의 값을 모두 합산하는 경우는 꼭 최대 입력치를 확인해서 타입범위를 벗어나는지 확인하자!
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(arr[i] - (i+1));
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

