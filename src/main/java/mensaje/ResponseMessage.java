package mensaje;

public record ResponseMessage<T>(

    int code,
    String message,
    T data
){
        // Constructor
        public ResponseMessage( int code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

        // Métodos getter
        public int getCode() {
        return code;
    }

        public String getMessage () {
        return message;
    }

        public T getData () {
        return data;
    }


}




