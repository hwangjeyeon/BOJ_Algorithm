import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 조건문에 맞는 문자 수를 세고 그에 맞게 출력하면 된다
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
        String s = br.readLine();
        int countB = 0;
        int countS = 0;
        int countA = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'B'){
                countB++;
            }else if(s.charAt(i) == 'S'){
                countS++;
            }else if(s.charAt(i) == 'A'){
                countA++;
            }
        }

        int max = Math.max(Math.max(countB,countS),countA);

        if(countB == countS && countS == countA){
            bw.write("SCU");
        }else if(countB == countS && max == countB){
            bw.write("BS");
        }else if(countB == countA && max == countB){
            bw.write("BA");
        }else if(countS == countA && max == countS){
            bw.write("SA");
        }else{
            if(max == countB){
                bw.write("B");
            }else if(max == countS){
                bw.write("S");
            }else if(max== countA){
                bw.write("A");
            }
        }



        br.close();
        bw.close();
    }

}
