import java.io.*;


/**
 * 풀이 과정: charAt 사용법 연습 문제, indexOf, lastIndexOf 쓰려고 했으나, 적합하지 않아 charAt만 사용해서 풀었습니다
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String s = br.readLine();
            int tmp = s.length()-1;
            bw.write(s.charAt(0)+""+ s.charAt(tmp) +"\n");
        }

        br.close();
        bw.close();
    }

}
