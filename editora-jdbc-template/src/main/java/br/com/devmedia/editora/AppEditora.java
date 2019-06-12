package br.com.devmedia.editora;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StringUtils;

import br.com.devmedia.editora.dao.AutorDao;
import br.com.devmedia.editora.dao.EditoraDao;
import br.com.devmedia.editora.dao.EnderecoDao;
import br.com.devmedia.editora.dao.LivroAutorDao;
import br.com.devmedia.editora.dao.LivroDao;
import br.com.devmedia.editora.entity.Autor;
import br.com.devmedia.editora.entity.Editora;
import br.com.devmedia.editora.entity.Endereco;
import br.com.devmedia.editora.entity.Livro;
import br.com.devmedia.editora.entity.LivroAutor;

/**
 * Hello world!
 *
 */
@EnableAutoConfiguration
@ComponentScan
public class AppEditora implements CommandLineRunner {

	@Autowired
	private EditoraDao editoraDao;

	@Autowired
	private LivroDao livroDao;

	@Autowired
	private AutorDao autorDao;

	@Autowired
	private LivroAutorDao livroAutorDao;

	@Autowired
	private EnderecoDao enderecoDao;

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication();
		SpringApplication.run(AppEditora.class);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("---------------------------------------------");
//		insertEditora();
//		findAllEditoras();
//		findById();
//		findByCidade();
//		findByRazaoSocial();
//		countEditoras();
//		findEmailByIdEditora();
//		findCidadeAndEmailByIdEditora();
//		updateEditora();
//		deleteEditora();
//		execute();
//		insertAutor();
//		findAllAutores();
//		findAutoresByEditora();
//		updateAutor();
//		deleteAutor();
//		findEditoraWithAutores();
//		insertLivro();
//		findLivroWithAutores();
		findAutorWithLivros();
//		findLivrosByEdicao();
//		findLivroByPaginas();
//		updateLivro();
//		findLivroByTituloAndEdicao();
//		procedureUpperCase();

//		procedureInfo();
//		functionAutorLivro();
//		insertBatchEditoras();

//		updateBathAutores();
//		deleteBatchAutores();
//		findAllEnderecos();

		System.out.println("---------------------------------------------");
	}

	private void findAllEnderecos() {
		List<Endereco> enderecos = enderecoDao.findAll();
		enderecos.forEach(System.out::println);
	}

	private void deleteBatchAutores() {

		autorDao.deleteBath(Arrays.asList(7, 8, 9));
	}

	private void updateBathAutores() {
		Autor a1 = autorDao.findById(5);
		a1.setEmail("pm@email.com");
		Autor a2 = autorDao.findById(6);
		a2.setEmail("carlaPires@email.com");
		Autor a3 = autorDao.findById(7);
		a3.setEmail("manoelSantos@email.com");

		autorDao.updateBath(Arrays.asList(a1, a2, a3));

		findAllAutores();

	}

	private void insertBatchEditoras() {
		System.out.println("-------Primeiro insert--------------------------");
		List<Editora> editoras = new ArrayList<>();
		editoras.add(new Editora("Editora Leão", "Belém", "ed-leao@edLeao.com.br"));
		editoras.add(new Editora("Editora Pé Redondo", "Belém", "pe-redondo@edPeRedondo.com.br"));
		editoras.add(new Editora("Editora Maguari", "Ananindeua", "ed-maguari@edMaguari.com.br"));

		editoraDao.saveBatch(editoras);

		findAllEditoras();

		System.out.println("-------Segundo insert--------------------------");
		editoras = new ArrayList<>();
		editoras.add(new Editora("Editora Modelo", "Castanhal", "ed-modelo@edModelo.com.br"));
		editoras.add(new Editora("Editora Barcarena", "Barcarena", "ed-barcarena@edBarcarena.com.br"));
		editoras.add(new Editora("Editora Munguba", "Monte Dourado", "ed-munguna@edMunguba.com.br"));

		editoraDao.insertBatch(editoras);

		findAllEditoras();

	}

	private void functionAutorLivro() {
		String texto = livroDao.callFunctionTotalLivrosByAutor(4);
		System.out.println(texto);

	}

	private void procedureInfo() {
		List<String> retorno = livroDao.callProcedureInfoLivro(8);

		System.out.println(retorno.toString());
	}

	private void procedureUpperCase() {
		Map<String, Object> map = livroDao.callProcedureUpperCaseTitulo(3);

		for (Map.Entry<String, Object> kv : map.entrySet()) {
			System.out.println(kv.getKey() + "\n" + kv.getValue());
		}
	}

	private void findLivroByTituloAndEdicao() {

		Livro livro = livroDao.findByTituloAndEdicao("Aprenda JEE em 60 dias", 1);
		System.out.println("LIVRO: " + livro.toString());
	}

	private void updateLivro() {
		Livro livro = livroDao.findLivroWithComAutores(3);
		System.out.println("ORIGINAL: " + livro.toString());

		livro.setTitulo("Aprenda JEE em 60 dias");
//		livro.setPaginas(182);
//		livro.setEdicao(1);

//		int OK = livroDao.update(livro);
		int OK = livroDao.alter(livro);

		if (OK == 1) {
			livro = livroDao.findLivroWithComAutores(3);
		} else {
			System.out.println("Operação não realizada");
		}

		System.out.println("UPDATE: " + livro.toString());

	}

	private void findLivroByPaginas() {
		List<Livro> livros = livroDao.findByPaginas(50, 200);
		livros.forEach(System.out::println);
	}

	private void findLivrosByEdicao() {
		List<Livro> livros = livroDao.findByEdicao(2);

		livros.forEach(System.out::println);

	}

	private void findAutorWithLivros() {
		Autor autor = autorDao.findAutorWithLivros(1);

		System.out.println(autor.toString());

		for (Livro livro : autor.getLivros()) {
			System.out.println(livro.toString());
		}

	}

	private void findLivroWithAutores() {
		Livro livro = livroDao.findLivroWithComAutores(9);

		System.out.println(livro.toString());

		for (Autor autor : livro.getAutores()) {
			System.out.println(autor.toString());
		}

	}

	private void insertLivro() {
		String titulo = "Tudo sobre Jogos on line";
		int edicao = 2;
		int paginas = 105;

		String[] autores = { "Caio Sousa"};

		Livro livro = new Livro();
		livro.setTitulo(titulo);
		livro.setEdicao(edicao);
		livro.setPaginas(paginas);

		livro = livroDao.save(livro);

		Integer idLivro = livro.getId();

		for (String nome : autores) {
			Integer idAutor = autorDao.getIdByNome(nome);
			livroAutorDao.save(new LivroAutor(idLivro, idAutor));
			System.out.println("Livro inserido com sucesso");
		}

	}

	private void findEditoraWithAutores() {
		Editora editora = editoraDao.findEditoraWithAutores(11, 0, 2);

		System.out.println(editora.getId() + "; " + editora.getRazaoSocial() + "; " + editora.getEmail() + "; "
				+ editora.getCidade());

		System.out.println("------------------------------------");
		for (Autor autor : editora.getAutores()) {
			System.out.println(autor.toString());
		}

		System.out.println("------------------------------------");
		editora = editoraDao.findEditoraWithAutores(11, 1, 2);
		for (Autor autor : editora.getAutores()) {
			System.out.println(autor.toString());
		}

		System.out.println("------------------------------------");
		editora = editoraDao.findEditoraWithAutores(11, 2, 2);
		for (Autor autor : editora.getAutores()) {
			System.out.println(autor.toString());
		}

		System.out.println("------------------------------------");
		editora = editoraDao.findEditoraWithAutores(11, 3, 2);
		for (Autor autor : editora.getAutores()) {
			System.out.println(autor.toString());
		}
	}

	private void deleteAutor() {
		int ok = autorDao.delete(1);

		if (ok == 1) {
			System.out.println("Operação realizada com sucesso!");
		} else {
			System.out.println("Operação não realizada!");
		}

	}

	private void updateAutor() {
		System.out.println("Antes");
		Autor autor = autorDao.findById(1);
		System.out.println(autor.toString());

		Editora editora = new Editora();
		editora.setId(2);

		autor.setEditora(editora);

		int ok = autorDao.update(autor);

		if (ok == 1) {
			System.out.println("depois");
			Autor aut = autorDao.findById(1);
			System.out.println(aut.toString());
		} else {
			System.out.println("Operação não realizada!");
		}

	}

	private void findAutoresByEditora() {
		List<Autor> autores = autorDao.findAutoresByEditoras("Editora Gaveia S/A");
		autores.forEach(System.out::println);
	}

	private void findAllAutores() {
		List<Autor> autores = autorDao.findAll();
		autores.forEach(System.out::println);

	}

	private void insertAutor() {
		Editora editora = editoraDao.findById(15);
		System.out.println(editora);
		Autor autor = new Autor();
		autor.setNome("Santorio Mendes Castro");
		autor.setEmail("smc@email.com.br");
		autor.setEditora(editora);

		if (StringUtils.isEmpty(autor.getId())) {
			autor = autorDao.save(autor);
		}

		if (!StringUtils.isEmpty(autor.getId())) {
			System.out.println(autor.toString());
		}

	}

	private void deleteEditora() {
		int ok = editoraDao.delete(1);

		if (ok == 1) {
			System.out.println("Operação realizada com Sucesso!");
		} else {
			System.out.println("Operação não realizada");
		}

	}

	private void updateEditora() {
		Editora editora = editoraDao.findById(2);
		System.out.println(editora.getRazaoSocial());

		editora.setRazaoSocial("Editora Norte S/A");

		int ok = editoraDao.update(editora);

		if (ok == 1) {
			Editora ed = editoraDao.findById(2);
			System.out.println(ed.toString());
		} else {
			System.out.println("Operação não realizada");
		}

	}

	private void findCidadeAndEmailByIdEditora() {
		List<String> lista = editoraDao.findCidadeAndEmailById(11);
		lista.forEach(System.out::println);
		System.out.println("----------------");
		
		Editora editora = editoraDao.findCidadeAndEmailForId(11);
		System.out.println(editora.toString());
		System.out.println("----------------");
		
		List<Editora> editoras = editoraDao.findCidadesAndEmails();
		editoras.forEach(System.out::println);
	}

	private void findEmailByIdEditora() {
		String email = editoraDao.findEmailById(11);
		System.out.println("Email: " + email);

		List<String> emails = editoraDao.findByEmails();
		emails.forEach(System.out::println);

	}

	private void countEditoras() {
		int count = editoraDao.count();
		System.out.println("Count is " + count);

	}

	private void findByRazaoSocial() {
		List<Editora> editoras = editoraDao.findByRazaoSocial("Ico");
		editoras.forEach(System.out::println);
	}

	private void findByCidade() {
		List<Editora> editoras = editoraDao.findByCidades("Belém", "Recife");

		editoras.forEach(System.out::println);

	}

	private void findById() {
		Editora editora = editoraDao.findById(11);
		System.out.println(editora.toString());

	}

	private void findAllEditoras() {
		List<Editora> editoras = editoraDao.findAll();

		editoras.forEach(System.out::println);

	}

	private void insertEditora() {
		Editora editora = new Editora();
		editora.setRazaoSocial("Editora Águia S/A");
		editora.setCidade("Marabá");
		editora.setEmail("contato@aguia.com.br");

		int ok = editoraDao.insert(editora);
		System.out.println("OK = " + ok);
//		int id = dao.save(editora);
//		System.out.println("ID = " + id);
//		editora = dao.add(editora);
//		System.out.println(editora.toString());

	}
}
