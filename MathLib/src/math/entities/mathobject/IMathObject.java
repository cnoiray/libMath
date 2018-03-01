package math.entities.mathobject;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;

public interface IMathObject {
	public boolean isNull();
	public boolean equals(IMathObject value);
	public IMathObject arrondir();
	public boolean sup(IMathObject value);
	public boolean inf(IMathObject value);
	public IMathObject eval();
	public IMathObject calc(SimpleEntry<Inconnue, IMathObject>... value);
}
