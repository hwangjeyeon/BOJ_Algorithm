import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 역방향으로 dfs하면 쉽게 풀 수 있는 문제다. 루트부터하면 분기지점에서 두개 이상을 생각해야하기 때문에 복잡해지는데, 단말노드부터 시작하면 한방향으로 고정된다
 * 2. 따라서 단말노드부터 시작해서 루트까지 dfs를 하면 된다
 * 3. 리스트를 이용해서 시작지점부터 루트까지 연결된 노드를 각각의 리스트에 담는다
 * 4. 그리고 두 리스트를 이중포문으로 비교해서 공통되는 부분이 생기면 ans로 초기화하고 포문을 탈출한다
 * 5. ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(두 리스트 크기의 곱)
 * 공간복잡도: O(n)
 *
 */
public class Main {

    static int[] list;
    static boolean[] visited;
    static List<Integer> tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            list = new int[n+1];
            for (int i = 0; i < n-1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[b] = a;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tmp = new ArrayList<>();
            visited = new boolean[n+1];
            List<Integer> q1 = dfs(a);

            visited = new boolean[n+1];
            tmp = new ArrayList<>();
            List<Integer> q2 = dfs(b);
            int ans = -1;
            boolean isAns = false;
            for (int i = 0; i < q1.size(); i++) {
                for (int j = 0; j < q2.size(); j++) {
                    if(q1.get(i).equals(q2.get(j))) {
                        ans = q1.get(i);
                        isAns = true;
                        break;
                    }
                }
                if(isAns){
                    break;
                }
            }

            bw.write(ans+"\n");

        }


        br.close();
        bw.close();
    }

    private static List<Integer> dfs(int a) {
        if(tmp.isEmpty()){
            tmp.add(a);
        }
        if(list[a] == 0){
            return tmp;
        }


        tmp.add(list[a]);
        dfs(list[a]);

        return tmp;
    }

}
