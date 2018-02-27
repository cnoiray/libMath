/**
 * 
 */
package math.test.fonction;

public class BinaryOperation extends AbstractOperation {

	
	private String operand;

	private AbstractOperation operateur1;
	
	private AbstractOperation operateur2;
	
	/**
	 * 
	 */
	public BinaryOperation(String operand, AbstractOperation operateur1, AbstractOperation operateur2) {
		// TODO Auto-generated constructor stub
		this.operand = operand;
		this.operateur1 = operateur1;
		this.operateur2 = operateur2;
	}
	
	/**
	 * @return the operand
	 */
	public String getOperand() {
		return operand.toUpperCase();
	}

	/**
	 * @return the operateur1
	 */
	public AbstractOperation getOperateur1() {
		return operateur1;
	}

	/**
	 * @return the operateur2
	 */
	public AbstractOperation getOperateur2() {
		return operateur2;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		if("/".equalsIgnoreCase(operand)||operand.contains("&")||"=".equalsIgnoreCase(operand)|| hasSquareBracket(operand)){
			sb.append("(");
			if(operateur1 instanceof ValueOperation && operateur1.toString().contains(":")){
				String[] s = operateur1.toString().split(":");
				sb.append(s[0]+":("+s[1]+operand+operateur2.toString()+")");
			}else{
				sb.append("("+operateur1.toString()+operand+operateur2.toString()+")").toString();
			}
			sb.append(")");
		}else{
			sb.append("("+operateur1.toString()+" "+operand+" "+operateur2.toString()+")").toString();
		}
		return sb.toString();
	}
	
	public boolean hasSquareBracket(String operand){
		return "<".equalsIgnoreCase(operand)||">".equalsIgnoreCase(operand);
	}

}
