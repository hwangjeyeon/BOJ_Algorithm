import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. n이 매우 작은 깡구현 문제다.
 * 2. 주어진 조건에 맞춰서 구현만 해주면 된다
 * 3. 입력값 관리가 조금 까다로운 문제인데, 각 학생의 번호와 그 학생이 좋아하는 학생의 번호는 리스트배열을 활용해서 인덱스와 리스트값으로 관리했다
 * 4. 이어서 학생의 번호는 입력순서대로 배치해야하기 때문에 큐에다가 넣어서 관리했다
 * 5. 주어진 탐색 순서에 맞춰서 구현했다. 비어있는 칸의 좌표 후보를 뽑은 다음 한칸이면 그 칸에다가 배치하는 로직을 실행하고 이후 로직을 건너뛴다
 * 6. 만약 1개를 초과한다면 후보지만을 기준으로 빈칸 탐색을 진행한다. 만약 빈칸 후보지의 개수가 1개면 그 위치에 배치하고 이후 로직을 건너뛴다
 * 7. 만약 빈칸 후보지도 1개를 초과한다면 리스트를 행번호를 기준으로 오름차순하고 같다면 열번호를 기준으로 오름차순정렬한다
 * 8. 이어서 맨 처음 값을 좌표로 하는 위치에 현재 번호를 배치한다. 어차피 위 로직에 따라 순서대로 실행하면 예외가 발생할 수 없기 때문에 불필요한 예외는 필요 없는 문제다
 * 9. 마지막으로 모든 좌표를 꺼내서 상하좌우로 범위를 벗어나지 않으면서 자신이 좋아하는 학생이 있는지 개수를 세서 별도의 배열에 값을 넣어준다
 * 10. 최종적으로 별도의 배열을 모두 순회하면서 값의 개수에 따라 ans에 지정한 값을 합산한다.
 * 11. 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^4)
 * 공간복잡도: O(n^2)
 *
 */
public class Main {

    static int n;
    static List<Integer>[] list;
    static int[][] arr;
    static Queue<Integer> q = new LinkedList<>();
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        list = new List[n*n+1];
        arr = new int[n][n];
        for (int i = 0; i < n*n+1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n*n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            q.add(a);
            for (int j = 0; j < 4; j++) {
                list[a].add(Integer.parseInt(st.nextToken()));
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            List<int[]> candidates = adjacent(now);
            if(candidates.size() == 1){
                place(candidates.get(0), now);
                continue;
            }

            List<int[]> blanks = blank(candidates);


            if(blanks.size() == 1){
                place(blanks.get(0), now);
                continue;
            }

            Collections.sort(blanks, (o1, o2) -> {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            });
            place(blanks.get(0), now);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = arr[i][j];
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(isRange(ny, nx) && list[a].contains(arr[ny][nx])){
                        count++;
                    }
                }
                if(count == 0){
                    ans += 0;
                }else if(count == 1){
                    ans += 1;
                }else if(count == 2){
                    ans += 10;
                }else if(count == 3){
                    ans += 100;
                }else if(count == 4){
                    ans += 1000;
                }
            }
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static List<int[]> blank(List<int[]> candidates) {
        int max = 0;
        int[][] count = new int[n][n];
        for (int i = 0; i < candidates.size(); i++) {
            int[] now = candidates.get(i);
            int tmp = 0;
            for (int j = 0; j < 4; j++) {
                int ny = now[0] + dy[j];
                int nx = now[1] + dx[j];
                if(isRange(ny,nx) && arr[ny][nx] == 0){
                    tmp++;
                }
            }
            max = Math.max(max, tmp);
            count[now[0]][now[1]] = tmp;
        }
        List<int[]> blanks = new ArrayList<>();

        for (int i = 0; i < candidates.size(); i++) {
            int[] now = candidates.get(i);
            if(max == count[now[0]][now[1]]){
                blanks.add(now);
            }
        }
        return blanks;
    }

    private static boolean isRange(int ny, int nx) {
        return ny >= 0 && ny < n && nx >= 0 && nx < n;
    }

    private static void place(int[] man, int now) {
        arr[man[0]][man[1]] = now;
    }

    private static List<int[]> adjacent(int now) {
        int[][] count = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = 0;
                if(arr[i][j] != 0){
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(isRange(ny,nx) && list[now].contains(arr[ny][nx]) && arr[ny][nx] != 0){
                        tmp++;
                    }
                }
                count[i][j] = tmp;
                max = Math.max(max, tmp);
            }
        }

        List<int[]> candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(count[i][j] == max && arr[i][j] == 0){
                    candidates.add(new int[]{i,j});
                }
            }
        }
        return candidates;
    }
}
