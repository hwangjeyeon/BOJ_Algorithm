import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 *
 * 문제 해결:
 * 1. 단순히 contains로는 못푼다. 중복 단어도 있기 때문이다. 
 * 2. 알파벳이기에 char형으로 접근하는 것이 좋아보인다.
 * 3. 첫번째 문자열의 각 문자의 알파벳을 알파벳 배열에 개수만큼 증가시켜놓는다
 * 4. 이제 입력받는 문자열들을 비교한다. 해당 문자의 알파뱃 배열의 값이 0이상이면 same을 증가시키고 해당 배열의 값을 감소시킨다
 * 5. 이제 3가지 경우를 비교해야한다. 그중 먼저 입력 문자열이 기준 문자열보다 작을 때면 same이 입력 문자과 같아야한다. 그때 ans를 증가시킨다
 * 6. 만약 두 문자열이 같은 경우 same이 기준문자열보다 작거나 같은 경우 증가시킨다
 * 7. 만약 입력문자열의 길이가 1만큼 크면 same이 기준 문자열과 같은 경우 ans를 증가시킨다
 * 8. 완성한 ans를 출력한다.
 *
 *
 * 시간복잡도: O(nm)
 * 공간복잡도: O(1)
 *
 *
 */
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String pivot = br.readLine();
        int[] alpha = new int[26];
        for (int i = 0; i < pivot.length(); i++) {
            alpha[pivot.charAt(i) - 'A']++;
        }


        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            String now = br.readLine();
            int[] tmp = alpha.clone();
            int same = 0;
            for (int j = 0; j < now.length(); j++) {
                if(tmp[now.charAt(j) - 'A']> 0){
                    same++;
                    tmp[now.charAt(j) - 'A']--;
                }
            }

            if(now.length() == pivot.length()-1 && same == now.length()){
                ans++;
            }else if(now.length() == pivot.length()){
                if(same == pivot.length()-1 || same == pivot.length()){
                    ans++;
                }
            }else if(now.length() == pivot.length()+1){
                if(same == pivot.length()){
                    ans++;
                }
            }

        }

        bw.write(ans+"");
        br.close();
        bw.close();
    }

}
