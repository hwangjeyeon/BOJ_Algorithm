import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 두 지점의 시간을 동기화하는 BFS 문제다
 * 2. 이전에 풀었던 불 문제랑 비슷하게 해결하였다
 * 3. 물과 비버의 지점을 다른 큐에 배치시켜두고, 현재 물 크기와 비버 위치 크기만큼만 순회해서 탐색하도록 했다
 * 4. 이동할 때마다 배열에 물과 비버의 위치를 갱신시키며, 비버라고 하더라도 기존의 위치를 .으로 바꾸지않고 S로 유지시킨다
 * 5. 비버의 경우 bfs 탐색 도중 다음 위치가 D라면, 현재 이동거리 + 1 한 값을 ans와 비교해서 더 작은 값으로 넣어주고 BFS 탐색을 종료시킨다
 * 6. 만약 ans가 초기 최댓값이라면 KAKTUS를 출력하고 아니라면 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(r*c)
 * 공간복잡도: O(r*c)
 *
 */
public class Main {

    static int r;
    static int c;
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};
    static int ans = Integer.MAX_VALUE;
    static char[][] arr;
    static int[] start;
    static int[] end;
    static List<int[]> water;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        water = new ArrayList<>();
        end = new int[2];
        start = new int[2];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'S'){
                    start[0] = i;
                    start[1] = j;
                }
                if(arr[i][j] == 'D'){
                    end[0] = i;
                    end[1] = j;
                }
                if(arr[i][j] == '*'){
                    water.add(new int[]{i,j});
                }
            }
        }

        bfs();
        if(ans == Integer.MAX_VALUE){
            bw.write("KAKTUS");
        }else{
            bw.write(ans+"");
        }

        br.close();
        bw.close();
    }

    private static void bfs() {
        Queue<int[]> beaver = new LinkedList<>();
        beaver.add(new int[]{start[0], start[1],0});
        Queue<int[]> waters = new LinkedList<>(water);
        while(!beaver.isEmpty()){
            int size = waters.size();
            for (int i = 0; i < size; i++) {
                int[] now = waters.poll();
                for (int j = 0; j < 4; j++) {
                    int ny = now[0] + dy[j];
                    int nx = now[1] + dx[j];
                    if(isRange(ny,nx) && arr[ny][nx] != 'D' && arr[ny][nx] != 'X' && arr[ny][nx] != '*'){
                        arr[ny][nx] = '*';
                        waters.add(new int[]{ny,nx});
                    }
                }
            }
            size = beaver.size();
            for (int i = 0; i < size; i++) {
                int[] now = beaver.poll();
                for (int j = 0; j < 4; j++) {
                    int ny = now[0] + dy[j];
                    int nx = now[1] + dx[j];
                    if(isRange(ny,nx) && arr[ny][nx] != '*' && arr[ny][nx] != 'X' && arr[ny][nx] != 'S'){
                        if(arr[ny][nx] == 'D'){
                            ans = Math.min(ans,now[2] + 1);
                            return;
                        }
                        arr[ny][nx] = 'S';
                        beaver.add(new int[]{ny,nx, now[2] + 1});
                    }
                }
            }
        }
    }

    private static boolean isRange(int ny, int nx) {
        return ny >=0 && ny < r && nx >=0 && nx < c;
    }
}
