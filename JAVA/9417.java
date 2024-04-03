import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 이중포문과 GCD를 이용해서 모든 최대공약수를 구한다
 * 2. GCD(b, a%b) 공식을 이용하자 ->참고로 무조건 a가 더 커야한다.
 *
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(T*M*M)
 * 공간복잡도: O(M)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            while(st.hasMoreTokens()){
                list.add(Integer.parseInt(st.nextToken()));
            }
            int max = 0;
            for (int j = 0; j < list.size()-1; j++) {
                for (int k = j+1; k < list.size(); k++) {
                    int first = list.get(j);
                    int second = list.get(k);
                    int tmp;
                    if(first < second){
                        tmp = first;
                        first = second;
                        second = tmp;
                    }
                    int gcd;
                    while(second != 0){
                        gcd = first % second;
                        first = second;
                        second = gcd;
                    }
                    max = Math.max(max, first);
                }

            }
            bw.write(max+"\n");
        }

        br.close();
        bw.close();
    }
}

