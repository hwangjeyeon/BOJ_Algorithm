import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 유니온파인드로 해결하는 문제다.
 * 2. I면 유니온하고, Q면 find해서 출력하면 된다
 * 3. n이 10^6이기 때문에 이중포문으로 확인하는 것은 어렵고 개수를 세는 배열이나 Map을 사용해야한다. 이 문제에서는 Map을 사용했다
 * 4. map을 parent 초기화할 때, i를 key로 하고 value를 1로 초기화한다
 * 5. 그리고 유니온할 때, find한 a와 b로 key를 b로 하며, a와 b의 get 결과를 합하는 식으로 put한다
 * 6. map의 결과를 반드시 유니온 과정에서 진행해야 한다. 왜냐하면, parent의 결과가 바뀌기 전의 a와 b이기 때문에 그것을 가지고 결과를 누적해야하기 때문이다
 * 7. 출력할 때, find한 결과를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(N)
 * 공간복잡도: O(부품의 수)
 *
 */



public class Main {

    static int[] parent;
    static Map<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        parent = new int[1_000_001];
        map = new HashMap<>();
        for (int i = 0; i < 1_000_001; i++) {
            parent[i] = i;
            map.put(i, 1);
        }


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            if(a.equals("I")){
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                union(b, c);
            }else{
                int d = Integer.parseInt(st.nextToken());
                bw.write(map.get(find(d))+ "\n");
            }
        }

        br.close();
        bw.close();
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if(x != y){
            parent[y] = x;
        }
    }

    private static int find(int a){
        if(a == parent[a]){
            return a;
        }
        return parent[a] = find(parent[a]);
    }

}
