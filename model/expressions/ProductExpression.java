package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.ColorCombinations;

public class ProductExpression extends ParenExpression {

	public ProductExpression() {
		super("product");
		setOperandNumber(-1);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		RGBColor productColor = new RGBColor(1);
		for(int i=0;i<getOperandList().size();i++){
			productColor = ColorCombinations.multiply(productColor, getOperand(i).evaluate(varMap));
		}
		return productColor;
	}
	
	public static class Factory extends ParenExpression.AbstractFactory{
		
		@Override
		public boolean isThisType(String commandName) {
			return commandName.equals("product");
		}

		@Override
		public ParenExpression createInstance() {
			return new ProductExpression();
		}
	}

}
