package model.expressions;

import java.util.ArrayList;
import java.util.List;


public abstract class ParenExpression extends Expression {
	private List<Expression> myOperandList;
	private String myCommand;
	private int myOperandNumber;
	
	public ParenExpression (String command) { 
		myOperandList = new ArrayList<Expression>();
		myCommand = command;
	}
	
	public void append(Expression operand){
		myOperandList.add(operand);
	}
	
	public List<Expression> getOperandList(){
		return myOperandList;
	}
	
	public Expression getOperand(int index) {
		return myOperandList.get(index);
	}
	
	@Override
	public String toString(){
		StringBuffer stringRep = new StringBuffer();
		stringRep.append("( "+myCommand);
		for(Expression op : myOperandList){
			stringRep.append(" "+op.toString());
		}
		stringRep.append(" )");
		return stringRep.toString();
	}

	public void setOperandNumber(int number) {
		myOperandNumber = number;
	}

	public int getOperandNumber() {
		return myOperandNumber;
	}
	
	public static abstract class AbstractFactory {
		public abstract boolean isThisType(String commandName);
		public abstract ParenExpression createInstance();
	}

}
