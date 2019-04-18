package com.s3.helper;

import com.pdq.pedido.domain.Perfil;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PerfilHelper extends Perfil {

	private static final long serialVersionUID = 119162020054495665L;

    public static final Long ADM_VENDAS = 5L; 
    public static final Long RTV = 6L; 
}