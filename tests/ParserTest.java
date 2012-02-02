package tests;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import model.Parser;
import model.ParserException;
import model.RGBColor;
import static org.junit.Assert.*;
import org.junit.*;


public class ParserTest
{
    // useful constants
    private static final RGBColor BLACK = new RGBColor(Color.BLACK);
    private static final RGBColor GRAY = new RGBColor(0.5);
    private static final RGBColor WHITE = new RGBColor(Color.WHITE);
    
    private Parser myParser = new Parser();
    private Map<String,RGBColor> myVarMap = new HashMap<String,RGBColor>();

    @Before
    public void setUp ()
    {
        // initialize stuff here
    }


    @Test
    public void testConstant ()
    {
        RGBColor actual = myParser.makeAbstractExpression("1").evaluate(myVarMap);
        assertTrue(WHITE.equals(actual));
        actual = myParser.makeAbstractExpression("-1").evaluate(myVarMap);
        assertTrue(BLACK.equals(actual));
        actual = myParser.makeAbstractExpression("0.5").evaluate(myVarMap);
        assertTrue(GRAY.equals(actual));
        actual = myParser.makeAbstractExpression(".5").evaluate(myVarMap);
        assertTrue(GRAY.equals(actual));
        try
        {
            myParser.makeAbstractExpression("0.5 0.5").evaluate(myVarMap);
            fail("Exception should have been thrown");
        }
        catch (ParserException e)
        {
            // actually that's good
            assertEquals(ParserException.Type.EXTRA_CHARACTERS, e.getType());
        }
        assertTrue(GRAY.equals(actual));
    }


    @Test
    public void testBinaryOps ()
    {
        RGBColor actual = myParser.makeAbstractExpression("(plus .1 .9)").evaluate(myVarMap);
        assertTrue(WHITE.equals(actual));
        actual = myParser.makeAbstractExpression("(plus (plus 0.01 0.09) (plus 0.4 0.5))").evaluate(myVarMap);
        assertTrue(WHITE.equals(actual));
        actual = myParser.makeAbstractExpression("    (plus(plus 0.01 0.09)(plus 0.4 0.5   ))    ").evaluate(myVarMap);
        assertTrue(WHITE.equals(actual));
        actual = myParser.makeAbstractExpression("(minus (div 1.8 2) (mul -10 0.01))").evaluate(myVarMap);
        assertTrue(WHITE.equals(actual));
        try
        {
            myParser.makeAbstractExpression("(fooo 0.1 0.9)").evaluate(myVarMap);
            fail("Exception should have been thrown");
        }
        catch (ParserException e)
        {
            // actually that's good
            assertEquals(ParserException.Type.UNKNOWN_COMMAND, e.getType());
        }
    }
}
