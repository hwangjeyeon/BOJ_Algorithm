import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 이해하고 주어진대로 구현하면 되는 문제다
 * 2. 먼저 정답 문자열을 Accepted로 고정시켜두고, 샘플 케이스를 순회한다.
 * 3. 이때 샘플케이스의 값이랑 정답 입력이 갖지 않는 경우, Wrong Answer으로 ans를 바꾼다
 * 4. 이어서 테스트케이스 값이랑 정답 입력값이랑 비교한다. 이때 Accepted인데 같지 않으면 Why Wrong!!!으로 바꾼다
 * 5. 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(s1)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        String ans = "Accepted";
        for (int i = 0; i < s1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a != b){
                ans = "Wrong Answer";
                break;
            }
        }
        for (int i = 0; i < s2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(ans.equals("Accepted") && a != b){
                ans = "Why Wrong!!!";
            }
        }
        bw.write(ans);


        br.close();
        bw.close();
    }
}
