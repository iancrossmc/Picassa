package model.expressions;

import java.util.HashMap;
import java.util.Map;

import model.ParserException;
import model.RGBColor;

public class LetExpression extends ParenExpression {

	public LetExpression() {
		super("let");
		setOperandNumber(3);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		Map<String, RGBColor> mapCopy = new HashMap<String, RGBColor>(varMap);
		String varString = getOperand(0).toString();
		if (varString.matches("(t|x|y)"))
			throw new ParserException("Can not set " + varString
					+ " to a value");
		RGBColor value = getOperand(1).evaluate(varMap);
		mapCopy.put(varString, value);
		return getOperand(2).evaluate(mapCopy);
	}

	public static class Factory extends AbstractFactory {

		@Override
		public boolean isThisType(String commandName) {
			return commandName.equals("let");
		}

		@Override
		public ParenExpression createInstance() {
			return new LetExpression();
		}
	}
}

