package com.hypermind.provider.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 无间
 * @since 2019-10-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("config")
public class Config extends Model<Config> {

    private static final long serialVersionUID=1L;

    @TableField("name")
    private String name;

    @TableField("value")
    private Integer value;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
