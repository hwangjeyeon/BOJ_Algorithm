import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 투포인터 알고리즘을 이용하여 해결하였다.
 * - 먼저 배열을 오름차순으로 정렬한다
 * - 양끝에 포인터 두개를 배치하고 양 끝 값을 더해서 비교한다
 * - 만약 m보다 크면 끝 쪽 포인터 값을 감소하고 작으면 시작쪽 포인터 값을 증가시킨다
 * - 같으면 count값을 증가시킨다
 * - 끝 포인터가 시작 포인터보다 큰 동안 반복하며 종료되고 나서는 완성된 count값을 출력한다.
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
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] armor = new int[n];
        for (int i = 0; i < n; i++) {
            armor[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = n-1;
        int count = 0;
        Arrays.sort(armor);
        while(start < end){
            int cost = armor[start] + armor[end];
            if (cost > m){
                end--;
            }else if (cost < m){
                start++;
            }else{
                count++;
                start++;
                end--;
            }
        }
        bw.write(String.valueOf(count));
        br.close();
        bw.close();
    }
}
