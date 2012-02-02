package model.expressions;

import java.util.Map;

import model.RGBColor;

public class ClampExpression extends ParenExpression {

	public ClampExpression() {
		super("clamp");
		setOperandNumber(1);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		RGBColor ret = getOperand(0).evaluate(varMap);
		ret.clamp();
		return ret;
	}
	
	
	public static class Factory extends AbstractFactory{
		
		@Override
		public boolean isThisType(String commandName) {
			return commandName.equals("clamp");
		}

		@Override
		public ParenExpression createInstance() {
			return new ClampExpression();
		}
		
		
	}

}
