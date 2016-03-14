package es.deusto.ingenieria.is.search.formulation;

import java.util.List;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.SearchMethod;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFS;
import es.deusto.ingenieria.is.search.algorithms.heuristic.BestFS;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Class defining a problem's formulation for it to be solved by a search method.
 *  The problem is defined by:
 * <li>List of initial states.</li>
 * <li>List of final states.</li>
 * <li>List of operators.</li>
 */
public class Problem {

//	private Operator mover;
	private int numSoportes;
	private int numDiscos;
	private int soporteInicial;
	private int soporteFinal;
	
//	private int disco;
//	private int soporteDestino;
	

	
	Operator operator;
	
	/**
	 * List containing the problem's initial states.
	 */
	
//	private State actualState;
	
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
		
		this.operators = new ArrayList<Operator>();
		
		addInitialState();
		addFinalState();
		System.out.println(initialStates.get(0).getList().size());
//		System.out.println(finalStates.get(0).getList().size());
		addOperators();
		
		solve(DepthFS.getInstance());
//		solve(new BestFS(new AttacksEvaluationFunction()));
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
	
	public void addOperators() {
		for(int i=0;i<numDiscos;i++){
			for(int j=0;j<numSoportes;j++){
				operator = new Operator(i,j,numSoportes);//i=numdisco j=soportedestino
				addOperator(operator);
				System.out.println(i+ " " + j);
			}
		}
	}
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
			return state.equals(finalStates.get(0));
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
//	public void runTest() {
//		
//		//Pruebas con 3 discos y 3 soportes (soporteInicial 1) (soporteFinal 3)
//		
//		System.out.println("\n- Prueba 'isApplicable' movimiento NO VÁLIDO (mover al mismo soporte):\n");//probar mover al mismo
//		disco = 3;
//		soporteDestino = soporteInicial;
//		System.out.println(mover.isApplicable(estadoActual,disco,soporteDestino));
//		
//		System.out.println("\n- Prueba 'isApplicable' movimiento NO VÁLIDO (mover un disco de abajo):\n");//probar mover disco de abajo del todo
//		disco = 1;
//		soporteDestino = 2;
//		System.out.println(mover.isApplicable(estadoActual,disco,soporteDestino));
//		
//		System.out.println("\n- Prueba 'isApplicable' movimiento VÁLIDO (mover un disco de abajo): \n");//probar mover al 2
//		disco = 3;
//		soporteDestino = 2;
//		System.out.println(mover.isApplicable(estadoActual,disco,soporteDestino));
//		
//
//		
//		
//		System.out.println("\n- Prueba 'apply' movimiento VÁLIDO:\n");
//
//		System.out.println("Antes de mover:\n");
//		System.out.println(estadoActual.toString(numSoportes));
//		
//		disco = 3;
//		soporteDestino = 1;
//		estadoActual = mover.apply(estadoActual,disco,soporteDestino);
//		
//		System.out.println("Después de mover:\n");
//		System.out.println(estadoActual.toString(numSoportes));		
//	}
	public void solve(SearchMethod searchMethod) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.S");
		Date beginDate = GregorianCalendar.getInstance().getTime();
		System.out.println("\n* Start '" + searchMethod.getClass().getSimpleName() + "' (" + formatter.format(beginDate) + ")");				

		Node finalNode = searchMethod.search(this, this.getInitialStates().get(0));
		
		Date endDate = GregorianCalendar.getInstance().getTime();		
		System.out.println("* End   '" + searchMethod.getClass().getSimpleName() + "' (" + formatter.format(endDate) + ")");
		
		long miliseconds = (int) Math.abs(beginDate.getTime() - endDate.getTime());
		long seconds = miliseconds / 1000;
		miliseconds %= 1000;		
		long minutes = seconds / 60;
		seconds %= 60;
		long hours = minutes / 60;
		minutes %= 60;
		
		String time = "\n* Serach lasts: ";
		time += (hours > 0) ? hours + " h " : " ";
		time += (minutes > 0) ? minutes + " m " : " ";
		time += (seconds > 0) ? seconds + "s " : " ";
		time += (miliseconds > 0) ? miliseconds + "ms " : " ";
		
		System.out.println(time);
		
		if (finalNode != null) {
			System.out.println("\n- Solution found!     :)");
			List<String> operators = new ArrayList<String>();
			searchMethod.solutionPath(finalNode, operators);
			searchMethod.createSolutionLog(operators);			
			System.out.println("- Final state:\n" + finalNode.getState());
		} else {
			System.out.println("\n- Unable to find the solution!     :(");
		}
	}
}