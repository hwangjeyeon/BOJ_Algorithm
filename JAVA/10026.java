import java.io.*;
import java.util.*;


/**
 * 풀이 방법: 최대 입력값이 굉장히 작기 때문에 탐색 알고리즘을 사용할 수 있으며, 최단거리를 구하는 것이 아니기 때문에 bfs 탐색 알고리즘 뿐만 아니라 bfs 탐색알고리즘도 가능은 하겠다 생각했습니다
 * - 그러나 일단 bfs로만 풀어봤습니다. 추후 dfs로도 풀어볼 예정입니다.
 * 접근 방법: 적록 색약 아닌 사람들이 볼 수 있는 영역을 먼저 처리하면서, 적록색약인 사람들이 볼 수 있는 영역으로 세팅하고 처리해야겠다고 접근했습니다.
 * 풀이 과정:
 * 다음 조건을 세웠다.
 * - 적록색약이 아닌 사람들
 * -> visited[][] 배열이 0일때 미방문, 1일때 방문
 * - 적록색약인 사람들
 * -> visited[][] 배열이 1일때 방문, 2일때 미방문
 * => 다음과 같이 한 이유는 visited[][]를 중간에 초기화하는 낭비 과정을 없애기 위함임
 *
 * 1. 위 방식으로 bfs 탐색 알고리즘을 적용하여 먼저 적록색약이 아닌 사람들의 영역을 구한 뒤 count1에 저장한다
 * 2. 적록색약인 사람들을 위한 필드를 만들기 위해, 위 1번 과정에서 현재 배열의 값이 G인 경우 R로 바꾸도록 세팅해놓았다
 * 3. bfs 탐색 알고리즘을 적용하여 적록색약인 사람들의 영역을 구한 뒤 count2에 저장한다
 * 4. count1과 count2를 출력한다.
 *
 * 시간복잡도:
 * - 큐에 넣고 뺴는 과정은 상수 시간
 * - 두번의 N*N격자 탐색하는 bfs 알고리즘 과정에서 O(n^2) 시간 복잡도 발생
 * - 따라서 이 코드의 시간복잡도는 O(n^2)이다
 * -> 이때 최악의 경우를 고려할떄 최대 입력값은 100 -> 최대 100*100=10000시간인데, 보통 1억당 1초라고 생각하면 되기 떄문에
 * 해당 코드는 시간제한 1초 이내로 해결할 수 있다
 * 공간복잡도:
 * - 공간 복잡도도 마찬가지로 2차원 배열의 크기인 N*N만 고려하면 된다. 나머지 변수들은 일반 상수로 무시해도 되는 정도
 * 따라서 이 코드의 시간 복잡도는 O(n^2)이다
 * -> 똑같이 생각했을 때 128MB = 128*10^6을 넘지는 않는다.
 * -> 따라서 해당 메모리 제한 조건 내로 문제를 해결할 수 있다.
 */




public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] rgb = new char[N][N];
        int[][] visited = new int[N][N];
        int count1=0,count2=0;
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                rgb[i][j] = s.charAt(j);
                visited[i][j] = 0;
            }
        }
        br.close();

        //색약 아닌 사람부터
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j] == 0){
                    q.add(i);
                    q.add(j);
                    visited[i][j] = 1;
                    while(!q.isEmpty()){
                        int y = q.poll();
                        int x = q.poll();
                        if(y-1 >= 0 && rgb[y-1][x] == rgb[y][x] && visited[y-1][x] == 0){
                            q.add(y-1);
                            q.add(x);
                            visited[y-1][x] = 1;
                        }
                        if(y+1 <N && rgb[y+1][x] == rgb[y][x] && visited[y+1][x] == 0){
                            q.add(y+1);
                            q.add(x);
                            visited[y+1][x] = 1;
                        }

                        if(x-1 >=0 && rgb[y][x-1] == rgb[y][x] && visited[y][x-1] == 0){
                            q.add(y);
                            q.add(x-1);
                            visited[y][x-1] = 1;
                        }

                        if(x+1 < N && rgb[y][x+1] == rgb[y][x] && visited[y][x+1] == 0){
                            q.add(y);
                            q.add(x+1);
                            visited[y][x+1] = 1;
                        }
                        if (rgb[y][x] == 'G') {
                            rgb[y][x] = 'R';
                        }
                    }
                    count1++;
                }
            }
        }


        //색약인 사람
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j] == 1){
                    q.add(i);
                    q.add(j);
                    visited[i][j] = 2;
                    while(!q.isEmpty()){
                        int y = q.poll();
                        int x = q.poll();
                        if(y-1 >= 0 && rgb[y-1][x] == rgb[y][x] && visited[y-1][x] == 1){
                            q.add(y-1);
                            q.add(x);
                            visited[y-1][x] = 2;
                        }

                        if(y+1 <N && rgb[y+1][x] == rgb[y][x] && visited[y+1][x] == 1){
                            q.add(y+1);
                            q.add(x);
                            visited[y+1][x] = 2;
                        }

                        if(x-1 >=0 && rgb[y][x-1] == rgb[y][x] && visited[y][x-1] == 1){
                            q.add(y);
                            q.add(x-1);
                            visited[y][x-1] = 2;
                        }

                        if(x+1 < N && rgb[y][x+1] == rgb[y][x] && visited[y][x+1] == 1){
                            q.add(y);
                            q.add(x+1);
                            visited[y][x+1] = 2;
                        }
                    }
                    count2++;
                }
            }
        }

        bw.write(count1 + " " + count2);
        bw.close();

    }
}
