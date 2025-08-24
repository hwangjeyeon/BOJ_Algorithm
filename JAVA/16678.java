import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 일단 1로 돌아가는 과정을 진행하기 위해 오름차순으로 정렬하고 첫번째 사람을 1로 만들어야한다
 * 2. 이후는 이전과 같거나 1만큼만 높도록 해서 연쇄적으로 발생하도록 한다
 * 4. 이전 사람과 같으면 작업을 수행하지 않고 크다면 1만큼만 차이나도록 한다
 * 5. 따라서 첫번쨰 사람이 1이 아니면 arr[0] - 1을 통해 ans에 합산해서 넣어주고 arr[0]을 1로 만든다
 * 6. 이후 1부터 n까지 순회하며 arr[i] > arr[i-1]이라면 ans에는 arr[i] - (arr[i-1] + 1); 을 통해 1만큼 차이난만큼만 더해주고, 해당 위치도 arr[i-1] + 1로 값을 변강한다
 * 7. 완성한 ans를 출력하면 정답이 된다
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
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long ans = 0;
        if(arr[0] != 1){
            ans += (arr[0] - 1);
            arr[0] = 1;
        }

        for (int i = 1; i < n; i++) {
            if(arr[i] > arr[i-1]){
                ans += arr[i] - (arr[i-1] + 1);
                arr[i] = arr[i-1] + 1;
            }
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
