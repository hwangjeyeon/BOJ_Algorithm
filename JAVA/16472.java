import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 투포인터로 해결할 수 있는 문제다
 * 2. 알파벳 배열 만들어 두고, 카운팅과 정답을 관리할 변수를 선언한다
 * 3. i와 j를 함께 선언하며, j를 늘리는 방향으로 탐색을 진행한다
 * 4. 만약 현재 알파벳의 수가 0이라면 count를 늘려준다
 * 5. 그리고 현재 카운팅 수가 n보다 작고 i가 j보다 작으면 i번째 알파벳을 줄이고 count를 줄여준다
 * 6. 이어서 두 지점 간의 차이와 ans를 비교해서 더 큰값으로 갱신한다
 * 7. 완성한 ans를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(|s|)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] alpha = new char[26];

        int count = 0;
        int ans = 0;

        for (int i = 0, j = 0; j < s.length(); j++) {
            if(alpha[s.charAt(j) - 'a']++ == 0){
                count++;
            }

            while(n < count && i < j){
                if(--alpha[s.charAt(i++) - 'a'] == 0 ){
                    count--;
                }
            }
            ans = Math.max(ans, j - i + 1);
        }
        bw.write(ans+"");
        
        br.close();
        bw.close();
    }
}
