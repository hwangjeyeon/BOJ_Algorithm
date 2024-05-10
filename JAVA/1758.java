import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 일단 최악의 경우 10만이 10만번 더해질 수 있으므로 합산 변수는 long타입을 사용해야한다
 * 2. 처음에는 오름차순 정렬만 생각을 하였다. 음수가 되면 팁을 못 받니까 팁을 적게 내는 사람에게 높은 등수를 주어서 돈을 최대한 그리디하게 가져오면 된다고 생각했다
 * 3. 하지만 이 방법은 오차가 있음을 예제를 통해 발견했다.
 * 4. 4번째 예제를 봤을 때, 1이 4개고 이어서 2가 한개 오는 것을 확인할 수 있다
 * 5. 이때 오름차순으로만 확인하면 1만을 받게 된다. 하지만 2에게서만 팁을 받는다면? 2원을 받을 수 있게 된다
 * 6. 따라서 내림차순도 똑같이 합산을 계산해주어야한다
 * 7. 마지막에 둘을 비교해서 더 큰 값을 ans에 넣고 출력하면 정답이 된다
 *
 * - 테케가 잘 주어져서 쉽게 발견하고 풀 수 있었지만 만약 실제 코테였다면 위와 같은 이유로 틀렸을 문제다
 * - 그리디 문제에서는 이런 경우가 있음을 꼭 확인하고, 첫번째 논리에서 테케를 모두 통과하면 히든 케이스나 예외 케이스를 꼭 생각해서 문제를 풀도록 하자!
 * 
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
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long first = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] - i > 0){
                first += arr[i] - i;
            }
        }
        Arrays.sort(arr, Collections.reverseOrder());
        long second = 0;
        for (int i=0; i<n; i++){
            if(arr[i] - i > 0){
                second += arr[i] - i;
            }
        }
        long ans = Math.max(first, second);


        bw.write(ans+"");


        br.close();
        bw.close();
    }
}

