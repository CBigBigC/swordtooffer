package problem1;

/**
 * Design pattern：Singleton.
 * Advantage: Don't need lock.
 * Weakness: The instance will be created once the class is loaded,
 *           which may be a waste of space.
 */
public class SingletonFourth {

    private SingletonFourth(){};

    //Init the single instance with the of the class which will be loaded only once
    private static SingletonFourth singleInstance = new SingletonFourth();

    public static SingletonFourth createSingleInstance(){
        return singleInstance;
    }
}
