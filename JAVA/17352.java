import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 두 지점을 잇는 문제이기 때문에 유니온 파인드로 풀면 되는 문제다.
 * 2. 초기화한 뒤, 주어지는 두 지점을 유니온해준다
 * 3. 이어서 어느 지점과 이어도 된다고 했으므로, 첫번째 지점과 같지 않은 경우를 정답으로 출력하면 된다.
 *
 * 해결방법:
 * 1. 위 방식으로 하다가 처음에 틀렸었다
 * 2. 이유를 찾아보니 parent[i]와 parent[1]을 비교하고 있었기 때문이었다
 * 3. 입력값 순서에 따라 parent[i]가 최종 부모 노드가 아닐 수도 있다
 * 4. 그렇기에 find(i)로 비교를 해주어야 한다.
 * 5. find(i) == find(1)로 수정하니 정답이 되었다.
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
        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n - 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        for (int i = 2; i < n + 1; i++) {
            if(find(i) != find(1)){

                bw.write(1 + " " + i);
                break;
            }
        }

        br.close();
        bw.close();
    }

}

