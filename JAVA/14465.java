import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 슬라이딩 윈도우 + 누적합 문제다. 누적합 없이 풀면 시간 초과 위험이 있으므로 누적합을 꼭 이용하자
 * 2. 슬라이딩 윈도우나 투포인터에서 시간초과 위험이 있으면 누적합을 고민해보자! -> 네이버 2024 공채 코테 1번 문제도 비슷했다!
 * 3. boolean 배열로 선언하여 망가진 신호등 위치 상태를 관리한다. count와 ans변수를 두고 ans는 Integer.MAX_VALUE로 초기화한다
 * 4. 슬라이딩 윈도우 초기값을 보기 위해 1부터 K까지 탐색하면서 망가진 신호등이 있으면 count++해준다
 * 5. ans에 count와 ans중 최솟값을 넣어준다
 * 6. 이제 슬라이딩 윈도우와 누적합을 이용해서 최소 수리 개수를 구한다
 * 7. k+1부터 n까지 탐색하면서 i - k의 위치가 true면 count--하고 i가 true면 count++ 해준다
 * 8. 그리고 ans에 다시 count와 비교해서 더 작은 넣어준다
 * 9. 완성한 ans 결과를 출력한다. 
 *
 * 해결방법:
 *
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
        int b = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[n+1];
        for (int i = 0; i < b; i++) {
            int broken = Integer.parseInt(br.readLine());
            arr[broken] = true;
        }

        int count = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < k+1; i++) {
            if(arr[i]){
                count++;
            }
        }

        ans = Math.min(ans, count);
        for (int i = k+1; i < n + 1; i++) {
            if(arr[i-k]){
                count--;
            }

            if(arr[i]){
                count++;
            }
            ans = Math.min(ans, count);
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

