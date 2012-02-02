package model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.expressions.Expression;
import model.expressions.NumExpression;
import model.expressions.ParenExpression;
import model.expressions.VariableExpression;

/**
 * Parses a string into an expression tree based on rules for arithmetic.
 * 
 * Due to the nature of the language being parsed, a recursive descent parser is
 * used http://en.wikipedia.org/wiki/Recursive_descent_parser
 * 
 * @author former student solution
 * @author Robert C. Duvall (added comments, exceptions, some functions)
 */
public class Parser {
	// double is made up of an optional negative sign, followed by a sequence
	// of one or more digits, optionally followed by a period, then possibly
	// another sequence of digits
	private static final Pattern DOUBLE_REGEX = Pattern
			.compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\.[0-9]+)");
	// expression begins with a left paren followed by the command name,
	// which is a sequence of alphabetic characters or single symbol
	private static final Pattern EXPRESSION_BEGIN_REGEX = Pattern.compile(
			"\\((([a-z]+)|([\\+\\-\\%\\*\\/\\^\\!]))", Pattern.CASE_INSENSITIVE);
	// expression that contains a single variable (word, letter, etc).
	private static final Pattern VAR_REGEX = Pattern.compile("([a-z]+)", Pattern.CASE_INSENSITIVE);

	// state of the parser
	private int myCurrentPosition;
	private String myInput;

	/**
	 * Converts given string into expression tree.
	 * 
	 * @param input
	 *            expression given in the language to be parsed
	 * @return expression tree representing the given formula
	 */
	public Expression makeAbstractExpression(String input) {
		myInput = input;
		Expression result = parseExpression();
		skipWhiteSpace();
		if (notAtEndOfString()) {
			throw new ParserException(
					"Unexpected characters at end of the string: "
							+ myInput.substring(myCurrentPosition),
					ParserException.Type.EXTRA_CHARACTERS);
		}
		return result;
	}

	public Expression parseExpression() {
		skipWhiteSpace();
		if (matchRegex(DOUBLE_REGEX))
			return parseNumberExpression();
		if (matchRegex(EXPRESSION_BEGIN_REGEX))
			return parseParenExpression();
		if (matchRegex(VAR_REGEX))
			return parseVarExpression();
		else
			throw new ParserException("Unexpected character "
					+ currentCharacter());
	}

	private boolean matchRegex(Pattern regex) {
		Matcher regMatcher = regex
				.matcher(myInput.substring(myCurrentPosition));
		return regMatcher.lookingAt();
	}

	public Expression parseNumberExpression() {
		Matcher doubleMatcher = DOUBLE_REGEX.matcher(myInput);
		doubleMatcher.find(myCurrentPosition);
		String numberMatch = myInput.substring(doubleMatcher.start(),
				doubleMatcher.end());
		myCurrentPosition = doubleMatcher.end();
		// this represents the color gray of the given intensity
		double value = Double.parseDouble(numberMatch);
		return new NumExpression(value);
		
	}

	public Expression parseParenExpression() {
		Matcher expressionMatcher = EXPRESSION_BEGIN_REGEX.matcher(myInput);
		expressionMatcher.find(myCurrentPosition);
		String commandName = expressionMatcher.group(1);
		myCurrentPosition = expressionMatcher.end();
		ExpressionFactory factory = new ExpressionFactory();
		ParenExpression expression = factory.getParenExpression(commandName);
		validateCommandName(commandName, expression);
		appendOperands(expression);
		skipWhiteSpace();
		myCurrentPosition++;
		return (Expression) expression;
	}

	public Expression parseVarExpression() {
		Matcher variableMatcher = VAR_REGEX.matcher(myInput);
		variableMatcher.find(myCurrentPosition);
		String variable = variableMatcher.group(1);
		myCurrentPosition = variableMatcher.end();
		return new VariableExpression(variable);

	}
	
	private void appendOperands(ParenExpression expression) {
		int parseCount = 0;
		while (currentCharacter() != ')') {
			expression.append(parseExpression());
			parseCount++;
		}
		validateParseCount(expression, parseCount);
	}
	
	private void validateParseCount(ParenExpression expression, int parseCount) {
		if (expression.getOperandNumber() != parseCount && expression.getOperandNumber()!=-1) {
			throw new ParserException(
					"Unexpected number of operands, should be "
							+ expression.getOperandNumber());
		}
	}

	private void validateCommandName(String commandName, ParenExpression expression) {
		if (expression == null)
			throw new ParserException("Command not recognized : " + commandName);
	}

	public void skipWhiteSpace() {
		while (notAtEndOfString() && Character.isWhitespace(currentCharacter())) {
			myCurrentPosition++;
		}
	}

	private char currentCharacter() {
		if(boundsCheck())
			return myInput.charAt(myCurrentPosition);
		throw new ParserException("No closed parenthesis found.");
	}
	
	private boolean boundsCheck() {
		return myCurrentPosition<myInput.length();
	}

	private boolean notAtEndOfString() {
		return myCurrentPosition < myInput.length();
	}
}
