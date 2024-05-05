import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;   
import javax.swing.border.LineBorder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import edu.stanford.nlp.process.WordSegmenter;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.util.HashSet;
public class GUI_Project
{
		public static void main(String[] args) 
		{
		        SwingUtilities.invokeLater(new Runnable() {
		            @Override
		            public void run() {
		                try {
							createAndShowGUI();
						
		                } catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
		        });
		    }

		    static void createAndShowGUI() throws IOException 
		    {
		    	nlp_rules.nestedclass nestedObj = new nlp_rules.nestedclass();
		    	Font font1=new Font("Arial", Font.BOLD,15);
			    Font fontc=new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 13);
			    
		        FlatLightLaf.setup(); //setting the look and feel
		        JFrame.setDefaultLookAndFeelDecorated(true); 
		       
		    	JFrame frame = new JFrame();
		    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        
		        Font customFont = new Font("Arial", Font.PLAIN, 24);
	            UIManager.put("JFrame.font", customFont);
		        frame.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(54, 60, 107));
	            frame.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.white);
		                  
		        frame.pack();
		        frame.setSize(500, 500);  
		        frame.setLocationRelativeTo(null);
		        frame.setTitle(" "
		        		+ "                                                                                                                           "
		        		+ "                                                                                                          NL2DSL");
		    	
		        frame.setVisible(true);  
		                
		        
		        JPanel panel1=new JPanel();
		        JLabel Label1 = new JLabel("Generate Xtext DSL Grammar");
		        Label1.setFont(font1);
		        Label1.setForeground(new Color(54, 60, 107));
		        panel1.add(Label1);
		        panel1.setBounds(470,80,220,20);
		        frame.add(panel1);
		        
		        JPanel panel2=new JPanel();
		        JButton Generate = new JButton("Generate");
		        Generate.setFont(new Font("Arial", Font.BOLD,14));
		        Generate.setHorizontalAlignment(JButton.CENTER);
		        Generate.setVerticalAlignment(JButton.CENTER);
		        Generate.setBackground(new Color(54, 60, 107));
		        Generate.setForeground(Color.white);
		        panel2.add(Generate);
		        panel2.setBounds(977,360,100,50);
		        frame.add(panel2);
		        
		        JPanel panelkk=new JPanel();
		        JButton save = new JButton("Save");
		        save.setFont(new Font("Arial", Font.BOLD,14));
		        save.setHorizontalAlignment(JButton.CENTER);
	            save.setVerticalAlignment(JButton.CENTER);
		        save.setBackground(new Color(54, 60, 107));
		        save.setForeground(Color.white);
		        panelkk.add(save);
		        panelkk.setBounds(985,720,110,50);
		        frame.add(panelkk);
		        
		        JPanel panelb=new JPanel();
		        JLabel Labelb = new JLabel("Save Xtext DSL Grammar");
		        Labelb.setFont(font1);
		        Labelb.setHorizontalAlignment(JButton.RIGHT);
		        Labelb.setForeground(new Color(54, 60, 107));
		        panelb.add(Labelb);
		        panelb.setBounds(470,430,190,20);
		        frame.add(panelb);

		        JPanel panelcasestudy1 = new JPanel();	   
		        JTextArea textArea_DSL = new JTextArea(15, 58); // Rows and Columns
		        textArea_DSL.setLineWrap(true);
		        textArea_DSL.setWrapStyleWord(true);        
		        textArea_DSL.setFont(fontc);
		        textArea_DSL.setEditable(false); 
		        textArea_DSL.setBackground(Color.WHITE);
		        JScrollPane scrollPanea = new JScrollPane(textArea_DSL);
		        scrollPanea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		        scrollPanea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		        panelcasestudy1.add(scrollPanea);
		        panelcasestudy1.setBounds(470,456,605,450);
		        frame.add(panelcasestudy1);
		       	        
		            
		        JPanel panelcasestudy = new JPanel();	        
		        //case study text
		        JTextArea textArea = new JTextArea(15, 59); // Rows and Columns
		        textArea.setLineWrap(true);
		        textArea.setWrapStyleWord(true);        	        
		        textArea.setFont(fontc);
		        JScrollPane scrollPane = new JScrollPane(textArea);
		        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
		        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		        panelcasestudy.add(Box.createVerticalStrut(300));
		        panelcasestudy.add(scrollPane);
		        frame.add(panelcasestudy);
		        
		               
		        
		        JButton ChooseFile=new JButton("Upload");
		        ChooseFile.setSize(110, 50);
		        ChooseFile.setFont(new Font("Arial", Font.BOLD,14));
		        ChooseFile.setBackground(new Color(54, 60, 107));
		        ChooseFile.setForeground(Color.white);
		        JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files (*.PDF)", "pdf");
		        fileChooser.setFileFilter(filter);
		        // Set the initial directory (change this to your desired directory path)
		        File initialDirectory = new File("C:\\Users\\AminaSoftware\\Documents\\MS-Thesis");
		        fileChooser.setCurrentDirectory(initialDirectory);
		        JTextField location=new JTextField(43);
		        ChooseFile.addActionListener(new ActionListener() 
		        {
		            @Override
		            public void actionPerformed(ActionEvent e) 
		            {
		                int result = fileChooser.showOpenDialog(null);
		                if (result == JFileChooser.APPROVE_OPTION) 
		                {
		                        File selectedFile = fileChooser.getSelectedFile();
								try
								{
									PdfReader pdfReader = new PdfReader(selectedFile.getAbsolutePath());
									StringBuilder text = new StringBuilder();
			                        for (int page = 1; page <= pdfReader.getNumberOfPages(); page++) 
			                        {
			                        	text.append(PdfTextExtractor.getTextFromPage(pdfReader, page));	
			                        }   
			                        textArea.setText(text.toString());
			                        location.setText(selectedFile.getAbsolutePath());
								} 
								catch (IOException e1) 
								{
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
		            }	
		         }
		        });
		        
		        
		        JButton b2=new JButton("Clear");
		        b2.setFont(new Font("Arial", Font.BOLD,14));
		        b2.setHorizontalAlignment(JButton.CENTER);
	            b2.setVerticalAlignment(JButton.CENTER);
		        b2.setSize(110, 50);
		        b2.setBackground(new Color(54, 60, 107));
		        b2.setForeground(Color.white);
		        b2.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                textArea_DSL.setText(""); // Clear the text area
		            }
		        });
		        
		        JPanel panela=new JPanel();
		        panela.add(Box.createVerticalStrut(70));
		        panela.add(Box.createHorizontalStrut(-20));
		        panela.add(Box.createHorizontalStrut(5));
		        panela.add(location);      
		        panela.add(ChooseFile);
		        panela.add(b2);    
		        panela.add(Box.createVerticalStrut(20));
		        frame.add(panela, BorderLayout.NORTH);

    save.addActionListener(new ActionListener() 
    {
    	
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stuB
	        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        FileNameExtensionFilter filter = new FileNameExtensionFilter("Xtext Files (*.xtext)", "xtext");
	        fileChooser.setFileFilter(filter);
	        // Set the initial directory (change this to your desired directory path)
	        File initialDirectory = new File("C:\\Users\\AminaSoftware\\Desktop");
	        fileChooser.setCurrentDirectory(initialDirectory);
	                int result = fileChooser.showOpenDialog(null);
	                if (result == fileChooser.APPROVE_OPTION) 
	                {
	                	String filePath = fileChooser.getSelectedFile().getAbsolutePath();
	                    String content=textArea_DSL.getText();
	                    saveToFile(filePath, content);
	                }
	            }

				private void saveToFile(String filePath, String content) 
				{
					// TODO Auto-generated method stub
					try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
					{
						   writer.write(content);
				            JOptionPane.showMessageDialog(null, "Xtext DSL File saved!");
					}
					catch (IOException e) 
					{
			            e.printStackTrace();
			        }
				}
		
    });
        
        //get the first element... from generate button
        Generate.addActionListener(new ActionListener() 
        {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
					// TODO Auto-generated method stub
					MaxentTagger tagger =  new MaxentTagger("stanford/models/english-left3words-distsim.tagger.");
					String text1= textArea.getText().toString().replaceAll("[\\p{Punct}&&[^.]]", " ");				
					String[] taged = tagger.tagString(text1).split("\\.+"); 
				    
					for(String token:taged)
					{
						System.out.println("Tokens are:"+token);
					}
				    // Create an empty array to store the converted results
				       String[] convertedTexts = new String[taged.length];
				        
				       
				       // Iterate over each tagged text
				       for (int i = 0; i < taged.length; i++) 
				       {
				           String taggedText = taged[i];
				           // Convert NNS and NNP to NN
				           String convertedTexta = taggedText.replaceAll("NNS", "NN");
				           String convertedText=convertedTexta.replaceAll("NNP", "NN");
				           
				           // Store the converted text in the array
				           convertedTexts[i] = convertedText;
				           System.out.println(convertedTexts[i]);  
				      }				       
				
			     int totalSentences=convertedTexts.length;
			      
		         for (int t=0;t<totalSentences;t++)
		         {
		        	 if(!(convertedTexts[t].contains("where_WRB")))
		        	 {
			        	 System.out.println("without where text is :"+convertedTexts[t]);   
			        	//if root element exist
//#####################################################################################################################################################################################
			             for(String executed_pattern:nestedObj.pattern1f)
			  	    	    {	        
			      		      String[] arr1=new String[6];
			            	  Pattern pattern=Pattern.compile(executed_pattern);
						      Matcher matched=pattern.matcher(convertedTexts[t]);
						      if(matched.find())
						      {
						    	  System.out.println("#############################################################################");
							      System.out.println("\n\n"+"Expression:: "+matched.group().replaceAll("_\\S+", ""));
							      System.out.println("Matched Rule: " + executed_pattern);
							      arr1[0]=executed_pattern;
							    //  text_rules.append(arr1[0]);
							      
							       //1st way  for timing model
							      Pattern p = Pattern.compile("\\w+NN\\b.\\w+NN\\b");//. represents single character  
							      Matcher m = p.matcher(matched.group());  
							      System.out.println("Matched statement: " + m);
							      
							      Pattern p1 = Pattern.compile("\\w+JJ\\b.\\w+NN\\b");//. represents single character  
							      Matcher m1 = p1.matcher(matched.group());  
							      System.out.println("Matched statement: " + m1);
							      
							      if(m.find())
							   	  {
								      String patternb="(?<=\\w+VB\\b).*|(?<=\\w+VBZ\\b.*\\w+IN\\b).*";
								      Pattern patternf=Pattern.compile(patternb);
								      Matcher matchedb=patternf.matcher(convertedTexts[t]);
								      if(matchedb.find())
								      {
								    	  String s="\\w+NN\\b.\\w+NN\\b";
								    	  Pattern pa=Pattern.compile(s);
								    	  Matcher match=pa.matcher(matchedb.group());
								    	  if(match.find())
								    	  {
								    	  String expression=match.group().replaceAll("_\\S+", "").trim();
								    	  System.out.println("System Has:"+expression);
								    	  
								    	  arr1[1]=expression;
								    	  System.out.println("#############################################################################");
								      }}
								      arr1[1] = arr1[1].replace(" ", "_");
								      nestedObj.main1=arr1[1].concat(":'")+arr1[1].concat("'").trim();
								      System.out.println("added in xtext aGGs:"+nestedObj.main1);
								      arr1[2]=nestedObj.main1;
								      if(!(textArea_DSL.getText().contains(arr1[2])))
								      {
								      textArea_DSL.append("\n"+arr1[2]);
								   }
							   	  }
							     
//####################################################################################################################################################################################
							    //2ND way  for diabetic manager if(m0.find())
							      else if(m1.find())
							      {
				    				  //system
								      String patternv="(\\w+NN\\b).(?=\\w+VBZ\\b)|(\\w+NN\\b).(?=\\w+MD\\b)";  
								      Pattern patterns=Pattern.compile(patternv);
								      Matcher matcheds=patterns.matcher(convertedTexts[t]);
								      if(matcheds.find())
								      {
								    	  String expression=matcheds.group().replaceAll("_\\S+", "").trim();
								    	  System.out.println("System Has:"+expression);
								    	  arr1[1]=expression;
								    	  System.out.println("#############################################################################");
								      }
				    				  //diabetic manager
								      String patternba="(\\w+JJ\\b.\\w+NN\\b)";  
								      Pattern patternfa=Pattern.compile(patternba);
								      Matcher matchedba=patternfa.matcher(convertedTexts[t]);
								      if(matchedba.find())
								      {
								    	  String expression=matchedba.group().replaceAll("_\\S+", "").trim();
								    	  System.out.println("System Has:"+expression);
								    	  arr1[2]=expression;
								    	  System.out.println("#############################################################################");
								      }
								      nestedObj.main=arr1[1].concat(":'").trim();
								      nestedObj.maina=arr1[2].concat("'").trim();
								      
								      nestedObj.mainroot=nestedObj.main+nestedObj.maina.trim();
								      System.out.println("added in xtext aGGs:"+nestedObj.mainroot);
								      arr1[3]=nestedObj.mainroot;
								      if(!(textArea_DSL.getText().contains(arr1[3])))
								      {
								      textArea_DSL.append("\n"+arr1[3]);
								      }
							      }
							      }
			  	    	      }
			             //pattern to check relationships
//#####################################################################################################################################################################
		                   //pattern to check relationship element
					       for(String exec:nestedObj.pattern_VBZ)
					       {
					       Pattern r = Pattern.compile(exec);
					       Matcher m=	r.matcher(convertedTexts[t]);
					       if(m.find())
					       {
					    	   System.out.println("Statement of relationships:"+m.group()); 					    	   
					    	  
						    	   System.out.println("Statement of 'it_PRP' relationships:"+convertedTexts[t]);   
						    	   if((convertedTexts[t].contains("contains_VBZ"))
						    		   |(convertedTexts[t].contains("contain_VB"))
						    		   |(convertedTexts[t].contains("composed_VBN")))
						    	     {
						    		   String[] arrx=new String[7];
						    		   arrx[0]=exec;//store the pattern of executed rules
						    		   
						    		   System.out.println("Statement of 'containment' relationships:"+convertedTexts[t]);   
						    		 
						    		   //extract ROOT ELEMENT
						    		   String[] conceptName=convertedTexts[t].split(" ");
						    		   if(!(convertedTexts[t].contains("it_PRP")))
							    	   {
						    		   System.out.println("CONCEPT Name 2of 'without where containment:"+conceptName[3]); 
						    		   if(conceptName[3].contains("_NN"))
						    		   {
						    		   String RootElement=conceptName[3].replaceAll("_\\S+", "");
						    		   String CONCEPT="\n\n"+RootElement.concat(":'")+RootElement.concat("'");
						    		   textArea_DSL.append(CONCEPT);
							    	   }
							    	   }
						    		   
						    		   else
						    		   {
							    		   System.out.println("CONCEPT Name 2of 'without where containment:"+conceptName[2]);    
						    			   if(conceptName[2].contains("it_PRP"))
							    		   {
							    		   String RootElement=conceptName[2].replaceAll("_\\S+", "");
							    		   String CONCEPT="\n\n"+RootElement.concat(":'")+RootElement.concat("'");
							    		   }
						    		   }
						    		   String patterna="(?<=\\w+JJ\\b).*";
						    		   Pattern ra = Pattern.compile(patterna);
								       Matcher ma=	ra.matcher(convertedTexts[t]);
								       if(ma.find())
								       {
								    	   System.out.println("association name:"+ma.group()); 
								    	   String patternaa="\\w+NN\\b.";
							    		   Pattern raa = Pattern.compile(patternaa);
									       Matcher maa=	raa.matcher(ma.group());
									       if(maa.find())
									       {
									    	   System.out.println("association name1:"+maa.group().replaceAll("_\\S+", ""));     
									    	   String associationName=maa.group().replaceAll("_\\S+", "");
									    	   arrx[1]=associationName.trim();
									       }
								       }
								       
								       //extract multiplicity
								       String patternb="\\w+JJ\\b";								       
								       Pattern ra1 = Pattern.compile(patternb);
								       Matcher ma2=	ra1.matcher(convertedTexts[t]);
								       if(ma2.find())
								       {
								    	   System.out.println("multiplicity name:"+ma2.group()); 
								    	   String multiplicity=ma2.group().replaceAll("_\\S+", "");
								    	 
								    	   if(ma2.group().contains("multiple_JJ"))
			      	     		        	  {
			       	     		        		arrx[2]="+=";
			       	     		        		arrx[3]="*";
			       	     		        		
			       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx[1]+arrx[2]+arrx[1].trim().concat(")")+arrx[3];
			       	     		        		System.out.println("Statement hasf Xtext added:"+nestedObj.descriptionContaining1);
			       	     		        		System.out.println("#####################################################################");
			       		     		        	System.out.println("\n");
			       		     		        	  	 
			      	     		        	  }
			       	     		        	
								    	   else if(ma2.group().contains("single_JJ"))
			       	     		        	{
			       	     		        		arrx[2]="=";
			       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx[1]+arrx[2]+arrx[1].trim().concat(")");
			       	     		        		System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
			       	     		        		System.out.println("#####################################################################");
			       		     		        	System.out.println("\n");
			       	     		        	}
			       	     		        	
								    	   else if(ma2.group().contains("optional_JJ"))
			      	     		        	{
			       	     		        		
			       	     		        		arrx[2]="=";
			       	     		        		arrx[3]="?";
			       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx[1]+arrx[2]+arrx[1].trim().concat(")")+arrx[3];
			       	     		        		System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
			       	     		        		System.out.println("#####################################################################");
			       		     		        	System.out.println("\n"); 
			       	     		        	}
								   
								    	   else 
								    	   {
								    		   arrx[2]="=";
								    		   nestedObj.descriptionContaining1="\n".concat("(")+arrx[1]+arrx[2]+arrx[1].trim().concat(")");
			       	     		        	   System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
			       	     		        	   System.out.println("#####################################################################");
			       		     		           System.out.println("\n"); 
								    	   }
								    	   
								    	   
						    	   }
								       arrx[5]=nestedObj.descriptionContaining1;
								       textArea_DSL.append(arrx[5]);
								       //
						    	   }
//########################################################################################################################################################################						    	  
						    	   if((convertedTexts[t].contains("linked_VBN")))
							    	   {
						    		   System.out.println("Statement of 'referennce' relationships:"+convertedTexts[t]);   
						    		   String arrx1[]=new String[7];
						    		 
						    		   arrx1[0]=exec;
						    		   if(!(convertedTexts[t].contains("it_PRP")))
							    	   {
						    			   String[] conceptName=convertedTexts[t].split(" ");
							    		   System.out.println("CONCEPT Name 2of 'without where containment:"+conceptName[3]); 
							    		   if(conceptName[3].contains("_NN"))
							    		   {
							    		   String RootElement=conceptName[3].replaceAll("_\\S+", "");
							    		   String CONCEPT="\n\n"+RootElement.concat(":'")+RootElement.concat("'");
							    		   textArea_DSL.append(CONCEPT);   
							    	   }
							    	   }
						    		   //extract assocaition
						    		   String patterna="(?<=\\w+JJ\\b).*";
						    		   Pattern ra = Pattern.compile(patterna);
								       Matcher ma=	ra.matcher(convertedTexts[t]);
								       if(ma.find())
								       {
								    	   System.out.println("association name:"+ma.group()); 
								    	   String patternaa="\\w+NN\\b.";
							    		   Pattern raa = Pattern.compile(patternaa);
									       Matcher maa=	raa.matcher(ma.group());
									       if(maa.find())
									       {
									    	   System.out.println("association name1:"+maa.group().replaceAll("_\\S+", ""));     
									    	   String associationName=maa.group().replaceAll("_\\S+", "");
									    	   arrx1[1]=associationName.trim();
									       }
								       }
								       //extract multiplicity
								       String patternb="\\w+JJ\\b";								       
								       Pattern ra1 = Pattern.compile(patternb);
								       Matcher ma2=	ra1.matcher(convertedTexts[t]);
								       if(ma2.find())
								       {
								    	   System.out.println("multiplicity name:"+ma2.group()); 
								    	   String multiplicity=ma2.group().replaceAll("_\\S+", "");
								    	   
								    	   if(ma2.group().contains("multiple_JJ"))
			      	     		        	  {
			       	     		        		arrx1[2]="+=";
			       	     		        		arrx1[3]="*";
			       	     		        		
			       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx1[1]+arrx1[2].concat("[")+arrx1[1].trim().concat("])")+arrx1[3];
			       	     		        		System.out.println("Statement hasf Xtext added:"+nestedObj.descriptionContaining1);
			       	     		        		System.out.println("#####################################################################");
			       		     		        	System.out.println("\n");
			       		     		        	  	 
			      	     		        	  }
			       	     		        	
								    	   else if(ma2.group().contains("single_JJ"))
			       	     		        	{
			       	     		        		arrx1[2]="=";
			       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx1[1]+arrx1[2].concat("[")+arrx1[1].trim().concat("])");
			       	     		        		System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
			       	     		        		System.out.println("#####################################################################");
			       		     		        	System.out.println("\n");
			       	     		        	}
			       	     		        	
			       	     		        else if(ma2.group().contains("optional_JJ"))
			      	     		        	{
			       	     		        		
			       	     		        		arrx1[2]="=";
			       	     		        		arrx1[3]="?";
			       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx1[1]+arrx1[2].concat("[")+arrx1[1].trim().concat("])")+arrx1[3];
			       	     		        		System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
			       	     		        		System.out.println("#####################################################################");
			       		     		        	System.out.println("\n"); 
			       	     		        	}
			       	     		    else 
							    	   {
							    		   arrx1[2]="=";
							    		   nestedObj.descriptionContaining1="\n".concat("(")+arrx1[1]+arrx1[2]+arrx1[1].trim().concat(")");
		       	     		        	   System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
		       	     		        	   System.out.println("#####################################################################");
		       		     		           System.out.println("\n"); 
							    	   }
								       }
								       arrx1[5]=nestedObj.descriptionContaining1;
								       textArea_DSL.append(arrx1[5]);
							    	   }
					       }}
//###############################################################################################################################################################################
					       //pattern to check attributes
					       //pattern to check Multiple Attributes element
					       for(String patterns:nestedObj.patterna)
					       {
					    	   Pattern r = Pattern.compile(patterns);
						       Matcher m=	r.matcher(convertedTexts[t]);
						       if(m.find())
						       {
						    	   String array1[]=new String[5];
						    	   System.out.println("Sentences of multiple-attributes:"+convertedTexts[t]);
						    	   array1[0]=patterns;	
						    	   
						    	   String[] concepta = convertedTexts[t].split("\\s+");
						    	   if(!(concepta[1].contains("it_PRP")) | (concepta[2].contains("it_PRP")))
						    	   {  
						    	   String pattern_concept="(\\w+NN\\b.\\w+NN\\b.(?=\\w+VBZ\\b))|(\\w+NN\\b.(?=\\w+VBZ\\b))"
						    			   +"|(\\w+NN\\b.\\w+NN\\b.(?=\\w+MD\\b))|(\\w+NN\\b.(?=\\w+MD\\b))"
						    			   +"|((?<=\\w+IN\\b).*?(?=\\w+VBP\\b))"
						    			   ;
						    	   Pattern ra = Pattern.compile(pattern_concept);
							       Matcher ma=	ra.matcher(convertedTexts[t]);
							       if(ma.find())
							       {
							    	   if(ma.group().contains("concept_NN"))
							    	   {
							    	   String conceptName="\\w+NN\\b";
							    	   Pattern concept=Pattern.compile(conceptName);
							    	   Matcher MatchConcept=concept.matcher(ma.group());
							    	   if(MatchConcept.find())
							    	   {
							    	   String Conceptname=MatchConcept.group().replaceAll("_\\S+", "");	
							    	   System.out.println("Statement of multi-attributes:"+Conceptname);
							    	   array1[1]=Conceptname.trim().concat(":'")+Conceptname.trim().concat("'").trim();	
							    	   }  
							    	   }
							    	   
							    	   if(!(ma.group().contains("concept_NN")))
							    	   {
							    		   
							    	   String Conceptname=ma.group().replaceAll("_\\S+", "").trim();	
							    	   System.out.println("concept of words have:"+Conceptname); 
							    	   String[] words = Conceptname.split("\\s+");
							    	   System.out.println("length of words have:"+words.length); 
								    	  
							    	   if(words.length==2)
							    	   {
							    	   for (String arr:words)
							    	   {
							    	   System.out.println("Statement of multi-attributes have:"+words[0]+words[1]); 
							    	   array1[1]=words[0]+"_"+words[1].trim().concat(":'")
							    			   +words[0].trim()+"_"+
							    			   words[1].trim().concat("'").trim();	
							    	   System.out.println("words"+array1[1]);
							    	   }
							    	   }
							    	   if(words.length==1)
							    	   {
							    		   System.out.println("Statement of multi-attributes:"+words[0]);
								    	   array1[1]=words[0].trim().concat(":'").trim()+words[0].trim().concat("'").trim();	 
								    	   System.out.println("wordss"+array1[1]);
							    	   }
							          }
							       
							       System.out.println("multiple attributes concept name:"+array1[1]);
					    		   if(!(textArea_DSL.getText().contains(array1[1])))
						    	     {
					    			   textArea_DSL.append(";"+"\n\n"+array1[1]);
						    	     }
					    		    
					    		    
						    	   }
						    	  }
						    	   
						    	   String pattern_attribute1=
						    			   "(?<=\\w+VBZ\\b.*\\w+IN\\b).*?(?=\\w+CC\\b)"//represented by //has attributes like name and category
						    			   +"|(?<=\\w+MD\\b.*\\w+IN\\b).*?(?=\\w+CC\\b)"//must define by name and category
						    			   +"|(?<=\\w+VB\\b).*?(?=\\w+VBN\\b|\\w+CC\\b)"//must have a name and category//must have a name preceded by 
						    			   +"|(?<=\\w+VBG\\b).*?(?=\\w+IN\\b)"//has attributes including name and category
						    			   +"|(?<=\\w+VBP\\b).*?(?=\\w+CC\\b)"//attributes of-- are name and category
						    			   +"|(?<=\\w+VBZ\\b).*?(?=\\w+WDT\\b)"//contains a name that should precede a category of
						    			   ;
						    	   Pattern r1 = Pattern.compile(pattern_attribute1);
							       Matcher m1=	r1.matcher(convertedTexts[t]);
							       if(m1.find())
							       {
							    	   String conceptName="\\w+NN\\b";
							    	   Pattern concept=Pattern.compile(conceptName);
							    	   Matcher MatchConcept1=concept.matcher(m1.group());
							    	   if(MatchConcept1.find())
							    	   {
							    	   String attribute1=MatchConcept1.group().replaceAll("_\\S+", "");	
							    	   System.out.println("Attribute1:"+attribute1);
							    	   array1[2]=attribute1;
							       }
							       }
							       
							       // 2nd element ka baad 
							       //when datatype is defined
							       if((convertedTexts[t].contains("string_NN"))|(convertedTexts[t].contains("int_NN"))
							       |(convertedTexts[t].contains("boolean_JJ"))|(convertedTexts[t].contains("id_NN")))
							       {
							       String pattern_attribute2=
						    			   "(?<=\\w+CC\\b).*?(?=\\w+IN\\b)"
						    			   +"|(?<=\\w+MD\\b.*\\w+VBN\\b.*\\w+IN\\b).*?(?=\\w+IN\\b)"// preceded by catrgory of
						    			   +"|(?<=\\w+WDT\\b.*\\w+VB\\b).*?(?=\\w+IN\\b)"////contains a name that should precede a category of
						    			   ;
						    	   Pattern r2 = Pattern.compile(pattern_attribute2);
							       Matcher m2=	r2.matcher(convertedTexts[t]);
							       if(m2.find())
							       {
							    	   String conceptName="\\w+NN\\b";
							    	   Pattern concept=Pattern.compile(conceptName);
							    	   Matcher MatchConcept2=concept.matcher(m2.group());
							    	   if(MatchConcept2.find())
							    	   {
							    		   
							    	   String attribute2=MatchConcept2.group().replaceAll("_\\S+", "");	
							    	   System.out.println("Attribute2c:"+attribute2);
							    	   array1[3]=attribute2;
							           }
							        }
							       
							       String type=
						    			   "(?<=\\w+CC\\b.*\\w+IN\\b).*"
						    			   +"|(?<=\\w+VBN\\b.*\\w+IN\\b.*\\w+IN\\b).*"
						    			   +"|(?<=\\w+WDT\\b.*\\w+IN\\b).*"//contains a name that should precede a category of
						    			;
						    	   Pattern r3 = Pattern.compile(type);
							       Matcher m3=	r3.matcher(convertedTexts[t]);
							       if(m3.find())
							       {
							    	   String attribute2=m3.group().replaceAll("_\\S+", "");	
							    	   System.out.println("type:"+attribute2);
							    	   if((m3.group().contains("ID_NN"))|(m3.group().contains("id_NN")))
					    				  {
					    				  type=m3.group().replaceAll("_\\S+", "").substring(0,3).toUpperCase();
					    				  //added 
					    				  array1[4]=type;
					    				  }
					    				
					    				else if(m3.group().contains("int_NN"))
					    				  {
					    				  type=m3.group().replaceAll("_\\S+", "").substring(0,4).toUpperCase();
					    				  array1[4]=type;
					    				  }
					    				else if(m3.group().contains("string_NN"))
					    				  {
					    					type=m3.group().replaceAll("_\\S+", "").substring(0,7).toUpperCase();
					    					array1[4]=type;
					    				  }
							       }
					   	            //string type
							       
							       if(!(m3.group().contains("boolean_JJ")))
							       {
						            String elementk=
						            		"\n"+array1[2].concat("=").trim()+array1[4].trim()
						            	   +"\n"+array1[3].concat("=").trim()+array1[4].trim();
						            textArea_DSL.append(elementk);
						            //to remove the repition
						            //if((textArea_DSL.getText().contains(array1[1])) && (!(textArea_DSL.getText().contains(elementk))))
						            //{
						            //textArea_DSL.append(elementk);
							        //}
							       }
							       else if(m3.group().contains("boolean_JJ"))
							       {
							    	   String elementk=
							            		"\n".concat("(")+array1[2].concat("?='")+array1[2].concat("')?")
							            	   +"\n".concat("(")+array1[3].concat("?='")+array1[3].concat("')?");
							    	   textArea_DSL.append(elementk);
							       }
								  }
							       //when only datatype is define. 
							       
							       
							       //when datatype is not defined
							      
							       else 
							       {
							    	   String pattern_attribute2=
							    			   "(?<=\\w+CC\\b).*"//represented by //has attributes like name and category
							    			   +"|(?<=\\w+VBN\\b.*\\w+IN\\b).*"// preceded by catrgory of
							    			   +"|(?<=\\w+WDT\\b.*\\w+VB\\b).*"////contains a name that should precede a category of
							    			   ;
							    	   Pattern r2 = Pattern.compile(pattern_attribute2);
								       Matcher m2=	r2.matcher(convertedTexts[t]);
								       if(m2.find())
								       {
								    	   String conceptName="\\w+NN\\b";
								    	   Pattern concept=Pattern.compile(conceptName);
								    	   Matcher MatchConcept2=concept.matcher(m2.group());
								    	   if(MatchConcept2.find())
								    	   {
								    		   
								    	   String attribute2=MatchConcept2.group().replaceAll("_\\S+", "");	
								    	   System.out.println("Attributeaaaa:"+attribute2);
								    	   array1[3]=attribute2;
								    	   textArea_DSL.append("\n"+array1[2].concat("=null")+"\n"+array1[3].concat("=null"));
								    	   }
								       }     
							       }
							   }//multi-attibutes
					       }
//#########################################################################################################################################################					       
					       //pattern to check single & optional attributes
					     //#######################################################################################################################################################
					       //Pattern to check single and optional attributes
					       for(String patternx:nestedObj.patternx)
					       {
					    	   Pattern r = Pattern.compile(patternx);
						       Matcher m=	r.matcher(convertedTexts[t]);
						       if(m.find())
						       {
						    	   String array1[]=new String[5];
						    	   System.out.println("Statement of single/optional attributes:"+convertedTexts[t]);	
						    	   array1[0]=patternx;	
						    	  
						    	   System.out.println("rule of single/optional attributes:"+array1[0]);
						    	   if(convertedTexts[t].contains("optional_JJ"))
						    	   {
						    		   						    	   
						    		String[] concepta = convertedTexts[t].split("\\s+");   
							    	if(!(concepta[1].contains("it_PRP")) | (concepta[2].contains("it_PRP")))
							    	{  
						    	   String pattern_concept="(\\w+NN\\b.\\w+NN\\b.(?=\\w+VBZ\\b))|(\\w+NN\\b.(?=\\w+VBZ\\b))"
						    			   +"|(\\w+NN\\b.\\w+NN\\b.(?=\\w+MD\\b))|(\\w+NN\\b.(?=\\w+MD\\b))"
						    			   +"|(?<=\\w+CD\\b.*\\w+IN\\b).*?(?=\\w+VBZ\\b)"
						    			   ;
						    	   Pattern ra = Pattern.compile(pattern_concept);
							       Matcher ma=	ra.matcher(convertedTexts[t]);
							       if(ma.find())
							       {
							    	
							    	   if(ma.group().contains("concept_NN"))
							    	   {						    		
							    		   String conceptName="\\w+NN\\b";
								    	   Pattern concept=Pattern.compile(conceptName);
								    	   Matcher MatchConcept=concept.matcher(ma.group());
								    	   if(MatchConcept.find())
								    	   {
								    	   String Conceptname=MatchConcept.group().replaceAll("_\\S+", "");	
								    	   System.out.println("Statement of optional-attributes:"+Conceptname);
								    	   array1[1]=Conceptname.trim().concat(":'")+Conceptname.trim().concat("'").trim();	
								    	   }  
							    	   }
							    	   
							    	   if(!(ma.group().contains("concept_NN")))
							    	   {	
							    	   String Conceptname=ma.group().replaceAll("_\\S+", "").trim();
							    	   System.out.println("Statement of optional concept has:"+Conceptname);
							    	   
							    	   if(ma.group().contains("the_DT"))
							    	   {
							    	   String c=ma.group().replaceAll("_\\S+", "").substring(4).trim();
							    	   System.out.println("Statement of optional concept have:"+c);
							    	   String[] words = c.split("\\s+");
							    	   System.out.println("length of words have:"+words.length); 
							    	   
							    	   if(words.length==2)
							    	   {
							    	   System.out.println("Statement of optional-attributes have DT:"+words[1]); 
							    	   array1[1]=words[0]+"_"+words[1].trim().concat(":'")+words[0]+"_"+words[1].trim().concat("'").trim();	
							    	   }
							    	 
							    	   if(words.length==1)
							    	   {
							    		   System.out.println("Statement of optional-attributes ARE:"+words[0]);
								    	   array1[1]=words[0].trim().concat(":'")+words[0].trim().concat("'").trim();	   
							    	   }
							          }
							    	   
							    	   if(!(ma.group().contains("the_DT")))
								    	 {
								    		 System.out.println("nO DT");
								    		 String[] words = Conceptname.split("\\s+");
								    		 System.out.println("length of words have:"+words.length); 
								    		 if(words.length==2)
									    	   {
									    	   System.out.println("Statement of single-attributes have DT:"+words[0]+" "+words[1]); 
									    	   array1[1]=words[0]+"_"+words[1].trim().concat(":'")+words[0]+"_"+words[1].trim().concat("'").trim();	
									    	   }
									    	   if(words.length==1)
									    	   {
									    		   System.out.println("Statement of single-attributes ARE:"+words[0]);
										    	   array1[1]=words[0].trim().concat(":'")+words[0].trim().concat("'").trim();	   
									    	   }
								    	 }
							    	   
							    	  }
							       System.out.println("optional attributes concept name:"+array1[1]);
					    		   if(!(textArea_DSL.getText().contains(array1[1])))
						    	     {
					    			   textArea_DSL.append(";"+"\n\n"+array1[1]);
						    	     }
						    	   }
							    	   
							     }

						    	   //when datatypes are defined...
									if((convertedTexts[t].contains("int_NN"))|(convertedTexts[t].contains("id_NN"))
						    	   |(convertedTexts[t].contains("string_NN"))|(convertedTexts[t].contains("boolean_JJ")))
									{
						    	   //optional tags. 
						    	   String pattern_attribute="(?<=\\w+CD\\b.*\\w+VBZ).*?(?=\\w+IN\\b)"
							    			  +"|(?<=\\w+MD\\b.*\\w+VBN\\b).*?(?=\\w+IN\\b)"
							    			  +"|(?<=\\w+MD\\b.*\\w+IN\\b).*?(?=\\w+IN\\b)"
							    			  ;
							    	   Pattern r1 = Pattern.compile(pattern_attribute);
								       Matcher m1=	r1.matcher(convertedTexts[t]);
								       if(m1.find())
								       {
								    	   String conceptName="\\w+NN\\b";
								    	   Pattern concept=Pattern.compile(conceptName);
								    	   Matcher MatchConcept1=concept.matcher(m1.group());
								    	   if(MatchConcept1.find())
								    	   {
								    	   String attribute1=MatchConcept1.group().replaceAll("_\\S+", "");	
								    	   System.out.println("Statement of optional-attributes:"+attribute1);
								    	   array1[2]=attribute1;
								       }
								       }
								       String pattern_optionalTag="\\w+JJ\\b";
							    	   Pattern r2 = Pattern.compile(pattern_optionalTag);
								       Matcher m2=	r2.matcher(convertedTexts[t]);
								       if(m2.find())
								       {
								    	   String optionalTag="?";
								    	   array1[3]=optionalTag;
								       }
								
						   					
								       //datatypes
								       String type
								    		  ="(?<=\\w+MD\\b.*\\w+VBN\\b.*\\w+IN\\b).*"
										 	  +"|(?<=\\w+MD\\b.*\\w+IN\\b.*\\w+IN\\b).*"
								    		  +"|(?<=\\w+CD\\b.*\\w+VBZ\\b.*\\w+IN\\b).*";
								       ;
						    	   Pattern r3 = Pattern.compile(type);
							       Matcher m3=	r3.matcher(convertedTexts[t]);
							       if(m3.find())
							       {
							    	   String typed=m3.group().replaceAll("_\\S+", "");	
							    	   System.out.println("type:"+typed);
							    	   if((m3.group().contains("ID_NN"))|(m3.group().contains("id_NN")))
					    				  {
					    				  type=m3.group().replaceAll("_\\S+", "").substring(0,3).toUpperCase();
					    				  //added 
					    				  array1[4]=type;
					    				  }
					    				
					    				else if(m3.group().contains("int_NN"))
					    				  {
					    				  type=m3.group().replaceAll("_\\S+", "").substring(0,4).toUpperCase();
					    				  array1[4]=type;
					    				  }
					    				else if(m3.group().contains("string_NN"))
					    				  {
					    					type=m3.group().replaceAll("_\\S+", "").substring(0,7).toUpperCase();
					    					array1[4]=type;
					    				  }
					   	           } //string type
							       if(!(m3.group().contains("boolean_JJ")))
							       {
						            String elementk="\n".concat("(")+array1[2].concat("=").trim()+array1[4].concat(")").trim()+array1[3].trim();
						            textArea_DSL.append(elementk);
							       }
							       else if(m3.group().contains("boolean_JJ"))
							    	 
							       {
						            String elementk="\n".concat("(")+array1[2].concat("?='")+array1[2].concat("')")+array1[3];
						            textArea_DSL.append(elementk);
							       }
								 }//when only data type is defined.
									
								
							 //when datatypes are not defined...
								 else 
								 {
							    	   //optional tags. 
							    	   String pattern_attribute="(?<=\\w+CD\\b.*\\w+VBZ).*"
								    			  +"|(?<=\\w+MD\\b.*\\w+VBN\\b).*"
								    			  +"|(?<=\\w+MD\\b.*\\w+IN\\b).*"
								    			  ;
								    	   Pattern r1 = Pattern.compile(pattern_attribute);
									       Matcher m1=	r1.matcher(convertedTexts[t]);
									       if(m1.find())
									       {
									    	   String conceptName="\\w+NN\\b";
									    	   Pattern concept=Pattern.compile(conceptName);
									    	   Matcher MatchConcept1=concept.matcher(m1.group());
									    	   if(MatchConcept1.find())
									    	   {
									    	   String attribute1=MatchConcept1.group().replaceAll("_\\S+", "");	
									    	   System.out.println("Statement of optionals:"+attribute1);
									    	   array1[2]=attribute1;
									       }
									       }
									       String pattern_optionalTag=
									    		   "(?<=\\w+MD\\b.*\\w+DT\\b).*?(?=\\w+NN\\b.\\w+VBN\\b)"
										    		+"|(?<=\\w+MD\\b.*\\w+DT\\b).*?(?=\\w+NN\\b.\\w+IN\\b)"
										    		+"|(?<=\\w+CD\\b).*?(?=\\w+NN\\b.*\\w+VBZ\\b)";
									       
								    	   Pattern r2 = Pattern.compile(pattern_optionalTag);
									       Matcher m2=	r2.matcher(convertedTexts[t]);
									       if(m2.find())
									       {
									    	   String optionalTag="?";
									    	   array1[3]=optionalTag;
									    	   String concept=array1[2].concat("=null").concat(")")+array1[3].trim();
									    	   textArea_DSL.append("\n".concat("(")+concept);
									       }
									 }//when only data type is defined.
									
							   }//optional 
//###############################################################################################################################################								    	   
						    	   if(!(convertedTexts[t].contains("optional_JJ")))
						    	   {
						    		   String[] concepta = convertedTexts[t].split("\\s+");
							    	   if(!(concepta[1].contains("it_PRP")) | (concepta[2].contains("it_PRP")))
							    	   {  
						    		   //if(!(convertedTexts[t].contains("it_PRP"))){
							    		   
							    	   String pattern_concept="(\\w+NN\\b.\\w+NN\\b.(?=\\w+VBZ\\b))|(\\w+NN\\b.(?=\\w+VBZ\\b))"
							    			   +"|(\\w+NN\\b.\\w+NN\\b.(?=\\w+MD\\b))|(\\w+NN\\b.(?=\\w+MD\\b))"
							    			   +"|(?<=\\w+CD\\b.*\\w+IN\\b).*?(?=\\w+VBZ\\b)"
							    			   ;
							    	   Pattern ra = Pattern.compile(pattern_concept);
								       Matcher ma=	ra.matcher(convertedTexts[t]);
								        
								       if(ma.find())
								       {
								    	     if(ma.group().contains("concept_NN"))
									    	   {						    		
									    		   String conceptName="\\w+NN\\b";
										    	   Pattern concept=Pattern.compile(conceptName);
										    	   Matcher MatchConcept=concept.matcher(ma.group());
										    	   if(MatchConcept.find())
										    	   {
										    	   String Conceptname=MatchConcept.group().replaceAll("_\\S+", "");	
										    	   System.out.println("Statement of single-attributes:"+Conceptname);
										    	   array1[1]=Conceptname.trim().concat(":'")+Conceptname.trim().concat("'").trim();	
										    	   }  
									    	   }
								    	   
									    	   if(!(ma.group().contains("concept_NN")))
									    	   {	
									    	   String Conceptname=ma.group().replaceAll("_\\S+", "").trim();
									    	   System.out.println("Statement of single concept has:"+Conceptname);
									    	   
									    	   if(ma.group().contains("the_DT"))
									    	   {
									    	   String c=ma.group().replaceAll("_\\S+", "").substring(4).trim();
									    	   System.out.println("Statement of single concept have:"+c);
									    	   String[] words = c.split("\\s+");
									    	   System.out.println("length of words have:"+words.length); 
									    	   
									    	   if(words.length==2)
									    	   {
									    	   System.out.println("Statement of single-attributes have DT:"+words[1]); 
									    	   array1[1]=words[0]+"_"+words[1].trim().concat(":'")+words[0]+"_"+words[1].trim().concat("'").trim();	
									    	   }
									    	 
									    	   if(words.length==1)
									    	   {
									    		   System.out.println("Statement of single-attributes ARE:"+words[0]);
										    	   array1[1]=words[0].trim().concat(":'")+words[0].trim().concat("'").trim();	   
									    	   }
									          }
									    	 if(!(ma.group().contains("the_DT")))
									    	 {
									    		 System.out.println("nO DT");
									    		 String[] words = Conceptname.split("\\s+");
									    		 System.out.println("length of words have:"+words.length); 
									    		 if(words.length==2)
										    	   {
										    	   System.out.println("Statement of single-attributes have DT:"+words[0]+" "+words[1]); 
										    	   array1[1]=words[0]+"_"+words[1].trim().concat(":'")+words[0]+"_"+words[1].trim().concat("'").trim();	
										    	   }
										    	   if(words.length==1)
										    	   {
										    		   System.out.println("Statement of single-attributes ARE:"+words[0]);
											    	   array1[1]=words[0].trim().concat(":'")+words[0].trim().concat("'").trim();	   
										    	   }
									    	 }
									    	 
									    	  }
									       System.out.println("single attributes concept name:"+array1[1]);
							    		   if(!(textArea_DSL.getText().contains(array1[1])))
								    	     {
							    			   textArea_DSL.append(";"+"\n\n"+array1[1]);
								    	     }
								    	   
								    	   }
							    	   }
						    		   
						    		   //when data type is defined.
						    		   if((convertedTexts[t].contains("string_NN"))|(convertedTexts[t].contains("int_NN"))|
						    		   (convertedTexts[t].contains("id_NN"))|(convertedTexts[t].contains("boolean_JJ")))
						    		   {
							    	   String pattern_attribute= "(?<=\\w+CD\\b.*\\w+VBZ\\b).*?(?=\\w+IN\\b)"
							    			  +"|(?<=\\w+MD\\b.*\\w+VBN\\b).*?(?=\\w+IN\\b)"
							    			  +"|(?<=\\w+MD\\b.*\\w+IN\\b).*?(?=\\w+IN\\b)"
							    			  +"|(?<=\\w+VBN\\b.*\\w+VB\\b).*?(?=\\w+IN\\b)"
							    			  +"|(?<=\\w+VBN\\b.*\\w+VBG\\b).*?(?=\\w+IN\\b)";
							    			  
							    	   Pattern r1 = Pattern.compile(pattern_attribute);
								       Matcher m1=	r1.matcher(convertedTexts[t]);
								       if(m1.find())
								       {
								    	   String conceptName="\\w+NN\\b";
								    	   Pattern concept=Pattern.compile(conceptName);
								    	   Matcher MatchConcept1=concept.matcher(m1.group());
								    	   if(MatchConcept1.find())
								    	   {
								    	   String attribute1=MatchConcept1.group().replaceAll("_\\S+", "");	
								    	   System.out.println("Statement of single-category attributes:"+attribute1);
								    	   array1[2]=attribute1;
								       }
								       }
								       
								       String type=
										    	  "(?<=\\w+MD\\b.*\\w+VBN\\b.*\\w+IN\\b).*"
												  +"|(?<=\\w+MD\\b.*\\w+IN\\b.*\\w+IN\\b).*"
												  +"|(?<=\\w+VBN\\b.*\\w+VB\\b.*\\w+IN\\b).*"
												  +"|(?<=\\w+VBN\\b.*\\w+VBG\\b.*\\w+IN\\b).*"
												  +"|(?<=\\w+CD\\b.*\\w+VBZ\\b.*\\w+IN\\b).*"
												  ;
							    	   Pattern r3 = Pattern.compile(type);
								       Matcher m3=	r3.matcher(convertedTexts[t]);
								       if(m3.find())
								       {
								    	   String attribute2=m3.group().replaceAll("_\\S+", "");	
								    	   System.out.println("type:"+attribute2);
								    	   if((m3.group().contains("ID_NN"))|(m3.group().contains("id_NN")))
						    				  {
						    				  type=m3.group().replaceAll("_\\S+", "").substring(0,3).toUpperCase();
						    				  //added 
						    				  array1[3]=type;
						    				  }
								    	   
						    				
						    				else if(m3.group().contains("int_NN"))
						    				  {
						    				  type=m3.group().replaceAll("_\\S+", "").substring(0,4).toUpperCase();
						    				  array1[3]=type;
						    				  }
						    				else if (m3.group().contains("boolean_JJ"))
						    				  {
						    					type= "\n".concat("(")+array1[2].concat("?='")+array1[2].concat("')?");
						    					array1[3]=type;
						    				  }
						    				  else if(m3.group().contains("string_NN"))
						    				  {
						    					type=m3.group().replaceAll("_\\S+", "").substring(0,7).toUpperCase();
						    					array1[3]=type;
						    				  }
						    				  else
						    				  {
						    					type=m3.group().replaceAll("_\\S+", "").toUpperCase();
						    					//String[] a=type.split(" ");
						    					
						    					//for(int o=0;o<a.length;o++)
						    					//{
						    					//System.out.println("type defined for single category:"+a[1]);
						    					//}
						    					//array1[4]=a[1];
						    					System.out.println("type defined1 for single category:"+m3);
						    				  }
						   	           }
								       if(!(m3.group().contains("boolean_JJ")))
								       {
								       //string type
							            String elementk="\n"+
							            		array1[2].concat("=").trim()+array1[3].trim();
							            textArea_DSL.append(elementk);
								       }
								       else if((m3.group().contains("boolean_JJ")))
								    	   
								       {
								       //string type
							            String elementk="\n".concat("(")+array1[2].concat("?='")+array1[2].concat("')?");
							            textArea_DSL.append(elementk);
								       }
						    		  }//when datatype is defined.
						    		   
						    		   
						    		 //when datatype is not defined.
						    		   
						    		   else 
						    		   {
						    			   String pattern_attribute= "(?<=\\w+CD\\b.*\\w+VBZ\\b).*"
									    			  +"|(?<=\\w+MD\\b.*\\w+VBN\\b).*"
									    			  +"|(?<=\\w+MD\\b.*\\w+IN\\b).*"
									    			  +"|(?<=\\w+VBN\\b.*\\w+VB\\b).*"
									    			  +"|(?<=\\w+VBN\\b.*\\w+VBG\\b).*"
									    			  ;
									    			  
									    	   Pattern r1 = Pattern.compile(pattern_attribute);
										       Matcher m1=	r1.matcher(convertedTexts[t]);
										       if(m1.find())
										       {
										    	   String conceptName="\\w+NN\\b";
										    	   Pattern concept=Pattern.compile(conceptName);
										    	   Matcher MatchConcept1=concept.matcher(m1.group());
										    	   if(MatchConcept1.find())
										    	   {
										    	   String attribute1=MatchConcept1.group().replaceAll("_\\S+", "");	
										    	   System.out.println("Statement of single-category attributes:"+attribute1);
										    	   array1[2]=attribute1;
										    	   String conceptq=array1[2].concat("=null");
										    	   textArea_DSL.append("\n"+conceptq);
										           }
										       }
						    		     }
//#################################################################################################################################################3						    		   
						    		   
						    	   }//single
//###############################################################################################################################################								    	   
					          }
					           }//optional & single-attibutes
		        	 }				       
//#####################################################################################################################################################		        	 
		        	 if(convertedTexts[t].contains("where_WRB"))
		    			{		    				
		        		    String split="\\w+WRB+\\b";
							String[] text=convertedTexts[t].split(split);
							
							for(int u=0;u<text.length;u++)
							{
								System.out.println("\n\n"+"'with where text is':: "+text[u]);
								//if root element exist
//#####################################################################################################################################################################################
								for(String executed_pattern:nestedObj.pattern1f)
				  	    	    {	        
				      		      String[] arr1=new String[6];
				            	  Pattern pattern=Pattern.compile(executed_pattern);
							      Matcher matched=pattern.matcher(text[u]);
							      if(matched.find())
							      {
							    	  System.out.println("#############################################################################");
								      System.out.println("\n\n"+"Expression:: "+text[u].replaceAll("_\\S+", ""));
								      System.out.println("Matched Rule: " + executed_pattern);
								      arr1[0]=executed_pattern;
								    //  text_rules.append(arr1[0]);
								      
								       //1st way  for timing model
								      Pattern p = Pattern.compile("\\w+NN\\b.\\w+NN\\b");//. represents single character  
								      Matcher m = p.matcher(matched.group());  
								      System.out.println("Matched statement: " + m);
								      
								      Pattern p1 = Pattern.compile("\\w+JJ\\b.\\w+NN\\b");//. represents single character  
								      Matcher m1 = p1.matcher(matched.group());  
								      System.out.println("Matched statement: " + m1);
								      
								      if(m.find())
								   	  {
									      String patternb="(?<=\\w+VB\\b).*|(?<=\\w+VBZ\\b.*\\w+IN\\b).*";
									      Pattern patternf=Pattern.compile(patternb);
									      Matcher matchedb=patternf.matcher(text[u]);
									      if(matchedb.find())
									      {
									    	  String s="\\w+NN\\b.\\w+NN\\b";
									    	  Pattern pa=Pattern.compile(s);
									    	  Matcher match=pa.matcher(matchedb.group());
									    	  if(match.find())
									    	  {
									    	  String expression=match.group().replaceAll("_\\S+", "").trim();
									    	  System.out.println("System Has:"+expression);
									    	  
									    	  arr1[1]=expression;
									    	  System.out.println("#############################################################################");
									      }}
									      arr1[1] = arr1[1].replace(" ", "_");
									      nestedObj.main1="\n"+arr1[1].concat(":'")+arr1[1].concat("'").trim();
									      System.out.println("added in xtext aGGs:"+nestedObj.main);
									      arr1[2]=nestedObj.main1;
									      if(!(textArea_DSL.getText().contains(arr1[2])))
									      {
									      textArea_DSL.append(arr1[2]);
									      }
								   	  }
//####################################################################################################################################################################################
								    //2ND way  for diabetic manager if(m0.find())
								      else if(m1.find())
								      {
					    				  //system
									      String patternv="(\\w+NN\\b).(?=\\w+VBZ\\b)|(\\w+NN\\b).(?=\\w+MD\\b)";  
									      Pattern patterns=Pattern.compile(patternv);
									      Matcher matcheds=patterns.matcher(text[u]);
									      if(matcheds.find())
									      {
									    	  String expression=matcheds.group().replaceAll("_\\S+", "").trim();
									    	  System.out.println("System Has:"+expression);
									    	  arr1[1]=expression;
									    	  System.out.println("#############################################################################");
									      }
					    				  //diabetic manager
									      String patternba="(\\w+JJ\\b.\\w+NN\\b)";  
									      Pattern patternfa=Pattern.compile(patternba);
									      Matcher matchedba=patternfa.matcher(text[u]);
									      if(matchedba.find())
									      {
									    	  String expression=matchedba.group().replaceAll("_\\S+", "").trim();
									    	  System.out.println("System Has:"+expression);
									    	  arr1[2]=expression;
									    	  System.out.println("#############################################################################");
									      }
									      nestedObj.main=arr1[1].concat(":'").trim();
									      nestedObj.maina=arr1[2].concat("'").trim();
									      
									      nestedObj.mainroot="\n"+nestedObj.main+nestedObj.maina;
									      System.out.println("added in xtext aGGs:"+nestedObj.mainroot);
									      arr1[3]=nestedObj.mainroot;
									      if(!(textArea_DSL.getText().contains(arr1[3])))
									      {	  
									      textArea_DSL.append(arr1[3]);
									      }
								      }
								      }
				  	    	        } 	
//############################################################################################################################################################################## 
				                   //pattern to check relationship element
							       for(String exec:nestedObj.pattern_VBZ)
							       {
							       Pattern r = Pattern.compile(exec);
							       Matcher m=	r.matcher(text[u]);
							       if(m.find())
							       {
							    	   System.out.println("Statement of relationships:"+m.group());	
//###############################################################################################################################################################################
							    	   if(text[u].contains("it_PRP"))
							    	   {
								    	   System.out.println("Statement of 'where PRP' relationships:"+text[u]);   
								    	   if((text[u].contains("contains_VBZ"))
								    		   |(text[u].contains("contain_VB"))
								    		   |(text[u].contains("composed_VBN")))
								    	   {
								    		   String[] arrx=new String[7];
								    		   arrx[0]=exec;//store the pattern of executed rules
								    		   
								    		   System.out.println("Statement of 'where containment' relationships:"+text[u]);     
								    		   //extract assocaition
								    		   
								    		   String[] conceptName=text[u].split(" ");
								    		   if(conceptName[1].contains("_NN"))
								    		   {
								    		   System.out.println("CONCEPT Name of 'where containment:"+conceptName[3]); 
								    		   String RootElement=conceptName[2].replaceAll("_\\S+", "");
								    		   String CONCEPT="\n\n"+RootElement.concat(":'");
								    		   String CONCEPT2=RootElement.concat("'");
								    		   arrx[1]=CONCEPT+CONCEPT2;
								    		   }
									    	   
								    		   String patterna="(?<=\\w+JJ\\b).*";
								    		   Pattern ra = Pattern.compile(patterna);
										       Matcher ma=	ra.matcher(text[u]);
										       if(ma.find())
										       {
										    	   System.out.println("association name:"+ma.group()); 
										    	   String patternaa="\\w+NN\\b.";
									    		   Pattern raa = Pattern.compile(patternaa);
											       Matcher maa=	raa.matcher(ma.group());
											       if(maa.find())
											       {
											    	   System.out.println("association name1:"+maa.group().replaceAll("_\\S+", ""));     
											    	   String associationName=maa.group().replaceAll("_\\S+", "").trim();
											    	   arrx[2]=associationName.trim();
											       }
										       }
										       //extract multiplicity
										       String patternb="\\w+JJ\\b";								       
										       Pattern ra1 = Pattern.compile(patternb);
										       Matcher ma2=	ra1.matcher(text[u]);   
										       if(ma2.find())
										       {
										    	   System.out.println("multiplicity name:"+ma2.group()); 
										    	   String multiplicity=ma2.group().replaceAll("_\\S+", "");
										    	 
										    	   if(ma2.group().contains("multiple_JJ"))
					      	     		        	  {
					       	     		        		arrx[3]="+=";
					       	     		        		arrx[4]="*";
					       	     		        		
					       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx[2]+arrx[3]+arrx[2].trim().concat(")")+arrx[4];
					       	     		        		System.out.println("Statement hasf Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        		System.out.println("#####################################################################");
					       		     		        	System.out.println("\n");
					      	     		        	  }
					       	     		        	
										    	   else if(ma2.group().contains("single_JJ"))
					       	     		        	{
					       	     		        		arrx[3]="=";
					       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx[2]+arrx[3]+arrx[2].trim().concat(")");
					       	     		        		System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        		System.out.println("#####################################################################");
					       		     		        	System.out.println("\n");
					       	     		        	}
					       	     		        	
										    	   else if(ma2.group().contains("optional_JJ"))
					      	     		        	{
					       	     		        		
					       	     		        		arrx[3]="=";
					       	     		        		arrx[4]="?";
					       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx[2]+arrx[3]+arrx[2].trim().concat(")")+arrx[4];
					       	     		        		System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        		System.out.println("#####################################################################");
					       		     		        	System.out.println("\n"); 
					       	     		        	}
										    	   else 
										    	   {
										    		   arrx[3]="=";
										    		   nestedObj.descriptionContaining1="\n".concat("(")+arrx[2]+arrx[3]+arrx[2].trim().concat(")");
					       	     		        	   System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        	   System.out.println("#####################################################################");
					       		     		           System.out.println("\n"); 
										    	   }
								    	   }
										       arrx[5]=nestedObj.descriptionContaining1;	
										       nestedObj.descriptionContainingd=arrx[5];	
										       textArea_DSL.append(arrx[5]);
								    	  }
//########################################################################################################################################################################						    	  
								    	   if(text[u].contains("linked_VBN"))
									    	   {
								    		   System.out.println("Statement of 'reference' relationships:"+text[u]);  
								    		   String arrx1[]=new String[7];
								    		   arrx1[0]=exec;
								    		   
								    		   
								    		   String[] conceptName=text[u].split(" ");
								    		   System.out.println("CONCEPT Name 2of 'where containment:"+conceptName[1]); 
								    		   String RootElement=conceptName[1].replaceAll("_\\S+", "");
								    		   String CONCEPT="\n\n"+RootElement.concat(":'")+RootElement.concat("'");
								    		   textArea_DSL.append(CONCEPT);
								    		   
								    		   //extract assocaition
								    		   String patterna="(?<=\\w+JJ\\b).*";
								    		   Pattern ra = Pattern.compile(patterna);
										       Matcher ma=	ra.matcher(text[u]);
										       if(ma.find())
										       {
										    	   System.out.println("association name:"+ma.group()); 
										    	   String patternaa="\\w+NN\\b.";
									    		   Pattern raa = Pattern.compile(patternaa);
											       Matcher maa=	raa.matcher(ma.group());
											       if(maa.find())
											       {
											    	   System.out.println("association name1:"+maa.group().replaceAll("_\\S+", ""));     
											    	   String associationName=maa.group().replaceAll("_\\S+", "");
											    	   arrx1[1]=associationName.trim();
											       }
										       }
										       //extract multiplicity
										       String patternb="\\w+JJ\\b";								       
										       Pattern ra1 = Pattern.compile(patternb);
										       Matcher ma2=	ra1.matcher(text[u]);
										       if(ma2.find())
										       {
										    	   System.out.println("multiplicity name:"+ma2.group()); 
										    	   String multiplicity=ma2.group().replaceAll("_\\S+", "");
										    	   
										    	   if(ma2.group().contains("multiple_JJ"))
					      	     		        	  {
					       	     		        		arrx1[2]="+=";
					       	     		        		arrx1[3]="*";
					       	     		        		
					       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx1[1]+arrx1[2].concat("[")+arrx1[1].trim().concat("])")+arrx1[3];
					       	     		        		System.out.println("Statement hasf Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        		System.out.println("#####################################################################");
					       		     		        	System.out.println("\n");
					       		     		        	  	 
					      	     		        	  }
					       	     		        	
										    	   else if(ma2.group().contains("single_JJ"))
					       	     		        	{
					       	     		        		arrx1[2]="=";
					       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx1[1]+arrx1[2].concat("[")+arrx1[1].trim().concat("])");
					       	     		        		System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        		System.out.println("#####################################################################");
					       		     		        	System.out.println("\n");
					       	     		        	}
					       	     		        	
										    	   else if(ma2.group().contains("optional_JJ"))
					      	     		        	{
					       	     		        		
					       	     		        		arrx1[2]="=";
					       	     		        		arrx1[3]="?";
					       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx1[1]+arrx1[2].concat("[")+arrx1[1].trim().concat("])")+arrx1[3];
					       	     		        		System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        		System.out.println("#####################################################################");
					       		     		        	System.out.println("\n"); 
					       	     		        	}
										    	   else 
										    	   {
										    		   arrx1[2]="=";
										    		   nestedObj.descriptionContaining1="\n".concat("(")+arrx1[1]+arrx1[2].concat("[")+arrx1[1].trim().concat("])");
					       	     		        	   System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        	   System.out.println("#####################################################################");
					       		     		           System.out.println("\n"); 
										    	   }
										       }
										       arrx1[5]=nestedObj.descriptionContaining1;
										       textArea_DSL.append(arrx1[5]);
									    	   }
							    	   }//prp hai
//###############################################################################################################################################################################
							    	   if(!(text[u].contains("it_PRP")))
							    	   {
								    	   System.out.println("Statement of 'where t_PRP' relationships:"+text[u]);   
								    	   if((text[u].contains("contains_VBZ"))
								    		   |(text[u].contains("contain_VB"))
								    		   |(text[u].contains("composed_VBN")))
								    	   {
								    		   if (!(text[u].startsWith(" the_DT")))
								    		   {
								    		   System.out.println("The sentence not starts with 'The_DT'.");
								    		   
								    		   String[] arrxa=new String[7];
								    		   List<String> string = new ArrayList<>();
								    		   
								    		   arrxa[0]=exec;//store the pattern of executed rules
								    		   System.out.println("Statement of 'where containment' relationships:"+text[u]);     
								    		   
								    		   //extract assocaition
								    		   String[] conceptName=text[u].split(" ");
								    		   if(conceptName[3].contains("_NN"))
								    		   {
								    		   System.out.println("CONCEPT1 Name of 'where containment is:"+conceptName[3]); 
								    		   String RootElement=conceptName[3].replaceAll("_\\S+", "");
								    		   nestedObj.CONCEPT=RootElement.concat(":'").trim();
								    		   nestedObj.CONCEPT2=RootElement.concat("'").trim();
								    		   arrxa[1]="\n\n"+nestedObj.CONCEPT+nestedObj.CONCEPT2;
								    		   }
								    		   
								    		   if(conceptName[1].contains("_NN"))
								    		   {
								    		   System.out.println("CONCEPT2 Name of 'where containment has:"+conceptName[2]); 
								    		   String RootElement=conceptName[2].replaceAll("_\\S+", "");
								    		   String CONCEPT=RootElement.concat(":'").trim();
								    		   String CONCEPT2=RootElement.concat("'").trim();
								    		   arrxa[1]="\n\n"+CONCEPT+CONCEPT2;
								    		   }
								    		  
								    		   String patterna="(?<=\\w+JJ\\b).*";
								    		   Pattern ra = Pattern.compile(patterna);
										       Matcher ma=	ra.matcher(text[u]);
										       if(ma.find())
										       {
										    	   System.out.println("association name:"+ma.group()); 
										    	   String patternaa="\\w+NN\\b.";
									    		   Pattern raa = Pattern.compile(patternaa);
											       Matcher maa=	raa.matcher(ma.group());
											       if(maa.find())
											       {
											    	   System.out.println("association name1:"+maa.group().replaceAll("_\\S+", ""));     
											    	   String associationName=maa.group().replaceAll("_\\S+", "").trim();
											    	   arrxa[2]=associationName.trim();
											       }
										       }
										       //extract multiplicity
										       String patternb="\\w+JJ\\b";								       
										       Pattern ra1 = Pattern.compile(patternb);
										       Matcher ma2=	ra1.matcher(text[u]);   
										       if(ma2.find())
										       {
										    	   System.out.println("multiplicity name:"+ma2.group()); 
										    	   String multiplicity=ma2.group().replaceAll("_\\S+", "");
										    	 
										    	   if(ma2.group().contains("multiple_JJ"))
					      	     		        	  {
					       	     		        		arrxa[3]="+=";
					       	     		        		arrxa[4]="*";
					       	     		        		
					       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrxa[2]+arrxa[3]+arrxa[2].trim().concat(")")+arrxa[4];
					       	     		        		System.out.println("Statement hasf Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        		System.out.println("#####################################################################");
					       		     		        	System.out.println("\n");
					      	     		        	  }
					       	     		        	
										    	   else if(ma2.group().contains("single_JJ"))
					       	     		        	{
					       	     		        		arrxa[3]="=";
					       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrxa[2]+arrxa[3]+arrxa[2].trim().concat(")");
					       	     		        		System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        		System.out.println("#####################################################################");
					       		     		        	System.out.println("\n");
					       	     		        	}
					       	     		        	
										    	   else if(ma2.group().contains("optional_JJ"))
					      	     		        	{
					       	     		        		
					       	     		        		arrxa[3]="=";
					       	     		        		arrxa[4]="?";
					       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrxa[2]+arrxa[3]+arrxa[2].trim().concat(")")+arrxa[4];
					       	     		        		System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        		System.out.println("#####################################################################");
					       		     		        	System.out.println("\n"); 
					       	     		        	}
										    	   else 
										    	   {
										    		   arrxa[3]="=";
										    		   nestedObj.descriptionContaining1="\n".concat("(")+arrxa[2]+arrxa[3]+arrxa[2].trim().concat(")");
					       	     		        	   System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        	   System.out.println("#####################################################################");
					       		     		           System.out.println("\n"); 
										    	   }
								    	   }
										       arrxa[5]=nestedObj.descriptionContaining1;
										      string.add(nestedObj.descriptionContaining1);
//##########################################################################################################################################										        
										      String texta = textArea_DSL.getText();
										       
										       
					       	     		          //main-->system    
										          System.out.println(nestedObj.CONCEPT);
										          System.out.println(nestedObj.mainroot);
										          System.out.println(nestedObj.main);
										          StringBuilder sb = new StringBuilder();
										          
										         if(nestedObj.CONCEPT.contains("system"))
										         {
										          if(nestedObj.main.equals(nestedObj.CONCEPT))
										          {
										        	  String textc=textArea_DSL.getText();
					        	                       if(!(textc.contains(arrxa[1])) && textc.contains(nestedObj.main))
						       	     		             {
							       	     		        	int Index = textc.indexOf(nestedObj.mainroot);		       	     		            		
							       	     		            System.out.println("index"+Index);
							       	     		            int newIndex = Index + nestedObj.mainroot.length();
							       	     		            System.out.println("new index"+newIndex);
							       	     		                		
							       	     		           if(!textc.contains(nestedObj.descriptionContaining1))
					       	     		                    {
							       	     		        	textArea_DSL.insert(arrxa[5].toString(), newIndex);
					       	     		                    }
							       	     		        
							       	     		            if(textc.contains(nestedObj.descriptionContaining1))
							       	     		            {
							       	     		            System.out.println("concepta"+nestedObj.descriptionContaining1);
							       	     		            int Index2 = textc.indexOf(nestedObj.descriptionContaining1);
							       	     		            System.out.println("INDEX2"+Index2);
							       	     		            int index3 = Index2+nestedObj.descriptionContaining1.length();
							       	     		            textArea_DSL.insert(arrxa[5], index3);
							       	     		             }
						       	     		             
										                   }
										          
										         }
										         }
										        
										         
										         else if(!(texta.contains(arrxa[1])))
					       	     		               {
							       	     		        	textArea_DSL.append(";"+arrxa[1]);
					       	     		               }
										       
										          String textc= textArea_DSL.getText();
						       	     		      if(textc.contains(arrxa[1]))
						       	     		      {
						       	     		    	    int j=textc.indexOf(arrxa[1]);
				 	       	     		                System.out.println(arrxa[1]+"indexpos:"+j);
					       	     		                System.out.println("now result has by concept"+arrxa[1]);
					       	     	                    int newIndex = j + arrxa[1].length();
					       	     		                System.out.println("new index"+j);
					       	     		                textArea_DSL.insert(arrxa[5], newIndex);
						       	     		      }
								    		   }// not starts with ' the_DT'
								    		   
//################################################################################################################################################################################								    		   
								    		if ((text[u].startsWith(" the_DT")))
								    	     {
								    		   System.out.println("The sentence starts with ' The_DT'.");
								    		  
								    		   String[] arrxv=new String[7];
								    		   
								    		   //extract concept name
								    		   String[] conceptName=text[u].split(" ");
								    		   if(conceptName[2].contains("_NN"))
								    		   {
								    		   System.out.println("CONCEPT2  Name of 'where containment is:"+conceptName[2]); 
								    		   String RootElement=conceptName[2].replaceAll("_\\S+", "");
								    		   nestedObj.CONCEPT=RootElement.concat(":'").trim();
								    		   nestedObj.CONCEPT2=RootElement.concat("'").trim();
								    		   arrxv[1]="\n\n"+nestedObj.CONCEPT+nestedObj.CONCEPT2;
								    		   System.out.println("Concept Name:"+arrxv[1]);
								    		   }
								    		   
								    		   //extract the asssociation name
								    		   String patterna="(?<=\\w+JJ\\b).*";
								    		   Pattern ra = Pattern.compile(patterna);
										       Matcher ma=	ra.matcher(text[u]);
										       if(ma.find())
										       {
										    	   System.out.println("association name:"+ma.group()); 
										    	   String patternaa="\\w+NN\\b.";
									    		   Pattern raa = Pattern.compile(patternaa);
											       Matcher maa=	raa.matcher(ma.group());
											       if(maa.find())
											       {
											    	   System.out.println("association name1:"+maa.group().replaceAll("_\\S+", ""));     
											    	   String associationName=maa.group().replaceAll("_\\S+", "").trim();
											    	   arrxv[2]=associationName.trim();
											       }
										       }
										       
										       //extract the multiplicities
										       String patternb="\\w+JJ\\b";								       
										       Pattern ra1 = Pattern.compile(patternb);
										       Matcher ma2=	ra1.matcher(text[u]);   
										       if(ma2.find())
										       {
										    	   System.out.println("multiplicity name:"+ma2.group()); 
										    	   String multiplicity=ma2.group().replaceAll("_\\S+", "");
										    	 
										    	   if(ma2.group().contains("multiple_JJ"))
					      	     		        	  {
					       	     		        		arrxv[3]="+=";
					       	     		        		arrxv[4]="*";
					       	     		        		
					       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrxv[2]+arrxv[3]+arrxv[2].trim().concat(")")+arrxv[4];
					       	     		        		System.out.println("Statement hasf Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        		System.out.println("#####################################################################");
					       		     		        	System.out.println("\n");
					      	     		        	  }
					       	     		        	
										    	   else if(ma2.group().contains("single_JJ"))
					       	     		        	{
					       	     		        		arrxv[3]="=";
					       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrxv[2]+arrxv[3]+arrxv[2].trim().concat(")");
					       	     		        		System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        		System.out.println("#####################################################################");
					       		     		        	System.out.println("\n");
					       	     		        	}
					       	     		        	
										    	   else if(ma2.group().contains("optional_JJ"))
					      	     		        	{
					       	     		        		
					       	     		        		arrxv[3]="=";
					       	     		        		arrxv[4]="?";
					       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrxv[2]+arrxv[3]+arrxv[2].trim().concat(")")+arrxv[4];
					       	     		        		System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        		System.out.println("#####################################################################");
					       		     		        	System.out.println("\n"); 
					       	     		        	}
										    	   else 
										    	   {
										    		   arrxv[3]="=";
										    		   nestedObj.descriptionContaining1="\n".concat("(")+arrxv[2]+arrxv[3]+arrxv[2].trim().concat(")");
					       	     		        	   System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        	   System.out.println("#####################################################################");
					       		     		           System.out.println("\n"); 
										    	   }
								    	      }
										      //
										       if(!(textArea_DSL.getText().contains(arrxv[1])))
										       {
										    	   textArea_DSL.append(";"+arrxv[1]);
										       }
										       arrxv[5]=nestedObj.descriptionContaining1;
										       textArea_DSL.append(arrxv[5]);
										       
								    	     }// have starts with ' the_DT'
								    	   }
//########################################################################################################################################################################						    	  
								    	   if(text[u].contains("linked_VBN"))
									    	 {
								    		   if(text[u].startsWith(" the_DT"))
								    		   {
								    		   System.out.println("Statement of 'DT reference' relationships:"+text[u]);  
								    		   String arrx1[]=new String[7];
								    		   arrx1[0]=exec;
								    		   
								    		   String[] conceptName=text[u].split(" ");
								    		   System.out.println("CONCEPT Name 2of 'where reference:"+conceptName[2]); 
								    		   String RootElement=conceptName[2].replaceAll("_\\S+", "");
								    		   String CONCEPT="\n\n"+RootElement.concat(":'")+RootElement.concat("'");
								    		   textArea_DSL.append(CONCEPT);
								    		   
								    		   //extract assocaition
								    		   String patterna="(?<=\\w+JJ\\b).*";
								    		   Pattern ra = Pattern.compile(patterna);
										       Matcher ma=	ra.matcher(text[u]);
										       if(ma.find())
										       {
										    	   System.out.println("association name:"+ma.group()); 
										    	   String patternaa="\\w+NN\\b.";
									    		   Pattern raa = Pattern.compile(patternaa);
											       Matcher maa=	raa.matcher(ma.group());
											       if(maa.find())
											       {
											    	   System.out.println("association name1:"+maa.group().replaceAll("_\\S+", ""));     
											    	   String associationName=maa.group().replaceAll("_\\S+", "");
											    	   arrx1[1]=associationName.trim();
											       }
										       }
										       //extract multiplicity
										       String patternb="\\w+JJ\\b";								       
										       Pattern ra1 = Pattern.compile(patternb);
										       Matcher ma2=	ra1.matcher(text[u]);
										       if(ma2.find())
										       {
										    	   System.out.println("multiplicity name:"+ma2.group()); 
										    	   String multiplicity=ma2.group().replaceAll("_\\S+", "");
										    	   
										    	   if(ma2.group().contains("multiple_JJ"))
					      	     		        	  {
					       	     		        		arrx1[2]="+=";
					       	     		        		arrx1[3]="*";
					       	     		        		
					       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx1[1]+arrx1[2].concat("[")+arrx1[1].trim().concat("])")+arrx1[3];
					       	     		        		System.out.println("Statement hasf Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        		System.out.println("#####################################################################");
					       		     		        	System.out.println("\n");
					       		     		        	  	 
					      	     		        	  }
					       	     		        	
										    	   else if(ma2.group().contains("single_JJ"))
					       	     		        	{
					       	     		        		arrx1[2]="=";
					       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx1[1]+arrx1[2].concat("[")+arrx1[1].trim().concat("])");
					       	     		        		System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        		System.out.println("#####################################################################");
					       		     		        	System.out.println("\n");
					       	     		        	}
					       	     		        	
										    	   else if(ma2.group().contains("optional_JJ"))
					      	     		        	{
					       	     		        		
					       	     		        		arrx1[2]="=";
					       	     		        		arrx1[3]="?";
					       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx1[1]+arrx1[2].concat("[")+arrx1[1].trim().concat("])")+arrx1[3];
					       	     		        		System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        		System.out.println("#####################################################################");
					       		     		        	System.out.println("\n"); 
					       	     		        	}
										    	   else 
										    	   {
										    		   arrx1[2]="=";
										    		   nestedObj.descriptionContaining1="\n".concat("(")+arrx1[1]+arrx1[2].concat("[")
										    				   +arrx1[1].trim().concat("])");
										    		   
					       	     		        	   System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        	   System.out.println("#####################################################################");
					       		     		           System.out.println("\n"); 
										    	   }
										       }
										       arrx1[5]=nestedObj.descriptionContaining1;
										       textArea_DSL.append(arrx1[5]);
								    		   }
								    		   else
								    		   {
								    		   System.out.println("Statement of '!DT reference' relationships:"+text[u]);  
								    		   String arrx1[]=new String[7];
								    		   arrx1[0]=exec;
								    		   
								    		   String[] conceptName=text[u].split(" ");
								    		   System.out.println("CONCEPT Name of '!DT where reference:"+conceptName[3]); 
								    		   String RootElement=conceptName[3].replaceAll("_\\S+", "");
								    		   String CONCEPT="\n\n"+RootElement.concat(":'")+RootElement.concat("'");
								    		   textArea_DSL.append(CONCEPT);
								    		   
								    		   //extract assocaition
								    		   String patterna="(?<=\\w+JJ\\b).*";
								    		   Pattern ra = Pattern.compile(patterna);
										       Matcher ma=	ra.matcher(text[u]);
										       if(ma.find())
										       {
										    	   System.out.println("association name:"+ma.group()); 
										    	   String patternaa="\\w+NN\\b.";
									    		   Pattern raa = Pattern.compile(patternaa);
											       Matcher maa=	raa.matcher(ma.group());
											       if(maa.find())
											       {
											    	   System.out.println("association name1:"+maa.group().replaceAll("_\\S+", ""));     
											    	   String associationName=maa.group().replaceAll("_\\S+", "");
											    	   arrx1[1]=associationName.trim();
											       }
										       }
										       //extract multiplicity
										       String patternb="\\w+JJ\\b";								       
										       Pattern ra1 = Pattern.compile(patternb);
										       Matcher ma2=	ra1.matcher(text[u]);
										       if(ma2.find())
										       {
										    	   System.out.println("multiplicity name:"+ma2.group()); 
										    	   String multiplicity=ma2.group().replaceAll("_\\S+", "");
										    	   
										    	   if(ma2.group().contains("multiple_JJ"))
					      	     		        	  {
					       	     		        		arrx1[2]="+=";
					       	     		        		arrx1[3]="*";
					       	     		        		
					       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx1[1]+arrx1[2].concat("[")+arrx1[1].trim().concat("])")+arrx1[3];
					       	     		        		System.out.println("Statement hasf Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        		System.out.println("#####################################################################");
					       		     		        	System.out.println("\n");
					       		     		        	  	 
					      	     		        	  }
					       	     		        	
										    	   else if(ma2.group().contains("single_JJ"))
					       	     		        	{
					       	     		        		arrx1[2]="=";
					       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx1[1]+arrx1[2].concat("[")+arrx1[1].trim().concat("])");
					       	     		        		System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        		System.out.println("#####################################################################");
					       		     		        	System.out.println("\n");
					       	     		        	}
					       	     		        	
					       	     		        else if(ma2.group().contains("optional_JJ"))
					      	     		        	{
					       	     		        		
					       	     		        		arrx1[2]="=";
					       	     		        		arrx1[3]="?";
					       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx1[1]+arrx1[2].concat("[")+arrx1[1].trim().concat("])")+arrx1[3];
					       	     		        		System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
					       	     		        		System.out.println("#####################################################################");
					       		     		        	System.out.println("\n"); 
					       	     		        	}
					       	     		    else 
			      	     		        	{
			       	     		        		
			       	     		        		arrx1[2]="=";
			       	     		        		nestedObj.descriptionContaining1="\n".concat("(")+arrx1[1]+arrx1[2].concat("[")+arrx1[1].trim().concat("])");
			       	     		        		System.out.println("Statement has Xtext added:"+nestedObj.descriptionContaining1);
			       	     		        		System.out.println("#####################################################################");
			       		     		        	System.out.println("\n"); 
			       	     		        	}
										    	   
										       }
										       arrx1[5]=nestedObj.descriptionContaining1;
										       textArea_DSL.append(arrx1[5]);
								    		   }
								    		   
								    		   
//###############################################################s###############################################################################
							    	  }
							    	   }//prp nhi hai
							    	   }
							       }
//###################################################################################################################################################						       
							     //pattern to check Multiple Attributes element
							       for(String patterns:nestedObj.patterna)
							       {
							    	   Pattern r = Pattern.compile(patterns);
								       Matcher m=	r.matcher(text[u]);
								       if(m.find())
								       {
								    	   String array1[]=new String[5];
								    	   System.out.println("Statement of multi-attributes:"+text[u]);	
								    	   array1[0]=patterns;	
								    	   
								    	   String[] concepta = text[u].split("\\s+");
								    	   if(!(concepta[1].contains("it_PRP")) | (concepta[2].contains("it_PRP")))
								    	   {
								    	   String pattern_concept="(\\w+NN\\b.\\w+NN\\b.(?=\\w+VBZ\\b))|(\\w+NN\\b.(?=\\w+VBZ))"
								    			   +"|(\\w+NN\\b.\\w+NN\\b.(?=\\w+MD\\b))|(\\w+NN\\b.(?=\\w+MD\\b))"
								    			   +"|(?<=\\w+IN\\b).*?(?=\\w+VBP\\b)"
								    			   ;
								    	   Pattern ra = Pattern.compile(pattern_concept);
									       Matcher ma=	ra.matcher(text[u]);
									       if(ma.find())
									       {
									    	   if(ma.group().contains("concept_NN"))
									    	   {						    		
									    		   String conceptName="\\w+NN\\b";
										    	   Pattern concept=Pattern.compile(conceptName);
										    	   Matcher MatchConcept=concept.matcher(ma.group());
										    	   if(MatchConcept.find())
										    	   {
										    	   String Conceptname=MatchConcept.group().replaceAll("_\\S+", "");	
										    	   System.out.println("concept of multi-attributes:"+Conceptname);
										    	   array1[1]=Conceptname.trim().concat(":'")+Conceptname.trim().concat("'").trim();	
										    	   }  
									    	   }
								    	   
								    	     if(!(ma.group().contains("concept_NN")))
									    	 {	
									    	   String Conceptname=ma.group().replaceAll("_\\S+", "").trim();	
									    	   System.out.println("Statement of multiple-attributes concept:"+Conceptname);
									    	   
									    	   String[] words=Conceptname.split("\\s+");
									    	   System.out.println("Statement of length:"+words.length);
									    	   
									    	   if(words.length==2)
									    	   {
									    		   for(String arr:words)
									    		   {
									    	        array1[1]=words[0]+"_"+words[1].trim().concat(":'")
									    	        		+words[0]+"_"+words[1].trim().concat("'").trim();	
									    		   }
									    	   }
									    	   
									    	   if(words.length==1)
									    	   {
									    		   array1[1]=words[0].trim().concat(":'")
									    	        		+words[0].trim().concat("'").trim();   
									    	   }
									    	   } 
								    	     
								    	        System.out.println("Multiple attributes concept name:"+array1[1]);
								    		   if(!(textArea_DSL.getText().contains(array1[1])))
									    	     {
								    			   textArea_DSL.append(";"+"\n\n"+array1[1]);
									    	     }
									       }
								    	  }
								    	   String pattern_attribute1=
								    			   "(?<=\\w+VBZ\\b.*\\w+IN\\b).*?(?=\\w+CC\\b)"//represented by //has attributes like name and category
								    			   +"|(?<=\\w+MD\\b.*\\w+IN\\b).*?(?=\\w+CC\\b)"//must define by name and category
								    			   +"|(?<=\\w+VB\\b).*?(?=\\w+VBN\\b|\\w+CC\\b)"//must have a name and category//must have a name preceded by 
								    			   +"|(?<=\\w+VBG\\b).*?(?=\\w+IN\\b)"//has attributes including name and category
								    			   +"|(?<=\\w+VBP\\b).*?(?=\\w+CC\\b)"//attributes of-- are name and category
								    			   +"|(?<=\\w+VBZ\\b).*?(?=\\w+WDT\\b)"//contains a name that should precede a category of
								    			   ;
								    	   Pattern r1 = Pattern.compile(pattern_attribute1);
									       Matcher m1=	r1.matcher(text[u]);
									       if(m1.find())
									       {
									    	   String conceptName="\\w+NN\\b";
									    	   Pattern concept=Pattern.compile(conceptName);
									    	   Matcher MatchConcept1=concept.matcher(m1.group());
									    	   if(MatchConcept1.find())
									    	   {
									    	   String attribute1=MatchConcept1.group().replaceAll("_\\S+", "");	
									    	   System.out.println("Statement of multi-attributes:"+attribute1);
									    	   array1[2]=attribute1;
									       }
									       }
									       
									       //2nd element ka baad.
									       if((text[u].contains("string_NN"))|(text[u].contains("int_NN"))
											       |(text[u].contains("boolean_JJ"))|(text[u].contains("id_NN")))
										   {
									       String pattern_attribute2=
								    			   "(?<=\\w+CC\\b).*?(?=\\w+IN\\b)"//represented by //has attributes like name and category
								    			   +"|(?<=\\w+MD\\b.*\\w+VBN\\b.*\\w+IN\\b).*?(?=\\w+IN\\b)"//must have a name preceded by catrgory of
								    			   +"|(?<=\\w+WDT\\b.*\\w+VB\\b).*?(?=\\w+IN\\b)"////contains a name that should precede a category of
								    			   ;
								    	   Pattern r2d = Pattern.compile(pattern_attribute2);
									       Matcher m2d=	r2d.matcher(text[u]);
									       if(m2d.find())
									       {
									    	   String conceptName="\\w+NN\\b";
									    	   Pattern concept=Pattern.compile(conceptName);
									    	   Matcher MatchConcept2=concept.matcher(m2d.group());
									    	   if(MatchConcept2.find())
									    	   {
									    	   String attribute2=MatchConcept2.group().replaceAll("_\\S+", "");	
									    	   System.out.println("Attribute2k:"+attribute2);
									    	   array1[3]=attribute2;
									           }
									       }
										   }
									       
									       else
									       {
										       String pattern_attribute2=
									    			   "(?<=\\w+CC\\b).*"
									    			   +"|(?<=\\w+MD\\b.*\\w+IN\\b).*"//must have a name preceded by catrgory of
									    			   +"|(?<=\\w+WDT\\b.*\\w+VB\\b).*"////contains a name that should precede a category of
									    			   ;
									    	   Pattern r2g = Pattern.compile(pattern_attribute2);
										       Matcher m2r=	r2g.matcher(text[u]);
										       if(m2r.find())
										       {
										    	   String conceptName="\\w+NN\\b";
										    	   Pattern concept=Pattern.compile(conceptName);
										    	   Matcher MatchConcept2=concept.matcher(m2r.group());
										    	   if(MatchConcept2.find())
										    	   {
										    	   String attribute2=MatchConcept2.group().replaceAll("_\\S+", "");	
										    	   System.out.println("Attribute2n:"+attribute2);
										    	   array1[3]=attribute2;
										    	   textArea_DSL.append("\n"+array1[2].concat("=null")+"\n"+array1[3].concat("=null"));
										    	   
										           }
										       }   
									       }
									       
									       //when type is defined ..
									       if((text[u].contains("string_NN"))|(text[u].contains("int_NN"))
											       |(text[u].contains("boolean_JJ"))|(text[u].contains("id_NN")))
										  {
									       String type=
								    			   "(?<=\\w+CC\\b.*\\w+IN\\b).*"
								    			   +"|(?<=\\w+MD\\b.*\\w+IN\\b.*\\w+IN\\b).*"
								    			   +"|(?<=\\w+WDT\\b.*\\w+IN\\b).*"//contains a name that should precede a category of
								    			;
								    	   Pattern r3 = Pattern.compile(type);
									       Matcher m3=	r3.matcher(text[u]);
									       if(m3.find())
									       {
									    	   String attribute2=m3.group().replaceAll("_\\S+", "");	
									    	   System.out.println("type:"+attribute2);
									    	   if((m3.group().contains("ID_NN"))|(m3.group().contains("id_NN")))
							    				  {
							    				  type=m3.group().replaceAll("_\\S+", "").substring(0,3).toUpperCase();
							    				  array1[4]=type;
							    				  }
							    				
							    				else if(m3.group().contains("int_NN"))
							    				  {
							    				  type=m3.group().replaceAll("_\\S+", "").substring(0,4).toUpperCase();
							    				  array1[4]=type;
							    				  }
							    				else if(m3.group().contains("string_NN"))
							    				  {
							    					type=m3.group().replaceAll("_\\S+", "").substring(0,7).toUpperCase();
							    					array1[4]=type;
							    					System.out.println("string type:"+array1[4]);
							    					
							    				  }
							    				else
							    				  {
							    					type=m3.group().replaceAll("_\\S+", "").toUpperCase();
							    					String[] a=type.split(" ");
							    					
							    					for(int o=0;o<a.length;o++)
							    					{
							    					System.out.println("type defined1:"+a[1]);
							    					}
							    					array1[4]=a[1];
							    					System.out.println("type defined:"+a[1]);
							    				  }
									    	   
							   	           } //string type
									       if(!(m3.group().contains("boolean_JJ")))
									       {
									    	   nestedObj.elementk=
								            		  "\n"+array1[2].concat("=").trim()+array1[4].trim()
								            		 +"\n"+array1[3].concat("=").trim()+array1[4].trim();
									    		       textArea_DSL.append(nestedObj.elementk);
									       }
									       
									       
									       else if(m3.group().contains("boolean_JJ"))
									       {
									    	   nestedObj.elementk=
									            		  "\n".concat("(")+array1[2].concat("?='")+array1[2].concat("')?")
									            		  +"\n".concat("(")+array1[3].concat("?='")+array1[3].concat("')?");	
									    	  
									    		   textArea_DSL.append(nestedObj.elementk);
									    	   
									       }
										  } // 
								       }
								       
							           }//multi-attibutes
							       
//#######################################################################################################################################################
							       //Pattern to check single and optional attributes
							       for(String patternx:nestedObj.patternx)
							       {
							    	   Pattern r = Pattern.compile(patternx);
								       Matcher m=	r.matcher(text[u]);
								       if(m.find())
								       {
								    	   String array1[]=new String[5];
								    	   System.out.println("Statement of optional or single attributes:"+text[u]);	
								    	   
								    	   if(text[u].contains("optional_JJ"))
								    	   {
								    		   array1[0]=patternx;	
									    	   System.out.println("Statement of matched rules:"+array1[0]);	
									    	
									    	   String[] concepta = text[u].split("\\s+");
									    	   if(!(concepta[1].contains("it_PRP")) | (concepta[2].contains("it_PRP")))
									    	   {  
									    	   //if(!(text[u].contains("it_PRP"))){
									    		   
									    	   String pattern_concept="(\\w+NN\\b.\\w+NN\\b.(?=\\w+VBZ\\b))|(\\w+NN\\b.(?=\\w+VBZ\\b))"
									    			   +"|(\\w+NN\\b.\\w+NN\\b.(?=\\w+MD\\b))|(\\w+NN\\b.(?=\\w+MD\\b))"
									    			   +"|(?<=\\w+CD\\b.*\\w+IN\\b).*?(?=\\w+VBZ\\b)"
									    			   ;
									    	   
									    	   Pattern ra = Pattern.compile(pattern_concept);
										       Matcher ma=	ra.matcher(text[u]);
										       if(ma.find())
										       {
										    	   if(ma.group().contains("concept_NN"))
										    	   {						    		
										    		   String conceptName="\\w+NN\\b";
											    	   Pattern concept=Pattern.compile(conceptName);
											    	   Matcher MatchConcept=concept.matcher(ma.group());
											    	   if(MatchConcept.find())
											    	   {
											    	   String Conceptname=MatchConcept.group().replaceAll("_\\S+", "");	
											    	   System.out.println("Statement of optional-attributes:"+Conceptname);
											    	   array1[1]=Conceptname.trim().concat(":'")+Conceptname.trim().concat("'").trim();	
											    	   }  
										    	   }
									    	   
										    	   if(!(ma.group().contains("concept_NN")))
										    	   {	
										    	   String Conceptname=ma.group().replaceAll("_\\S+", "").trim();
										    	   System.out.println("Statement of single concept has:"+Conceptname);
										    	   
										    	   if(ma.group().contains("the_DT"))
										    	   {
										    	   String c=ma.group().replaceAll("_\\S+", "").substring(4).trim();
										    	   System.out.println("Statement of single concept have:"+c);
										    	   String[] words = c.split("\\s+");
										    	   System.out.println("length of words have:"+words.length); 
										    	   
										    	   if(words.length==2)
										    	   {
										    	   System.out.println("Statement of single-attributes have DT:"+words[1]); 
										    	   array1[1]=words[0]+"_"+words[1].trim().concat(":'")+words[0]+"_"+words[1].trim().concat("'").trim();	
										    	   }
										    	 
										    	   if(words.length==1)
										    	   {
										    		   System.out.println("Statement of single-attributes ARE:"+words[0]);
											    	   array1[1]=words[0].trim().concat(":'")+words[0].trim().concat("'").trim();	   
										    	   }
										          }
										    	   
										    	   if(!(ma.group().contains("the_DT")))
											    	 {
											    		 System.out.println("nO DT");
											    		 String[] words = Conceptname.split("\\s+");
											    		 System.out.println("length of words have:"+words.length); 
											    		 if(words.length==2)
												    	   {
												    	   System.out.println("Statement of single-attributes have DT:"+words[0]+" "+words[1]); 
												    	   array1[1]=words[0]+"_"+words[1].trim().concat(":'")+words[0]+"_"+words[1].trim().concat("'").trim();	
												    	   }
												    	   if(words.length==1)
												    	   {
												    		   System.out.println("Statement of single-attributes ARE:"+words[0]);
													    	   array1[1]=words[0].trim().concat(":'")+words[0].trim().concat("'").trim();	   
												    	   }
											    	 }
										    	   
										    	  }
										       System.out.println("single attributes concept name:"+array1[1]);
								    		   if(!(textArea_DSL.getText().contains(array1[1])))
									    	     {
								    			   textArea_DSL.append(";"+"\n\n"+array1[1]);
									    	     }
									    	   
									    	   }
								    	   }
									    	   
								    	   //when data type is defined.
								    	   if((text[u].contains("int_NN"))|(text[u].contains("id_NN"))
								    	   |(text[u].contains("string_NN"))|(text[u].contains("boolean_JJ")))
								    	   {
								    	   String pattern_attribute="(?<=\\w+CD\\b.*\\w+VBZ).*?(?=\\w+IN\\b)"
								    			  +"|(?<=\\w+MD\\b.*\\w+VBN\\b).*?(?=\\w+IN\\b)"
								    			  +"|(?<=\\w+MD\\b.*\\w+IN\\b).*?(?=\\w+IN\\b)"
								    			  ;
								    	   Pattern r1 = Pattern.compile(pattern_attribute);
									       Matcher m1=	r1.matcher(text[u]);
									       if(m1.find())
									       {
									    	   String conceptName="\\w+NN\\b";
									    	   Pattern concept=Pattern.compile(conceptName);
									    	   Matcher MatchConcept1=concept.matcher(m1.group());
									    	   if(MatchConcept1.find())
									    	   {
									    	   String attribute1=MatchConcept1.group().replaceAll("_\\S+", "");	
									    	   System.out.println("Statement of multi-attributes:"+attribute1);
									    	   array1[2]=attribute1;
									       }
									       }
									       String pattern_optionalTag="\\w+JJ\\b";
									       
								    	   Pattern r2 = Pattern.compile(pattern_optionalTag);
									       Matcher m2=	r2.matcher(text[u]);
									       if(m2.find())
									       {
									    	   String optionalTag="?";
									    	   array1[3]=optionalTag;
									       }
									       
									       
									       String type
									    		   ="(?<=\\w+CD\\b.*\\w+VBZ\\b.*\\w+IN\\b).*"
											       +"|(?<=\\w+MD\\b.*\\w+VBN\b.*\\w+IN\\b).*"
											 	   +"|(?<=\\w+MD\\b.*\\w+IN\\b.*\\w+IN\\b).*";
											       
								    	   Pattern r3 = Pattern.compile(type);
									       Matcher m3=	r3.matcher(text[u]);
									       if(m3.find())
									       {
									    	   String attribute2=m3.group().replaceAll("_\\S+", "");	
									    	   System.out.println("type:"+attribute2);
									    	   if((m3.group().contains("ID_NN"))|(m3.group().contains("id_NN")))
							    				  {
							    				  type=m3.group().replaceAll("_\\S+", "").substring(0,3).toUpperCase();
							    				  //added 
							    				  array1[4]=type;
							    				  }
							    				
							    				else if(m3.group().contains("int_NN"))
							    				  {
							    				  type=m3.group().replaceAll("_\\S+", "").substring(0,4).toUpperCase();
							    				  array1[4]=type;
							    				  }
							    				else if(m3.group().contains("string_NN"))
							    				  {
							    					type=m3.group().replaceAll("_\\S+", "").substring(0,7).toUpperCase();
							    					array1[4]=type;
							    				  }
							   	           } //string type
									       if(!(m3.group().contains("boolean_JJ")))
									       {
								            String elementk="\n".concat("(")+array1[2].concat("=").trim()+array1[4].concat(")").trim()+array1[3];
								            
								            textArea_DSL.append(elementk);
									        
									       }
									       else if(m3.group().contains("boolean_JJ"))
									       {
									    	   String elementk="\n".concat("('")+array1[2].concat("?='")+array1[2].concat("')?");
									           textArea_DSL.append(elementk);  
									       }
								    	   }//when datatype is defined.
								    	   
								    	   
								    	   //when datatype is not defined..
								    	   
								    	   else
								    	   {
										    	   String pattern_attribute="(?<=\\w+CD\\b.*\\w+VBZ).*?"
										    			  +"|(?<=\\w+MD\\b.*\\w+VBN\\b).*"
										    			  +"|(?<=\\w+MD\\b.*\\w+IN\\b).*"
										    			  ;
										    	   Pattern r1 = Pattern.compile(pattern_attribute);
											       Matcher m1=	r1.matcher(text[u]);
											       if(m1.find())
											       {
											    	   String conceptName="\\w+NN\\b";
											    	   Pattern concept=Pattern.compile(conceptName);
											    	   Matcher MatchConcept1=concept.matcher(m1.group());
											    	   if(MatchConcept1.find())
											    	   {
											    	   String attribute1=MatchConcept1.group().replaceAll("_\\S+", "");	
											    	   System.out.println("Statement of optionals:"+attribute1);
											    	   array1[2]=attribute1;
											           }
											       }
											       String pattern_optionalTag="(?<=\\w+VB\\b).*?(?=\\w+NN\\b.\\w+VBN\\b)"
												    		+"|(?<=\\w+VB\\b).*?(?=\\w+NN\\b.\\w+IN\\b)"
												    		+"|(?<=\\w+CD\\b).*?(?=\\w+NN\\b.*\\w+VBZ\\b)";
											       
										    	   Pattern r2 = Pattern.compile(pattern_optionalTag);
											       Matcher m2=	r2.matcher(text[u]);
											       if(m2.find())
											       {
											    	   String optionalTag="?";
											    	   array1[3]=optionalTag;
											    	   String ff=array1[2].concat(")")+array1[3];
											    	   textArea_DSL.append("\n".concat("(")+ff);
											    	   
											       }
										    	  }
										    	   
								    	   
								    	   
									       }//optional 
//###############################################################################################################################################								    	   
								    	   if(!(text[u].contains("optional_JJ")))
								    	   {
								    		   array1[0]=patternx;	
									    	   System.out.println("Statement of matched rules:"+array1[0]);	
									    	   
									    	   String[] concepta = text[u].split("\\s+");
									    	   if(!(concepta[1].contains("it_PRP")) | (concepta[2].contains("it_PRP")))
									    	   {  									    		   
									    	   //if(!(text[u].contains("it_PRP"))){
									    	   
									    	   String pattern_concept="(\\w+NN\\b.\\w+NN\\b.(?=\\w+VBZ\\b))|(\\w+NN\\b.(?=\\w+VBZ))"
									    			   +"|(\\w+NN\\b.\\w+NN\\b.(?=\\w+MD\\b))|(\\w+NN\\b.(?=\\w+MD\\b))"
									    			   +"|(?<=\\w+CD\\b.*\\w+IN\\b).*?(?=\\w+VBZ\\b)"
									    			   ;
									    	   Pattern ra = Pattern.compile(pattern_concept);
										       Matcher ma=	ra.matcher(text[u]);
										       if(ma.find())
										       {
										    	   if(ma.group().contains("concept_NN"))
										    	   {						    		
										    		   String conceptName="\\w+NN\\b";
											    	   Pattern concept=Pattern.compile(conceptName);
											    	   Matcher MatchConcept=concept.matcher(ma.group());
											    	   if(MatchConcept.find())
											    	   {
											    	   String Conceptname=MatchConcept.group().replaceAll("_\\S+", "");	
											    	   System.out.println("Statement of single-attributes:"+Conceptname);
											    	   array1[1]=Conceptname.trim().concat(":'")+Conceptname.trim().concat("'").trim();	
											    	   }  
										    	   }
									    	   
										    	   if(!(ma.group().contains("concept_NN")))
										    	   {	
										    	   String Conceptname=ma.group().replaceAll("_\\S+", "").trim();
										    	   System.out.println("Statement of single concept has:"+Conceptname);
										    	   
										    	   if(ma.group().contains("the_DT"))
										    	   {
										    	   String c=ma.group().replaceAll("_\\S+", "").substring(4).trim();
										    	   System.out.println("Statement of single concept have:"+c);
										    	   String[] words = c.split("\\s+");
										    	   System.out.println("length of words have:"+words.length); 
										    	   
										    	   if(words.length==2)
										    	   {
										    	   System.out.println("Statement of single-attributes have DT:"+words[1]); 
										    	   array1[1]=words[0]+"_"+words[1].trim().concat(":'")+words[0]+"_"+words[1].trim().concat("'").trim();	
										    	   }
										    	 
										    	   if(words.length==1)
										    	   {
										    		   System.out.println("Statement of single-attributes ARE:"+words[0]);
											    	   array1[1]=words[0].trim().concat(":'")+words[0].trim().concat("'").trim();	   
										    	   }
										          }
											    	 if(!(ma.group().contains("the_DT")))
											    	 {
											    		 System.out.println("nO DT");
											    		 String[] words = Conceptname.split("\\s+");
											    		 System.out.println("length of words have:"+words.length); 
											    		 if(words.length==2)
												    	   {
												    	   System.out.println("Statement of single-attributes have DT:"+words[0]+" "+words[1]); 
												    	   array1[1]=words[0]+"_"+words[1].trim().concat(":'")+words[0]+"_"+words[1].trim().concat("'").trim();	
												    	   }
												    	   if(words.length==1)
												    	   {
												    		   System.out.println("Statement of single-attributes ARE:"+words[0]);
													    	   array1[1]=words[0].trim().concat(":'")+words[0].trim().concat("'").trim();	   
												    	   }
											    	 }
										    	  }
										       System.out.println("single attributes concept name:"+array1[1]);
								    		   if(!(textArea_DSL.getText().contains(array1[1])))
									    	     {
								    			   textArea_DSL.append(";"+"\n\n"+array1[1]);
									    	     }
									    	   
									    	   }
								    	   }
									    	   
								    		   if((text[u].contains("int_NN"))|(text[u].contains("id_NN"))|
								    		   (text[u].contains("id_NN"))|(text[u].contains("string_NN")))
								    		   {
									    	   String pattern_attribute=
									    			   "(?<=\\w+CD\\b.*\\w+VBZ\\b).*?(?=\\w+IN\\b)"//one -- attribute of -- is --
									    			  +"|(?<=\\w+MD\\b.*\\w+VBN\\b).*?(?=\\w+IN\\b)" //may have an attributre named
									    			  +"|(?<=\\w+MD\\b.*\\w+IN\\b).*?(?=\\w+IN\\b)"//may have an attribute like -- o--
									    			  +"|(?<=\\w+VBN\\b.*\\w+VB\\b).*?(?=\\w+IN\\b)"//used to define a==
									    			  +"|(?<=\\w+VBN\\b.*\\w+VBG\\b).*?(?=\\w+IN\\b)"//used for defininign
									    			  ;
									    	   
									    	   Pattern r1 = Pattern.compile(pattern_attribute);
										       Matcher m1=	r1.matcher(text[u]);
										       if(m1.find())
										       {
										    	   String conceptName="\\w+NN\\b";
										    	   Pattern concept=Pattern.compile(conceptName);
										    	   Matcher MatchConcept1=concept.matcher(m1.group());
										    	   if(MatchConcept1.find())
										    	   {
										    	   String attribute1=MatchConcept1.group().replaceAll("_\\S+", "");	
										    	   System.out.println("SINGLE Attirbute has:"+attribute1);
										    	   array1[2]=attribute1;
										           }
										       }
										       
										       String type=
										    	  "(?<=\\w+MD\\b.*\\w+VBN\\b.*\\w+IN\\b).*"
												  +"|(?<=\\w+MD\\b.*\\w+IN\\b.*\\w+IN\\b).*"
												  +"|(?<=\\w+VBN\\b.*\\w+VB\\b.*\\w+IN\\b).*"
												  +"|(?<=\\w+VBN\\b.*\\w+VBG\\b.*\\w+IN\\b).*"
												  +"|(?<=\\w+CD\\b.*\\w+VBZ\\b.*\\w+IN\\b).*";
										       
									    	   Pattern r3 = Pattern.compile(type);
										       Matcher m3=	r3.matcher(text[u]);
										       if(m3.find())
										       {
										    	   String attribute2=m3.group().replaceAll("_\\S+", "");	
										    	   System.out.println("type:"+attribute2);
										    	   if((m3.group().contains("ID_NN"))|(m3.group().contains("id_NN")))
								    				  {
								    				  type=m3.group().replaceAll("_\\S+", "").substring(0,3).toUpperCase();
								    				  //added 
								    				  array1[3]=type;
								    				  }
								    				
								    				else if(m3.group().contains("int_NN"))
								    				  {
								    				  type=m3.group().replaceAll("_\\S+", "").substring(0,4).toUpperCase();
								    				  array1[3]=type;
								    				  }
										    	   else if(m3.group().contains("string_NN"))
								    				  {
								    					type=m3.group().replaceAll("_\\S+", "").substring(0,7).toUpperCase();
								    					array1[3]=type;
								    				  }
								   	           } //string type
										       
										       if(!(m3.group().contains("boolean_JJ")))
										       {
									            String elementk="\n"+array1[2].concat("=").trim()+array1[3].trim();
									            textArea_DSL.append(elementk);
										        }
										       
									            else if (m3.group().contains("boolean_JJ"))
											       {
											    	   String elementk="\n".concat("('")+array1[2].concat("?='")+array1[2].concat("')?");	
											           textArea_DSL.append(elementk);  
											       }
										       else 
										       {
										    	   String elementk="\n"+array1[2];  	
										    	   textArea_DSL.append(elementk);
											        
										       }
								    		   }//when datatype is defined
								    		   
								    		   
								    		   //when datatype is not defined.
								    		   else 
								    		   {
								    			   String pattern_attribute=
										    			   "(?<=\\w+CD\\b.*\\w+VBZ\\b).*"
										    			  +"|(?<=\\w+MD\\b.*\\w+VBN\\b).*"
										    			  +"|(?<=\\w+MD\\b.*\\w+IN\\b).*"
										    			  +"|(?<=\\w+VBN\\b.*\\w+VB\\b).*"
										    			  +"|(?<=\\w+VBN\\b.*\\w+VBG\\b).*"
										    			  ;
										    	   Pattern r1 = Pattern.compile(pattern_attribute);
											       Matcher m1=	r1.matcher(text[u]);
											       if(m1.find())
											       {
											    	   String conceptName="\\w+NN\\b";
											    	   Pattern concept=Pattern.compile(conceptName);
											    	   Matcher MatchConcept1=concept.matcher(m1.group());
											    	   if(MatchConcept1.find())
											    	   {
											    	   String attribute1=MatchConcept1.group().replaceAll("_\\S+", "");	
											    	   System.out.println("SINGLE Attirbute has:"+attribute1);
											    	   array1[2]=attribute1.concat("=null");
											    	   textArea_DSL.append("\n"+array1[2]);
											           
											    	   }
											       }
								    		   }
								    		   
								    	   }//single
//###############################################################################################################################################								    	   
							          }
							           }//optional & single-attibutes
							       }
							
							}
		        	 
		        	 }//
		          String text=textArea_DSL.getText();
		          System.out.println("Text is:"+text);
		          
		          String[] LIST=new String[20];
		          LIST[0]="STRING";
		          LIST[1]="INT";
		          LIST[2]="ID";
		          LIST[3]="?";
		          LIST[4]="*";
		          LIST[5]=")";
		          LIST[6]="null";
		          
		          if(textArea_DSL.getText().contains(LIST[0]))
		          {
		          int index=textArea_DSL.getText().lastIndexOf(LIST[0]);
		          System.out.println("Last index is:"+index);
		          String ch=textArea_DSL.getText().substring(index);
		          System.out.println("Last text is:"+ch);
		          int indexs=index+ch.length();
		          textArea_DSL.insert(";", indexs);
		          }
		          
		          else if(textArea_DSL.getText().contains(LIST[1]))
		          {
		          int index=textArea_DSL.getText().lastIndexOf(LIST[1]);
		          System.out.println("Last index is:"+index);
		          String ch=textArea_DSL.getText().substring(index);
		          System.out.println("Last text is:"+ch);
		          int indexs=index+ch.length();
		          textArea_DSL.insert(";", indexs);
		          }
		          
		          else if(textArea_DSL.getText().contains(LIST[2]))
		          {
		          int index=textArea_DSL.getText().lastIndexOf(LIST[2]);
		          System.out.println("Last index is:"+index);
		          String ch=textArea_DSL.getText().substring(index);
		          System.out.println("Last text is:"+ch);
		          int indexs=index+ch.length();
		          textArea_DSL.insert(";", indexs);
		          }
		          
		          else if(textArea_DSL.getText().contains(LIST[3]))
		          {
		          int index=textArea_DSL.getText().lastIndexOf(LIST[3]);
		          System.out.println("Last index is:"+index);
		          String ch=textArea_DSL.getText().substring(index);
		          System.out.println("Last text is:"+ch);
		          int indexs=index+ch.length();
		          textArea_DSL.insert(";", indexs);
		          }
		          
		          else if(textArea_DSL.getText().contains(LIST[4]))
		          {
		          int index=textArea_DSL.getText().lastIndexOf(LIST[4]);
		          System.out.println("Last index is:"+index);
		          String ch=textArea_DSL.getText().substring(index);
		          System.out.println("Last text is:"+ch);
		          int indexs=index+ch.length();
		          textArea_DSL.insert(";", indexs);
		          }
		          
		          else if(textArea_DSL.getText().contains(LIST[5]))
		          {
		          int index=textArea_DSL.getText().lastIndexOf(LIST[5]);
		          System.out.println("Last index is:"+index);
		          String ch=textArea_DSL.getText().substring(index);
		          System.out.println("Last text is:"+ch);
		          int indexs=index+ch.length();
		          textArea_DSL.insert(";", indexs);
		          }
		          
		          else if(textArea_DSL.getText().contains(LIST[6]))
		          {
		          int index=textArea_DSL.getText().lastIndexOf(LIST[6]);
		          System.out.println("Last index is:"+index);
		          String ch=textArea_DSL.getText().substring(index);
		          System.out.println("Last text is:"+ch);
		          int indexs=index+ch.length();
		          textArea_DSL.insert(";", indexs);
		          }
		       }
//####################################################################################################################################################################################		    	   
				
		       
		});
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Display the window.  
        frame.pack();
        frame.setSize(600, 600);          
        frame.setVisible(true);  
        
    }}							