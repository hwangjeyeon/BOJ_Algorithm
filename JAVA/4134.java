import java.io.*;
import java.math.BigInteger;
import java.util.*;


/**
 * 풀이 과정:
 * - BigInteger를 사용해서 풀었다.
 * - BigInteger의 nextProbablePrime()을 사용하면 다음 소수를 알 수 있다.
 * - 1과 0인 경우 정수 2를 출력한다
 * - 그리고 한가지 확인을 해줘야하는데 이 문제에서 크거나 같은 다음소수라고 했기 떄문에, 입력받은 수가 소수인지 판단해야한다
 * - 정수론, 소수판정 방법을 사용하여, 2부터 현재 수의 sqrt한 값과 같아질때까지 순회하여, 현재수를 j로 나눴을 때 나머지가 0인경우가 있으면 합성수로 판단한다
 * - 위 판단결과 소수인 경우에는 그 수를 출력하고 아닌 경우 앞서 말한 BigInteger의 nextProbablePrime()을 사용한다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long T = Long.parseLong(br.readLine());
        for(int i=0; i<T; i++) {
            String s = br.readLine();
            BigInteger bigInteger = new BigInteger(s);
            long chkNumber = Long.parseLong(s);
            boolean chk = true;
            long sqrtChkNumber = (long) Math.sqrt(chkNumber);
            for (int j = 2; j <= sqrtChkNumber; j++){
                if (chkNumber % j == 0) {
                    chk = false;
                    break;
                }
            }
            if(chkNumber == 1 || chkNumber == 0){
                bw.write(2+"\n");
            }else if(chk){
                bw.write(chkNumber + "\n");
            }else{
                bw.write(bigInteger.nextProbablePrime()+"\n");
            }

        }


        br.close();
        bw.close();
    }

}
