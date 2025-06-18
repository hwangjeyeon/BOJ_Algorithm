import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 간단한 조건문 출력 문제
 *
 * 해결방법:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(name.equals("#") && age == 0 && weight == 0){
                break;
            }
            bw.write(name+" ");
            if(age > 17 || weight >= 80){
                bw.write("Senior\n");
            }else{
                bw.write("Junior\n");
            }
        }
        
        br.close();
        bw.close();
    }

}
