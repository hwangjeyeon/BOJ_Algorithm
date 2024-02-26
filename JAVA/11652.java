import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 처음 생각은 정렬 후, 투포인터를 생각했으나 너무 쉽게 불가능하다는 것을 깨닫게 되었다.
 * - 이어서 생각한 것은 숫자들을 key로 하고 그 개수를 value로 하는 map을 활용하는 것이었다.
 * - 이를 활용하기 위해서는 두가지 변수가 필요하다. value의 크기를 비교할 값과 정답으로 출력할 key를 담을 변수이다.
 * - 엔트리 셋으로 모든 map의 엔트리를 순회하며, 가져온 값이 크다면 해당 값으로 tmp 변수를 바꾸고 ans에 key를 담는다
 * - 한가지 더 신경써야하는데, 값이 같다면 두 키값중 더 작은 값을 ans에 넣어줘야 한다. 
 * - 이렇게 완성한 ans를 출력하면 정답이 된다.
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
        long[] arr = new long[n];
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long tmp = Long.parseLong(br.readLine());
            map.put(tmp, map.getOrDefault(tmp,0)+1);
        }

        long ans = Long.MAX_VALUE;
        long tmp = 0;
        for(Map.Entry<Long, Integer> i : map.entrySet()){
            if(i.getValue() > tmp){
                tmp = i.getValue();
                ans = i.getKey();
            }else if(i.getValue() == tmp){
                ans = Math.min(ans, i.getKey());
            }
        }



        bw.write(ans+"");

        br.close();
        bw.close();
    }

}

