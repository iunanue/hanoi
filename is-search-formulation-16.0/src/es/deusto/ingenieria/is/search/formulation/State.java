package es.deusto.ingenieria.is.search.formulation;

import java.util.ArrayList;

import javax.print.attribute.standard.NumberOfDocuments;

import com.sun.org.glassfish.external.statistics.StringStatistic;

/**
 * Class defining problem state. It represents a given problem stage or situation.
 */
public class State {

	private int numDiscos;
	private boolean esInicialFinal;
	
private ArrayList<Integer> list;
private ArrayList<Integer> listComparar = new ArrayList<Integer>();
	
	public State(int numDiscos, boolean esInicialFinal)
	{
		this.numDiscos = numDiscos;
		this.esInicialFinal = esInicialFinal;
		list = new ArrayList<Integer>();
		
		if(esInicialFinal == true)
		{
			for(int i=numDiscos; numDiscos>0; i--)
			{
				list.add(numDiscos);
			}
		}
		else
		{
			for(int i=numDiscos; numDiscos>0; i--)
			{
				list.add(0);
			}
		}
		
		
	}
	/**
	 * Returns a string representation of the object. In general, the toString
	 * method returns a string that "textually represents" this object.
	 * 
	 * The result should be a concise but informative representation that is 
	 * easy for a person to read. It is recommended that all subclasses 
	 * override this method.
	 * 
	 * The toString method for class Object returns a string consisting of the
	 * name of the class of which the object is an instance, the at-sign 
	 * character `@', and the unsigned hexadecimal representation of the hash
	 * code of the object. 
	 * 
	 * In other words, this method returns a string equal to the value of: 
	 * getClass().getName() + '@' + Integer.toHexString(hashCode())
	 * 
	 * @return a string representation of the object.
	 */
	public String toString() {
		String stringSoporte = null;
		for(int i=0;i<numDiscos;i++)
		{
			stringSoporte = stringSoporte +"[" + list.get(i)+"]\n";
		}
		return stringSoporte;
		
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * The equals method for class Object implements the most discriminating 
	 * possible equivalence relation on objects; that is, for any non-null 
	 * reference values x and y, this method returns true if and only if x 
	 * and y refer to the same object (x == y has the value true).
	 * 
	 * 
	 * @param obj
	 *            the reference object with which to compare.
	 * @return boolean
	 *         <li><b>true</b> - if this object is the same as the obj argument.</li>
	 *         <li><b>false</b> - otherwise.</li>
	 */
	public boolean equals(State state) {
		boolean igual = true;
		for(int i=0;i<numDiscos;i++){
			if(list.get(i) != state.list.get(i)){
				igual = false;
			}
		}
		return igual;
	}
}