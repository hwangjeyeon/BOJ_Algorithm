import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 *
 * 문제 해결:
 * 1. 스페셜 저지 문제라 답이 여러개 나올 수 있다. 최소를 구하는 것이 아니라 그냥 늑대 주위로 울타리 설치만 하면 된다
 * 2. 따라서 늑대를 찾아서 그 주위로 .이면 울타리를 설치하고 만약 그 주위에 S가 있으면 불가능하다고 출력하면 된다.
 *
 * 시간복잡도: O(rc)
 * 공간복잡도: O(rc)
 *
 *
 */


public class Main {

    static Queue<Integer> q = new LinkedList<>();
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static char[][] arr;
    static boolean isOk = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                arr[i][j] = input[j].charAt(0);
                if(arr[i][j] == 'W'){
                    q.add(i);
                    q.add(j);
                }
            }
        }

        bfs(r,c);
        if(isOk){
            bw.write("1\n");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    bw.write(arr[i][j]);
                }
                bw.write("\n");
            }
        }else{
            bw.write("0");
        }




        br.close();
        bw.close();
    }

    private static void bfs(int r, int c) {
        while(!q.isEmpty()){
            int y = q.poll();
            int x = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(nx >=0 && ny >= 0 && ny < r && nx < c){
                    if(arr[ny][nx] == '.'){
                        arr[ny][nx] = 'D';
                    }
                    if(arr[ny][nx] == 'S'){
                        isOk = false;
                        return;
                    }
                }
            }

        }

    }
}
