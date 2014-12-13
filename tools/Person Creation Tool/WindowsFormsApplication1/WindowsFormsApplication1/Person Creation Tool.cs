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

namespace WindowsFormsApplication1
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
            XmlElement root = (XmlElement)doc.AppendChild(doc.CreateElement("Person"));
            root.SetAttribute("Name", nameBox.Text);
            root.AppendChild(doc.CreateElement("OpennessToExperience")).InnerText = System.Convert.ToString(numO.Value);
            root.AppendChild(doc.CreateElement("Conscientiousness")).InnerText = System.Convert.ToString(numC.Value);
            root.AppendChild(doc.CreateElement("Extraversion")).InnerText = System.Convert.ToString(numE.Value);
            root.AppendChild(doc.CreateElement("Agreeableness")).InnerText = System.Convert.ToString(numA.Value);
            root.AppendChild(doc.CreateElement("Neuroticism")).InnerText = System.Convert.ToString(numN.Value);

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
            " A tendency to be organized and dependable, show self-discipline, " +
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
            ""
            ;
            Info info = new Info(text);
            info.Text = "Extraversion Info";
            info.Show();
        }

        private void labelA_Click(object sender, EventArgs e)
        {
            String text =
            ""
            ;
            Info info = new Info(text);
            info.Text = "Agreeableness Info";
            info.Show();
        }

        private void labelN_Click(object sender, EventArgs e)
        {
            String text =
            ""
            ;
            Info info = new Info(text);
            info.Text = "Neuroticism Info";
            info.Show();
        }
    }
}
