import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 가능한 경우를 모두 탐색한다.
 *
 * - 문제 해결:
 * 1. 다음 풀이를 생각하면 되는 문제이다.
 * 2. 가장 자리 영역은 width가 그대로이고 height는 width 영역을 제외해야하니까 height-2이다
 * 3. 그 안의 갈색 영역은 width-2와 height-2이다. 만들어지는 도형을 생각해서 이런 공식을 뽑아내면 된다
 * 4. i는 width j는 height로 생각하고 순회를 돈다. 이때 순회는 더 큰 수인 r만큼 돌아주면 된다
 * 5. 이제 위 식을 이용하여 i*2 + (j-2)*2 은 r이랑 같아야하고 (i-2) * (j-2)는 b랑 같은 경우 j와 i순으로 출려하면 된다. 큰 수는 width가 된다고 문제에 나와있기 떄문이다.
 *
 * 시간복잡도: O(r^2)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= r; j++) {
                if(i*2 + (j-2) *2 == r && (i-2) * (j-2) == b){
                    bw.write(j + " " + i);
                    br.close();
                    bw.close();
                    return;
                }
            }
        }

        br.close();
        bw.close();
    }

}

