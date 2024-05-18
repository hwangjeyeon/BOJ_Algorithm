import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 범위를 미리 지정해둔다. 처음값을 기준으로 0.5를 빼준 값에서 l을 더한 것을 범위로 삼아준다
 * 2. 이어서 만약 현재 값에 0.5를 더한 값이 범위보다 크다면 범위를 현재 값으로 갱신해주고, ans++해준다
 * 3. ans의 초기값은 1로 설정해주는데 맨 처음 지정한 값에는 무조건 테이프를 하나 붙이기 떄문이다
 * 4. 완성한 ans를 출력하면 정답이 된다. 
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
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int range = (int) (arr[0] - 0.5 + l);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if(range < (int)(arr[i]+0.5)){
                range = (int)(arr[i]- 0.5 + l);
                ans++;
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }



}

