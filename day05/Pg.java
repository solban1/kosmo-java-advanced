import java.util.Arrays;
import java.util.List;

public class Pg {
    public static void main(String[] args) {
        // System.out.println(List.of(1, 2, null)); // (X) NullPointerException
        System.out.println(Arrays.asList(1, 2, null)); // (O)
    }
}
