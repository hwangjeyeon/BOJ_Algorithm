import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 문자열 파싱과 주어진 조건에 맞춰서 잘 처리하면 된다
 * 2. 주의할 점은 sum이 0보다 작을 때는 26을 더하고 25보다 클때만 %연산을 해주면 된다
 * 
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(단어의 개수*|S|)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            String s = st.nextToken();
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < s.length()-1; i+=2) {
                int sum = 0;
                sum += s.charAt(i) - 'a';
                sum += s.charAt(i+1) - 'a';
                sum -= n;
                if(sum < 0){
                    sum += 26;
                }else if(sum > 25){
                    sum %= 26;
                }

                ans.append((char)(sum + 'a'));
            }
            bw.write(ans.toString()+ " ");

        }


        br.close();
        bw.close();
    }
}

