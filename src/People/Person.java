package People;

import java.util.Arrays;
import java.util.LinkedList;

import PersonalityTraits.*;
import Conversation.*;
import Emotions.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Person.
 */
public class Person 
{
    
    /**  The name of the person. */
    protected String name;
    
	/** The emotions: Joy, Sadness, Anger, Fear, Trust, Surprise, Anticipation, Disgust. */
	protected Emotion[] emotions;
	
	/** The personality traits: OpennessToExperience, Conscientiousness, Extraversion, Agreeableness, Neuroticism. */
	protected PersonalityTrait[] personalityTraits;
	
	/** Array of modifiers for all the emotions(combines all personality traits modifiers). */
	protected double[] totalEmotionModifiers; 
	
	/** The number of personality traits. */
 	protected int numTraits;
	
	/**
	 * Constructor for Person, initializes all emotions and personality traits to default.
	 *
	 * @param name the name
	 */
	public Person(String name)
	{
	    this.name = name;
		//initialize emotions with intensities of 0
		this.emotions = new Emotion[]{new Joy(0), new Sadness(0), new Anger(0),
				new Fear(0), new Disgust(0), new Surprise(0), new Anticipation(0),
				new Trust(0)}; 
		//initialize personality traits to intensities of .5 (average)
		this.personalityTraits = new PersonalityTrait[]{ new OpennessToExperience(.5),
				new Conscientiousness(.5), new Extraversion(.5), new Agreeableness(.5),
				new Neuroticism(.5)
		};
		this.totalEmotionModifiers = new double[] {1, 1, 1, 1, 1, 1, 1, 1}; //initialize
		this.numTraits = personalityTraits.length; 
	}
	
	/**
	 * Changes the emotions of Person given with the delta array given.
	 *
	 * @param deltaEmotions the array of raw emotion changes desired (will be
	 * multiplied by the modifiers due to personality traits)
	 */
	public void updateEmotions(double[] deltaEmotions)
	{	
		calculateEmotionModifiers();
		
		//Check for correct size of array
		if (deltaEmotions.length != 8)
		{
		    // TODO Show error dialog, don't throw error.
			throw new NullPointerException("\nError: Number of emotion modifiers incorrect. "
								+ "No update on...\n"
								+ this.toString());
		}
		
		//update all the emotions by changing the intensity with the inputed delta array * modifier
		for (int index = 0; index < 8; index++)
		{
			//set the change in emotion by multiplying the desired emotion change by the total 
			//modifier for that emotion(determined by all of the personality trait modifiers combined)
			this.emotions[index].changeIntensity(deltaEmotions[index] * totalEmotionModifiers[index]); 
		}
	}
	
	/**
	 * Calculates the emotional modifiers by combining all the personality train
	 * modifiers. No output, but alters the global totalEmotionModifiers variable. 
	 */
	protected void calculateEmotionModifiers()
	{
		// Loop through each of the emotions.
		for (int index = 0; index < emotions.length; index++)
		{
		    // Clear current modifier.
		    totalEmotionModifiers[index] = 0;
		    
			// Loop through all of the personality traits to add up their modifiers for emotion
			for(int index1 = 0; index1 < personalityTraits.length; index1++)
			{
				// Add all the personality modifiers to get a single modifier
				totalEmotionModifiers[index] += personalityTraits[index1].getEmotionModifiers()[index]; 
			}
			
			// Average the multipliers together.
			totalEmotionModifiers[index] = totalEmotionModifiers[index]/personalityTraits.length; 
			// TODO Is there a better way to calculate the emotional modifiers? ^^^^^^
		}
	}
	
	/**
	 * Determines the response to the statement inputed. Works by filtering the pool 
	 * of options down.
	 *
	 * @param statementPool the statement pool
	 * @return the response
	 */
	@SuppressWarnings("null")
	public Statement getResponse(LinkedList<Statement> statementPool)
	{
		Statement response = null; //TODO This shouldn't be null when method's finished
		statementPool = getPossibleResponses(statementPool);
		
		//TODO Pick response from possible responses (based on desired outcome???)
		
		return statementPool.get(0); //TODO SHOULD BE RESPONSE, DID THIS FOR DEBUGGIN
	}
	
	/**
	 * Checks for the possible responses of Statements based on a pool
	 * of choices. Works by filtering the pool down.
	 *
	 * @param statementPool the statement pool
	 * @return the possible responses
	 */
	private LinkedList<Statement> getPossibleResponses(LinkedList<Statement> statementPool)
	{
		LinkedList<Statement> possibleResponses = new LinkedList<Statement>(); //array to hold the filtered pool by possible
		//responses based on min personality requirements
		
		boolean requirementsMet; // used in loops to check for all requirements

		// for all the possible statements
		for (int index = 0; index < statementPool.size(); index++) 
		{
			requirementsMet = true; // assume innocent until proven guilty
			
			// check for the min and max requirements of all personality traits
			for (int traits = 0; traits < numTraits; traits++) 
			{	
				// check that EVERY personality trait meets the minimum
				// requirement for the statement
				if (this.personalityTraits[traits].getIntensity() > 
						(statementPool.get(index).getMinPersonalityTraits())[traits]
						&& requirementsMet) 
				{
				    if (this.personalityTraits[traits].getIntensity() < 
                    (statementPool.get(index).getMaxPersonalityTraits())[traits]) 
				    {
				        possibleResponses.add(statementPool.get(index));
				    }
				} 
				else // if one min requirement isn't met, don't add statement
				{
					requirementsMet = false;
				}
			}
		}
		return possibleResponses;
	}
	
	
	//Getters and Setters
	
	
	/**
	 * Gets the emotions.
	 *
	 * @return the emotions
	 */
	public Emotion[] getEmotions() 
	{
		return emotions;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the personality traits.
     *
     * @return the personality traits
     */
    public PersonalityTrait[] getPersonalityTraits() {
        return personalityTraits;
    }

    /**
     * Sets the personality traits.
     *
     * @param personalityTraits the new personality traits
     */
    public void setPersonalityTraits(PersonalityTrait[] personalityTraits) {
        this.personalityTraits = personalityTraits;
    }

    /**
     * Gets the total emotion modifiers.
     *
     * @return the total emotion modifiers
     */
    public double[] getTotalEmotionModifiers() {
        return totalEmotionModifiers;
    }

    /**
     * Sets the total emotion modifiers.
     *
     * @param totalEmotionModifiers the new total emotion modifiers
     */
    public void setTotalEmotionModifiers(double[] totalEmotionModifiers) {
        this.totalEmotionModifiers = totalEmotionModifiers;
    }

    /**
     * Gets the num traits.
     *
     * @return the num traits
     */
    public int getNumTraits() {
        return numTraits;
    }

    /**
     * Sets the num traits.
     *
     * @param numTraits the new num traits
     */
    public void setNumTraits(int numTraits) {
        this.numTraits = numTraits;
    }

    /**
	 * Sets the emotions.
	 *
	 * @param emotions the new emotions
	 */
	public void setEmotions(Emotion[] emotions) 
	{
		this.emotions = emotions;
	}
	//
	
	/**
	 * Gets the emotion modifiers.
	 *
	 * @return the emotion modifiers
	 */
	public double[] getEmotionModifiers() 
	{
		return totalEmotionModifiers;
	}
	
	/**
	 * Sets the emotion modifiers.
	 *
	 * @param emotionModifiers the new emotion modifiers
	 */
	public void setEmotionModifiers(double[] emotionModifiers) 
	{
		this.totalEmotionModifiers = emotionModifiers;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "------------Person----------- \nEmotions\n " + 
				Arrays.toString(emotions).replace(",", "").
					replace("[", "").replace("]", "")
				+ "\nPersonality Traits\n " + 
				Arrays.toString(personalityTraits).replace(",", "").
					replace("[", "").replace("]", "")
				+ "-----------------------------\n";
	}
}
