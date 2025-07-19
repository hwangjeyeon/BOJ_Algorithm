import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 이 문제는 고정된 크기의 표적지가 있고, nm크기의 사격판의 위치를 바꿔가며, 명중한 칸의 점수를 표적지에 올렸을 때 1점부터 10점까지 얻을 수 있어야하는 문제다
 * 2. 문제의 핵심은 10번 점수가 1칸 있으니 명중한 칸의 위치를 사격판의 중앙에 10점에 놓여있다고 생각하고, 모든 가능한 경우를 탐색하는 문제다
 * 3. 먼저 입력한 값을 배열에 배치하는데, 명중한 칸도 리스트에다가 넣어준다
 * 4. 이후 리스트의 값을 하나씩 뽑아서 10점칸이라 생각한 뒤, 현재 지점에서 +-9칸 만큼의 범위만큼 탐색을 진행한다. 벗어나면 최소, 최대 크기로 한정짓도록 한다
 * 5. 1인 지점에 대해서 10점칸과 얼마나 떨어져있는지 확인하며, 10점에서 그 만큼을 뺀다음 점수를 얻었는지 확인하는 배열에 그 인덱스 위치의 값을 증가시킨다
 * 6. 순회 종료 이후, 모든 칸이 명중했다면 그 위치로 확정짓고 순회를 탈출한다
 * 7. 만약 명중한 칸의 좌표가 둘다 -1이면 -1을 출력하고 아니면 그 칸의 좌표를 출력했을 때 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(100,000 * 19 * 19)
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

        char[][] arr = new char[n][m];
        List<int[]> shot = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == '1') {
                    shot.add(new int[]{i, j});
                }
            }
        }

        int ansY = -1;
        int ansX = -1;
        for (int[] now : shot) {
            int y = now[0];
            int x = now[1];
            int[] chk = new int[11];

            int startY = Math.max(0, y - 9);
            int endY = Math.min(n - 1, y + 9);
            int startX = Math.max(0, x - 9);
            int endX = Math.min(m - 1, x + 9);

            for (int i = startY; i < endY+1; i++) {
                for (int j = startX; j < endX+1; j++) {
                    if(arr[i][j] == '0'){
                        continue;
                    }
                    int score = 10 - Math.max(Math.abs(i-y), Math.abs(j-x));
                    chk[score]++;
                }
            }
            if(check(chk)){
                ansY = y;
                ansX = x;
                break;
            }
        }

        if(ansY == -1 && ansX == -1){
            bw.write("-1");
        }else{
            bw.write(ansY + " " + ansX);
        }

        br.close();
        bw.close();
    }

    private static boolean check(int[] chk) {
        for (int i = 1; i < 11; i++) {
            if(chk[i] != 1){
                return false;
            }
        }
        return true;
    }
}
