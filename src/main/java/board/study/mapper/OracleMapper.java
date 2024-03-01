package board.study.mapper;

import org.apache.ibatis.annotations.Select;

public interface OracleMapper {

    public String sysdateXml();

    @Select("SELECT SYSDATE FROM DUAL")
    public String sysdate();
}
