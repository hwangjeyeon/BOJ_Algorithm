import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 방법: 누적합 알고리즘으로 풀었습니다
 * 접근 방법:
 * 1. 배열 시작점부터 끝점까지 모두 더하는 방법으로 접근 -> O(n^2)으로 시간초과 발생
 * 2. 누적합 알고리즘의 방법 활용 -> 정답
 * 변수 선언:
 * int[] arr = 값을 담은 배열
 * int[] prefix_arr = 누적합을 담은 배열 -> 첫번째 배열은 0, 이후 부터는 누적해서 합해준다
 * start = 구하고자 하는 범위의 시작 지점
 * end = 구하고자 하는 범위의 끝 지점
 * ans = 정답
 * 풀이 과정:
 * 1. 값을 arr배열에 담고 prefix_arr의 다음 값에 현재의 prefix_arr값과 arr값을 더해준다 -> 현재의 prefix_arr은 지금까지 누적한 합이고 arr은 이번에 더할 값
 * 2. 끝 지점의 prefix_arr의 값에서 시작지점 - 1의 prefix_arr의 값을 ans에 담고 출력한다 -> 시작지점까지 더한 누적합과 끝지점까지 더한 누적합의 중복 지점을 빼주는 과정
 * 3. ans을 출력한다
 */


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] prefix_arr = new int[N+1];
        prefix_arr[0] = 0;
        for(int i=0; i<N; i++){
            prefix_arr[i+1] = prefix_arr[i] + arr[i];
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int ans = prefix_arr[end]-prefix_arr[start-1];

            bw.write(ans + "\n");
        }

        br.close();
        bw.close();



    }
}
