import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 현재 너무 바빠서 공부 못하는중... 학술제까지는 단계별 해결 문제만 푸는걸로...
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * 너무 쉬운 문제라 생략
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> homework = new ArrayList<Integer>();
        for(int i=0; i<28; i++){
            homework.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(homework);

        int count = 0;
        for(int i=1; i<=30; i++){
            if(!homework.contains(i) && count < 2){
                bw.write(i + "\n");
                count++;
            }
        }

        br.close();
        bw.close();
    }

}
