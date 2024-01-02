import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - Map을 활용해서 문자열을 키값으로 하고, 해당 키의 값이 1인 경우 그 다음으로 입력 받은 문자도 1로 바꾸는 방식으로 풀면 되는 문제다.
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
        StringTokenizer st;
        Map<String, Integer> dancer = new HashMap<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if(a.equals("ChongChong")){
                dancer.put(a,dancer.getOrDefault(a, 1));

            }else{
                dancer.put(a,dancer.getOrDefault(a, 0));
            }
            if(b.equals("ChongChong")){
                dancer.put(b,dancer.getOrDefault(b, 1));
            }else{
                dancer.put(b,dancer.getOrDefault(b, 0));
            }

            if(dancer.get(a) == 1){
                dancer.put(b,1);
            }
            if(dancer.get(b) == 1){
                dancer.put(a,1);
            }
        }
        int count = 0;
        for (Integer value : dancer.values()) {
            count += value;
        }

        bw.write(count + "");

        br.close();
        bw.close();
    }
}
