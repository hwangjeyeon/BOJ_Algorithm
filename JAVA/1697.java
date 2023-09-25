import java.io.*;
import java.util.*;


/**
 * 풀이 방법: bfs탐색 알고리즘으로 해당 문제를 풀었습니다.
 * 접근 방법: 최단거리를 구하는 것과 비슷한 문제이고, 도착 지점이 고정되어있기 때문에 BFS 탐색 알고리즘으로 접근했습니다.
 * 풀이 과정:
 * 1. 메모리 초과 문제를 해결하기 위해 방문 배열을 초기화합니다. 이때 -1은 미방문 배열입니다
 * 2. N 지점을 0으로 초기화, 트리의 계층이 정답이 되기 떄문에 x-1,x+1,2*x 지점에 해당하는 부분이 -1일 경우 직전 visted 배열의 값에다가 +1한 값으로 저장
 * 3. bfs 탐색 알고리즘을 통해 큐를 활용, 배열 인덱스 초과 상황 고려해서 상한선과 하한선도 같이 검증해준다.
 * 4. 매 반복마다 큐의 peek()가 K와 같은지 검증, 같으면 visted[q.peek()]값을 ans 저장한 뒤 break
 * 5. ans를 정답으로 출력.
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        br.close();
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[100001];

        for(int i=0; i<visited.length; i++){
            visited[i] = -1;
        }


        q.add(N);
        visited[N] = 0;

            while(!q.isEmpty()){
                if(q.peek() == K){
                    ans = visited[q.peek()];
                    q.clear();
                    break;
                }


                if (q.peek() - 1 <= 100000 && q.peek()-1 >= 0 && visited[q.peek() - 1] == -1) {
                    visited[q.peek() - 1] = visited[q.peek()] + 1;
                    q.add(q.peek() - 1);
                }


                if (q.peek() + 1 <= 100000 && visited[q.peek() + 1] == -1) {
                    visited[q.peek() + 1] = visited[q.peek()] + 1;
                    q.add(q.peek() + 1);
                }


                if (q.peek() * 2 <= 100000 && visited[q.peek() * 2] == -1) {
                    visited[q.peek() * 2] = visited[q.peek()] + 1;
                    q.add(q.peek() * 2);
                }

                q.poll();

            }
            bw.write( ans + "");
            bw.close();

    }
}
