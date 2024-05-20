

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 *
 * - 문제 해결:
 * 1. 뒤에서부터 비교를한다. 가장 큰 값인 n과 같은지를 비교한다
 * 2. 만약 같다면 해당 pivot 값을 감소시킨다
 * 3. 순회 후에 pivot을 출력하면 정답이 된다
 * 4. 뒤에서부터 큰값을 기준으로 같은지 비교해서 같으면 감소시키는 방식을 사용하는 이유는 정렬 방식을 볼 때, 결국 아래서부터 위로 큰값 -> 작은 값 형식이기 때문이다
 * 5. 사이의 값이 어떻든 간에 현재 큰값 -> 작은 값으로 정렬이 얼마큼 되어있는지가 중요하다
 * 6. 2번째 예제에서는 3까지는 3 4 순으로 잘 정렬이 되어있다. 그 사이의 작은 값이 얼마가 들어가든 말이다. 
 * 7. 이제 pivot의 수만큼은 큰값 -> 작은 값 순이 차례대로 되어있지 않기 때문에 정렬을 해야한다
 * 
 *
 *
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
        int pivot = n;
        for (int i = n-1; i >= 0; i--) {
            if(pivot == arr[i]){
                pivot--;
            }
        }
        bw.write(pivot+"");

        br.close();
        bw.close();
    }
}

