package Conversation;

import java.util.Arrays;
import java.util.LinkedList;

import People.Person;

/**
 * The Class Statement.
 */
public class Statement 
{
    /**  The topic to which the statement is from. */
    protected Topic topic;
    
    /**  The actual words related to the statement. */
    protected String text;
    
	/** Base change in joy. */
	protected double delJoy;
	/** Base change in sadness. */
	protected double delSadness;
	/** Base change in anger. */
	protected double delAnger;
	/** Base change in fear. */
	protected double delFear;
	/** Base change in disgust. */
	protected double delDisgust;
	/** Base change in surprise. */
	protected double delSurprise;
	/** Base change in anticipation. */
	protected double delAnticipation;
	/** Base change in trust. */
	protected double delTrust;
	
	/** Base change in all emotions. Alternate, condensed version. */
	protected double[] delEmotions;
	
	/** The minimum level of personality trait OpennessToExperience required to say the statement. */
	protected double minOpennessToExperience;
	/** The minimum level of personality trait Conscientiousness required to say the statement. */
	protected double minConscientiousness;
	/** The minimum level of personality trait Extraversion required to say the statement. */
	protected double minExtraversion;
	/** The minimum level of personality trait Agreeableness required to say the statement. */
	protected double minAgreeableness;
	/** The minimum level of personality trait Neuroticism required to say the statement. */
	protected double minNeuroticism;
	
	/** The maximum level of personality trait OpennessToExperience required to say the statement. */
    protected double maxOpennessToExperience;
    /** The maximum level of personality trait Conscientiousness required to say the statement. */
    protected double maxConscientiousness;
    /** The maximum level of personality trait Extraversion required to say the statement. */
    protected double maxExtraversion;
    /** The maximum level of personality trait Agreeableness required to say the statement. */
    protected double maxAgreeableness;
    /** The maximum level of personality trait Neuroticism required to say the statement. */
    protected double maxNeuroticism;
    
	/** The minimum for all personality traits. Alternate, condensed version */
	protected double[] minPersonalityTraits;

	/** The maximum for all personality traits. Alternate, condensed version */
    protected double[] maxPersonalityTraits;
    
    /**  The topic this statement will transition to. */
    protected Topic nextTopic;
    
    /**  The string of the next topic's title. Used primarily for XML generation. */
    private String nextTopicTitle;
	
	/** 
	* Used during conversations to link a statement with a person that said it.
	*/
	private LinkedList<Person> whoSaidIt;
    
	/**
	 * Instantiates a new statement.
	 *
	 * @param topic the topic that the statement relates to
     * @param nextTopic the topic that the statement transitions to
	 * @param text the text
	 * @param delJoy the change in joy
	 * @param delSadness the change in sadness
	 * @param delAnger the change in anger
	 * @param delFear the change in fear
	 * @param delDisgust the change in disgust
	 * @param delSurprise the change in surprise
	 * @param delAnticipation the change in anticipation
	 * @param delTrust the change in trust
	 * @param minOpennessToExperience the minimum openness to experience required
	 * @param minConscientiousness the minimum conscientiousness required
	 * @param minExtraversion the minimum extraversion required
	 * @param minAgreeableness the minimum agreeableness required
	 * @param minNeuroticism the minimum neuroticism required
	 */
	public Statement(Topic topic, Topic nextTopic, String text, 
	        double delJoy, double delSadness, double delAnger,
			double delFear, double delDisgust, double delSurprise,
			double delAnticipation, double delTrust,
			double minOpennessToExperience, double maxOpennessToExperience,
			double minConscientiousness, double maxConscientiousness,
			double minExtraversion, double maxExtraversion,
			double minAgreeableness, double maxAgreeableness,
			double minNeuroticism, double maxNeuroticism) 
	{
	    this.topic = topic;
	    this.nextTopic = nextTopic;
	    this.nextTopicTitle= nextTopic.getTitle();
	    this.text = text;
		this.delJoy = delJoy;
		this.delSadness = delSadness;
		this.delAnger = delAnger;
		this.delFear = delFear;
		this.delDisgust = delDisgust;
		this.delSurprise = delSurprise;
		this.delAnticipation = delAnticipation;
		this.delTrust = delTrust;
		
		this.minOpennessToExperience = minOpennessToExperience;
		this.minConscientiousness = minConscientiousness;
		this.minExtraversion = minExtraversion;
		this.minAgreeableness = minAgreeableness;
		this.minNeuroticism = minNeuroticism;
		
		this.maxOpennessToExperience = maxOpennessToExperience;
        this.maxConscientiousness = maxConscientiousness;
        this.maxExtraversion = maxExtraversion;
        this.maxAgreeableness = maxAgreeableness;
        this.maxNeuroticism = maxNeuroticism;
        
		this.delEmotions = new double[8]; //TODO HARD-CODED = BAD. MORE MODULAR.
		this.minPersonalityTraits = new double[5]; //TODO HARD-CODED = BAD. MORE MODULAR.
		
		this.whoSaidIt = new LinkedList<Person>();
		
		// Add the current statement to the topic it's related to. 
		topic.addStatement(this);
	}
	
	/**
	 * Instantiates a new statement. OVERLOADED METHOD WITH NO NEW TOPIC.
	 *
	 * @param topic the topic that the statement relates to
	 * @param text the text
	 * @param delJoy the change in joy
	 * @param delSadness the change in sadness
	 * @param delAnger the change in anger
	 * @param delFear the change in fear
	 * @param delDisgust the change in disgust
	 * @param delSurprise the change in surprise
	 * @param delAnticipation the change in anticipation
	 * @param delTrust the change in trust
	 * @param minOpennessToExperience the minimum openness to experience required
	 * @param minConscientiousness the minimum conscientiousness required
	 * @param minExtraversion the minimum extraversion required
	 * @param minAgreeableness the minimum agreeableness required
	 * @param minNeuroticism the minimum neuroticism required
	 */
	public Statement(Topic topic, String text, 
            double delJoy, double delSadness, double delAnger,
            double delFear, double delDisgust, double delSurprise,
            double delAnticipation, double delTrust,
            double minOpennessToExperience, double maxOpennessToExperience,
            double minConscientiousness, double maxConscientiousness,
            double minExtraversion, double maxExtraversion,
            double minAgreeableness, double maxAgreeableness,
            double minNeuroticism, double maxNeuroticism) 
    {
        this.topic = topic;
        this.nextTopic = null; //TODO: THIS MAY BE A BAD IDEA SETTING NEXTTOPIC TO NULL. FIGURE OUT HOW TO HANDLE END OF CONVO.
        this.nextTopicTitle = ""; //empty so it appears in xml
        this.text = text;
        this.delJoy = delJoy;
        this.delSadness = delSadness;
        this.delAnger = delAnger;
        this.delFear = delFear;
        this.delDisgust = delDisgust;
        this.delSurprise = delSurprise;
        this.delAnticipation = delAnticipation;
        this.delTrust = delTrust;
        
        this.minOpennessToExperience = minOpennessToExperience;
        this.minConscientiousness = minConscientiousness;
        this.minExtraversion = minExtraversion;
        this.minAgreeableness = minAgreeableness;
        this.minNeuroticism = minNeuroticism;
        
        this.maxOpennessToExperience = maxOpennessToExperience;
        this.maxConscientiousness = maxConscientiousness;
        this.maxExtraversion = maxExtraversion;
        this.maxAgreeableness = maxAgreeableness;
        this.maxNeuroticism = maxNeuroticism;
        
        this.delEmotions = new double[8]; //TODO HARD-CODED = BAD. MORE MODULAR.
        this.minPersonalityTraits = new double[5]; //TODO HARD-CODED = BAD. MORE MODULAR.
        
		this.whoSaidIt = new LinkedList<Person>();
		
        // Add the current statement to the topic it's related to. 
        topic.addStatement(this);
    }
    
	/*TODO To use or not to use....
	//Overloaded constructor
	public Statement(double[] delEmotions, double[] minPersonalityTraits) {
		this.delEmotions = delEmotions;
		this.minPersonalityTraits = minPersonalityTraits;
	}
	 */
	
    
	// TODO Improve search functionality. This should really sort the 
	// list of people (while keeping intact their previous position... so we know
	// who said it first) and then search for person1 and person2 using 
	// "phonebook" search. Return the one that had the original location closer
	// to the end. Perhaps this isn't necessary if each statement in a conversation
	// is a new object, in which case there wouldn't be a million people in this list
	// of who has said this single statement. Need to test this.
	/**
	 * Gets the last person (either of the 2 inputed people) who said this statement
	 * last.
	 *
	 * @param person1 one of the people to search for
	 * @param person2 another of the people to search for
	 * @return the person who said the statement last
	 */
	public Person getWhoSaidItLast(Person person1, Person person2)
	{
		// Loop backwards through the list to get through the most
		// recent people. 
		for(int index = whoSaidIt.size() - 1; index >= 0; index--)
		{
			// TODO Can I use "==" here? Or do I need to compare names or something?
			// Should be the same object... right?
			if (whoSaidIt.get(index) == person1)
			{
				return person1;
			}
			else if (whoSaidIt.get(index) == person2)
			{
				return person2;
			}
		}
		
		// Neither.
		return null;
	}
	
	/**
	 * Gets the who said it first.
	 *
	 * @param person1 the person1
	 * @param person2 the person2
	 * @return the who said it first
	 */
	public Person getWhoSaidItFirst(Person person1, Person person2)
	{
		// Loop forwards through the list to get through the least
		// recent people. 
		for(int index = 0; index <= whoSaidIt.size() - 1; index++)
		{
			// TODO Can I use "==" here? Or do I need to compare names or something?
			// Should be the same object... right?
			if (whoSaidIt.get(index) == person1)
			{
				return person1;
			}
			else if (whoSaidIt.get(index) == person2)
			{
				return person2;
			}
		}
		
		// Neither.
		return null;
	}
	
	/**
	 * Adds the last person who said it.
	 *
	 * @param person the person
	 */
	public void addLastPersonWhoSaidIt(Person person)
	{
		whoSaidIt.addLast(person);
	}
	
	/**
	 * Gets the last person who said it.
	 *
	 * @return the last person who said it
	 */
	public Person getLastPersonWhoSaidIt()
	{
		return whoSaidIt.getLast();
	}
	
    /** 
	* Gets the person who said this statement.
	*
	* @return the person who said this statement.
	*/
	public LinkedList<Person> getWhoSaidIt()
	{
		return whoSaidIt;
	}
	
	/**
	 *  
	 * Sets the person who said this statement.
	 *
	 * @param whoSaidIt the new who said it
	 */
	public void setWhoSaidIt(LinkedList<Person> whoSaidIt)
	{
		this.whoSaidIt = whoSaidIt;
	}
	
	/**
	 * Gets the next topic title.
	 *
	 * @return the next topic title
	 */
	public String getNextTopicTitle() {
        return nextTopicTitle;
    }

    /**
     * Sets the next topic title.
     *
     * @param nextTopicTitle the new next topic title
     */
    public void setNextTopicTitle(String nextTopicTitle) {
        this.nextTopicTitle = nextTopicTitle;
    }

    /**
     * Gets the change in joy.
     *
     * @return the change in joy
     */
    public double getDelJoy() 
    {
        return delJoy;
    }
    
    
    /**
	 * Sets the change in joy.
	 *
	 * @param delJoy the new change in joy
	 */
	public void setDelJoy(double delJoy) 
	{
		this.delJoy = delJoy;
	}

	//
	/**
	 * Gets the change in sadness.
	 *
	 * @return the change in sadness
	 */
	public double getDelSadness() 
	{
		return delSadness;
	}
	
	/**
	 * Sets the change in sadness.
	 *
	 * @param delSadness the new change in sadness
	 */
	public void setDelSadness(double delSadness) 
	{
		this.delSadness = delSadness;
	}

	//
	/**
	 * Gets the change in anger.
	 *
	 * @return the change in anger
	 */
	public double getDelAnger() 
	{
		return delAnger;
	}
	
	/**
	 * Sets the change in anger.
	 *
	 * @param delAnger the new change in anger
	 */
	public void setDelAnger(double delAnger) 
	{
		this.delAnger = delAnger;
	}

	//
	/**
	 * Gets the change in fear.
	 *
	 * @return the change in fear
	 */
	public double getDelFear() 
	{
		return delFear;
	}
	
	/**
	 * Sets the change in fear.
	 *
	 * @param delFear the new change in fear
	 */
	public void setDelFear(double delFear) 
	{
		this.delFear = delFear;
	}

	//
	/**
	 * Gets the change in disgust.
	 *
	 * @return the change in disgust
	 */
	public double getDelDisgust() 
	{
		return delDisgust;
	}
	
	/**
	 * Sets the change in disgust.
	 *
	 * @param delDisgust the new change in disgust
	 */
	public void setDelDisgust(double delDisgust) 
	{
		this.delDisgust = delDisgust;
	}

	//
	/**
	 * Gets the change in surprise.
	 *
	 * @return the change in surprise
	 */
	public double getDelSurprise() 
	{
		return delSurprise;
	}
	
	/**
	 * Sets the change in surprise.
	 *
	 * @param delSurprise the new change in surprise
	 */
	public void setDelSurprise(double delSurprise) 
	{
		this.delSurprise = delSurprise;
	}

	//
	/**
	 * Gets the change in anticipation.
	 *
	 * @return the change in anticipation
	 */
	public double getDelAnticipation() 
	{
		return delAnticipation;
	}
	
	/**
	 * Sets the change in anticipation.
	 *
	 * @param delAnticipation the new change in anticipation
	 */
	public void setDelAnticipation(double delAnticipation) 
	{
		this.delAnticipation = delAnticipation;
	}

	//
	/**
	 * Gets the change in trust.
	 *
	 * @return the change in trust
	 */
	public double getDelTrust() 
	{
		return delTrust;
	}
	
	/**
	 * Sets the change in trust.
	 *
	 * @param delTrust the new change in trust
	 */
	public void setDelTrust(double delTrust)
	{
		this.delTrust = delTrust;
	}

	//
	/**
	 * Gets the change in emotions.
	 *
	 * @return the change in emotions
	 */
	public double[] getDelEmotions() 
	{
	    delEmotions = new double[8];
        //Create condensed version of emotions
        this.delEmotions[0] = this.delJoy;
        this.delEmotions[1] = this.delSadness;
        this.delEmotions[2] = this.delAnger;
        this.delEmotions[3] = this.delFear;
        this.delEmotions[4] = this.delDisgust;
        this.delEmotions[5] = this.delSurprise;
        this.delEmotions[6] = this.delAnticipation;
        this.delEmotions[7] = this.delTrust;
        
		return delEmotions;
	}
	
	/**
	 * Sets the change in emotions.
	 *
	 * @param delEmotions the new change in emotions
	 */
	public void setDelEmotions(double[] delEmotions) 
	{
		this.delEmotions = delEmotions;
	}

	//
	/**
	 * Gets the min openness to experience.
	 *
	 * @return the min openness to experience
	 */
	public double getMinOpennessToExperience()
	{
		return minOpennessToExperience;
	}
	
	/**
	 * Sets the min openness to experience.
	 *
	 * @param minOpennessToExperience the new min openness to experience
	 */
	public void setMinOpennessToExperience(double minOpennessToExperience) 
	{
		this.minOpennessToExperience = minOpennessToExperience;
	}

	//
	/**
	 * Gets the min conscientiousness.
	 *
	 * @return the min conscientiousness
	 */
	public double getMinConscientiousness()
	{
		return minConscientiousness;
	}
	
	/**
	 * Sets the min conscientiousness.
	 *
	 * @param minConscientiousness the new min conscientiousness
	 */
	public void setMinConscientiousness(double minConscientiousness) 
	{
		this.minConscientiousness = minConscientiousness;
	}

	//
	/**
	 * Gets the min extraversion.
	 *
	 * @return the min extraversion
	 */
	public double getMinExtraversion()
	{
		return minExtraversion;
	}
	
	/**
	 * Sets the min extraversion.
	 *
	 * @param minExtraversion the new min extraversion
	 */
	public void setMinExtraversion(double minExtraversion)
	{
		this.minExtraversion = minExtraversion;
	}

	//
	/**
	 * Gets the min agreeableness.
	 *
	 * @return the min agreeableness
	 */
	public double getMinAgreeableness() 
	{
		return minAgreeableness;
	}
	
	/**
	 * Sets the min agreeableness.
	 *
	 * @param minAgreeableness the new min agreeableness
	 */
	public void setMinAgreeableness(double minAgreeableness) 
	{
		this.minAgreeableness = minAgreeableness;
	}

	//
	/**
	 * Gets the min neuroticism.
	 *
	 * @return the min neuroticism
	 */
	public double getMinNeuroticism() 
	{
		return minNeuroticism;
	}
	
	/**
	 * Sets the min neuroticism.
	 *
	 * @param minNeuroticism the new min neuroticism
	 */
	public void setMinNeuroticism(double minNeuroticism) 
	{
		this.minNeuroticism = minNeuroticism;
	}

	public double getMaxOpennessToExperience() 
	{
        return maxOpennessToExperience;
    }

    public void setMaxOpennessToExperience(double maxOpennessToExperience) 
    {
        this.maxOpennessToExperience = maxOpennessToExperience;
    }

    public double getMaxConscientiousness() 
    {
        return maxConscientiousness;
    }

    public void setMaxConscientiousness(double maxConscientiousness) 
    {
        this.maxConscientiousness = maxConscientiousness;
    }

    public double getMaxExtraversion() 
    {
        return maxExtraversion;
    }

    public void setMaxExtraversion(double maxExtraversion) 
    {
        this.maxExtraversion = maxExtraversion;
    }

    public double getMaxAgreeableness() 
    {
        return maxAgreeableness;
    }

    public void setMaxAgreeableness(double maxAgreeableness) 
    {
        this.maxAgreeableness = maxAgreeableness;
    }

    public double getMaxNeuroticism() 
    {
        return maxNeuroticism;
    }

    public void setMaxNeuroticism(double maxNeuroticism) 
    {
        this.maxNeuroticism = maxNeuroticism;
    }

    /**
	 * Gets the min personality traits.
	 *
	 * @return the min personality traits
	 */
	public double[] getMinPersonalityTraits() 
	{
	    minPersonalityTraits = new double[5];
		//Create condensed version of personality traits
		this.minPersonalityTraits[0] = this.minOpennessToExperience;
		this.minPersonalityTraits[1] = this.minConscientiousness;
		this.minPersonalityTraits[2] = this.minExtraversion;
		this.minPersonalityTraits[3] = this.minAgreeableness;
		this.minPersonalityTraits[4] = this.minNeuroticism;
		return minPersonalityTraits;
	}
	
	/**
	 * Sets the min personality traits.
	 *
	 * @param minPersonalityTraits the new min personality traits
	 */
	public void setMinPersonalityTraits(double[] minPersonalityTraits) 
	{
		this.minPersonalityTraits = minPersonalityTraits;
		
		//make sure to change the individual variables as well as the
		//condensed version
		this.setMinOpennessToExperience(minPersonalityTraits[0]);
		this.setMinConscientiousness(minPersonalityTraits[1]);
		this.setMinExtraversion(minPersonalityTraits[2]);
		this.setMinAgreeableness(minPersonalityTraits[3]);
		this.setMinNeuroticism(minPersonalityTraits[4]);
	}

    /**
     * Gets the max personality traits.
     *
     * @return the max personality traits
     */
    public double[] getMaxPersonalityTraits() 
    {
        maxPersonalityTraits = new double[5];
        //Create condensed version of personality traits
        this.maxPersonalityTraits[0] = this.maxOpennessToExperience;
        this.maxPersonalityTraits[1] = this.maxConscientiousness;
        this.maxPersonalityTraits[2] = this.maxExtraversion;
        this.maxPersonalityTraits[3] = this.maxAgreeableness;
        this.maxPersonalityTraits[4] = this.maxNeuroticism;
        return maxPersonalityTraits;
    }
    
    /**
     * Sets the max personality traits.
     *
     * @param maxPersonalityTraits the new max personality traits
     */
    public void setMaxPersonalityTraits(double[] maxPersonalityTraits) 
    {
        this.maxPersonalityTraits = maxPersonalityTraits;
        
        //make sure to change the individual variables as well as the
        //condensed version
        this.setMaxOpennessToExperience(maxPersonalityTraits[0]);
        this.setMaxConscientiousness(maxPersonalityTraits[1]);
        this.setMaxExtraversion(maxPersonalityTraits[2]);
        this.setMaxAgreeableness(maxPersonalityTraits[3]);
        this.setMaxNeuroticism(maxPersonalityTraits[4]);
    }
    
	/**
	 * Gets the topic.
	 *
	 * @return the topic
	 */
	public Topic getTopic() {
        return topic;
    }

    /**
     * Sets the topic.
     *
     * @param topic the new topic
     */
    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    /**
     * Gets the next topic.
     *
     * @return the next topic
     */
    public Topic getNextTopic() {
        return nextTopic;
    }

    /**
     * Sets the topic.
     *
     * @param nextTopic the new next topic
     */
    public void setNextTopic(Topic nextTopic) {
        this.nextTopic = nextTopic;
        this.nextTopicTitle = nextTopic.getTitle();
    }
    
    /**
     * Gets the text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text.
     *
     * @param text the new text
     */
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Statement [topic=" + topic + ", text=" + text + ", delJoy="
                + delJoy + ", delSadness=" + delSadness + ", delAnger="
                + delAnger + ", delFear=" + delFear + ", delDisgust="
                + delDisgust + ", delSurprise=" + delSurprise
                + ", delAnticipation=" + delAnticipation + ", delTrust="
                + delTrust + ", delEmotions=" + Arrays.toString(delEmotions)
                + ", minOpennessToExperience=" + minOpennessToExperience
                + ", minConscientiousness=" + minConscientiousness
                + ", minExtraversion=" + minExtraversion
                + ", minAgreeableness=" + minAgreeableness
                + ", minNeuroticism=" + minNeuroticism
                + ", maxOpennessToExperience=" + maxOpennessToExperience
                + ", maxConscientiousness=" + maxConscientiousness
                + ", maxExtraversion=" + maxExtraversion
                + ", maxAgreeableness=" + maxAgreeableness
                + ", maxNeuroticism=" + maxNeuroticism
                + ", minPersonalityTraits="
                + Arrays.toString(minPersonalityTraits)
                + ", maxPersonalityTraits="
                + Arrays.toString(maxPersonalityTraits) + ", nextTopic="
                + nextTopic + ", nextTopicTitle=" + nextTopicTitle
                + ", whoSaidIt=" + whoSaidIt + "]";
    }
}
