import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 문제는 주어진대로 그냥 구현하면 되는 문제이다..
 * - 하지만 람다식을 이용한 구현에 약했고, 힌트를 참고해서 구현하였다.
 * - compareToIgnoreCase vs compareTo의 차이는 compareTo는 아스키 코드의 값을 기준으로 -> 즉 사전 순으로 비교하여 정렬한다는 것이다
 * - 하지만 compareToIgnoreCase는 compareTo에서 대소문자를 구분하지 않고 정렬한다는 조건이 붙는다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] serial = new String[n];
        for (int i = 0; i < n; i++) {
            serial[i] = br.readLine();
        }

        Arrays.sort(serial, (o1, o2) -> {
            if(o1.length() != o2.length()){
                return o1.length() - o2.length();
            }else{
                int a = 0;
                int b = 0;
                for (int i = 0; i < o1.length(); i++) {
                    int tmp1 = o1.charAt(i) - '0';
                    int tmp2 = o2.charAt(i) - '0';
                    if(tmp1 >=0 && tmp1 < 10){
                        a += tmp1;
                    }
                    if(tmp2 >=0 && tmp2 < 10){
                        b += tmp2;
                    }
                }
                if(a==b){
                   return o1.compareToIgnoreCase(o2);
                }else{
                    return a - b;
                }
            }
        });

        for (String s : serial) {
            bw.write(s+"\n");
        }

        br.close();
        bw.close();
    }

}

