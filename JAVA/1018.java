import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 브루트포스로 해결
 * - String 2차원 배열로 정답 배열을 만든 뒤, 8*8배열만큼 주어진 field 배열에서 왼쪽 상단부터 쭉 완전탐색한다
 * - black과 white인 경우 따로 count해서 가장 작은 값을 ans와 비교해서 더 작은 값을 넣어주고 순회 종료 후 출력한다.
 * - 과거 C++로 풀었던 문제를 이제 자바로 풀어보았다. 
 * - 코테보고나니 풀었던 문제를 다시 풀어보는 것이 중요하다는 것을 깨닫게 되었다. 따라서 먼저 C++로 풀었던 문제를 자바로 풀고, 이후에 답지 봤던 문제들을 자바로 다시 풀 계획이다.
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(n*m)
 *
 */



public class Main {

    static String[][] black = {
            {"B","W","B","W","B","W","B","W"},
            {"W","B","W","B","W","B","W","B"},
            {"B","W","B","W","B","W","B","W"},
            {"W","B","W","B","W","B","W","B"},
            {"B","W","B","W","B","W","B","W"},
            {"W","B","W","B","W","B","W","B"},
            {"B","W","B","W","B","W","B","W"},
            {"W","B","W","B","W","B","W","B"}
    };

    static String[][] white = {
            {"W","B","W","B","W","B","W","B"},
            {"B","W","B","W","B","W","B","W"},
            {"W","B","W","B","W","B","W","B"},
            {"B","W","B","W","B","W","B","W"},
            {"W","B","W","B","W","B","W","B"},
            {"B","W","B","W","B","W","B","W"},
            {"W","B","W","B","W","B","W","B"},
            {"B","W","B","W","B","W","B","W"}
    };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[][] field = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                field[i][j] = line[j];
            }
        }

        int width = m-8+1;
        int height = n-8+1;
        int count1 = 0;
        int count2 = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if(!Objects.equals(field[i+k][j+l], black[k][l])){
                            count1++;
                        }
                        if(!Objects.equals(field[i+k][j+l], white[k][l])){
                            count2++;
                        }

                    }
                }

                ans = Math.min(ans,Math.min(count1, count2));
                count1 = 0;
                count2 = 0;
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

