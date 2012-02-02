package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.ColorCombinations;

public class MulExpression extends ParenExpression {

	public MulExpression() {
		super("mul");
		setOperandNumber(2);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		return ColorCombinations.multiply(getOperand(0).evaluate(varMap),
				getOperand(1).evaluate(varMap));
	}
	
	public static class Factory extends AbstractFactory {

		@Override
		public boolean isThisType(String commandName) {
			return (commandName.equals("mul")||commandName.equals("*"));
		}

		@Override
		public ParenExpression createInstance() {
			return new MulExpression();
		}
	}


}
