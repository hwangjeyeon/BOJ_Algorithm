import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 입력 배열과 임시배열, 정답 배열 총 3개 만들어둔다
 * 2. 입력 배열을 순회하면서, 숫자를 발견하면 임시배열의 그 위치에 -1를 넣는다
 * 3. 그리고 배열 범위를 벗어나지 않으면 그 상하좌우 대각선의 위치에 값을 1 증가시킨다
 * 4. 입력배열 순회 종료 후, 임시배열을 순회하는데, -1이면 정답 배열에 *을 넣고 10을 넘으면 M을 넣어준다. 그 외의 경우 그 숫자를 문자로 넣어준다.
 * 5. 완성한 정답 배열을 출력한다.
 * 6. 한가지 체크해야할 것이 주위 8칸을 탐색할 때, 지뢰가 있는 곳을 다시 탐색할수도 있다. 그래서 -1이 사라질 수도 있으므로 그 부분은 범위 체크를할 때 제외하도록 조건을 추가해줘야 한다.
 *
 * 문제 해결:
 * - 다음번에는 dx, dy를 활용해보자
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 *
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[][] input = new String[n][n];
        int[][] tmp = new int[n][n];
        String[][] ans = new String[n][n];
//        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 }, dy = { -1, 0, 1, -1, 1, -1, 0, 1 }; -> 활용하려면 8번 순회하는 포문 한번더 해야함.
        
        for (int i = 0; i < n; i++) {
            String[] a = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                input[i][j] = a[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!input[i][j].equals(".")){
                    int count = Integer.parseInt(input[i][j]);
                    tmp[i][j] = -1;

                    //상
                    if(i-1 >= 0 && input[i-1][j].equals(".")){
                        tmp[i-1][j]+=count;
                    }

                    //하
                    if(i+1 < n && input[i+1][j].equals(".")){
                        tmp[i+1][j]+=count;
                    }

                    //좌
                    if(j-1 >= 0 && input[i][j-1].equals(".")){
                        tmp[i][j-1]+=count;
                    }

                    //우
                    if(j+1 < n && input[i][j+1].equals(".")){
                        tmp[i][j+1]+=count;
                    }

                    //좌상
                    if(i-1 >= 0 && j-1 >=0 && input[i-1][j-1].equals(".")){
                        tmp[i-1][j-1]+=count;
                    }

                    //우상
                    if(i-1>=0 && j+1 < n && input[i-1][j+1].equals(".")){
                        tmp[i-1][j+1]+=count;
                    }

                    //좌하
                    if(i+1 <n && j-1 >= 0 && input[i+1][j-1].equals(".")){
                        tmp[i+1][j-1]+=count;
                    }

                    //우하
                    if(i+1 < n && j+1 < n && input[i+1][j+1].equals(".")){
                        tmp[i+1][j+1]+=count;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(tmp[i][j] == -1){
                    ans[i][j] = "*";
                }else if(tmp[i][j] >= 10){
                    ans[i][j] = "M";
                }else{
                    ans[i][j] = String.valueOf(tmp[i][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(ans[i][j]);
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}
