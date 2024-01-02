import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 재귀함수로 팩토리얼을 구현하여 출력하는 문제다. 
 * - 최대 입력값이 20이므로 long 타입형으로 해야한다.
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

        bw.write(recursive(n)+"");

        br.close();
        bw.close();
    }

    static long recursive(int n){
        if(n <=0){
            return 1;
        }

        return n*recursive(n-1);
    }

}
