package pl.mzuchnik.communicatorserver.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ActiveUsers {

    private List<String> users;

    public ActiveUsers() {
        this.users = new ArrayList<>();
    }

    public void addUser(String username){
        users.add(username);
    }

    public void removeUser(String username){
        users.remove(username);
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public int size(){
        return users.size();
    }
}
