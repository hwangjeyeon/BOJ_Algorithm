import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 최소신장 트리로 푸는 문제다 크루스칼 알고리즘 사용해서 풀었다
 * 2. 유니온파인드를 활용해서, 모든 지점에 대해 거리 가중치로 오름차순 정렬한다
 * 3. 이후 현재의 두 지점을 union 할 수 있다면 검증을 진행하는데 p와 q가 같지 않고, p와 q가 각각 now[0]이나 now[1]중 하나에 포함된다면 isOk를 true로 한다
 * 4. count가 n이상이 되면 탈출하고 완성된 isOk결과를 리턴한다 
 * 5. 그 결과에 따라 정답을 출력하면 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(nm)
 * 공간복잡도: O(m)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list.add(new int[]{a, b, c});
            }
            if(mst(n,p,q, list)){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }
        }

        br.close();
        bw.close();
    }

    private static int find(int now, int[] parent){
        if(now == parent[now]){
            return now;
        }
        return parent[now] = find(parent[now], parent);
    }

    private static boolean union(int a, int b, int[] parent){
        int x = find(a, parent);
        int y = find(b, parent);
        if(x == y){
            return false;
        }
        parent[x] = y;
        return true;
    }

    private static boolean mst(int n, int p, int q, List<int[]> list){
        list.sort((o1, o2) -> o1[2] - o2[2]);
        int[] parent = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        int count = 1;
        boolean isOk = false;
        for (int[] now : list) {
            if(union(now[0], now[1], parent)){
                count++;
                if(p != q && (p == now[0] || q == now[0]) && (p == now[1] || q == now[1])){
                    isOk = true;
                }
            }
            if(count >= n){
                break;
            }
        }
        return isOk;
    }

}
