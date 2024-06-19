import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 처음에는 양방향 그래프로 잇고 탐색을 해야하나 했는데, 비행기를 타는 최소 횟수나 최단거리를 구하는 것이 아니라 비행기의 종류를 최소한으로 구하라 했으므로 가볍게 n-1이 나온다
 * 2. 왜냐하면 노드 n개가 있을 때 노드끼리 모두 연결시키기 위해서는 n-1개가 있어야하기 때문이다. 
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            List<Integer>[] graph = new List[n+1];
            for (int j = 0; j < n+1; j++) {
                graph[j] = new ArrayList<>();
            }
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                graph[first].add(second);
                graph[second].add(first);
            }
            bw.write(n-1+"\n");

        }



        
        br.close();
        bw.close();
    }



}

