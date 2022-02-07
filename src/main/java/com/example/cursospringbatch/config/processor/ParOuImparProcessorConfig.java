package com.example.cursospringbatch.config.processor;

import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.lang.String.format;

@Configuration
public class ParOuImparProcessorConfig {

    @Bean
    public FunctionItemProcessor<Integer, String> parOuImparProcessor() {
        return new FunctionItemProcessor<>
                (item -> item % 2 == 0 ? format("Item %s é par", item) : format("Item %s é ímpar", item));
    }

}
