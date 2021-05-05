package edu.upc.dsa;
import edu.upc.dsa.Classes.*;

import java.util.List;

public interface GameManager {
    public void singin(User user);
    public void login(String userId, String pass);
    public void logout(String userId);
    public void deleteAccount(String userId, String pass);
    public User getUser(String userId);
    public void updateUser(User user);

    public void addEnemy(Enemy enemy);
    public void killEnemy(String enemyId);

    public Game getGames(String userId);
    public void newGame(Game game);
    public void stopGame(String gameId);

    public void buy(Product product, int cant);

    public void clear();
    public void dirty();
    public boolean isDirty();
}
