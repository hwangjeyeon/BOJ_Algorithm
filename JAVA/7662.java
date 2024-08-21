import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 우선순위 큐와 Map을 활용해서 풀 수도 있는 문제인데, 더 쉬운 방법으로 문제를 해결하였다
 * 2. TreeMap을 이용하면 문제를 쉽게 해결할 수 있다
 * 3. 일단 주의할점이 한가지 있다 다형성을 이용한 Map을 사용하면 그 내부함수를 사용할 수 없다
 * 4. 따라서 Map으로 선언하지 말고 타입을 TreeMap으로 선언해주어야 한다
 * 5. 문제에 주어진대로 I일 경우 map에 넣어준다.
 * 6. D일 경우 map이 비어있으면 continue 해준다
 * 7. 비어있지 않으면 1인지 -1인지 구분해준다. 1이면 lastKey() 최댓값을 지워주고, -1이면 firstKey() 최솟값을 지워주어야 한다
 * 8. 한가지 주의할 점이 key를 지워버리면 똑같은 수가 2개 이상 들어있는 경우 한개만 지우는게 아니라 다 지워버린다
 * 9. 따라서 if문에서 put으로 값을 1 갑소하여 갱신하는데, 그 리턴 값이 1인 경우에만 키를 지워준다. 참고로 map의 put은 이전 값을 리턴해준다
 * 10. map이 비어있으면 EMPTY를 출력하고 아니면 최댓값 lastKey()와 최솟값 firstKey()를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(T * n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char s = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());
                if(s == 'I'){
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }else{
                    if(map.isEmpty()){
                        continue;
                    }

                    if(num == 1){
                        if(map.put(map.lastKey(), map.get(map.lastKey())-1) == 1){
                            map.remove(map.lastKey());
                        }
                    }else{
                        if(map.put(map.firstKey(), map.get(map.firstKey())-1) == 1){
                            map.remove(map.firstKey());
                        }
                    }
                }
            }
            if(map.isEmpty()){
                bw.write("EMPTY\n");
            }else{
                bw.write(map.lastKey() + " " + map.firstKey()+"\n");
            }
        }


        br.close();
        bw.close();
    }
}

