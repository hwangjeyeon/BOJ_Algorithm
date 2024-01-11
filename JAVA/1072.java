import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 이분탐색으로 문제를 풀었다.
 * - 먼저 절대 변하지 않는 경우는 99%, 100%인 경우다.
 * - 따라서 Z >= 99인 경우는 -1이 출력되도록 한다.
 * - 이제 변하는 경우에서는 x와 y의 값을 1씩 증가시킨 다음 z의 값이 변화하는지 관찰하는 방법이 있다.
 * - 하지만 입력값이 10^9까지 들어오기 떄문에, 이 방법은 시간 초과가 발생한다.
 * - 그렇다면 해결할 방법이 바로 이분탐색이다.
 * - left는 0, right는 최대 입력값의 2배인 2*10^9으로 초기화한다
 * - 이제 mid는 (left+right)/2로 선언해주고, mid만큼 더한 결과를 tmp_mid에 넣어준다
 * - 이때 tmp_mid가 z보다 큰 경우 right에 mid를 넣어서 mid~right사이의 값을 없애준다
 * - tmp_mid가 z보다 크지 않을 경우 left에 mid+1을 넣어서 left ~ right 사이의 값을 없애준다.
 * - 이렇게 범위를 줄여나가다 보면 결국 left==right인 구간이 생기게 되는데, 이때가 정답이 된다
 * - 따라서 left나 right를 count에 넣어서 출력해주면 정답이 된다.
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(1)
 *
 */





public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long z = y*100/x;

        long count = 0;
        if(z >= 99){
            count = -1;
        }else{
            long left = 0;
            long right = 2000000000;
            while(left < right){
                long mid  = (left + right) / 2;
                long tmp_mid = (y+mid)*100 / (x+mid);
                if(tmp_mid > z){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }
            count = left;
        }


        bw.write(String.valueOf(count));
        br.close();
        bw.close();
    }

}
