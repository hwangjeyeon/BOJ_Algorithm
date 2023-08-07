import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.*;

/**
 * 풀이 방법: 브루트 포스 방식으로 모든 높이에서 걸리는 시간을 다 구한다음 가장 적은 시간이 걸리고 그중에서도 높이가 가장 높은 것을 선택하는 방법으로 풀었습니다
 * 접근 방법:
 * 2일동안 수없는 방법을 사용해봤습니다.
 * - 평균으로 높이를 미리 지정해서 땅을 파거나 땅을 쌓거나 하는 방식
 * - 한칸마다 인벤토리에 블럭이 있으면 쌓고 없으면 파내는 방식 등
 * 결국 내린 최종 결론은 모든 높이를 다 비교해보는 방식으로 밖에 답이 없다는 결론이 나왔습니다.
 * 하지만 모든 높이(최대높이256)를 다 비교하는 것보다 주어진 맵의 높이중 가장 높은 높이까지만 비교해도 된다는 것을 파악했고 맵의 높이를 하나씩 입력받을 때, Math함수를 이용하여 max로 가장 높은 높이를 파악했습니다
 *
 * 변수 선언:
 * int N = 세로 길이
 * int M = 가로 길이
 * int B = 인벤토리 블록
 * int[] block = 칸별 블록 높이를 받는 배열
 * int height = 가장 높은 높이 -> 비교할 때의 상한선
 * int[] times = 문제에서 주어진 작업 시간
 * int test_B = 임시 인벤토리 블록 -> 높이마다 비교할 때 기존 B를 쓰면 의도된 결과가 나타나지 않기 때문에 사용
 * int ans = 최소 시간을 구하기 위한 변수
 * int ans_height = 정답 높이를 받기 위한 변수
 *
 * 풀이과정:
 * - 0부터 상한선 높이(height) 반복합니다.
 * 1-1. 만약 현재 측정하는 높이보다 해당 맵 위치의 높이가 더 높으면 그 차이만큼 test_B에다가 더해줍니다 -> 땅을 파서 인벤토리에 넣는 작업
 * 1-2. 이때 해당 동작은 2초가 걸리므로 그 차이에다가 2를 곱해서 시간에 더해줍니다
 * 2-1. 만약 현재 측정하는 높이보다 해당 맵 위치의 높이가 더 낮으면 그 차이만큼 test_B에다가  빼줍니다 -> 인벤토리에서 블록을 가져오는 과정
 * 2-2. 이때 해당 동작은 1초가 걸리므로 그 차이만큼 시간에 더해줍니다
 * 3. 최종적으로 1,2 과정을 모두 마치고 나서 test_B가 음수인지 확인합니다. 만약 음수이면 해당 높이는 정답이 될 수 없다는 것을 의미하므로, times[i]에 -1을 넣어 표시해줍니다
 * 4. 만약 -1이면 continue해서 후보에서 제외하고, 가장 작은 times[i]를 ans에 넣습니다 이때 i도 해당 높이가 가장 작다는 것을 의미하므로 ans_height에 넣습니다
 * 5. 최종 결과로 ans와 ans_height를 출력합니다.
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] block = new int[N * M];
        st = new StringTokenizer(br.readLine());
        int height = -1 ;
        for (int i = 0; i < (M * N); i++) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            block[i] = Integer.parseInt(st.nextToken());
            height = max(height, block[i]);
        }

        br.close();
        int[] times = new int[height+1];
        for(int i=0; i<height+1; i++) {
                times[i] = 0;
        }

        for(int i=0; i<height+1; i++) {
            int test_B = B;

            for (int j = 0; j < N * M; j++) {
                if (block[j] > i) {
                    test_B += (block[j] - i);
                    times[i] += ((block[j] - i) * 2);
                } else if(block[j] < i){
                    test_B -= (i - block[j]);
                    times[i] += (i - block[j]);
                }
            }
            if(test_B<0){
                times[i] = -1;
            }
        }
        long ans = times[0];
        long ans_height = 0;
        for(int i=0; i<height+1; i++){
            if(times[i] == -1){
                continue;
            }
            if(ans >= times[i]){
                ans = times[i];
                ans_height = i;
            }

        }

        bw.write(ans + " " + ans_height);
        bw.close();
    }
}
