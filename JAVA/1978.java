import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 입력값이 작아 1~3은 예외로 처리하고 그 외의 수는 2부터 자기자신 - 1까지 나누어 떨어지는 수가 있는지 체크한 뒤 없으면 count 값을 증가시키도록 하였다.
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tmp = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            tmp = Integer.parseInt(st.nextToken());
            if(tmp == 1){
                continue;
            }else if(tmp == 2 || tmp == 3){
                count++;
            }else{
                boolean isOk = true;
                for (int j = 2; j < tmp; j++) {
                    if(tmp % j == 0){
                        isOk = false;
                        break;
                    }
                }
                if(isOk){
                    count++;
                }
            }
        }

        bw.write(count+"");

        br.close();
        bw.close();
    }

}

