package Ratiing.Exception;

public class ResourceNotFoundException extends RuntimeException{
   public ResourceNotFoundException(String message){
        super(message);
    }
    public ResourceNotFoundException(){
        super("Resource Not found Exception");
    }
}
