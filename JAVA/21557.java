

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 양 끝은 고정되어 있으니까, 양끝을 비교해서 더 큰 값의 옆에 있는 폭죽더미를 없애준다
 * 2. 이렇게 하면 더 큰 값의 높이가 1씩 감소하게 될 것이기 떄문에 그리디하게 정답을 구할 수 있다.
 * 3. 추가로 n-2번째는 무조건 3개가 남으니까 2번 과정을 n-1만 해주고 n-2에서는 left와 right 모두 감소시켜준다
 * 4. 마지막으로 left와 right중 더 큰 값을 출력하면 정답이 된다.
 *
 *
 * - 문제 해결:
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = arr[0];
        int right = arr[n-1];
        int posLeft = 1;
        int posRight = n-2;

        for (int i = 0; i < n - 3; i++) {
            if(left < right){
                arr[posRight] = 0;
                arr[posRight-1]--;
                right--;
                posRight--;
            }else{
                arr[posLeft] = 0;
                arr[posLeft+1]--;
                left--;
                posLeft++;
            }
        }
        left--;
        right--;

        bw.write(Math.max(left, right)+"");





        br.close();
        bw.close();
    }
}

