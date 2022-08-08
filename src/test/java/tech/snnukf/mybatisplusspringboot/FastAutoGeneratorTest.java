package tech.snnukf.mybatisplusspringboot;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @className: FastAutoGeneratorTest
 * @description: TODO 类描述
 * @author: simple.jbx
 * @date: 2022/8/8
 **/
public class FastAutoGeneratorTest {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://192.168.182.129:3306/mybatis_plus?characterEncoding=utf-8&userSSL=false", "root", "123456")
                        .globalConfig(builder -> {
                            builder.author("simple") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                                    .fileOverride() // 覆盖已生成文件
                                    .outputDir("D:\\Code\\JAVA\\mybatis-plus-auto-generator"); // 指定输出目录
                        })
                        .packageConfig(builder -> {
                            builder.parent("tech.snnukf") // 设置父包名
                                    .moduleName("mybatisplusspringboot") // 设置父包模块名
                                    .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\Code\\JAVA\\mybatis-plus-auto-generator\\mapper"));// 设置mapperXml生成路径
                        })
                        .strategyConfig(builder -> {
                            builder.addInclude("t_user") // 设置需要生成的表名
                                    .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                        })
                        .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                        .execute();
    }
}
