import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. Set을 사용해서 해결하면 쉽게 풀 수 있다
 * 2. Set에 매 substring의 결과를 넣어주고, 그 크기가 n이 될때까지 찾는다
 * 3. 2번 과정을 찾을 때까지 ans를 증가시킨다. ans의 초기값은 1이다
 * 4. 순회 종료 후, 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*|S|)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int ans = 1;
        for (int i = arr[0].length()-1; i >= 0; i--) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                set.add(arr[j].substring(i));
            }
            if(set.size() == n){
               break;
            }
            ans++;
        }

        bw.write(ans+"");
        
        br.close();
        bw.close();

    }
}
