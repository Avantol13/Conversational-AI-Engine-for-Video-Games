package People;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

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
	
	/** This value allows for the adjustment of the emotional degradation depending on 
	    how quickly you are updating the people's emotions. Initial assumption: update
		every 6 seconds = 1.00 */
	protected double updateFrequencyMultiplier = 1.0;
	
	/** Array of values that represent the degradation/decreasing of emotion intensity. */
	protected double[] emotionDegradationValues;
	
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
		this.emotionDegradationValues = new double[] {0.0001, 0.0001, 0.0001, 0.0001, 
			0.0001, 0.0001, 0.0001, 0.0001}; //initialize
		updateFrequencyMultiplier = 1.0;
	}
	
	/**
	 * Initializes the emotion modifiers and other variables. Necessary when importing people
	 * from XML because xstream does not call the default constructor.
	 * 
	 */
	public void initialize()
	{
        this.totalEmotionModifiers = new double[] {1, 1, 1, 1, 1, 1, 1, 1}; //initialize
		this.emotionDegradationValues = new double[] {0.0001, 0.0001, 0.0001, 0.0001, 
			0.0001, 0.0001, 0.0001, 0.0001}; //initialize
        this.personalityTraits = new PersonalityTrait[]{ 
                new OpennessToExperience(personalityTraits[0].getIntensity()),
                new Conscientiousness(personalityTraits[1].getIntensity()), 
                new Extraversion(personalityTraits[2].getIntensity()), 
                new Agreeableness(personalityTraits[3].getIntensity()),
                new Neuroticism(personalityTraits[4].getIntensity())};
        updateFrequencyMultiplier = 1.0;
	}
	
	/**
	 * Changes the emotions of Person given with the delta array given.
	 *
	 * @param deltaEmotions the array of raw emotion changes desired (will be
	 * multiplied by the modifiers due to personality traits)
	 */
	public void updateEmotions(double[] deltaEmotions)
	{	
		double[] finalDeltaEmotions = new double[8];
		
		// Calculate the modifiers for increasing emotions.
		calculateEmotionModifiers();
		
        // Adjust the deltas based on inverse relationships between requested changes.
		deltaEmotions = adjustDeltas(deltaEmotions);
        
		//Check for correct size of array
		if (deltaEmotions.length != 8)
		{
		    // TODO Show error dialog, don't throw error.
			throw new NullPointerException("\nError: Number of emotion modifiers incorrect. "
								+ "No update on...\n"
								+ this.toString());
		}
		
		// Calculate the change in emotions after the modifiers take effect. 
		for (int index = 0; index < 8; index++)
		{
			// Get final values for the delta for each emotion (based on modifiers)
			finalDeltaEmotions[index] = deltaEmotions[index] * totalEmotionModifiers[index];
		}
		
		// Calculate the values that will be subtracted from the emotions for degrading
		// over time. Final deltas are passed in to be used for calculations.
		calculateEmotionDegradationValues(finalDeltaEmotions);
		
		// Update all the emotions by changing the intensity with the changes calculated 
		// from requests * modifiers
		for (int index = 0; index < 8; index++)
		{
		    // This will effectively negate the effect of degradation on emotional changes
		    // that occur from this update. i.e. a change of 0.2 will not immediately be dropped 
		    // to 0.1999 because of instant degradation
		    if (finalDeltaEmotions[index] > 0)
		    {
		        finalDeltaEmotions[index] += emotionDegradationValues[index];
		    }
		    
			//set the change in emotion by multiplying the desired emotion change by the total 
			//modifier for that emotion(determined by all of the personality trait modifiers combined)
			this.emotions[index].changeIntensity(finalDeltaEmotions[index]); 
			
			// Decrease the intensity by the calculated degradation value.
			this.emotions[index].changeIntensity(-emotionDegradationValues[index]);
		}
	}
	
	/**
	* Adjust the delta values based on inverse relationships between them.
	* For example, when a person is sad and there's a requested positive change
	* in joy, first we must reduce sadness, then increase joy. Can't be joyful 
	* and sad at the same time.
	*
	* @param finalDeltaEmotions the requested emotion changes
	* @return The adjusted array of emotion changes
	*/
	protected double[] adjustDeltas(double[] finalDeltaEmotions)
	{
		// Balance two deltas
		// If there's an attempted change in joy or sadness
		if (finalDeltaEmotions[0] != 0 || finalDeltaEmotions[1] != 0)
		{
			// If joy is greater than sadness
			if (finalDeltaEmotions[0] > finalDeltaEmotions[1])
			{
				// Subtract sadness change from joy
				finalDeltaEmotions[0] -= finalDeltaEmotions[1];
				finalDeltaEmotions[1] = 0;
			}
			// Sadness is greater than joy 
			else if (finalDeltaEmotions[0] < finalDeltaEmotions[1]) 
			{
				// Subtract joy change from sadness
				finalDeltaEmotions[1] -= finalDeltaEmotions[0];
				finalDeltaEmotions[0] = 0;
			}
			else // They're equal, they cancel.
			{
			    finalDeltaEmotions[0] = 0;
			    finalDeltaEmotions[1] = 0;
			}
		}
		
		// Alter change based on current emotions. i.e. If sad, joy = -sad
		// If there's an attempted change in joy and the person is sad
		if (finalDeltaEmotions[0] > 0 && this.emotions[1].getIntensity() > 0)
		{
			// If change requested is larger than current sadness
			if (finalDeltaEmotions[0] > this.emotions[1].getIntensity())
			{
				// Reduce sadness to 0
				finalDeltaEmotions[1] = -this.emotions[1].getIntensity();
				
				// Keep the rest of the emotion change as joy
				// + because it's already a negative number
				finalDeltaEmotions[0] += finalDeltaEmotions[1];
			}
			// Change requested is NOT larger than current sadness
			else if (finalDeltaEmotions[0] < this.emotions[1].getIntensity())  
			{
				// Subtract the joy from sadness.
				finalDeltaEmotions[1] = -finalDeltaEmotions[0];

				// No change in joy now.
				finalDeltaEmotions[0] = 0;
			}
			else // They're equal, they cancel.
            {
                finalDeltaEmotions[0] = 0;
                finalDeltaEmotions[1] = 0;
			}
		}
		// If there's an attempted change in sadness and the person is joyful
		else if (finalDeltaEmotions[1] > 0 && this.emotions[0].getIntensity() > 0)
		{
			// If change requested is larger than current joy
			if (finalDeltaEmotions[1] > this.emotions[0].getIntensity())
			{
				// Reduce joy to 0
				finalDeltaEmotions[0] = -this.emotions[0].getIntensity();
				
				// Keep the rest of the emotion change as sadness
				// + because it's already a negative number
				finalDeltaEmotions[1] += finalDeltaEmotions[0];
			}
			// Change requested is NOT larger than current joy
			else if (finalDeltaEmotions[1] < this.emotions[0].getIntensity())
			{
				// Subtract the sadness from joy.
				finalDeltaEmotions[0] = -finalDeltaEmotions[1];

				// No change in sadness now.
				finalDeltaEmotions[1] = 0;
			}
            else // They're equal, they cancel.
            {
                finalDeltaEmotions[0] = 0;
                finalDeltaEmotions[1] = 0;
            }
		}
		else
		{
			// Do nothing. Proceed with emotion changes as normal.
		}
		
		return finalDeltaEmotions;
	}
	
	/**
	 * Calculates the emotional modifiers by combining all the personality trait
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
			for(int index1 = 0; index1 < 5; index1++)
			{
				// Add all the personality modifiers to get a single modifier
				totalEmotionModifiers[index] += personalityTraits[index1].getEmotionModifiers()[index]; 
			}
			
			// Average the multipliers together.
			totalEmotionModifiers[index] = totalEmotionModifiers[index]/5; 
			// TODO Is there a better way to calculate the emotional modifiers? ^^^^^^
		}
	}
	
	/**
	 * Calculates the values for each emotion that represent the value to subtracted
	 * from the intensity if no specified change is requested and the person is being
	 * updated. This effectively allows for emotions to degrade over time based on
	 * various factors like other emotions and personality.
	 */
	protected void calculateEmotionDegradationValues(double[] deltaEmotions)
	{
		// TODO Based some degradation values on personality traits?
		// TODO Verify ranges and values for boundary conditions. Do they make sense? 
		
		// Reference -- Indexes and associated emotions:
		// 0. JOY, 1. SADNESS, 2. ANGER, 3. FEAR, 
		// 4. DISGUST, 5. SURPRISE, 6. ANTICIPATION, 7. TRUST	
		
		for (int index = 0; index < deltaEmotions.length; index++)
		{
			// If there was no specified change and the emotion has some value
			if (deltaEmotions[index] == 0 && this.emotions[index].getIntensity() > 0)
			{
				switch (index)
				{
					// JOY
					case 0 :
						// Increase value based on Anger
						double angerValue = convertToRange(
								this.emotions[2].getIntensity(), 
								0.00, 1.00, 
								0.0001, .001);
								 
						// Increase value based on Disgust
						double disgustValue = convertToRange(
								this.emotions[4].getIntensity(), 
								0.00, 1.00, 
								0.0001, .0005);
						
						// Use both values to find actual degradation value by 
						// adding and converting to a range between normal and x10.
						emotionDegradationValues[0] = convertToRange(
								angerValue + disgustValue, 
								0.0002, 0.0015, 
								0.0001, .001); 
						
						emotionDegradationValues[0] *= updateFrequencyMultiplier;
						break;
					
					// SADNESS
					case 1 :
						emotionDegradationValues[1] = 0.0001;
						
						emotionDegradationValues[1] *= updateFrequencyMultiplier;
						break;
					
					// ANGER
					case 2 :
						// Increase value based on Joy
						emotionDegradationValues[2] = convertToRange(
								this.emotions[0].getIntensity(), 
								0.00, 1.00, 
								0.0001, .0005);
								
						// Decrease value based on Disgust
						emotionDegradationValues[2] -= convertToRange(
								this.emotions[4].getIntensity(), 
								0.00, 1.00, 
								0, .001);
						
						// Don't allow degradation value to be negative.
						if (emotionDegradationValues[2] <= 0)
						{
							// Minimum value.
							emotionDegradationValues[2] = 0.0001;
						}
						
						emotionDegradationValues[2] *= updateFrequencyMultiplier;
						break;
					
					// FEAR
					case 3 :
						// Increase value based on Joy
						emotionDegradationValues[3] = convertToRange(
								this.emotions[0].getIntensity(), 
								0.00, 1.00, 
								0.0001, .0005);
								
						// Decrease value based on Anticipation
						emotionDegradationValues[3] -= convertToRange(
								this.emotions[6].getIntensity(), 
								0.00, 1.00, 
								0, .001);
								
						// Don't allow degradation value to be negative.
						if (emotionDegradationValues[3] <= 0)
						{
							// Minimum value.
							emotionDegradationValues[3] = 0.0001;
						}
						
						emotionDegradationValues[3] *= updateFrequencyMultiplier;
						break;
					
					// DISGUST
					case 4 :
						emotionDegradationValues[4] = 0.0001;
						// Increase value based on Joy
						emotionDegradationValues[4] = convertToRange(
								this.emotions[0].getIntensity(), 
								0.00, 1.00, 
								0.0001, .001);
								
						// Decrease value based on Anger
						emotionDegradationValues[4] -= convertToRange(
								this.emotions[2].getIntensity(), 
								0.00, 1.00, 
								0, .001);
								
						// Don't allow degradation value to be negative.
						if (emotionDegradationValues[4] <= 0)
						{
							// Minimum value.
							emotionDegradationValues[4] = 0.0001;
						}
						
						emotionDegradationValues[4] *= updateFrequencyMultiplier;
						break;
					
					// SURPRISE
					case 5 :
						// Increase value to greater than "normal"
						emotionDegradationValues[5] = 0.01;
						
						emotionDegradationValues[5] *= updateFrequencyMultiplier;
						break;
					
					// ANTICIPATION
					case 6 :
						// Decrease value to less than "normal"
						emotionDegradationValues[6] = 0.00005;
						
						emotionDegradationValues[6] *= updateFrequencyMultiplier;
						break;
					
					// TRUST
					case 7 :
						emotionDegradationValues[7] = 0.0001;
						
						emotionDegradationValues[7] *= updateFrequencyMultiplier;
						break;
				}
			}
			else
			{
				// Do nothing. Change emotion as expected.
			}
		}
	}
	
	/**
	* Takes a range and value and converts to within a different range.
	* 
	* @param oldValue The value to convert to a new range.
	* @param oldMin The minimum value that the oldValue could be.
	* @param oldMax The maximum value that the oldvalue could be.
	* @param newMin The new minimum range for the value.
	* @param newMac The new maximum range for the value.
	* @return the new value within the range specified
	*/
	public double convertToRange(double oldValue, double oldMin, double oldMax, 
								 double newMin, double newMax)
	{
		return (((oldValue - oldMin) * (newMax - newMin)) / (oldMax - oldMin)) + newMin;
	}
	
	/**
	 * Determines the response to the statement inputed. Works by filtering the pool 
	 * of options down.
	 *
	 * @param statementPool The statement pool 
	 * @return the response
	 */
	public Statement getResponse(LinkedList<Statement> statementPool)
	{
		Statement response = null; //TODO This shouldn't be null when method's finished
		statementPool = getPossibleResponses(statementPool);
		
		//TODO Pick response from possible responses (based on desired outcome???)
		response = getStatementWithGreatestChange(statementPool, null, 0);
		
		return response; //TODO TEST THIS. IT MIGHT BREAK. 
		//return statementPool.get(0); //TODO SHOULD BE RESPONSE, DID THIS FOR DEBUGGIN
	}
	
	/**
	* Recursively finds the statement that has the greatest delta in the emotion that the person
	* is the greatest influenced by (i.e. the person's max emotion)
	*
	* @param statementPool Pool of statements to search in
	* @param indicesToIgnore Indices of the emotions to ignore (see findMaxIgnoreIndex method)
	* @param count Index for the indicesToIgnore, increases when something is added
	*
	* @return The statement that has the greatest delta in the emotion that the person
	* is the greatest influenced by (i.e. the person's max emotion)
	*/
	public Statement getStatementWithGreatestChange(LinkedList<Statement> statementPool, int[] indicesToIgnore, int count)
	{
		// Reference -- Indexes and associated emotions:
		// 0. JOY, 1. SADNESS, 2. ANGER, 3. FEAR, 
		// 4. DISGUST, 5. SURPRISE, 6. ANTICIPATION, 7. TRUST	
	    
	    /** Array will hold values for the emotion intensities. */
        double[] emotionIntensities = new double[statementPool.size()];
        for (int index = 0; index < statementPool.size(); index++)
        {
            emotionIntensities[index] = statementPool.get(index).getDelEmotions()[index];
        }
        
		// Find the emotion with the greatest value/influence
		int indexForMaxEmotion = findMaxIgnoreIndex(emotionIntensities, indicesToIgnore);
		
		// All values for emotions are equal. Person doesn't have a preference on how to respond.
		if (indexForMaxEmotion == -1)
		{
			// Grab a random statement from the pool of available ones.
			Random rand = new Random();
			int randomNum = rand.nextInt((statementPool.size()) + 1);
			
			return statementPool.get(randomNum);
		}
		
		// Search the statement pool for the statement with the greatest change in ^emotion
		/** Array will hold values for the change in the emotion specified from the statements. */
		double[] deltasForMaxEmotion = new double[statementPool.size()];
		for (int index = 0; index < statementPool.size(); index++)
		{
			deltasForMaxEmotion[index] = statementPool.get(index).getDelEmotions()[indexForMaxEmotion];
		}
		
		int indexForStatement = findMaxIgnoreIndex(deltasForMaxEmotion, null);
		
		// No max found within the statement deltas for the max emotion.
		if (indexForStatement == -1)
		{
			// If none, ignore emotion, move on the second greatest.
			indicesToIgnore[count] = indexForMaxEmotion;
			count++;
			
			// Recursively call while ignoring previous max and advancing count.
			return getStatementWithGreatestChange(statementPool, indicesToIgnore, count);
		}
		else
		{
			// We found a statement with a maximum delta in the emotion that the person
			// is currently greatly influenced by (i.e. their max emotion).
			return statementPool.get(indexForStatement);
		}
	}
	
	/**
	* Finds the index of the maximum value of an array while ignoring any
	* max with an index in the array of indicesToIgnore
	*
	* @param values The array of values to find the index of the max value from.
 	* @indicesToIgnore The array of indices to ignore when searching for the max value. 
	*
	* @return the index of the maximum value in values, ignoring certain indices.
	*			-1 means there is no max
	*/
	public int findMaxIgnoreIndex(double[] values, int[] indicesToIgnore)
	{
		int maxIndex = 0;
		for (int index = 1; index < values.length; index++)
		{
		    double newnumber = values[index];
		    if ((newnumber > values[maxIndex]))
		    {
				// Don't ignore it unless specified. 
				boolean ignore = false; 
				
				// Make sure something was passed in.
				if (indicesToIgnore != null)
				{
					for (int count = 0; count < indicesToIgnore.length; count++)
					{
						if (index == indicesToIgnore[count])
						{
							ignore = true;
						}
					}
				}
				
				// If it's not an index we should ignore, save it as max.
				if (!ignore)
				{
					maxIndex = index;
				}
		    }
		}
		
		// Make sure there's more than one value. 
		if (values.length > 1)
		{
			// Check to see if the max value is equal to the first and second value. 
			if (values[0] == values[1] && 
			        values[1] == values[maxIndex])
			{
				// That means that they're all the same value. 
				return -1;
			}
		}
		
		return maxIndex;
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
			for (int traits = 0; traits < 5; traits++) 
			{	
				// check that EVERY personality trait meets the minimum and maximum
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
