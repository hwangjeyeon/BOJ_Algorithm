import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 풀이 방법: BFS 탐색 알고리즘으로 풀었습니다
 * 접근 방법: 입력값이 작으며, 그래프 형식이고, 최소 일수를 구하는 문제이기에 BFS 탐색 알고리즘으로 풀어야겠다고 접근했습니다
 * 풀이 과정:
 * 1. 기존 방식과 똑같이 입력받는다. 이때 조건을 두개 추가해주는데 안익는 토마토가 있는지 확인하기 위해 -1이나 1이 입력될때마다
 * tomato_count를 1씩 감소시키고 1이 입력되면 해당 좌표를 큐에 넣어준다
 * 2. bfs 탐색 알고리즘으로 문제를 풀어나가고, ans에 box[y][x]-1값을 넣어줘서 정답을 출력할 수 있게 한다. 이때 토마토가 익는경우가 존재할때마다 count값을 증가시켜준다
 * 3. count값과 tomato_count가 같으면 ans를 출력하고 다르면 익지 않은 토마토가 존재한다는 의미이므로 -1을 출력한다
 *
 * 시간복잡도: O(N*M) M의 최대값이 1000이므로, 1초 제한 시간 내에 해당 문제를 해결할 수 있다
 * 공간복잡도: O(N*M) M의 최대값이 1000이므로 256MB 메모리 제한안에서 해당 문제를 해결할 수 있다
 * 
 */





public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] box = new int[N][M];
        int ans=0;
        int count =0;
        int tomato_count = N*M;
        Queue<Integer> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == -1){
                    tomato_count--;
                }

                if(box[i][j] == 1){
                    tomato_count--;
                    q.add(i);
                    q.add(j);
                }

            }
            if(i <N-1){
                st = new StringTokenizer(br.readLine());
            }

        }

        br.close();
        while(!q.isEmpty()){
            int y = q.poll();
            int x = q.poll();

            if(y-1>=0 && box[y-1][x] == 0){
                q.add(y-1);
                q.add(x);
                box[y-1][x] = box[y][x]+1;
                count++;
            }

            if(y+1<N && box[y+1][x] == 0){
                q.add(y+1);
                q.add(x);
                box[y+1][x] = box[y][x]+1;
                count++;
            }

            if(x-1 >=0 && box[y][x-1] == 0){
                q.add(y);
                q.add(x-1);
                box[y][x-1] = box[y][x]+1;
                count++;
            }

            if(x+1<M && box[y][x+1] == 0){
                q.add(y);
                q.add(x+1);
                box[y][x+1] = box[y][x]+1;
                count++;
            }
            ans = box[y][x]-1;

        }
        if(tomato_count != count){
            bw.write(-1 +"");
        }else{
            bw.write(ans+"");
        }

        bw.close();

    }
}
