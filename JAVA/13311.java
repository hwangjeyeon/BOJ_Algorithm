import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 수학적사고로 푸는 문제다.
 * 2. =이 수학의 equal을 생각하면 된다. n = a-1 (mod a)는 n mod a가 a-1과 같다는 의미다
 * 3. n을 5으로 나눈 나머지도 4와 같다는 의미로, 이때 만족하는 n은 -1이다
 * 
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
        bw.write("-1");
        
        br.close();
        bw.close();
    }
}
