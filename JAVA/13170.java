import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 수학적 사고가 필요한 문제다.
 * 2. w씩 때려보면 안전하게 체크할 수 있기 때문에 w 단위로 올려보는데 p가 최대 치니까 p/w로 생각했다
 * 3. 이어서 p%w가 0보다 크면 그 개수를 ans++하도록 했다
 * 4. 또한 순위를 고려해서 첫번째 강도가 아니라 그 뒤의 경우를 고려해서 p-k+1를 했는데 틀린 결과를 얻었다
 * 
 * 해결방법:
 * 1. 잘못 생각했다 일단 w단위로 칠때 정확하게 w인 경우 안전범위를 벗어나는줄 알았는데 w까지 포함이었다.
 * 2. 두번째는 순위 고려할 필요가 딱히 없어보인다. 문제를 읽어보면 안전 범위 내에서 해결이 된다
 * 3. 또한 p는 양의 실수이므로 double형으로 받아야 한다
 * 4. 그리고 p/w할때 올림을 해주어야 하므로 ceil을 사용하며 int형으로 형변환하여 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        double p = Double.parseDouble(st.nextToken());
        int w = Integer.parseInt(st.nextToken());


        bw.write((int)Math.ceil(p / w)+"");




        br.close();
        bw.close();
    }
}

