package PersonalityTraits;
import Emotions.*;

// TODO: Auto-generated Javadoc
/**
 * The Personality Trait Neuroticism.
 */
public class Neuroticism extends PersonalityTrait
{
	
	/**
	 * Instantiates Neuroticism as a personality trait.
	 *
	 * @param intensity the intensity
	 */
	public Neuroticism(double intensity) 
	{
		super("Neuroticism", intensity);
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
			emotionModifiers[1] += (3/2)*(intensity - .5) + 1; //SADNESS
			emotionModifiers[3] += (3/2)*(intensity - .5) + 1; //FEAR
			emotionModifiers[5] += (3/2)*(intensity - .5) + 1; //SURPRISE
			emotionModifiers[6] += (3/2)*(intensity - .5) + 1; //ANTICIPATION
			
			/* Decrease Effect (min of x0.25) */
			emotionModifiers[7] += (5/2)*(intensity - .5) - 1; //TRUST
		}
		else if (intensity < .5)
		{
			/* Increase Effects (Max of x1.75) */
			emotionModifiers[0] += (3/2)*(.5 - intensity) + 1; //JOY
			emotionModifiers[7] += (3/2)*(.5 - intensity) + 1; //TRUST
			
			/* Decrease Effect (min of x0.25) */
			emotionModifiers[1] += (5/2)*(.5 - intensity) - 1; //SADNESS
			emotionModifiers[3] += (5/2)*(.5 - intensity) - 1; //FEAR
			emotionModifiers[5] += (5/2)*(.5 - intensity) - 1; //SURPRISE
			emotionModifiers[6] += (5/2)*(.5 - intensity) - 1; //ANTICIPATION
		}
		//if intensity is 0.5 (which is average) the modifier will remain x1.0
		
	}
}