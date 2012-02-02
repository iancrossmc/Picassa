package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.ColorModel;

public class YCrCbToRGBExpression extends ParenExpression {

	public YCrCbToRGBExpression() {
		super("yCrCbtoRGB");
		setOperandNumber(1);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		return ColorModel.ycrcb2rgb(getOperand(0).evaluate(varMap));
	}

	public static class Factory extends AbstractFactory {

		@Override
		public boolean isThisType(String commandName) {
			return commandName.equalsIgnoreCase("yCrCbtoRGB");
		}

		@Override
		public ParenExpression createInstance() {
			return new YCrCbToRGBExpression();
		}
	}
}
