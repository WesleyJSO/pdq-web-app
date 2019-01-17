package com.pdq.pedido.dao;

import java.util.stream.Stream;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.pedido.domain.Usuario;

public interface IUsuarioDAO {

	public Stream<Usuario> filter(Filter<Usuario> filter);
}
