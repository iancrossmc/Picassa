package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.ColorCombinations;

public class FloorExpression extends ParenExpression {

	public FloorExpression() {
		super("floor");
		setOperandNumber(1);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		return ColorCombinations.floor(getOperand(0).evaluate(varMap));
}
	
	public static class Factory extends AbstractFactory {

		@Override
		public boolean isThisType(String commandName) {
			return commandName.equals("floor");
		}

		@Override
		public ParenExpression createInstance() {
			return new FloorExpression();
		}
	}
}
