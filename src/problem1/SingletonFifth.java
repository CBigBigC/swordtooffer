package problem1;

/**
 * Design pattern：Singleton
 * Weakness: Perfect
 */
public class SingletonFifth {

    private SingletonFifth() {
    }

    private static class SingletonPatternHolder {
        //Same with the static instance in SingletonFourth,
        //The diff is, this instance is hold until the call of "getInstance()"
        private static final SingletonFifth singletonPattern = new SingletonFifth();
    }

    public static SingletonFifth getInstance() {
        return SingletonPatternHolder.singletonPattern;
    }
}
