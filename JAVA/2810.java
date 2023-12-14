import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 컵홀더를 사용할 수 있는 사람은 전체 좌석의 수와 같다. 다음의 경우를 제외하고 말이다
 * - 커플석 쌍이 두개 이상 있을 경우 컵홀더 사용 가능한 사람의 수가 1씩 감소한다. 
 * - 따라서 커플석 쌍이 두개 이상 있을 경우 전체 좌석에서 커플석 쌍의 개수를 빼주고 1을 더해준 뒤 정답을 출력하면 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String seats = br.readLine();
        int countCouple = 0;
        for(int i=0; i<seats.length(); i++){
            if(seats.charAt(i) == 'L'){
                countCouple++;
            }
        }
        countCouple /= 2;
        int cupholder = 0;
        if(countCouple > 1){
            cupholder = n - countCouple+1;
        }else{
            cupholder = n;
        }

        bw.write(cupholder+"");

        br.close();
        bw.close();
    }

}
