import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;


/**
 * 풀이 방법: DFS 탐색 알고리즘으로 풀었습니다.
 * 접근 방법: 입력값이 적고 그래프 문제이기에 탐색 알고리즘을 적용할 수 있겠다고 생각했고, DFS와 BFS 중 DFS 공부를 위해 DFS 탐색 알고리즘으로 접근해서 풀어야겠다고 생각했습니다.
 * 풀이 과정:
 * 1. Stack을 활용한 DFS 탐색 알고리즘으로 풀었습니다. 이번에는 상하좌우 + 대각선 조건까지 추가해서 총 8까지 경우를 탐색합니다.
 * 2. 0인 경우는 탐색을 건너뛰고 (continue), 방문하지 않은 1인 경우는 chk를 true로 하여 DFS 탐색 알고리즘 이후 count를 증가시킵니다. 방문한 1일 경우는 chk를 false로 바꿉니다.
 * 3. 최종 count 값을 출력합니다.
 *
 * 시간복잡도: O(h*w) -> for문 O(h*w), bfs탐색 알고리즘 최악의 경우 O(h*w)인데 이중 for문 안에서 같이 비례하므로 O(h*w)
 * 공간복잡도: O(h*w)
 *
 */





public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int[][] map = new int[h][w];
            int[][] visited = new int[h][w];
            int count = 0;
            Stack<Integer> island = new Stack<>();
            if(w ==0 && h == 0){
                break;
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<h; i++){
                for(int j=0; j<w;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    visited[i][j] = 0;
                }
                if(i < h-1){
                    st = new StringTokenizer(br.readLine());
                }
            }

            boolean chk = false;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){

                    if(map[i][j] == 0){
                        continue;
                    }
                    if(map[i][j] == 1 && visited[i][j] == 0){
                        chk = true;
                    }else{
                        chk = false;
                    }
                    visited[i][j] = 1;
                    island.add(i);
                    island.add(j);
                    while(!island.isEmpty()){
                        int x = island.pop();
                        int y = island.pop();
                        if(y-1>=0 && visited[y-1][x] == 0 && map[y-1][x] == 1){
                            visited[y-1][x] = 1;
                            island.add(y-1);
                            island.add(x);

                        }
                        if(y+1 < h && visited[y+1][x] == 0 && map[y+1][x] == 1){
                            visited[y+1][x] = 1;
                            island.add(y+1);
                            island.add(x);

                        }
                        if(x-1>=0 && visited[y][x-1] == 0 && map[y][x-1] == 1){
                            visited[y][x-1] = 1;
                            island.add(y);
                            island.add(x-1);

                        }
                        if(x+1 < w && visited[y][x+1] == 0 && map[y][x+1] == 1){
                            visited[y][x+1] = 1;
                            island.add(y);
                            island.add(x+1);

                        }

                        if(y-1>=0 && x-1>=0 && visited[y-1][x-1] == 0 && map[y-1][x-1] == 1){
                            visited[y-1][x-1] = 1;
                            island.add(y-1);
                            island.add(x-1);
                        }

                        if(y-1>=0 && x+1 < w && visited[y-1][x+1] == 0 && map[y-1][x+1] == 1){
                            visited[y-1][x+1] = 1;
                            island.add(y-1);
                            island.add(x+1);
                        }

                        if(y+1<h && x-1>=0 && visited[y+1][x-1] == 0 && map[y+1][x-1] == 1){
                            visited[y+1][x-1] = 1;
                            island.add(y+1);
                            island.add(x-1);
                        }

                        if(y+1<h && x+1 < w && visited[y+1][x+1] == 0 && map[y+1][x+1] == 1){
                            visited[y+1][x+1]=1;
                            island.add(y+1);
                            island.add(x+1);
                        }


                    }

                    if(chk){
                        count++;
                    }
                }
            }



            bw.write(count + "\n");
        }
            br.close();
            bw.close();
    }
}
