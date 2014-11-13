package Emotions;

// TODO: Auto-generated Javadoc
/**
 * The Class Emotion.
 */
public abstract class Emotion 
{
	
	/** The name. */
	protected String name; //name of the emotion
	
	/** The intensity: [0,1], 1 being the highest. */
	protected double intensity;
	
	/**
	 * Instantiates a new emotion.
	 *
	 * @param name the name
	 * @param intensity the intensity
	 */
	public Emotion(String name, double intensity)
	{
		this.name = name;
		this.intensity = intensity;
	}
	
	/**
	 * Change intensity.
	 *
	 * @param delta The change in the intensity of the emotion
	 */
	public void changeIntensity(double delta)
	{
		this.intensity += delta;
		
		//check to see if it hit the max value and clip to that value
		if (this.intensity > 1.0)
		{
			this.intensity = 1.0;
		}
		
		//check to see if it hit the min value and clip to that value
		if (this.intensity < 0)
		{
			this.intensity = 0;
		}
	}
	
	/* Getters and Setters */
	//
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
	public void setIntensity(double intensity)
	{
		this.intensity = intensity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + name + ":" + intensity + ")" + "\n";
	}
	
	/**
	 * Num to string.
	 *
	 * @return the string
	 */
	public String numToString() {
        return "" + intensity;
    }
	
}
