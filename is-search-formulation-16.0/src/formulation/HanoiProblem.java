package formulation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.SearchMethod;
import es.deusto.ingenieria.is.search.formulation.State;



public class HanoiProblem extends es.deusto.ingenieria.is.search.formulation.Problem{

	private int numSoportes;
	private int numDiscos;
	private int soporteInicial;
	private int soporteFinal;
	
	HanoiOperator operator;
	
	private List<HanoiState> initialStates;

	/**
	 * List containing the problem's final states.
	 */
	private List<HanoiState> finalStates;

	/**
	 * List containing the problem's operators.
	 */
	private List<HanoiOperator> operators;
	
	
	public HanoiProblem(int numSoportes, int numDiscos, int soporteInicial, int soporteFinal){
		super();
		this.numSoportes = numSoportes;
		this.numDiscos = numDiscos;
		this.soporteInicial = soporteInicial;
		this.soporteFinal = soporteFinal;
		
		this.operators = new ArrayList<HanoiOperator>();
		
		addInitialState();
		addFinalState();
//		System.out.println(getInitialStates().get(0).toString(numSoportes));
//		System.out.println(getFinalStates().get(0).toString(numSoportes));
		addOperators();
	}
	
	public void addInitialState() {
		HanoiState initialState = new HanoiState(numSoportes);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numDiscos; i++) {
			list.add(soporteInicial);
		}
		initialState.setList(list);
		addInitialState(initialState);
	}
	
	public void addFinalState() {
		HanoiState finalState = new HanoiState(numSoportes);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numDiscos; i++) {
			list.add(soporteFinal);
		}
		finalState.setList(list);
		addFinalState(finalState);
	}
	
	protected void addOperators() {
		for(int i=0;i<numDiscos;i++){
			for(int j=0;j<numSoportes;j++){
				operator = new HanoiOperator(i,j,numSoportes);//i=numdisco j=soportedestino
				addOperator(operator);
				System.out.println(i+ " " + j);
			}
		}
			
	}
	
	@Override
	public State gatherInitialPercepts() {
		// TODO Auto-generated method stub
		return null;
	}
	
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
			System.out.println("\n- Final state:\n" + finalNode.getState().toString());
		} else {
			System.out.println("\n- Unable to find the solution!     :(");
		}
	}

}
