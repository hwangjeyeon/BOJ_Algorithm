import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 주어진 대로 구현하면 되는데 잘 구현해야 한다..
 * 2. 순서대로 잘 구현하고 문자열 라이브러리를 바싹 익혀서 잘 활용해야 한다
 * 3. 다음 순서대로 진행하면 된다. 먼저 split 빈칸으로 단어를 추합한다
 * 4. 각 단어별로 첫번째 단어를 확인한다. Set에 있는지 확인하고 없다면 넣어주고 StringBuilder에 넣어준다
 * 5. 이후 단어들은 전부 그냥 StringBuilder에 넣는다
 * 6. 참고로 검사할 때랑 넣을 때는 소문자로 바꿔서 진행하고 출력할때만 그대로 한다
 * 7. 발견했다면 trim()을 사용해서 출력하고 아니라면 StringBuilder를 초기화하고 다시 탐색한다
 * 8. 이번에도 순회를 똑같이 하는데 각 단어의 알파벳 살펴본다. 똑같이 검증하고 이번에는 []만 잘 처리해서 단어만 넣어준다
 * 9. 두번째 탐색에서는 단어 하나씩 넣어주는 순회를 진행해주고 이후 trim()해서 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n * |s.length| * |word.length|)
 * 공간복잡도: O(|s.length|)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Set<Character> alpha = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            StringBuilder sb = new StringBuilder();

            boolean isFind = false;
            for (String word : s) {

                if(!isFind && !alpha.contains(word.toLowerCase().charAt(0))){
                    alpha.add(word.toLowerCase().charAt(0));
                    sb.append("[" + word.charAt(0) + "]" + word.substring(1) +" ");
                    isFind = true;
                }else{
                    sb.append(word + " ");
                }
            }

            if(isFind){
                bw.write(sb.toString().trim()+"\n");
            }else{
                sb = new StringBuilder();
                isFind = false;
                for (String word : s) {
                    for (int j = 0; j < word.length(); j++) {
                        if(!isFind && !alpha.contains(word.toLowerCase().charAt(j))){
                            alpha.add(word.toLowerCase().charAt(j));
                            sb.append("[" + word.charAt(j) + "]");
                            isFind = true;
                        }else{
                            sb.append(word.charAt(j));
                        }
                    }
                    sb.append(" ");
                }
                bw.write(sb.toString().trim()+"\n");
            }

        }




        br.close();
        bw.close();
    }
}

