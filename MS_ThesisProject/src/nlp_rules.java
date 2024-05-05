import edu.stanford.nlp.io.EncodingPrintWriter.out;

import edu.stanford.nlp.ling.CoreAnnotations;
import java.io.*;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.Timing;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
public class nlp_rules
{
   protected static String[] convertedTexts; 
      
        // Set up the MaxentTagger
        static MaxentTagger tagger =  new MaxentTagger("stanford/models/english-left3words-distsim.tagger.");
        static String text;
        
        public nlp_rules() throws IOException
        {
		PdfReader pdfReader = new PdfReader("C:\\Users\\AminaSoftware\\Documents\\MS-Thesis\\TimingModel.pdf");	
		//Get the number of pages in pdf.
		int pages = pdfReader.getNumberOfPages(); 
		//Iterate the pdf through pages.
		for(int i=1; i<=pages; i++) 
		{ 
		  //Extract the page content using PdfTextExtractor.
		  text =	PdfTextExtractor.getTextFromPage(pdfReader, i);
	 
		  //Print the page content on console.
		  System.out.println("Content on Page " + i + ": " + text);
	      }
        }
        static class nestedclass
        {
        	

         	  static String[] patterna= {

                         //for multiple attributes
        	   "((\\w+NN\\b.*|\\w+PRP\\b.)\\w+MD\\b.\\w+VB\\b.(?:(\\w+DT\\b.)?)\\w+NN\\b.\\w+VBN\\b.\\w+IN\\b.(?:(\\w+DT\\b.)?)\\w+NN\\b)",
        	  
        	   "((\\w+NN\\b.*|\\w+PRP\\b.)\\w+MD\\b.\\w+VB\\b.(?:(\\w+IN\\b.)?)(?:(\\w+DT\\b.)?)\\w+NN\\b.\\w+CC\\b.\\w+NN\\b)",
        	  
        	  "((\\w+NN\\b.\\w+NN\\b.|\\w+NN\\b.|\\w+PRP\\b.)\\w+VBZ\\b.(?:(\\w+DT\\b.)?)\\w+NN\\b.\\w+WDT\\b.\\w+MD\\b.\\w+VB\\b.(?:(\\w+DT\\b.)?)\\w+NN\\b)",
        	  
        	  "((\\w+NN\\b.*|\\w+PRP\\b.)\\w+VBZ\\b.\\w+VBN\\b.\\w+IN\\b.(?:(\\w+DT\\b.)?)\\w+NN\\b.\\w+CC\\b.\\w+NN\\b.\\w+NN\\b)",
        	 
        	  "((\\w+NN\\b.*|\\w+PRP\\b.)\\w+VBZ\\b.(?:(\\w+JJ\\b.)?)"
        	  + "\\w+NN\\b.(\\w+VBG\\b.|\\w+IN\\b.)\\w+NN\\b.\\w+CC\\b.\\w+NN\\b)",
        	  
  	      	  "(\\w+NN\\b.\\w+IN\\b.(?:(\\w+DT\\b.)?)\\w+NN\\b.*\\w+VBP\\b.\\w+NN\\b.\\w+CC\\b.\\w+NN\\b)"
           	 };
                  	 
         	  static //for single and optional attributes
         	 String[] patternx= 
 		  {
 				  
 				  //must have an optional attribute/maust have an 
 		
 		      "((\\w+NN\\b.*|\\w+PRP\\b.)\\w+VBZ\\b.\\w+VBN\\b."
 		      + "(\\w+TO\\b.\\w+VB\\b.|\\w+IN\\b.\\w+VBG\\b.)(?:(\\w+DT\\b.)?)\\w+NN\\b.\\w+NN\\b)",//used to define.for defining
 		      
 		      "(\\w+CD\\b.(?:(\\w+JJ\\b.)?)\\w+NN\\b.\\w+IN\\b.(?:(\\w+DT\\b.)?)\\w+NN\\b.*\\w+VBZ\\b.(?:(\\w+DT\\b.)?)\\w+NN\\b)",
 		 	  "((\\w+NN\\b.|\\w+NN\\b.\\w+NN\\b.|\\w+PRP\\b.)\\w+MD\\b.\\w+VB\\b.(?:(\\w+DT\\b.)?)(?:(\\w+JJ\\b.)?)"
 		 	  + "\\w+NN\\b.(\\w+VBN\\b.|\\w+IN\\b.(?:(\\w+DT\\b.)?))\\w+NN\\b)"
 		      
          };  
 	 
         	  
         	  //containing patterns childs
         	  static String[] pattern_VBZ = 
     		      { 
     		    		  "((\\w+NN\\b.*|\\w+PRP\\b.)(\\w+VBZ\\b.\\w+JJ\\b.\\w+NN\\b.\\w+NN\\b))",
     		    		   "((\\w+NN\\b.*|\\w+PRP\\b.)(\\w+VBZ\\b.\\w+VBN\\b.\\w+IN\\b.\\w+JJ\\b.\\w+NN\\b.\\w+NN\\b))",
     		    		   "((\\w+NN\\b.*|\\w+PRP\\b.)(\\w+MD\\b.(?:(\\w+RB\\b.)?)\\w+VB\\b.\\w+JJ\\b.\\w+NN\\b.\\w+NN\\b))"
     	           } ; 
         	 

          	  static String[] pattern1f= 
   	    	   {
   	    			  "(\\w+NN\\b.\\w+VBZ\\b.\\w+DT\\b.\\w+NN\\b.\\w+IN\\b.(\\w+JJ\\b.\\w+NN\\b|\\w+NN\\b.\\w+NN\\b))",
    		    		"(\\w+NN\\b.\\w+IN\\b.\\w+NN\\b.\\w+MD\\b.\\w+VB\\b.(?:(\\w+DT\\b.)?)(\\w+JJ\\b.\\w+NN\\b|\\w+NN\\b.\\w+NN\\b))"
   		      };  	
     	 
        
          	  static String descriptionContainig = null;
          	 static String CONCEPT = null;
          	 static String CONCEPT2 = null;
        	  static String main1 = null;
          	  static String maina=null;
          	  static String mainroot=null;
        	  static String conceptElement=null;
        	  static String conceptElementRel=null;
        	  
        	  static String elementk=null;
        	  static String main=null;//for pattern
        	  static String relationmain=null;//for pattern
        	  static String concept_of_multiAttribute=null;
        	  static String singleAttributeConcept=null;
        	  static String optionalAttributeConcept=null;
        	  static String attribute_multiple=null;//for pattern   

        	  static String descriptionContaining1=null;//for pattern   
        	  static String descriptionContaining1a=null;//for pattern   
        	  
        	  static String descriptionContainingd=null;//for pattern   
        	  static String descriptionContainingd1=null;//for pattern   
        	  static String resultab=null;//for pattern   
        	  static String relationshipConcept=null;
        	  
        	  static String singleAttribute=null;//for pattern
        	  static String optionalAttribute=null;//for pattern
        	  
        	  static String parserRule_Details=null;//for pattera
        	  static String parserRule_Details1=null;//for patterna
        	  static String attribute_Added=null;//for patternx
        	  static String attribute_Added1=null;//for patternx
        }
}