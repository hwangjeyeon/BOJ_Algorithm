import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 밑을 주어진 진수로 변환하는 과정을 통해 자릿수별 숫자를 뽑아낸다음 left와 right를 주고 비교해서 같은지를 확인한다
 * 2. 모두 같다면 1 도중에 아닌게 있다면 0을 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(A/n)
 * 공간복잡도: O(A/n)
 *
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while(T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            List<Integer> digit = new ArrayList<>();

            long x = a;
            while(x > 0){
                digit.add((int)(x % b));
                x /= b;
            }

            boolean isOk = true;
            int left = 0;
            int right = digit.size() - 1;
            while(left < right){
                if(!digit.get(left).equals(digit.get(right))){
                    isOk = false;
                    break;
                }
                left++;
                right--;
            }

            bw.write(isOk ? "1\n" : "0\n");
        }

        br.close();
        bw.close();
    }

}
