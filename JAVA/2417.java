import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 이분탐색으로 풀었다.
 * - 그냥 mid*mid하면 오버플로우가 발생한다.
 * - 그래서 Math.pow(mid,2)로 해결해야하고 (long) 형변환도 하면 오버플로우가 발생하기 때문에 하면 안된다.
 * - 이렇게 했을 때, 이분탐색 방법으로 해결해가며, ans에는 mid값을 넣어준다. 단 가장 작은 정수를 찾기 위해서, right의 범위가 재설정 되는 경우만 ans에 mid를 넣는다
 * - 최종 완성된 ans를 출력한다.
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(1)
 *
 */





public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        long left = 0;
        long right = n;
        long ans = 0;
        while(left <= right){
            long mid = (left + right) / 2;
            System.out.println(Math.pow(mid,2));
            if(Math.pow(mid,2) >= n){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        bw.write(String.valueOf(ans));

        br.close();
        bw.close();
    }

}
