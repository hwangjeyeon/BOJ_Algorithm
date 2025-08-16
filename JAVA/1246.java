import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 잠재고객의 희망가격을 오름차순 정렬한뒤 탐색한다
 * 2. 각 잠재고객의 희망가격으로 판매 시 수익을 비교해서 최대값을 구하면 된다
 * 3. 구매 가능한 잠재고객의 수가 달걀의 수보다 많을 경우 최대 달걀의 수만큼만 구매한 것으로 계산한다
 * 4. 이렇게 현재 Sum이 maxSum보다 크면 갱신해주고, 그 결과에 대해 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(m)
 * 공간복잡도: O(m)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int maxSum = 0;
        int max = 0;

        for (int i = 0; i < m; i++) {
            int now = arr[i];
            int nowSum = 0;
            if(m - i < n){
                nowSum = now * (m - i);
            }else{
                nowSum = now * n;
            }

            if(nowSum > maxSum){
                maxSum = nowSum;
                max = now;
            }
        }
        bw.write(max + " " + maxSum);
        
        br.close();
        bw.close();
    }

}
