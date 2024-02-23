import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - map을 활용하려 했으나, 순서가 보장되지 않아서 LinkedHashSet을 활용하였다.
 * - 또한 Integer형으로는 정답이 되지 않아 String으로 받았고, 중복되는 값이 들어올 경우 해당 값을 지우고 다시 넣어주도록 하였다
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < l; i++) {
            String tmp = br.readLine();
            if(set.contains(tmp)){
                set.remove(tmp);
            }
            set.add(tmp);
        }
        int nowPos = 0;

        for (String i : set) {
            nowPos++;
            bw.write(i + "\n");
            if(nowPos == k){
                break;
            }
        }


        br.close();
        bw.close();
    }

}

