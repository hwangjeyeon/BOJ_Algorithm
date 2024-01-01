import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - map을 사용해서 푸는 문제이다. 입력받은 문자열이 ENTER면 map을 초기화해줘서, 문제를 진행 시킨다
 * - ENTER가 아니면 해당 문자열이 MAP에 있는지 확인하고 없으면 MAP에 넣은 뒤, count값을 증가시킨다
 * - 최종 완성된 count를 출력하면 정답이 된다.
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
        int count = 0;
        Map<String, Integer> chat = new HashMap<>();
        for(int i=0; i<n; i++){
            String s = br.readLine();
            if(s.equals("ENTER")){
                chat = new HashMap<>();
            }else{
                if(!chat.containsKey(s)){
                    chat.put(s, 1);
                    count += chat.get(s);
                }
            }
        }

        bw.write(count + "");

        br.close();
        bw.close();
    }
}
