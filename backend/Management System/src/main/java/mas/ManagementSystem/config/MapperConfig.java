package mas.ManagementSystem.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    //    Add model mapper to app context
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
