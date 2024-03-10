import java.io.*;
import java.math.BigInteger;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민 및 풀이:
 * 1. n만큼 각 문자열 자리에서 가장 많이 나타나는 알파벳을 체크한다.
 * 2. 완성된 배열을 체크하는데 자릿수별로 가장 큰 값의 위치를 확인하고 이에 해당하는 문자열을 result에 넣는다
 * 3. 완성된 result를 다시 순회해서 맞지 않는 문자열만큼 ans에 더해준다
 * 4. 완성한 결과를 result와 ans 순으로 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(m)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
        }

        int ans = 0;
        int[][] arr = new int[m][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(input[i].charAt(j) == 'A'){
                    arr[j][0]++;
                }else if(input[i].charAt(j) == 'C'){
                    arr[j][1]++;
                }else if(input[i].charAt(j) == 'G'){
                    arr[j][2]++;
                }else if(input[i].charAt(j) == 'T'){
                    arr[j][3]++;
                }
            }
        }
        String result = "";
        for (int i = 0; i < m; i++) {
            int tmp = 0;
            int now = -1;
            for (int j = 0; j < 4; j++) {
                if(tmp < arr[i][j]){
                    now = j;
                    tmp = Math.max(tmp, arr[i][j]);
                }
            }
            if(now == 0){
                result += "A";
            }else if(now ==1){
                result += "C";
            }else if(now == 2){
                result += "G";
            }else if(now == 3){
                result += "T";
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(input[i].charAt(j) != result.charAt(j)){
                    ans++;
                }
            }
        }

        bw.write(result+"\n");
        bw.write(ans+"");
        br.close();
        bw.close();
    }

}

