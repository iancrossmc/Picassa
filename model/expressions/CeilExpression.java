package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.ColorCombinations;

public class CeilExpression extends ParenExpression {

	public CeilExpression() {
		super("ceil");
		setOperandNumber(1);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		return ColorCombinations.ceiling(getOperand(0).evaluate(varMap));
	}
	
	public static class Factory extends AbstractFactory{
		
		@Override
		public boolean isThisType(String commandName) {
			return commandName.equals("ceil");
		}

		@Override
		public ParenExpression createInstance() {
			return new CeilExpression();
		}
	}
}
