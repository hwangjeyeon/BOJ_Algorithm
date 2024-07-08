import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. left와 right를 1로 초기화하고 left<=right인 동안 순회하면서 right는 더하고 left는 빼준다
 * 2. 먼저 sum과 n이 같은지 검사하고 같으면 ans를 증가시키며 sum이 n보다 작으면 right++하고 크거나 같으면 left--한다
 *
 * 해결방법:
 * 1. 한가지 주의할점이 sum은 1이 되어야한다. left와 right를 1로 잡아서 n이 1인 경우는 투포인터 연산없이 지나가기 때문이다.
 *
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(1)
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int sum = 1;
        int left = 1;
        int right = 1;
        int ans = 0;
        while(left <= right){
            if(sum == n){
                ans++;
            }

            if(sum < n){
                right++;
                sum += right;
            }else if(sum >= n){
                sum -= left;
                left++;
            }
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

