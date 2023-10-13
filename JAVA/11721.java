import java.io.*;


/**
 * 풀이 과정:
 * - 중간고사 이슈로 끝날 때까지 감을 잃지 않기 위한 가벼운 문제만 풀 예정
 * - substring에 대해 배우게 되었다. 앞으로 활용할 일이 많아 이번 기회에 확실하게 배우고 갈 예정
 * substring(int index) -> index 이후의 값을 출력한다
 * substring(int beginindex, int endindex) -> beginindex부터 endindex 전까지의 값을 출력한다
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
        String s = br.readLine();
        br.close();
        for(int i=0; i<s.length(); i+=10){
            if(s.length()-i > 10){
                bw.write(s.substring(i, i+10)+"\n");
            }else{
                bw.write(s.substring(i));
            }
        }
        bw.close();
    }

}
