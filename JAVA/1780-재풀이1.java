import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 재귀
 * 1. 함수 형태: paper(종이 정보가 담긴 배열, x,y, n/3)
 * 2. base Condition 특정 함수 조건을 만족시키는 경우 -> 그 줄의 좌표를 가져와서 해당 Map의 값을 증가시켜준다
 * -> 이떄 특정 함수 조건은 조어진 필드 범위 내에서 같은 숫자로만 이루어져 있는지 확인하는 함수이다.
 * 3. 재귀식 총 9개를 돌려준다.
 * paper(종이 정보가 담긴 배열, x,y, n/3)
 * paper(종이 정보가 담긴 배열, x+n/3,y, n/3)
 * paper(종이 정보가 담긴 배열, x+2*(n/3),y, n/3)
 * paper(종이 정보가 담긴 배열, x,y+n/3, n/3)
 * paper(종이 정보가 담긴 배열, x+n/3,y+n/3, n/3)
 * paper(종이 정보가 담긴 배열, x+2*(n/3),y+n/3, n/3)
 * paper(종이 정보가 담긴 배열, x,y+2*(n/3), n/3)
 * paper(종이 정보가 담긴 배열, x+n/3,y+2*(n/3), n/3)
 * paper(종이 정보가 담긴 배열, x+2*(n/3),y+2*(n/3), n/3)
 *
 *
 * - 문제 해결:
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */


public class Main {
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] field = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        map.put(-1,0);
        map.put(0,0);
        map.put(1,0);
        paper(field, 0,0, n);

        for (Integer i : map.values()){
            bw.write(i+"\n");
        }

        br.close();
        bw.close();
    }

    private static void paper(int[][] field, int x, int y, int size) {
        if(onlyOne(field, x,y,size)){
            map.put(field[y][x],map.get(field[y][x])+1);
            return;
        }

        int newSize = size / 3;
        paper(field,x,y, newSize);
        paper(field,x+ newSize,y, newSize);
        paper(field,x+(2* (newSize)),y, newSize);

        paper(field,x,y + newSize, newSize);
        paper(field,x+ newSize,y + newSize, newSize);
        paper(field,x+(2* (newSize)),y + newSize, newSize);

        paper(field,x,y+(2* (newSize)), newSize);
        paper(field,x+ newSize,y+(2* (newSize)), newSize);
        paper(field,x+(2* (newSize)),y+(2* (newSize)), newSize);

    }

    private static boolean onlyOne(int[][] field, int x, int y, int size) {
        int now = field[y][x];
        for (int i = y; i < y+size; i++) {
            for (int j = x; j < x+size; j++) {
                if(field[i][j] != now){
                    return false;
                }
            }
        }


        return true;
    }


}

