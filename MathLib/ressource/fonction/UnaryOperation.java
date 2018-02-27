/**
 * 
 */
package math.test.fonction;

public class UnaryOperation extends AbstractOperation {

	private AbstractOperation operateur;
	
	private String operand;
	
	/**
	 * 
	 */
	public UnaryOperation(String operand, AbstractOperation operateur) {
		// TODO Auto-generated constructor stub
		this.operateur = operateur;
		this.operand = operand;
	}

	/**
	 * @return the operateur
	 */
	public AbstractOperation getOperateur() {
		return operateur;
	}

	/**
	 * @return the operand
	 */
	public String getOperand() {
		return operand;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();;
		if(operand!=null){
			if(operand.contains("&")){
				sb.append("("+operand.toUpperCase()+operateur.toString()+")");
			}else{
				sb.append("("+operand.toUpperCase()+" "+operateur.toString()+")");
			}
		}else{
			sb.append("("+operateur.toString()+")");
		}
		
		
		return sb.toString();
	}

}
