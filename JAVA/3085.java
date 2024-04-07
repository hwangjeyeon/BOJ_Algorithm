import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 입력값이 작아서 완탐을 해주면된다
 * 2. 스왑을 해주면 된다. 우측방향과 하측 방향만 확인하고 스왑해준 뒤, 열과 행을 기준으로 완탐해서 가장 큰 연속된 값을 찾아준다
 * 3. 각 스왑 탐색이 완료된 뒤에 다시 원상태로 복구시켜둔다.
 * 
 *
 * 문제 해결:
 * 1. arr.clone으로 했을 때 계속 틀렸는데 원인을 찾지 못했다. 다음 재풀이할 때, 이에 대해 알아볼 계획이다.
 *
 * 시간복잡도: O(n^4)
 * 공간복잡도: O(n^2)
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = input[j];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                // 우
                String s = arr[i][j];
                arr[i][j] = arr[i][j+1];
                arr[i][j+1] = s;


                ans = getAns(n, arr, ans);

                s = arr[i][j];
                arr[i][j] = arr[i][j+1];
                arr[i][j+1] = s;

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {

                //하
                String s = arr[j][i];
                arr[j][i] = arr[j+1][i];
                arr[j+1][i] = s;

                ans = getAns(n, arr, ans);

                s = arr[j][i];
                arr[j][i] = arr[j+1][i];
                arr[j+1][i] = s;
            }
        }





        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static int getAns(int n, String[][] tmp, int ans) {
        for (int k = 0; k < n; k++) {
            int count = 1;
            for (int l = 0; l < n -1; l++) {
                if(tmp[k][l+1].equals(tmp[k][l])){
                    count++;
                }else{
                    count = 1;
                }
                ans = Math.max(ans, count);
            }
        }
        for (int k = 0; k < n; k++) {
            int count = 1;
            for (int l = 0; l < n -1; l++) {
                if(tmp[l+1][k].equals(tmp[l][k])){
                    count++;
                }else{
                    count = 1;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

}
