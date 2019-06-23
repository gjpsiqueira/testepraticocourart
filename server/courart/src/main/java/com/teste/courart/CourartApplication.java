package com.teste.courart;

import com.teste.courart.model.Modelo;
import com.teste.courart.model.Veiculo;
import com.teste.courart.repository.ModeloRepository;
import com.teste.courart.repository.VeiculoRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class CourartApplication {

	@Autowired
	private ModeloRepository modeloRepository;
	@Autowired
	private VeiculoRepository veiculoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CourartApplication.class, args);
	}

	@Bean
	public InitializingBean populateDB() {
		return () -> {

//			SimpleDateFormat spl=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			Date date = spl.parse("2012-12-13 14:54:30");

//			String d=spl.format(date);
//			date=spl.parse(d);

//			Modelo m1 = new Modelo("YUNDAI I30","2009",8.10,4);
//			Veiculo v = new Veiculo("MX-100-20","MX2938382JMK123K",true,"2001",date,date,m1);
//			Veiculo v1 = new Veiculo("MX-200-21","MX2938382JMK123K",false,"2009",date,date,m1);
//			modeloRepository.save(m1);
//			veiculoRepository.save(v);
//			veiculoRepository.save(v1);

		};
	}
}
