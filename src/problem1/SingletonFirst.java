package problem1;

/**
 * Design pattern：Singleton
 * Weakness: Lose effective when it come to multithreading
 */
public class SingletonFirst {

    private SingletonFirst(){};

    //Set the instance static to ensure single
    private static SingletonFirst singleInstance = null;

    public static SingletonFirst createSingleInstance(){

        //Create a instance only if the instance hasn't been initialed
        if(singleInstance == null){
            singleInstance = new SingletonFirst();
        }
        return singleInstance;
    }
}
