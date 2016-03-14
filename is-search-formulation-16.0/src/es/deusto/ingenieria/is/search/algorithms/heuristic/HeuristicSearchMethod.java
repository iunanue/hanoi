package es.deusto.ingenieria.is.search.algorithms.heuristic;

import es.deusto.ingenieria.is.search.algorithms.SearchMethod;

/**
 * Abstract class defining a heuristic search method.
 */
public abstract class HeuristicSearchMethod extends SearchMethod {

	/**
	 * Evaluation function used by the heuristic search method.
	 */
	private EvaluationFunction evaluationFunction;

	/**
	 * Constructor method.
	 * 
	 * @param function
	 *            Evaluation function to be used by the heuristic search method.
	 */
	public HeuristicSearchMethod(EvaluationFunction function) {
		this.evaluationFunction = function;
	}

	/**
	 * Returns the evaluation function.
	 * @return EvaluationFunction function used by the heuristic search method.
	 */
	public EvaluationFunction getEvaluationFunction() {
		return evaluationFunction;
	}
}