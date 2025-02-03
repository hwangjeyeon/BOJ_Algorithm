import javax.xml.transform.SourceLocator;
import java.io.*;

/**
 * 풀이 과정:
 * 1. 오랜만에 푸는 재귀 문제여서 조금 많이 걸린 문제다
 * 2. 수학적인 사고력으로 구현하는 법과 재귀를 섞으면 쉽게 풀리는 문제다
 * 3. 길이가 3이상이면, 임의로 세 지점으로 나누어야 하므로 브루트포스로 찾아야한다
 * 4. 이것을 잘 고려해서 해결하면 풀 수 있는 문제다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(9^3)
 * 공간복잡도: O(1)
 *
 */
public class Main {

    static int max;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        max = 0;
        min = Integer.MAX_VALUE;
        solve(n, 0);
        bw.write(min+" " + max);
        br.close();
        bw.close();
    }

    private static void solve(int n, int count) {
        count += countOdd(n);
        if(n / 10 == 0){
            min = Math.min(min, count);
            max = Math.max(max, count);
        }else if(n / 100 == 0){
            int nxt = n / 10;
            nxt += n % 10;
            solve(nxt, count);
        }else{
            String s = String.valueOf(n);
            for (int i = 0; i < s.length()-2; i++) {
                for (int j = i+1; j < s.length() - 1; j++) {
                    int nxt = Integer.parseInt(s.substring(0, i+1))
                             + Integer.parseInt(s.substring(i+1, j+1))
                            + Integer.parseInt(s.substring(j+1));
                    solve(nxt, count);
                }
            }
        }
    }

    private static int countOdd(int n) {
        int cnt = 0;
        while(n > 0 ){
            int tmp = n % 10;
            if(tmp % 2 == 1){
                cnt++;
            }
            n /= 10;
        }
        return cnt;
    }
}
