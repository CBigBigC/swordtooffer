package problem1;

/**
 * Design pattern：Singleton
 * Weakness: Perfect
 */
public class SingletonThird {

    private SingletonThird(){};

    private static SingletonThird singleInstance = null;

    private static final Object lockObject = new Object();

    public static SingletonThird createSingleInstance(){

        //Only the first time to initiate a instance need a lock
        if(singleInstance == null){
            synchronized (lockObject){
                if(singleInstance == null){
                    singleInstance = new SingletonThird();
                }
            }
        }
        return singleInstance;
    }
}
