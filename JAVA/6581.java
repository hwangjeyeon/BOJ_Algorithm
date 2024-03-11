import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 * 1. 입력 줄마다 정답 Stringbuild에 append 한다.
 * 2. 만약 현재 글자가 <이면 >가 나올 때까지 특수 문자 변수에 넣는다
 * 3. 2번이 br이면 StringBUilder에 "\n"을 append하고 현재 문자열 길이 변수를 0으로 바꾼다
 * 4. 2번이 hr이면 현재 문자열 길이가 0이면 -을 80개 넣어주고 아니면 "\n"을 더한 뒤 -을 80개 넣는다
 * => 너무 난잡한 풀이라 새 풀이를 찾았다.
 *
 * 문제 해결:
 * 1. 여러가지 문제가 발생했는데 한줄씩 띄어쓰기 단위로 잘라서 체크하니까 이전 문자 체크할 때 생기는 여러 문제가 발생하였고 모든 문자열을 입력받고 리스트에 넣은 뒤 비교하는 방법으로 바꾸었다
 * 2. StringBuilder.append의 repaet 기능을 이용하면 -을 쉽게 표현할 수 있다 -> sb.append("-".repeat(80));
 * 3. <br>과 <hr>은 그냥 구현하면 된다
 * 4. 이제 문자를 입력 받고 띄어쓰기 하는 부분에서 문제가 너무 많이 발생해서 힌트를 참고했다
 * 5. 생각보다 간단하게 해결할 수 있었다... 현재 입력 들어온 문자열 길이의 합인 count가 0이냐 아니냐로 따지는 것으로 빈칸을 더할지 말지를 정하면 됐다
 * 6. 80을 넘는지도 위 조건을 활용하고 count가 0이 아니면 무조건 빈칸을 넣고 현재 문자열을 넣는 방식이다
 * 7. 나는 현재 문자를 넣고 빈칸을 넣어서 문제가 발생했는데 먼저 빈칸을 넣고 문자열을 넣으면 체크해야하는 것은 count가 0이 아니냐 맞냐만 따지면 되니까 더 쉬운 구분이었다
 * 8. 이렇게 하면 모든 문제가 해결되고 정답을 출력하게 된다.
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
        String input = "";
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String last = "";
        List<String> list = new ArrayList<>();
        while ((input = br.readLine())!=null) {
            StringTokenizer st = new StringTokenizer(input, " \t\n");
            while (st.hasMoreTokens())
                list.add(st.nextToken());
        }
        for (String s : list) {
                if(s.equals("<br>")){
                    sb.append("\n");
                    count = 0;
                    continue;
                }
                if (s.equals("<hr>")){
                    if(count != 0){
                        sb.append("\n");
                    }
                    sb.append("-".repeat(80));
                    sb.append("\n");
                    count = 0;
                    continue;
                }
                if(count + s.length() + (count == 0 ? 0 : 1)>80){
                    count = 0;
                    sb.append("\n");
                }
                if(count != 0){
                    sb.append(" ");
                }
                sb.append(s);
                count += s.length() + (count == 0 ? 0 : 1);
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }


}
