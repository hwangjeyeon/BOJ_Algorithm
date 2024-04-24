import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 범위가 너무 적어서 완전탐색으로 풀면 되는 문제다.
 * 2. 이때 특정 학교의 남학생이나 여학생 하나를 잡고 0부터 해당 숫자만큼 늘려가면서 그 변화를 관찰해서 푸는 문제다
 * 3. 여기서는 A학교의 남학생 수를 0부터 그 수만큼 조절하는 방식으로 그림을 그렸을 때, 연쇄되는 변화를 결과 배열에 넣고 모두 0이상인지 체크한뒤 1을 출력해서 해당 값을 출력하는 방법을 선택하였다
 * 4. 그림과 그 규칙을 구하지 않고 단순히 학교별 남학생을 기준으로 여학생과 비교해서 빼주는 연산을 하면 틀리는 문제라 재풀이 할 때 그려보고 규칙을 찾아내자
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

class school{

    int boy;
    int girl;

    public school(int boy, int girl) {
        this.boy = boy;
        this.girl = girl;
    }
}


public class Main {

    static school[] student = new school[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int boy = Integer.parseInt(st.nextToken());
            int girl = Integer.parseInt(st.nextToken());
            student[i] =  new school(boy, girl);
        }
        boolean isFind = false;
        for (int i = 0; i < student[0].boy; i++) {
            int[][] arr = new int[3][2];
            //a - b
            arr[0][0] = i;
            // a - c
            arr[0][1] = student[0].boy - i;
            // b - c
            arr[1][1] = student[2].girl - arr[0][1];
            // b - a
            arr[1][0] = student[1].boy - arr[1][1];
            // c - a
            arr[2][0] = student[0].girl - arr[1][0];
            //c - b
            arr[2][1] = student[2].boy - arr[2][0];
            boolean isOk = true;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2; k++) {
                    if(arr[j][k] < 0){
                        isOk = false;
                    }
                }
            }

            if(isOk){
                bw.write("1\n");
                bw.write(arr[0][0] + " " + arr[0][1] + "\n");
                bw.write(arr[1][0] + " " + arr[1][1] + "\n");
                bw.write(arr[2][0] + " " + arr[2][1]);
                isFind = true;
                break;
            }

        }

        if(!isFind){
            bw.write("0");
        }

        br.close();
        bw.close();
    }
}

