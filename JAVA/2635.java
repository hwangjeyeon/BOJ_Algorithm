import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 입력값이 작아서 n부터 1까지의 수를 모두 탐색하면 되는 문제다.
 * 2. 각 순회마다 first와 second를 n과 i로 지정해두고 while문을 돌린다
 * 3. 처음 시작에서 third에다가 first-second를 두고 third가 음수이면 순회를 종료한다
 * 4. 아닐 경우 tmp 리스트에 해당 값을 넣고 first를 second로 second를 third로 둔다
 * 5. 반복해서 나온 결과를 비교하는데, count값보다 tmp의 size가 더 크면 count에 tmp의 size를 넣고 ans 리스트를 tmp로 바꿔준다
 * 6. 완성한 결과를 각각 출력하면 된다.
 *
 * - 문제 해결:
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

        int n = Integer.parseInt(br.readLine());

        List<Integer> ans = new ArrayList<>();
        int count = 0;
        for (int i = n; i >= 1; i--) {
            List<Integer> tmp = new ArrayList<>();
            int first = n;
            int second = i;
            tmp.add(first);
            tmp.add(second);

            while(true){
                int third = first - second;
                if(third >= 0){
                    tmp.add(third);
                }else{
                    break;
                }
                first = second;
                second = third;
            }
            if(count < tmp.size()){
                count = tmp.size();
                ans = tmp;
            }

        }
        bw.write(count+"\n");
        for (Integer an : ans) {
            bw.write(an + " ");
        }
        br.close();
        bw.close();
    }
}

