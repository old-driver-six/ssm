package com.bj186.oas.mapper;

import com.bj186.oas.pojo.Position;

public interface PositionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oas_position
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    int deleteByPrimaryKey(Integer positionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oas_position
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    int insert(Position record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oas_position
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    int insertSelective(Position record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oas_position
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    Position selectByPrimaryKey(Integer positionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oas_position
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    int updateByPrimaryKeySelective(Position record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oas_position
     *
     * @mbg.generated Tue Jun 18 09:59:51 CST 2019
     */
    int updateByPrimaryKey(Position record);
}