import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 중간고사 이슈로 끝날 때까지 감을 잃지 않기 위한 가벼운 문제만 풀 예정
 * - 자바 Patterns, Matchers 클래스, 정규식 공부 예정 - > 문자열 공부 순차적으로 진행하면서 공부 예정
 * - 해결방법:
 * - 제일 처음 substring으로 해결하는 방식을 떠올렸다.
 * 1.입력받은 패턴을 "*"으로 split()해서 String[]에 넣어준다
 * 2. 각각을 s1, s2 스트링 변수에 넣어주고 비교할 word를 입력받는다
 * 3. 이 부분때문에 런타임 에러가 몇번 발생했는데, 입력 단어가 s1+s2의 길이보다 작을 수도 있다 이럴 때는 NE로 출력되도록 한다
 * 4. s1+s2보다 길거나 같으면 word의 시작부분부터 s1의 length()까지 substring해서 equals로 비교한다
 * 5. 만약 4번이 true이면  word.length()-s2.length()부터 끝까지 substring해서 equals로 비교하고 true면 DA를 출력한다
 * 6. 4,5번에서 false가 나오면 NE를 출력한다.
 * 
 * - 정규식으로 푸는 방법이 있는데 시간이 좀 걸릴 것 같아 추후 문자열 공부할 때 공부 후 해당 방식으로 풀어볼 예정
 * 
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split("[*]");
        String s1 = s[0];
        String s2 = s[1];

        for(int i=0; i<n; i++){
            String word = br.readLine();
            if(s1.length()+s2.length() <= word.length()){
                if(word.substring(0,s1.length()).equals(s1)){
                    if(word.substring(word.length()-s2.length()).equals(s2)){
                        bw.write("DA"+"\n");
                    }else{
                        bw.write("NE" + "\n");
                    }
                }else{
                    bw.write("NE" + "\n");
                }
            }else{
                bw.write("NE"+"\n");
            }


        }

        br.close();
        bw.close();
    }

}
