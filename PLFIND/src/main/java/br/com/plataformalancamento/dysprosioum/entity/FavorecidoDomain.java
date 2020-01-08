package br.com.plataformalancamento.dysprosioum.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.plataformalancamento.dysprosioum.utility.ConstanteUtility;

@Entity
@Table(name = ConstanteUtility.TABLE_NAME_TB_FAVORECIDO)
@XmlRootElement
public class FavorecidoDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = ConstanteUtility.SEQUENCE_FAVORECIDO, sequenceName = ConstanteUtility.SEQUENCE_FAVORECIDO, allocationSize = 1)
	@GeneratedValue(generator = ConstanteUtility.SEQUENCE_FAVORECIDO, strategy = GenerationType.SEQUENCE)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	private String nome;
	
	public FavorecidoDomain() { }
	
	public FavorecidoDomain(Long codigo) {
		super();
		this.codigo = codigo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
