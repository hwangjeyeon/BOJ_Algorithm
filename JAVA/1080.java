

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 그리디하게 하려면 왼쪽 위만을 기준으로 해서 다르면 3*3만큼 반전시키면 된다.
 * 2. 이렇게 하면 중복으로 뒤집는 경우도 없고, 순차적으로 순회할 때 중복으로 뒤집지 않는 왼쪽 위만을 뒤집기 때문에 그리디하게 뒤집을 수 있다
 * 3. 각 왼쪽 위가 다를 경우만 3*3만큼 반전시킨 뒤, 마지막에 n*m만큼 모두 순회해서 다른게 있으면 -1을 출력, 아니면 count를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(nm*3*3)
 * 공간복잡도: O(nm)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr1[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr2[i][j] = Integer.parseInt(input[j]);
            }
        }
        boolean isOk = true;
        int count = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m-2; j++) {
                if(arr1[i][j] != arr2[i][j]){
                    count++;
                    for (int k = i; k < i+3; k++) {
                        for (int l = j; l < j+3; l++) {
                            if(arr1[k][l] == 1){
                                arr1[k][l] = 0;
                            }else{
                                arr1[k][l] = 1;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr1[i][j] != arr2[i][j]){
                    isOk = false;
                }else{

                }
            }
        }


        if(!isOk){
            bw.write("-1");
        }else{
            bw.write(count+"");
        }

        br.close();
        bw.close();
    }
}

