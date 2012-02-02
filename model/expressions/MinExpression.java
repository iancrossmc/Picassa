package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.ColorCombinations;

public class MinExpression extends ParenExpression{

	public MinExpression() {
		super("min");
		setOperandNumber(-1);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		RGBColor minColor = new RGBColor(1);
		for(int i=0;i<getOperandList().size();i++){
			minColor = ColorCombinations.minimum(minColor, getOperand(i).evaluate(varMap));
		}
		return minColor;
	}
	
	public static class Factory extends ParenExpression.AbstractFactory{
		
		@Override
		public boolean isThisType(String commandName) {
			return commandName.equals("min");
		}

		@Override
		public ParenExpression createInstance() {
			return new MinExpression();
		}
	}

}
