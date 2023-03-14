package hello.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import memory.MemoryController;
import memory.MemoryFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class MemoryConfig {

    @Bean
    public MemoryFinder memoryFinder(){
        return new MemoryFinder();
    }

    @Bean
    public MemoryController memoryController(){
        return new MemoryController(memoryFinder());
    }

    @PostConstruct
    public void initConfig(){
        log.info("MemoryConfig Init");
    }

}
