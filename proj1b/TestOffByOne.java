import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator c = new OffByOne();
    @Test
    public void test(){
        assertEquals(c.equalChars('a','b'),true);
        assertEquals(c.equalChars('r','q'),true);
        assertEquals(c.equalChars('&', '%'),true);
    }
//    @Test
//    assertFalse(offByOne.equals("a","b"),false);

    // Your tests go here.
} //Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/