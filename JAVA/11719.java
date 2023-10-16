import java.io.*;


/**
 * 풀이 과정:
 * - 중간고사 이슈로 끝날 때까지 감을 잃지 않기 위한 가벼운 문제만 풀 예정
 * while 조건에 s = br.readLin()을 넣어야 해결되는 신기한 문제였다.
 * 앞으로도 더 창의적이고 논리적인 해결책을 찾도록 연습하고, 자바와 관련된 라이브러리를 잘 활용하고 숙지해야겠다
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        while((s = br.readLine()) != null){
            bw.write(s+"\n");
        }


        br.close();
        bw.close();


    }

}
