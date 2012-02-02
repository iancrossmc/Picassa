package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.ColorCombinations;

public class PlusExpression extends ParenExpression {

	public PlusExpression() {
		super("plus");
		setOperandNumber(2);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		return ColorCombinations.add(getOperand(0).evaluate(varMap), 
				getOperand(1).evaluate(varMap));
	}
	
	public static class Factory extends AbstractFactory {

		@Override
		public boolean isThisType(String commandName) {
			return (commandName.equals("plus")||commandName.equals("+"));
		}

		@Override
		public ParenExpression createInstance() {
			return new PlusExpression();
		}
	}

}
