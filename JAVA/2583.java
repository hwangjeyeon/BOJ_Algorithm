import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - BFS를 이용하여 풀면 된다.
 * - 빈 영역은 0, 색칠한 부분은 1로 설정한다
 * - 좌표로 주어졌기 때문에, 좌표 시작부터 좌표 끝나는 지점까지 각각 1로 색칠해준다
 * - 이후에 BFS 탐색을 통해 0인 부분의 영역의 넓이를 구해 리스트에 넣어준다
 * - 오름차순으로 출력해야하기 때문에 먼저 리스트를 오름차순 정렬한다
 * - 이후 리스트의 size를 출력하고, 이어서 리스트에 들어간 각 넓이의 값들을 출력해준다.
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */





public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] field = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                field[i][j] = 0;
            }
        }


        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            for(int j=startY; j<endY; j++){
                for(int l=startX; l<endX; l++){
                    field[j][l] = 1;
                }
            }
        }
        int squareArea = 0;
        List<Integer> areas = new ArrayList<>();
        Queue<Integer> area = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(field[i][j] == 0){
                    field[i][j] = -1;
                    area.add(i);
                    area.add(j);

                    while(!area.isEmpty()){
                        int y = area.poll();
                        int x = area.poll();
                        //상
                        if(y-1 >= 0 && field[y-1][x] == 0){
                            area.add(y-1);
                            area.add(x);
                            field[y-1][x] = -1;
                            squareArea++;
                        }
                        //하
                        if(y+1 < m && field[y+1][x] == 0){
                            area.add(y+1);
                            area.add(x);
                            field[y+1][x] = -1;
                            squareArea++;
                        }

                        //좌
                        if(x-1 >= 0 && field[y][x-1] == 0){
                            area.add(y);
                            area.add(x-1);
                            field[y][x-1] = -1;
                            squareArea++;
                        }

                        //우
                        if(x+1 <n && field[y][x+1] == 0){
                            area.add(y);
                            area.add(x+1);
                            field[y][x+1] = -1;
                            squareArea++;
                        }
                    }
                    areas.add(squareArea+1);
                }
                squareArea=0;
            }
        }

        Collections.sort(areas);
        StringBuilder sb = new StringBuilder();
        sb.append(areas.size()).append("\n");
        for (Integer i : areas) {
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}
