using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml;

namespace PersonCreationTool
{
    public partial class PersonCreationForm : Form
    {
        private String pathForCodeGen;

        public PersonCreationForm()
        {
            InitializeComponent();
            numO_ValueChanged(null, EventArgs.Empty);
            numC_ValueChanged(null, EventArgs.Empty);
            numE_ValueChanged(null, EventArgs.Empty);
            numA_ValueChanged(null, EventArgs.Empty);
            numN_ValueChanged(null, EventArgs.Empty);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            const string message =
            "Are you sure you would like to close the form?";
            const string caption = "Form Closing";
            var result = MessageBox.Show(message, caption,
                                         MessageBoxButtons.YesNo,
                                         MessageBoxIcon.Question);

            // If the no button was pressed ... 
            if (result == DialogResult.Yes)
            {
                this.Close();
            }
        }

        private void generateButton_Click(object sender, EventArgs e)
        {
            // Get the path in the text box.
            pathForCodeGen = fileGenerationLocation.Text;

            // Test the path to see if it's a valid format. If not, error.
            try
            {
                Uri testPath = new Uri(pathForCodeGen);

                // Everything checks out, the user entered the types of files to
                // generate and a valid location.
                specifyLocationError.Visible = false;
            }
            catch (UriFormatException)
            {
                // Show error and reset invalid path.
                specifyLocationError.Visible = true;
                pathForCodeGen = null;

                // Check if they have name.
                if (nameBox.Text == "" || nameBox.Text == null)
                {
                    nameError.Visible = true;
                }
                return;
            }

            // Check if they entered a name.
            if (nameBox.Text == "" || nameBox.Text == null)
            {
                nameError.Visible = true;
                return;
            }
            nameError.Visible = false;

            //TODO Generate xml
            XmlDocument doc = new XmlDocument();
            XmlElement root = (XmlElement)doc.AppendChild(doc.CreateElement("person"));
            root.SetAttribute("name", nameBox.Text);

            XmlElement emotions = (XmlElement)root.AppendChild(doc.CreateElement("emotions"));
            XmlElement personalityTraits = (XmlElement)root.AppendChild(doc.CreateElement("personalityTraits"));

            XmlElement joy = (XmlElement)emotions.AppendChild(doc.CreateElement("Emotions.Joy"));
            joy.AppendChild(doc.CreateElement("intensity")).InnerText = "0.0";

            XmlElement sadness = (XmlElement)emotions.AppendChild(doc.CreateElement("Emotions.Sadness"));
            sadness.AppendChild(doc.CreateElement("intensity")).InnerText = "0.0";

            XmlElement anger = (XmlElement)emotions.AppendChild(doc.CreateElement("Emotions.Anger"));
            anger.AppendChild(doc.CreateElement("intensity")).InnerText = "0.0";

            XmlElement fear = (XmlElement)emotions.AppendChild(doc.CreateElement("Emotions.Fear"));
            fear.AppendChild(doc.CreateElement("intensity")).InnerText = "0.0";

            XmlElement disgust = (XmlElement)emotions.AppendChild(doc.CreateElement("Emotions.Disgust"));
            disgust.AppendChild(doc.CreateElement("intensity")).InnerText = "0.0";

            XmlElement surprise = (XmlElement)emotions.AppendChild(doc.CreateElement("Emotions.Surprise"));
            surprise.AppendChild(doc.CreateElement("intensity")).InnerText = "0.0";

            XmlElement anticipation = (XmlElement)emotions.AppendChild(doc.CreateElement("Emotions.Anticipation"));
            anticipation.AppendChild(doc.CreateElement("intensity")).InnerText = "0.0";

            XmlElement trust = (XmlElement)emotions.AppendChild(doc.CreateElement("Emotions.Trust"));
            trust.AppendChild(doc.CreateElement("intensity")).InnerText = "0.0";

            XmlElement opennessToExperience = (XmlElement)personalityTraits.AppendChild(doc.CreateElement("PersonalityTraits.OpennessToExperience"));
            opennessToExperience.AppendChild(doc.CreateElement("intensity")).InnerText = System.Convert.ToString(numO.Value);

            XmlElement conscientiousness = (XmlElement)personalityTraits.AppendChild(doc.CreateElement("PersonalityTraits.Conscientiousness"));
            conscientiousness.AppendChild(doc.CreateElement("intensity")).InnerText = System.Convert.ToString(numC.Value);

            XmlElement extraversion = (XmlElement)personalityTraits.AppendChild(doc.CreateElement("PersonalityTraits.Extraversion"));
            extraversion.AppendChild(doc.CreateElement("intensity")).InnerText = System.Convert.ToString(numE.Value);

            XmlElement agreeableness = (XmlElement)personalityTraits.AppendChild(doc.CreateElement("PersonalityTraits.Agreeableness"));
            agreeableness.AppendChild(doc.CreateElement("intensity")).InnerText = System.Convert.ToString(numA.Value);

            XmlElement neuroticism = (XmlElement)personalityTraits.AppendChild(doc.CreateElement("PersonalityTraits.Neuroticism"));
            neuroticism.AppendChild(doc.CreateElement("intensity")).InnerText = System.Convert.ToString(numN.Value);

            // Save to xml
            doc.Save(pathForCodeGen + "\\" + nameBox.Text + ".xml");

            MessageBox.Show("Success", "Successfully generated file.", MessageBoxButtons.OK);
        }

        private void browseButton_Click(object sender, EventArgs e)
        {
            string path;
            path = System.IO.Path.GetDirectoryName(System.Reflection.Assembly.GetExecutingAssembly().GetName().CodeBase );
            folderBrowserDialog1.SelectedPath = path;
            if (folderBrowserDialog1.ShowDialog() == DialogResult.OK)
            {
                // Get the path that the user selected.
                pathForCodeGen = folderBrowserDialog1.SelectedPath;

                // Put the path into the text box next to the button. 
                fileGenerationLocation.Clear();
                fileGenerationLocation.Paste(pathForCodeGen);

                // If the error was there, remove it.
                specifyLocationError.Visible = false;
            }
        }

        private void numO_ValueChanged(object sender, EventArgs e)
        {
            double value = System.Convert.ToDouble(numO.Value);
            updateLabel(value, labelO_1, "inventive/curious", "consistent/cautious");
        }

        private void numC_ValueChanged(object sender, EventArgs e)
        {
            double value = System.Convert.ToDouble(numC.Value);
            updateLabel(value, labelC_1, "efficient/organized", "easy-going/careless");
        }

        private void numE_ValueChanged(object sender, EventArgs e)
        {
            double value = System.Convert.ToDouble(numE.Value);
            updateLabel(value, labelE_1, "outgoing/energetic", "solitary/reserved");
        }

        private void numA_ValueChanged(object sender, EventArgs e)
        {
            double value = System.Convert.ToDouble(numA.Value);
            updateLabel(value, labelA_1, "friendly/compassionate", "analytical/detached");
        }

        private void numN_ValueChanged(object sender, EventArgs e)
        {
            double value = System.Convert.ToDouble(numN.Value);
            updateLabel(value, labelN_1, "sensitive/nervous", "secure/confident");
        }

        private void updateLabel(Double value, Label label, String upperBoundTrait, String lowerBoundTrait)
        {
            if (value >= 0.92)
            {
                label.Text = "Unbelievably " + upperBoundTrait;
            }
            else if (value >= .84)
            {
                label.Text = "Extremely " + upperBoundTrait;
            }
            else if (value >= .75)
            {
                label.Text = "Very " + upperBoundTrait;
            }
            else if (value >= .66)
            {
                label.Text = "Really " + upperBoundTrait;
            }
            else if (value >= .58)
            {
                label.Text = "Pretty " + upperBoundTrait;
            }
            else if (value > .50)
            {
                label.Text = "Sort of " + upperBoundTrait;
            }
            else if (value == 0.50)
            {
                label.Text = "No more " + upperBoundTrait + " than " + lowerBoundTrait;
            }
            else if (value >= .42)
            {
                label.Text = "Sort of " + lowerBoundTrait;
            }
            else if (value >= .34)
            {
                label.Text = "Pretty " + lowerBoundTrait;
            }
            else if (value >= .25)
            {
                label.Text = "Really " + lowerBoundTrait;
            }
            else if (value >= .16)
            {
                label.Text = "Very " + lowerBoundTrait;
            }
            else if (value >= .08)
            {
                label.Text = "Extremely " + lowerBoundTrait;
            }
            else
            {
                label.Text = "Unbelievably " + lowerBoundTrait;
            }
        }

        private void newToolStripMenuItem_Click(object sender, EventArgs e)
        {
            nameBox.Clear();
            pathForCodeGen = null;
            fileGenerationLocation.Clear();
            specifyLocationError.Visible = false;
            nameError.Visible = false;
            numO.Value = System.Convert.ToDecimal(0.5);
            numC.Value = System.Convert.ToDecimal(0.5);
            numE.Value = System.Convert.ToDecimal(0.5);
            numA.Value = System.Convert.ToDecimal(0.5);
            numN.Value = System.Convert.ToDecimal(0.5);
            numO_ValueChanged(null, EventArgs.Empty);
            numC_ValueChanged(null, EventArgs.Empty);
            numE_ValueChanged(null, EventArgs.Empty);
            numA_ValueChanged(null, EventArgs.Empty);
            numN_ValueChanged(null, EventArgs.Empty);
        }

        private void labelO_Click(object sender, EventArgs e)
        {
            String text =
                "Openness to experience\ninventive/curious vs. consistent/cautious\n\n" +
                "A particular individual, however, may have a high overall openness" +
                " score and be interested in learning and exploring new cultures but have" +
                " no great interest in art or poetry. There is a strong connection between " + 
                "liberal ethics and openness to experience such as support for policies " + 
                "endorsing racial tolerance. Another characteristic of the open cognitive " +
                "style is a facility for thinking in symbols and abstractions far removed from " + 
                "concrete experience.\n\nPeople with low scores on openness tend to have more " + 
                "conventional, traditional interests. They prefer the plain, straightforward, " + 
                "and obvious over the complex, ambiguous, and subtle. They may regard the arts " + 
                "and sciences with suspicion or view these endeavors as uninteresting. Closed" + 
                " people prefer familiarity over novelty; they are conservative and resistant to change.\n\n" +
                "Examples of higher Openness to Experience:\n" +
                "   -I have a rich vocabulary.\n" +
                "   -I have a vivid imagination.\n" +
                "   -I have excellent ideas.\n" +
                "   -I am quick to understand things.\n" +
                "   -I use difficult words.\n" +
                "   -I spend time reflecting on things.\n" +
                "   -I am full of ideas.\n\n" +
                "Examples of lower Openness to Experience.\n" +
                "   -I am not interested in abstractions.\n" +
                "   -I do not have a good imagination.\n" +
                "   -I have difficulty understanding abstract ideas:\n\n" +
                "See http://en.wikipedia.org/wiki/Big_Five_personality_traits"
                ;

            Info info = new Info(text);
            info.Text = "Openness to Experience Info";
            info.Show();
        }

        private void labelC_1_Click(object sender, EventArgs e)
        {

        }

        private void labelC_Click(object sender, EventArgs e)
        {
            String text =
            "Conscientiousness\nefficient/organized vs. easy-going/careless\n\n" +
            "A tendency to be organized and dependable, show self-discipline, " +
            "act dutifully, aim for achievement, and prefer planned rather than spontaneous behavior.\n\n" +
            "It is related to the way in which people control, regulate, and direct their impulses. High "+
            "scores on conscientiousness indicate a preference for planned rather than spontaneous behavior."+
            " The average level of conscientiousness rises among young adults and then declines among older adults.\n\n" +
            "Examples of higher Conscientiousness:\n" +
            "   -I am always prepared.\n" +
            "   -I pay attention to details.\n" +
            "   -I get chores done right away.\n" +
            "   -I like order.\n" +
            "   -I follow a schedule.\n" +
            "   -I am exacting in my work.\n" +
            "Examples of lower Conscientiousness:\n" +
            "   -I leave my belongings around.\n" +
            "   -I make a mess of things.\n" +
            "   -I often forget to put things back in their proper place.\n" +
            "   -I shirk my duties.\n\n" +
            "See http://en.wikipedia.org/wiki/Big_Five_personality_traits"
            ;
            Info info = new Info(text);
            info.Text = "Conscientiousness Info";
            info.Show();
        }

        private void labelE_Click(object sender, EventArgs e)
        {
            String text =
            "Extraversion\noutgoing/energetic vs. solitary/reserved\n\n" +
            "Energy, positive emotions, surgency, assertiveness, sociability and the tendency to seek "+
            "stimulation in the company of others, and talkativeness." +
            "Extraversion is characterized by breadth of activities (as opposed to depth), surgency "+
            "from external activity/situations, and energy creation from external means. The trait is "+
            "marked by pronounced engagement with the external world. Extraverts enjoy interacting with "+
            "people, and are often perceived as full of energy. They tend to be enthusiastic, "+
            "action-oriented individuals. They possess high group visibility, like to talk, and assert themselves. " +
            "Introverts have lower social engagement and energy levels than extraverts. They tend to "+
            "seem quiet, low-key, deliberate, and less involved in the social world. Their lack of social "+
            "involvement should not be interpreted as shyness or depression; instead they are more "+
            "independent of their social world than extraverts. Introverts need less stimulation than "+
            "extraverts and more time alone. This does not mean that they are unfriendly or antisocial; "+
            "rather, they are reserved in social situations.\n\n"+
            "Examples of higher Extraversion:\n" +
            "   -I am the life of the party.\n" +
            "   -I don't mind being the center of attention.\n" +
            "   -I feel comfortable around people.\n" +
            "   -I talk to a lot of different people at parties.\n" +
            "Examples of lower Extraversion:\n" +
            "   -I don't talk a lot. \n" +
            "   -I think a lot before I speak or act.\n" +
            "   -I don't like to draw attention to myself. \n" +
            "   -I have no intention of talking in large crowds. \n" +
            "   -I am quiet around strangers.\n\n" +
            "See http://en.wikipedia.org/wiki/Big_Five_personality_traits"
            ;
            Info info = new Info(text);
            info.Text = "Extraversion Info";
            info.Show();
        }

        private void labelA_Click(object sender, EventArgs e)
        {
            String text =
            "Agreeableness\nfriendly/compassionate vs. analytical/detached\n\n" +
            "A tendency to be compassionate and cooperative rather than suspicious and antagonistic towards others. " +
            "It is also a measure of one's trusting and helpful nature, and whether a person is generally well tempered or not. " +
            "The agreeableness trait reflects individual differences in general concern for social harmony. Agreeable individuals "+
            "value getting along with others. They are generally considerate, kind, generous, trusting and trustworthy, helpful, "+
            "and willing to compromise their interests with others. Agreeable people also have an optimistic view of human nature. "+
            "Because agreeableness is a social trait, research has shown that one's agreeableness positively correlates with "+
            "the quality of relationships with one's team members.\n\n"+

            "Disagreeable individuals place self-interest above getting along with others. They are generally unconcerned "+
            "with others' well-being, and are less likely to extend themselves for other people. Sometimes their skepticism "+
            "about others' motives causes them to be suspicious, unfriendly, and uncooperative.\n\n" +

            "Examples of higher Agreeableness:\n" +
            "   -I am interested in people.\n" +
            "   -I sympathize with others' feelings.\n" +
            "   -I have a soft heart.\n" +
            "   -I feel others' emotions.\n" +
            "   -I make people feel at ease.\n" +
            "   -I take time out for others.\n" +
            "Examples of lower Agreeableness:\n" +
            "   -I am not really interested in others. \n" +
            "   -I insult people.\n" +
            "   -I am not interested in other people's problems.  \n" +
            "   -I feel little concern for others. \n\n" +
            "See http://en.wikipedia.org/wiki/Big_Five_personality_traits"
            ;
            Info info = new Info(text);
            info.Text = "Agreeableness Info";
            info.Show();
        }

        private void labelN_Click(object sender, EventArgs e)
        {
            String text =
            "Neuroticism\nsensitive/nervous vs. secure/confident\n\n" +
            "The tendency to experience unpleasant emotions easily, such as anger, anxiety, depression, and vulnerability. "+
            "Neuroticism also refers to the degree of emotional stability and impulse control and is sometimes referred to by its low pole, \"emotional stability\". "+
            "Neuroticism is the tendency to experience negative emotions, such as anger, anxiety, or depression. It is "+
            "sometimes called emotional instability, or is reversed and referred to as emotional stability. According to "+
            "Eysenck's (1967) theory of personality, neuroticism is interlinked with low tolerance for stress or aversive stimuli. "+
            "Those who score high in neuroticism are emotionally reactive and vulnerable to stress. They are more likely to interpret "+
            "ordinary situations as threatening, and minor frustrations as hopelessly difficult. Their negative emotional reactions "+
            "tend to persist for unusually long periods of time, which means they are often in a bad mood. For instance, neuroticism "+
            "is connected to a pessimistic approach toward work, confidence that work impedes personal relationships, and apparent "+
            "anxiety linked with work. Furthermore, those who score high on neuroticism may display more skin conductance "+
            "reactivity than those who score low on neuroticism. These problems in emotional regulation can diminish "+
            "the ability of a person scoring high on neuroticism to think clearly, make decisions, and cope effectively with stress. "+
            "Lacking contentment in one's life achievements can correlate with high neuroticism scores and increase one's likelihood "+
            "of falling into clinical depression. Moreover, individuals high on neuroticism tend to experience more negative life events., "+
            "but neuroticism also changes in response to positive and negative life experiences.\n\n"+

            "At the other end of the scale, individuals who score low in neuroticism are less easily upset and are less emotionally "+
            "reactive. They tend to be calm, emotionally stable, and free from persistent negative feelings. Freedom from negative "+
            "feelings does not mean that low scorers experience a lot of positive feelings."+

            "Examples of higher Neuroticism:\n" +
            "   -I am easily disturbed.\n" +
            "   -I change my mood a lot.\n" +
            "   -I get irritated easily.\n" +
            "   -I get stressed out easily.\n" +
            "   -I get upset easily.\n" +
            "   -I am much more anxious than most people.\n" +
            "   -I worry about things.\n" +
            "   -I have frequent mood swings.\n" +
            "Examples of lower Neuroticism:\n" +
            "   -I am relaxed most of the time. \n" +
            "   -I seldom feel blue. \n\n" +
            "See http://en.wikipedia.org/wiki/Big_Five_personality_traits"
            ;
            Info info = new Info(text);
            info.Text = "Neuroticism Info";
            info.Show();
        }
    }
}
