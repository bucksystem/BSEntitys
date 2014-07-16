package br.com.bucksystem.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Empresas database table.
 * 
 */
@Entity
@Table(name="Empresas")
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="EMPR_ChpEmpresa")
	private Long id;

	@Column(name="EMPR_DsaNomeFantasia")
	private String nomefantasia;

	@Column(name="EMPR_DsaRazaoSocial")
	private String razaosocial;

	@Column(name="EMPR_NoaCNPJCPF")
	private String cnpjcpf;

	@Column(name="EMPR_OpbConsistirCNPJCPF")
	private byte consistircnpjcpf;

	@Version
	private Timestamp versao;

	//bi-directional one-to-one association to Usuario
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EMPR_ChpEmpresa")
	private Usuario usuario;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="empresa2")
	private List<Usuario> usuarios;

	public Empresa() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomefantasia() {
		return this.nomefantasia;
	}

	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
	}

	public String getRazaosocial() {
		return this.razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public String getCnpjcpf() {
		return this.cnpjcpf;
	}

	public void setCnpjcpf(String cnpjcpf) {
		this.cnpjcpf = cnpjcpf;
	}

	public byte getConsistircnpjcpf() {
		return this.consistircnpjcpf;
	}

	public void setConsistircnpjcpf(byte consistircnpjcpf) {
		this.consistircnpjcpf = consistircnpjcpf;
	}

	public Timestamp getVersao() {
		return this.versao;
	}

	public void setVersao(Timestamp versao) {
		this.versao = versao;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setEmpresa2(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setEmpresa2(null);

		return usuario;
	}

}