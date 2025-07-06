import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 밝기를 미리 배열에 저장하고, 최댓값을 구하기 위한 최솟값을 미리 변수로 가져두낟
 * 2. 순회하면서 각 전구가 켜져있는지 꺼져있는지 확인한다
 * 3. 만약 켜져 있다면 a에 더하고 b에는 빼준다. 각각 켰을 때와 껐을 때의 전구 밝기의 값이다
 * 4. 그리고 max가 현재 밝기 * -1 (뒤집었을 때)보다 작다면 max를 그 값으로 갱신한다
 * 5. 만약 꺼져있다면 꺼져있을 때의 밝기에 값을 더해주낟
 * 6. 그리고 만약 현재 꺼져있을 때의 값이 현재 밝기 보다 작으면 b를 현재 밝기로 갱신한다
 * 7. 다시 이어서 max가 b보다 작으면 max를 b로 갱신한다
 * 8. 완성한 a와 max를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int a = 0;
        int b = 0;
        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp == 1){
                a += arr[i];
                b -= arr[i];
                if(max < arr[i]*-1){
                    max = arr[i] *-1;
                }
            }else{
                b += arr[i];
                if(b < arr[i]){
                    b = arr[i];
                }
                if(max < b){
                    max = b;
                }
            }
        }
        bw.write((a + max) + "");
        
        br.close();
        bw.close();
    }

}
