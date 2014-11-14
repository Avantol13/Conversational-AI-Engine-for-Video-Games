package Application;
 import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.SwingConstants;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;

import Conversation.Conversation;
import Conversation.Statement;
import Conversation.Topic;
import Emotions.Emotion;
import People.Person;
import PersonalityTraits.PersonalityTrait;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

/** 
 * TODO improve search functions for searching of topics. Perhaps
 *		sort all the topics by title (quick sort) and then find the 
 *		topic by a simple "phone-book" search.
 */

 // TODO Change number color on change from last statement to easily show changes.

/**
 * The Class Application.
 */
public class Application 
{
    /** The data for the application. */
    protected ApplicationData applicationData;
    
    /** The left statement. */
    protected Statement leftStatement;
    
    /** The right statement. */
    protected Statement rightStatement;
    
    /** The right statement object. */
    private Object rightStatementObject;
    
    /** The left statement object. */
    private Object leftStatementObject;
         
    /** The responder box. */
    private JTextField responderBox;

    /** The initiator box. */
    private JTextField initiatorBox;
    
    /** The decimal format. */
    DecimalFormat decimalFormat;
    
    /** The frm npc conversational ai. */
    private JFrame frmNpcConversationalAi;
    
    /** The Bottom_ right. */
    private JPanel Bottom_Right;
    
    /** The Top_ right. */
    private JPanel Top_Right;
    
    /** The Person info right. */
    private JPanel PersonInfoRight;
    
    /** The txt open to experience_2. */
    private JTextField txtOpenToExperience_2;
    
    /** The text field_27. */
    private JTextField textField_27;
    
    /** The text field_28. */
    private JTextField textField_28;
    
    /** The text field_29. */
    private JTextField textField_29;
    
    /** The text field_30. */
    private JTextField textField_30;
    
    /** The Person right_ o. */
    private JTextField PersonRight_O;
    
    /** The Person right_ c. */
    private JTextField PersonRight_C;
    
    /** The Person right_ e. */
    private JTextField PersonRight_E;
    
    /** The Person right_ a. */
    private JTextField PersonRight_A;
    
    /** The Person right_ n. */
    private JTextField PersonRight_N;
    
    /** The Person right_ joy. */
    private JTextField PersonRight_Joy;
    
    /** The Person right_ sad. */
    private JTextField PersonRight_Sad;
    
    /** The Person right_ anger. */
    private JTextField PersonRight_Anger;
    
    /** The Person right_ fear. */
    private JTextField PersonRight_Fear;
    
    /** The Person right_ trust. */
    private JTextField PersonRight_Trust;
    
    /** The Person right_ surprise. */
    private JTextField PersonRight_Surprise;
    
    /** The Person right_ antic. */
    private JTextField PersonRight_Antic;
    
    /** The Person right_ disgust. */
    private JTextField PersonRight_Disgust;
    
    /** The text field_44. */
    private JTextField textField_44;
    
    /** The text field_45. */
    private JTextField textField_45;
    
    /** The text field_46. */
    private JTextField textField_46;
    
    /** The text field_47. */
    private JTextField textField_47;
    
    /** The txt trust_2. */
    private JTextField txtTrust_2;
    
    /** The text field_49. */
    private JTextField textField_49;
    
    /** The text field_50. */
    private JTextField textField_50;
    
    /** The txt disgust_2. */
    private JTextField txtDisgust_2;
    
    /** The Bottom_ left. */
    private JPanel Bottom_Left;
    
    /** The Top_ left. */
    private JPanel Top_Left;
    
    /** The Statement info right. */
    private JPanel StatementInfoRight;
    
    /** The txt open to experience_3. */
    private JTextField txtOpenToExperience_3;
    
    /** The text field_2. */
    private JTextField textField_2;
    
    /** The text field_3. */
    private JTextField textField_3;
    
    /** The text field_4. */
    private JTextField textField_4;
    
    /** The text field_5. */
    private JTextField textField_5;
    
    /** The Statement right_ o. */
    private JTextField StatementRight_O;
    
    /** The Statement right_ c. */
    private JTextField StatementRight_C;
    
    /** The Statement right_ e. */
    private JTextField StatementRight_E;
    
    /** The Statement right_ a. */
    private JTextField StatementRight_A;
    
    /** The Statement right_ n. */
    private JTextField StatementRight_N;
    
    /** The panel_1. */
    private JPanel panel_1;
    
    /** The Statement right_ joy. */
    private JTextField StatementRight_Joy;
    
    /** The Statement right_ sad. */
    private JTextField StatementRight_Sad;
    
    /** The Statement right_ anger. */
    private JTextField StatementRight_Anger;
    
    /** The Statement right_ fear. */
    private JTextField StatementRight_Fear;
    
    /** The Statement right_ trust. */
    private JTextField StatementRight_Trust;
    
    /** The Statement right_ surprise. */
    private JTextField StatementRight_Surprise;
    
    /** The Statement right_ antic. */
    private JTextField StatementRight_Antic;
    
    /** The Statement right_ disgust. */
    private JTextField StatementRight_Disgust;
    
    /** The text field_19. */
    private JTextField textField_19;
    
    /** The text field_20. */
    private JTextField textField_20;
    
    /** The text field_21. */
    private JTextField textField_21;
    
    /** The text field_22. */
    private JTextField textField_22;
    
    /** The txt trust_3. */
    private JTextField txtTrust_3;
    
    /** The text field_24. */
    private JTextField textField_24;
    
    /** The text field_25. */
    private JTextField textField_25;
    
    /** The txt disgust_3. */
    private JTextField txtDisgust_3;
    
    /** The Person info left. */
    private JPanel PersonInfoLeft;
    
    /** The txt open to experience. */
    private JTextField txtOpenToExperience;
    
    /** The text field_53. */
    private JTextField textField_53;
    
    /** The text field_54. */
    private JTextField textField_54;
    
    /** The text field_55. */
    private JTextField textField_55;
    
    /** The text field_56. */
    private JTextField textField_56;
    
    /** The Person left_ o. */
    private JTextField PersonLeft_O;
    
    /** The Person left_ c. */
    private JTextField PersonLeft_C;
    
    /** The Person left_ e. */
    private JTextField PersonLeft_E;
    
    /** The Person left_ a. */
    private JTextField PersonLeft_A;
    
    /** The Person left_ n. */
    private JTextField PersonLeft_N;
    
    /** The panel_4. */
    private JPanel panel_4;
    
    /** The Person left_ joy. */
    private JTextField PersonLeft_Joy;
    
    /** The Person left_ sad. */
    private JTextField PersonLeft_Sad;
    
    /** The Person left_ anger. */
    private JTextField PersonLeft_Anger;
    
    /** The Person left_ fear. */
    private JTextField PersonLeft_Fear;
    
    /** The Person left_ trust. */
    private JTextField PersonLeft_Trust;
    
    /** The Person left_ surprise. */
    private JTextField PersonLeft_Surprise;
    
    /** The Person left_ antic. */
    private JTextField PersonLeft_Antic;
    
    /** The Person left_ disgust. */
    private JTextField PersonLeft_Disgust;
    
    /** The text field_70. */
    private JTextField textField_70;
    
    /** The text field_71. */
    private JTextField textField_71;
    
    /** The text field_72. */
    private JTextField textField_72;
    
    /** The text field_73. */
    private JTextField textField_73;
    
    /** The txt trust. */
    private JTextField txtTrust;
    
    /** The text field_75. */
    private JTextField textField_75;
    
    /** The text field_76. */
    private JTextField textField_76;
    
    /** The txt disgust. */
    private JTextField txtDisgust;
    
    /** The Statement info left. */
    private JPanel StatementInfoLeft;
    
    /** The txt open to experience_1. */
    private JTextField txtOpenToExperience_1;
    
    /** The text field_79. */
    private JTextField textField_79;
    
    /** The text field_80. */
    private JTextField textField_80;
    
    /** The text field_81. */
    private JTextField textField_81;
    
    /** The text field_82. */
    private JTextField textField_82;
    
    /** The Statement left_ o. */
    private JTextField StatementLeft_O;
    
    /** The Statement left_ c. */
    private JTextField StatementLeft_C;
    
    /** The Statement left_ e. */
    private JTextField StatementLeft_E;
    
    /** The Statement left_ a. */
    private JTextField StatementLeft_A;
    
    /** The Statement left_ n. */
    private JTextField StatementLeft_N;
    
    /** The panel_10. */
    private JPanel panel_10;
    
    /** The Statement left_ joy. */
    private JTextField StatementLeft_Joy;
    
    /** The Statement left_ sadness. */
    private JTextField StatementLeft_Sadness;
    
    /** The Statement left_ anger. */
    private JTextField StatementLeft_Anger;
    
    /** The Statement left_ fear. */
    private JTextField StatementLeft_Fear;
    
    /** The Statement left_ trust. */
    private JTextField StatementLeft_Trust;
    
    /** The Statement left_ surprise. */
    private JTextField StatementLeft_Surprise;
    
    /** The Statement left_ antic. */
    private JTextField StatementLeft_Antic;
    
    /** The Statement left_ disgust. */
    private JTextField StatementLeft_Disgust;
    
    /** The text field_96. */
    private JTextField textField_96;
    
    /** The text field_97. */
    private JTextField textField_97;
    
    /** The text field_98. */
    private JTextField textField_98;
    
    /** The text field_99. */
    private JTextField textField_99;
    
    /** The txt trust_1. */
    private JTextField txtTrust_1;
    
    /** The text field_101. */
    private JTextField textField_101;
    
    /** The text field_102. */
    private JTextField textField_102;
    
    /** The txt disgust_1. */
    private JTextField txtDisgust_1;
    
    /** The Statement select left. */
    private JComboBox StatementSelectLeft;
    
    /** The Statement select right. */
    private JComboBox StatementSelectRight;
    
    /** The vertical strut. */
    private Component verticalStrut;
    
    /** The vertical strut_1. */
    private Component verticalStrut_1;
    
    /** The Topic of conversation. */
    private JTextField topicOfConversationBox;
    
    /** The place holder. */
    private JTextField previousTopicBox;
        
    /** The btn say left. */
    private JButton sayRight;
    
    /** The lbl topic of conversation. */
    private JLabel lblTopicOfConversation;
    
    /** The lbl statement. */
    private JLabel lblStatement;
    
    /** The lbl statement_1. */
    private JLabel lblStatement_1;
    
    /** The lbl previous topic. */
    private JLabel lblPreviousTopic;
	
    /** The panel_7. */
    private JPanel panel_7;
    
    /** The lbl conversation initiator. */
    private JLabel lblConversationInitiator;
    
    /** The horizontal strut. */
    private Component horizontalStrut;
    
    /** The lbl responder. */
    private JLabel lblResponder;
    
    /** The horizontal strut_1. */
    private Component horizontalStrut_1;
    
    /** The start convo. */
    private JButton startConvo;
    
    /** The mntm reset. */
    private JMenuItem mntmReset;
    
    /** The mn conversation. */
    private JMenuItem mnConversation;
    
    /** The mntm load. */
    private JMenu mntmLoad;
    
    /** The mntm topics. */
    private JMenuItem mntmTopics;
    
    /** The mntm people. */
    private JMenuItem mntmPeople;

    /**
     * Launch the application.
     *
     * @param args the arguments
     */
    public static void main(String[] args) 
    {
        EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try 
                {
                    // Set up the look and feel for the interface
                    try 
                    {
                        // Set cross-platform Java L&F (also called "Metal")
                    UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
                    } 
                    catch (UnsupportedLookAndFeelException e) 
                    {
                       // handle exception
                    }
                    catch (ClassNotFoundException e) 
                    {
                       // handle exception
                    }
                    catch (InstantiationException e) 
                    {
                       // handle exception
                    }
                    catch (IllegalAccessException e) 
                    {
                       // handle exception
                    }
                    
                    Application window = new Application();
                    window.frmNpcConversationalAi.setVisible(true);
                } catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Application() 
    {
        decimalFormat = new DecimalFormat("#.##");
        
        // TODO Don't use overrode constructor with no arguments... bad idea b/c null pointers
        applicationData = new ApplicationData();
        
		initializeGUI(this);
    }
        
    /**
     * Searches the given topic for the statement with text specified.
     *
     * @param topic the topic
     * @param text The text of the statement to search for
     * @return the statement with the same text as the input
     */
    public Statement searchStatement(Topic topic, String text)
    {
        LinkedList<Statement> statements = topic.getStatements();
        for(int index = 0; index < statements.size(); index++)
        {
            if (statements.get(index).getText().equals(text))
            {
                return statements.get(index);
            }
        }
        return null;
    }
    
    /**
     * Updates the GUI depending on current variables (selections in boxes).
     */
    @SuppressWarnings("unchecked")
    public void updateLeftGUI()
    {
        // Show all the information from the conversation.
        initiatorBox.setText(applicationData.getCurrentConversation().getInitiator().getName());
        responderBox.setText(applicationData.getCurrentConversation().getResponder().getName());
        try
        {
            topicOfConversationBox.setText(applicationData.getCurrentConversation().getCurrentTopic().getTitle());
            previousTopicBox.setText(applicationData.getCurrentConversation().getPrevTopics().getLast().getTitle());
        }
        catch (NullPointerException exc)
        {
            // Ignore.
        }
        catch (NoSuchElementException exc)
        {
            // Ignore
        }
        
        /** The statements to add to the combo box*/
        String[] statementsString = new String[applicationData.getCurrentConversation().getCurrentTopic().getStatements().size()];            
        for(int count = 0; count < applicationData.getCurrentConversation().getCurrentTopic().getStatements().size(); count++)
        {
            statementsString[count] = applicationData.getCurrentConversation().getCurrentTopic().getStatements().get(count).getText();
        }
        StatementSelectLeft.setModel(new DefaultComboBoxModel(statementsString));
        // It's null to start will, so don't try to do stuff with it
        if (leftStatementObject != null)
        {
            StatementSelectLeft.setSelectedItem(leftStatementObject);
            leftStatement = searchStatement(applicationData.getCurrentConversation().getCurrentTopic(), leftStatementObject.toString());
        }
        
        // Get information from all of the current people and statements to display
        Emotion[] leftPersonEmotions = applicationData.getCurrentConversation().getInitiator().getEmotions();
        PersonalityTrait[] personalityTraits_leftPerson = applicationData.getCurrentConversation().getInitiator().getPersonalityTraits();
        
        try
        {
            double[] minPersonalityTraits_leftStatement = leftStatement.getMinPersonalityTraits();
            double[] delEmotions_leftStatement = leftStatement.getDelEmotions();

            // Left statement minimum personality requirements and delta emotions
            StatementLeft_Joy.setText("" + decimalFormat.format(delEmotions_leftStatement[0]));
            StatementLeft_Sadness.setText("" + decimalFormat.format(delEmotions_leftStatement[1]));
            StatementLeft_Anger.setText("" + decimalFormat.format(delEmotions_leftStatement[2]));
            StatementLeft_Fear.setText("" + decimalFormat.format(delEmotions_leftStatement[3]));
            StatementLeft_Disgust.setText("" + decimalFormat.format(delEmotions_leftStatement[4]));
            StatementLeft_Surprise.setText("" + decimalFormat.format(delEmotions_leftStatement[5]));
            StatementLeft_Antic.setText("" + decimalFormat.format(delEmotions_leftStatement[6]));
            StatementLeft_Trust.setText("" + decimalFormat.format(delEmotions_leftStatement[7]));
            StatementLeft_O.setText("" + decimalFormat.format(minPersonalityTraits_leftStatement[0]));
            StatementLeft_C.setText("" + decimalFormat.format(minPersonalityTraits_leftStatement[1]));
            StatementLeft_E.setText("" + decimalFormat.format(minPersonalityTraits_leftStatement[2]));
            StatementLeft_A.setText("" + decimalFormat.format(minPersonalityTraits_leftStatement[3]));
            StatementLeft_N.setText("" + decimalFormat.format(minPersonalityTraits_leftStatement[4]));
        }
        catch (NullPointerException exc)
        {
            //something wasn't found.... TODO figure out what to do here,
        }
        
        // Left person's current emotions and personality traits
        PersonLeft_Joy.setText("" + decimalFormat.format(leftPersonEmotions[0].getIntensity()));
        PersonLeft_Sad.setText("" + decimalFormat.format(leftPersonEmotions[1].getIntensity()));
        PersonLeft_Anger.setText("" + decimalFormat.format(leftPersonEmotions[2].getIntensity()));
        PersonLeft_Fear.setText("" + decimalFormat.format(leftPersonEmotions[3].getIntensity()));
        PersonLeft_Disgust.setText("" + decimalFormat.format(leftPersonEmotions[4].getIntensity()));
        PersonLeft_Surprise.setText("" + decimalFormat.format(leftPersonEmotions[5].getIntensity()));
        PersonLeft_Antic.setText("" + decimalFormat.format(leftPersonEmotions[6].getIntensity()));
        PersonLeft_Trust.setText("" + decimalFormat.format(leftPersonEmotions[7].getIntensity()));
        PersonLeft_O.setText("" + decimalFormat.format(personalityTraits_leftPerson[0].getIntensity()));
        PersonLeft_C.setText("" + decimalFormat.format(personalityTraits_leftPerson[1].getIntensity()));
        PersonLeft_E.setText("" + decimalFormat.format(personalityTraits_leftPerson[2].getIntensity()));
        PersonLeft_A.setText("" + decimalFormat.format(personalityTraits_leftPerson[3].getIntensity()));
        PersonLeft_N.setText("" + decimalFormat.format(personalityTraits_leftPerson[4].getIntensity()));
        
		// TODO change this to all topics for debugging? 
        // The topics to add to the combo box
        //String[] topicsString = new String[1];
		//topicsString[0] = applicationData.getCurrentConversation().getCurrentTopic().getTitle();
		
        //TopicOfConversation.setText((new DefaultComboBoxModel(topicsString));
    }
    
    /**
     * Updates the GUI depending on current variables (selections in boxes).
     */
    @SuppressWarnings("unchecked")
    public void updateRightGUI()
    {
        // Show all the information from the conversation.
        initiatorBox.setText(applicationData.getCurrentConversation().getInitiator().getName());
        responderBox.setText(applicationData.getCurrentConversation().getResponder().getName());
        
        try
        {
            topicOfConversationBox.setText(applicationData.getCurrentConversation().getCurrentTopic().getTitle());
            previousTopicBox.setText(applicationData.getCurrentConversation().getPrevTopics().getLast().getTitle());
        }
        catch (NullPointerException exc)
        {
            // Ignore.
        }
        catch (NoSuchElementException exc)
        {
            // Ignore
        }
    
        /** The statements to add to the combo box*/
        String[] statementsString2 = new String[applicationData.getCurrentConversation().getCurrentTopic().getStatements().size()];            
        for(int count = 0; count < applicationData.getCurrentConversation().getCurrentTopic().getStatements().size(); count++)
        {
            statementsString2[count] = applicationData.getCurrentConversation().getCurrentTopic().getStatements().get(count).getText();
        }
        StatementSelectRight.setModel(new DefaultComboBoxModel(statementsString2));
        // It's null to start will, so don't try to do stuff with it
        if (rightStatementObject != null)
        {
            StatementSelectRight.setSelectedItem(rightStatementObject);
            rightStatement = searchStatement(applicationData.getCurrentConversation().getCurrentTopic(), rightStatementObject.toString());
        }
        
        // Get information from all of the current people and statements to display
        Emotion[] rightPersonEmotions = applicationData.getCurrentConversation().getResponder().getEmotions();
        PersonalityTrait[] personalityTraits_rightPerson = applicationData.getCurrentConversation().getResponder().getPersonalityTraits();
                        
        try
        {
            double[] minPersonalityTraits_rightStatement = rightStatement.getMinPersonalityTraits();
            double[] delEmotions_rightStatement = rightStatement.getDelEmotions();
            
            // Right statement minimum personality requirements and delta emotions
            StatementRight_Joy.setText("" + decimalFormat.format(delEmotions_rightStatement[0]));
            StatementRight_Sad.setText("" + decimalFormat.format(delEmotions_rightStatement[1]));
            StatementRight_Anger.setText("" + decimalFormat.format(delEmotions_rightStatement[2]));
            StatementRight_Fear.setText("" + decimalFormat.format(delEmotions_rightStatement[3]));
            StatementRight_Disgust.setText("" + decimalFormat.format(delEmotions_rightStatement[4]));
            StatementRight_Surprise.setText("" + decimalFormat.format(delEmotions_rightStatement[5]));
            StatementRight_Antic.setText("" + decimalFormat.format(delEmotions_rightStatement[6]));
            StatementRight_Trust.setText("" + decimalFormat.format(delEmotions_rightStatement[7]));
            StatementRight_O.setText("" + decimalFormat.format(minPersonalityTraits_rightStatement[0]));
            StatementRight_C.setText("" + decimalFormat.format(minPersonalityTraits_rightStatement[1]));
            StatementRight_E.setText("" + decimalFormat.format(minPersonalityTraits_rightStatement[2]));
            StatementRight_A.setText("" + decimalFormat.format(minPersonalityTraits_rightStatement[3]));
            StatementRight_N.setText("" + decimalFormat.format(minPersonalityTraits_rightStatement[4]));
        }
        catch (NullPointerException exc)
        {
            //something wasn't found.... TODO figure out what to do here,
        }
        
        // Right person's current emotions and personality traits
        PersonRight_Joy.setText("" + decimalFormat.format(rightPersonEmotions[0].getIntensity()));
        PersonRight_Sad.setText("" + decimalFormat.format(rightPersonEmotions[1].getIntensity()));
        PersonRight_Anger.setText("" + decimalFormat.format(rightPersonEmotions[2].getIntensity()));
        PersonRight_Fear.setText("" + decimalFormat.format(rightPersonEmotions[3].getIntensity()));
        PersonRight_Disgust.setText("" + decimalFormat.format(rightPersonEmotions[4].getIntensity()));
        PersonRight_Surprise.setText("" + decimalFormat.format(rightPersonEmotions[5].getIntensity()));
        PersonRight_Antic.setText("" + decimalFormat.format(rightPersonEmotions[6].getIntensity()));
        PersonRight_Trust.setText("" + decimalFormat.format(rightPersonEmotions[7].getIntensity()));
        PersonRight_O.setText("" + decimalFormat.format(personalityTraits_rightPerson[0].getIntensity()));
        PersonRight_C.setText("" + decimalFormat.format(personalityTraits_rightPerson[1].getIntensity()));
        PersonRight_E.setText("" + decimalFormat.format(personalityTraits_rightPerson[2].getIntensity()));
        PersonRight_A.setText("" + decimalFormat.format(personalityTraits_rightPerson[3].getIntensity()));
        PersonRight_N.setText("" + decimalFormat.format(personalityTraits_rightPerson[4].getIntensity()));
        
        // TODO change this to all topics for debugging? 
        // The topics to add to the combo box
        //String[] topicsString = new String[1];
        //topicsString[0] = conversation.getCurrentTopic().getTitle();
        
        //TopicOfConversation.setText((new DefaultComboBoxModel(topicsString));
    }
    
    /**
     * Initialize the contents of the frame.
     *
     * @param application the application
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void initializeGUI(final Application application) 
    {
        frmNpcConversationalAi = new JFrame();
        frmNpcConversationalAi.addWindowFocusListener(new WindowFocusListener() 
        {
            public void windowGainedFocus(WindowEvent arg0) 
            {
                if (applicationData.getCurrentConversation() != null)
                {
                    // Set everything up for next statement input.
                    startConvo.setEnabled(true);
                    sayRight.setEnabled(false);
                    StatementSelectLeft.setEnabled(true);
                    StatementSelectRight.setEnabled(false);
                    
                    updateLeftGUI();
                    updateRightGUI();
                }
            }
            public void windowLostFocus(WindowEvent arg0) 
            {
                // Do nothing.
            }
        });
        frmNpcConversationalAi.setTitle("NPC Conversational AI Engine 1.0");
        frmNpcConversationalAi.setBounds(100, 100, 1203, 445);
        frmNpcConversationalAi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar menuBar = new JMenuBar();
        frmNpcConversationalAi.setJMenuBar(menuBar);
        
        JMenu mnMenu = new JMenu("File");
        menuBar.add(mnMenu);
        
        JMenu mntmMenuitem_1 = new JMenu("New");
        mnMenu.add(mntmMenuitem_1);
        
        mnConversation = new JMenuItem("Conversation");
        mnConversation.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent arg0) 
            {
                if (applicationData.getTopics() != null && applicationData.getPeople() != null)
                {
                    // Grab all the topics.
                    Object[] topics = new Object[applicationData.getTopics().size()];
                    for (int index = 0; index < topics.length; index++)
                    {
                        topics[index] = applicationData.getTopics().get(index).getTitle();
                    }
                    
                    String stringTopic = (String)JOptionPane.showInputDialog(
                                        frmNpcConversationalAi,
                                        "Select Starting Topic:\n",
                                        "Conversation Information",
                                        JOptionPane.PLAIN_MESSAGE,
                                        null,
                                        topics,
                                        applicationData.getTopics().get(0).getTitle());
                    Topic startingTopic = searchTopic(stringTopic, applicationData.getTopics());
                    
                    // User entered valid information.
                    if (startingTopic != null)
                    {
                        // Grab all the people.
                        Object[] people = new Object[applicationData.getPeople().size()];
                        for (int index = 0; index < people.length; index++)
                        {
                            people[index] = applicationData.getPeople().get(index).getName();
                        }
                        
                        String stringInitiator = (String)JOptionPane.showInputDialog(
                                            frmNpcConversationalAi,
                                            "Select Initiator:\n",
                                            "Conversation Information",
                                            JOptionPane.PLAIN_MESSAGE,
                                            null,
                                            people,
                                            applicationData.getPeople().get(0).getName());
                        Person initiator = searchPerson(stringInitiator, applicationData.getPeople());
                        
                        // User entered valid information.
                        if (initiator != null)
                        {
                            // Responder.
                            String stringResponder = (String)JOptionPane.showInputDialog(
                                    frmNpcConversationalAi,
                                    "Select Responder:\n",
                                    "Conversation Information",
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    people,
                                    applicationData.getPeople().get(0).getName());
                            Person responder = searchPerson(stringResponder, applicationData.getPeople());
                
                            applicationData.newConversation(new Conversation(initiator, responder, startingTopic));
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, 
                            "Please load topics and people to continue.", 
                            "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        mntmMenuitem_1.add(mnConversation);
        
        mntmLoad = new JMenu("Load");
        mnMenu.add(mntmLoad);
        
        mntmTopics = new JMenuItem("Topics");
        mntmTopics.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent arg0) 
            {
                // Import the topics. If it fails, show error.
                if (!applicationData.importTopics())
                {
                    JOptionPane.showMessageDialog(null, "Error importing XML files as topics.", 
                            "Warning", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Successfully imported topics.", 
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        mntmLoad.add(mntmTopics);
        
        mntmPeople = new JMenuItem("People");
        mntmPeople.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent arg0) 
            {
                // Import the people. If it fails, show error.
                if (!applicationData.importPeople())
                {
                    JOptionPane.showMessageDialog(null, "Error importing XML files as people.", 
                            "Warning", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Successfully imported people.", 
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        mntmLoad.add(mntmPeople);
        
        mntmReset = new JMenuItem("Reset");
        mnMenu.add(mntmReset);
        mntmReset.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if (applicationData.getCurrentConversation() != null)
                {
                    // Set everything up for next statement input.
                    startConvo.setEnabled(true);
                    sayRight.setEnabled(false);
                    StatementSelectLeft.setEnabled(true);
                    StatementSelectRight.setEnabled(false);
                                        
                    // Revert to the original conversation
                    applicationData.newConversation(applicationData.getOriginalConversation());
                    
                    // Reset the people's emotions.
                    double[] zeros = {-1,-1,-1,-1,-1,-1,-1,-1};
                    applicationData.getCurrentConversation().getInitiator().updateEmotions(zeros);
                    applicationData.getCurrentConversation().getResponder().updateEmotions(zeros);
                    
                    // Update the display.
                    updateLeftGUI();
                    updateRightGUI();
                }
            }
        });
        frmNpcConversationalAi.getContentPane().setLayout(new BoxLayout(frmNpcConversationalAi.getContentPane(), BoxLayout.X_AXIS));
        
        JPanel Left = new JPanel();
        Left.setBackground(UIManager.getColor("menu"));
        frmNpcConversationalAi.getContentPane().add(Left);
        GridBagLayout gbl_Left = new GridBagLayout();
        gbl_Left.columnWidths = new int[]{28, 0};
        gbl_Left.rowHeights = new int[]{0, 0, 20, 0, 0, 0, 0, 0, 0, 0};
        gbl_Left.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_Left.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        Left.setLayout(gbl_Left);
        
        initiatorBox = new JTextField();
        initiatorBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        initiatorBox.setHorizontalAlignment(SwingConstants.CENTER);
        initiatorBox.setEditable(false);
		
		/* TODO Remove. Don't need this anymore.
				
        // The people to add to the combo box
        String[] PeopleForComboBox = new String[people.size()];            
        for(int count = 0; count < this.people.size(); count++)
        {
            PeopleForComboBox[count] = this.people.get(count).getName();
        }
        comboBox.setModel(new DefaultComboBoxModel(PeopleForComboBox));
        
		*/
		
        /** INITIALIZE ALL THE COMBO BOXES*/
        StatementSelectRight = new JComboBox();
        StatementSelectRight.setEnabled(false);
        topicOfConversationBox = new JTextField();
        topicOfConversationBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        topicOfConversationBox.setHorizontalAlignment(SwingConstants.CENTER);
        topicOfConversationBox.setEditable(false);
        
        horizontalStrut = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
        gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
        gbc_horizontalStrut.gridx = 0;
        gbc_horizontalStrut.gridy = 0;
        Left.add(horizontalStrut, gbc_horizontalStrut);
        
        lblConversationInitiator = new JLabel("Initiator");
        lblConversationInitiator.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblConversationInitiator = new GridBagConstraints();
        gbc_lblConversationInitiator.insets = new Insets(0, 0, 5, 0);
        gbc_lblConversationInitiator.gridx = 0;
        gbc_lblConversationInitiator.gridy = 1;
        Left.add(lblConversationInitiator, gbc_lblConversationInitiator);
        
        GridBagConstraints gbc_initiatorBox = new GridBagConstraints();
        gbc_initiatorBox.insets = new Insets(0, 0, 5, 0);
        gbc_initiatorBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_initiatorBox.gridx = 0;
        gbc_initiatorBox.gridy = 2;
        Left.add(initiatorBox, gbc_initiatorBox);
        
        Top_Left = new JPanel();
        GridBagConstraints gbc_Top_Left = new GridBagConstraints();
        gbc_Top_Left.insets = new Insets(0, 0, 5, 0);
        gbc_Top_Left.fill = GridBagConstraints.BOTH;
        gbc_Top_Left.gridx = 0;
        gbc_Top_Left.gridy = 3;
        Left.add(Top_Left, gbc_Top_Left);
        GridBagLayout gbl_Top_Left = new GridBagLayout();
        gbl_Top_Left.columnWidths = new int[]{0, 0};
        gbl_Top_Left.rowHeights = new int[]{0, 0};
        gbl_Top_Left.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_Top_Left.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        Top_Left.setLayout(gbl_Top_Left);
        
        PersonInfoLeft = new JPanel();
        GridBagConstraints gbc_PersonInfoLeft = new GridBagConstraints();
        gbc_PersonInfoLeft.fill = GridBagConstraints.BOTH;
        gbc_PersonInfoLeft.gridx = 0;
        gbc_PersonInfoLeft.gridy = 0;
        Top_Left.add(PersonInfoLeft, gbc_PersonInfoLeft);
        GridBagLayout gbl_PersonInfoLeft = new GridBagLayout();
        gbl_PersonInfoLeft.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gbl_PersonInfoLeft.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_PersonInfoLeft.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_PersonInfoLeft.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        PersonInfoLeft.setLayout(gbl_PersonInfoLeft);
        
        txtOpenToExperience = new JTextField();
        txtOpenToExperience.setText("Open to Experience");
        txtOpenToExperience.setHorizontalAlignment(SwingConstants.CENTER);
        txtOpenToExperience.setEditable(false);
        txtOpenToExperience.setColumns(10);
        GridBagConstraints gbc_txtOpenToExperience = new GridBagConstraints();
        gbc_txtOpenToExperience.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtOpenToExperience.insets = new Insets(0, 0, 5, 5);
        gbc_txtOpenToExperience.gridx = 0;
        gbc_txtOpenToExperience.gridy = 0;
        PersonInfoLeft.add(txtOpenToExperience, gbc_txtOpenToExperience);
        
        textField_53 = new JTextField();
        textField_53.setText("Conscientiousness");
        textField_53.setHorizontalAlignment(SwingConstants.CENTER);
        textField_53.setEditable(false);
        textField_53.setColumns(10);
        GridBagConstraints gbc_textField_53 = new GridBagConstraints();
        gbc_textField_53.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_53.insets = new Insets(0, 0, 5, 5);
        gbc_textField_53.gridx = 1;
        gbc_textField_53.gridy = 0;
        PersonInfoLeft.add(textField_53, gbc_textField_53);
        
        textField_54 = new JTextField();
        textField_54.setText("Extraversion");
        textField_54.setHorizontalAlignment(SwingConstants.CENTER);
        textField_54.setEditable(false);
        textField_54.setColumns(10);
        GridBagConstraints gbc_textField_54 = new GridBagConstraints();
        gbc_textField_54.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_54.insets = new Insets(0, 0, 5, 5);
        gbc_textField_54.gridx = 2;
        gbc_textField_54.gridy = 0;
        PersonInfoLeft.add(textField_54, gbc_textField_54);
        
        textField_55 = new JTextField();
        textField_55.setText("Agreeableness");
        textField_55.setHorizontalAlignment(SwingConstants.CENTER);
        textField_55.setEditable(false);
        textField_55.setColumns(10);
        GridBagConstraints gbc_textField_55 = new GridBagConstraints();
        gbc_textField_55.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_55.insets = new Insets(0, 0, 5, 5);
        gbc_textField_55.gridx = 3;
        gbc_textField_55.gridy = 0;
        PersonInfoLeft.add(textField_55, gbc_textField_55);
        
        textField_56 = new JTextField();
        textField_56.setText("Neuroticism");
        textField_56.setHorizontalAlignment(SwingConstants.CENTER);
        textField_56.setEditable(false);
        textField_56.setColumns(10);
        GridBagConstraints gbc_textField_56 = new GridBagConstraints();
        gbc_textField_56.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_56.insets = new Insets(0, 0, 5, 0);
        gbc_textField_56.gridx = 4;
        gbc_textField_56.gridy = 0;
        PersonInfoLeft.add(textField_56, gbc_textField_56);
        
        PersonLeft_O = new JTextField();
        PersonLeft_O.setHorizontalAlignment(SwingConstants.CENTER);
        PersonLeft_O.setEditable(false);
        PersonLeft_O.setColumns(10);
        GridBagConstraints gbc_PersonLeft_O = new GridBagConstraints();
        gbc_PersonLeft_O.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonLeft_O.insets = new Insets(0, 0, 5, 5);
        gbc_PersonLeft_O.gridx = 0;
        gbc_PersonLeft_O.gridy = 1;
        PersonInfoLeft.add(PersonLeft_O, gbc_PersonLeft_O);
        
        PersonLeft_C = new JTextField();
        PersonLeft_C.setHorizontalAlignment(SwingConstants.CENTER);
        PersonLeft_C.setEditable(false);
        PersonLeft_C.setColumns(10);
        GridBagConstraints gbc_PersonLeft_C = new GridBagConstraints();
        gbc_PersonLeft_C.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonLeft_C.insets = new Insets(0, 0, 5, 5);
        gbc_PersonLeft_C.gridx = 1;
        gbc_PersonLeft_C.gridy = 1;
        PersonInfoLeft.add(PersonLeft_C, gbc_PersonLeft_C);
        
        PersonLeft_E = new JTextField();
        PersonLeft_E.setHorizontalAlignment(SwingConstants.CENTER);
        PersonLeft_E.setEditable(false);
        PersonLeft_E.setColumns(10);
        GridBagConstraints gbc_PersonLeft_E = new GridBagConstraints();
        gbc_PersonLeft_E.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonLeft_E.insets = new Insets(0, 0, 5, 5);
        gbc_PersonLeft_E.gridx = 2;
        gbc_PersonLeft_E.gridy = 1;
        PersonInfoLeft.add(PersonLeft_E, gbc_PersonLeft_E);
        
        PersonLeft_A = new JTextField();
        PersonLeft_A.setHorizontalAlignment(SwingConstants.CENTER);
        PersonLeft_A.setEditable(false);
        PersonLeft_A.setColumns(10);
        GridBagConstraints gbc_PersonLeft_A = new GridBagConstraints();
        gbc_PersonLeft_A.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonLeft_A.insets = new Insets(0, 0, 5, 5);
        gbc_PersonLeft_A.gridx = 3;
        gbc_PersonLeft_A.gridy = 1;
        PersonInfoLeft.add(PersonLeft_A, gbc_PersonLeft_A);
        
        PersonLeft_N = new JTextField();
        PersonLeft_N.setHorizontalAlignment(SwingConstants.CENTER);
        PersonLeft_N.setEditable(false);
        PersonLeft_N.setColumns(10);
        GridBagConstraints gbc_PersonLeft_N = new GridBagConstraints();
        gbc_PersonLeft_N.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonLeft_N.insets = new Insets(0, 0, 5, 0);
        gbc_PersonLeft_N.gridx = 4;
        gbc_PersonLeft_N.gridy = 1;
        PersonInfoLeft.add(PersonLeft_N, gbc_PersonLeft_N);
        
        panel_4 = new JPanel();
        GridBagConstraints gbc_panel_4 = new GridBagConstraints();
        gbc_panel_4.fill = GridBagConstraints.BOTH;
        gbc_panel_4.gridwidth = 5;
        gbc_panel_4.insets = new Insets(0, 0, 5, 0);
        gbc_panel_4.gridx = 0;
        gbc_panel_4.gridy = 2;
        PersonInfoLeft.add(panel_4, gbc_panel_4);
        GridBagLayout gbl_panel_4 = new GridBagLayout();
        gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel_4.rowHeights = new int[]{0, 0, 0};
        gbl_panel_4.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_panel_4.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        panel_4.setLayout(gbl_panel_4);
        
        PersonLeft_Joy = new JTextField();
        PersonLeft_Joy.setHorizontalAlignment(SwingConstants.CENTER);
        PersonLeft_Joy.setEditable(false);
        PersonLeft_Joy.setColumns(10);
        GridBagConstraints gbc_PersonLeft_Joy = new GridBagConstraints();
        gbc_PersonLeft_Joy.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonLeft_Joy.insets = new Insets(0, 0, 5, 5);
        gbc_PersonLeft_Joy.gridx = 0;
        gbc_PersonLeft_Joy.gridy = 0;
        panel_4.add(PersonLeft_Joy, gbc_PersonLeft_Joy);
        
        PersonLeft_Sad = new JTextField();
        PersonLeft_Sad.setHorizontalAlignment(SwingConstants.CENTER);
        PersonLeft_Sad.setEditable(false);
        PersonLeft_Sad.setColumns(10);
        GridBagConstraints gbc_PersonLeft_Sad = new GridBagConstraints();
        gbc_PersonLeft_Sad.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonLeft_Sad.insets = new Insets(0, 0, 5, 5);
        gbc_PersonLeft_Sad.gridx = 1;
        gbc_PersonLeft_Sad.gridy = 0;
        panel_4.add(PersonLeft_Sad, gbc_PersonLeft_Sad);
        
        PersonLeft_Anger = new JTextField();
        PersonLeft_Anger.setHorizontalAlignment(SwingConstants.CENTER);
        PersonLeft_Anger.setEditable(false);
        PersonLeft_Anger.setColumns(10);
        GridBagConstraints gbc_PersonLeft_Anger = new GridBagConstraints();
        gbc_PersonLeft_Anger.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonLeft_Anger.insets = new Insets(0, 0, 5, 5);
        gbc_PersonLeft_Anger.gridx = 2;
        gbc_PersonLeft_Anger.gridy = 0;
        panel_4.add(PersonLeft_Anger, gbc_PersonLeft_Anger);
        
        PersonLeft_Fear = new JTextField();
        PersonLeft_Fear.setHorizontalAlignment(SwingConstants.CENTER);
        PersonLeft_Fear.setEditable(false);
        PersonLeft_Fear.setColumns(10);
        GridBagConstraints gbc_PersonLeft_Fear = new GridBagConstraints();
        gbc_PersonLeft_Fear.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonLeft_Fear.insets = new Insets(0, 0, 5, 5);
        gbc_PersonLeft_Fear.gridx = 3;
        gbc_PersonLeft_Fear.gridy = 0;
        panel_4.add(PersonLeft_Fear, gbc_PersonLeft_Fear);
        
        PersonLeft_Trust = new JTextField();
        PersonLeft_Trust.setHorizontalAlignment(SwingConstants.CENTER);
        PersonLeft_Trust.setEditable(false);
        PersonLeft_Trust.setColumns(10);
        GridBagConstraints gbc_PersonLeft_Trust = new GridBagConstraints();
        gbc_PersonLeft_Trust.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonLeft_Trust.insets = new Insets(0, 0, 5, 5);
        gbc_PersonLeft_Trust.gridx = 4;
        gbc_PersonLeft_Trust.gridy = 0;
        panel_4.add(PersonLeft_Trust, gbc_PersonLeft_Trust);
        
        PersonLeft_Surprise = new JTextField();
        PersonLeft_Surprise.setHorizontalAlignment(SwingConstants.CENTER);
        PersonLeft_Surprise.setEditable(false);
        PersonLeft_Surprise.setColumns(10);
        GridBagConstraints gbc_PersonLeft_Surprise = new GridBagConstraints();
        gbc_PersonLeft_Surprise.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonLeft_Surprise.insets = new Insets(0, 0, 5, 5);
        gbc_PersonLeft_Surprise.gridx = 5;
        gbc_PersonLeft_Surprise.gridy = 0;
        panel_4.add(PersonLeft_Surprise, gbc_PersonLeft_Surprise);
        
        PersonLeft_Antic = new JTextField();
        PersonLeft_Antic.setHorizontalAlignment(SwingConstants.CENTER);
        PersonLeft_Antic.setEditable(false);
        PersonLeft_Antic.setColumns(10);
        GridBagConstraints gbc_PersonLeft_Antic = new GridBagConstraints();
        gbc_PersonLeft_Antic.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonLeft_Antic.insets = new Insets(0, 0, 5, 5);
        gbc_PersonLeft_Antic.gridx = 6;
        gbc_PersonLeft_Antic.gridy = 0;
        panel_4.add(PersonLeft_Antic, gbc_PersonLeft_Antic);
        
        PersonLeft_Disgust = new JTextField();
        PersonLeft_Disgust.setHorizontalAlignment(SwingConstants.CENTER);
        PersonLeft_Disgust.setEditable(false);
        PersonLeft_Disgust.setColumns(10);
        GridBagConstraints gbc_PersonLeft_Disgust = new GridBagConstraints();
        gbc_PersonLeft_Disgust.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonLeft_Disgust.insets = new Insets(0, 0, 5, 0);
        gbc_PersonLeft_Disgust.gridx = 7;
        gbc_PersonLeft_Disgust.gridy = 0;
        panel_4.add(PersonLeft_Disgust, gbc_PersonLeft_Disgust);
        
        textField_70 = new JTextField();
        textField_70.setText("Joy");
        textField_70.setHorizontalAlignment(SwingConstants.CENTER);
        textField_70.setEditable(false);
        textField_70.setColumns(10);
        GridBagConstraints gbc_textField_70 = new GridBagConstraints();
        gbc_textField_70.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_70.insets = new Insets(0, 0, 0, 5);
        gbc_textField_70.gridx = 0;
        gbc_textField_70.gridy = 1;
        panel_4.add(textField_70, gbc_textField_70);
        
        textField_71 = new JTextField();
        textField_71.setText("Sadness");
        textField_71.setHorizontalAlignment(SwingConstants.CENTER);
        textField_71.setEditable(false);
        textField_71.setColumns(10);
        GridBagConstraints gbc_textField_71 = new GridBagConstraints();
        gbc_textField_71.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_71.insets = new Insets(0, 0, 0, 5);
        gbc_textField_71.gridx = 1;
        gbc_textField_71.gridy = 1;
        panel_4.add(textField_71, gbc_textField_71);
        
        textField_72 = new JTextField();
        textField_72.setText("Anger");
        textField_72.setHorizontalAlignment(SwingConstants.CENTER);
        textField_72.setEditable(false);
        textField_72.setColumns(10);
        GridBagConstraints gbc_textField_72 = new GridBagConstraints();
        gbc_textField_72.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_72.insets = new Insets(0, 0, 0, 5);
        gbc_textField_72.gridx = 2;
        gbc_textField_72.gridy = 1;
        panel_4.add(textField_72, gbc_textField_72);
        
        textField_73 = new JTextField();
        textField_73.setText("Fear");
        textField_73.setHorizontalAlignment(SwingConstants.CENTER);
        textField_73.setEditable(false);
        textField_73.setColumns(10);
        GridBagConstraints gbc_textField_73 = new GridBagConstraints();
        gbc_textField_73.fill = GridBagConstraints.BOTH;
        gbc_textField_73.insets = new Insets(0, 0, 0, 5);
        gbc_textField_73.gridx = 3;
        gbc_textField_73.gridy = 1;
        panel_4.add(textField_73, gbc_textField_73);
        
        txtTrust = new JTextField();
        txtTrust.setText("Trust");
        txtTrust.setHorizontalAlignment(SwingConstants.CENTER);
        txtTrust.setEditable(false);
        txtTrust.setColumns(10);
        GridBagConstraints gbc_txtTrust = new GridBagConstraints();
        gbc_txtTrust.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtTrust.insets = new Insets(0, 0, 0, 5);
        gbc_txtTrust.gridx = 4;
        gbc_txtTrust.gridy = 1;
        panel_4.add(txtTrust, gbc_txtTrust);
        
        textField_75 = new JTextField();
        textField_75.setText("Surprise");
        textField_75.setHorizontalAlignment(SwingConstants.CENTER);
        textField_75.setEditable(false);
        textField_75.setColumns(10);
        GridBagConstraints gbc_textField_75 = new GridBagConstraints();
        gbc_textField_75.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_75.insets = new Insets(0, 0, 0, 5);
        gbc_textField_75.gridx = 5;
        gbc_textField_75.gridy = 1;
        panel_4.add(textField_75, gbc_textField_75);
        
        textField_76 = new JTextField();
        textField_76.setText("Anticipation");
        textField_76.setHorizontalAlignment(SwingConstants.CENTER);
        textField_76.setEditable(false);
        textField_76.setColumns(10);
        GridBagConstraints gbc_textField_76 = new GridBagConstraints();
        gbc_textField_76.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_76.insets = new Insets(0, 0, 0, 5);
        gbc_textField_76.gridx = 6;
        gbc_textField_76.gridy = 1;
        panel_4.add(textField_76, gbc_textField_76);
        
        txtDisgust = new JTextField();
        txtDisgust.setText("Disgust");
        txtDisgust.setHorizontalAlignment(SwingConstants.CENTER);
        txtDisgust.setEditable(false);
        txtDisgust.setColumns(10);
        GridBagConstraints gbc_txtDisgust = new GridBagConstraints();
        gbc_txtDisgust.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtDisgust.gridx = 7;
        gbc_txtDisgust.gridy = 1;
        panel_4.add(txtDisgust, gbc_txtDisgust);
        
        lblPreviousTopic = new JLabel("Previous Topic");
        lblPreviousTopic.setFont(new Font("Tahoma", Font.BOLD, 12));
        GridBagConstraints gbc_lblPreviousTopic = new GridBagConstraints();
        gbc_lblPreviousTopic.insets = new Insets(0, 0, 5, 0);
        gbc_lblPreviousTopic.gridx = 0;
        gbc_lblPreviousTopic.gridy = 4;
        Left.add(lblPreviousTopic, gbc_lblPreviousTopic);
        
        previousTopicBox = new JTextField();
        previousTopicBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        previousTopicBox.setHorizontalAlignment(SwingConstants.CENTER);
        previousTopicBox.setEditable(false);
        GridBagConstraints gbc_previousTopicBox = new GridBagConstraints();
        gbc_previousTopicBox.insets = new Insets(0, 0, 5, 0);
        gbc_previousTopicBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_previousTopicBox.gridx = 0;
        gbc_previousTopicBox.gridy = 5;
        Left.add(previousTopicBox, gbc_previousTopicBox);
        
        lblStatement_1 = new JLabel("Statement");
        lblStatement_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblStatement_1 = new GridBagConstraints();
        gbc_lblStatement_1.insets = new Insets(0, 0, 5, 0);
        gbc_lblStatement_1.gridx = 0;
        gbc_lblStatement_1.gridy = 6;
        Left.add(lblStatement_1, gbc_lblStatement_1);
        StatementSelectLeft = new JComboBox();
        StatementSelectLeft.setEnabled(false);
        
        
        GridBagConstraints gbc_StatementSelectLeft = new GridBagConstraints();
        gbc_StatementSelectLeft.insets = new Insets(0, 0, 5, 0);
        gbc_StatementSelectLeft.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementSelectLeft.gridx = 0;
        gbc_StatementSelectLeft.gridy = 7;
        Left.add(StatementSelectLeft, gbc_StatementSelectLeft);
        StatementSelectLeft.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
				// Make sure there's a conversation to work with. 
				if (applicationData.getCurrentConversation() != null)
				{
					String statementText = StatementSelectLeft.getSelectedItem().toString();
					if (searchStatement(applicationData.getCurrentConversation().getCurrentTopic(), statementText) != null)
					{
						leftStatement = searchStatement(applicationData.getCurrentConversation().getCurrentTopic(), statementText);
						leftStatementObject = StatementSelectLeft.getSelectedItem();
					}
					updateLeftGUI();
				}
				else
				{
					JOptionPane.showMessageDialog(null, 
					"Please create a conversation to continue.", 
					"Warning", JOptionPane.WARNING_MESSAGE);
				}
            }
        });
          
        Bottom_Left = new JPanel();
        GridBagConstraints gbc_Bottom_Left = new GridBagConstraints();
        gbc_Bottom_Left.fill = GridBagConstraints.BOTH;
        gbc_Bottom_Left.gridx = 0;
        gbc_Bottom_Left.gridy = 8;
        Left.add(Bottom_Left, gbc_Bottom_Left);
        GridBagLayout gbl_Bottom_Left = new GridBagLayout();
        gbl_Bottom_Left.columnWidths = new int[]{0, 0};
        gbl_Bottom_Left.rowHeights = new int[]{0, 0};
        gbl_Bottom_Left.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_Bottom_Left.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        Bottom_Left.setLayout(gbl_Bottom_Left);
        
        StatementInfoLeft = new JPanel();
        GridBagConstraints gbc_StatementInfoLeft = new GridBagConstraints();
        gbc_StatementInfoLeft.fill = GridBagConstraints.BOTH;
        gbc_StatementInfoLeft.gridx = 0;
        gbc_StatementInfoLeft.gridy = 0;
        
        Bottom_Left.add(StatementInfoLeft, gbc_StatementInfoLeft);
        GridBagLayout gbl_StatementInfoLeft = new GridBagLayout();
        gbl_StatementInfoLeft.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gbl_StatementInfoLeft.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_StatementInfoLeft.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_StatementInfoLeft.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        StatementInfoLeft.setLayout(gbl_StatementInfoLeft);
        
        txtOpenToExperience_1 = new JTextField();
        txtOpenToExperience_1.setText("Open to Experience");
        txtOpenToExperience_1.setHorizontalAlignment(SwingConstants.CENTER);
        txtOpenToExperience_1.setEditable(false);
        txtOpenToExperience_1.setColumns(10);
        GridBagConstraints gbc_txtOpenToExperience_1 = new GridBagConstraints();
        gbc_txtOpenToExperience_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtOpenToExperience_1.insets = new Insets(0, 0, 5, 5);
        gbc_txtOpenToExperience_1.gridx = 0;
        gbc_txtOpenToExperience_1.gridy = 0;
        StatementInfoLeft.add(txtOpenToExperience_1, gbc_txtOpenToExperience_1);
        
        textField_79 = new JTextField();
        textField_79.setText("Conscientiousness");
        textField_79.setHorizontalAlignment(SwingConstants.CENTER);
        textField_79.setEditable(false);
        textField_79.setColumns(10);
        GridBagConstraints gbc_textField_79 = new GridBagConstraints();
        gbc_textField_79.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_79.insets = new Insets(0, 0, 5, 5);
        gbc_textField_79.gridx = 1;
        gbc_textField_79.gridy = 0;
        StatementInfoLeft.add(textField_79, gbc_textField_79);
        
        textField_80 = new JTextField();
        textField_80.setText("Extraversion");
        textField_80.setHorizontalAlignment(SwingConstants.CENTER);
        textField_80.setEditable(false);
        textField_80.setColumns(10);
        GridBagConstraints gbc_textField_80 = new GridBagConstraints();
        gbc_textField_80.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_80.insets = new Insets(0, 0, 5, 5);
        gbc_textField_80.gridx = 2;
        gbc_textField_80.gridy = 0;
        StatementInfoLeft.add(textField_80, gbc_textField_80);
        
        textField_81 = new JTextField();
        textField_81.setText("Agreeableness");
        textField_81.setHorizontalAlignment(SwingConstants.CENTER);
        textField_81.setEditable(false);
        textField_81.setColumns(10);
        GridBagConstraints gbc_textField_81 = new GridBagConstraints();
        gbc_textField_81.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_81.insets = new Insets(0, 0, 5, 5);
        gbc_textField_81.gridx = 3;
        gbc_textField_81.gridy = 0;
        StatementInfoLeft.add(textField_81, gbc_textField_81);
        
        textField_82 = new JTextField();
        textField_82.setText("Neuroticism");
        textField_82.setHorizontalAlignment(SwingConstants.CENTER);
        textField_82.setEditable(false);
        textField_82.setColumns(10);
        GridBagConstraints gbc_textField_82 = new GridBagConstraints();
        gbc_textField_82.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_82.insets = new Insets(0, 0, 5, 0);
        gbc_textField_82.gridx = 4;
        gbc_textField_82.gridy = 0;
        StatementInfoLeft.add(textField_82, gbc_textField_82);
        
        StatementLeft_O = new JTextField();
        StatementLeft_O.setHorizontalAlignment(SwingConstants.CENTER);
        StatementLeft_O.setEditable(false);
        StatementLeft_O.setColumns(10);
        GridBagConstraints gbc_StatementLeft_O = new GridBagConstraints();
        gbc_StatementLeft_O.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementLeft_O.insets = new Insets(0, 0, 5, 5);
        gbc_StatementLeft_O.gridx = 0;
        gbc_StatementLeft_O.gridy = 1;
        StatementInfoLeft.add(StatementLeft_O, gbc_StatementLeft_O);
        
        StatementLeft_C = new JTextField();
        StatementLeft_C.setHorizontalAlignment(SwingConstants.CENTER);
        StatementLeft_C.setEditable(false);
        StatementLeft_C.setColumns(10);
        GridBagConstraints gbc_StatementLeft_C = new GridBagConstraints();
        gbc_StatementLeft_C.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementLeft_C.insets = new Insets(0, 0, 5, 5);
        gbc_StatementLeft_C.gridx = 1;
        gbc_StatementLeft_C.gridy = 1;
        StatementInfoLeft.add(StatementLeft_C, gbc_StatementLeft_C);
        
        StatementLeft_E = new JTextField();
        StatementLeft_E.setHorizontalAlignment(SwingConstants.CENTER);
        StatementLeft_E.setEditable(false);
        StatementLeft_E.setColumns(10);
        GridBagConstraints gbc_StatementLeft_E = new GridBagConstraints();
        gbc_StatementLeft_E.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementLeft_E.insets = new Insets(0, 0, 5, 5);
        gbc_StatementLeft_E.gridx = 2;
        gbc_StatementLeft_E.gridy = 1;
        StatementInfoLeft.add(StatementLeft_E, gbc_StatementLeft_E);
        
        StatementLeft_A = new JTextField();
        StatementLeft_A.setHorizontalAlignment(SwingConstants.CENTER);
        StatementLeft_A.setEditable(false);
        StatementLeft_A.setColumns(10);
        GridBagConstraints gbc_StatementLeft_A = new GridBagConstraints();
        gbc_StatementLeft_A.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementLeft_A.insets = new Insets(0, 0, 5, 5);
        gbc_StatementLeft_A.gridx = 3;
        gbc_StatementLeft_A.gridy = 1;
        StatementInfoLeft.add(StatementLeft_A, gbc_StatementLeft_A);
        
        StatementLeft_N = new JTextField();
        StatementLeft_N.setHorizontalAlignment(SwingConstants.CENTER);
        StatementLeft_N.setEditable(false);
        StatementLeft_N.setColumns(10);
        GridBagConstraints gbc_StatementLeft_N = new GridBagConstraints();
        gbc_StatementLeft_N.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementLeft_N.insets = new Insets(0, 0, 5, 0);
        gbc_StatementLeft_N.gridx = 4;
        gbc_StatementLeft_N.gridy = 1;
        StatementInfoLeft.add(StatementLeft_N, gbc_StatementLeft_N);
        
        panel_10 = new JPanel();
        GridBagConstraints gbc_panel_10 = new GridBagConstraints();
        gbc_panel_10.fill = GridBagConstraints.BOTH;
        gbc_panel_10.gridwidth = 5;
        gbc_panel_10.insets = new Insets(0, 0, 5, 0);
        gbc_panel_10.gridx = 0;
        gbc_panel_10.gridy = 2;
        StatementInfoLeft.add(panel_10, gbc_panel_10);
        GridBagLayout gbl_panel_10 = new GridBagLayout();
        gbl_panel_10.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel_10.rowHeights = new int[]{0, 0, 0, 0};
        gbl_panel_10.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_panel_10.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_10.setLayout(gbl_panel_10);
        
        StatementLeft_Joy = new JTextField();
        StatementLeft_Joy.setHorizontalAlignment(SwingConstants.CENTER);
        StatementLeft_Joy.setEditable(false);
        StatementLeft_Joy.setColumns(10);
        GridBagConstraints gbc_StatementLeft_Joy = new GridBagConstraints();
        gbc_StatementLeft_Joy.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementLeft_Joy.insets = new Insets(0, 0, 5, 5);
        gbc_StatementLeft_Joy.gridx = 0;
        gbc_StatementLeft_Joy.gridy = 0;
        panel_10.add(StatementLeft_Joy, gbc_StatementLeft_Joy);
        
        StatementLeft_Sadness = new JTextField();
        StatementLeft_Sadness.setHorizontalAlignment(SwingConstants.CENTER);
        StatementLeft_Sadness.setEditable(false);
        StatementLeft_Sadness.setColumns(10);
        GridBagConstraints gbc_StatementLeft_Sadness = new GridBagConstraints();
        gbc_StatementLeft_Sadness.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementLeft_Sadness.insets = new Insets(0, 0, 5, 5);
        gbc_StatementLeft_Sadness.gridx = 1;
        gbc_StatementLeft_Sadness.gridy = 0;
        panel_10.add(StatementLeft_Sadness, gbc_StatementLeft_Sadness);
        
        StatementLeft_Anger = new JTextField();
        StatementLeft_Anger.setHorizontalAlignment(SwingConstants.CENTER);
        StatementLeft_Anger.setEditable(false);
        StatementLeft_Anger.setColumns(10);
        GridBagConstraints gbc_StatementLeft_Anger = new GridBagConstraints();
        gbc_StatementLeft_Anger.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementLeft_Anger.insets = new Insets(0, 0, 5, 5);
        gbc_StatementLeft_Anger.gridx = 2;
        gbc_StatementLeft_Anger.gridy = 0;
        panel_10.add(StatementLeft_Anger, gbc_StatementLeft_Anger);
        
        StatementLeft_Fear = new JTextField();
        StatementLeft_Fear.setHorizontalAlignment(SwingConstants.CENTER);
        StatementLeft_Fear.setEditable(false);
        StatementLeft_Fear.setColumns(10);
        GridBagConstraints gbc_StatementLeft_Fear = new GridBagConstraints();
        gbc_StatementLeft_Fear.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementLeft_Fear.insets = new Insets(0, 0, 5, 5);
        gbc_StatementLeft_Fear.gridx = 3;
        gbc_StatementLeft_Fear.gridy = 0;
        panel_10.add(StatementLeft_Fear, gbc_StatementLeft_Fear);
        
        StatementLeft_Trust = new JTextField();
        StatementLeft_Trust.setHorizontalAlignment(SwingConstants.CENTER);
        StatementLeft_Trust.setEditable(false);
        StatementLeft_Trust.setColumns(10);
        GridBagConstraints gbc_StatementLeft_Trust = new GridBagConstraints();
        gbc_StatementLeft_Trust.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementLeft_Trust.insets = new Insets(0, 0, 5, 5);
        gbc_StatementLeft_Trust.gridx = 4;
        gbc_StatementLeft_Trust.gridy = 0;
        panel_10.add(StatementLeft_Trust, gbc_StatementLeft_Trust);
        
        StatementLeft_Surprise = new JTextField();
        StatementLeft_Surprise.setHorizontalAlignment(SwingConstants.CENTER);
        StatementLeft_Surprise.setEditable(false);
        StatementLeft_Surprise.setColumns(10);
        GridBagConstraints gbc_StatementLeft_Surprise = new GridBagConstraints();
        gbc_StatementLeft_Surprise.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementLeft_Surprise.insets = new Insets(0, 0, 5, 5);
        gbc_StatementLeft_Surprise.gridx = 5;
        gbc_StatementLeft_Surprise.gridy = 0;
        panel_10.add(StatementLeft_Surprise, gbc_StatementLeft_Surprise);
        
        StatementLeft_Antic = new JTextField();
        StatementLeft_Antic.setHorizontalAlignment(SwingConstants.CENTER);
        StatementLeft_Antic.setEditable(false);
        StatementLeft_Antic.setColumns(10);
        GridBagConstraints gbc_StatementLeft_Antic = new GridBagConstraints();
        gbc_StatementLeft_Antic.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementLeft_Antic.insets = new Insets(0, 0, 5, 5);
        gbc_StatementLeft_Antic.gridx = 6;
        gbc_StatementLeft_Antic.gridy = 0;
        panel_10.add(StatementLeft_Antic, gbc_StatementLeft_Antic);
        
        StatementLeft_Disgust = new JTextField();
        StatementLeft_Disgust.setHorizontalAlignment(SwingConstants.CENTER);
        StatementLeft_Disgust.setEditable(false);
        StatementLeft_Disgust.setColumns(10);
        GridBagConstraints gbc_StatementLeft_Disgust = new GridBagConstraints();
        gbc_StatementLeft_Disgust.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementLeft_Disgust.insets = new Insets(0, 0, 5, 0);
        gbc_StatementLeft_Disgust.gridx = 7;
        gbc_StatementLeft_Disgust.gridy = 0;
        panel_10.add(StatementLeft_Disgust, gbc_StatementLeft_Disgust);
        
        textField_96 = new JTextField();
        textField_96.setText("Joy");
        textField_96.setHorizontalAlignment(SwingConstants.CENTER);
        textField_96.setEditable(false);
        textField_96.setColumns(10);
        GridBagConstraints gbc_textField_96 = new GridBagConstraints();
        gbc_textField_96.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_96.insets = new Insets(0, 0, 5, 5);
        gbc_textField_96.gridx = 0;
        gbc_textField_96.gridy = 1;
        panel_10.add(textField_96, gbc_textField_96);
        
        textField_97 = new JTextField();
        textField_97.setText("Sadness");
        textField_97.setHorizontalAlignment(SwingConstants.CENTER);
        textField_97.setEditable(false);
        textField_97.setColumns(10);
        GridBagConstraints gbc_textField_97 = new GridBagConstraints();
        gbc_textField_97.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_97.insets = new Insets(0, 0, 5, 5);
        gbc_textField_97.gridx = 1;
        gbc_textField_97.gridy = 1;
        panel_10.add(textField_97, gbc_textField_97);
        
        textField_98 = new JTextField();
        textField_98.setText("Anger");
        textField_98.setHorizontalAlignment(SwingConstants.CENTER);
        textField_98.setEditable(false);
        textField_98.setColumns(10);
        GridBagConstraints gbc_textField_98 = new GridBagConstraints();
        gbc_textField_98.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_98.insets = new Insets(0, 0, 5, 5);
        gbc_textField_98.gridx = 2;
        gbc_textField_98.gridy = 1;
        panel_10.add(textField_98, gbc_textField_98);
        
        textField_99 = new JTextField();
        textField_99.setText("Fear");
        textField_99.setHorizontalAlignment(SwingConstants.CENTER);
        textField_99.setEditable(false);
        textField_99.setColumns(10);
        GridBagConstraints gbc_textField_99 = new GridBagConstraints();
        gbc_textField_99.fill = GridBagConstraints.BOTH;
        gbc_textField_99.insets = new Insets(0, 0, 5, 5);
        gbc_textField_99.gridx = 3;
        gbc_textField_99.gridy = 1;
        panel_10.add(textField_99, gbc_textField_99);
        
        txtTrust_1 = new JTextField();
        txtTrust_1.setText("Trust");
        txtTrust_1.setHorizontalAlignment(SwingConstants.CENTER);
        txtTrust_1.setEditable(false);
        txtTrust_1.setColumns(10);
        GridBagConstraints gbc_txtTrust_1 = new GridBagConstraints();
        gbc_txtTrust_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtTrust_1.insets = new Insets(0, 0, 5, 5);
        gbc_txtTrust_1.gridx = 4;
        gbc_txtTrust_1.gridy = 1;
        panel_10.add(txtTrust_1, gbc_txtTrust_1);
        
        textField_101 = new JTextField();
        textField_101.setText("Surprise");
        textField_101.setHorizontalAlignment(SwingConstants.CENTER);
        textField_101.setEditable(false);
        textField_101.setColumns(10);
        GridBagConstraints gbc_textField_101 = new GridBagConstraints();
        gbc_textField_101.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_101.insets = new Insets(0, 0, 5, 5);
        gbc_textField_101.gridx = 5;
        gbc_textField_101.gridy = 1;
        panel_10.add(textField_101, gbc_textField_101);
        
        textField_102 = new JTextField();
        textField_102.setText("Anticipation");
        textField_102.setHorizontalAlignment(SwingConstants.CENTER);
        textField_102.setEditable(false);
        textField_102.setColumns(10);
        GridBagConstraints gbc_textField_102 = new GridBagConstraints();
        gbc_textField_102.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_102.insets = new Insets(0, 0, 5, 5);
        gbc_textField_102.gridx = 6;
        gbc_textField_102.gridy = 1;
        panel_10.add(textField_102, gbc_textField_102);
        
        txtDisgust_1 = new JTextField();
        txtDisgust_1.setText("Disgust");
        txtDisgust_1.setHorizontalAlignment(SwingConstants.CENTER);
        txtDisgust_1.setEditable(false);
        txtDisgust_1.setColumns(10);
        GridBagConstraints gbc_txtDisgust_1 = new GridBagConstraints();
        gbc_txtDisgust_1.insets = new Insets(0, 0, 5, 0);
        gbc_txtDisgust_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtDisgust_1.gridx = 7;
        gbc_txtDisgust_1.gridy = 1;
        panel_10.add(txtDisgust_1, gbc_txtDisgust_1);
        
        startConvo = new JButton("Say");
        startConvo.setEnabled(false);
        startConvo.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                // Make sure the conversation has begun. Button should be disabled.
                if (applicationData.getCurrentConversation() != null)
                {
                    // Update.
                    updateLeftGUI();
                    
                    // Set everything up for next statement input.
                    startConvo.setEnabled(false);
                    sayRight.setEnabled(true);
                    StatementSelectLeft.setEnabled(false);
                    StatementSelectRight.setEnabled(true);
                    
                    // The user did not change the selection.
                    if (leftStatement == null)
                    {
                        // So grab the first item.
                        leftStatement = searchStatement(applicationData.getCurrentConversation().getCurrentTopic(), 
                                   StatementSelectLeft.getModel().getElementAt(0).toString());
                        
                        // No results were found.
                        if (leftStatement != null)
                        {
                            // Since we're on the left, this is the initiator saying something to the responder.
                            applicationData.getCurrentConversation().say(applicationData.getCurrentConversation().getInitiator(), leftStatement, applicationData.getCurrentConversation().getResponder()); 
                            
                            updateRightGUI(); 
                        }
                        else
                        {
                            //TODO throw statement not found error.
                        }
                    }
                    else
                    {
                        // Since we're on the left, this is the initiator saying something to the responder.
                        applicationData.getCurrentConversation().say(applicationData.getCurrentConversation().getInitiator(), leftStatement, applicationData.getCurrentConversation().getResponder()); 
                        
                        updateRightGUI();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, 
                    "Please link a conversation to the application to continue.", 
                    "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        GridBagConstraints gbc_startConvo = new GridBagConstraints();
        gbc_startConvo.gridwidth = 8;
        gbc_startConvo.insets = new Insets(0, 0, 0, 5);
        gbc_startConvo.gridx = 0;
        gbc_startConvo.gridy = 2;
        panel_10.add(startConvo, gbc_startConvo);
        
        JPanel Right = new JPanel();
        Right.setBackground(UIManager.getColor("menu"));
        frmNpcConversationalAi.getContentPane().add(Right);
        GridBagLayout gbl_Right = new GridBagLayout();
        gbl_Right.columnWidths = new int[]{0, 0, 28, 0};
        gbl_Right.rowHeights = new int[]{0, 0, 20, 0, 0, 0, 0, 0, 0, 0};
        gbl_Right.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_Right.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        Right.setLayout(gbl_Right);
        
        horizontalStrut_1 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
        gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
        gbc_horizontalStrut_1.gridx = 2;
        gbc_horizontalStrut_1.gridy = 0;
        Right.add(horizontalStrut_1, gbc_horizontalStrut_1);
        
        lblResponder = new JLabel("Responder");
        lblResponder.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblResponder = new GridBagConstraints();
        gbc_lblResponder.insets = new Insets(0, 0, 5, 0);
        gbc_lblResponder.gridx = 2;
        gbc_lblResponder.gridy = 1;
        Right.add(lblResponder, gbc_lblResponder);
        
        responderBox = new JTextField();
        responderBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        responderBox.setHorizontalAlignment(SwingConstants.CENTER);
        responderBox.setEditable(false);
		
		/* TODO Remove. Don't need this.
        comboBox_1.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                String name = comboBox_1.getSelectedItem().toString();
                //TODO Fix encapsulation here. I'm passing in a global variable.
                //What the butts? Maybe have an overloaded method with no second
                //parameter and it'll access the global? Probs a good idea...
                  
                rightPerson = searchPerson(name, people);
                updateGUI();
            }
        });
       
        // The people to add to the combo box
        String[] PeopleForComboBox2 = new String[people.size()];            
        for(int count = 0; count < this.people.size(); count++)
        {
            PeopleForComboBox2[count] = this.people.get(count).getName();
        }
        comboBox_1.setModel(new DefaultComboBoxModel(PeopleForComboBox2));
        */
		
        GridBagConstraints gbc_responderBox = new GridBagConstraints();
        gbc_responderBox.insets = new Insets(0, 0, 5, 0);
        gbc_responderBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_responderBox.gridx = 2;
        gbc_responderBox.gridy = 2;
        Right.add(responderBox, gbc_responderBox);
        
        Top_Right = new JPanel();
        GridBagConstraints gbc_Top_Right = new GridBagConstraints();
        gbc_Top_Right.insets = new Insets(0, 0, 5, 0);
        gbc_Top_Right.fill = GridBagConstraints.BOTH;
        gbc_Top_Right.gridx = 2;
        gbc_Top_Right.gridy = 3;
        Right.add(Top_Right, gbc_Top_Right);
        GridBagLayout gbl_Top_Right = new GridBagLayout();
        gbl_Top_Right.columnWidths = new int[]{0, 0};
        gbl_Top_Right.rowHeights = new int[]{0, 0};
        gbl_Top_Right.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_Top_Right.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        Top_Right.setLayout(gbl_Top_Right);
        
        PersonInfoRight = new JPanel();
        GridBagConstraints gbc_PersonInfoRight = new GridBagConstraints();
        gbc_PersonInfoRight.fill = GridBagConstraints.BOTH;
        gbc_PersonInfoRight.gridx = 0;
        gbc_PersonInfoRight.gridy = 0;
        Top_Right.add(PersonInfoRight, gbc_PersonInfoRight);
        GridBagLayout gbl_PersonInfoRight = new GridBagLayout();
        gbl_PersonInfoRight.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gbl_PersonInfoRight.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_PersonInfoRight.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_PersonInfoRight.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        PersonInfoRight.setLayout(gbl_PersonInfoRight);
        
        txtOpenToExperience_2 = new JTextField();
        txtOpenToExperience_2.setText("Open to Experience");
        txtOpenToExperience_2.setHorizontalAlignment(SwingConstants.CENTER);
        txtOpenToExperience_2.setEditable(false);
        txtOpenToExperience_2.setColumns(10);
        GridBagConstraints gbc_txtOpenToExperience_2 = new GridBagConstraints();
        gbc_txtOpenToExperience_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtOpenToExperience_2.insets = new Insets(0, 0, 5, 5);
        gbc_txtOpenToExperience_2.gridx = 0;
        gbc_txtOpenToExperience_2.gridy = 0;
        PersonInfoRight.add(txtOpenToExperience_2, gbc_txtOpenToExperience_2);
        
        textField_27 = new JTextField();
        textField_27.setText("Conscientiousness");
        textField_27.setHorizontalAlignment(SwingConstants.CENTER);
        textField_27.setEditable(false);
        textField_27.setColumns(10);
        GridBagConstraints gbc_textField_27 = new GridBagConstraints();
        gbc_textField_27.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_27.insets = new Insets(0, 0, 5, 5);
        gbc_textField_27.gridx = 1;
        gbc_textField_27.gridy = 0;
        PersonInfoRight.add(textField_27, gbc_textField_27);
        
        textField_28 = new JTextField();
        textField_28.setText("Extraversion");
        textField_28.setHorizontalAlignment(SwingConstants.CENTER);
        textField_28.setEditable(false);
        textField_28.setColumns(10);
        GridBagConstraints gbc_textField_28 = new GridBagConstraints();
        gbc_textField_28.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_28.insets = new Insets(0, 0, 5, 5);
        gbc_textField_28.gridx = 2;
        gbc_textField_28.gridy = 0;
        PersonInfoRight.add(textField_28, gbc_textField_28);
        
        textField_29 = new JTextField();
        textField_29.setText("Agreeableness");
        textField_29.setHorizontalAlignment(SwingConstants.CENTER);
        textField_29.setEditable(false);
        textField_29.setColumns(10);
        GridBagConstraints gbc_textField_29 = new GridBagConstraints();
        gbc_textField_29.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_29.insets = new Insets(0, 0, 5, 5);
        gbc_textField_29.gridx = 3;
        gbc_textField_29.gridy = 0;
        PersonInfoRight.add(textField_29, gbc_textField_29);
        
        textField_30 = new JTextField();
        textField_30.setText("Neuroticism");
        textField_30.setHorizontalAlignment(SwingConstants.CENTER);
        textField_30.setEditable(false);
        textField_30.setColumns(10);
        GridBagConstraints gbc_textField_30 = new GridBagConstraints();
        gbc_textField_30.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_30.insets = new Insets(0, 0, 5, 0);
        gbc_textField_30.gridx = 4;
        gbc_textField_30.gridy = 0;
        PersonInfoRight.add(textField_30, gbc_textField_30);
        
        PersonRight_O = new JTextField();
        PersonRight_O.setHorizontalAlignment(SwingConstants.CENTER);
        PersonRight_O.setEditable(false);
        PersonRight_O.setColumns(10);
        GridBagConstraints gbc_PersonRight_O = new GridBagConstraints();
        gbc_PersonRight_O.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonRight_O.insets = new Insets(0, 0, 5, 5);
        gbc_PersonRight_O.gridx = 0;
        gbc_PersonRight_O.gridy = 1;
        PersonInfoRight.add(PersonRight_O, gbc_PersonRight_O);
        
        PersonRight_C = new JTextField();
        PersonRight_C.setHorizontalAlignment(SwingConstants.CENTER);
        PersonRight_C.setEditable(false);
        PersonRight_C.setColumns(10);
        GridBagConstraints gbc_PersonRight_C = new GridBagConstraints();
        gbc_PersonRight_C.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonRight_C.insets = new Insets(0, 0, 5, 5);
        gbc_PersonRight_C.gridx = 1;
        gbc_PersonRight_C.gridy = 1;
        PersonInfoRight.add(PersonRight_C, gbc_PersonRight_C);
        
        PersonRight_E = new JTextField();
        PersonRight_E.setHorizontalAlignment(SwingConstants.CENTER);
        PersonRight_E.setEditable(false);
        PersonRight_E.setColumns(10);
        GridBagConstraints gbc_PersonRight_E = new GridBagConstraints();
        gbc_PersonRight_E.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonRight_E.insets = new Insets(0, 0, 5, 5);
        gbc_PersonRight_E.gridx = 2;
        gbc_PersonRight_E.gridy = 1;
        PersonInfoRight.add(PersonRight_E, gbc_PersonRight_E);
        
        PersonRight_A = new JTextField();
        PersonRight_A.setHorizontalAlignment(SwingConstants.CENTER);
        PersonRight_A.setEditable(false);
        PersonRight_A.setColumns(10);
        GridBagConstraints gbc_PersonRight_A = new GridBagConstraints();
        gbc_PersonRight_A.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonRight_A.insets = new Insets(0, 0, 5, 5);
        gbc_PersonRight_A.gridx = 3;
        gbc_PersonRight_A.gridy = 1;
        PersonInfoRight.add(PersonRight_A, gbc_PersonRight_A);
        
        PersonRight_N = new JTextField();
        PersonRight_N.setHorizontalAlignment(SwingConstants.CENTER);
        PersonRight_N.setEditable(false);
        PersonRight_N.setColumns(10);
        GridBagConstraints gbc_PersonRight_N = new GridBagConstraints();
        gbc_PersonRight_N.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonRight_N.insets = new Insets(0, 0, 5, 0);
        gbc_PersonRight_N.gridx = 4;
        gbc_PersonRight_N.gridy = 1;
        PersonInfoRight.add(PersonRight_N, gbc_PersonRight_N);
        
        panel_7 = new JPanel();
        GridBagConstraints gbc_panel_7 = new GridBagConstraints();
        gbc_panel_7.fill = GridBagConstraints.BOTH;
        gbc_panel_7.gridwidth = 5;
        gbc_panel_7.insets = new Insets(0, 0, 5, 0);
        gbc_panel_7.gridx = 0;
        gbc_panel_7.gridy = 2;
        PersonInfoRight.add(panel_7, gbc_panel_7);
        GridBagLayout gbl_panel_7 = new GridBagLayout();
        gbl_panel_7.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel_7.rowHeights = new int[]{0, 0, 0};
        gbl_panel_7.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_panel_7.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        panel_7.setLayout(gbl_panel_7);
        
        PersonRight_Joy = new JTextField();
        PersonRight_Joy.setHorizontalAlignment(SwingConstants.CENTER);
        PersonRight_Joy.setEditable(false);
        PersonRight_Joy.setColumns(10);
        GridBagConstraints gbc_PersonRight_Joy = new GridBagConstraints();
        gbc_PersonRight_Joy.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonRight_Joy.insets = new Insets(0, 0, 5, 5);
        gbc_PersonRight_Joy.gridx = 0;
        gbc_PersonRight_Joy.gridy = 0;
        panel_7.add(PersonRight_Joy, gbc_PersonRight_Joy);
        
        PersonRight_Sad = new JTextField();
        PersonRight_Sad.setHorizontalAlignment(SwingConstants.CENTER);
        PersonRight_Sad.setEditable(false);
        PersonRight_Sad.setColumns(10);
        GridBagConstraints gbc_PersonRight_Sad = new GridBagConstraints();
        gbc_PersonRight_Sad.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonRight_Sad.insets = new Insets(0, 0, 5, 5);
        gbc_PersonRight_Sad.gridx = 1;
        gbc_PersonRight_Sad.gridy = 0;
        panel_7.add(PersonRight_Sad, gbc_PersonRight_Sad);
        
        PersonRight_Anger = new JTextField();
        PersonRight_Anger.setHorizontalAlignment(SwingConstants.CENTER);
        PersonRight_Anger.setEditable(false);
        PersonRight_Anger.setColumns(10);
        GridBagConstraints gbc_PersonRight_Anger = new GridBagConstraints();
        gbc_PersonRight_Anger.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonRight_Anger.insets = new Insets(0, 0, 5, 5);
        gbc_PersonRight_Anger.gridx = 2;
        gbc_PersonRight_Anger.gridy = 0;
        panel_7.add(PersonRight_Anger, gbc_PersonRight_Anger);
        
        PersonRight_Fear = new JTextField();
        PersonRight_Fear.setHorizontalAlignment(SwingConstants.CENTER);
        PersonRight_Fear.setEditable(false);
        PersonRight_Fear.setColumns(10);
        GridBagConstraints gbc_PersonRight_Fear = new GridBagConstraints();
        gbc_PersonRight_Fear.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonRight_Fear.insets = new Insets(0, 0, 5, 5);
        gbc_PersonRight_Fear.gridx = 3;
        gbc_PersonRight_Fear.gridy = 0;
        panel_7.add(PersonRight_Fear, gbc_PersonRight_Fear);
        
        PersonRight_Trust = new JTextField();
        PersonRight_Trust.setHorizontalAlignment(SwingConstants.CENTER);
        PersonRight_Trust.setEditable(false);
        PersonRight_Trust.setColumns(10);
        GridBagConstraints gbc_PersonRight_Trust = new GridBagConstraints();
        gbc_PersonRight_Trust.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonRight_Trust.insets = new Insets(0, 0, 5, 5);
        gbc_PersonRight_Trust.gridx = 4;
        gbc_PersonRight_Trust.gridy = 0;
        panel_7.add(PersonRight_Trust, gbc_PersonRight_Trust);
        
        PersonRight_Surprise = new JTextField();
        PersonRight_Surprise.setHorizontalAlignment(SwingConstants.CENTER);
        PersonRight_Surprise.setEditable(false);
        PersonRight_Surprise.setColumns(10);
        GridBagConstraints gbc_PersonRight_Surprise = new GridBagConstraints();
        gbc_PersonRight_Surprise.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonRight_Surprise.insets = new Insets(0, 0, 5, 5);
        gbc_PersonRight_Surprise.gridx = 5;
        gbc_PersonRight_Surprise.gridy = 0;
        panel_7.add(PersonRight_Surprise, gbc_PersonRight_Surprise);
        
        PersonRight_Antic = new JTextField();
        PersonRight_Antic.setHorizontalAlignment(SwingConstants.CENTER);
        PersonRight_Antic.setEditable(false);
        PersonRight_Antic.setColumns(10);
        GridBagConstraints gbc_PersonRight_Antic = new GridBagConstraints();
        gbc_PersonRight_Antic.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonRight_Antic.insets = new Insets(0, 0, 5, 5);
        gbc_PersonRight_Antic.gridx = 6;
        gbc_PersonRight_Antic.gridy = 0;
        panel_7.add(PersonRight_Antic, gbc_PersonRight_Antic);
        
        PersonRight_Disgust = new JTextField();
        PersonRight_Disgust.setHorizontalAlignment(SwingConstants.CENTER);
        PersonRight_Disgust.setEditable(false);
        PersonRight_Disgust.setColumns(10);
        GridBagConstraints gbc_PersonRight_Disgust = new GridBagConstraints();
        gbc_PersonRight_Disgust.fill = GridBagConstraints.HORIZONTAL;
        gbc_PersonRight_Disgust.insets = new Insets(0, 0, 5, 0);
        gbc_PersonRight_Disgust.gridx = 7;
        gbc_PersonRight_Disgust.gridy = 0;
        panel_7.add(PersonRight_Disgust, gbc_PersonRight_Disgust);
        
        textField_44 = new JTextField();
        textField_44.setText("Joy");
        textField_44.setHorizontalAlignment(SwingConstants.CENTER);
        textField_44.setEditable(false);
        textField_44.setColumns(10);
        GridBagConstraints gbc_textField_44 = new GridBagConstraints();
        gbc_textField_44.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_44.insets = new Insets(0, 0, 0, 5);
        gbc_textField_44.gridx = 0;
        gbc_textField_44.gridy = 1;
        panel_7.add(textField_44, gbc_textField_44);
        
        textField_45 = new JTextField();
        textField_45.setText("Sadness");
        textField_45.setHorizontalAlignment(SwingConstants.CENTER);
        textField_45.setEditable(false);
        textField_45.setColumns(10);
        GridBagConstraints gbc_textField_45 = new GridBagConstraints();
        gbc_textField_45.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_45.insets = new Insets(0, 0, 0, 5);
        gbc_textField_45.gridx = 1;
        gbc_textField_45.gridy = 1;
        panel_7.add(textField_45, gbc_textField_45);
        
        textField_46 = new JTextField();
        textField_46.setText("Anger");
        textField_46.setHorizontalAlignment(SwingConstants.CENTER);
        textField_46.setEditable(false);
        textField_46.setColumns(10);
        GridBagConstraints gbc_textField_46 = new GridBagConstraints();
        gbc_textField_46.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_46.insets = new Insets(0, 0, 0, 5);
        gbc_textField_46.gridx = 2;
        gbc_textField_46.gridy = 1;
        panel_7.add(textField_46, gbc_textField_46);
        
        textField_47 = new JTextField();
        textField_47.setText("Fear");
        textField_47.setHorizontalAlignment(SwingConstants.CENTER);
        textField_47.setEditable(false);
        textField_47.setColumns(10);
        GridBagConstraints gbc_textField_47 = new GridBagConstraints();
        gbc_textField_47.fill = GridBagConstraints.BOTH;
        gbc_textField_47.insets = new Insets(0, 0, 0, 5);
        gbc_textField_47.gridx = 3;
        gbc_textField_47.gridy = 1;
        panel_7.add(textField_47, gbc_textField_47);
        
        txtTrust_2 = new JTextField();
        txtTrust_2.setText("Trust");
        txtTrust_2.setHorizontalAlignment(SwingConstants.CENTER);
        txtTrust_2.setEditable(false);
        txtTrust_2.setColumns(10);
        GridBagConstraints gbc_txtTrust_2 = new GridBagConstraints();
        gbc_txtTrust_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtTrust_2.insets = new Insets(0, 0, 0, 5);
        gbc_txtTrust_2.gridx = 4;
        gbc_txtTrust_2.gridy = 1;
        panel_7.add(txtTrust_2, gbc_txtTrust_2);
        
        textField_49 = new JTextField();
        textField_49.setText("Surprise");
        textField_49.setHorizontalAlignment(SwingConstants.CENTER);
        textField_49.setEditable(false);
        textField_49.setColumns(10);
        GridBagConstraints gbc_textField_49 = new GridBagConstraints();
        gbc_textField_49.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_49.insets = new Insets(0, 0, 0, 5);
        gbc_textField_49.gridx = 5;
        gbc_textField_49.gridy = 1;
        panel_7.add(textField_49, gbc_textField_49);
        
        textField_50 = new JTextField();
        textField_50.setText("Anticipation");
        textField_50.setHorizontalAlignment(SwingConstants.CENTER);
        textField_50.setEditable(false);
        textField_50.setColumns(10);
        GridBagConstraints gbc_textField_50 = new GridBagConstraints();
        gbc_textField_50.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_50.insets = new Insets(0, 0, 0, 5);
        gbc_textField_50.gridx = 6;
        gbc_textField_50.gridy = 1;
        panel_7.add(textField_50, gbc_textField_50);
        
        txtDisgust_2 = new JTextField();
        txtDisgust_2.setText("Disgust");
        txtDisgust_2.setHorizontalAlignment(SwingConstants.CENTER);
        txtDisgust_2.setEditable(false);
        txtDisgust_2.setColumns(10);
        GridBagConstraints gbc_txtDisgust_2 = new GridBagConstraints();
        gbc_txtDisgust_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtDisgust_2.gridx = 7;
        gbc_txtDisgust_2.gridy = 1;
        panel_7.add(txtDisgust_2, gbc_txtDisgust_2);
        
        lblTopicOfConversation = new JLabel("Topic of Conversation");
        lblTopicOfConversation.setFont(new Font("Tahoma", Font.BOLD, 12));
        GridBagConstraints gbc_lblTopicOfConversation = new GridBagConstraints();
        gbc_lblTopicOfConversation.insets = new Insets(0, 0, 5, 0);
        gbc_lblTopicOfConversation.gridx = 2;
        gbc_lblTopicOfConversation.gridy = 4;
        Right.add(lblTopicOfConversation, gbc_lblTopicOfConversation);
        
        GridBagConstraints gbc_topicOfConversationBox = new GridBagConstraints();
        gbc_topicOfConversationBox.insets = new Insets(0, 0, 5, 0);
        gbc_topicOfConversationBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_topicOfConversationBox.gridx = 2;
        gbc_topicOfConversationBox.gridy = 5;
        Right.add(topicOfConversationBox, gbc_topicOfConversationBox);
        
        lblStatement = new JLabel("Statement");
        lblStatement.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblStatement = new GridBagConstraints();
        gbc_lblStatement.insets = new Insets(0, 0, 5, 0);
        gbc_lblStatement.gridx = 2;
        gbc_lblStatement.gridy = 6;
        Right.add(lblStatement, gbc_lblStatement);
        
        GridBagConstraints gbc_StatementSelectRight = new GridBagConstraints();
        gbc_StatementSelectRight.insets = new Insets(0, 0, 5, 0);
        gbc_StatementSelectRight.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementSelectRight.gridx = 2;
        gbc_StatementSelectRight.gridy = 7;
        Right.add(StatementSelectRight, gbc_StatementSelectRight);
        
        Bottom_Right = new JPanel();
        GridBagConstraints gbc_Bottom_Right = new GridBagConstraints();
        gbc_Bottom_Right.fill = GridBagConstraints.BOTH;
        gbc_Bottom_Right.gridx = 2;
        gbc_Bottom_Right.gridy = 8;
        Right.add(Bottom_Right, gbc_Bottom_Right);
        
        GridBagLayout gbl_Bottom_Right = new GridBagLayout();
        gbl_Bottom_Right.columnWidths = new int[]{0, 0};
        gbl_Bottom_Right.rowHeights = new int[]{0, 0};
        gbl_Bottom_Right.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_Bottom_Right.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        Bottom_Right.setLayout(gbl_Bottom_Right);
        
        StatementInfoRight = new JPanel();
        GridBagConstraints gbc_StatementInfoRight = new GridBagConstraints();
        gbc_StatementInfoRight.fill = GridBagConstraints.BOTH;
        gbc_StatementInfoRight.gridx = 0;
        gbc_StatementInfoRight.gridy = 0;
        Bottom_Right.add(StatementInfoRight, gbc_StatementInfoRight);
        GridBagLayout gbl_StatementInfoRight = new GridBagLayout();
        gbl_StatementInfoRight.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
        gbl_StatementInfoRight.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_StatementInfoRight.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_StatementInfoRight.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        StatementInfoRight.setLayout(gbl_StatementInfoRight);
        
        txtOpenToExperience_3 = new JTextField();
        txtOpenToExperience_3.setText("Open to Experience");
        txtOpenToExperience_3.setHorizontalAlignment(SwingConstants.CENTER);
        txtOpenToExperience_3.setEditable(false);
        txtOpenToExperience_3.setColumns(10);
        GridBagConstraints gbc_txtOpenToExperience_3 = new GridBagConstraints();
        gbc_txtOpenToExperience_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtOpenToExperience_3.insets = new Insets(0, 0, 5, 5);
        gbc_txtOpenToExperience_3.gridx = 0;
        gbc_txtOpenToExperience_3.gridy = 0;
        StatementInfoRight.add(txtOpenToExperience_3, gbc_txtOpenToExperience_3);
        
        textField_2 = new JTextField();
        textField_2.setText("Conscientiousness");
        textField_2.setHorizontalAlignment(SwingConstants.CENTER);
        textField_2.setEditable(false);
        textField_2.setColumns(10);
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.insets = new Insets(0, 0, 5, 5);
        gbc_textField_2.gridx = 1;
        gbc_textField_2.gridy = 0;
        StatementInfoRight.add(textField_2, gbc_textField_2);
        
        textField_3 = new JTextField();
        textField_3.setText("Extraversion");
        textField_3.setHorizontalAlignment(SwingConstants.CENTER);
        textField_3.setEditable(false);
        textField_3.setColumns(10);
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.insets = new Insets(0, 0, 5, 5);
        gbc_textField_3.gridx = 2;
        gbc_textField_3.gridy = 0;
        StatementInfoRight.add(textField_3, gbc_textField_3);
        
        textField_4 = new JTextField();
        textField_4.setText("Agreeableness");
        textField_4.setHorizontalAlignment(SwingConstants.CENTER);
        textField_4.setEditable(false);
        textField_4.setColumns(10);
        GridBagConstraints gbc_textField_4 = new GridBagConstraints();
        gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_4.insets = new Insets(0, 0, 5, 5);
        gbc_textField_4.gridx = 3;
        gbc_textField_4.gridy = 0;
        StatementInfoRight.add(textField_4, gbc_textField_4);
        
        textField_5 = new JTextField();
        textField_5.setText("Neuroticism");
        textField_5.setHorizontalAlignment(SwingConstants.CENTER);
        textField_5.setEditable(false);
        textField_5.setColumns(10);
        GridBagConstraints gbc_textField_5 = new GridBagConstraints();
        gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_5.insets = new Insets(0, 0, 5, 0);
        gbc_textField_5.gridx = 4;
        gbc_textField_5.gridy = 0;
        StatementInfoRight.add(textField_5, gbc_textField_5);
        
        StatementRight_O = new JTextField();
        StatementRight_O.setHorizontalAlignment(SwingConstants.CENTER);
        StatementRight_O.setEditable(false);
        StatementRight_O.setColumns(10);
        GridBagConstraints gbc_StatementRight_O = new GridBagConstraints();
        gbc_StatementRight_O.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementRight_O.insets = new Insets(0, 0, 5, 5);
        gbc_StatementRight_O.gridx = 0;
        gbc_StatementRight_O.gridy = 1;
        StatementInfoRight.add(StatementRight_O, gbc_StatementRight_O);
        
        StatementRight_C = new JTextField();
        StatementRight_C.setHorizontalAlignment(SwingConstants.CENTER);
        StatementRight_C.setEditable(false);
        StatementRight_C.setColumns(10);
        GridBagConstraints gbc_StatementRight_C = new GridBagConstraints();
        gbc_StatementRight_C.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementRight_C.insets = new Insets(0, 0, 5, 5);
        gbc_StatementRight_C.gridx = 1;
        gbc_StatementRight_C.gridy = 1;
        StatementInfoRight.add(StatementRight_C, gbc_StatementRight_C);
        
        StatementRight_E = new JTextField();
        StatementRight_E.setHorizontalAlignment(SwingConstants.CENTER);
        StatementRight_E.setEditable(false);
        StatementRight_E.setColumns(10);
        GridBagConstraints gbc_StatementRight_E = new GridBagConstraints();
        gbc_StatementRight_E.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementRight_E.insets = new Insets(0, 0, 5, 5);
        gbc_StatementRight_E.gridx = 2;
        gbc_StatementRight_E.gridy = 1;
        StatementInfoRight.add(StatementRight_E, gbc_StatementRight_E);
        
        StatementRight_A = new JTextField();
        StatementRight_A.setHorizontalAlignment(SwingConstants.CENTER);
        StatementRight_A.setEditable(false);
        StatementRight_A.setColumns(10);
        GridBagConstraints gbc_StatementRight_A = new GridBagConstraints();
        gbc_StatementRight_A.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementRight_A.insets = new Insets(0, 0, 5, 5);
        gbc_StatementRight_A.gridx = 3;
        gbc_StatementRight_A.gridy = 1;
        StatementInfoRight.add(StatementRight_A, gbc_StatementRight_A);
        
        StatementRight_N = new JTextField();
        StatementRight_N.setHorizontalAlignment(SwingConstants.CENTER);
        StatementRight_N.setEditable(false);
        StatementRight_N.setColumns(10);
        GridBagConstraints gbc_StatementRight_N = new GridBagConstraints();
        gbc_StatementRight_N.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementRight_N.insets = new Insets(0, 0, 5, 0);
        gbc_StatementRight_N.gridx = 4;
        gbc_StatementRight_N.gridy = 1;
        StatementInfoRight.add(StatementRight_N, gbc_StatementRight_N);
        
        panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.gridwidth = 5;
        gbc_panel_1.insets = new Insets(0, 0, 5, 0);
        gbc_panel_1.gridx = 0;
        gbc_panel_1.gridy = 2;
        StatementInfoRight.add(panel_1, gbc_panel_1);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
        gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);
        
        StatementRight_Joy = new JTextField();
        StatementRight_Joy.setHorizontalAlignment(SwingConstants.CENTER);
        StatementRight_Joy.setEditable(false);
        StatementRight_Joy.setColumns(10);
        GridBagConstraints gbc_StatementRight_Joy = new GridBagConstraints();
        gbc_StatementRight_Joy.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementRight_Joy.insets = new Insets(0, 0, 5, 5);
        gbc_StatementRight_Joy.gridx = 0;
        gbc_StatementRight_Joy.gridy = 0;
        panel_1.add(StatementRight_Joy, gbc_StatementRight_Joy);
        
        StatementRight_Sad = new JTextField();
        StatementRight_Sad.setHorizontalAlignment(SwingConstants.CENTER);
        StatementRight_Sad.setEditable(false);
        StatementRight_Sad.setColumns(10);
        GridBagConstraints gbc_StatementRight_Sad = new GridBagConstraints();
        gbc_StatementRight_Sad.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementRight_Sad.insets = new Insets(0, 0, 5, 5);
        gbc_StatementRight_Sad.gridx = 1;
        gbc_StatementRight_Sad.gridy = 0;
        panel_1.add(StatementRight_Sad, gbc_StatementRight_Sad);
        
        StatementRight_Anger = new JTextField();
        StatementRight_Anger.setHorizontalAlignment(SwingConstants.CENTER);
        StatementRight_Anger.setEditable(false);
        StatementRight_Anger.setColumns(10);
        GridBagConstraints gbc_StatementRight_Anger = new GridBagConstraints();
        gbc_StatementRight_Anger.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementRight_Anger.insets = new Insets(0, 0, 5, 5);
        gbc_StatementRight_Anger.gridx = 2;
        gbc_StatementRight_Anger.gridy = 0;
        panel_1.add(StatementRight_Anger, gbc_StatementRight_Anger);
        
        StatementRight_Fear = new JTextField();
        StatementRight_Fear.setHorizontalAlignment(SwingConstants.CENTER);
        StatementRight_Fear.setEditable(false);
        StatementRight_Fear.setColumns(10);
        GridBagConstraints gbc_StatementRight_Fear = new GridBagConstraints();
        gbc_StatementRight_Fear.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementRight_Fear.insets = new Insets(0, 0, 5, 5);
        gbc_StatementRight_Fear.gridx = 3;
        gbc_StatementRight_Fear.gridy = 0;
        panel_1.add(StatementRight_Fear, gbc_StatementRight_Fear);
        
        StatementRight_Trust = new JTextField();
        StatementRight_Trust.setHorizontalAlignment(SwingConstants.CENTER);
        StatementRight_Trust.setEditable(false);
        StatementRight_Trust.setColumns(10);
        GridBagConstraints gbc_StatementRight_Trust = new GridBagConstraints();
        gbc_StatementRight_Trust.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementRight_Trust.insets = new Insets(0, 0, 5, 5);
        gbc_StatementRight_Trust.gridx = 4;
        gbc_StatementRight_Trust.gridy = 0;
        panel_1.add(StatementRight_Trust, gbc_StatementRight_Trust);
        
        StatementRight_Surprise = new JTextField();
        StatementRight_Surprise.setHorizontalAlignment(SwingConstants.CENTER);
        StatementRight_Surprise.setEditable(false);
        StatementRight_Surprise.setColumns(10);
        GridBagConstraints gbc_StatementRight_Surprise = new GridBagConstraints();
        gbc_StatementRight_Surprise.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementRight_Surprise.insets = new Insets(0, 0, 5, 5);
        gbc_StatementRight_Surprise.gridx = 5;
        gbc_StatementRight_Surprise.gridy = 0;
        panel_1.add(StatementRight_Surprise, gbc_StatementRight_Surprise);
        
        StatementRight_Antic = new JTextField();
        StatementRight_Antic.setHorizontalAlignment(SwingConstants.CENTER);
        StatementRight_Antic.setEditable(false);
        StatementRight_Antic.setColumns(10);
        GridBagConstraints gbc_StatementRight_Antic = new GridBagConstraints();
        gbc_StatementRight_Antic.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementRight_Antic.insets = new Insets(0, 0, 5, 5);
        gbc_StatementRight_Antic.gridx = 6;
        gbc_StatementRight_Antic.gridy = 0;
        panel_1.add(StatementRight_Antic, gbc_StatementRight_Antic);
        
        StatementRight_Disgust = new JTextField();
        StatementRight_Disgust.setHorizontalAlignment(SwingConstants.CENTER);
        StatementRight_Disgust.setEditable(false);
        StatementRight_Disgust.setColumns(10);
        GridBagConstraints gbc_StatementRight_Disgust = new GridBagConstraints();
        gbc_StatementRight_Disgust.fill = GridBagConstraints.HORIZONTAL;
        gbc_StatementRight_Disgust.insets = new Insets(0, 0, 5, 0);
        gbc_StatementRight_Disgust.gridx = 7;
        gbc_StatementRight_Disgust.gridy = 0;
        panel_1.add(StatementRight_Disgust, gbc_StatementRight_Disgust);
        
        textField_19 = new JTextField();
        textField_19.setText("Joy");
        textField_19.setHorizontalAlignment(SwingConstants.CENTER);
        textField_19.setEditable(false);
        textField_19.setColumns(10);
        GridBagConstraints gbc_textField_19 = new GridBagConstraints();
        gbc_textField_19.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_19.insets = new Insets(0, 0, 5, 5);
        gbc_textField_19.gridx = 0;
        gbc_textField_19.gridy = 1;
        panel_1.add(textField_19, gbc_textField_19);
        
        textField_20 = new JTextField();
        textField_20.setText("Sadness");
        textField_20.setHorizontalAlignment(SwingConstants.CENTER);
        textField_20.setEditable(false);
        textField_20.setColumns(10);
        GridBagConstraints gbc_textField_20 = new GridBagConstraints();
        gbc_textField_20.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_20.insets = new Insets(0, 0, 5, 5);
        gbc_textField_20.gridx = 1;
        gbc_textField_20.gridy = 1;
        panel_1.add(textField_20, gbc_textField_20);
        
        textField_21 = new JTextField();
        textField_21.setText("Anger");
        textField_21.setHorizontalAlignment(SwingConstants.CENTER);
        textField_21.setEditable(false);
        textField_21.setColumns(10);
        GridBagConstraints gbc_textField_21 = new GridBagConstraints();
        gbc_textField_21.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_21.insets = new Insets(0, 0, 5, 5);
        gbc_textField_21.gridx = 2;
        gbc_textField_21.gridy = 1;
        panel_1.add(textField_21, gbc_textField_21);
        
        textField_22 = new JTextField();
        textField_22.setText("Fear");
        textField_22.setHorizontalAlignment(SwingConstants.CENTER);
        textField_22.setEditable(false);
        textField_22.setColumns(10);
        GridBagConstraints gbc_textField_22 = new GridBagConstraints();
        gbc_textField_22.fill = GridBagConstraints.BOTH;
        gbc_textField_22.insets = new Insets(0, 0, 5, 5);
        gbc_textField_22.gridx = 3;
        gbc_textField_22.gridy = 1;
        panel_1.add(textField_22, gbc_textField_22);
        
        txtTrust_3 = new JTextField();
        txtTrust_3.setText("Trust");
        txtTrust_3.setHorizontalAlignment(SwingConstants.CENTER);
        txtTrust_3.setEditable(false);
        txtTrust_3.setColumns(10);
        GridBagConstraints gbc_txtTrust_3 = new GridBagConstraints();
        gbc_txtTrust_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtTrust_3.insets = new Insets(0, 0, 5, 5);
        gbc_txtTrust_3.gridx = 4;
        gbc_txtTrust_3.gridy = 1;
        panel_1.add(txtTrust_3, gbc_txtTrust_3);
        
        textField_24 = new JTextField();
        textField_24.setText("Surprise");
        textField_24.setHorizontalAlignment(SwingConstants.CENTER);
        textField_24.setEditable(false);
        textField_24.setColumns(10);
        GridBagConstraints gbc_textField_24 = new GridBagConstraints();
        gbc_textField_24.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_24.insets = new Insets(0, 0, 5, 5);
        gbc_textField_24.gridx = 5;
        gbc_textField_24.gridy = 1;
        panel_1.add(textField_24, gbc_textField_24);
        
        textField_25 = new JTextField();
        textField_25.setText("Anticipation");
        textField_25.setHorizontalAlignment(SwingConstants.CENTER);
        textField_25.setEditable(false);
        textField_25.setColumns(10);
        GridBagConstraints gbc_textField_25 = new GridBagConstraints();
        gbc_textField_25.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_25.insets = new Insets(0, 0, 5, 5);
        gbc_textField_25.gridx = 6;
        gbc_textField_25.gridy = 1;
        panel_1.add(textField_25, gbc_textField_25);
        
        txtDisgust_3 = new JTextField();
        txtDisgust_3.setText("Disgust");
        txtDisgust_3.setHorizontalAlignment(SwingConstants.CENTER);
        txtDisgust_3.setEditable(false);
        txtDisgust_3.setColumns(10);
        GridBagConstraints gbc_txtDisgust_3 = new GridBagConstraints();
        gbc_txtDisgust_3.insets = new Insets(0, 0, 5, 0);
        gbc_txtDisgust_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtDisgust_3.gridx = 7;
        gbc_txtDisgust_3.gridy = 1;
        panel_1.add(txtDisgust_3, gbc_txtDisgust_3);
        
        sayRight = new JButton("Say");
        GridBagConstraints gbc_sayRight = new GridBagConstraints();
        gbc_sayRight.gridwidth = 8;
        gbc_sayRight.insets = new Insets(0, 0, 0, 5);
        gbc_sayRight.gridx = 0;
        gbc_sayRight.gridy = 2;
        panel_1.add(sayRight, gbc_sayRight);
        sayRight.setEnabled(false);
        sayRight.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) 
            {
				// Make sure the conversation has begun. Button should be disabled.
				if (applicationData.getCurrentConversation() != null)
				{
				    updateRightGUI();
				    
					// Set everything up for next statement input.
					startConvo.setEnabled(true);
			        sayRight.setEnabled(false);
			        StatementSelectLeft.setEnabled(true);
			        StatementSelectRight.setEnabled(false);
			        
			        // The user did not change the selection.
                    if (rightStatement == null)
                    {
                        // So grab the first item.
                        rightStatement = searchStatement(applicationData.getCurrentConversation().getCurrentTopic(), 
                                   StatementSelectRight.getModel().getElementAt(0).toString());
                        
                        // No results were found.
                        if (rightStatement != null)
                        {
                            // Since we're on the right, this is the responder saying something to the initiator.
                            applicationData.getCurrentConversation().say(applicationData.getCurrentConversation().getResponder(), rightStatement, applicationData.getCurrentConversation().getInitiator()); 
                            
                            updateLeftGUI();
                        }
                        else
                        {
                            //TODO throw statement not found error. 
                        }
                    }
                    else
                    {
    					// Since we're on the right, this is the responder saying something to the initiator.
    					applicationData.getCurrentConversation().say(applicationData.getCurrentConversation().getResponder(), rightStatement, applicationData.getCurrentConversation().getInitiator()); 

    					updateLeftGUI();
                    }
				}
				else
				{
					JOptionPane.showMessageDialog(null, 
					"Please link a conversation to the application to continue.", 
					"Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
        });
        
        verticalStrut_1 = Box.createVerticalStrut(20);
        GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
        gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
        gbc_verticalStrut_1.gridx = 0;
        gbc_verticalStrut_1.gridy = 7;
        Right.add(verticalStrut_1, gbc_verticalStrut_1);
        
        verticalStrut = Box.createVerticalStrut(20);
        GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
        gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
        gbc_verticalStrut.gridx = 1;
        gbc_verticalStrut.gridy = 7;
        Right.add(verticalStrut, gbc_verticalStrut);
        
        // TODO Remove
        //String[] topicsString = new String[1];
		// topicsString[0] = conversation.getCurrentTopic().getTitle();
		
        // Same topics as left person
        // TopicOfConversation.setModel(new DefaultComboBoxModel(topicsString));
        
        /** The combo box for the selection of the statement on the right*/
        StatementSelectRight.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
				// Make sure the conversation has begun.
				if (applicationData.getCurrentConversation() != null)
				{
					if (StatementSelectRight.getSelectedItem() != null)
					{
						String statementText2 = StatementSelectRight.getSelectedItem().toString();
						if (searchStatement(applicationData.getCurrentConversation().getCurrentTopic(), statementText2) != null)
						{
							rightStatement = searchStatement(applicationData.getCurrentConversation().getCurrentTopic(), statementText2);
							rightStatementObject = StatementSelectRight.getSelectedItem();
						}
					}
					updateRightGUI();
				}
				else
				{
					JOptionPane.showMessageDialog(null, 
					"Please link a conversation to the application to continue.", 
					"Warning", JOptionPane.WARNING_MESSAGE);
				}
            }
        });
    }
    
    /**
     * Searches the list of people for the person specified.
     *
     * @param name The name of the person to search for
     * @param people the people
     * @return the person with the same name as the input
     */
    public Person searchPerson(String name, LinkedList<Person> people)
    {
        for(int index = 0; index < people.size(); index++)
        {
            if (people.get(index).getName().equals(name))
            {
                return people.get(index);
            }
        }
        return null;
    }
    
    /**
     * Searches the list of topics for the topic specified.
     *
     * @param title the title
     * @param topics the topics
     * @return the topic with the same title as the input
     */
    public Topic searchTopic(String title, LinkedList<Topic> topics)
    {
        for(int index = 0; index < topics.size(); index++)
        {
            if (topics.get(index).getTitle().equals(title))
            {
                return topics.get(index);
            }
        }
        return null;
    }
    
}
