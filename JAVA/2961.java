import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 각 재료를 사용하면 1, 안 하면 0으로 생각한다.
 * 2. 재료의 개수는 n개이기때문에 비트마스킹과 브루트포스를 사용하면 해결할 수 있다
 * 3. 모든 경우의 수는 lth에 보관하며 1 << n으로 보관하면 된다
 * 4. ans는 최소 경우를 찾기 위해 Integer.MAX_VALUE로 보관한다
 * 5. lth만큼 순회하면서 모든 경우의 수를 확인하자
 * 6. 1부터 순회하는데 0은 공집합인 경우이며, 재료를 적어도 하나 사용해야하므로 공집합은 제외하였다
 * 7. 이제 각 비트를 확인하는 순회를 진행한다. n까지 순회하면서 i와 비교하는데 1<<j랑 &연산을 통해 0보다 크다면 해당 비트가 있다는 것이므로 해당 j에 해당하는 값들을 곱하고 더해준다
 * 8. 각 경우 i마다 모든 비트 j를 순회하면서 나온 맛의 차이를 diff에 저장하고 ans와 비교하여 더 작은 값을 넣어준다
 * 9. 이렇게 각 i마다 j를 n만큼 순회하면서 그 값들을 저장하고 차이를 ans와 비교하여 준다
 * 10. 완성한 ans를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(lth * n)
 * 공간복잡도: O(n)
 *
 */

class Pair{
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(a, b);
        }

        int ans = Integer.MAX_VALUE;
        int lth = 1 << n;
        for (int i = 1; i < lth; i++) {
            int first = 1;
            int second = 0;
            for (int j = 0; j < n; j++) {
                if((i & (1 << j)) > 0){
                    first *= pairs[j].first;
                    second += pairs[j].second;
                }
            }
            int diff = Math.abs(first - second);
            ans = Math.min(ans, diff);
        }

        bw.write(ans+"");

        
        br.close();
        bw.close();
    }

}

