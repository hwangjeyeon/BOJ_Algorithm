import java.io.*;
import java.util.*;


/**
 * 풀이 방법: BFS 탐색 알고리즘으로 문제를 풀었습니다
 * 접근 방법: BFS 탐색 알고리즘으로 탐색한 뒤, 오름차순 정렬과 개수 출력을 위해 우선순위 큐를 사용해야겠다고 생각했습니다.
 * 풀이 과정:
 * 1. BFS 탐색 알고리즘을 이용하여 탐색해야할 좌표를 모두 탐색
 * 2. BFS 탐색 알고리즘으로 탐색될 떄마다 값을 증가해서 연결된 개수를 구하고 해당 값을 우선순위 큐에다가 넣어 크기 순으로 정렬함
 * 3. 최종적으로 우선순위 큐의 크기를 출력하여 개수를 출력하고, 오름차순 정렬되어 있는 값을 그대로 출력하여 문제 해결
 */





public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] fields = new int[N][N];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                    fields[i][j] = s.charAt(j)-48;
            }
        }

        PriorityQueue<Integer> ans = new PriorityQueue<>();
        Queue<Integer> bfs = new LinkedList<>();


        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){

                if(fields[i][j] == 1){
                    bfs.add(i);
                    bfs.add(j);
                    fields[i][j] = 2;
                    int count = 1;
                    while(!bfs.isEmpty()){
                        int y = bfs.poll();
                        int x = bfs.poll();

                        if(y-1 >= 0 && fields[y-1][x] == 1){ // 내 위가 0보다 크거나 같아야 함
                            bfs.add(y-1);
                            bfs.add(x);
                            fields[y-1][x] = 2;
                            count++;
                        }
                        if(y+1 < N && fields[y+1][x] == 1){ // 내 아래가 N보다 작아야 함
                            bfs.add(y+1);
                            bfs.add(x);
                            fields[y+1][x] = 2;
                            count++;
                        }
                        if(x-1 >=0 && fields[y][x-1] == 1){ // 내 왼쪽이 0보다 크거나 같야아 함
                            bfs.add(y);
                            bfs.add(x-1);
                            fields[y][x-1] = 2;
                            count++;
                        }
                        if(x+1 < N && fields[y][x+1] == 1){ // 내 오른쪽이 M보다 작아야 함
                            bfs.add(y);
                            bfs.add(x+1);
                            fields[y][x+1] = 2;
                            count++;
                        }
                    }
                    ans.add(count);
                }
            }
        }



        bw.write(ans.size() + "\n");
        while(!ans.isEmpty()){
            bw.write(ans.poll() + "\n");
        }
        br.close();
        bw.close();

    }
}
