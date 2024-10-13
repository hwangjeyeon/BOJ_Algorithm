import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 정규표현식을 사용하여 문자들을 모두 " "로 만든 뒤 split하면 쉽게 풀 수 있다
 * 2. ""인 경우가 존재할 수 있으므로 해당 경우는 continue하고 이외의 경우에 대해서 파싱해서 더해준다
 * 3. 완성한 결과를 출력하면 정답이 된다
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(|s|)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().replaceAll("[a-zA-Z]"," ").split(" ");
        long ans = 0;
        for (String a : s) {
            if(a.equals("")){
                continue;
            }
            ans += Integer.parseInt(a);
        }


        bw.write(ans+"");

        br.close();
        bw.close();
    }
}

