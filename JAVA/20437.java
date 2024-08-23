import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 문제를 어떻게 풀어야할까 고민하던 중, 일단 알파벳이라는 점과 개수를 세어서 k개에 도달하는 경우를 구해야한다는 것으로 힌트를 얻게 되었다
 * 2. 먼저 알파벳은 26크기의 배열로 선언해서 관리하고, 문자열에서 문자의 개수는 HashMap을 사용하여 관리하였다
 * 3. 메모리가 매우 크다는 점을 이용하여 우선순위 큐 배열을 사용하였다.
 * 4. 최솟값과 최댓값을 구하기 위한 준비를 하며, 문자열을 문자배열로 받아 탐색한다
 * 5. 만약 문자가 맵에 안 들어있다면 넣어주고, 우선순위 큐에도 현재 위치를 넣어준다
 * 6. 만약 들어있는 경우 기본적으로 맵의 개수 값을 늘려주며 우선순위 큐에도 현재 값을 넣어준다
 * 7. 맵의 개수가 k라면 현재 위치와 우선순위 큐에 있는 값의 차 + 1을 한 뒤, 맵에 있는 개수의 값을 줄여준다
 * 8. 이어서 최솟값과 최댓값을 위에서 그 거리간의 차를 구한 값을 이용하여 갱신해준다
 * 9. 최후에는 최댓값이 갱신되어있지 않다면 -1을 출력하고 아니라면 최솟값과 최댓값을 출력한다
 *
 * - 문제 해결:
 * 1. 2%에서 틀려서 반례를 찾아보니 k가 1일때는 무조건 최솟값과 최댓값이 1 1이 나온다.
 * 2. 따라서 k가 1일때는 1 1을 출력하도록 예외 처리를 해주었고, 정답이 되었다.
 *
 * 시간복잡도: O(T * |W|)
 * 공간복잡도: O(26 * |W|)
 *
 */


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            PriorityQueue<Integer>[] alpha = new PriorityQueue[26];
            for (int j = 0; j < 26; j++) {
                alpha[j] = new PriorityQueue<>();
            }
            int small = Integer.MAX_VALUE;
            int big = -1;
            char[] input = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < input.length; j++) {
                if(!map.containsKey(input[j])){
                    alpha[input[j] - 'a'].add(j);
                    map.put(input[j], 1);
                }else{
                    map.put(input[j], map.get(input[j])+1);
                    int num = map.get(input[j]);
                    alpha[input[j] - 'a'].add(j);
                    if(num == k){
                        int ans = j - alpha[input[j] - 'a'].poll()+1;
                        map.put(input[j], num-1);
                        small = Math.min(small, ans);
                        big = Math.max(big, ans);
                    }
                }
            }



            if(k == 1){
              bw.write("1 1\n");
            }else if(big == -1){
                bw.write("-1\n");
            }else{
                bw.write(small+ " " + big + "\n");
            }
        }
        br.close();
        bw.close();
    }
}

