package com.hitices.basicmaterial.service;

import com.hitices.basicmaterial.bean.RecordBean;
import com.hitices.basicmaterial.entity.MaterialRecord;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author jokerLjn
 * @version 1.0
 * @date 2021/9/21 20:38
 */
public interface MaterialRecordService {

    /**
     * add a record
     *
     * @param bean
     * @return recordId
     */
    Integer addRecord(RecordBean bean);

    /**
     * delete a record
     *
     * @param recordId
     * @return
     */
    boolean deleteRecord(Integer recordId);

    /**
     * delete all record of an optUser
     *
     * @param optUserId
     */
    void deleteAllRecordsByOptUserId(Integer optUserId);

    /**
     * get by record id
     *
     * @param recordId
     * @return
     */
    Optional<MaterialRecord> getByRecordId(Integer recordId);

    /**
     *
     * select all record of an optUser
     *
     * @param optUserId
     * @return
     */
    List<MaterialRecord> getAllRecordsByOptUserId(Integer optUserId);

    /**
     * select all record of an optUser between start and end;
     *
     * @param optUserId
     * @param start
     * @param end
     * @return
     */
    List<MaterialRecord> getAllRecordsByOptUserIdBetween(Integer optUserId, Date start, Date end);
}
