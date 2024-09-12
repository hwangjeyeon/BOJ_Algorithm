import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 먼저 처음 들어오는 nxn크기의 맵 정보를 char[][] 배열에 저장한다
 * 2. 정답을 위한 배열을 하나 선언해야한다. 이 배열은 nxn크기이며 char[][] 배열이고, 입력값에 대한 탐색을 통해 갱신될것이다
 * 3. 입력값을 보며, x인 경우 8방 탐색을 통해 지뢰가 있는지 확인한다. 만약 지뢰가 있다면 그 개수를 세어주며, 탐색 후, 정답 배열에 넣어준다
 * 4. 한가지 더 생각해야할 부분이 있다. 만약 내가 선택한 곳에 지뢰가 있는 경우 모든 지뢰를 표시해줘야한다. 다른 값을 지우지말고, 단지 지뢰가 있는 지역에 대한 표시만 해주면 된다
 * 5. 따라서 지뢰를 밟았는지 체크를 해줄 boolean 변수를 하나 선언한 뒤에, x이면서 지뢰가 있으면 true로 바꾸고 이후 처리는 그대로 진행한다
 * 6. 마지막으로 만약 bombFind가 true라면 n x n 순회를 한번 더 돌면서 *가 있는 모든 지점을 ans 배열에 *로 표시한다
 * 7. 이후 ans 배열을 순회하면서 하나씩 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n*n*8)
 * 공간복잡도: O(n*n)
 *
 */



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        char[][] ans = new char[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = s[j].charAt(0);
            }
        }

        int[] dy = {-1,-1,-1,0,0,1,1,1};
        int[] dx = {-1,0,1,-1,1,-1,0,1};

        boolean bombFind = false;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                char s = input[j].charAt(0);
                if(s == 'x'){
                    if(arr[i][j] == '*'){
                        bombFind = true;
                    }
                    int count = 0;
                    for (int k = 0; k < 8; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(ny >= 0 && nx >= 0 && nx < n && ny < n && arr[ny][nx] == '*'){
                            count++;
                        }
                    }
                    ans[i][j] = String.valueOf(count).charAt(0);
                }else{
                    ans[i][j] = '.';
                }
            }
        }

        if(bombFind){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j] == '*'){
                        ans[i][j] = '*';
                    }
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

