import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 각 지점을 배열로 받고, 맨 처음 값을 0부터 그지점까지의 거리로 보고 max값에 넣어준다
 * 2. 이어서 배열을 순회하면서 현재 위치와 이전 위치의 차이와 max값을 비교하여 더 큰 값을 넣어준다
 * 3. 이때 가로등 사이에 있는 경우 필요한 거리가 절반으로 줄어들기 떄문에 짝수인경우 절반 홀수인 경우 + 1을 해서 max를 구한다
 * 4. 마지막에 n부터 마지막 값 까지의 차이와도 비교해서 최종 max를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(m)
 * 공간복잡도: O(m)
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[m+2];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = arr[0];
        for (int i = 1; i < m; i++) {
            if((arr[i] - arr[i-1])% 2 == 0){
                max = Math.max(max, (arr[i] - arr[i-1]) / 2);
            }else{
                max = Math.max(max, (arr[i] - arr[i-1]) / 2 + 1);
            }
        }

        max = Math.max(max, n - arr[m-1]);
        bw.write(max+"");

        br.close();
        bw.close();
    }

}

