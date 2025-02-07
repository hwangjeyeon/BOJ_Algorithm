import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 경로를 이을 수 있다는 점에서 유니온파인드로 접근 가능한 문제다
 * 2. 입력값을 이용해서 연결되는 지점을 union한다
 * 3. 이어서 여행 계획의 첫번째 지점을 find해두고, 이후 오는 값들을 find한 값과 비교해서 다를 경우 NO를 출력한다
 * 4. 만약 모두 같을 경우 YES를 출력한다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */
public class Main {

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 1; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a == 1){
                    union(i,j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < m; i++) {
            int now = Integer.parseInt(st.nextToken());
            if(start != find(now)){
                bw.write("NO");
                bw.close();
                System.exit(0);
            }
        }

        bw.write("YES");



        br.close();
        bw.close();
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a!=b){
            if(a < b){
                parent[b] = a;
            }else{
                parent[a] = b;
            }
        }
    }

    private static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }


}
