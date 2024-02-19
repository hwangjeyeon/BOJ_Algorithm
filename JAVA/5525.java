import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 문자열을 char형으로 저장한 뒤 순회 탐색을 통해 'OI'의 개수를 체크하였다.
 * - 처음에는 StringBuilder로 미리 찾아야하는 문자를 만들어놓고 탐색하였으나, 시간초과 문제로 50점 통과에 그쳤었다
 * - 따라서 OI의 개수를 새는 방식으로가야겠다고 생각하였ek.
 * - OI의 개수를 처음에는 단순 int tmp 변수로 새는 방식을 생각하였지만, 통과하지 못하였다.
 * - 이번에는 int[] tmp = new int[m]으로 OI가 발견될 때 I자리에다가 지금까지 누적된 OI를 적어둬야겠다고 생각하였다.
 * - 그리고 누적된 숫자가 N보다 크거나 같은 경우, 시작 지점에 I가 있는지를 체크해야한다
 * - 예제를 통해 위를 찾기 위해서는 i - 2*n +1이라는 수식을 통해 찾을 수 있음을 발견하였고, 두 조건을 모두 만족할 경우 ans를 증가시키는 방식으로 순회를 진행시켰다
 * - 이제 완성된 ans를 출력하면 정답이 된다.
 *
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
        int m = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        int ans = 0;
        int[] tmp = new int[m];
        for (int i = 1; i < m - 1; i++) {
            if(s[i] == 'O' && s[i+1] == 'I'){
                tmp[i+1] = tmp[i-1] + 1;

                if(tmp[i+1] >= n && s[i - 2*n + 1] == 'I'){
                    ans++;
                }
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

