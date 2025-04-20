import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. TreeMap을 잘 활용하면 쉽게 풀 수 있는 문제다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(T*n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                break;
            }
            Map<Double, List<String>> map = new TreeMap<>(Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                StringTokenizer st= new StringTokenizer(br.readLine());
                String name = st.nextToken();
                double height = Double.parseDouble(st.nextToken());
                map.putIfAbsent(height, new ArrayList<>());
                List<String> tmp = map.get(height);
                tmp.add(name);
                map.put(height, tmp);
            }
            for (Map.Entry<Double, List<String>> doubleListEntry : map.entrySet()) {
                for (String s : doubleListEntry.getValue()) {
                    bw.write(s+" ");
                }
                bw.write("\n");
                break;
            }
        }


        br.close();
        bw.close();

    }
}
