import java.io.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 숫자인 지점이 몇번째인지 찾아서 해결하는 아이디어 문제이다
 * 2. 문자열의 첫번째 문자를 확인한다면 이것이 문자인지 숫자인지 구분할 수 있다.
 * 3. 이를 이용하여 몇번째인지를 기록하고, 첫번째라면 그 숫자를 값으로 갖는 count에 +3, 두번째면 2 세번째면 1 그외에는 0으로 자기자신이 되게 한다
 * 4. 이렇게 구한다음 문제 조건에 맞춰서 정답 문자를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = new String[3];

        int dept = 0;
        int count = 0;
        for(int i=0; i<3; i++){
            s[i] = br.readLine();
            if(s[i].charAt(0) >= '0' && s[i].charAt(0) <= '9'){
                count = Integer.parseInt(s[i]);
                dept = i+1;
            }
        }

        if(dept == 1){
            count += 3;
        }else if(dept == 2){
            count +=2;
        }else if(dept == 3){
            count += 1;
        }else{
            count = 0;
        }

        if(count % 3 == 0){
            if(count %5 == 0){
                bw.write("FizzBuzz");
            }else{
                bw.write("Fizz");
            }
        }else{
            if(count % 5 == 0){
                bw.write("Buzz");
            }else{
                bw.write(count+"");
            }
        }


        br.close();
        bw.close();
    }
}

