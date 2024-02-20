import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 규칙을 찾기 위해서는 먼저 난잡한 입력값들을 오름차순 정렬을 해야한다
 * - 이어서 생각한 규칙은 양 옆의 차이 기준, 처음 값을 기준으로 오른쪽의 두수 가져와서 배치 등을 생각했으나 다 출력값으로 이어지지는 못했다
 * - 이어서 문제에서 설명한 예제 배치를 파악했는데, 정렬한 후, 왼쪽 수부터 차례대로 처음 -> 끝, 처음의 오른쪽(두번째 인덱스) -> 끝 직전 인덱스 (마지막에서 두번쨰 인덱스) 이런식으로 배치됨을 확인했다
 * - 따라서 해당 로직대로 적절하게 구현해서 정답으로 활용할 배열에 배치시킨다
 * - 마지막으로 배열을 순회해서 차이가 가장 큰 수를 뽑아서 정답으로 출력하면 된다.
 *
 *
 * 시간복잡도: O(T*n)
 * 공간복잡도: O(n)
 *
 */


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] input = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(input);
            int[] log = new int[n];
            int left = 0;
            int right = n-1;
            for (int j = 0; j < n; j++) {
                if(j%2 == 0){
                    log[left] = input[j];
                    left++;
                }else {
                    log[right] = input[j];
                    right--;
                }
            }
            int max = -1;
            for (int j = 0; j < n; j++) {
                if(j!= n-1){
                    max = Math.max(max, Math.abs(log[j] - log[j+1]));
                }else{
                    max = Math.max(max,Math.abs(log[0] - log[n-1]));
                }
            }

            bw.write(max+"\n");
        }





        br.close();
        bw.close();
    }

}

