package demo.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TaskSchedule {
    //@Scheduled(cron="0/2 * *  * * ?")
    @Scheduled(fixedRate = 2000)
    public void healthCheck() {
        log.info("health");
    }
}
