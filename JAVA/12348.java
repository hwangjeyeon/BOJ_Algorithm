import java.io.*;

/**
 * 풀이 과정:
 * 1. 수학적 사고를 필요로하는 문제다
 * 2. 잘 생각해보면, 주어진 숫자의 자릿수의 최대 가능한 수에다가 전체 길이를 곱한값만큼 빼면 분해합을 만족시키는 최소 값이 될 것이다
 * 3. 다시 말하면 216의 경우 3자리인데, 각각 9,9,9가 최대로 가능하고, 어떤 분해합도  216에서 27을 뺀 198보다 클 것이다
 * 4. 따라서 미리 최소 시작위치를 구한다음 그 위치부터 쭉 탐색하면서 자릿수 * 10^자릿수번호의 합이 n과 같은 수를 찾는다
 * 5. 만약 발견하면 그 즉시 정답을 i로 바꾸고, 탈출한 뒤 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n - 9*|n|)
 * 공간복잡도: O(1)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        long ans = 0L;
        long n = Long.parseLong(s);
        int len = s.length();
        long min = n - len * 9L;

        for (long i = min; i < n; i++) {
            long sum = i;
            long tmp = i;

            while(tmp > 0){
                sum += tmp % 10;
                tmp /= 10;
            }
            if(sum == n){
                ans = i;
                break;
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }



}
