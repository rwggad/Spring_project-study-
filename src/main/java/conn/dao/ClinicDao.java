package conn.dao;

import conn.Model.ClinicModel.Base.PetType;
import conn.Model.ClinicModel.Owner;
import conn.Model.ClinicModel.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.jws.Oneway;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClinicDao {

    private JdbcTemplate template;

    @Autowired
    public ClinicDao(DataSource dataSource) {
        this.template = new JdbcTemplate();
        template.setDataSource(dataSource);
    }

    /**
     * pet_id 에 맞는 Pet Type 가져오기
     */
    public PetType select_petType(final int id) {
        List<PetType> pet = null;
        String sql = "SELECT * FROM types WHERE id = ?";
        pet = template.query(sql,
                new PreparedStatementSetter() {
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        preparedStatement.setInt(1, id);
                    }
                }, new RowMapper<PetType>() {
                    public PetType mapRow(ResultSet resultSet, int i) throws SQLException {
                        PetType type = new PetType();
                        type.setId(resultSet.getInt(1));
                        type.setName(resultSet.getString(2));
                        return type;
                    }
                });
        if (pet.isEmpty()) { // pet 정보가 없다면..
            return null;
        } else { // pet 정보가 있다면 전달.
            return pet.get(0);
        }
    }

    /**
     * owner_id 맞는 Pet 정보 가져오기
     */
    public List<Pet> select_pets(final Owner owner) {
        List<Pet> petList = null;
        String sql = "SELECT * FROM pets WHERE owner_id = ?";
        petList = template.query(sql,
                new PreparedStatementSetter() {
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        preparedStatement.setInt(1, owner.getId());
                    }
                },
                new RowMapper<Pet>() {
                    public Pet mapRow(ResultSet resultSet, int i) throws SQLException {
                        Pet pet = new Pet();
                        pet.setId(resultSet.getInt(1));
                        pet.setName(resultSet.getString(2));
                        pet.setBirthDay(resultSet.getString(3));
                        pet.setPetType(select_petType(resultSet.getInt(1)));
                        pet.setOwner(owner);
                        return pet;
                    }
                });
        if (petList.isEmpty()) { // 현재 방문자가 소유한 동물이 없다면...
            return null;
        } else { // 현재 방문자가 소유한 동물이 있을 경우...
            return petList;
        }
    }

    /**
     * 전체 Owner 정보 들고오기
     */
    public List<Owner> select_owners() {
        //id, 첫번째 이름, 두번째 이름, 주소, 도시, 핸드폰 번호)
        String sql = "SELECT * FROM owners";
        List<Owner> ownerList = template.query(sql,
                new RowMapper<Owner>() {
                    public Owner mapRow(ResultSet resultSet, int i) throws SQLException {
                        Owner owner = new Owner();
                        owner.setId(resultSet.getInt(1));
                        owner.setFirstName(resultSet.getString(2));
                        owner.setLastName(resultSet.getString(3));
                        owner.setAddress(resultSet.getString(4));
                        owner.setCity(resultSet.getString(5));
                        owner.setPhoneNUmber(resultSet.getString(6));
                        List<Pet> OwnerPetLst = select_pets(owner);
                        owner.setPets(OwnerPetLst);
                        return owner;
                    }
                });
        return ownerList;
    }

    /**
     * 특정 Owner 정보 들고오기
     */
    public Owner select_owner(final int id) {
        List<Owner> owners = null;
        String sql = "SELECT * FROM owners WHERE id = ?";
        owners = template.query(sql,
                new PreparedStatementSetter() {
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        preparedStatement.setInt(1, id);
                    }
                },
                new RowMapper<Owner>() {
                    public Owner mapRow(ResultSet resultSet, int i) throws SQLException {
                        Owner owner = new Owner();
                        owner.setId(resultSet.getInt(1));
                        owner.setFirstName(resultSet.getString(2));
                        owner.setLastName(resultSet.getString(3));
                        owner.setAddress(resultSet.getString(4));
                        owner.setCity(resultSet.getString(5));
                        owner.setPhoneNUmber(resultSet.getString(6));
                        List<Pet> OwnerPetLst = select_pets(owner);
                        owner.setPets(OwnerPetLst);
                        return owner;
                    }
                });
        if (owners.isEmpty()) {
            return null;
        } else {
            return owners.get(0);
        }
    }

    /**
     * Owner 정보 DB에 입력
     */
    public int insert_owner(final Owner owner) {
        String sql = "INSERT INTO owners VALUES(?, ?, ?, ?, ?, ?)";
        return template.update(sql,
                new PreparedStatementSetter() {
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        int idx = template.queryForObject("SELECT MAX(id) FROM owners", Integer.class);
                        preparedStatement.setInt(1, idx + 1);
                        preparedStatement.setString(2, owner.getFirstName());
                        preparedStatement.setString(3, owner.getLastName());
                        preparedStatement.setString(4, owner.getAddress());
                        preparedStatement.setString(5, owner.getCity());
                        preparedStatement.setString(6, owner.getPhoneNUmber());
                    }
                });
    }

    /**
     * Owner 정보 수정
     */
    public int modify_owner(final Owner owner) {
        String sql = "UPDATE owners SET first_name = ?, last_name = ?, address = ?, city = ?, telephone = ? WHERE id = ?";
        return template.update(sql,
                new PreparedStatementSetter() {
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        preparedStatement.setString(1, owner.getFirstName());
                        preparedStatement.setString(2, owner.getLastName());
                        preparedStatement.setString(3, owner.getAddress());
                        preparedStatement.setString(4, owner.getCity());
                        preparedStatement.setString(5, owner.getPhoneNUmber());
                        preparedStatement.setInt(6, owner.getId());
                    }
                });
    }
}