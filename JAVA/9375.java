import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 옷의 이름은 낚시인 문제이다. 타입만을 가지고 풀면 된다.
 * - 타입을 key로 가지고 그 타입 내에 있는 옷의 개수를 가지고 푸는 문제이다.
 * - 타입별 옷의 개수를 각각 key-value 쌍으로 하는 자료구조 map을 만든다
 * - 한 테이스케이스마다 모든 입력이 끝난 뒤, map에 저장한 모든 value값을 count 값에 곱해준다
 * - 타입별로 조합을 통해서 나올 수 있는 가짓수를 구하기 위함이다.
 * - 이때 기존 value값에 1을 더해서 곱하는데, 안 입는 경우를 포함해야 하기 때문이다. -> 처음에 안 입는 경우를 생각 안하고, 모두 한번씩만 입는 경우를 따로 빼는 잘못된 방법을 채택해서 해맸다...
 * - 이후 최종 촐력전에 1을 빼줘야 한다. 안입는 경우를 각각의 경우에 포함시켰기 때문에 모두 안 입는 알몸 상태가 나올 수 있기 때문이다.
 * - 문제에서는 그런 경우는 제외하라고 했기 때문에 1을 빼주고 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n*T)
 * 공간복잡도: O(n)
 *
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int count = 1;
            Map<String, Integer> costume = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();

                costume.put(type, costume.getOrDefault(type, 0) + 1);
            }

            for (Integer value : costume.values()) {
                count *= (value+1);
            }

            bw.write(count-1 + "\n");

        }


        br.close();
        bw.close();
    }
}

