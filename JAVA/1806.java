import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 *
 *
 * 문제 해결:
 * 1. 이분탐색이 아니라 투포인터와 누적합을 이용하는 문제였다
 * 2. 만약 sum이 s보다 크거나 같다면 그 범위를 줄여서 확인해봐야 한다. 따라서 arr[start]의 값을 sum에서 빼주고 길이가 더 짧은 것으로 갱신해준 뒤, start++해준다
 * 3. 만약 sum이 s보다 작다면 arr[end]의 값을 sum에 더해주고 end++해준다
 * 4. 한가지 더 해야지 완전히 통과할 수 있는데, end 포인터가 n에 도달한 상태에서 start의 범위를 계속 줄일 수 있다.
 * 5. 따라서 start와 end 증감 조건 문 사이에 end==n일경우 break하는 경우를 두어서 index에러도 잡고, 정답도 잡는 방법으로 해결하였다
 * 6. while문 종료 후에 ans가 Integer.MAX_VALUE이면 0을 출력하고 아니면 ans를 출력한다.
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while(true){

            if(sum >= s){
                sum -= arr[start];
                ans = Math.min(ans, end - start);
                start++;
            }else if (end == n){
                break;
            }else{
                sum += arr[end];
                end++;
            }
        }

        if(ans == Integer.MAX_VALUE){
            bw.write("0");
        }else{
            bw.write(ans+"");
        }



        br.close();
        bw.close();
    }

}
