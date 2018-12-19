package conn.service;

import conn.Model.ClinicModel.Owner;
import conn.dao.ClinicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClinicService {

    @Autowired
    ClinicDao dao;

    /** Owner 모든 정보 가져오기 */
    public List<Owner> getOwners(){
        List<Owner> ownerList = this.dao.select_owners();
        if(ownerList.isEmpty()){ // 현재 사이트에 방문자 정보가 없다면
            return null;
        }else{
            return ownerList;
        }
    }

    /** 특정 Owner 정보 가져오기 */
    public Owner getOwner(int id){
        Owner owner = this.dao.select_owner(id);
        return owner;
    }

    /** Owner 정보 입력하기 */
    public int putOwner(Owner owner){
        return this.dao.insert_owner(owner);
    }

    /** Owner 정보 수정하기*/
    public int modifyOwner(Owner owner){
        return this.dao.modify_owner(owner);
    }

}
