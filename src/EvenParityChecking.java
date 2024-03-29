import java.util.Scanner;

public class EvenParityChecking {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        char[] line = kb.nextLine().toCharArray();

        int[][] table = new int[4][];
        // table
        for(int i = 0; i < 4; i ++){
           table[i] = new int[8];
        }
        // table filled
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 8; j ++){
                table[i][j] = charToInt(line[j + 8 * i]);
            }
        }
        // look for row of error
        int row = checkOddRow(table) + 1;
        int col = checkOddCol(table) + 1;
        System.out.println("R"+row+"C"+col);
    }

    static int checkOddRow(int[][] a){
        for (int i = 0; i < 3; i ++){
            int sum = 0;
            for(int j = 0; j < 8; j ++) {
                sum += a[i][j];
            }
            if (sum % 2 == 1){
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    static int checkOddCol(int[][] a){
        for (int i = 0; i < 7; i ++){
            int sum = 0;
            for(int j = 0; j < 4; j ++) {
                sum += a[j][i];
            }
            if (sum % 2 == 1){
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    static int charToInt(char c)
    {
        return ((int) c) - 48;
    }
}
