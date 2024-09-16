package com.batch.config;

import com.batch.model.User;
import jakarta.transaction.TransactionManager;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;



import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {


    @Autowired
    private DataSource dataSource;


    @Autowired
    private JobBuilder jobBuilder;

    @Autowired
    private StepBuilder stepBuilder;

    @Autowired
   private PlatformTransactionManager transactionManager;


 
    @Bean
    public FlatFileItemReader<User> reader()
    {
        FlatFileItemReader<User> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("customers.csv"));
        reader.setLineMapper(getLineMapper());
        reader.setLinesToSkip(1);
        return reader;


    }

    @Bean
   public LineMapper<User> getLineMapper() {
        DefaultLineMapper<User> lineMapper=new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setNames(new String[]{"Index","First Name","Last Name","City","Country","Email"});
        lineTokenizer.setIncludedFields(new int[]{0,2,3,5,8});

        BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<>();

        fieldSetMapper.setTargetType(User.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }

    @Bean
    public ItemProcessor processor()
    {
        return new UserItemProcessor();
    }


    @Bean
    public JdbcBatchItemWriter<User> writer()
    {

        JdbcBatchItemWriter<User> writer=new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<User>());
        writer.setSql("insert into table user(userId,firstName,lastName,city,country,email) values (:userId,:firstName,:lastName,:city,:country,:email)");

        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public Job importUserJob()
    {
        return this.jobBuilder.incrementer(new RunIdIncrementer()).flow(step1()).end().build();

    }

    @Bean
    public Step step1() {

        return this.stepBuilder.<User,User>chunk(10,transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();


    }


}
