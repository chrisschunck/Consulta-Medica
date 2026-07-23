package br.com.agendamento.domain.exceptions;

@Component
@Schema(description="classe ResourceNotFoundException extendida com RuntimeException")
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}
