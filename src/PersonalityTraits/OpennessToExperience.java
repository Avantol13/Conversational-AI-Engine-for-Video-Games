package PersonalityTraits;
import Emotions.*;

// TODO: Auto-generated Javadoc
/**
 * The Personality Trait OpennessToExperience.
 */
public class OpennessToExperience extends PersonalityTrait
{
	
	/**
	 * Instantiates OpennessToExperience as a personality trait.
	 *
	 * @param intensity the intensity
	 */
	public OpennessToExperience(double intensity) 
	{
		super("OpennessToExperience", intensity);
		updateEmotionalModifiers();
	}

	/**
	 * Create the modifiers for each of emotions based on the intensity of the personality trait.
	 */
	public void updateEmotionalModifiers()
	{
		//0. Joy, 1. Sadness, 2. Anger, 3. Fear, 4. Disgust, 5. Surprise, 6. Anticipation, 7. Trust			
		if (intensity > .5)
		{
			/* Increase Effects (Max of x1.75) */
			emotionModifiers[0] += (3/2)*(intensity - .5) + 1; //JOY
			emotionModifiers[5] += (3/2)*(intensity - .5) + 1; //SURPRISE
			emotionModifiers[6] += (3/2)*(intensity - .5) + 1; //ANTICIPATION
			
			/* Decrease Effect (min of x0.25) */
			emotionModifiers[3] += (5/2)*(intensity - .5) - 1; //FEAR
		}
		else if (intensity < .5)
		{
			/* Increase Effects (Max of x1.75) */
			emotionModifiers[3] += (3/2)*(.5 - intensity) + 1; //FEAR
			emotionModifiers[5] += (3/2)*(.5 - intensity) + 1; //SURPRISE
			
			/* Decrease Effect (min of x0.25) */
			emotionModifiers[7] += (5/2)*(.5 - intensity) - 1; //TRUST
		}
		//if intensity is 0.5 (which is average) the modifier will remain x1.0
		
	}
}
