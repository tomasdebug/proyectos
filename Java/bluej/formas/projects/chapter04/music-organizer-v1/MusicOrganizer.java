import java.util.ArrayList;


/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
   
  
    
    
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
       
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
      
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    public void CheckIndex(int index)
    {
        if(index <0 ||  index>=files.size())
        {
           
            System.out.println("Está mi rey.");
        
        }else{
            
            System.out.println("debe de ser de 0" + (files.size() -1));
        
        }
        
    }
     public boolean ValidIndex(int index)
    {
        if(index <0 ||  index>=files.size())
        {
           
            return false;
        
        }else{
            
           return true;
        
        }
        
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        
        if(ValidIndex(index)) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        
        if(ValidIndex(index)) {
            files.remove(index);
        }else 
        {
            System.out.println("Dame un indice correcto gordo de mierda");
        }
    }
    public void ListAllFiles()
    {
        int index=0;
       while( index<files.size())
       {
        System.out.println(" "+ files.get(index));
        index++;
        }
    }
}
