//package br.com.inthurn.VilaDevInHouse.dao;
//
//import br.com.inthurn.VilaDevInHouse.model.transport.villager.VillagerDTO;
//import br.com.inthurn.VilaDevInHouse.service.infrastructure.DatabaseConnector;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Repository;
//
//import java.math.BigDecimal;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class VillagerDAO{
//
//    private final DatabaseConnector dbConnector;
//    private final AppUserDAO appUserDAO;
//    private final MonthDAO monthDAO;
//
//    public VillagerDAO(DatabaseConnector dbConnector, AppUserDAO appUserDAO, MonthDAO monthDAO) {
//        this.dbConnector = dbConnector;
//        this.appUserDAO = appUserDAO;
//        this.monthDAO = monthDAO;
//    }
//
//    public List<VillagerEntity> listAll(){
//        try {
//            List<VillagerEntity> villagerEntityList = new ArrayList<>();
//            final String SQL = "SELECT id, name FROM villager";
//            Connection connection = dbConnector.getConnection();
//            PreparedStatement preparedStatement = dbConnector.getConnection().prepareStatement(SQL);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()){
//                villagerEntityList.add(
//                        new VillagerEntity(
//                                resultSet.getInt("id"),
//                                resultSet.getString("name")
//                        )
//                );
//            }
//
//            return villagerEntityList;
//        }catch (SQLException e){
//            e.printStackTrace();
//            return null;
//        }
//
//    }
//
//
//    public VillagerEntity listDetailsById(Integer id) throws SQLException {
//        final String SQL = "SELECT name, surname, birthday, income, cpf from villager LEFT JOIN app_user ON (villager.appuser_id = app_user.id) WHERE villager.id = ?";
//        PreparedStatement statement = dbConnector
//                .getConnection().
//                prepareStatement(SQL);
//        statement.setInt(1, id);
//        ResultSet resultSet = statement.executeQuery();
//
//        if (resultSet.next()) {
//            return new VillagerEntity(
//                    resultSet.getString("name"),
//                    resultSet.getString("surname"),
//                    resultSet.getDate("birthday"),
//                    resultSet.getBigDecimal("income"),
//                    resultSet.getString("cpf")
//            );
//        } else {
//            return null;
//        }
//    }
//
//    public List<VillagerEntity> listByName(String name) {
//        List<VillagerEntity> villagerEntityList = new ArrayList<>();
//       try{
//           final String SQL = "SELECT id, name from villager WHERE name LIKE ?";
//           PreparedStatement statement = dbConnector
//                   .getConnection()
//                   .prepareStatement(SQL);
//           statement.setString(1, name + "%");
//
//           ResultSet resultSet = statement
//                   .executeQuery();
//
//           while (resultSet.next()){
//                villagerEntityList
//                        .add(new VillagerEntity(
//                                resultSet.getInt("id"),
//                                resultSet.getString("name")));
//           }
//           return villagerEntityList;
//
//       }catch (SQLException e){
//           e.printStackTrace();
//           return villagerEntityList;
//       }
//    }
//
//
//    public List<VillagerEntity> listPerMonth(Object object) {
//        List<VillagerEntity> villagerEntityList = new ArrayList<>();
//        Integer month;
//        if(object instanceof String){
//            month = monthDAO.getMonth(object);
//        }else {
//            month = (Integer) object;
//        }
//        try {
//            final String SQL="SELECT id, name FROM villager WHERE EXTRACT(MONTH FROM birthday) = ?";
//            PreparedStatement statement = dbConnector
//                    .getConnection()
//                    .prepareStatement(SQL);
//            statement.setInt(1, month);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                villagerEntityList.add(
//                        new VillagerEntity(
//                                resultSet.getInt("id"),
//                                resultSet.getString("name")
//                        )
//                );
//            }
//                return villagerEntityList;
//        }catch (SQLException e){
//            e.printStackTrace();
//            return villagerEntityList;
//        }
//    }
//
//    public ResponseEntity<String> addNew(VillagerDTO villagerDTO) {
//        try {
//            final String SQL = "INSERT INTO villager (name, surname, birthday, income, cpf, appuser_id) values (?,?,?,?,?,?)";
//            AppUserEntity appUser = new AppUserEntity(villagerDTO.getEmail(), villagerDTO.getPassword());
//            appUserDAO.addNew(appUser);
//            PreparedStatement statement = dbConnector.getConnection().prepareStatement(SQL);
//            statement.setString(1, villagerDTO.getName());
//            statement.setString(2, villagerDTO.getSurname());
//            statement.setDate(3, villagerDTO.getBirthday());
//            statement.setBigDecimal(4, villagerDTO.getIncome());
//            statement.setString(5, villagerDTO.getCpf());
//            statement.setInt(6, appUserDAO.catchByUsername(villagerDTO.getEmail()));
//            statement.executeQuery();
//
//            return new ResponseEntity("OK", HttpStatus.OK);
//        }catch (SQLException e){
//            return new ResponseEntity<String>("Deu ruim", HttpStatus.I_AM_A_TEAPOT);
//        }
//
//    }
//
//
//    public ResponseEntity<String> deletePerId(Integer id) {
//        try {
//            final String SQL = "DELETE FROM villager where id = ?";
//            PreparedStatement statement = dbConnector
//                    .getConnection().
//                    prepareStatement(SQL);
//            statement.setInt(1, id);
//            statement.executeQuery();
//            return new ResponseEntity<String>("Morador deletado", HttpStatus.OK);
//
//        } catch (SQLException e) {
//
//            return new ResponseEntity<String>("Erro ao Deletar usuário", HttpStatus.BAD_REQUEST);
//        }
//    }
//
//
//    public List<VillagerEntity> listByAge(Integer age) {
//        List<VillagerEntity> villagerEntityList = new ArrayList<>();
//        try {
//            final String SQL = "SELECT id, name, birthday FROM villager WHERE (EXTRACT( YEAR FROM age(villager.birthday)) >= ?)";
//            PreparedStatement statement = dbConnector
//                    .getConnection()
//                    .prepareStatement(SQL);
//            statement.setInt(1, age);
//
//            ResultSet resultSet = statement
//                    .executeQuery();
//
//            while (resultSet.next()) {
//                villagerEntityList
//                        .add(new VillagerEntity(
//                                resultSet.getInt("id"),
//                                resultSet.getString("name")));
//            }
//            return villagerEntityList;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return villagerEntityList;
//        }
//    }
//
//    public BigDecimal villagerCost() throws SQLException{
//        final String SQL = "SELECT SUM(income) from villager";
//        Statement statement = dbConnector.getConnection().createStatement();
//        statement.executeQuery(SQL);
//        ResultSet resultSet = statement.getResultSet();
//        if (resultSet.next()){
//            return resultSet.getBigDecimal("sum");
//        }
//        return null;
//    }
//
//    public VillagerEntity villagerWithHighestIncome(){
//        try {
//            final String SQL = "SELECT id, TRIM(CONCAT(name, ' ', surname)) name, income FROM villager ORDER BY income DESC LIMIT 1";
//            Statement statement = dbConnector.getConnection().createStatement();
//            ResultSet resultSet = statement.executeQuery(SQL);
//            if(resultSet.next()){
//                return new VillagerEntity(
//                        resultSet.getInt("id"),
//                        resultSet.getString("name"),
//                        resultSet.getBigDecimal("income")
//                );
//            }
//            return null;
//        }catch (SQLException e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//}