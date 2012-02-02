package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.ColorCombinations;

public class LogExpression extends ParenExpression {

	public LogExpression() {
		super("log");
		setOperandNumber(1);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		return ColorCombinations.logarithm(getOperand(0).evaluate(varMap));
	}

	public static class Factory extends AbstractFactory {

		@Override
		public boolean isThisType(String commandName) {
			return commandName.equals("log");
		}

		@Override
		public ParenExpression createInstance() {
			return new LogExpression();
		}
	}
}
