import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 투포인터 알고리즘을 이용해서 풀었습니다
 * - (1 ≤ i < j ≤ n) 조건때문에 일반적인 입력에서 투포인터 조건인 연속된 수가 되지 않는다
 * - 따라서 오름차순으로 정렬을 한 뒤 투포인터 알고리즘을 사용해야한다
 * - start는 0, end는 n-1으로 해서 두 수를 sum에 더해주고 x와 같은지 비교한다
 * - x와 같으면 count를 증가시키고 두 쌍을 찾았으므로 start 값은 증가 end값은 감소시켜서 다음 수를 비교한다
 * - 만약 sum이 x보다 크면 end를 감소시키고 작으면 start를 증가시킨다
 * - 이렇게 완성된 count를 출력하면 정답이 된다
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
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int start = 0;
        int end = n-1;
        int count = 0;

        while (start < end){
            int sum = arr[start] + arr[end];
            if(sum == x){
                count++;
                start++;
                end--;
            }else if(sum > x){
                end--;
            }else{
                start++;
            }
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}
