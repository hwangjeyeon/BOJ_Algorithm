import java.io.*;
import java.util.*;


/**
 * 풀이 방법: dfs 탐색 알고리즘으로 풀었습니다.
 * 접근 방법: 입력값이 적고 그래프 탐색 알고리즘이며, 시간제한이 2초로 넉넉히 주어서 dfs 탐색 알고리즘으로 풀어봐야겠다고 접근했습니다.
 * 풀이 과정: 
 * 1. dfs 탐색 알고리즘으로 배열을 탐색합니다. 
 * 2. 이때 개수를 확인하기 위해 미 방문하고 canvas가 1일 경우 count++해주고 temp에다가 탐색할때마다 크기를 증가하여 해당 그림의 넓이를 담은 뒤, big에 있는 값과 비교합니다.
 * 3. 최종 count와 big 값을 출력합니다.
 *
 * 시간복잡도: O(n*m) 최악의 경우 500*500이므로 제한시간 2초를 넘지 않는다. 
 * 공간복잡도: O(n*m)
 *
 */





public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] canvas = new int[n][m];
        int[][] visited = new int[n][m];
        Stack<Integer> stack = new Stack<>();
        int count=0;
        int big = 0;
        int temp =0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                canvas[i][j] = Integer.parseInt(st.nextToken());
            }
            if(i < n-1){
                st = new StringTokenizer(br.readLine());
            }
        }

        br.close();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(canvas[i][j] == 0){
                    continue;
                }

                if(canvas[i][j] == 1 && visited[i][j] == 0){
                    count++;
                    temp++;
                }
                stack.add(i);
                stack.add(j);
                visited[i][j] = 1;
                while(!stack.isEmpty()) {
                    int x = stack.pop();
                    int y = stack.pop();

                    if (y-1 >= 0 && visited[y-1][x] == 0 && canvas[y-1][x] == 1) {
                        stack.add(y-1);
                        stack.add(x);
                        visited[y-1][x] = 1;
                        temp++;
                    }
                    if (y+1 < n && visited[y+1][x] == 0 && canvas[y+1][x] == 1){
                        stack.add(y+1);
                        stack.add(x);
                        visited[y+1][x] = 1;
                        temp++;
                    }
                    if(x-1 >=0 && visited[y][x-1] == 0 && canvas[y][x-1] == 1){
                        stack.add(y);
                        stack.add(x-1);
                        visited[y][x-1] = 1;
                        temp++;
                    }
                    if(x+1<m && visited[y][x+1] == 0 && canvas[y][x+1] == 1){
                        stack.add(y);
                        stack.add(x+1);
                        visited[y][x+1] = 1;
                        temp++;
                    }


                }

                big = Math.max(big, temp);
                temp =0;

            }
        }

        bw.write(count + "\n" + big);
        bw.close();



    }
}
