import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 주어진 경우가 딱 두개 밖에 없다. 따라서 그냥 배열로 미리 만들어두자
 * 2. 그리고 입력 배열을 순회하는데 탐색범위를 입력배열 크기 - 8만큼 순회한다
 * 3. 이어서 위 순회안에서 8*8순회를 더 해서 만약 같지 않은 경우 count를 해준다. black과 white로 count2, count1을 나눠서 세어준다
 * 4. 위 순회가 끝나면 count1과 count2중 작은것을 선택하고, 다시 ans와 비교해서 더 작은 것을 ans에 넣어준다
 * 5. 완성된 ans를 출력하면 정답이다.
 *
 *
 * 문제 해결:
 *
 *
 * 시간복잡도: O((n-8) * (m-8) * 8 * 8)
 * 공간복잡도: O(nm)
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[][] white = {
                {"W","B","W","B","W","B","W","B"},
                {"B","W","B","W","B","W","B","W"},
                {"W","B","W","B","W","B","W","B"},
                {"B","W","B","W","B","W","B","W"},
                {"W","B","W","B","W","B","W","B"},
                {"B","W","B","W","B","W","B","W"},
                {"W","B","W","B","W","B","W","B"},
                {"B","W","B","W","B","W","B","W"},
        };

        String[][] black = {
                {"B","W","B","W","B","W","B","W"},
                {"W","B","W","B","W","B","W","B"},
                {"B","W","B","W","B","W","B","W"},
                {"W","B","W","B","W","B","W","B"},
                {"B","W","B","W","B","W","B","W"},
                {"W","B","W","B","W","B","W","B"},
                {"B","W","B","W","B","W","B","W"},
                {"W","B","W","B","W","B","W","B"}
        };


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[][] field = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                field[i][j] = input[j];
            }
        }

        int count1 = 0;
        int count2 = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n-8; i++) {
            for (int j = 0; j <= m-8; j++) {
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if(!field[i+k][j+l].equals(white[k][l])){
                            count1++;
                        }

                        if(!field[i+k][j+l].equals(black[k][l])){
                            count2++;
                        }
                    }
                }
                ans = Math.min(ans, Math.min(count1,count2));
                count1 = 0;
                count2 = 0;
            }
        }

        bw.write(ans+"");
        br.close();
        bw.close();
    }

}
