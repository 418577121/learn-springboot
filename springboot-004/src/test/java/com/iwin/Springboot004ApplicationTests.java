package com.iwin;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import com.iwin.entity.SysUser;
import com.iwin.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest(classes = Springboot004Application.class)
public class Springboot004ApplicationTests {

    @Resource
    private SysUserMapper userMapper;

    @Test
    public void addSysUser() {
        SysUser sysUser = new SysUser();
        sysUser.setCreateTime(LocalDateTime.now());
        sysUser.setEmail("wwww@QQ.com");
        sysUser.setDeptId(BigDecimal.valueOf(1));
        sysUser.setLoginName("测试");
        sysUser.setUserName("admin");
        sysUser.setAdminFlag("0");
        sysUser.setUserType("1");
        sysUser.setPhoneNumber("1232132323");
        sysUser.setPassword("11");
        sysUser.setSalt("111");
        userMapper.insert(sysUser);
    }

    @Test
    public void getAll() {
        List<SysUser> sysUsers = userMapper.selectList(null);
        System.out.println(sysUsers);
    }

    @Test
    public void startGenerator() {
        //1、全局配置
        GlobalConfig config = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        config.setActiveRecord(true)//开启AR模式
                .setAuthor("iwin")//设置作者
                .setOutputDir(projectPath + "/src/main/java")//生成路径(一般在此项目的src/main/java下)
                .setFileOverride(true)//第二次生成会把第一次生成的覆盖掉
                .setOpen(true)//生成完毕后是否自动打开输出目录
                //.setSwagger2(true)//实体属性 Swagger2 注解
                //.setIdType(IdType.AUTO)//主键策略
                .setServiceName("%sService")//生成的service接口名字首字母是否为I，这样设置就没有I
                .setBaseResultMap(true)//生成resultMap
                .setBaseColumnList(true);//在xml中生成基础列
        //2、数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.ORACLE)//数据库类型
                .setDriverName("oracle.jdbc.driver.OracleDriver")
                .setUrl("jdbc:oracle:thin:@127.0.0.1:1521:orcl")
                .setUsername("dht")
                .setPassword("dht");
        //3、策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)//开启全局大写命名
                .setNaming(NamingStrategy.underline_to_camel)//表名映射到实体的命名策略(下划线到驼峰)
                //表字段映射属性名策略(未指定按naming)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //.setTablePrefix("tb_")//表名前缀
                //.setSuperEntityClass("你自己的父类实体,没有就不用设置!")
                //.setSuperEntityColumns("id");//写于父类中的公共字段
                //.setSuperControllerClass("自定义继承的Controller类全称，带包名,没有就不用设置!")
                .setRestControllerStyle(true) //生成 @RestController 控制器
                .setEntityLombokModel(true)//使用lombok
                .setInclude("SYS_USER",
                        "SYS_DEPT",
                        "SYS_DEPT_USER",
                        "SYS_USER_CHANNEL",
                        "SYS_ROLE",
                        "SYS_USER_ROLE_DISTRIBUTION",
                        "SYS_USER_ROLE_USE",
                        "SYS_MENU",
                        "SYS_ROLE_MENU",
                        "SYS_USER_MENU_DISTRIBUTION",
                        "SYS_USER_MENU_USE",
                        "SYS_OPER_LOG"
                        );//逆向工程使用的表
        //4、包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.iwin")//设置包名的parent
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("entity")
                .setXml("mapper");//设置xml文件的目录
        //5、整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);
        //6、执行
        autoGenerator.execute();
    }

}
