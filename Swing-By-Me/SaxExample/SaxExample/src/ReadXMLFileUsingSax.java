
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ReadXMLFileUsingSax {

  
    public static void main(String[] args) {
try{
    SAXParserFactory factory=SAXParserFactory.newInstance();
    SAXParser saxParser=factory.newSAXParser();
    DefaultHandler handler=new DefaultHandler(){
    boolean bfname=false;
    boolean bsalary=false;
     
    @Override
    public void startElement(String uri,String localName,String qName,Attributes Attributes)throws SAXException{
    System.out.println("Strate element"+qName);
    if(qName.equalsIgnoreCase("FULLNAME")){
        bfname=true;
    }
     if(qName.equalsIgnoreCase("FULLNAME")){
        bsalary=true;
    }
          
}
    @Override
    public void endElement(String uri, String localName,String qName){
        System.out.println("End element"+qName);   
}
    
    
    @Override
    public void characters(char ch[],int start,int length){
        if(bfname){
            System.out.println("Full name: "+new String(ch,start,length));
            bfname=false;
        }
        if(bsalary){
            System.out.println("Full name: "+new String(ch,start,length));
            bsalary=false;
        }
    }
    };  
   saxParser.parse("D:\\Swing\\Swing-By-Me\\SaxExample\\SaxExample\\src\\staff.xml",handler);
}catch( Exception e){
    e.printStackTrace();
}


    }
    
}
