package problem1;

/**
 * Design pattern：Singleton
 * Weakness: Adding lock may be resources consuming
 *           when several thread step by the "if".
 */
public class SingletonSecond {

    private SingletonSecond(){};

    private static SingletonSecond singleInstance = null;

    private static final Object lockObject = new Object();

    public static SingletonSecond createSingleInstance(){

        //Adding lock on the "new" in case of multithreading
        synchronized (lockObject){
            if(singleInstance == null){
                singleInstance = new SingletonSecond();
            }
        }
        return singleInstance;
    }
}
