import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 타이머 A,B,C를 큰 순서대로 배열에 넣어 초기화하고, 각 사용 횟수를 리스트에 넣은 다음 출력한다.
 * - 이때 입력받은 T가 0이 아니면 요리시간을 맞출 수 없는 것이므로 -1을 출력한다.
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] timer = {300,60,10};
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<timer.length; i++){
            ans.add(T/timer[i]);
            T %= timer[i];
        }

        if(T != 0){
            bw.write(-1+"");
        }else{
            for (int i: ans) {
                bw.write(i + " ");
            }
        }


        br.close();
        bw.close();
    }

}
