package cn.edu.sdu.ise.labs.vo;

import lombok.Data;

/**
 * @author 15508
 */
@Data
public class NamelistVO {
    /**
     * id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 单位
     */
    private String organization;

    /**
     * 电话
     */
    private String telephoneNum;

    /**
     * 省份
     */
    private String province;

    /**
     * email
     */
    private String email;

    /**
     * 家庭住址
     */
    private String address;

}
