import java.io.*;
import java.math.BigInteger;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민 및 풀이:
 * 1. 테스트 케이스를 입력받는다.
 * 2. 첫번째 줄에는 울음소리들이 들어오므로 String 배열에 넣어둔다
 * 3. 테스트 케이스동안 반복하는데, 입력은 what does the fox say?가 들어올떄까지 반복한다.
 * 4. 이어서 문자열을 받는데 goes라는 단어가 포함되어 있으면 해당 문자열을 split해서 String 배열로 받고 2번째 인덱스의 단어를 따로 저장한다.
 * 5. 해당 문자열이 울음소리에 있으면 그 인덱스는 빈칸으로 바꾼다.
 * 6. 완성한 문자열을 출력하면 정답이다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(T) -> 알기 힘들다... 
 * 공간복잡도: O(1) -> 최대 100
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] cry = br.readLine().split(" ");
            String input = "";
            while(!(input = br.readLine()).equals("what does the fox say?")){
                String[] tmp = input.split(" ");
                input = tmp[2];
                for (int j = 0; j < cry.length; j++) {
                    if(cry[j].equals(input)){
                        cry[j] = "";
                    }
                }
            }
            for (String s : cry) {
                if(!s.isEmpty()){
                    bw.write(s +" ");
                }
            }
        }


        br.close();
        bw.close();
    }

}

