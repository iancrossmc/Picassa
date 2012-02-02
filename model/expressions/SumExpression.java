package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.ColorCombinations;

public class SumExpression extends ParenExpression {

	public SumExpression() {
		super("sum");
		setOperandNumber(-1);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		RGBColor sumColor = new RGBColor(0);
		for(int i=0;i<getOperandList().size();i++){
			sumColor = ColorCombinations.add(sumColor, getOperand(i).evaluate(varMap));
		}
		return sumColor;
	}
	
	public static class Factory extends ParenExpression.AbstractFactory{
		
		@Override
		public boolean isThisType(String commandName) {
			return commandName.equals("sum");
		}

		@Override
		public ParenExpression createInstance() {
			return new SumExpression();
		}
	}

}
