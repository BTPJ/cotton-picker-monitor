import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class MPGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:sqlite:src\\main\\resources\\sqlite\\test.db", "root", "root")
                .globalConfig(builder -> {
                    builder.author("BTPJ") // 设置作者
                            .commentDate("yyyy-MM-dd")
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(System.getProperty("user.dir") + "\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.btpj.monitor") // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addTablePrefix("t_", "c_") // 设置过滤表前缀
                            .enableSkipView(); // 跳过视图

                    // 实体类相关
                    builder.entityBuilder()
                            .enableChainModel()
                            .enableLombok()
                            .idType(IdType.AUTO);

                    builder.controllerBuilder()
                            .enableFileOverride()
                            .enableRestStyle(); // Controller为RestController
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
