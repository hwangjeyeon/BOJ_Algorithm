import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 단순히 주어진 식대로 비트연산을 하면 부분통과가 된다
 * 2. 따라서 주어진 식을 유심히 잘 봐야한다. ~k+1은 결국 2의 보수이므로 -k가 된다.
 * 3. 따라서 k&(-k)가 되고 이것은 k의 맨 뒤의 1을 반환한다
 * 4. k-(k&(-k))로 k의 맨 뒤 1이 0이 된다. 이렇게 하나씩 1을 찾아서 카운팅해주고 모든 부분이 0이 될때까지 진행한다
 * 5. 즉 이 문제는 주어진 k개의 비트 중에서 1을 찾는 문제인 것이다
 * 6. 따라서 그냥 문자열로 받고 n만큼 순회하면서 1인 경우만 count값을 증가시키고 이후 count를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') {
                count++;
            }
        }
        bw.write(count+"");

        br.close();
        bw.close();
    }
}

