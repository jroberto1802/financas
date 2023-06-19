package com.jrdev.minhasfinancas.service;

import com.jrdev.minhasfinancas.model.entity.Lancamento;

public interface LancamentoService {
	
	Lancamento atutenticar(String email, String senha);
	
	Lancamento salvarLancamento(Lancamento lancamento);
}
