import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 플로이드 와샬을 활용하면 쉽게 풀 수 있는 문제다
 * 2. 배열을 n으로 초기화하는 것이 아닌 알파벳 개수인 26개의 크기로 지정해주어야 한다
 * 3. 플로이드 와샬을 조금 변형하여, arr[j][i]가 1이고 arr[i][k]가 1이면 해당 arr[j][k]를 1로 초기화한다
 * 4. 이후 m번의 입력을 받으면서 해당 위치가 1이면 T 아니면 F를 출력한다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[26][26];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            st.nextToken();
            char b = st.nextToken().charAt(0);
            int A = a-'a';
            int B = b-'a';
            arr[A][B] = 1;
        }
        floydWarshall();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            st.nextToken();
            char b = st.nextToken().charAt(0);
            int A = a-'a';
            int B = b-'a';
            if(arr[A][B] == 1){
                bw.write("T\n");
            }else{
                bw.write("F\n");
            }
        }


        br.close();
        bw.close();
    }

    private static void floydWarshall() {

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    if(arr[j][i] == 1 && arr[i][k] == 1){
                        arr[j][k] = 1;
                    }
                }
            }
        }


    }

}

