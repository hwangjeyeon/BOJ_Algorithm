import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 간단한 구현 문제다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */


public class Main {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int headX = -1;
        int headY = -1;
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] a = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = a[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean isOk = true;
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(!isRange(ny,nx, n) || arr[ny][nx] == '_'){
                        isOk = false;
                        break;
                    }
                }
                if(isOk){
                    headX = i+1;
                    headY = j+1;
                }
            }
        }
        bw.write(headX + " " + headY+"\n");
        headX--;
        headY--;
        int leftArm = 0;
        int rightArm = 0;
        int waist = 0;
        int leftLeg = 0;
        int rightLeg = 0;
        for (int i = headY-1; i >= 0; i--) {
            if(arr[headX][i] == '*'){
                leftArm++;
            }else{
                break;
            }
        }

        for (int i = headY+1; i < n; i++) {
            if(arr[headX][i] == '*'){
                rightArm++;
            }else{
                break;
            }
        }
        int waistX = headX;
        int waistY = headY;
        for (int i = headX+1; i < n; i++) {
            if(arr[i][headY] == '*'){
                waist++;
                waistX++;
            }else{
                break;
            }
        }


        for (int i = waistX+1; i < n; i++) {
            if(arr[i][waistY-1] == '*'){
                leftLeg++;
            }else{
                break;
            }
        }

        for (int i = waistX+1; i < n; i++) {
            if(arr[i][waistY+1]== '*'){
                rightLeg++;
            }else{
                break;
            }
        }
        bw.write(leftArm + " " + rightArm + " " + waist  + " " + leftLeg + " " + rightLeg);
        
        br.close();
        bw.close();

    }

    private static boolean isRange(int ny, int nx, int n) {
        return ny >= 0 && ny < n && nx >= 0 && nx < n;
    }
}
