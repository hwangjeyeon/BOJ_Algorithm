import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 리스트를 사용해서 hard와 easy 문제의 난이도를 보관한다
 * 2. 풀이를 쉽게 하기 위해서 리스트를 hard를 기준으로 오름차순 정렬, 같으면 easy를 기준으로 오름차순 정렬을 하였다
 * 3. 이후 hard를 풀 수 있으면서 solve 수가 충족된다면 score에 140을 더하고 없다면 easy를 체크해서 100을 더해준다
 * 4. 완성한 score를 출력하면 정답이 된다.
 * 
 * 해결방법:
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int score = 0;
        int solve = 0;
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int easy = Integer.parseInt(st.nextToken());
            int hard = Integer.parseInt(st.nextToken());
            list.add(new int[] {hard, easy});

        }
        list.sort((o1,o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
           return o1[0] - o2[0];
        });

        for (int i = 0; i < list.size(); i++) {
            if(solve < k && list.get(i)[0] <= l){
                solve++;
                score+=140;
            }else if(solve < k  && list.get(i)[1] <= l){
                solve++;
                score+=100;
            }
        }

        bw.write(score + "");



        br.close();
        bw.close();
    }
}

