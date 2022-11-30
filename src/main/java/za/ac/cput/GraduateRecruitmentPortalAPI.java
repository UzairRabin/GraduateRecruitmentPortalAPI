package za.ac.cput;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@Slf4j
@SpringBootApplication
public class GraduateRecruitmentPortalAPI {

    public static final File appDirectory = new File(System.getenv("APPDATA")
                                            + "\\" + "Graduate " + "Recruitment Portal" + "\\");;

    private static void createAppDirectory()
    {
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
    }

    public static void main(String[] args)
    {
        createAppDirectory();
//        SpringApplication.run(GraduateRecruitmentPortalAPI.class, args);
    }
}
