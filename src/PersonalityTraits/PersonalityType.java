package PersonalityTraits;

// TODO: Auto-generated Javadoc
/**
 * A class defining a specific personality type.
 */
public class PersonalityType
{
	/** The name. */
	private String name;
	
	/** The openness to experience. */
	private OpennessToExperience opennessToExperience;
	
	/** The conscientiousness. */
	private Conscientiousness conscientiousness;
	
	/** The extraversion. */
	private Extraversion extraversion;
	
	/** The agreeableness. */
	private Agreeableness agreeableness;
	
	/** The neuroticism. */
	private Neuroticism neuroticism;
	
	/**
	 * Instantiates a new personality type.
	 *
	 * @param name the name
	 * @param opennessToExperienceIntensity the openness to experience intensity
	 * @param conscientiousnessIntensity the conscientiousness intensity
	 * @param extraversionIntensity the extraversion intensity
	 * @param agreeablenessIntensity the agreeableness intensity
	 * @param neuroticismIntensity the neuroticism intensity
	 */
	public PersonalityType(
				String name,
				double opennessToExperienceIntensity,
				double conscientiousnessIntensity, 
				double extraversionIntensity, 
				double agreeablenessIntensity,
				double neuroticismIntensity
				) 
	{
		this.name = name;
		this.opennessToExperience = new OpennessToExperience(opennessToExperienceIntensity);
		this.conscientiousness = new Conscientiousness(conscientiousnessIntensity);
		this.extraversion = new Extraversion(extraversionIntensity);
		this.agreeableness = new Agreeableness(agreeablenessIntensity);
		this.neuroticism = new Neuroticism(neuroticismIntensity);
	}
	
}