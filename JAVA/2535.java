import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 처음에는 map이랑 클래스 선언해서 사용하려고 했는데, 쉽지 않아서 2차원 배열로 관리했다
 * 2. 점수를 기준으로 내림차순 정렬하고, 0행부터 순서대로 출력한다
 * 3. 나라별로 메달 수 제한이 되어있으므로 금은이 같은 국가만 조건에 해당힉 ㅒㄸ문에 동메달 받을 학생을 정한다
 * 4. 완성한 결과를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
        }
        Arrays.sort(arr, (o1, o2) -> {
            return o2[2] - o1[2];
        });

        int count = 2;
        if(arr[0][0] == arr[1][0]){
            for (int i = 2; i < n; i++) {
                if(arr[0][0] != arr[i][0]){
                    count = i;
                    break;
                }
            }
        }

        bw.write(arr[0][0] + " " + arr[0][1] + "\n");
        bw.write(arr[1][0] + " " + arr[1][1] + "\n");
        bw.write(arr[count][0] + " " + arr[count][1]);
        
        br.close();
        bw.close();
    }

}
