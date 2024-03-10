import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민 및 풀이:
 * 1. 문제를 처음에 잘못 이해해서 나온 숫자와 더해진 수를 모두 더한 값을 출력하는 줄 알아 잘못 풀어서 시간을 많이 소모했다
 * 2. 이 문제는 1번처럼 푸는게 아니라 마지막 2개의 문자를 출력하면 되는 문제다. 앞자리가 0이라도 출력하는 거라 추가로 해줄 요소도 없는 문제다
 * 3. StringBuilder에 입력으로 들어온 문자를 각각 한자리씩 번갈아 append해준다
 * 4. 26개의 획수를 다 if나 switch로 해야하나 걱정했는데, 이럴때는 배열을 사용하면 된다. 앞으로 문제 풀때 노가다는 배열을 사용하면 되니까 겁먹지 말자
 * 5. ans 리스트에 StringBuilder의 각 문자 자릿수를 'A'로 뺀 값을 인덱스로 하는 arr의 값을 넣어준다
 * 6. ans 리스트의 사이즈가 2보다 큰 동안 반복하는데 tmp 리스트에다가 ans.get(i) 와 ans.get(i+1) 값을 10으로 나눠줬을 때의 나머지 값을 넣어준다.
 * 7. ans를 clear해주고 다시 tmp의 값을 ans에 넣어준다. 
 * 8. 완성한 ans의 두 값을 count 문자열에 넣어주고 출력하면 정답이 된다.
 * 
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
        String me = br.readLine();
        String her = br.readLine();
        StringBuilder sb = new StringBuilder();
        int now = 0;
        for (int i = 0; i < me.length(); i++) {
            sb.append(me.charAt(i));
            sb.append(her.charAt(i));
            now++;
        }
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < sb.length(); i++) {
            ans.add(arr[sb.charAt(i) - 'A']);
        }
        while(ans.size() > 2){
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < ans.size()-1; i++) {
                tmp.add((ans.get(i) + ans.get(i+1))%10);
            }
            ans.clear();
            for (int i = 0; i < tmp.size(); i++) {
                ans.add(tmp.get(i));
            }
        }
        String count = String.valueOf(ans.get(0));
        count += String.valueOf(ans.get(1));
        bw.write(count);
        br.close();
        bw.close();
    }

}

