import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 문자열 개수 파악하는 로직이랑 슬라이딩 윈도우 로직을 활용해서 푸는 문제다
 * 2. 이때, 슬라이딩 윈도우 x 전체 문자열하면 시간초과가 발생하므로 슬라이딩 윈도우 크기에 도달하면 앞에 요소를 빼면서 정답을 찾는 방식으로 해야한다
 * 3. 문자열을 순회하며 하나씩 그 빈도수를 세어준다
 * 4. 그다음 윈도우 크기를 증가시키고 비교 문자와 길이가 같은지 확인한다
 * 5. 같으면 두 문자 배열을 비교한다. 이때 Arrays.equals(배열1, 배열2)라이브러리를 쓰면 편한다. 두 배열이 같다면 ans를 증가시킨다
 * 6. 이어서 window크기를 줄이고 start 위치의 문자의 빈도를 하나 줄인다. 그리고 start를 증가시킨다 
 * 7. 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(g)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        String c = br.readLine();

        int[] wCount = new int[52];
        int[] gCount = new int[52];
        for (char c1 : s.toCharArray()) {
            if('a'<= c1 && c1 <= 'z'){
                wCount[c1-'a']++;
            }else{
                wCount[c1-'A'+26]++;
            }
        }


        int start = 0;
        int ans = 0;
        int window = 0;
        for (int i = 0; i < g; i++) {
            char d = c.charAt(i);
            if('a'<= d && d <= 'z'){
                gCount[d-'a']++;
            }else{
                gCount[d-'A'+26]++;
            }
            window++;
            if(window == w){
                if(Arrays.equals(wCount, gCount)){
                    ans++;
                }
                char q = c.charAt(start);
                if('a'<= q && q <= 'z'){
                    gCount[q-'a']--;
                }else{
                    gCount[q-'A'+26]--;
                }
                start++;
                window--;
            }

        }
        bw.write(ans+"");
        
        br.close();
        bw.close();
    }

}
