import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1.투포인터를 이용하여 풀 수 있는 문제다.
 * 2. 짝수와 홀수의 개수를 세면서 홀수가 K보다 커질때를 기점으로 구분하여 작업을 진행한다
 * 3. 최초 원소에 대해 짝수 홀수 여부를 판단하고 짝수 개수를 정답에 넣어준다
 * 4. 홀수의 개수가 K보다 많으면 현재 left위치의 원소가 짝수인지 홀수인지 판단하고 개수를 줄이며 left를 증가시킨다
 * 5. 아닌 경우 right를 증가시키며 right가 n보다 크거나 같다면 탈출한다
 * 6. 이어서 right 위치의 원소가 짝수인지 홀수인지 판단하고 개수를 늘리며 ans에 짝수의 개수와 비교하여 더 큰값을 넣어준다
 * 7. ans를 출력하면 정답이 된다.
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
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;

        int odd = 0;
        int even = 0;
        if(arr[0] % 2 == 0){
            even++;
        }else{
            odd++;
        }
        int ans = even;
        while(left <= right){
            if(odd > k){
                if(arr[left] % 2 == 0){
                    even--;
                }else{
                    odd--;
                }
                left++;
            }else{
                right++;
                if(right >= n){
                    break;
                }
                if(arr[right] % 2 == 0){
                    even++;
                }else{
                    odd++;
                }
                ans = Math.max(ans, even);
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}

