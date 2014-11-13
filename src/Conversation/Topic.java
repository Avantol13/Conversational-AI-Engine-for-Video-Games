package Conversation;

import java.util.LinkedList;

// TODO: Auto-generated Javadoc
/**
 * This defines an individual "topic" of conversation. Each topic has a title 
 * and corresponding statements associated with it.
 */
public class Topic 
{
    /** The title of the topic. */
    protected String title;
    
    /** The statements under the topic. */
    protected LinkedList<Statement> statements;
    
    /** The topics that can be accessed from any of statements under this topic. */
    protected LinkedList<Topic> relatedTopics;
    
    /**
     * Instantiates a new topic.
     *
     * @param title the title
     */
    public Topic(String title)
    {
        this.title = title;
        this.statements = new LinkedList<Statement>();
        this.relatedTopics = new LinkedList<Topic>();
    }
    
    /**
     * Instantiates a new topic.
     *
     * @param title the title
     * @param statements the statements associated
     */
    public Topic(String title, LinkedList<Statement> statements)
    {
        this.title = title;
        this.statements = statements;
        
        // Let's add all the related topics by looping through the statements and 
        // grabbing the topics they lead to
        for (int index = 0; index < statements.size(); index++)
        {
            //if the topic is already in the related topics, don't try to add it again
            if (!this.relatedTopics.contains(statements.get(index).getNextTopic()))
            {
                addRelatedTopic(statements.get(index).getNextTopic()); 
            }
        }
    }
    
    /**
     * Adds the specified topic.
     *
     * @param topic the topic to add
     */
    private void addRelatedTopic(Topic topic)
    {
        this.relatedTopics.add(topic);
    }
    
    /**
     * Removes the specified topic.
     *
     * @param topic the topic to remove
     */
    private void removeRelatedTopic(Topic topic)
    {
        this.relatedTopics.remove(topic);
    }
    
    /**
     * Adds the specified topics.
     *
     * @param topics the topics to add
     */
    private void addRelatedTopics(LinkedList<Topic> topics)
    {
        this.relatedTopics.addAll(topics);
    }
    
    /**
     * Removes the specified topics.
     *
     * @param topics the topics to remove
     */
    private void removeRelatedTopics(LinkedList<Topic> topics)
    {
        this.relatedTopics.removeAll(topics);
    }
    
    /**
     * Adds the specified statement.
     *
     * @param statement the statement to add
     */
    public void addStatement(Statement statement)
    {
        this.statements.add(statement);
     
        //if the topic is already in the related topics, don't try to add it again
        if (!this.relatedTopics.contains(statement.getNextTopic()))
        {
            addRelatedTopic(statement.getNextTopic()); 
        }
    }
    
    /**
     * Removes the specified statement.
     *
     * @param statement the statement to remove
     */
    public void removeStatement(Statement statement)
    {
        this.statements.remove(statement);
        
        //if the topic is in the related topics, remove it
        if (this.relatedTopics.contains(statement.getNextTopic()))
        {
            removeRelatedTopic(statement.getNextTopic()); 
        }
    }
    
    /**
     * Adds the specified statements.
     *
     * @param statements the statements to add
     */
    public void addStatements(LinkedList<Statement> statements)
    {
        this.statements.addAll(statements);
        
        // Let's add all the related topics by looping through the statements and 
        // grabbing the topics they lead to
        for (int index = 0; index < statements.size(); index++)
        {
            //if the topic is already in the related topics, don't try to add it again
            if (!this.relatedTopics.contains(statements.get(index).getNextTopic()))
            {
                addRelatedTopic(statements.get(index).getNextTopic()); 
            }
        }
    }
    
    /**
     * Removes the specified statements.
     *
     * @param statements the statements to remove
     */
    public void removeStatements(LinkedList<Statement> statements)
    {
        this.statements.removeAll(statements);
        
        // Let's remove all the related topics by looping through the statements and 
        // dropping the topics they lead to
        for (int index = 0; index < statements.size(); index++)
        {
            //if the topic is in the related topics, remove it
            if (this.relatedTopics.contains(statements.get(index).getNextTopic()))
            {
                removeRelatedTopic(statements.get(index).getNextTopic()); 
            }
        }
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the statements.
     *
     * @return the statements
     */
    public LinkedList<Statement> getStatements() {
        return statements;
    }

    /**
     * Sets the statements.
     *
     * @param statements the new statements
     */
    public void setStatements(LinkedList<Statement> statements) {
        this.statements = statements;
    }
    
    
}
