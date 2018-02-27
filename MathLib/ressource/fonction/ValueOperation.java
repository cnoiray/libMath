/**
 * 
 */
package math.test.fonction;

public class ValueOperation extends AbstractOperation {
	
	private String value;
	
	public ValueOperation(String value){
		this.value = value;
	}
	
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString(){
		return value;
	}
}
