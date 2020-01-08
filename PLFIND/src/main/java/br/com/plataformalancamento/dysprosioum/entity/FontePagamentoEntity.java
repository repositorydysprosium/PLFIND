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
@Table(name = ConstanteUtility.TABLE_NAME_TB_FONTE_PAGAMENTO)
@XmlRootElement
public class FontePagamentoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = ConstanteUtility.SEQUENCE_FONTE_PAGAMENTO, sequenceName = ConstanteUtility.SEQUENCE_FONTE_PAGAMENTO, allocationSize = 1)
	@GeneratedValue(generator = ConstanteUtility.SEQUENCE_FONTE_PAGAMENTO, strategy = GenerationType.SEQUENCE)
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;
	
	private String nome;
	
	private Boolean isAtivo;

	public FontePagamentoEntity() { }
	
	public FontePagamentoEntity(Long codigo) { 
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

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
