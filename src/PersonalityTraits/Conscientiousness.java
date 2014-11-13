package PersonalityTraits;
import Emotions.*;

// TODO: Auto-generated Javadoc
/**
 * The Personality Trait Conscientiousness.
 */
public class Conscientiousness extends PersonalityTrait
{
	
	/**
	 * Instantiates Conscientiousness as a personality trait.
	 *
	 * @param intensity the intensity
	 */
	public Conscientiousness(double intensity) 
	{
		super("Conscientiousness", intensity);
		updateEmotionalModifiers();
	}
	
	/**
	 * Create the modifiers for each of emotions based on the intensity of the personality trait.
	 */
	public void updateEmotionalModifiers()
	{
		//0. JOY, 1. SADNESS, 2. ANGER, 3. FEAR, 4. DISGUST, 5. SURPRISE, 6. ANTICIPATION, 7. TRUST			
		if (intensity > .5)
		{
			/* Increase Effects (Max of x1.75) */
			emotionModifiers[4] += (3/2)*(intensity - .5) + 1; //DISGUST
			emotionModifiers[5] += (3/2)*(intensity - .5) + 1; //SURPRISE
			
			/* Decrease Effect (min of x0.25) */
			//emotionModifiers[2] += (5/2)*(intensity - .5) - 1; //ANGER
		}
		else if (intensity < .5)
		{
			/* Increase Effects (Max of x1.75) */
			emotionModifiers[7] += (3/2)*(.5 - intensity) + 1; //TRUST
			
			/* Decrease Effect (min of x0.25) */
			emotionModifiers[1] += (5/2)*(.5 - intensity) - 1; //SADNESS
			emotionModifiers[2] += (5/2)*(.5 - intensity) - 1; //ANGER
			emotionModifiers[3] += (5/2)*(.5 - intensity) - 1; //FEAR
			emotionModifiers[4] += (5/2)*(.5 - intensity) - 1; //DISGUST
			emotionModifiers[5] += (5/2)*(.5 - intensity) - 1; //SURPRISE
			emotionModifiers[6] += (5/2)*(.5 - intensity) - 1; //ANTICIPATION
			
		}
		//if intensity is 0.5 (which is average) the modifier will remain x1.0
		
	}
}
