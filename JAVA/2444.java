import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 그냥 for문과 if문을 잘 쓰면 되는 문제
 *
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(1)
 *
 */




public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        int tmp = count;
        int tmp2 = 1;
        for(int i=0; i<2*count-1; i++){
            for(int j=0; j<tmp-1; j++){
                bw.write(" ");
            }
            if(i<count){
                tmp--;
                for(int j=1; j<=2*tmp2-1; j++){
                    bw.write("*");
                }
                tmp2++;
            }else{
                tmp++;
                tmp2--;
                for(int j=1; j<=2*tmp2-1; j++){
                    bw.write("*");
                }
            }

            if(tmp2 > count){
                tmp++;
                tmp++;
                tmp2--;
            }


            bw.write("\n");

        }




        br.close();
        bw.close();
    }

}
