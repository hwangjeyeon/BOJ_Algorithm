import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - BFS와 브루트포스(완전탐색)을 이용하여 풀었다.
 * - 1부터 주어진 field 값에서 가장 큰값까지 모든 경우를 다 safeHeight로 BFS 넘겨준다.
 * - 각 결과들은 배열에 따로 저장하며, 그 배열의 값 중에서 가장 큰 수를 ans에 저장하고 출력하면 정답이 된다.
 * - BFS는 visited배열과 큐, 그리고 안전한 영역이 있는지를 판단해줄 isOk 변수를 선언한다
 * - 또한 안전한 영역의 개수를 세어줄 count도 선언한다
 * - 이제 모든 필드를 순회하는데 방문하지 현재 값이 밤운하지 않았고 안전높이보다 크거나 같으면 y,x좌표를 큐에 추가하고 isOk를 true로 하며 visited배열을 true로 바꾼다
 * - 이어서 상하좌우를 탐색하면서 인덱스 범위를 벗어나지 않고 위 조건을 만족하는 배열 좌표를 찾아서 큐에 넣고 visited 배열을 true로 바꾼다.
 * - 이렇게 완성된 결과를 하나의 뭉탱이로 보고 count로 출력해야하기 때문에 큐가 비어있는동안 순회하는 위 과정이 끝난 뒤 isOk가 true이면 count값을 증가한다
 * - 모든 순회가 끝난 뒤 count 값을 return해주면 된다.
 * 
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */

public class Main {

    static int bfs(int[][] field, int safeHeight){
        boolean[][] visited = new boolean[field.length][field.length];

        Queue<Integer> q = new LinkedList<>();
        boolean isOk;
        int count = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                isOk = false;
                if(field[i][j] >= safeHeight && !visited[i][j]){
                    q.add(i);
                    q.add(j);
                    isOk = true;
                    visited[i][j] = true;
                }

                while(!q.isEmpty()){
                    int y = q.poll();
                    int x = q.poll();
                    //상
                    if(y-1 >= 0 && field[y-1][x] >= safeHeight && !visited[y-1][x]){
                        q.add(y-1);
                        q.add(x);
                        visited[y-1][x] = true;
                    }
                    //하
                    if(y+1 < field.length && field[y+1][x] >= safeHeight && !visited[y+1][x]){
                        q.add(y+1);
                        q.add(x);
                        visited[y+1][x] = true;
                    }
                    //좌
                    if(x-1 >=0 && field[y][x-1] >= safeHeight && !visited[y][x-1]){
                        q.add(y);
                        q.add(x-1);
                        visited[y][x-1] = true;
                    }
                    //우
                    if(x+1 < field.length && field[y][x+1] >= safeHeight && !visited[y][x+1]){
                        q.add(y);
                        q.add(x+1);
                        visited[y][x+1] = true;
                    }
                }
                if(isOk){
                    count++;
                }
            }
        }
        return count;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] field = new int[n][n];

        int maxHeight = -1;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, field[i][j]);
            }
        }
        int[] heightCount = new int[maxHeight+1];
        int ans = -1;
        for (int i = 1; i <= maxHeight; i++) {
            heightCount[i] = bfs(field, i);
            ans = Math.max(ans, heightCount[i]);
        }

        bw.write(String.valueOf(ans));

        br.close();
        bw.close();
    }
}

