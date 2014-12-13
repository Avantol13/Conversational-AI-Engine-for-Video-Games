package Application;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.thoughtworks.xstream.XStream;

import Conversation.Conversation;
import Conversation.Statement;
import Conversation.Topic;
import Emotions.Emotion;
import People.Person;
import PersonalityTraits.PersonalityTrait;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationData.
 */
public class ApplicationData 
{

    /** The people. */
    protected LinkedList<Person> people;
    
    /** The topics. */
    protected LinkedList<Topic> topics;
    
    /** The original current conversation. */
    private Conversation originalConversation;
    
    /** The current conversation taking place. */
    private Conversation conversation;
    
    /** The left person. */
    private Person leftPerson;
    
    /** The right person. */
    private Person rightPerson;
    
    /** The application. */
    private Application application;
    
    /**
     * Create the application.
     *
     * @param application the application
     * @param topics the topics
     * @param people the people
     * @param conversation the conversation
     */
    public ApplicationData(Application application, LinkedList<Topic> topics, 
            LinkedList<Person> people, Conversation conversation) 
    {
        this.topics = topics;
        this.people = people;
        this.conversation = conversation;
        this.originalConversation = conversation;
        this.leftPerson = conversation.getInitiator();
        this.rightPerson = conversation.getResponder();
        this.application = application;
    }
    
    /**
     * Create the application without initializing most fields.
     * Be careful with this, NullPointerExceptions are inevitable.
     * TODO Remove need for this overrode constructor, require use to have all information
     */
    public ApplicationData() 
    {
        // Do nothing. Everything is null.
    }
    
    /**
     * TODO REMOVE... Was used for creating initial XML files. Creates the statements.
     *
     * @return Returns a linked list containing a bunch of fake statements
     * used for debugging purposes.
     */
    static LinkedList<Statement> createStatements()
    {
        Topic topic = new Topic("Fruit");
        
        //create statements
        Statement statement0 = new Statement(topic, 
                "I love apples.",
                .1, .1, .1, .1, .1, .1, .1, .1,
                .5, 1.0,
                .5, 1.0,
                .5, 1.0,
                .5, 1.0,
                .5, 1.0);
        
        Statement statement1 = new Statement(topic,
                "Orange you glad to see me?",
                .1, .1, .1, .1, .1, .1, .1, .1,
                .5, 1.0,
                .5, 1.0,
                .5, 1.0,
                .5, 1.0,
                .5, 1.0);
        
        Statement statement2 = new Statement(topic,
                "Limes and lemons and stuff.",
                .1, .1, .1, .1, .1, .1, .1, .1,
                .5, 1.0,
                .5, 1.0,
                .5, 1.0,
                .5, 1.0,
                .5, 1.0);
      
        Statement statement3 = new Statement(topic, 
                "Raspberries is spelled funny.",
                .1, .1, .1, .1, .1, .1, .1, .1,
                .5, 1.0,
                .5, 1.0,
                .5, 1.0,
                .5, 1.0,
                .5, 1.0);
        
        Statement statement4 = new Statement(topic,
                "You look like a goofy banana.",
                .1, .1, .1, .1, .1, .1, .1, .1,
                .5, 1.0,
                .5, 1.0,
                .5, 1.0,
                .5, 1.0,
                .5, 1.0);
        
        Statement statement5 = new Statement(topic,
                "I hate pineapples.",
                .1, .1, .1, .1, .1, .1, .1, .1,
                .5, 1.0,
                .5, 1.0,
                .5, 1.0,
                .5, 1.0,
                .5, 1.0);
        
        LinkedList<Statement> statements = new LinkedList<Statement>();
        statements.add(statement0);
        statements.add(statement1);
        statements.add(statement2);
        statements.add(statement3);
        statements.add(statement4);
        statements.add(statement5);
        
        return statements;
    }
	
    /**
     * Imports topics by prompting for user input of directory and 
     * retrieving all XML files in directory as Topic objects.
     *
     * @return true, if successful
     */
    public boolean importTopics()
    {
        LinkedList<Topic> topicsFound = new LinkedList<Topic>();
        
        /** The directory containing the XML files representing the topics.*/
        File pathToTopics;
        
        /** All the XML files in the directory (all the topics)*/
        LinkedList<File> files = new LinkedList<File>();
        
        /** The window that appears to choose the directory for the XML files for the topics. */
        JFileChooser chooser = new JFileChooser();
        chooser.setApproveButtonText("Select Directory");
        chooser.setDialogTitle("XML Directory Select");
        // Set current directory as project path.
        chooser.setCurrentDirectory(new File (Paths.get("").toAbsolutePath().toString()));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        Integer opt = chooser.showOpenDialog(chooser);
        
        try
        {
            // Get the directory and then loop through the files to get just the xml's.
            pathToTopics = new File(chooser.getSelectedFile().getAbsolutePath());
            File[] allFiles = pathToTopics.listFiles();
            
            for (int index = 0; index < allFiles.length; index++)
            {
                if (allFiles[index].getName().toLowerCase().endsWith(".xml"))
                {
                   files.add(allFiles[index]);
                }
				else
				{
					// .txt files are okay, anything else is an error.
					if (!(allFiles[index].getName().toLowerCase().endsWith(".txt")))
					{
						return false;
					}
				}
            }
            
            // TODO Try to use linked list for files.
            // allFiles = listAllXML(pathToTopics, files);
            
        }// If nothing was selected/ window was closed or cancelled. 
        catch (NullPointerException exc)
        {
            return false;
        }
        
        // Now loop through the files we found and instantiate some topics. Kewl beanz. 
        for (int index = 0; index < files.size(); index++)
        {
            // Set up xml generation.
            XStream xstream = new XStream();
            xstream.ignoreUnknownElements();
            
            // Settings for Topic class
            xstream.alias("topic", Topic.class);
            xstream.useAttributeFor(Topic.class, "title");
            xstream.omitField(Topic.class, "relatedTopics");
            
            // Settings for statement
            xstream.alias("statement", Statement.class);
            xstream.useAttributeFor(Statement.class, "text");
            xstream.omitField(Statement.class, "topic");
            xstream.omitField(Statement.class, "delEmotions");
            xstream.omitField(Statement.class, "minPersonalityTraits");
            xstream.omitField(Statement.class, "maxPersonalityTraits");
            xstream.omitField(Statement.class, "nextTopic");
            xstream.omitField(Statement.class, "whoSaidIt");
            xstream.aliasField("nextTopic", Statement.class, "nextTopicTitle");
            
            try
            {
                // Get the topic from the current XML file. 
                Topic newTopic = (Topic)xstream.fromXML(files.get(index));
          
                // Add the topic to the list of topics.
                topicsFound.add(newTopic);
                
                for (int count = 0; count < newTopic.getStatements().size(); count++)
                {
                    /** The current statement within the loop for all statements. */
                    Statement currentStatement = newTopic.getStatements().get(count);
                    Topic nextTopic = searchTopic(currentStatement.getNextTopicTitle(), topicsFound);
                    
                    // If you find a topic that matches, set it as the next topic.
                    if (nextTopic != null)
                    {
                        currentStatement.setNextTopic(nextTopic);
                    }
                    // Else, we'll wait. The next topic may not have been created yet.
                }
            }
            catch (com.thoughtworks.xstream.mapper.CannotResolveClassException exc)
            {
                return false;
            }
        }
        
        // Now we have to loop through the topics we've created from the files
        // and make sure all the nextTopic's are populated for all the statements. 
        // They may not have been because the nextTopic within a topic may have been
        // created AFTER the said topic (so there's no way to reference it).
        for (int index = 0; index < topicsFound.size(); index++)
        {
            /** The current topic in the loop. */
            Topic currentTopic = topicsFound.get(index);
            
            for (int count = 0; count < currentTopic.getStatements().size(); count++)
            {
                /** The current statement in the loop. */
                Statement currentStatement = currentTopic.getStatements().get(count);
                
                // Set the topic.
                currentStatement.setTopic(currentTopic);
                
                // Initialize who said it. It's null because the objects constructor was
                // never actually called, the xstream just populated the values it knew.
                // Thus, we need to initialize this.
                currentStatement.setWhoSaidIt(new LinkedList<Person>());
                
                // If there is no next topic specified, we need to do it.
                if (currentStatement.getNextTopic() == null)
                {
                    // Get the next topic by searching all the topics for the one with the
                    // same title as the topic title specified by the XML.
                    Topic nextTopic = searchTopic(currentStatement.getNextTopicTitle(), topicsFound);
                    
                    // If you find a topic that matches, set it as the next topic.
                    if (nextTopic != null)
                    {
                        currentStatement.setNextTopic(nextTopic);
                    }
                    else
                    {
                        return false;
                        // We have a problem. There exists no topic as the one specified.
                        // TODO: Show error. There doesn't exist a topic with 
                        // title <topicsFound.get(count).getNextTopicTitle() within 
                        // topic <topicsFound.get(count).getTitle()>
                    }
                }
            }
        }
                
        topics = topicsFound;
        return true;
    }
	
    /**
     * Creates the xml files for each of the given topics.
     *
     * @return true, if successful
     */
    public boolean exportTopics()
    {
        // Set up xml generation.
        XStream xstream = new XStream();
        xstream.ignoreUnknownElements();
        
        // Settings for Topic class
        xstream.alias("topic", Topic.class);
        xstream.useAttributeFor(Topic.class, "title");
        xstream.omitField(Topic.class, "relatedTopics");
        
        // Settings for statement
        xstream.alias("statement", Statement.class);
        xstream.useAttributeFor(Statement.class, "text");
        xstream.omitField(Statement.class, "topic");
        xstream.omitField(Statement.class, "delEmotions");
        xstream.omitField(Statement.class, "minPersonalityTraits");
        xstream.omitField(Statement.class, "maxPersonalityTraits");
        xstream.omitField(Statement.class, "nextTopic");
        xstream.omitField(Statement.class, "whoSaidIt");
        xstream.aliasField("nextTopic", Statement.class, "nextTopicTitle");
        
        // Loop through all the topics and create an XML file for each one.
        for (int index = 0; index < topics.size(); index++)
        {
            //TODO: Finish XML test code
            FileWriter filewriter = null;
            try 
            {
                filewriter = new FileWriter(topics.get(index).getTitle() + ".xml");
            } 
			catch (IOException e) 
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
            xstream.toXML(topics.get(index), filewriter);
        }
        return true;
    }
    
	/**
     * Import people.
     * 
     * @return true, if successful
     */
    public boolean importPeople()
    {
        ////TODO remove
        this.people = new LinkedList<Person>();
        people.add(new Person("Mr. NPC"));
        people.add(new Person("Dr. NPC"));
        exportPeople();
        ////
        
		LinkedList<Person> peopleFound = new LinkedList<Person>();
        
        /** The directory containing the XML files representing the people.*/
        File pathToPeople;
        
        /** All the XML files in the directory (all the people)*/
        LinkedList<File> files = new LinkedList<File>();
        
        /** The window that appears to choose the directory for the XML files for the people. */
        JFileChooser chooser = new JFileChooser();
        chooser.setApproveButtonText("Select Directory");
        chooser.setDialogTitle("XML Directory Select");
        // Set current directory as project path.
        chooser.setCurrentDirectory(new File (Paths.get("").toAbsolutePath().toString()));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        Integer opt = chooser.showOpenDialog(chooser);
        
        try
        {
            // Get the directory and then loop through the files to get just the xml's.
            pathToPeople = new File(chooser.getSelectedFile().getAbsolutePath());
            File[] allFiles = pathToPeople.listFiles();
            
            for (int index = 0; index < allFiles.length; index++)
            {
                if (allFiles[index].getName().toLowerCase().endsWith(".xml"))
                {
                   files.add(allFiles[index]);
                }
				else
				{
					// .txt files are okay, anything else is an error.
					if (!(allFiles[index].getName().toLowerCase().endsWith(".txt")))
					{
						return false;
					}
				}
            }
            
            // TODO Try to use linked list for files.
            // allFiles = listAllXML(pathToPeople, files);
            
        }// If nothing was selected/ window was closed or cancelled. 
        catch (NullPointerException exc)
        {
            return false;
        }
        
        // Now loop through the files we found and instantiate some people. Kewl beanz. 
        for (int index = 0; index < files.size(); index++)
        {
            // Set up xml generation.
            XStream xstream = new XStream();
            xstream.ignoreUnknownElements();
            
            // Settings for Person class
            xstream.alias("person", Person.class);
            xstream.useAttributeFor(Person.class, "name");
            xstream.omitField(Person.class, "totalEmotionModifiers");
            xstream.omitField(Person.class, "numTraits");
			
            // Settings for PersonalityTrait class
            xstream.alias("PersonalityTrait", PersonalityTrait.class);
            xstream.omitField(PersonalityTrait.class, "name");
            xstream.omitField(PersonalityTrait.class, "emotionModifiers");
            
			// Settings for Emotion class
            xstream.alias("Emotion", Emotion.class);
            xstream.omitField(Emotion.class, "name");
			
            try
            {
                // Get the Person from the current XML file. 
                Person newPerson = (Person)xstream.fromXML(files.get(index));
                newPerson.initialize();
                // Add the Person to the list of people.
                peopleFound.add(newPerson);
            }
            catch (com.thoughtworks.xstream.mapper.CannotResolveClassException exc)
            {
                return false;
            }
        }
        
		this.people = peopleFound;
        return true;
    }
    
	/**
     * Creates the xml files for each of the given people.
     *
     * @return true, if successful
     */
    public boolean exportPeople()
    {
        // Set up xml generation.
        XStream xstream = new XStream();
        xstream.ignoreUnknownElements();
        
        // Settings for Person class
        xstream.alias("person", Person.class);
        xstream.useAttributeFor(Person.class, "name");
        xstream.omitField(Person.class, "totalEmotionModifiers");
        xstream.omitField(Person.class, "numTraits");
        
        // Settings for PersonalityTrait class
        xstream.alias("PersonalityTrait", PersonalityTrait.class);
        xstream.omitField(PersonalityTrait.class, "name");
        xstream.omitField(PersonalityTrait.class, "emotionModifiers");
        
        // Settings for Emotion class
        xstream.alias("Emotion", Emotion.class);
        xstream.omitField(Emotion.class, "name");
        
        // Loop through all the people and create an XML file for each one.
        for (int index = 0; index < people.size(); index++)
        {
            FileWriter filewriter = null;
            try 
            {
                filewriter = new FileWriter(people.get(index).getName() + ".xml");
            } 
			catch (IOException e) 
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
            xstream.toXML(people.get(index), filewriter);
        }
        return true;
    }
	
    // TODO Make this return a linked list
    /*
    public static File[] listAllXML(File pathToFiles, File[] allFiles) 
    {
        // Get the directory and then loop through the files to get just the xml's.
        allFiles = pathToTopics.listFiles();
        
        // Loop through files in directory.
        for (int index = 0; index < allFiles.length; index++)
        {
            if (allFiles[index].getName().toLowerCase().endsWith(".xml"))
            {
                allFiles.add(allFiles[index]);
            }
            else if (allFiles[index].isDirectory())
            {
                allFiles = listAllXML(allFiles[index], allFiles) 
            }
        }
        
        return allFiles;
    }
    */

    /**
     * Searches the list of people for the person specified.
     *
     * @param name The name of the person to search for
     * @param people the people
     * @return the person with the same name as the input
     */
    public Person searchPerson(String name, LinkedList<Person> people)
    {
        for(int index = 0; index < people.size(); index++)
        {
            if (people.get(index).getName().equals(name))
            {
                return people.get(index);
            }
        }
        return null;
    }
    
    /**
     * Searches the list of topics for the topic specified.
     *
     * @param title the title
     * @param topics the topics
     * @return the topic with the same title as the input
     */
    public Topic searchTopic(String title, LinkedList<Topic> topics)
    {
        for(int index = 0; index < topics.size(); index++)
        {
            if (topics.get(index).getTitle().equals(title))
            {
                return topics.get(index);
            }
        }
        return null;
    }

    /**
     * Gets the people.
     *
     * @return the people
     */
    public LinkedList<Person> getPeople() 
    {
        return people;
    }

    /**
     * Sets the people.
     *
     * @param people the new people
     */
    public void setPeople(LinkedList<Person> people) 
    {
        this.people = people;
    }

    /**
     * Gets the topics.
     *
     * @return the topics
     */
    public LinkedList<Topic> getTopics() 
    {
        return topics;
    }

    /**
     * Sets the topics.
     *
     * @param topics the new topics
     */
    public void setTopics(LinkedList<Topic> topics) 
    {
        this.topics = topics;
    }

    /**
     * Gets the original conversation.
     *
     * @return the original conversation
     */
    public Conversation getOriginalConversation() 
    {
        return originalConversation;
    }

    /**
     * Gets the conversation.
     *
     * @return the conversation
     */
    public Conversation getCurrentConversation() 
    {
        return conversation;
    }

    /**
     * Sets the conversation.
     *
     * @param conversation the new conversation
     */
    public void newConversation(Conversation conversation) 
    {
        this.conversation = conversation;
        this.originalConversation = conversation;
    }

    /**
     * Gets the left person.
     *
     * @return the left person
     */
    public Person getLeftPerson() 
    {
        return leftPerson;
    }

    /**
     * Sets the left person.
     *
     * @param leftPerson the new left person
     */
    public void setLeftPerson(Person leftPerson) 
    {
        this.leftPerson = leftPerson;
    }

    /**
     * Gets the right person.
     *
     * @return the right person
     */
    public Person getRightPerson() 
    {
        return rightPerson;
    }

    /**
     * Sets the right person.
     *
     * @param rightPerson the new right person
     */
    public void setRightPerson(Person rightPerson) 
    {
        this.rightPerson = rightPerson;
    }

    /**
     * Gets the application.
     *
     * @return the application
     */
    public Application getApplication() 
    {
        return application;
    }

    /**
     * Sets the application.
     *
     * @param application the new application
     */
    public void setApplication(Application application) 
    {
        this.application = application;
    }
    
    
 }