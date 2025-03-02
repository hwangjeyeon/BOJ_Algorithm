import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 우선순위 큐를 이용하는 문제다. n은 *24를 해준다
 * 2. 내림차순 대상은 증가하는 점수다. 어차피 순서대로 들어오므로 입력 순서대로 id를 지정한다. 받을 수 있는 점수는 변화하기 떄문에 id로 활용 못한다
 * 3. 전체 시간인 n이 0보다 크고 우선순위 큐가 비어있지 않는 동안 순회하면서, 최대 100에서 현재 받을 수 있는 점수값을 뺀값을 시간당 얻을 수 있는 점수로 나눠주낟
 * 4. 그리고 현재 남은 시간과 그 값을 비교해서 더 작은 값을 구한다
 * 5. 그 값을 전체 시간에서 뺴주고 배열의 id 인덱스에서 현재 받을 수 있는 점수 * 위의 결과 값을 곱해서 더해준다
 * 6. 만약 100이 아니라면 pq에 100에서 빼고 남은 값을 넣어준다
 * 7. 이후 각 id에 해당하는 배열의 값을 ans에 더해주고 이후 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(24*logn)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken())*24;
        int m = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            pq.add(new int[]{i, a});
        }


        int ans = 0;
        while(n > 0 && !pq.isEmpty()){
            int[] now = pq.poll();
            int tmp = ((100 - arr1[now[0]])/ now[1]);
            int tmp2 = Math.min(n, tmp);
            n -= tmp2;
            arr1[now[0]] += now[1] * tmp2;

            if(arr1[now[0]] != 100){
                pq.add(new int[]{now[0], 100 - arr1[now[0]]});
            }
        }

        for (int i = 0; i < m; i++) {
            ans += arr1[i];
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}
