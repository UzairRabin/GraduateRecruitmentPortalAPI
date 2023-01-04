package za.ac.cput;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.File;
import java.io.IOException;

@Slf4j
@SpringBootApplication
@EnableSwagger2
public class GraduateRecruitmentPortalAPI {

    private static File appDirectory = null;

    public static String getAppDirectory()
    {
        return appDirectory.getAbsolutePath();
    }

    public static String getUserDirectory(String username)
    {
        createDirectory(getAppDirectory() + "//" + "users" + "//" + username + "//");
        return getAppDirectory() + "//" + "users" + "//" + username + "//";
    }

    public static String getUserDocumentsDirectory(String username)
    {
        createDirectory(getUserDirectory(username) + "documents" + "//");
        return getUserDirectory(username) + "documents" + "//";
    }



    public static void main(String[] args)
    {
        createAppDirectory();
        SpringApplication.run(GraduateRecruitmentPortalAPI.class, args);
    }

    private static void createDirectory(String path)
    {
        try{
            File directory = new File(path);

            if(!directory.exists())
            {
                if (((directory.mkdirs())))
                {
                    log.info("App Directory Creation:{}", directory);
                } else
                {
                    log.error("App Directory Creation:{}", directory);
                }
            }
        }catch (Exception exception)
        {
            log.info("App Directory Creation:{}", exception);
        }
    }


    private static void createAppDirectory()
    {
        try{
            appDirectory = new File(System.getenv("APPDATA")
                    + "//" + "Graduate " + "Recruitment Portal" + "//");

            if(!appDirectory.exists())
            {
                if (((appDirectory.mkdirs())))
                {
                    log.info("App Directory Creation:{}", appDirectory);
                } else
                {
                    log.error("App Directory Creation:{}", appDirectory);
                }
            }
        }catch (Exception exception)
        {
            log.info("App Directory Creation:{}", exception);
        }

    }

}
