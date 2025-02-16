import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 유니온파인드로 사이클 판별하는 문제다
 * 2. 만약 두 정점의 find 결과가 같다면, 사이클이 발생한 것이므로 ans를 i+1로 바꾸고 break한다
 * 3. 아닌경우 union해주면 된다
 * 4. 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(m)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(a) == find(b)) {
                ans = (i+1);
                break;
            }
            union(a,b);
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static int find(int a){
        if(a == parent[a]){
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x!=y){
            parent[y] = x;
        }
    }

}
