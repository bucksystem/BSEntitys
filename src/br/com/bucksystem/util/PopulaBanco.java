package br.com.bucksystem.util;

import javax.persistence.EntityManager;

import br.com.bucksystem.entity.Empresa;
import br.com.bucksystem.entity.Grupo;
import br.com.bucksystem.entity.Modulo;
import br.com.bucksystem.entity.Usuario;
import br.com.bucksystem.entity.UsuariosTipo;

public class PopulaBanco {

	public static void main( String[] args ) {

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		
		Empresa empresa = new Empresa();
		empresa.setRazaosocial("Supervisor");
		empresa.setNomefantasia("Supervisor");
		empresa.setCnpjcpf("00000000000");
		empresa.setConsistircnpjcpf( (byte)0 );
		em.persist(empresa);
		
		UsuariosTipo usuariosTipo = new UsuariosTipo();
		usuariosTipo.setUsuariotipo( "Supervisor");
		usuariosTipo.setMaster( (byte)1 );
		em.persist(usuariosTipo);
		
		Usuario usuario = new Usuario();
		usuario.setEmail("supervidor@bucksystem.com.br");
		usuario.setUsuario("supervisor");
		new CriptoAll();
		String criptoAll = CriptoAll.md5( "Dell@1234" );
		usuario.setSenha( criptoAll );
		usuario.setUsuariosTipo(usuariosTipo);
		usuario.setEmpresa2(empresa);
		em.persist(usuario);
		
		UsuariosTipo usuariosTipo2 = new UsuariosTipo();
		usuariosTipo2.setUsuariotipo( "Normal");
		usuariosTipo2.setMaster( (byte)0 );
		em.persist(usuariosTipo2);
		
		UsuariosTipo usuariosTipo3 = new UsuariosTipo();
		usuariosTipo3.setUsuariotipo( "Supervisor de Sistema");
		usuariosTipo3.setMaster( (byte)0 );
		em.persist(usuariosTipo3);
		
		UsuariosTipo usuariosTipo4 = new UsuariosTipo();
		usuariosTipo4.setUsuariotipo( "Coordenador de Sistema");
		usuariosTipo4.setMaster( (byte)0 );
		em.persist(usuariosTipo4);

		Modulo modulo = new Modulo();
		modulo.setModulo("Usuários (t)");
		modulo.setSistemas( (byte)0 );
		modulo.setEstrutmensal( (byte)0 );
		em.persist(modulo);
		
		Grupo grupo = new Grupo();
		grupo.setGrupo("Informática");
		grupo.setModulo(modulo);
		em.persist(grupo);
		
		Grupo grupo2 = new Grupo();
		grupo2.setGrupo("Vendas");
		grupo2.setModulo(modulo);
		em.persist(grupo2);
		
		Modulo modulo2 = new Modulo();
		modulo2.setModulo("Itens (t)");
		modulo2.setSistemas( (byte)0 );
		modulo2.setEstrutmensal( (byte)0 );
		em.persist(modulo2);
		
		Modulo modulo3 = new Modulo();
		modulo3.setModulo("Contas a Receber");
		modulo3.setSistemas( (byte)1 );
		modulo3.setEstrutmensal( (byte)1 );
		em.persist(modulo3);
		
		Modulo modulo4 = new Modulo();
		modulo4.setModulo("Contabilidade");
		modulo4.setSistemas( (byte)1 );
		modulo4.setEstrutmensal( (byte)1 );
		em.persist(modulo4);

		em.getTransaction().commit();
		em.close();

	}

}
