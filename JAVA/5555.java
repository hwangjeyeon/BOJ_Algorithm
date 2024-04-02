import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 덱을 쓸까 고민하다가 그냥 문자열을 그대로 뒤에 붙여주는 방법을 선택했다
 * 2. 이렇게 하면 애매하게 끊겨서 앞이나 뒤를 살펴봐야하는 경우, 추가적인 순회없이 간단하게 해결할 수 있다
 * 3. contains를 통해 ring이 있는 경우 count를 해주고 완성된 결과를 출력하면 정답이다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String ring = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            input += input;
            if(input.contains(ring)){
                count++;
            }
        }
        bw.write(count+"");
        br.close();
        bw.close();
    }
}

