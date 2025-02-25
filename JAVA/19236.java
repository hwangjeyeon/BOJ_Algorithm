import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. Fish와 Shark의 정보가 너무 많다. 이럴때는 클래스로 선언하자
 * 2. Fish에서 주의할 점은 생존 여부도 파악해야 하며, Shark는 dfs를 위해 지금까지 먹은 물고기 번호의 합을 관리해야한다
 * 3. 물고기의 위치를 관리할 리스트를 하나 선언하자. 그리고 num으로 오름차순 정렬해준다
 * 4. 첫번째 물고기에 대한 작업을 진행하고 이후 dfs를 돌려준다
 * 5. dfs의 처음에는 ans를 최댓값으로 갱신해주고, 이후 현재 물고기 리스트에 있는 값들을 모두 꺼내와서 움직여준다
 * 6. 물고기의 움직임은 생존여부를 확인하고 진행한다. 8개의 방향에 대해 모두 탐색하며 범위를 벗어나지 않고, 상어가 없는 위치라면 이동을 진행하고 종료한다
 * 7. 이동과정은 swap으로 진행하며, 만약 이동 위치에 물고기가 없다면 그냥 이동하고 아니라면 둘의 위치를 바꿔준다
 * 8. arr 배열의 위치에 갱신하며 현재 물고기의 방향도 바궈준다
 * 9. 이후 shark의 위치를 이동한다. 4x4 배열이라 1~3만큼만 이동한다
 * 10. dfs는 배열과 리스트를 복사해야한다. 그리고 상어의 위치도 새롭게 갱신한다. 이 작업은 범위를 벗어나지 않거나 그 위치에 물고기가 있는 경우만 진행한다
 * 11. 그리고 고정된 현재 상어위치의 방향으로 1~3만큼 이동하며 복사한 결과를 반영하고, dfs에 넘겨준다
 * 12. 이렇게 완성한 ans를 출력하면 정답이 된다.
 *
 *
 * 해결방법:
 *
 * 시간복잡도: O(2^16)
 * 공간복잡도: O(1)
 *
 */
class Fish{
    int x;
    int y;
    int dir;
    int num;
    boolean isAlive = true;

    public Fish(int x, int y, int dir, int num, boolean isAlive) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.num = num;
        this.isAlive = isAlive;
    }
}

class Shark{
    int x;
    int y;
    int dir;
    int sum;

    public Shark(int x, int y, int dir, int sum) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.sum = sum;
    }
}


public class Main {

    static int ans = 0;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Fish> fishPos = new ArrayList<>();
        int[][] arr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken())-1;
                Fish fish = new Fish(i,j, b, a, true);
                fishPos.add(fish);
                arr[i][j] = fish.num;
            }
        }
        fishPos.sort((o1, o2) -> {
            return o1.num - o2.num;
        });


        Fish fish = fishPos.get(arr[0][0] - 1);
        Shark shark = new Shark(0,0, fish.dir, fish.num);
        fish.isAlive = false;
        arr[0][0] = -1;

        dfs(arr, shark, fishPos);

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void dfs(int[][] arr, Shark shark, List<Fish> fishPos) {
        if(ans < shark.sum){
            ans = shark.sum;
        }

        fishPos.forEach(e -> moveFish(e, arr, fishPos));

        for (int i = 1; i < 4; i++) {
            int nx = shark.x + dx[shark.dir] * i;
            int ny = shark.y + dy[shark.dir] * i;
            if(isRange(nx,ny) && arr[nx][ny] > 0){
                int[][] copy = copyArr(arr);
                List<Fish> fishCopy = copyFish(fishPos);
                copy[shark.x][shark.y] = 0;
                Fish fish = fishCopy.get(arr[nx][ny] - 1);
                Shark newShark = new Shark(fish.x, fish.y, fish.dir, shark.sum + fish.num);
                fish.isAlive = false;
                copy[fish.x][fish.y] = -1;

                dfs(copy, newShark, fishCopy);
            }
        }
    }

    private static List<Fish> copyFish(List<Fish> fishPos) {
        List<Fish> tmp = new ArrayList<>();
        fishPos.forEach(f -> tmp.add(new Fish(f.x, f.y, f.dir, f.num, f.isAlive)));
        return tmp;
    }

    private static int[][] copyArr(int[][] arr) {
        int[][] tmp = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tmp[i][j] = arr[i][j];
            }
        }

        return tmp;
    }

    private static void moveFish(Fish fish, int[][] arr, List<Fish> fishPos) {
        if(!fish.isAlive){
            return;
        }
        for (int i = 0; i < 8; i++) {
            int next = (fish.dir + i) % 8;
            int nx = fish.x + dx[next];
            int ny = fish.y + dy[next];
            if(isRange(nx,ny) && arr[nx][ny] > -1){
                arr[fish.x][fish.y] = 0;
                if(arr[nx][ny] == 0){
                    fish.x = nx;
                    fish.y = ny;
                }else{
                    Fish tmp = fishPos.get(arr[nx][ny] - 1);
                    tmp.x = fish.x;;
                    tmp.y = fish.y;
                    arr[fish.x][fish.y] = tmp.num;

                    fish.x = nx;
                    fish.y = ny;
                }
                arr[nx][ny] = fish.num;
                fish.dir = next;
                return;
            }
        }

    }


    private static boolean isRange(int nx, int ny){
        return nx >= 0 && nx < 4 && ny >= 0 && ny < 4;
    }

}
