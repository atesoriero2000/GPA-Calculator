import javax.swing.*;

import java.awt.event.*;
import java.util.regex.*;



public class Swing extends JFrame{
	
	private static final long serialVersionUID = 9223372036854775807L;
	
	JTextField percent1, percent2, percent3, percent4, percent5, percent6, percent7, percent8;
	JTextField credits1, credits2, credits3, credits4, credits5, credits6, credits7, credits8;
	JCheckBox weighted1, weighted2, weighted3, weighted4, weighted5, weighted6, weighted7, weighted8;
	JCheckBox use1, use2, use3, use4, use5, use6, use7, use8;
	JButton button1, button2, button3, button4, button5, buttonClear, buttonMPcalc, buttonClearAll;
	JRadioButton Letters, Numbers;
	JTextField cumulativeText;
	
	static double[] unweightedGP = new double[] { 4.33, 4.00, 3.67, 3.33, 3.00,
		2.67, 2.33, 2.00, 1.67, 1.33, 1.00, .67, 0 };

	static double[] weightedGP = new double[] { 5.41, 5.00, 4.59, 4.16, 3.75,
		3.34, 2.91, 2.50, 2.09, 1.66, 1.25, .84, 0 };
	
	String[] letterArray = {"A+","A","A-","B+","B","B-","C+","C","C-","D+","D","D-","F"};
	
	JTextField[] gradeArray = new JTextField[8];
	JTextField[] creditsArray = new JTextField[8];
	JCheckBox[] weightedArray = new JCheckBox[8];
	JCheckBox[] useArray = new JCheckBox[8];
	
	double weightedGPA;
	double unweightedGPA;
	
	String mp1 = "MP1"; //"3.68";
	String mp2 = "MP2"; //"3.91";
	String mp3 = "MP3"; //"4.06";
	String mp4 = "MP4"; 
	
	public static void main(String[] args){
		
		new Swing();

		
	}
	
	public Swing(){
		
		
		this.setSize(352,490);
		this.setTitle("GPA Calculator");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel thePanel = new JPanel();
		
		
		JLabel title = new JLabel("                              "
				+ "Grade      Credits"
				+ "                               ");
		thePanel.add(title);
		
		
		use1 = new JCheckBox();
		use1.setFocusable(false);
		use1.setSelected(false);
		thePanel.add(use1);
		JLabel label1 = new JLabel("Class 1:");
		thePanel.add(label1);
		percent1 = new JTextField("",5);
		thePanel.add(percent1);
		credits1 = new JTextField("",2);
		thePanel.add(credits1);
		weighted1 = new JCheckBox("Weighted    ");
		thePanel.add(weighted1);
		
		use2 = new JCheckBox();
		use2.setFocusable(false);
		use2.setSelected(false);
		thePanel.add(use2);
		JLabel label2 = new JLabel("Class 2:");
		thePanel.add(label2);
		percent2 = new JTextField("",5);
		thePanel.add(percent2);
		credits2 = new JTextField("",2);
		thePanel.add(credits2);
		weighted2 = new JCheckBox("Weighted    ");
		thePanel.add(weighted2);
		
		use3 = new JCheckBox();
		use3.setFocusable(false);
		use3.setSelected(false);
		thePanel.add(use3);
		JLabel label3 = new JLabel("Class 3:");
		thePanel.add(label3);
		percent3 = new JTextField("",5);
		thePanel.add(percent3);
		credits3 = new JTextField("",2);
		thePanel.add(credits3);
		weighted3 = new JCheckBox("Weighted    ");
		thePanel.add(weighted3);
		
		use4 = new JCheckBox();
		use4.setFocusable(false);
		use4.setSelected(false);
		thePanel.add(use4);
		JLabel label4 = new JLabel("Class 4:");
		thePanel.add(label4);
		percent4 = new JTextField("",5);
		thePanel.add(percent4);
		credits4 = new JTextField("",2);
		thePanel.add(credits4);
		weighted4 = new JCheckBox("Weighted    ");
		thePanel.add(weighted4);
		
		use5 = new JCheckBox();
		use5.setFocusable(false);
		use5.setSelected(false);
		thePanel.add(use5);
		JLabel label5 = new JLabel("Class 5:");
		thePanel.add(label5);
		percent5 = new JTextField("",5);
		thePanel.add(percent5);
		credits5 = new JTextField("",2);
		thePanel.add(credits5);
		weighted5 = new JCheckBox("Weighted    ");
		thePanel.add(weighted5);
		
		use6 = new JCheckBox();
		use6.setFocusable(false);
		use6.setSelected(false);
		thePanel.add(use6);
		JLabel label6 = new JLabel("Class 6:");
		thePanel.add(label6);
		percent6 = new JTextField("",5);
		thePanel.add(percent6);
		credits6 = new JTextField("",2);
		thePanel.add(credits6);
		weighted6 = new JCheckBox("Weighted    ");
		thePanel.add(weighted6);
		
		use7 = new JCheckBox();
		use7.setFocusable(false);
		use7.setSelected(false);
		thePanel.add(use7);
		JLabel label7 = new JLabel("Class 7:");
		thePanel.add(label7);
		percent7 = new JTextField("",5);
		thePanel.add(percent7);
		credits7 = new JTextField("",2);
		thePanel.add(credits7);
		weighted7 = new JCheckBox("Weighted    ");
		thePanel.add(weighted7);
		
		use8 = new JCheckBox();
		use8.setFocusable(false);
		use8.setSelected(false);
		thePanel.add(use8);
		JLabel label8 = new JLabel("Class 8:");
		thePanel.add(label8);
		percent8 = new JTextField("",5);
		thePanel.add(percent8);
		credits8 = new JTextField("",2);
		thePanel.add(credits8);
		weighted8 = new JCheckBox("Weighted    ");
		thePanel.add(weighted8);
		
		
		
		JLabel dataTypeLabel = new JLabel("Grade Type:");
		thePanel.add(dataTypeLabel);
		
		Numbers = new JRadioButton("Percent");
		Letters = new JRadioButton("Letter");
		
		Numbers.setSelected(true);
		
		ButtonGroup dataType = new ButtonGroup();
		
		dataType.add(Numbers);
		dataType.add(Letters);
		
		JPanel dataTypePanel = new JPanel();
		
		dataTypePanel.add(Numbers);
		dataTypePanel.add(Letters);
		
		thePanel.add(dataTypePanel);
		
		
		buttonClearAll = new JButton("Clear");
		ButtonListener lButton = new ButtonListener();
		buttonClearAll.addActionListener(lButton);
		thePanel.add(buttonClearAll);
		
		
		JLabel space = new JLabel("              ");
		thePanel.add(space);
		
		button1 = new JButton("          Calculate GPA          ");
		button1.addActionListener(lButton);
		thePanel.add(button1);
		
		JLabel space2 = new JLabel("              ");
		thePanel.add(space2);
		

		button2 = new JButton(mp1);
		button3 = new JButton(mp2);
		button4 = new JButton(mp3);
		button5 = new JButton(mp4);
		
		button2.addActionListener(lButton);
		button3.addActionListener(lButton);
		button4.addActionListener(lButton);
		button5.addActionListener(lButton);
		
		thePanel.add(button2);
		thePanel.add(button3);
		thePanel.add(button4);
		thePanel.add(button5);
		
		cumulativeText = new JTextField("", 3);
		cumulativeText.addActionListener(lButton);
		thePanel.add(cumulativeText);
		
		buttonClear = new JButton(" Clear Saved ");
		buttonClear.addActionListener(lButton);
		thePanel.add(buttonClear);
		
		buttonMPcalc = new JButton("     Calculate Cumulative GPA      ");
		buttonMPcalc.addActionListener(lButton);
		thePanel.add(buttonMPcalc);
		
		
		
		
		this.add(thePanel);
		this.setVisible(true);
		
		//JOptionPane.
		
		
		
	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == button2){
					
				String text;
				
					if(!cumulativeText.getText().equals("")){
						text = Regex("\\d*[.]?\\d*",cumulativeText.getText());
						cumulativeText.setText("");
					}else{
						text = Double.toString(weightedGPA);
					}
					
					if(text == null){
						text = "0.00";
					}
					
					button2.setText(text);
					
				}
				
				if(e.getSource() == button3){
					
				String text;
					
					if(!cumulativeText.getText().equals("")){
						text = Regex("\\d*[.]?\\d*",cumulativeText.getText());
						cumulativeText.setText("");
					}else{
						text = Double.toString(weightedGPA);
					}
					
					if(text ==  null){
						text = "0.00";
					}
					
					button3.setText(text);
				}
				
				if(e.getSource() == button4){
					
				String text ;
				
					
					if(!cumulativeText.getText().equals("")){
						text = Regex("\\d*[.]?\\d*",cumulativeText.getText());
						cumulativeText.setText("");
					}else{
						text = Double.toString(weightedGPA);
					}
					
					if(text == null){
						text = "0.00";
					}
					
					button4.setText(text);
				}
				
				if(e.getSource() == button5){
					
				String text;
					
					if(!cumulativeText.getText().equals("")){
						text = Regex("\\d*[.]?\\d*",cumulativeText.getText());
						cumulativeText.setText("");
					}else{
						text = Double.toString(weightedGPA);
					}
					
					if(text == null){
						text = "0.00";
					}
					
					button5.setText(text);
				}
				
			
				if(e.getSource() == buttonClear){
					
					button2.setText("MP1");
					button3.setText("MP2");
					button4.setText("MP3");
					button5.setText("MP4");
					
					cumulativeText.setText("");
					
				}
			
				if(e.getSource() == buttonMPcalc){
					int numOfMp = 0;
					double totalGPA = 0;
					
					//cumulativeText.setText("");
					
					if(button2.getText()!= "MP1"){
						numOfMp++;
						totalGPA += Double.parseDouble(button2.getText());
					}
					
					if(button3.getText()!= "MP2"){
						numOfMp++;
						totalGPA += Double.parseDouble(button3.getText());
					}
					
					if(button4.getText()!= "MP3"){
						numOfMp++;
						totalGPA += Double.parseDouble(button4.getText());
					}
					
					if(button5.getText()!= "MP4"){
						numOfMp++;
						totalGPA += Double.parseDouble(button5.getText());
					}
					
					totalGPA /= numOfMp;
					totalGPA = Math.round(totalGPA*100);
					totalGPA /= 100;
					
					JOptionPane.showMessageDialog(Swing.this, "Cumulative GPA: " + totalGPA
							, "Cumulative GPA", JOptionPane.INFORMATION_MESSAGE);
				}
				
				if(e.getSource() == buttonClearAll){
					percent1.setText("");
					percent2.setText("");
					percent3.setText("");
					percent4.setText("");
					percent5.setText("");
					percent6.setText("");
					percent7.setText("");
					percent8.setText("");

					credits1.setText("");
					credits2.setText("");
					credits3.setText("");
					credits4.setText("");
					credits5.setText("");
					credits6.setText("");
					credits7.setText("");
					credits8.setText("");
				}
			
			
			if(e.getSource() == button1){
				
				double totalCredits = 0;
				double GPxCreditsSum = 0;
				double unweightedGPsum = 0;
				int totalClasses = 8;
				int numUsedClasses = 0;
				boolean noErrors = true;
				
				gradeArray[0] = percent1;
				gradeArray[1] = percent2;
				gradeArray[2] = percent3;
				gradeArray[3] = percent4;
				gradeArray[4] = percent5;
				gradeArray[5] = percent6;
				gradeArray[6] = percent7;
				gradeArray[7] = percent8;

				creditsArray[0] = credits1;
				creditsArray[1] = credits2;
				creditsArray[2] = credits3;
				creditsArray[3] = credits4;
				creditsArray[4] = credits5;
				creditsArray[5] = credits6;
				creditsArray[6] = credits7;
				creditsArray[7] = credits8;
				
				weightedArray[0] = weighted1;
				weightedArray[1] = weighted2;
				weightedArray[2] = weighted3;
				weightedArray[3] = weighted4;
				weightedArray[4] = weighted5;
				weightedArray[5] = weighted6;
				weightedArray[6] = weighted7;
				weightedArray[7] = weighted8;
				
				useArray[0] = use1;
				useArray[1] = use2;
				useArray[2] = use3;
				useArray[3] = use4;
				useArray[4] = use5;
				useArray[5] = use6;
				useArray[6] = use7;
				useArray[7] = use8;
				
				
				
				for (int currentClass = 0; currentClass < totalClasses; currentClass++) {

					double percent=0;
					String letter;
					double credits = 0;
					boolean weighted;
					double gp = 0;
					int arrayPlace = 0;

					if(useArray[currentClass].isSelected()){
						numUsedClasses++;
						
						if(Numbers.isSelected()){
							
							
							try{
								percent = Double.parseDouble( Regex("\\d*[.]?\\d*",gradeArray[currentClass].getText()) );
								
							} catch (NullPointerException excep){
								noErrors = false;
								JOptionPane.showMessageDialog(Swing.this, "Input Correct Data Type (use only numbers with no % sign)", "Error", JOptionPane.ERROR_MESSAGE);
								break;
								
							}
							percent = (double)Math.round(percent);
							
							
							if (percent >= 97) {//A+
								arrayPlace=0;
		
							} else if (percent >= 93) {//A && percent <= 96
								arrayPlace=1;
		
							} else if (percent >= 90) {//A- && percent <= 92 
								arrayPlace=2;
		
							} else if (percent >= 87) {//B+ && percent <= 89 
								arrayPlace=3;
		
							} else if (percent >= 83) {//B && percent <= 86
								arrayPlace=4;
		
							} else if (percent >= 80) {//B- && percent <= 82
								arrayPlace=5;
		
							} else if (percent >= 77) {//C+ && percent <= 82 
								arrayPlace=6;
		
							} else if (percent >= 73) {//C && percent <= 76
								arrayPlace=7;
		
							} else if (percent >= 70) {//C- && percent <= 72
								arrayPlace=8;
		
							} else if (percent >= 67) {//D+ && percent <= 69
								arrayPlace=9;
		
							} else if (percent >= 63) {//D && percent <= 66
								arrayPlace=10;
		
							} else if (percent >= 60) {//D- && percent <= 62
								arrayPlace=11;
								
							} else if (percent <= 59) {//F
								arrayPlace=12;
							}
							
						
							
						}else{
							
							letter = gradeArray[currentClass].getText();//Regex("[a-dA-D|f|F]([+|-])?",
							
							arrayPlace = 0;
							
							for(String theLetters : letterArray){
								
								if(theLetters.equalsIgnoreCase(letter)){
									break;
								}else{
									arrayPlace++;
								}
							}
							
							if(arrayPlace>12){
								JOptionPane.showMessageDialog(Swing.this, "Input Correct Data Type (letter grade then + or - with no space)", "Error", JOptionPane.ERROR_MESSAGE);
								noErrors = false;
								break;
							}
							
							
						}
			
						
						weighted = weightedArray[currentClass].isSelected();
						
						if(weighted){
							gp = weightedGP[arrayPlace];
							
						}else{
							gp = unweightedGP[arrayPlace];
							
						}
					
						
						try{
							credits = Double.parseDouble(creditsArray[currentClass].getText());
						
						} catch (NumberFormatException excep){
							noErrors = false;
							JOptionPane.showMessageDialog(Swing.this, "Input Correct Data Type (credits column)", "Error", JOptionPane.ERROR_MESSAGE);
							break;
							
						}
						totalCredits += credits;
	
						unweightedGPsum += unweightedGP[arrayPlace] * credits;
					
						GPxCreditsSum += gp * credits;
					}

				}//FOR
				
				
				
				if(numUsedClasses == 0){
					noErrors = false;
					JOptionPane.showMessageDialog(Swing.this, "Select Class Spaces to Use", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if(noErrors){
					weightedGPA = GPxCreditsSum/totalCredits;
					unweightedGPA = unweightedGPsum/totalCredits;
					
					weightedGPA = Math.round(weightedGPA*100);
					weightedGPA /= 100;
					String sWeightedGPA = Double.toString(weightedGPA);
					
					unweightedGPA = Math.round(unweightedGPA*100);
					unweightedGPA /= 100;
					String sUnweightedGPA = Double.toString(unweightedGPA);
					
					JOptionPane.showMessageDialog(Swing.this, 
							"Weighted GPA: " +sWeightedGPA  +
							"\nUnweighted GPA: " + sUnweightedGPA, "GPA",
							JOptionPane.INFORMATION_MESSAGE);
					
					
					if(unweightedGPA <= 2){
						JOptionPane.showMessageDialog(Swing.this, 
								"YOU'RE DUMB", "GPA",
								JOptionPane.INFORMATION_MESSAGE);
						
					}
				}
				
				
				
			}//IF
			
		}//METHOD
		
	}//BUTTONLISTENER
	
	private static String Regex(String expresion, String theGrade){
		
		Pattern compiledExpretion = Pattern.compile(expresion);
		Matcher regexMatcher = compiledExpretion.matcher(theGrade);
		String finalGrade = null;
		
		
		regexMatcher.find();
		
		if(regexMatcher.group().length() != 0){
			finalGrade = regexMatcher.group().trim();
		}
		
		
		
		//System.out.println(finalGrade);
		return finalGrade;
	}
}//FILE
