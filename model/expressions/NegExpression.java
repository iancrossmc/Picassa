package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.ColorCombinations;

public class NegExpression extends ParenExpression {
	
	public NegExpression() {
		super("neg");
		setOperandNumber(1);
	}

	
	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		return ColorCombinations.negative(getOperand(0).evaluate(varMap));
	}
	
	public static class Factory extends AbstractFactory {

		@Override
		public boolean isThisType(String commandName) {
			return (commandName.equals("neg")||commandName.equals("!"));
		}

		@Override
		public ParenExpression createInstance() {
			return new NegExpression();
		}
	}
	
	
}
