import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        if (doStuff())
            System.out.println("valid");
        else
            System.out.println("invalid");
    }

    static boolean doStuff()
    {
        Scanner kb = new Scanner(System.in);
        String pass = kb.nextLine();

        boolean hasLower = false;
        boolean hasUpperOrSpecial = false;
        boolean hasNum = false;
        if (pass.length() < 6 || pass.length() > 15) return false;

        for (Character c : pass.toCharArray())
        {
            if (c >= 'a' && c <= 'z') hasLower = true;
            if ((c >= 'A' && c <= 'Z') || c == '@' || c == '#' || c == '$') hasUpperOrSpecial = true;
            if (c >= '0' && c <= '9') hasNum = true;
        }
        return hasNum && hasLower && hasUpperOrSpecial;
    }
}
