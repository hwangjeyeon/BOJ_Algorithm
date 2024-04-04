import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 *
 *
 * 문제 해결:
 * 1. 두자리수까지는 모두 한수이다. 따라서 100 미만이면 count에 n을 넣고 출력한다
 * 2. 만약 세자리수일 경우 문제가 되는데, 완전탐색으로 해결한다
 * 3. 어차피 최대 입력이 1000미만이니까 세자리수만 보면된다. 첫째 자리는 i/100이고, 둘째자리는 (i/10)%10이다. 셋째자리는 i%10이다
 * 4. 이제 first - second와 second-third가 같은경우만 count++해준다. 참고로 2번에서 미리 세자리수인 경우 앞에 99는 한수이므로 이를 추가해주어야 해서 count가 99부터 시작한다
 * 5. 완성한 count를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        if(n < 100){
            count = n;
        }else{
            count = 99;
            for (int i = 100; i <= n; i++) {
                int first = i/100;
                int second = (i/10)%10;
                int third = i%10;

                if((first - second) == (second - third)){
                    count++;
                }
            }
        }

        bw.write(count+"");

        br.close();
        bw.close();
    }

}
