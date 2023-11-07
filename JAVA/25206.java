import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * 그냥 if문으로 구분해서 답을 구하고, String.format을 이용하여, 출력한다
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        double answer = 0.0;
        double sum = 0.0;
        for(int i=0; i<20; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if("A+".equals(grade)){
                answer += credit * 4.5;
                sum += credit;
            }

            if("A0".equals(grade)){
                answer += credit * 4.0;
                sum += credit;
            }

            if("B+".equals(grade)){
                answer += credit * 3.5;
                sum += credit;
            }

            if("B0".equals(grade)){
                answer += credit * 3.0;
                sum += credit;
            }

            if("C+".equals(grade)){
                answer += credit * 2.5;
                sum += credit;
            }

            if("C0".equals(grade)){
                answer += credit * 2.0;
                sum += credit;
            }

            if("D+".equals(grade)){
                answer += credit * 1.5;
                sum += credit;
            }

            if("D0".equals(grade)){
                answer += credit;
                sum += credit;
            }

            if("F".equals(grade)){
                answer += credit * 0;
                sum += credit;
            }

            if("P".equals(grade)){
            }

        }

        bw.write(String.format("%.6f",answer/sum) + "");
        br.close();
        bw.close();
    }


}
