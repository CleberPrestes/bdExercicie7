package posutfpr.banco.ativcinco;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import posutfpr.banco.ativcinco.entity.DepartamentEntity;
import posutfpr.banco.ativcinco.entity.FuncEntity;
import posutfpr.banco.ativcinco.service.DepartamentService;
import posutfpr.banco.ativcinco.service.FuncService;


//UTFPR — Universidade Tecnológica Federal do Paraná UTFPR
//XXI Curso de Especialização em Tecnologia Java (2021_01)
//Banco de Dados
//Atividade 7
//Cleber dos Santos Prestes de Oliveira


@SpringBootApplication
public class AtivcincoApplication {

	static String departTest;
    static int depTest;
	public static void main(String[] args) {
		SpringApplication.run(AtivcincoApplication.class, args);

		System.out.println("The system ok");

	}

	DepartamentEntity depAdm = new DepartamentEntity("Administrativo");
	DepartamentEntity dpFinc = new DepartamentEntity("Financeiro");
	DepartamentEntity dpRH = new DepartamentEntity("Rec. Human");
	DepartamentEntity dpCom = new DepartamentEntity("Comercial");
	DepartamentEntity dpDir = new DepartamentEntity("Diretoria");

	@Bean
	public CommandLineRunner demo(DepartamentService departamentService) {
		return (args) -> {

			// salvando os departamentos
			//Descomentar para popular o banco
			/*
			departamentService.saveDepartament(depAdm);
			departamentService.saveDepartament(dpFinc);
			departamentService.saveDepartament(dpRH);
			departamentService.saveDepartament(dpCom);
			departamentService.saveDepartament(dpDir);
			*/
		
		
		};
	}

	@Bean
	public CommandLineRunner demoFunc(FuncService funcService, DepartamentService departamentService) {
		return (args) -> {

			// populando os funcionarios
			//Descomentar para popular o banco
			/*
			funcService.saveFunc(new FuncEntity("João Silva", 4, 7500l, "Diretor", depAdm));
			funcService.saveFunc(new FuncEntity("Maria Santos", 2, 5500l, "Gerente", depAdm));
			funcService.saveFunc(new FuncEntity("Jorge Oliveira", 3, 6800l, "Coordenador", depAdm));
			funcService.saveFunc(new FuncEntity("Aline Ribas", 1, 4600l, "Supervisor", depAdm));

			funcService.saveFunc(new FuncEntity("Jhon Wick", 0, 3500l, "Contador", dpFinc));
			funcService.saveFunc(new FuncEntity("Jean Claude", 6, 4500l, "Estatistico", dpFinc));
			funcService.saveFunc(new FuncEntity("Lara Croft", 2, 3500l, "Gerente", dpFinc));

			funcService.saveFunc(new FuncEntity("Miguel Monet", 3, 6500l, "Supervisor", dpRH));
			funcService.saveFunc(new FuncEntity("Edgar Degas", 1, 2500l, "Recrutador", dpRH));

			funcService.saveFunc(new FuncEntity("João Debret", 4, 1500l, "Telemarketing", dpCom));
			funcService.saveFunc(new FuncEntity("Margot Robbie", 3, 3500l, "Vendedor", dpCom));
			funcService.saveFunc(new FuncEntity("Ellen Page", 2, 3500l, "Auxiliar de vendas", dpCom));

			funcService.saveFunc(new FuncEntity("Peter Parker", 0, 30000L, "COO", dpDir));
			funcService.saveFunc(new FuncEntity("Steve Rogers", 0, 37000l, "CEO", dpDir));
			funcService.saveFunc(new FuncEntity("Klark Kent", 0, 35000l, "CFO", dpDir));
			
			*/
			
			
			
			// Atividade7.1
			System.out.println("-----------------------------------------------------------------");
			System.out.println(" Atividade 7.1 - Reajute de Salario em 10%");
			funcService.salaryReadjustment(10);
			
			
			// Atividade7.2
			System.out.println("-----------------------------------------------------------------");
			System.out.println(" Atividade 7.2 - Funcionarios com zero dependentes da Diretoria");
			for (FuncEntity listFuncToDep : funcService.findByNamedParam(0, "Diretoria")) {

				System.out.println(listFuncToDep.getName());
			}
				
			// Atividade7.3
		
			System.out.println("-----------------------------------------------------------------");
			System.out.println(" Atividade 7.3 - Update departamento  ");
			
			int resultUpd =funcService.updateFuncDepart(departamentService.findDepartByName("Financeiro"),
					departamentService.findDepartByName("Administrativo"));
			System.out.println(" Update: Number=True, 0=False - Resultado: " + resultUpd);
			
						
			
			// Atividade7.4
			System.out.println("-----------------------------------------------------------------");
			System.out.println(" Atividade 7.4 - Delete todos os funcionarios de um departamento ");
			int resultDel =funcService.deleteFuncByDepart(2l);
			System.out.println(" Delete: Number=True, 0=False - Resultado: " + resultDel);
			System.out.println("-----------------------------------------------------------------");			
					
			
			
		};

	}

}
