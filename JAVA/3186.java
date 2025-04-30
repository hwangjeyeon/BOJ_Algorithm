import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 분기조건을 잘 주면 쉽게 풀 수 있는 문제다
 * 2. 1이 연속으로 k초 이상되면 그 이후 플러시 전까지는 유지되나 그 이전에 0이 나오면 해제된다
 * 3. 만약 count가 k이상일 때, 0이되면 num을 초기화한다. 
 * 4. 다시, 0이면서 k보다 count가 크거나 같으면 num을 증가시킨다
 * 5. 만약 이때 num도 l이상이면 ans에 넣어준다
 * 6. 만약 ans가 비어있으면 NIKAD를 출력하고 아니면 ans의 값을 하나씩 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    static final String NOT_FLUSH = "NIKAD";
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        int count = 0;
        int num = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(arr[i] == '1' && count >= k){
                num = 0;
                continue;
            }
            if(arr[i] == '1'){
                count++;
                continue;
            }
            if(arr[i] == '0'&& count < k){
                count = 0;
                continue;
            }


            if(arr[i] == '0' && count >= k){
                num++;

                if(num >= l){
                    ans.add((i+1));
                    num = 0;
                    count = 0;
                }
                continue;
            }

        }
        if(count >= k){
            ans.add(n + l);
        }

        if(ans.isEmpty()){
            bw.write(NOT_FLUSH);
        }else{
            for (Integer an : ans) {
                bw.write(an+"\n");
            }
        }

        br.close();
        bw.close();

    }
}
