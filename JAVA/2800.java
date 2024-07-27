import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 괄호 문제는 거의 대부분 스택을 사용하면 된다.
 * 2. 이 문제에서는 괄호 쌍을 구한다음 조합으로 해당되는 경우를 모두 문자열로 출력해야한다
 * 3. 따라서 스택의 시작과 끝을 하나의 쌍으로 하는 괄호를 리스트에 보관하기로 결정하였다
 * 4. 문자열을 순회하면서 괄호의 시작을 발견하면 그 위치를 스택에 넣어주고 끝을 발견하면 pop해서 시작위치와 끝 위치를 리스트에 넣어준다
 * 5. 이제 조합을 이용하여 해결하면 되는데...
 *
 * 해결방법:
 * 1. 조합에 대해 아직 개념이 부족하여 힌트를 참고하였다. 추후 조합에 대해 학습할 계획이다
 * 2. 추가로 Set을 이용해 중복을 제거해야한다. 이 문제에서는 정렬도 해야하므로 HashSet을 이용하면 추가 정렬을 해야하고 TreeSet을 이용하면 알아서 정렬되기 때문에 필요 없으니 TreeSet으로 선언한다
 * 3. 비트마스킹으로도 풀 수 있는 문제라고 한다. 조합, HashSet vs TreeSet, 비트마스킹까지 모두 학습할 수 있는 좋은 문제이므로 이후 추가 학습을 통해 문제를 여러번 재풀이할 계획이다
 * 4. 이어서 조합을 위해 Set과 방문체크 배열을 하나 만들어준다. 깊이를 0부터 시작하고, 문자열도 인수로 넘겨준다
 * 5. 현재 깊이의 괄호를 포함하는 경우와 포함하지 않는 경우를 각각 재귀를 돌려주면 된다. 이때 방문 체크 배열을 이용하여 해당 재귀를 돌리도록 구현하였다
 * 6. 만약 depth가 괄호 리스트의 크기와 같아지면 방문 여부를 체크하여 방문하지 않았을 때, StringBuilder에 append한다
 * 7. 이때, 모든 괄호의 쌍이 포함되어 있을 수도 있으므로, 해당 경우를 제외하기 위해 boolean first라는 변수를 선언하여, 만약 방문한 경우가 한번이라도 존재하는 경우 true로 바꿔주고 이 경우에만 result에 넣어준다
 * 8. 이렇게 완성한 set의 값을 모두 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(2^|S|)
 * 공간복잡도: O(|S|)
 *
 */
class Bracket{
    int start;
    int end;

    public Bracket(int start, int end) {
        this.start = start;
        this.end = end;
    }
}


public class Main {
    static List<Bracket> brackets;
    static Set<String> result;
    static boolean[] chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Stack<Integer> stacks = new Stack<>();
        brackets = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stacks.add(i);
            }else if(s.charAt(i) == ')'){
                int start = stacks.pop();
                brackets.add(new Bracket(start, i));
            }
        }
        chk = new boolean[s.length()];
        result = new TreeSet<>();
        comb(0, s.toCharArray());

        for (String string : result) {
            bw.write(string+"\n");
        }


        br.close();
        bw.close();
    }

    private static void comb(int depth, char[] s) {
        if(depth == brackets.size()){
            boolean first = false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                if(!chk[i]){
                    sb.append(s[i]);
                }else{
                    first = true;
                }
            }
            if(first){
                result.add(sb.toString());
            }
            return;
        }

        comb(depth+1, s);
        Bracket bracket = brackets.get(depth);
        chk[bracket.start] = true;
        chk[bracket.end] = true;
        comb(depth+1, s);
        chk[bracket.start] = false;
        chk[bracket.end] = false;
    }
}

