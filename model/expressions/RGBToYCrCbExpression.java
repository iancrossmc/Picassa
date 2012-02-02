package model.expressions;

import java.util.Map;

import model.RGBColor;
import model.util.ColorModel;

public class RGBToYCrCbExpression extends ParenExpression {

	public RGBToYCrCbExpression() {
		super("rgbToYCrCb");
		setOperandNumber(1);
	}

	@Override
	public RGBColor evaluate(Map<String, RGBColor> varMap) {
		return ColorModel.rgb2ycrcb(getOperand(0).evaluate(varMap));
	}

	public static class Factory extends AbstractFactory {

		@Override
		public boolean isThisType(String commandName) {
			return commandName.equalsIgnoreCase("rgbToYCrCb");
		}

		@Override
		public ParenExpression createInstance() {
			return new RGBToYCrCbExpression();
		}
	}

}
