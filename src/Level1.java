import java.util.*;

public class Level1 {
    public static String TheRabbitsFoot(String s, boolean encode) {
        String resStr = "";
        String str = s.replaceAll(" ", "");
        int N = str.length();
        double sqrt = Math.sqrt(N);
        double sqrtRound = Math.round(sqrt);
        int strMtrx = sqrt < sqrtRound ? (int) sqrtRound - 1 : (int) sqrtRound;
        int colMtrx = sqrt <= sqrtRound ? (int) sqrtRound : (int) sqrtRound + 1;
        while (N > (strMtrx * colMtrx)) strMtrx++;
        char[][] matrixStrs = new char[strMtrx][colMtrx];
        if (encode) {
            for (int i = 0, k = 0; i < strMtrx; i++) {
                for (int j = 0; j < colMtrx; j++) {
                    if (k < N) matrixStrs[i][j] = str.charAt(k);
                    else matrixStrs[i][j] = ' ';
                    k++;
                }
            }
            for (int i = 0; i < colMtrx; i++) {
                for (int j = 0; j < strMtrx; j++) {
                    if (matrixStrs[j][i] != ' ') resStr = resStr + matrixStrs[j][i];
                }
                if (i != colMtrx - 1) resStr = resStr + " ";
            }
        } else {
            boolean it = false;
            for (int i = 0, k = 0; i < colMtrx; i++) {
                for (int j = 0; j < strMtrx; j++) {
                    if (j == 0 && (N - k) == ((colMtrx - i) * (strMtrx - 1)) && !it) {
                        strMtrx--;
                        it = true;
                    }
                    if (k < N) matrixStrs[j][i] = str.charAt(k);
                    else matrixStrs[j][i] = ' ';
                    k++;
                }
            }
            if (it) strMtrx++;
            for (int i = 0; i < strMtrx; i++) {
                for (int j = 0; j < colMtrx; j++) {
                    if (matrixStrs[i][j] != ' ') resStr = resStr + matrixStrs[i][j];
                }
                if (i != strMtrx - 1) resStr = resStr + " ";
            }
        }
        return resStr;
    }
}