package problem10;

public class FrogMoveUp {
    public static int numberOfWay(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        return numberOfWay(n - 1) + numberOfWay(n - 2);
    }
}
