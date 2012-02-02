package model.expressions;

import java.util.Map;

import model.RGBColor;

public class ColExpression extends ParenExpression {
	
	public ColExpression() {
		super("color");
		setOperandNumber(3);
	}
	
	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		RGBColor color = new RGBColor(getOperand(0).evaluate(varMap),
									  getOperand(1).evaluate(varMap),
									  getOperand(2).evaluate(varMap));
        return color;
	}

	
public static class Factory extends AbstractFactory{
		
		@Override
		public boolean isThisType(String commandName) {
			return commandName.equals("color");
		}

		@Override
		public ParenExpression createInstance() {
			return new ColExpression();
		}
		
		
	}
}
