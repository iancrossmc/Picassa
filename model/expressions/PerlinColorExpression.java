package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.PerlinNoise;

public class PerlinColorExpression extends ParenExpression {

	public PerlinColorExpression() {
		super("perlinColor");
		setOperandNumber(2);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		return PerlinNoise.colorNoise(getOperand(0).evaluate(varMap), 
									  getOperand(1).evaluate(varMap));
		
	}

	public static class Factory extends AbstractFactory {

		@Override
		public boolean isThisType(String commandName) {
			return commandName.equalsIgnoreCase("perlinColor");
			
		}

		@Override
		public ParenExpression createInstance() {
			return new PerlinColorExpression();
		}
	}
}
