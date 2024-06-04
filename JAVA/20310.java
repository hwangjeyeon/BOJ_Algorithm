

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 사전순으로 앞서려면 0이 최대한 앞으로 가게해야한다. 따라서 1을 앞에서부터 봐서 절반을 제거하고 뒤에서부터 0을 절반 제거해주면 된다
 * 2. 각각의 리스트를 만들고 제거될 위치를 담도록 하였다
 * 3. 이어서 각 위치가 1이나 0일때 해당 리스트에 현재 위치가 들어있는지 확인하고 들어있지 않으면 정답 StringBuilder에다가 넣는다
 * 4. 완성한 StringBuilder를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(s.length())
 * 공간복잡도: O(s.length())
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int one = 0;
        int zero = 0;
        List<Integer> listZero = new ArrayList<>();
        List<Integer> listOne = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                one++;
            }else{
                zero++;
            }
        }
        int count1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1' && one/2 > count1){
                count1++;
                listOne.add(i);
            }
        }
        int count2 = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '0' && zero/2 > count2){
                count2++;
                listZero.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                if(!listOne.contains(i)){
                    sb.append(s.charAt(i));
                }
            }else{
                if(!listZero.contains(i)){
                    sb.append(s.charAt(i));
                }
            }
        }

        bw.write(sb.toString()+"");

        br.close();
        bw.close();
    }
}

