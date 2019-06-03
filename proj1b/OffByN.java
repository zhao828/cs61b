public class OffByN implements CharacterComparator {
    private int N;
    public OffByN(int n){
        N = n;

    }
    public boolean equalChars(char x, char y){
        if(Math.abs((int)x-(int)y)==N){
            return true;
        }
        else{
            return false;
        }
    }
}
