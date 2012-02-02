package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.ColorCombinations;

public class AverageExpression extends ParenExpression {

	public AverageExpression() {
		super("average");
		setOperandNumber(-1);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		RGBColor averageColor = new RGBColor(0);
		for(int i=0;i<getOperandList().size();i++){
			averageColor = ColorCombinations.add(averageColor, getOperand(i).evaluate(varMap));
		}
		RGBColor divColor = new RGBColor(getOperandList().size());
		averageColor = ColorCombinations.divide(averageColor,divColor);
		return averageColor;
	}
	
	public static class Factory extends ParenExpression.AbstractFactory{
		
		@Override
		public boolean isThisType(String commandName) {
			return commandName.equals("average");
		}

		@Override
		public ParenExpression createInstance() {
			return new AverageExpression();
		}
	}
}
