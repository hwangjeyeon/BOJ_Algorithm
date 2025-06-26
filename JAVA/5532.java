import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 두 과목 모두 0이하가 되면 i+1만큼 l에서 빼준다
 * 2. 첫날 모두 마친다해도 그날은 포함 안하므로 예외를 생각하지 않아도 된다
 * 3. 완성한 l을 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(l)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        
        for(int i=0; i<l; i++){
            a -= c;
            b -= d;
            if(a<=0 && b<=0){
                l -= (i+1);
                break;
            }
        }
        
        bw.write(l+"");
            
        br.close();
        bw.close();
    }

}