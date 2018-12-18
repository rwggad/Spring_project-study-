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

    public List<Owner> getOwners(){
        List<Owner> ownerList = this.dao.select_owners();
        if(ownerList.isEmpty()){ // 현재 사이트에 방문자 정보가 없다면
            return null;
        }else{
            return ownerList;
        }
    }
}
