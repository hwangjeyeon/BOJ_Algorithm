import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 들어올릴 수 있는 최대 무게는 선택한 로프들 중 가장 작은 로프가 버틸 수 있는 무게여야 한다.
 * - 따라서 들어온 개수만큼 작은 로프와 곱한 값이 병렬로 연결했을 때, 버틸 수 있는 최대 중량이다.
 * - 입력 받은 각 로프의 정보를 내림차순해서 정렬한다
 * - 배열의 첫번째 인덱스에 있는 요소를 max 변수에 넣어주고, 남은 인덱스의 요소와 그 (인덱스+1)을 곱한 값과 max변수를 비교하여 더 큰 값을 max 변수에 넣어준다
 * - 최종적으로 max의 값을 출력한다.
 * 
 * - 힌트를 참고했다. 더 연습이 필요해 보인다.
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
        int[] rope = new int[n];
        for(int i=0; i<n; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }

        rope = Arrays.stream(rope)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        int max = rope[0];
        for(int i=1; i<rope.length; i++){
            max = Math.max(max, rope[i]*(i+1));
        }
        bw.write(max+"");
        br.close();
        bw.close();
    }

}
