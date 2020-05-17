package problem19;

public class RegularMatch {
    private boolean matchOrNot(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern, 0, 0);
    }

    private boolean matchCore(String str, String pattern, int index1, int index2) {
        if (str == null || pattern == null) {
            return false;
        }
        if (index1 >= str.length() || index2 >= pattern.length())
            if (index2 + 1 < pattern.length() && pattern.charAt(index2 + 1) == '*') {
                if (str.charAt(index1) == pattern.charAt(index2)
                        || pattern.charAt(index2) == '.') {
                    return matchCore(str, pattern, index1 + 1, index2 + 2)
                            || matchCore(str, pattern, index1 + 1, index2)
                            || matchCore(str, pattern, index1, index2 + 2);
                } else {
                    return matchCore(str, pattern, index1, index2 + 2);
                }
            }
        if (str.charAt(index1) == pattern.charAt(index2) || pattern.charAt(index2) == '.') {
            return matchCore(str, pattern, index1 + 1, index2 + 1);
        }
        return false;
    }
}
