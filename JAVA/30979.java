import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 전체 시간이 T보다 많거나 같은지 아니면 작은지에 따라 값을 다르게 출력하면 된다
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int candy = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> taste = new ArrayList<>();
        int totalMinutes = 0;
        for(int i=0; i<candy; i++){
            taste.add(Integer.parseInt(st.nextToken()));
            totalMinutes += taste.get(i);
        }

        if(totalMinutes >= T){
            bw.write("Padaeng_i Happy");
        }else{
            bw.write("Padaeng_i Cry");
        }




        br.close();
        bw.close();
    }

}
