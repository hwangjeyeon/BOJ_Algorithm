import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 함수식은 파라미터를 문장의 크기인 n과 _을 세어줄 count로 설정한다
 * -> findZ(int n, int count)
 * 2. base Condition은 n==0일때이다. 이때 출력해야하는 문장을 StringBuilder에 넣는다
 * 3. 재귀식은 다음과 같다. findZ(n-1, count+4)
 * 4. 재귀식 종료 후에 나오는 문장도 하나 추가해줘야 한다.
 * - 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        chatbot(n, 0);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void chatbot(int n, int count){
        if(n == 0){
            sb.append("_".repeat(count))
                    .append("\"재귀함수가 뭔가요?\"\n")
                    .append("_".repeat(count))
                    .append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n")
                    .append("_".repeat(count))
                    .append("라고 답변하였지.\n");
            return;
        }

        sb.append("_".repeat(count))
                .append("\"재귀함수가 뭔가요?\"\n")
                .append("_".repeat(count))
                .append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n")
                .append("_".repeat(count))
                .append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n")
                .append("_".repeat(count))
                .append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

        chatbot(n-1, count+4);
        sb.append("_".repeat(count))
                .append("라고 답변하였지.\n");
    }



}

