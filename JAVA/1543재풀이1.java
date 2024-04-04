import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 문자열은 변화시킬 수 없기 때문에, start라는 포인터 역할의 변수를 하나 선언해서 완전탐색하였다.
 * 2. 만약 찾으려는 것을 발견하면 그 발견한 크기 만큼 start에 더해서 탐색하고 발견하지 못하면 단순 start++로 다시 탐색하도록 한다.
 *
 * 문제 해결:
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

        String pivot = br.readLine();
        String find = br.readLine();
        int start = 0;
        int ans = 0;
        while(start < pivot.length()-find.length()+1){
            int tmp = 0;
            for (int i = 0; i < find.length(); i++) {
                if(pivot.charAt(i+start) == find.charAt(i)){
                    tmp++;
                }
            }

            if(tmp == find.length()){
                start += find.length();
                ans++;

            }else{
                start++;
            }
        }

        bw.write(ans+"");
        br.close();
        bw.close();
    }

}
