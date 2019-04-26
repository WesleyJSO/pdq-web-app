package com.s3.repository;

import java.util.List;

import com.pdq.pedido.domain.Usuario;
import com.pdq.utils.IRepository;
/**
 * 
 * @author José Wesley Silva
 * Muralis Assessoria e Tecnologia Ltda.
 * 23-04-2019 17:44:19
 *
 */
public interface UsuarioRepository extends IRepository<Usuario, Long> {

	Usuario findByLoginAndSenha(String login, String senha);

	Usuario findBySenha(String senha);

	List<Usuario> findByStsAtivo(Boolean ativo);
}
