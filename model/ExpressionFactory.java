package model;

import java.util.ArrayList;
import java.util.List;

import model.expressions.*;
import model.expressions.ParenExpression.AbstractFactory;

public class ExpressionFactory {
	private AbstractFactory[] myFactoryArray;
	
	public ExpressionFactory(){
		AbstractFactory[] array = {new AbsExpression.Factory(),new ATanExpression.Factory(),
				new CeilExpression.Factory(),new ClampExpression.Factory(),
				new ColExpression.Factory(),new CosExpression.Factory(),
				new DivExpression.Factory(),new ExpExpression.Factory(),
				new FloorExpression.Factory(),new LetExpression.Factory(),
				new LogExpression.Factory(),new MinusExpression.Factory(),
				new ModExpression.Factory(),new MulExpression.Factory(),
				new NegExpression.Factory(),new PerlinBWExpression.Factory(),
				new PerlinColorExpression.Factory(),new PlusExpression.Factory(),
				new RandomExpression.Factory(),new RGBToYCrCbExpression.Factory(),
				new SinExpression.Factory(),new TanExpression.Factory(),
				new WrapExpression.Factory(),new YCrCbToRGBExpression.Factory(),
				new AverageExpression.Factory(),new IfExpression.Factory(),
				new MaxExpression.Factory(), new MinExpression.Factory(),
				new ProductExpression.Factory(), new SumExpression.Factory()};
		myFactoryArray = array;
	}
	

	public ParenExpression getParenExpression(String commandName) {
		for(AbstractFactory factory : myFactoryArray){
			if(factory.isThisType(commandName))
				return factory.createInstance();
		}
		return null;
	}
}
