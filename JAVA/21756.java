import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 리스트에 수를 배정한 뒤, 그냥 list.size만큼 list의 i위치를 빼주면된다
 * 2. 알아서 홀수번째 수가 땡겨지면서 삭제되기 때문이다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }
        while(list.size() > 1){
            for (int i = 0; i < list.size(); i++) {
                list.remove(list.get(i));
            }
        }
        bw.write(list.get(0)+"");

        br.close();
        bw.close();
    }
}

