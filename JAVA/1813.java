import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * - 문제가 이해가 되지 않는다...
 * - 힌트를 참고해서 이해한 바로는 i각각이 인덱스라고 생각하면 된다고 한다.
 * - 그래서 중복이 들어와도 같은 인덱스에 대한 내용이다
 * - 배열을 미리 만들어주고 들어오는 값에 해당하는 인덱스의 값을 늘려준다
 * - 입력이 끝나고 순회를 도는데 가장 큰 값을 출력해야하므로 뒤에서부터 순회를 한다
 * - 각 인덱스가 i랑 같으면 출력하고 종료한다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] count = new int[51];
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            count[tmp]++;
        }

        for (int i = n; i >= 0; i--) {
            if(count[i] == i){
                bw.write(i + "\n");
                br.close();
                bw.close();
                return;
            }
        }

        bw.write("-1");
        br.close();
        bw.close();
    }

}

