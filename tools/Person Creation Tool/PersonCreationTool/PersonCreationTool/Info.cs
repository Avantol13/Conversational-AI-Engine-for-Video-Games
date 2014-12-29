using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PersonCreationTool
{
    public partial class Info : Form
    {
        private String text;

        public Info(String text)
        {
            this.text = text;
            InitializeComponent();
        }

        private void Info_Load(object sender, EventArgs e)
        {
            textBox.Text = this.text;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
