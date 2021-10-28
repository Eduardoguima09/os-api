package com.eduardo.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.os.domain.Cliente;
import com.eduardo.os.domain.OS;
import com.eduardo.os.domain.Tecnico;
import com.eduardo.os.domain.enums.Prioridade;
import com.eduardo.os.domain.enums.Status;
import com.eduardo.os.repositories.ClienteRepository;
import com.eduardo.os.repositories.OSRepository;
import com.eduardo.os.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository osRepository;

	public void instanciaDB() {

		Tecnico t1 = new Tecnico(null, "Eduardo", "144.785.300-84", "(88) 9888-8888");
		Cliente c1 = new Cliente(null, "Mariana", "598.508.200-80", "(88) 9888-7777");
		OS os1 = new OS(null, Prioridade.ALTA, "Obs.Teste create OS", Status.ANDAMENTO, t1, c1);

		Tecnico t2 = new Tecnico(null, "Linus Torvalds", "641.760.040-88", "(88) 9888-9999");
		
		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));

	}
}
