package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.ColorCombinations;

public class RandomExpression extends ParenExpression{
	private RGBColor myColor;

	public RandomExpression() {
		super("random");
		setOperandNumber(0);
	}
	
	@Override 
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		if (myColor == null){
			myColor = ColorCombinations.random();
		}
		return myColor;
	}

	public static class Factory extends AbstractFactory {

		@Override
		public boolean isThisType(String commandName) {
			return commandName.equals("random");
		}

		@Override
		public ParenExpression createInstance() {
			return new RandomExpression();
		}
	}
}
