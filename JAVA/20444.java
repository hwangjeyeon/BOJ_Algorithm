import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. n이 1부터 9까지 가능한 경우를 모두 찾아봤다
 * [가능한 경우]
 * 1 - 1
 * 2 - 3, 4
 * 3 - 4, 6
 * 4 - 5, 8, 9
 * 5 - 6, 10, 12
 * 6 - 7, 12, 15, 16
 * 7 - 8, 14, 18, 20
 * 8 - 9, 16, 21, 24, 25
 * 9 - 10, 18, 24, 28, 30
 *
 * 2. n/2만큼 결과가 나오며, a는 0 b는 n이라고 할 때, (a+1) * (b+1)만큼의 결과가 n/2+1만큼 나온다
 * 3. 예를들어 9의 경우 10 -> (0+1) * (9+1), 18 -> (1+1) * (8+1)과 같이 나온다. 즉 n/2만큼 순회를 돌며, a는 0부터 증가하고 b는 n부터 감소한다고 했을 때, 각각에 +1한 값을 곱하면 경우의 수가 나온다
 * 4. 이 규칙을 활용해서 문제를 해결하려고 하면 시간초과가 발생할 수 있다. n이 2147483647 - 1이라서 2등분해도 약 10억이기 때문이다
 * 5. 따라서 시간복잡도를 줄여야하는데, 선택할 수 있는 방법으로 이분탐색이 있다. a와 b를 구한다고 했을 때, 0~n/2인 지점에서 가장 적합한 a를 구하면된다. b는 어차피 a의 결과에 종속되어있기 때문이다
 * 6. 따라서 left와 right를 0과 n/2로 선언하고, a를 두 범위 사이의 절반으로 지정한다. b는 n에서 a를 뺀 값으로 생각한다.
 * 7. 이어서 다음과 같은 식의 결과를 확인한다 (a+1) * (b+1)
 * 8. 해당 결과가 k와 같으면 정답이고 그대로 탈출한다
 * 9. 만약 결과과 k보다 크다면 a방향으로 자르는 횟수가 너무 많은 것이므로 right를 조절하고 반대는 left를 조절한다
 * 10. 이렇게 해서 left <= right 범위내에서 이분탐색을 진행하며, 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(log(n/2))
 * 공간복잡도: O(1)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long left = 0;
        long right = n / 2;
        String ans = "NO";
        while(left <= right){
            long a = (left + right) / 2;
            long b = n - a;
            long count = (a + 1) * (b + 1);
            if(count == k){
                ans = "YES";
                break;
            }else if(count > k){
                right = a - 1;
            }else{
                left = a + 1;
            }
        }


        bw.write(ans);

        br.close();
        bw.close();
    }
}
