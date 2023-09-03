import java.io.*;
import java.util.*;


/**
 * 풀이 방법: 링크드리스트 기반으로 풀었으며, BFS, DFS 알고리즘 방식 순서대로 적용하여 풀었습니다
 * 접근 방법: 주어진 입력값이 단순해서 링크드리스트로 풀 수 있겠다고 판단했습니다.
 * 변수 선언:
 * Graph 클래스 내 필드
 * private int V; // 정점의 개수
 * private LinkedList<Integer> connector[]; // 연결 링크
 * private int count; // 개수
 *
 * Graph 클래스 내 메소드
 * void addEdge(int l, int r) 주어진 정점 간 연결, 양방향 링크드리스트로 구현했습니다
 * void BFS(int s) - BFS 알고리즘 사용 메소드
 * int getAnswer() - 정답 출력
 *
 *
 * 풀이 과정:
 * 1. 1260번 문제와 비슷하게 진행하나 만약 처음으로 들어온 값이 방문했다면 바로 메소드를 종료시킵니다.
 * 2. 만약 종료되지 않는다면 값을 증가시키고 이후에 알고리즘 방식대로 탐색해나갑니다.
 * 3. DFS 알고리즘은 재귀 방식으로 풀었는데, 정답을 풀기 위해 check를 인수로 주어서 풀었습니다. 메인함수로 주는 경우 0, 재귀함수로 온 인수인 경우 1로 체크하여
 * 0인 경우에 count를 증가시키고 1인경우에는 무시합니다.
 */


class Graph{
    private int V; // 정점의 개수
    private LinkedList<Integer> connector[]; // 연결 링크
    private int count; // 개수

    boolean visited[];

    Graph(int v){
        V = v+1;
        connector = new LinkedList[V];
        for(int i=0; i<V; i++){
            connector[i] = new LinkedList<>();
        }
        visited = new boolean[V];
        count = 0;
    }

    void addEdge(int l, int r){
        connector[l].add(r);
        connector[r].add(l);
    }


    void BFS(int s){
        Queue<Integer> queue = new LinkedList<>();

        if(visited[s]){
            return;
        }
        count++;
        visited[s] = true;
        queue.add(s);
        while(!queue.isEmpty()){
            s = queue.poll();
            Iterator<Integer> i = connector[s].listIterator();
            while(i.hasNext()){
                int n = i.next();

                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void DFS(int s, int check){
        if(visited[s]){
            return;
        }
        if(check == 0){
            count++;
        }
        visited[s] = true;
        Iterator<Integer> i = connector[s].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFS(n, 1);
            }
        }
    }


    int getAnswer(){
        return count;
    }

}




public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Graph gp = new Graph(N);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            gp.addEdge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        for(int i=1; i<=N; i++){
            gp.DFS(i,0);
        }

        bw.write(gp.getAnswer()+"");
        br.close();
        bw.close();
    }
}
