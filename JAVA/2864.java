import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 최대값인 경우 모든 5를 6으로 바꾸면 되고, 최소값인 경우 모든 6을 5로 바꾸면 된다.
 * - 이 조건에 맞춰서 변수와 반복문을 선언하고, 계산하여 결과를 출력하면 된다.
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        String maxA = "";
        String maxB = "";
        String minA = "";
        String minB = "";
        int max;
        int min;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) == '5'){
                maxA += "6";
                minA += "5";
            }else if(a.charAt(i) == '6'){
                maxA += "6";
                minA += "5";
            }else{
                maxA += a.charAt(i);
                minA += a.charAt(i);
            }
        }

        for(int i=0; i<b.length(); i++){
            if(b.charAt(i) == '5'){
                maxB += "6";
                minB += "5";
            }else if(b.charAt(i) == '6'){
                maxB += "6";
                minB += "5";
            }else{
                maxB += b.charAt(i);
                minB += b.charAt(i);
            }
        }

        max = Integer.parseInt(maxA) + Integer.parseInt(maxB);
        min = Integer.parseInt(minA) + Integer.parseInt(minB);

        bw.write(min + " " + max);

        br.close();
        bw.close();
    }

}
