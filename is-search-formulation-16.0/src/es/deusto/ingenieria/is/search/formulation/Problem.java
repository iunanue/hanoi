package es.deusto.ingenieria.is.search.formulation;

import java.util.List;
import java.util.ArrayList;

/**
 * Class defining a problem's formulation for it to be solved by a search method.
 *  The problem is defined by:
 * <li>List of initial states.</li>
 * <li>List of final states.</li>
 * <li>List of operators.</li>
 */
public class Problem {

	private Operator mover;
	private int numSoportes;
	private int numDiscos;
	private int soporteInicial;
	private int soporteFinal;
	
	private State estadoActual;
	private State estadoFinal;
	
	/**
	 * List containing the problem's initial states.
	 */
	
	private State actualState;
	
	private List<State> initialStates;

	/**
	 * List containing the problem's final states.
	 */
	private List<State> finalStates;

	/**
	 * List containing the problem's operators.
	 */
	private List<Operator> operators;

	/**
	 * Constructor method. Instantiates a problem making empty lists for the initial states,
	 * final states and operators.
	 */
	public Problem(int numSoportes, int numDiscos, int soporteInicial, int soporteFinal) {
		this.numSoportes = numSoportes;
		this.numDiscos = numDiscos;
		this.soporteInicial = soporteInicial;
		this.soporteFinal = soporteFinal;
		mover = new Operator();
		
		this.operators = new ArrayList<Operator>();
		
		addInitialState();
		addFinalState();
//		runTest();
		
	}
	
	/**
	 * Adds a problem initial state to the list of initial states.
	 * 
	 * @param initialState
	 *            State that is one of the problem's initial states.
	 */
	public void addInitialState() {

		State initialState = new State();
		initialStates = new ArrayList<State>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numDiscos; i++) {
			list.add(soporteInicial);
		}
		initialState.setList(list);
		initialStates.add(initialState);
		estadoActual = initialState;
	}

	/**
	 * Returns the problem's initial states list.
	 * 
	 * @return List<State> containing the problem's initial states.
	 */
	public List<State> getInitialStates() {
		return this.initialStates;
	}
	
	/**
	 * Adds a problem final state to the list of final states.
	 * 
	 * @param finalState
	 *            State that is one of the problem's final states.
	 */
	public void addFinalState() {
//		if (finalState != null && !this.finalStates.contains(finalState)) {
//			this.finalStates.add(finalState);
//		}
		State finalState = new State();
		finalStates = new ArrayList<State>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numDiscos; i++) {
			list.add(soporteFinal);
		}
		finalState.setList(list);
		finalStates.add(finalState);
	}

	/**
	 * Returns the problem's final states list.
	 * 
	 * @return List<State> containing the problem's final states.
	 */
	
	public List<State> getFinalStates() {
		return this.finalStates;
	}

	/**
	 * Adds a problem operator to the list of operators.
	 * 
	 * @param operator
	 *            Operator that is one of the problem's operators.
	 */
	public void addOperator(Operator operator) {
		if (operator != null && !this.operators.contains(operator)) {
			this.operators.add(operator);
		}
	}

	/**
	 * Returns the problem's operators list.
	 * 
	 * @return List<Operator> containing the problem's operators.
	 */
	public List<Operator> getOperators() {
		return this.operators;
	}

	/**
	 * Checks whether a given state is one of the problem's final states by looking 
	 * for it inside the problem's final states list (using method contains). If final
	 * states of the problem are unknown, this method must be redefined. 
	 * 
	 * @param state
	 *            State containing the problem state to be checked.
	 * @return boolean
	 *         <li>true - if state is found in the list of final states</li>
	 *         <li>false - if state is not found in the list of final states.</li>
	 */
	public boolean isFinalState(State state) {
		if (state != null) {
			return state.equals(estadoFinal);
		} else {
			return false;
		}
	}
	
	/**
	 * Checks whether a given state is fully observed.  
	 * 
	 * @param state
	 *            State containing the problem state to be checked.
	 * @return boolean
	 *         <li>true - if state is fully observed.</li>
	 *         <li>false - if state is fully observed.</li>
	 */	
	public boolean isFullyObserved(State state) {
		//Default implementation: All the states are fully observed.
		return true;
	}	
	
	/**
	 * Gathers initial percepts from environment. 
	 * Returns the environment initial state.
	 * 
	 * @return State
	 *            that represents the initial state of the environment.
	 */
	public State gatherInitialPercepts(){
		return null;
		
	}
	
	/**
	 * Gathers percepts that were missing from the current environment state. 
	 * Returns the environment state now fully described by the newly gathered percepts.
	 * 
	 * @param state
	 *            State represents the current state of the environment.
	 * @return State
	 *            that represents the current state of the environment fully described.
	 */
	public State gatherPercepts(State state) {
		return state;
	}
	public void runTest() {
		
		//Pruebas con 3 discos y 3 soportes (soporteInicial 1) (soporteFinal 3)
		
		System.out.println("\n- Prueba 'isApplicable' movimiento NO VÁLIDO:\n");//probar mover al mismo
		System.out.println(mover.isApplicable(estadoActual,3,soporteInicial));
		
		System.out.println("\n- Prueba 'isApplicable' movimiento VÁLIDO:\n");//probar mover al 2
		System.out.println(mover.isApplicable(estadoActual,3,2));
		
		System.out.println("\n- Prueba 'isApplicable' movimiento NO VÁLIDO:\n");//probar mover disco de abajo del todo
		System.out.println(mover.isApplicable(estadoActual,1,2));
		
		
		System.out.println("\n- Prueba 'apply' movimiento VÁLIDO:\n");

		System.out.println("Antes de mover:\n");
		System.out.println(estadoActual.toString(numSoportes));
		
		estadoActual = mover.apply(estadoActual,3,1);
		
		System.out.println("Después de mover:\n");
		System.out.println(estadoActual.toString(numSoportes));
		
			
	}
}