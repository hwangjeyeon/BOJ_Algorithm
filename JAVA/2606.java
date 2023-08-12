import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 풀이 방법: 링크드리스트로 연결하며, DFS 방식으로 풀었습니다
 * 접근 방법: 이전에 풀었던 DFS와 BFS 문제를 생각하면서 Network라는 클래스를 만들어서 해결하면 되겠다고 생각했습니다
 * 변수 선언:
 * int N = 컴퓨터 수
 * int M = 컴퓨터 쌍의 수
 * class Network 필드는 이전 1260번과 대부분 동일
 * int ans = 1번과 연결된 정점의 개수
 *
 * 풀이 과정:
 * 1. 정점간 간선 연결을 합니다.
 * 2. DFS 방식으로 탐색하며, 얼마만큼 탐색하는지 ans에 담아 최종적으로 출력합니다
 *
 */


class Network{
    private int V;
    private LinkedList<Integer> adj[];
    boolean visited[];
    int ans;
    Network(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i] = new LinkedList();
        }

        visited = new boolean[v];
        ans = 0;
    }

    void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    void DFS(int v){
        visited[v] = true;
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                ans++;
                DFS(n);
            }
        }

    }

    int get_ans(){
       return ans;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Network computer = new Network(N+1);
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            computer.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();
        computer.DFS(1);
        int ans = computer.get_ans();
        bw.write(ans+"");
        bw.close();
    }
}
