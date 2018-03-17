package demo;

import java.util.List;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        String[] array = {};
        String[] array2 = null;
        System.out.println(Objects.isNull(array));
        System.out.println(Objects.isNull(array2));

        String[] require = {};

    }

    private static boolean containsRole(List<String> processedRoles, String[] requireRoles) {
        boolean flag = false;
        for (String role : requireRoles) {
            if (processedRoles.contains(role)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}
