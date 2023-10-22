import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정:
 * - 우테코 미션, GDSC 면접, 알고리즘 경시대회 준비로 인해 백준 DP, 문자열 풀이와 스프링 공부가 늦어지고 있어서 GDSC 면접, 알고리즘 경시대회, 우테코 미션을 중점적으로 끝낸 후에 공부 진행할 에정입니다.
 * - 그냥 모든 조건 처리 했습니다.
 *
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int diceNum1 = Integer.parseInt(st.nextToken());
        int diceNum2 = Integer.parseInt(st.nextToken());
        int diceNum3 = Integer.parseInt(st.nextToken());

        if(diceNum1 == diceNum2 && diceNum2 == diceNum3){
            bw.write(1000*diceNum1 + 10000 +"");
        }else if(diceNum1 == diceNum2 || diceNum1 == diceNum3){
            bw.write(100*diceNum1 + 1000 +"");
        }else if(diceNum2 == diceNum3) {
            bw.write(100*diceNum2 + 1000 +"");
        }else{
            bw.write(Math.max(Math.max(diceNum1,diceNum2),diceNum3)*100 +"" );
        }
        br.close();
        bw.close();
    }

}
