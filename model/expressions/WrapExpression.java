package model.expressions;

import java.util.Map;

import model.RGBColor;

public class WrapExpression extends ParenExpression {

	public WrapExpression() {
		super("wrap");
		setOperandNumber(1);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		RGBColor ret = getOperand(0).evaluate(varMap);
		ret.wrap();
		return ret;
	}
	
	public static class Factory extends AbstractFactory {

		@Override
		public boolean isThisType(String commandName) {
			return commandName.equals("wrap");
		}

		@Override
		public ParenExpression createInstance() {
			return new WrapExpression();
		}
	}

}
