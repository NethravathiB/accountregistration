
package gui;

public class User {
    private String name;
private String username;
    private String password;
    private String email;
    public User(String name, String username, String password,String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email=email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    
    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
    

    
    
    



