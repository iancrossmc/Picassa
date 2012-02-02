package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.ColorCombinations;

public class SinExpression extends ParenExpression {

	public SinExpression() {
		super("sin");
		setOperandNumber(1);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		return ColorCombinations.sin(getOperand(0).evaluate(varMap));
	}
	
	public static class Factory extends AbstractFactory {

		@Override
		public boolean isThisType(String commandName) {
			return commandName.equals("sin");
		}

		@Override
		public ParenExpression createInstance() {
			return new SinExpression();
		}
	}

}
