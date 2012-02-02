package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.PerlinNoise;

public class PerlinBWExpression extends ParenExpression {

	public PerlinBWExpression() {
		super("perlinBW");
		setOperandNumber(2);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		return PerlinNoise.greyNoise(getOperand(0).evaluate(varMap), 
									 getOperand(1).evaluate(varMap));		
	}
	
	public static class Factory extends AbstractFactory {

		@Override
		public boolean isThisType(String commandName) {
			return commandName.equalsIgnoreCase(("perlinBW"));
		}

		@Override
		public ParenExpression createInstance() {
			return new PerlinBWExpression();
		}
	}

}
