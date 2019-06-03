import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static CharacterComparator c = new OffByN(3);
    @Test
    public void test(){
        assertEquals(c.equalChars('a','b'),false);
        assertEquals(c.equalChars('t','q'),true);

    }
}
