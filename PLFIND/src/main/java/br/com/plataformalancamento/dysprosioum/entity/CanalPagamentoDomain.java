package br.com.plataformalancamento.dysprosioum.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.plataformalancamento.dysprosioum.utility.ConstanteUtility;

@Entity
@Table(name = ConstanteUtility.TABLE_NAME_TB_CANAL_PAGAMENTO)
@XmlRootElement
public class CanalPagamentoDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = ConstanteUtility.SEQUENCE_CANAL_PAGAMENTO, sequenceName = ConstanteUtility.SEQUENCE_CANAL_PAGAMENTO, allocationSize = 1)
	@GeneratedValue(generator = ConstanteUtility.SEQUENCE_CANAL_PAGAMENTO, strategy = GenerationType.SEQUENCE)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	@NotNull(message = "O nome não pode ser nulo")
	@Column(name = "NOME", nullable = false, length = 50)
	private String nome;
	
	private Boolean isValido;
	
	public CanalPagamentoDomain() { }
	
	public CanalPagamentoDomain(Long codigo) {
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

	public Boolean getIsValido() {
		return isValido;
	}

	public void setIsValido(Boolean isValido) {
		this.isValido = isValido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
