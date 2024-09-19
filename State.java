package assignmentOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// State class with Map of transition for each input
// also is the basic one, both NFA and DFA class
// uses this class
public class State 
{
	private int stateID;
	private Map<Character, ArrayList<State>> nextState;
	private Set <State> states;
	private boolean acceptState;
	
	// This constructor is used for NFA
	public State (int ID) 
	{
		this.setStateID(ID);
		this.setNextState(new HashMap <Character, ArrayList<State>> ());
		this.setAcceptState(false);
	}
	
	// This constructor is used for DFA
	public State(Set<State> states, int ID) 
	{
		this.setStates(states);
		this.setStateID(ID);
		this.setNextState(new HashMap <Character, ArrayList<State>> ());
		
		// find if there is final state in this set of states
		for (State p : states) 
		{
			if (p.isAcceptState()) 
			{
				this.setAcceptState(true);
				break;
			}
		}
	}
	
	// Add transition between states and insert into the arrayList
	// or create the arrayList based on key
	public void addTransition (State next, char key) 
	{
		ArrayList <State> list = this.nextState.get(key);
		
		if (list == null) 
		{
			list = new ArrayList<State> ();
			this.nextState.put(key, list);
		}
		
		list.add(next);
	}

	// Get all transition states based on symbol
	public ArrayList<State> getAllTransitions(char c) 
	{	
		if (this.nextState.get(c) == null)	
		{	
			return new ArrayList<State> ();	
		}
		else 								
		{	
			return this.nextState.get(c);	
		}
	}
	
	// Auto-generated Getters and Setters
	public Map<Character, ArrayList<State>> getNextState() 
	{
		return nextState;
	}

	public void setNextState(HashMap<Character, ArrayList<State>> hashMap) 
	{
		this.nextState = hashMap;
	}
	
	public int getStateID() 
	{
		return stateID;
	}

	public void setStateID(int stateID) 
	{
		this.stateID = stateID;
	}

	public boolean isAcceptState() 
	{
		return acceptState;
	}

	public void setAcceptState(boolean acceptState) 
	{
		this.acceptState = acceptState;
	}

	public Set <State> getStates() 
	{
		return states;
	}

	public void setStates(Set <State> states) 
	{
		this.states = states;
	}
}