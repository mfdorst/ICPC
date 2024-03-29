import java.util.Arrays;
import java.util.Scanner;

public class FileRequest {
    public static void main(String[] args) {
        int[][] owners = new int[3][];
        for (int i = 0; i < 3; i++)
        {
            owners[i] = new int[4];
        }

        Scanner s = new Scanner(System.in);

        char[] line = s.nextLine().toCharArray();
        // Ignore 'A'
        {
            int owner = 0;
            for (int i = 1; i < line.length;)
            {
                while (i < line.length && isNum(line[i]))
                {
                    int resource = charToInt(line[i]);
                    owners[owner][resource - 1] = 1;
                    i++;
                }
                owner++;
                i++;
            }
        }

        // Count how many of chunk 1 A has
        int[] chunkCounts = new int[4];
        for (int i = 0; i < 4; i++)
        {
            chunkCounts[i] = owners[0][i] + owners[1][i] + owners[2][i];
        }

        for (int chunk = 0; chunk < 4; chunk++)
        {
            int rarestChunk = indexOfMin(chunkCounts);
            System.out.print(rarestChunk + 1);
            chunkCounts[rarestChunk] += 4;
            for (int owner = 0; owner < 3; owner++)
            {
                if (owners[owner][rarestChunk] == 1)
                {
                    System.out.print(getPeerName(owner));
                    break;
                }
            }
        }
    }

    static int charToInt(char c)
    {
        return ((int) c) - 48;
    }

    static boolean isNum(char b)
    {
        return b >= '0' && b <= '9';
    }

    static int indexOfMin(int[] a)
    {
        int minIndex = 0;
        for (int i = 1; i < a.length; i++)
        {
            if (a[i] < a[minIndex]) minIndex = i;
        }
        return minIndex;
    }

    static char getPeerName(int peerNum)
    {
        switch (peerNum) {
            case 0: return 'A';
            case 1: return 'B';
            case 2: return 'C';
        }
        throw new IllegalArgumentException();
    }
}
