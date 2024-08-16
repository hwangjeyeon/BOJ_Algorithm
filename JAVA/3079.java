import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 처음에는 그리디를 생각했는데, 다시 잘 읽어보니 시뮬레이션 돌리기에는 입력값도 너무 많고 크기도 커서, 범위를 묻는 문제니까 이분탐색을 해야겠다고 생각하였다
 * 2. 모든 타입은 long 타입으로 지정하였다. 범위가 워낙 크기 때문이다
 * 3. left와 right를 모두 1로 잡는다. left는 나올 수 있는 최소범위가 1이기 때문에 그대로 나둔다
 * 4. right는 입력과정에서 가장 큰 값을 찾는다. 이때 최대의 범위가 되는 경우는 가장 큰수에 m을 곱한 값이다
 * 5. 예제 입력을 보았을 때 최대 범위는 10 * 6이라는 것을 유추할 수 있기 때문이다.
 * 6. 이분탐색을 위해 입력값을 담은 배열을 오름차순 정렬하였다
 *
 * - 문제 해결:
 * 1. 아직 이분탐색 설계가 미숙하다. 비트마스킹 학습과 순열/조합 복습이 끝나고는 이분탐색에 집중하는 시간을 가져야겠다..
 * 2. 어쨋든 이분탐색은 다음과 같이 설계할 수 있다. 총 걸리는 시간에서 각 심사대에 있는 사람의 수를 합하는 sum 변수를 하나두고 n만큼 순회한다
 * 3. mid / arr[i]는 현재 원소의 심사대에 오게되는 인원수이다. 이 값을 sum에다가 더해준다
 * 4. 한가지 주의할 점이 중간에 sum이 m보다 크거나 같을 경우 오버플로우가 발생한다고 한다.. 따라서 break 조건을 하나 넣어줘야 한다
 * 5. 이어서 sum이 m보다 크거나 같다면 일단 가능은 하므로 ans에 더 작은 값을 넣어주며, 최소값을 찾기 위해 right의 범위를 mid-1로 줄인다
 * 6. 만약 작다면 불가능하므로 ans에는 넣지 않고 left 범위를 늘려준다
 * 7. 완성한 ans를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        long left = 1;
        long right = 1;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]*m);
        }
        long ans = Long.MAX_VALUE;
        Arrays.sort(arr);
        while(left <= right){
            long mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                long tmp = mid / arr[i];
                if(sum >= m){
                    break;
                }
                sum += tmp;
            }
            if(sum >= m){
                right = mid - 1;
                ans = Math.min(ans, mid);
            }else{
                left = mid + 1;
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

