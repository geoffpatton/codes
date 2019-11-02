package problems;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SherlockAnagramsTest {

    private SherlockAnagrams target;

    @Before
    public void setUp() {
        target = new SherlockAnagrams();
    }

    @Test
    public void testSherlockAndAnagrams() {
        assertEquals(4, target.sherlockAndAnagrams("abba"));
        assertEquals(0, target.sherlockAndAnagrams("abcd"));
        assertEquals(3, target.sherlockAndAnagrams("ifailuhkqq"));
        assertEquals(10, target.sherlockAndAnagrams("kkkk"));
        assertEquals(5, target.sherlockAndAnagrams("cdcd"));
        assertEquals(399, target.sherlockAndAnagrams(
            "ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel"));
        assertEquals(370, target.sherlockAndAnagrams(
            "mqmtjwxaaaxklheghvqcyhaaegtlyntxmoluqlzvuzgkwhkkfpwarkckansgabfclzgnumdrojexnrdunivxqjzfbzsodycnsnmw"));

    }

}
