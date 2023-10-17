import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 중간고사 이슈로 끝날 때까지 감을 잃지 않기 위한 가벼운 문제만 풀 예정
 *
 * - 해결방법:
 * -> 먼저 객체안의 내용이 같은지를 비교할 떄는 ==보다 equals로 하자.
 * -> 문자열끼리 누가 더 사전 순으로 앞서는지 확인하려면 compareTo를 사용하자
 * -> a.compareTo(b)
 * -> 반환값이 음수면 a가 더 큼
 * -> 반환값이 0이면 두 수 같음
 * -> 반환갑싱 양수면 b가 더 큼
 *
 * - String을 키로, Integer를 값으로 같는 Map을 생성해서 풀었다.
 * 1. 만약 해당하는 키가 없으면 해당 문자를 키로, 값을 1로 설정
 * 2. 만약 해당하는 키가 있으면 해당 값을 증가시켜서 저장
 * 3. max변수를 활용하여 더 큰값이 있으면 해당 값을 max 변수에 넣어주고 현재 입력한 문자열 s를 정답 변수에 저장
 * 4. 만약 max변수와 해당 키의 값이 같으면 정답 변수인 ans와 현재 입력 문자인 s를 compareTo로 비교해서 s가 더 크면 ans에 s를 저장
 * 5. 최종 결과 출력
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n) -> map때문에 최악의 경우 모든 키값이 다르면 n개 있을 수 있음
 *
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        String ans ="";
        for(int i=0; i<n; i++){
            String s = br.readLine();
            if(map.get(s) == null){
                map.put(s, 1);
            }else{
                Integer count = map.get(s);
                count++;
                map.put(s,count);
            }

            if(max < map.get(s)){
                max = map.get(s);
                ans = s;
            }else if(max == map.get(s)){
                if(ans.compareTo(s) > 0){
                    ans = s;
                }
            }

        }

        bw.write(ans);

        br.close();
        bw.close();
    }

}
