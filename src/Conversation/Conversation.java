package Conversation;
import java.util.LinkedList;

import People.Person;

// TODO: Auto-generated Javadoc
/**
 * The Class Conversation. Contains the ingredients necessary for a conversation
 * between 2 people, including 2 People, a current topic, previous topics, etc.
 */
public class Conversation 
{
    
    /** The initiator of the conversation. */
    protected Person initiator;
    
    /** The responder to the initiator of the conversation. The person responding first. */
    protected Person responder;
    
    /** The current topic of conversation. */
    protected Topic currentTopic;
    
    /** The previous topics in the conversation. */
    protected LinkedList<Topic> prevTopics;
    
	/** The previous statements in the conversation. */
    protected LinkedList<Statement> prevStatements;
		
    /**
     * Instantiates a new conversation.
     *
     * @param initiator the initiator
     * @param responder the responder
     * @param startingTopic the starting topic
     */
    public Conversation(Person initiator, Person responder, Topic startingTopic)
    {
        this.initiator = initiator;
        this.responder = responder;
        this.currentTopic = startingTopic;
        this.prevStatements = new LinkedList<Statement>();
        this.prevTopics = new LinkedList<Topic>();
    }
    
	/**
	 * Forces the specified talker to say the statement provided to the
	 * listener. Does not require minimum requirements or use anything "A.I."
	 * Mainly intended for debugging.
	 *
	 * @param talker the talker
	 * @param statement the statement
	 * @param listener the listener
	 */
	public void say(Person talker, Statement statement, Person listener)
	{
		// Add the statement to the list of previous statements.
		prevStatements.addLast(statement);
		prevStatements.getLast().addLastPersonWhoSaidIt(talker);
				
		// TODO Remove comments below. This will automate the statement selection. No debugging.
		// Get the response based on available statements. NOT used here because the statements
		// available are provided in the combo box and the user selects one. 
		/* Statement response = talker.getResponse(statements); */
		
		// Update the other person's emotions based on the statement selected.
		listener.updateEmotions(statement.getDelEmotions());
		
		// Save the last topic of conversation.
		prevTopics.addLast(currentTopic);
		
		// Move the conversation to the next topic.
		currentTopic = statement.getNextTopic();
	}
	
	/**
	* The last person who was listening makes a statement to
	* the last person who was talking. Using "A.I." to determine
	* what statement to say.
	*
	*/
	public void nextStatement()
	{
		// Get the last person who talked.
		Person talker = getLastStatement().getWhoSaidItLast(initiator, responder);
		Person listener = null; //TODO Need to handle this...
		
		// Figure out if the listener was the initiator or responder.
		if (talker == initiator)
		{
			listener = responder;
		}
		else if (talker == responder)
		{
			listener = initiator;
		}
		else
		{
			// TODO We have a problem. Last statement should've been said
			// by either the responder or initiator. 
		}
		
		// Get the statements that can be said about the current topic.
		LinkedList<Statement> statements = currentTopic.getStatements();
		
		// This will automate the statement selection.
		Statement response = talker.getResponse(statements);
		
		// Add the statement to the list of previous statements.
		prevStatements.addLast(response);
		prevStatements.getLast().addLastPersonWhoSaidIt(talker);
		
		// Update the other person's emotions based on the statement selected.
		listener.updateEmotions(response.getDelEmotions());
		
		// Save the last topic of conversation.
		prevTopics.addLast(currentTopic);
		
		// Move the conversation to the next topic.
		currentTopic = response.getNextTopic();
	}
	
	/**
	 * The talker specified says another statement to the listener.
	 * Using the "A.I." to filter through the possible statements.
	 *
	 * @param talker the talker
	 * @param listener the listener
	 */
	public void nextStatement(Person talker, Person listener)
	{
		// Get the statements that can be said about the current topic.
		LinkedList<Statement> statements = currentTopic.getStatements();
		
		// This will automate the statement selection.
		Statement response = talker.getResponse(statements);
		
		// Add the statement to the list of previous statements.
		prevStatements.addLast(response);
		prevStatements.getLast().addLastPersonWhoSaidIt(talker);
		
		// Update the other person's emotions based on the statement selected.
		listener.updateEmotions(response.getDelEmotions());
		
		// Save the last topic of conversation.
		prevTopics.addLast(currentTopic);
		
		// Move the conversation to the next topic.
		currentTopic = response.getNextTopic();
	}
	
	/** 
	* Gets the last statement said by the initiator of the conversation.
	*
	* @return The last statement said by the initiator of the conversation.
	*/
	public Statement getLastStatementByInitiator()
	{
		// Loop backwards through the list to get through the most
		// recent statements. 
		for(int index = prevStatements.size() - 1; index >= 0; index--)
		{
			// TODO Can I use "==" here? Or do I need to compare names or something?
			// Should be the same object... right?
			if (prevStatements.get(index).getWhoSaidItLast(initiator, responder) == initiator)
			{
				return prevStatements.get(index);
			}
		}
		
		// Didn't find anything. 
		return null;
	}
	
	/** 
	* Gets the last statement said by the responder for the conversation.
	*
	* @return The last statement said by the responder for the conversation.
	*/
	public Statement getLastStatementByResponder()
	{
		// Loop backwards through the list to get through the most
		// recent statements. 
		for(int index = prevStatements.size() - 1; index >= 0; index--)
		{
			// TODO Can I use "==" here? Or do I need to compare names or something?
			// Should be the same object... right?
			if (prevStatements.get(index).getWhoSaidItLast(initiator, responder) == responder)
			{
				return prevStatements.get(index);
			}
		}
		
		// Didn't find anything. 
		return null;
	}
	
	/**
	* Gets the last person who talked.
	*
	* @return The person who said the last statement.
	*/
	public Person getPrevTalker()
	{
		return this.getLastStatement().getWhoSaidItLast(initiator, responder);
	}
	
	/**
	* Gets the last statement that was said.
	*
	* @return The last statement that was said.
	*/
	public Statement getLastStatement()
	{
		return prevStatements.getLast();
	}
	
    /**
     * Gets the initiator.
     *
     * @return the initiator
     */
    public Person getInitiator() 
    {
        return initiator;
    }

    /**
     * Sets the initiator.
     *
     * @param initiator the new initiator
     */
    public void setInitiator(Person initiator) 
    {
        this.initiator = initiator;
    }

    /**
     * Gets the responder.
     *
     * @return the responder
     */
    public Person getResponder() 
    {
        return responder;
    }

    /**
     * Sets the responder.
     *
     * @param responder the new responder
     */
    public void setResponder(Person responder) 
    {
        this.responder = responder;
    }

    /**
     * Gets the current topic.
     *
     * @return the current topic
     */
    public Topic getCurrentTopic() 
    {
        return currentTopic;
    }

    /**
     * Sets the current topic.
     *
     * @param currentTopic the new current topic
     */
    public void setCurrentTopic(Topic currentTopic) 
    {
        this.currentTopic = currentTopic;
    }
	
	/**
     * Gets the prev statements.
     *
     * @return the prev statements
     */
    public LinkedList<Statement> getPrevStatements() 
    {
        return prevStatements;
    }

    /**
     * Sets the prev statements.
     *
     * @param prevStatements the new prev statements
     */
    public void setPrevStatements(LinkedList<Statement> prevStatements) 
    {
        this.prevStatements = prevStatements;
    }
	
    /**
     * Gets the prev topics.
     *
     * @return the prev topics
     */
    public LinkedList<Topic> getPrevTopics() 
    {
        return prevTopics;
    }

    /**
     * Sets the prev topics.
     *
     * @param prevTopics the new prev topics
     */
    public void setPrevTopics(LinkedList<Topic> prevTopics) 
    {
        this.prevTopics = prevTopics;
    }
}
