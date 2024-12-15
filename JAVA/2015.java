import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 누적합 공식을 잘 생각해보자. i부터 j까지의 누적합은 sum[j] - sum[i-1]이다.
 * 2. 이때 문제에서 sum[j] - sum[i] = k인 경우를 원하고 있으므로 이 식을 활용해서 sum[j] - k = sum[i]인 지점을 찾으면 될 것이다
 * 3. 이중포문으로는 시간초과가 발생하기 때문에 자료구조 map을 활용해서 sum[j]에 저장된 값을 기준으로 파악하자. 예륻를어 sum[j]의 값이 3이라면 3을 key값으로 하는 것이다!
 * 4. value에는 그 값의 개수를 넣어주면 된다
 * 5. 따라서 1부터 n+1만큼 탐색하며, sum[j] - k의 value를 ans에 더해주고 없으면 0을 더해주면 정답을 찾을 수 있을 것이다.
 * 6. 이때 sum[j]를 map에 저장하고, 이미 저장되었다면 그 값을 가져와 1을 더한 값을 넣어주자. 저장되어있지 않다면 0에다가 1을 더한 값을 넣어주자
 * 7. 중요한 것이 두가지 있는데 i와 j가 1보다 크거나 같으므로, i-1인 지점을 파악하기 위해 누적합이 0인 경우도 파악하고 있어야 한다.
 * 8. 따라서 0을 key로 하며 value를 1로 하는 값을 map에 넣어주자
 * 9. 또한 ans는 long타입으로 해야한다. n*(n+1)/2은 int형 범위를 넘을 수 있으므로 long타입으로 해야한다
 * 10. 완성한 ans를 출력하면 정답이 된다.
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
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] sum = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            sum[i] = sum[i-1] + arr[i];
        }
        long ans = 0;
        map.put(0,1);
        for (int i = 1; i < n + 1; i++) {
            ans += map.getOrDefault(sum[i] - k, 0);
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
