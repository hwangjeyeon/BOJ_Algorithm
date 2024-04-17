import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 *
 * - 문제 해결:
 * 1. 전형적인 bfs 문제다. 해당 유형 문제가 꽤 출제를 많이 하기 때문에 재풀이 때, 확실히 숙지할 필요가 있다
 * 2. +1,-1, +a, -a, +b,-b와 점프하는 경우인 *a, *b인 경우를 모두 탐색해주면 된다
 * 3. 이때 해당 부분을 따로 배열로 만들어두지 않고 큐에서 나온 now와 연산한뒤 배열로 각 순회마다 만들어주어서 탐색하도록 하였다. 
 * 4. 각자 따로 탐색 분기가 진행되므로 현재 지점에다가 이전 지점의 값+1을 더하는 식으로 그 횟수를 구하였다
 * 5. 만약 도착지점의 배열의 값이 0 이상이면 구해졌다는 의미이므로 순회를 종료하고 정답을 출력하면 된다.
 * 6. 추가로 각 지점을 나타내는 것은 최대 입력인 100001로 처리해주어야 한다 m+1로 하면 도중에 인덱스 에러가 발생한다
 * 7. 왜냐하면 충분히 점프하면서 그 입력 범위를 벗어날 수도 있기 때문이다. 따라서 최대 입력값으로 처리해주어야 한다
 *
 * 시간복잡도: O(logm)
 * 공간복잡도: O(m)
 *
 */

public class Main {

    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        arr = new int[100001];
        bfs(n,a,b,m);
        bw.write(arr[m] +"");

        br.close();
        bw.close();
    }

    private static void bfs(int start, int a, int b, int m) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            int[] move = {now-1, now+1, now-a,now+a, now-b,now+b, now*a, now*b};
            for (Integer i : move) {
                if(i >=0 && i < 100001 && !visited[i]){
                    visited[i] = true;
                    arr[i] = arr[now]+1;
                    q.add(i);
                }
            }
            if(arr[m] > 0){
                break;
            }
        }

    }


}

