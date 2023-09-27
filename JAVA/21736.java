import java.io.*;
import java.util.*;


/**
 * 풀이 방법: bfs 탐색 알고리즘으로 풀었습니다.
 * 접근 방법: 입력값이 작고 배열그래프 문제이기 떄문에 브루트포스보다 더 효율적인 bfs 탐색 알고리즘으로 풀어야겠다고 접근했습니다.
 * 풀이 과정: 
 * 1. bfs 탐색 알고리즘으로 풀어나가는데, 범위를 벗어나지 않고 / 방문하지 않았으며 / 'X'가 아닌 경우 큐에 해당 좌표를 넣도록 했씁니다.
 * 2. 이때 해당 좌표가 'P'면 ans++ 해줌
 * 3. 최종 정답을 출력하는데 0이면 "TT" 출력하고 아니면 ans 출력
 *
 * 시간복잡도: O(N*M) -> 둘의 최대 입력값은 600씩이므로 자바 시간제한인 2초를 넘을 수 잆다.
 * 공간복잡도: O(N*M) -> 메모리 제한 1024MB를 넘을 수 없다. 시간 복잡도와 같은 이유
 */




public class Main {

    public static void main(String[] args) throws IOException {
        //입출력 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());


        //변수 설정
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] school = new char[N][M];
        int[][] visited = new int[N][M];
        Queue<Integer> q = new LinkedList<>();
        int ans=0;

        //배열 입력 및 초기화
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                school[i][j] = s.charAt(j);
                if(s.charAt(j) == 'I'){
                    q.add(i);
                    q.add(j);
                    visited[i][j] = 1;
                }else{
                    visited[i][j] = 0;
                }
            }

        }

        br.close();


        //bfs 탐색 알고리즘
        while(!q.isEmpty()){
            int y = q.poll();
            int x = q.poll();


            if(y-1>=0 && school[y-1][x] != 'X' && visited[y-1][x] == 0){
                if(school[y-1][x] == 'P'){
                    ans++;
                }
                q.add(y-1);
                q.add(x);
                visited[y-1][x] = 1;
            }

            if(y+1<N && school[y+1][x] != 'X' && visited[y+1][x] == 0){
                if(school[y+1][x] == 'P'){
                    ans++;
                }
                q.add(y+1);
                q.add(x);
                visited[y+1][x] = 1;
            }

            if(x-1>=0 && school[y][x-1] != 'X' && visited[y][x-1] == 0){
                if(school[y][x-1] == 'P'){
                    ans++;
                }
                q.add(y);
                q.add(x-1);
                visited[y][x-1] = 1;
            }

            if(x+1<M && school[y][x+1] != 'X' && visited[y][x+1] == 0){
                if(school[y][x+1] == 'P'){
                    ans++;
                }
                q.add(y);
                q.add(x+1);
                visited[y][x+1] = 1;
            }

        }
        
        //최종 정답 출력
        if(ans == 0){
            bw.write("TT");
        }else{
            bw.write(ans+"");
        }
        bw.close();
    }
}
