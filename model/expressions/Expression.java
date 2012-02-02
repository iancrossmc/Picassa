package model.expressions;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import model.Parser;
import model.RGBColor;
import model.ParserException.Type;
import model.util.ColorCombinations;

/**
 * An Expression represents a mathematical expression as a tree.
 * 
 * In this format, the internal nodes represent mathematical 
 * functions and the leaves represent constant values.
 *
 *@author - Ian McMahon
 */

public abstract class Expression {
	
	public abstract RGBColor evaluate (Map<String, RGBColor> varMap);
	public abstract String toString ();
	
	
		
}
