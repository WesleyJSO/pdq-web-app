package com.pdq.usuario.dao;

import java.util.stream.Stream;

import com.dvsmedeiros.bce.domain.Filter;
import com.pdq.usuario.domain.Usuario;

public interface IUsuarioDAO {

	public Stream<Usuario> filter(Filter<Usuario> filter);
}
