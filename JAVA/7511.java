import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 기본적인 유니온파인드 문제다.
 * 2. 주어진 두 수의 find값을 비교하여 같으면 1을 출력하고 아니면 0을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(Alpha(n))
 * 공간복잡도: O(n)
 *
 */

public class Main {

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y){
            return;
        }

        if(x <= y){
            parent[y] = x;
        }else{
            parent[x] = y;
        }

    }

    private static int find(int x){
        if(parent[x] == x){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            parent = new int[n+1];
            for (int j = 1; j < n + 1; j++) {
                parent[j] = j;
            }
            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            }
            int m = Integer.parseInt(br.readLine());
            bw.write("Scenario " + (i+1) + ":\n");
            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(find(a) == find(b)){
                    bw.write("1\n");
                }else{
                    bw.write("0\n");
                }
            }
            bw.write("\n");

        }

        br.close();
        bw.close();
    }

}

