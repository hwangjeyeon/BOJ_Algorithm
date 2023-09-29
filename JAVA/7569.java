import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 풀이 방법: bfs 탐색 알고리즘으로 풀었습니다.
 * 접근 방법: 기존 2차원 배열을 활용해서 풀었던 7576번 토마토 문제의 코드를 가져와서 bfs탐색 알고리즘으로 풀어야겠다고 접근했습니다.
 * 풀이 과정:
 * 1. 2차원 배열을 3차원 배열로 바꾸고, 입력방식의 변화를 준 뒤, 위와 아래를 탐색하지 않은 경우도 추가해줍니다.
 * 2. 정답을 출력합니다.
 *
 * 시간복잡도: O(H*N*M)
 * 공간복잡도: O(H*N*M)
 *
 */





public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); //가로
        int N = Integer.parseInt(st.nextToken()); //세로
        int H = Integer.parseInt(st.nextToken()); //높이
        int[][][] box = new int[H][N][M];
        int ans=0;
        int count =0;
        int tomato_count = H*N*M;
        Queue<Integer> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){

                for(int k=0; k<M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());

                    if(box[i][j][k] == -1){
                        tomato_count--;
                    }

                    if(box[i][j][k] == 1){
                        tomato_count--;
                        q.add(i);
                        q.add(j);
                        q.add(k);
                    }
                }
                if(i<H-1 || j<N-1){
                    st = new StringTokenizer(br.readLine());
                }
            }


        }

        br.close();
        while(!q.isEmpty()){
            int z = q.poll();
            int y = q.poll();
            int x = q.poll();

            if(z-1>=0  && box[z-1][y][x] == 0) {
                q.add(z-1);
                q.add(y);
                q.add(x);
                box[z-1][y][x] = box[z][y][x]+1;
                count++;
            }

            if(z+1<H && box[z+1][y][x] == 0) {
                q.add(z+1);
                q.add(y);
                q.add(x);
                box[z+1][y][x] = box[z][y][x]+1;
                count++;
            }

            if(y-1>=0 && box[z][y-1][x] == 0){
                q.add(z);
                q.add(y-1);
                q.add(x);
                box[z][y-1][x] = box[z][y][x]+1;
                count++;
            }

            if(y+1<N && box[z][y+1][x] == 0){
                q.add(z);
                q.add(y+1);
                q.add(x);
                box[z][y+1][x] = box[z][y][x]+1;
                count++;
            }

            if(x-1 >=0 && box[z][y][x-1] == 0){
                q.add(z);
                q.add(y);
                q.add(x-1);
                box[z][y][x-1] = box[z][y][x]+1;
                count++;
            }

            if(x+1<M && box[z][y][x+1] == 0){
                q.add(z);
                q.add(y);
                q.add(x+1);
                box[z][y][x+1] = box[z][y][x]+1;
                count++;
            }
            ans = box[z][y][x]-1;

        }


        if(tomato_count != count){
            bw.write(-1 +"");
        }else{
            bw.write(ans+"");
        }

        bw.close();

    }




}
