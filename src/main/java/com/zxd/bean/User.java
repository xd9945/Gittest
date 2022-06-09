package com.zxd.bean;



import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author xudongzhou
 * @since 2022-06-06
 */
@Data
public class User {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private String userUuid;

    private String userName;

    private String password;

    private String realName;

    private Integer age;

    private Integer sex;

    private String phone;




}
