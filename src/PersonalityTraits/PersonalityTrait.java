package PersonalityTraits;

import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonalityTrait, containing variables and methods common to all personality traits.
 */
public abstract class PersonalityTrait
{
	
	/** The name of the emotion. */
	protected String name; 
	
	/** The intensity: [0,1], 1 being the highest. */
	protected double intensity; 
	
	/** The array of modifiers for all the emotions. */
	protected double[] emotionModifiers;

	/**
	 * Instantiates a new personality trait.
	 *
	 * @param name the name
	 * @param intensity the intensity
	 */
	public PersonalityTrait(String name, double intensity)
	{
		this.name = name;
		this.intensity = intensity;
		//Joy, Sadness, Anger, Fear, Disgust, Surprise, Anticipation, Trust
		this.emotionModifiers = new double[] {1, 1, 1, 1, 1, 1, 1, 1}; //initialize
	}
	
	/**
	 * Change intensity.
	 *
	 * @param delta The change in the intensity of the emotion
	 */
	public void changeIntensity(float delta)
	{
		this.intensity = this.intensity + delta;
	}
	
	//Getters and Setters
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	//
	/**
	 * Gets the intensity.
	 *
	 * @return the intensity
	 */
	public double getIntensity()
	{
		return this.intensity;
	}
	
	/**
	 * Sets the intensity.
	 *
	 * @param intensity the new intensity
	 */
	public void setIntensity(float intensity)
	{
		this.intensity = intensity;
	}
	
	//
	/**
	 * Gets the emotion modifiers.
	 *
	 * @return the emotion modifiers
	 */
	public double[] getEmotionModifiers() 
	{
		return emotionModifiers;
	}
	
	/**
	 * Sets the emotion modifiers.
	 *
	 * @param emotionModifiers the new emotion modifiers
	 */
	public void setEmotionModifiers(double[] emotionModifiers) 
	{
		this.emotionModifiers = emotionModifiers;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + name + ":" + intensity + ")" + "\n";
	}
	
	
}
