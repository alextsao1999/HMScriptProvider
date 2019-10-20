package com.hypermind.provider;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

import java.io.File;
import java.util.*;

public class CodeGenerator {
    private static String packageName = "";               //文件路径
    private static String packagePath = "com.hypermind.provider";
    private static String authorName = "无间";          //作者
    private static String[] table = {"scripts", "config"};          //table名字
    private static String prefix = "";                    //table前缀
    private static File file = new File(packageName);
    private static String path = file.getAbsolutePath();

    // 代码生成器
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
                // 全局配置
                new GlobalConfig()
                        .setOutputDir(path + "/src/main/java")//输出目录
                        .setFileOverride(true)// 是否覆盖文件
                        .setActiveRecord(true)// 开启 activeRecord 模式
                        .setEnableCache(false)// XML 二级缓存
                        .setBaseResultMap(true)// XML ResultMap
                        .setBaseColumnList(true)// XML columList
                        .setOpen(false)//生成后打开文件夹
                        .setAuthor(authorName)
                        .setMapperName("%sMapper")
                        .setServiceName("%sService")
                        .setServiceImplName("%sServiceImpl")
                        .setControllerName("%sController")
        ).setDataSource(
                // 数据源配置
                new DataSourceConfig()
                        .setDbType(DbType.SQLITE)// 数据库类型
                        .setDriverName("org.sqlite.JDBC")
                        .setUsername("root")
                        .setPassword("root")
                        .setUrl("jdbc:sqlite:" + path + "/src/main/resources/database/website.db")
        ).setStrategy(
                // 策略配置
                new StrategyConfig()
                        .setEntityLombokModel(true)
                        .setTablePrefix(prefix)
                        .setNaming(NamingStrategy.underline_to_camel)
                        .setInclude(table)
                        .setRestControllerStyle(true)
                        .entityTableFieldAnnotationEnable(true)
                        .setSuperControllerClass(packagePath + ".controller.BaseController")
//                        .setSuperEntityClass("BaseEntity")
//                        .setSuperEntityColumns("id","del_flag","add_time","upd_time","add_uid","upd_uid")
        ).setPackageInfo(
                new PackageConfig()
                        .setParent(packagePath)// 自定义包路径
                        .setController("controller")
                        .setEntity("model")
                        .setMapper("mapper")
                        .setXml("mapper.xml")
                        .setService("service.iService")
                        .setServiceImpl("service")
        ).setCfg(
                new InjectionConfig() {
                    @Override
                    public void initMap() {
                        Map<String, Object> map = new HashMap<>();
                        map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                        this.setMap(map);
                    }
                }
        ).setTemplate(
                new TemplateConfig()
                        .setXml(null)//不生成XML
//                        .setService(null)//不生成Service
//                        .setServiceImpl(null)//不生成Service
//                        .setMapper(null)//不生成Mapper
                        .setController(null)//不生成Controller
        );

        // 执行生成
        mpg.execute();
    }

}
