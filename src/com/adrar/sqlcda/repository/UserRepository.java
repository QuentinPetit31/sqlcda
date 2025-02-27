package com.adrar.sqlcda.repository;

import com.adrar.sqlcda.db.Bdd;
import com.adrar.sqlcda.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class UserRepository {
    /*
     * Attributs
     * */

    private static final Connection connection = Bdd.getConnection();

    /*
     * Méthodes (CRUD)
     * */
    //Méthode pour ajouter
    public static User save(User addUser) {
        //Créer un objet user
        User newUser = null;
        try {
            //Requête
            String sql = "INSERT INTO users(firstname, lastname, email, password) VALUE(?,?,?,?)";
            //Préparer la requête
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //Bind les paramètres
            preparedStatement.setString(1, addUser.getFirstname());
            preparedStatement.setString(2, addUser.getLastname());
            preparedStatement.setString(3, addUser.getEmail());
            preparedStatement.setString(4, addUser.getPassword());

            //Exécuter la requête
            int nbrRows = preparedStatement.executeUpdate();

            //vérifier si la requête est bien passé
            if(nbrRows > 0){
                newUser = new User(
                        addUser.getFirstname(),
                        addUser.getLastname(),
                        addUser.getEmail(),
                        addUser.getPassword()
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return newUser;
    }

    public static boolean isExist(String email) {
        boolean getUser = false;
        try {
            String sql = "SELECT id FROM users WHERE email = ?";
            //préparer la requête
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //Bind le paramètre
            preparedStatement.setString(1, email);
            //récupérer le resultat de la requête
            ResultSet resultSet = preparedStatement.executeQuery();

            //Vérification du résultat
            while(resultSet.next()){
                getUser = true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return getUser;
    }

    public static User findByEmail(String email) {
        User findUser = null;
        try {
            String sql = "SELECT id, firstname, lastname, email FROM users WHERE email = ?";
            //Préparer la requête
            PreparedStatement prepare = connection.prepareStatement(sql);
            //Bind un paramètre
            prepare.setString(1, email);
            //Exécuter la requête
            ResultSet resultSet = prepare.executeQuery();
            if(resultSet.next()){
                findUser = new User();
                findUser.setId(resultSet.getInt("id"));
                findUser.setFirstname(resultSet.getString("firstname"));
                findUser.setLastname(resultSet.getString("lastname"));
                findUser.setEmail(resultSet.getString("email"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return findUser;
    }


    public static List<User>  findAll() {
        List<User> findUsers =  new ArrayList<>();;
        try {
            String sql = "SELECT id, firstname, lastname, email FROM users";

            //Préparer la requête
            PreparedStatement prepare = connection.prepareStatement(sql);

            //Exécuter la requête
            ResultSet resultSet = prepare.executeQuery();
            while (resultSet.next()){
                User find = new User();
                find.setId(resultSet.getInt("id"));
                find.setFirstname(resultSet.getString("firstname"));
                find.setLastname(resultSet.getString("lastname"));
                find.setEmail(resultSet.getString("email"));
                findUsers.add(find);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return findUsers;
    }

}