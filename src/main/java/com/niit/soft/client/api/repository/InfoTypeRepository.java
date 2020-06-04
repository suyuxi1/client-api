package com.niit.soft.client.api.repository;

import com.niit.soft.client.api.domain.model.InfoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * @author Yujie_Zhao
 * @ClassName InfoTypeRepository
 * @Description 资讯分类Repository
 * @Date 2020/5/26  17:16
 * @Version 1.0
 **/
public interface InfoTypeRepository extends JpaRepository<InfoType,Long> , JpaSpecificationExecutor<InfoType> {
    /**
     * 更具id查找分类
     * @param id
     * @return InfoType
     */
    InfoType findByPkInfoTypeId(Long id);

    /**
     * 更具分离名称查找分类
     * @param name
     * @return
     */
    InfoType findByName(String name);

    /**
     * @param id
     * @return
     */
    @Query(value = "select name,sort from first_smart_campus.info_type where pk_info_type_id = ?1",nativeQuery = true)
    InfoType getTopById(Long id);


    /**
     * 更具id查找分类
     * @param id
     * @return
     */
    @Query(value = "select T.pk_info_type_id, T.name,T.sort,M.pk_info_manage_id  " +
            "FROM first_smart_campus.info_manage_type MT ," +
            " first_smart_campus.info_type T  ," +
            " first_smart_campus.info_manage M " +
            "WHERE MT.info_id = M.pk_info_manage_id " +
            "AND MT.type_id = T.pk_info_type_id " +
            "AND T.pk_info_type_id = ?1",nativeQuery = true)
    List<Map<String,Object>> findInfoByPkInfoTypeId(Long id);

}
