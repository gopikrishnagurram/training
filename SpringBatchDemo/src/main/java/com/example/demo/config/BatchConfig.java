package com.example.demo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.example.demo.bean.Playerdetails;
import com.example.demo.listnere.JobCompleteionListner;
import com.example.demo.steps.FlatFileProcessor;
import com.example.demo.steps.FlatFileWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	/**
	 * Internally providing the JobRepository object.
	 */
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFareaderctory;
	
	@Autowired
	public FlatFileProcessor flatFileProcessor;
	
	@Autowired 
	public FlatFileWriter flatFileWriter;
	
	@Value("classPath:/playercsv.csv")
	private Resource inputResource;
	
	
	@Bean
	public Job processFileJob() {
		return jobBuilderFactory.get("FILE-JOB").incrementer(new RunIdIncrementer()).listener(listener())
				.flow(flatFileStep()).end().build();
	}

	@Bean
	public Step flatFileStep() {
		return stepBuilderFareaderctory.get("FILE-Step").<Playerdetails, Playerdetails>chunk(3).reader(reader())
				.processor(flatFileProcessor).writer(flatFileWriter).build();
	}

	@Bean
	public FlatFileItemReader<Playerdetails> reader() {
		FlatFileItemReader<Playerdetails> itemReader = new FlatFileItemReader<Playerdetails>();
		itemReader.setLineMapper(lineMapper());
		itemReader.setLinesToSkip(1);
		itemReader.setResource(inputResource);
		return itemReader;
	}

	@Bean
	public LineMapper<Playerdetails> lineMapper() {
		DefaultLineMapper<Playerdetails> lineMapper = new DefaultLineMapper<Playerdetails>();

		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] { "no", "name", "age", "role" });
		lineTokenizer.setIncludedFields(new int[] { 0, 1, 2, 3 });
		

		BeanWrapperFieldSetMapper<Playerdetails> fieldSetMapper = new BeanWrapperFieldSetMapper<Playerdetails>();
		fieldSetMapper.setTargetType(Playerdetails.class);

		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);

		return lineMapper;
	}
	
	@Bean
	public JobExecutionListener listener() {
		return new JobCompleteionListner();
	}
}
