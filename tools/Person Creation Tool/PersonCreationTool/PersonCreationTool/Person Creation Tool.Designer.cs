namespace PersonCreationTool
{
    partial class PersonCreationForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.newToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.openToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.numO = new System.Windows.Forms.NumericUpDown();
            this.labelO = new System.Windows.Forms.Label();
            this.labelC = new System.Windows.Forms.Label();
            this.numC = new System.Windows.Forms.NumericUpDown();
            this.labelE = new System.Windows.Forms.Label();
            this.numE = new System.Windows.Forms.NumericUpDown();
            this.labelA = new System.Windows.Forms.Label();
            this.numA = new System.Windows.Forms.NumericUpDown();
            this.labelN = new System.Windows.Forms.Label();
            this.numN = new System.Windows.Forms.NumericUpDown();
            this.labelO_1 = new System.Windows.Forms.Label();
            this.labelC_1 = new System.Windows.Forms.Label();
            this.labelE_1 = new System.Windows.Forms.Label();
            this.labelA_1 = new System.Windows.Forms.Label();
            this.labelN_1 = new System.Windows.Forms.Label();
            this.generateButton = new System.Windows.Forms.Button();
            this.cancelButton = new System.Windows.Forms.Button();
            this.fileGenLocLabel = new System.Windows.Forms.Label();
            this.fileGenerationLocation = new System.Windows.Forms.TextBox();
            this.folderBrowserDialog1 = new System.Windows.Forms.FolderBrowserDialog();
            this.browseButton = new System.Windows.Forms.Button();
            this.specifyLocationError = new System.Windows.Forms.Label();
            this.nameBox = new System.Windows.Forms.TextBox();
            this.nameLabel = new System.Windows.Forms.Label();
            this.nameError = new System.Windows.Forms.Label();
            this.menuStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numO)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numC)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numE)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numA)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numN)).BeginInit();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(561, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // fileToolStripMenuItem
            // 
            this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.newToolStripMenuItem,
            this.openToolStripMenuItem});
            this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
            this.fileToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
            this.fileToolStripMenuItem.Text = "File";
            // 
            // newToolStripMenuItem
            // 
            this.newToolStripMenuItem.Name = "newToolStripMenuItem";
            this.newToolStripMenuItem.Size = new System.Drawing.Size(112, 22);
            this.newToolStripMenuItem.Text = "New";
            this.newToolStripMenuItem.Click += new System.EventHandler(this.newToolStripMenuItem_Click);
            // 
            // openToolStripMenuItem
            // 
            this.openToolStripMenuItem.Name = "openToolStripMenuItem";
            this.openToolStripMenuItem.Size = new System.Drawing.Size(112, 22);
            this.openToolStripMenuItem.Text = "Open...";
            // 
            // numO
            // 
            this.numO.DecimalPlaces = 2;
            this.numO.Increment = new decimal(new int[] {
            2,
            0,
            0,
            131072});
            this.numO.Location = new System.Drawing.Point(173, 63);
            this.numO.Maximum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.numO.Name = "numO";
            this.numO.Size = new System.Drawing.Size(44, 20);
            this.numO.TabIndex = 1;
            this.numO.Value = new decimal(new int[] {
            50,
            0,
            0,
            131072});
            this.numO.ValueChanged += new System.EventHandler(this.numO_ValueChanged);
            // 
            // labelO
            // 
            this.labelO.AutoSize = true;
            this.labelO.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelO.Location = new System.Drawing.Point(12, 62);
            this.labelO.Name = "labelO";
            this.labelO.Size = new System.Drawing.Size(155, 16);
            this.labelO.TabIndex = 2;
            this.labelO.Text = "Openness to Experience";
            this.labelO.Click += new System.EventHandler(this.labelO_Click);
            // 
            // labelC
            // 
            this.labelC.AutoSize = true;
            this.labelC.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelC.Location = new System.Drawing.Point(46, 88);
            this.labelC.Name = "labelC";
            this.labelC.Size = new System.Drawing.Size(121, 16);
            this.labelC.TabIndex = 4;
            this.labelC.Text = "Conscientiousness";
            this.labelC.Click += new System.EventHandler(this.labelC_Click);
            // 
            // numC
            // 
            this.numC.DecimalPlaces = 2;
            this.numC.Increment = new decimal(new int[] {
            2,
            0,
            0,
            131072});
            this.numC.Location = new System.Drawing.Point(173, 89);
            this.numC.Maximum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.numC.Name = "numC";
            this.numC.Size = new System.Drawing.Size(44, 20);
            this.numC.TabIndex = 3;
            this.numC.Value = new decimal(new int[] {
            5,
            0,
            0,
            65536});
            this.numC.ValueChanged += new System.EventHandler(this.numC_ValueChanged);
            // 
            // labelE
            // 
            this.labelE.AutoSize = true;
            this.labelE.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelE.Location = new System.Drawing.Point(85, 115);
            this.labelE.Name = "labelE";
            this.labelE.Size = new System.Drawing.Size(82, 16);
            this.labelE.TabIndex = 6;
            this.labelE.Text = "Extraversion";
            this.labelE.Click += new System.EventHandler(this.labelE_Click);
            // 
            // numE
            // 
            this.numE.DecimalPlaces = 2;
            this.numE.Increment = new decimal(new int[] {
            2,
            0,
            0,
            131072});
            this.numE.Location = new System.Drawing.Point(173, 115);
            this.numE.Maximum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.numE.Name = "numE";
            this.numE.Size = new System.Drawing.Size(44, 20);
            this.numE.TabIndex = 5;
            this.numE.Value = new decimal(new int[] {
            5,
            0,
            0,
            65536});
            this.numE.ValueChanged += new System.EventHandler(this.numE_ValueChanged);
            // 
            // labelA
            // 
            this.labelA.AutoSize = true;
            this.labelA.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelA.Location = new System.Drawing.Point(66, 141);
            this.labelA.Name = "labelA";
            this.labelA.Size = new System.Drawing.Size(101, 16);
            this.labelA.TabIndex = 8;
            this.labelA.Text = "Agreeableness";
            this.labelA.Click += new System.EventHandler(this.labelA_Click);
            // 
            // numA
            // 
            this.numA.DecimalPlaces = 2;
            this.numA.Increment = new decimal(new int[] {
            2,
            0,
            0,
            131072});
            this.numA.Location = new System.Drawing.Point(173, 141);
            this.numA.Maximum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.numA.Name = "numA";
            this.numA.Size = new System.Drawing.Size(44, 20);
            this.numA.TabIndex = 7;
            this.numA.Value = new decimal(new int[] {
            5,
            0,
            0,
            65536});
            this.numA.ValueChanged += new System.EventHandler(this.numA_ValueChanged);
            // 
            // labelN
            // 
            this.labelN.AutoSize = true;
            this.labelN.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelN.Location = new System.Drawing.Point(88, 167);
            this.labelN.Name = "labelN";
            this.labelN.Size = new System.Drawing.Size(79, 16);
            this.labelN.TabIndex = 10;
            this.labelN.Text = "Neuroticism";
            this.labelN.Click += new System.EventHandler(this.labelN_Click);
            // 
            // numN
            // 
            this.numN.DecimalPlaces = 2;
            this.numN.Increment = new decimal(new int[] {
            2,
            0,
            0,
            131072});
            this.numN.Location = new System.Drawing.Point(173, 167);
            this.numN.Maximum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.numN.Name = "numN";
            this.numN.Size = new System.Drawing.Size(44, 20);
            this.numN.TabIndex = 9;
            this.numN.Value = new decimal(new int[] {
            5,
            0,
            0,
            65536});
            this.numN.ValueChanged += new System.EventHandler(this.numN_ValueChanged);
            // 
            // labelO_1
            // 
            this.labelO_1.AutoSize = true;
            this.labelO_1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelO_1.Location = new System.Drawing.Point(225, 63);
            this.labelO_1.Name = "labelO_1";
            this.labelO_1.Size = new System.Drawing.Size(0, 15);
            this.labelO_1.TabIndex = 11;
            // 
            // labelC_1
            // 
            this.labelC_1.AutoSize = true;
            this.labelC_1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelC_1.Location = new System.Drawing.Point(225, 89);
            this.labelC_1.Name = "labelC_1";
            this.labelC_1.Size = new System.Drawing.Size(0, 15);
            this.labelC_1.TabIndex = 12;
            this.labelC_1.Click += new System.EventHandler(this.labelC_1_Click);
            // 
            // labelE_1
            // 
            this.labelE_1.AutoSize = true;
            this.labelE_1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelE_1.Location = new System.Drawing.Point(225, 115);
            this.labelE_1.Name = "labelE_1";
            this.labelE_1.Size = new System.Drawing.Size(0, 15);
            this.labelE_1.TabIndex = 13;
            // 
            // labelA_1
            // 
            this.labelA_1.AutoSize = true;
            this.labelA_1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelA_1.Location = new System.Drawing.Point(225, 141);
            this.labelA_1.Name = "labelA_1";
            this.labelA_1.Size = new System.Drawing.Size(0, 15);
            this.labelA_1.TabIndex = 14;
            // 
            // labelN_1
            // 
            this.labelN_1.AutoSize = true;
            this.labelN_1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelN_1.Location = new System.Drawing.Point(225, 167);
            this.labelN_1.Name = "labelN_1";
            this.labelN_1.Size = new System.Drawing.Size(0, 15);
            this.labelN_1.TabIndex = 15;
            // 
            // generateButton
            // 
            this.generateButton.Location = new System.Drawing.Point(397, 227);
            this.generateButton.Name = "generateButton";
            this.generateButton.Size = new System.Drawing.Size(75, 23);
            this.generateButton.TabIndex = 16;
            this.generateButton.Text = "Generate";
            this.generateButton.UseVisualStyleBackColor = true;
            this.generateButton.Click += new System.EventHandler(this.generateButton_Click);
            // 
            // cancelButton
            // 
            this.cancelButton.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.cancelButton.Location = new System.Drawing.Point(478, 227);
            this.cancelButton.Name = "cancelButton";
            this.cancelButton.Size = new System.Drawing.Size(75, 23);
            this.cancelButton.TabIndex = 17;
            this.cancelButton.Text = "Cancel";
            this.cancelButton.UseVisualStyleBackColor = true;
            this.cancelButton.Click += new System.EventHandler(this.button1_Click);
            // 
            // fileGenLocLabel
            // 
            this.fileGenLocLabel.AutoSize = true;
            this.fileGenLocLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.fileGenLocLabel.Location = new System.Drawing.Point(52, 198);
            this.fileGenLocLabel.Name = "fileGenLocLabel";
            this.fileGenLocLabel.Size = new System.Drawing.Size(153, 16);
            this.fileGenLocLabel.TabIndex = 18;
            this.fileGenLocLabel.Text = "File Generation Location";
            // 
            // fileGenerationLocation
            // 
            this.fileGenerationLocation.Location = new System.Drawing.Point(211, 197);
            this.fileGenerationLocation.Name = "fileGenerationLocation";
            this.fileGenerationLocation.Size = new System.Drawing.Size(310, 20);
            this.fileGenerationLocation.TabIndex = 19;
            // 
            // browseButton
            // 
            this.browseButton.Location = new System.Drawing.Point(527, 197);
            this.browseButton.Name = "browseButton";
            this.browseButton.Size = new System.Drawing.Size(26, 20);
            this.browseButton.TabIndex = 20;
            this.browseButton.Text = "...";
            this.browseButton.UseVisualStyleBackColor = true;
            this.browseButton.Click += new System.EventHandler(this.browseButton_Click);
            // 
            // specifyLocationError
            // 
            this.specifyLocationError.AutoSize = true;
            this.specifyLocationError.ForeColor = System.Drawing.Color.Red;
            this.specifyLocationError.Location = new System.Drawing.Point(102, 232);
            this.specifyLocationError.Name = "specifyLocationError";
            this.specifyLocationError.Size = new System.Drawing.Size(248, 13);
            this.specifyLocationError.TabIndex = 21;
            this.specifyLocationError.Text = "Please specify a valid location to generate the files.";
            this.specifyLocationError.Visible = false;
            // 
            // nameBox
            // 
            this.nameBox.Location = new System.Drawing.Point(63, 37);
            this.nameBox.Name = "nameBox";
            this.nameBox.Size = new System.Drawing.Size(171, 20);
            this.nameBox.TabIndex = 22;
            // 
            // nameLabel
            // 
            this.nameLabel.AutoSize = true;
            this.nameLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.nameLabel.Location = new System.Drawing.Point(12, 38);
            this.nameLabel.Name = "nameLabel";
            this.nameLabel.Size = new System.Drawing.Size(45, 16);
            this.nameLabel.TabIndex = 23;
            this.nameLabel.Text = "Name";
            // 
            // nameError
            // 
            this.nameError.AutoSize = true;
            this.nameError.ForeColor = System.Drawing.Color.Red;
            this.nameError.Location = new System.Drawing.Point(240, 40);
            this.nameError.Name = "nameError";
            this.nameError.Size = new System.Drawing.Size(132, 13);
            this.nameError.TabIndex = 24;
            this.nameError.Text = "Please enter a valid name.";
            this.nameError.Visible = false;
            // 
            // PersonCreationForm
            // 
            this.AcceptButton = this.generateButton;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.cancelButton;
            this.ClientSize = new System.Drawing.Size(561, 257);
            this.Controls.Add(this.nameError);
            this.Controls.Add(this.nameLabel);
            this.Controls.Add(this.nameBox);
            this.Controls.Add(this.specifyLocationError);
            this.Controls.Add(this.browseButton);
            this.Controls.Add(this.fileGenerationLocation);
            this.Controls.Add(this.fileGenLocLabel);
            this.Controls.Add(this.cancelButton);
            this.Controls.Add(this.generateButton);
            this.Controls.Add(this.labelN_1);
            this.Controls.Add(this.labelA_1);
            this.Controls.Add(this.labelE_1);
            this.Controls.Add(this.labelC_1);
            this.Controls.Add(this.labelO_1);
            this.Controls.Add(this.labelN);
            this.Controls.Add(this.numN);
            this.Controls.Add(this.labelA);
            this.Controls.Add(this.numA);
            this.Controls.Add(this.labelE);
            this.Controls.Add(this.numE);
            this.Controls.Add(this.labelC);
            this.Controls.Add(this.numC);
            this.Controls.Add(this.labelO);
            this.Controls.Add(this.numO);
            this.Controls.Add(this.menuStrip1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "PersonCreationForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Person Creation Tool";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numO)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numC)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numE)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numA)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numN)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem newToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem openToolStripMenuItem;
        private System.Windows.Forms.NumericUpDown numO;
        private System.Windows.Forms.Label labelO;
        private System.Windows.Forms.Label labelC;
        private System.Windows.Forms.NumericUpDown numC;
        private System.Windows.Forms.Label labelE;
        private System.Windows.Forms.NumericUpDown numE;
        private System.Windows.Forms.Label labelA;
        private System.Windows.Forms.NumericUpDown numA;
        private System.Windows.Forms.Label labelN;
        private System.Windows.Forms.NumericUpDown numN;
        private System.Windows.Forms.Label labelO_1;
        private System.Windows.Forms.Label labelC_1;
        private System.Windows.Forms.Label labelE_1;
        private System.Windows.Forms.Label labelA_1;
        private System.Windows.Forms.Label labelN_1;
        private System.Windows.Forms.Button generateButton;
        private System.Windows.Forms.Button cancelButton;
        private System.Windows.Forms.Label fileGenLocLabel;
        private System.Windows.Forms.TextBox fileGenerationLocation;
        private System.Windows.Forms.FolderBrowserDialog folderBrowserDialog1;
        private System.Windows.Forms.Button browseButton;
        private System.Windows.Forms.Label specifyLocationError;
        private System.Windows.Forms.TextBox nameBox;
        private System.Windows.Forms.Label nameLabel;
        private System.Windows.Forms.Label nameError;
    }
}

