package com.example.cursospringbatch.config.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImprimeParImparStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step imprimeParImparStep(ItemReader<Integer> reader,
                                    ItemProcessor<Integer, String> processor,
                                    ItemWriter<String> writer) {
        return stepBuilderFactory
                .get("imprimeParImparStep")
                .<Integer, String>chunk(10)
                // tipo dos itens <lidos, escritos> tamanho do chunk(10 itens por chunk)
                .reader(reader)
                .processor(processor) // opcional
                .writer(writer)
                .build();
    }

}
