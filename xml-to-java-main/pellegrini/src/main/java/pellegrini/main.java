package pellegrini;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



/**
 * Hello world!
 *
 */
public class main 
{
    public static void main( String[] args ) throws JsonParseException, JsonMappingException, IOException{
       File file = new File("pellegrini/src/main/java/pellegrini/classe.xml");//si indica il percorso del file
         XmlMapper xmlMapper = new XmlMapper();
         root value = xmlMapper.readValue(file, root.class);//file per non scrivere tutti le linee di codice,root può variare in base al tag totale
         
         System.out.println("la classe " + value.getClasse() + " " + value.getSpecializzazione() +" si trova nell'aula " +
         value.getAula().getNome() + " ed è composta dai seguenti studenti:");//si fa la stampa
         
         for(int i=0;i<value.getStudenti().size();i++)
         {
         System.out.println("-" + value.getStudenti().get(i).getCognome());
         }

//serilizzare 

         String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);//root perchè contiene  tutto,per serializzare e per fare in modo che sia stampato per bene
         System.out.println(xml);

//json sereliazzare 
ObjectMapper mapper = new ObjectMapper();
String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString( value );
System.out.println(json);

//json deserealizzare

root user = mapper.readValue(json, root.class);//mapper readvalue per legge
System.out.println("la classe " + user.getClasse() + " " + user.getSpecializzazione() +" si trova nell'aula " +
         user.getAula().getNome() + " ed è composta dai seguenti studenti:");//si fa la stampa
         for(int i=0;i<user.getStudenti().size();i++)
         {
         System.out.println("-" + user.getStudenti().get(i).getCognome());
         }
}
}

