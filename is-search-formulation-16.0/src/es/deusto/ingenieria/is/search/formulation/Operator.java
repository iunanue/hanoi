package es.deusto.ingenieria.is.search.formulation;

/**
 * Abstract class defining a problem's operator. Operator represents the way
 * problem states are created, since the result of applying an operator on a
 * given problem state is a new problem state. <br/>
 * <br/>
 * <b>Note</b>: The purpose of this class is for specific Operators of a given
 * problem to inherit from it and redefine the methods <i>isAplicable()</i> y
 * <i>effect()</i>.
 */
public class Operator {

	/**
	 * Operator's name.
	 */
	private String name;

	/**
	 * Cost of applying the Operator on a given problem state.
	 */
	private double cost;

	/**
	 * Constructor method. Instantiates an operator with no name and cost zero.
	 */
	public Operator() {
		this.name = "mover";
	}

	/**
	 * Constructor method. Instantiates an operator with a given name and cost
	 * zero.
	 * 
	 * @param name
	 *            String with the opearator's name.
	 */
	public Operator(String name) {
		this.name = name;
	}

	/**
	 * Constructor method. Instantiates an operator with a given name and cost.
	 * 
	 * @param name
	 *            String with the operator's name.
	 * @param cost
	 *            double with the operator's cost.
	 */
	public Operator(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}

	/**
	 * Returns the operator's cost.
	 * 
	 * @return double with the operator's cost.
	 */
	public double getCost() {
		return this.cost;
	}

	/**
	 * Modifies the value of the operator's cost.
	 * 
	 * @param cost
	 *            double with the new operator's cost.
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * Returns the operator's name.
	 * 
	 * @return String with the operator's name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Modifies the value of the operator's name.
	 * 
	 * @param name
	 *            String with the new operator's name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Applies the operator on a given problem state to generate a new problem
	 * state.
	 * 
	 * @param state
	 *            State on which the operator is applied.
	 * @return State resulting from applying the operator or <i>null</i> if the
	 *         operator can't be applied on the state received as parameter, or
	 *         an error happens during the operator application. <br/>
	 *         <br/>
	 *         <ul>
	 *         <li>This method's implementation uses methods <i>isApplicable</i>
	 *         and <i>effect</i>.</li>
	 *         <li>This method is <i><b>final</i></b> to avoid its redefinition
	 *         by a subclass of Operator; This is justified by the fact that an
	 *         operator is always applied the same way on a problem state</li>
	 *         </ul>
	 */
	public final State apply(State state, Integer fichaMover, Integer torreDestino) {
		State successor = null;

		if (state != null && this.isApplicable(state,fichaMover, torreDestino)) {
			successor = this.effect(state,fichaMover, torreDestino);
		}
		else{
			successor = state;
		}
		return successor;
	}

	/**
	 * Checks whether the Operator can be applied to a state.
	 * 
	 * @param state
	 *            State to which the operator is to be applied.
	 * @return
	 * 		<ul>
	 *         <li><b>true</b> - if the operator applies.</li>
	 *         <li><b>false</b> - if the operator can not be applied.</li>
	 *         </ul>
	 *         <br/>
	 *         <br/>
	 *         <b>Note</b>: This method is <i><b>protected</b></i> to avoid its
	 *         invocation by classes other than operator subclasses or classes
	 *         outside this package <i>es.deusto.ingenieria.aike.formulation</i>
	 *         .
	 */
	protected boolean isApplicable(State state, int fichaMover, int torreDestino) {
		boolean applicable = true;
		System.out.println("Ficha:" + fichaMover);
		int fichaMoverTorre = state.getList().get(fichaMover - 1);
		System.out.println("tama�o" + state.getList().size());
		for (int i = fichaMover; i < state.getList().size(); i++) {

			int fichaTorre = state.getList().get(i);
			System.out.println("fichaTorre" + fichaTorre);
			System.out.println("fichaMoverTorre" + fichaMoverTorre);
			System.out.println("fichaMoverTorre" + fichaMoverTorre);
			System.out.println("torreDestino" + torreDestino);
			if (fichaTorre == fichaMoverTorre)
				applicable = false;
			if (torreDestino == fichaMoverTorre)
				applicable = false;
			if (fichaTorre == torreDestino)
				applicable = false;
		}
		return applicable;

	}

	/**
	 * This method corresponds to the operator's <b>Transition Model</b>. That
	 * is to say, its result is the EFFECT of applying the operator on the given
	 * state, so a new successor state is generated.
	 * 
	 * @param state
	 *            state is the current problem state.
	 * @return State is the newly generated state or <i>null</i> if an error
	 *         occurs. <br/>
	 *         <br/>
	 *         <b>Note</b>: This method is <i><b>protected</b></i> to avoid its
	 *         invocation by classes other than operator subclasses or classes
	 *         outside this package <i>es.deusto.ingenieria.aike.formulation</i>
	 *         .
	 */
	protected State effect(State state, Integer fichaMover, Integer torreDestino) {
		System.out.println("sdfsdfasdfasdf");
		state.getList().set(fichaMover-1, torreDestino);
		System.out.println(state.getList().get(fichaMover-1));
		return state;

	}

	/**
	 * Returns a text string containing the operator's name and cost.
	 * Redefinition of method <i>toString()</i> from the class Object.
	 * 
	 * @return String with the operator's name and cost.
	 */
	public String toString() {
		return this.getName() + " // Operator's cost: " + this.getCost();
	}
}