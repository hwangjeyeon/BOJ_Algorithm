import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 중간고사 이슈로 끝날 때까지 감을 잃지 않기 위한 가벼운 문제만 풀 예정
 * - StringBuilder 공부
 * - 해결방법:
 * 1. 문자 -> 8진수 -> 10진수 -> 2진수 = 수의 길이가 333,334를 넘는 문제가 발생
 * 2. 문자로 8진수를 입력 받고 각 자릿수를 보면서 이진수로 바로 바꿔준다 어차피 입력값 범위가 0~7이므로 경우의 수가 많지 않음
 * -> 문자열 길이 만큼 탐색하는 반복문에서 각 자리의 문자를 가져와서 숫자로 저장
 * -> 4~7이면 맨앞자리 1, 4만큼 저장한 변수에서 빼줌, 2~3이면 두번째 자리수 1, 2만큼 저장한 변수에서 빼줌, 1이면 세번째 자리수 1, 0이면 세번쨰 자리수 0
 * -> 이 과정을 반복해서 StringBuilder로 이어준다
 * -> 또한 앞에 0이 붙는 경우 제거하기 위해 원래 8진수의 맨앞 자리가 2~3인경우 0을 한개 지워주고, 1~2인경우 0을 두개 지워준다
 * -> 최종 값을 출력한다
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n) -> StringBuilder떄문
 *
 * 기타사항: String, StringBuilder, StringBuffer에 대해서 깊게 공부할 필요를 느낌. 중간고사 종료 후, DP 이차원 배열 문제와 함께 학습할 예정
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            int n = s.charAt(i) - '0';
            if(n >= 4){
                n -= 4;
                sb.append(1);
            }else{
                sb.append(0);
            }
            if(n>=2){
                n-=2;
                sb.append(1);
            }else{
               sb.append(0);
            }
            if(n==1){
                sb.append(1);
            }else{
                sb.append(0);
            }
        }


            if(s.charAt(0) == '1' || s.charAt(0)== '0') {
                sb.delete(0, 2);
            }else if(s.charAt(0) == '2' || s.charAt(0) == '3'){
                sb.deleteCharAt(0);
            }


        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}
