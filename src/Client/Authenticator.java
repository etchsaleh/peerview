package Client;

class Authenticator {

    private static Authenticator instance = null;
    private ClientSocket socket;

    private Authenticator (ClientSocket socket) {
        this.socket = socket;
    }
    
    public static Authenticator getInstance (ClientSocket socket) {
        if (instance == null) {
            instance = new Authenticator(socket);
        }
        return instance;
    }

    public boolean isValid(String inputPassword) {
        sendPassword(inputPassword);
        return "valid".equals(getResult());
    }
    public void sendPassword(String message) {
        socket.sendMessage(message);
    }
    public String getResult () {
        return socket.getMessage();
    }
}




