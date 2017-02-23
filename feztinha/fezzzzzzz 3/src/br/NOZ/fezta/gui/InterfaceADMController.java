package br.NOZ.fezta.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;

import javafx.scene.control.TextArea;

import javafx.scene.input.MouseEvent;

import javafx.scene.input.KeyEvent;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.text.Text;

import javafx.scene.chart.PieChart;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import br.NOZ.fezta.beans.Cliente;
import br.NOZ.fezta.beans.Endereco;
import br.NOZ.fezta.beans.Evento;
import br.NOZ.fezta.beans.Funcionario;
import br.NOZ.fezta.beans.Ingresso;
import br.NOZ.fezta.beans.Produto;
import br.NOZ.fezta.repositorio.RepositorioEventos;
import br.NOZ.fezta.repositorio.RepositorioFuncionario;
import br.NOZ.fezta.repositorio.RepositorioIngresso;
import br.NOZ.fezta.repositorio.RepositorioProdutos;
import javafx.event.ActionEvent;

import javafx.scene.control.PasswordField;

import javafx.scene.input.InputMethodEvent;

import javafx.scene.control.TableView;

public class InterfaceADMController /* implements Initializable */ {
	@FXML
	private TextField empresaRua;
	@FXML
	private TextField empresaBairro;
	@FXML
	private TextField empresaN;
	@FXML
	private TextField empresaCep;
	@FXML
	private TextField empresaNome;
	@FXML
	private Text fNome;
	@FXML
	private Text fCPF;
	@FXML
	private Text fFuncao;
	@FXML
	private Text fSalario;
	@FXML
	private TableView<LocalDateTime> fFim;
	@FXML
	private TableColumn<LocalDateTime, LocalDateTime> fcFim;
	@FXML
	private TableView<LocalDateTime> fInicio;
	@FXML
	private TableColumn<LocalDateTime, LocalDateTime> fcInicio;
	@FXML
	private TableView<Evento> calendarioTabelaEventos;
	@FXML
	private TableColumn<Evento, String> caLiCod;
	@FXML
	private TableColumn<Evento, LocalDate> caLiDia;
	@FXML
	private TextField calendarioCod;
	@FXML
	private TextField calendarioEvento;
	@FXML
	private TextField calendarioDia;
	@FXML
	private TextField calendarioMes;
	@FXML
	private TextField calendarioAno;
	@FXML
	private TextField calendarioCusto;
	@FXML
	private TextField calendarioLucro;
	@FXML
	private TextArea calendarioAnotacoes;
	@FXML
	private TableView<Produto> estoqueTable;
	@FXML
	private TableColumn<Produto, String> eTCodigo;
	@FXML
	private TableColumn<Produto, String> eTNome;
	@FXML
	private TableColumn<Produto, String> eTPreco;
	@FXML
	private TableColumn<Produto, String> eTQTD;
	@FXML
	private TextField estoqueQTD;
	@FXML
	private TextField estoquePreco;
	@FXML
	private TextField estoqueNome;
	@FXML
	private TextField estoqueCodigo;
	@FXML
	private TableView<Evento> financeiroEventos;
	@FXML
	private TableColumn<Evento, String> financeiroCod;
	@FXML
	private TableColumn<Evento, LocalDate> financeiroDia;
	@FXML
	private PieChart lucroTotal;
	@FXML
	private Label financeiroIT;
	@FXML
	private Label financeiroIngressos;
	@FXML
	private TableView<Produto> financeiroVendas;
	@FXML
	private TableColumn<Produto, String> finTCodigo;
	@FXML
	private TableColumn<Produto, String> finTNome;
	@FXML
	private TableColumn<Produto, String> finTPreco;
	@FXML
	private TableColumn<Produto, String> finTQTD;
	@FXML
	private TableView<Funcionario> funcionarioTabela;
	@FXML
	private TableColumn<Funcionario, String> fuLiCPF;
	@FXML
	private TableColumn<Funcionario, String> fuLiNome;
	@FXML
	private TextField funcionarioCep;
	@FXML
	private TextField funcionarioN;
	@FXML
	private TextField funcionarioBairro;
	@FXML
	private TextField funcionarioRua;
	@FXML
	private TextField funcionarioCPF;
	@FXML
	private TextField funcionarioNome;
	@FXML
	private TextField funcionarioTelefone;
	@FXML
	private TextField funcionarioSalario;
	@FXML
	private TextField funcionarioFuncao;
	@FXML
	private TextField funcionarioLogin;
	@FXML
	private PasswordField funcionarioSenha;
	@FXML
	private TextField funcionarioAcess;
	@FXML
	private TextField funcionarioEDia;
	@FXML
	private TextField funcionarioEMes;
	@FXML
	private TextField funcionarioEAno;
	@FXML
	private TextField funcionarioSAno;
	@FXML
	private TextField funcionarioSMes;
	@FXML
	private TextField funcionarioSDia;
	@FXML
	private TableView<Funcionario> fuTaFim;
	@FXML
	private TableColumn<Funcionario, LocalDate> fuLiFim;
	@FXML
	private TableView<Funcionario> fuTaInicio;
	@FXML
	private TableColumn<Funcionario, LocalDate> fuLiInicio;
	@FXML
	private TableView<Ingresso> bilheteClientes;
	@FXML
	private TableColumn<Ingresso, String> biLiCod;
	@FXML
	private TableColumn<Ingresso, String> biLiNome;
	@FXML
	private Button bilheteSair;
	@FXML
	private TextField bilheteNome;
	@FXML
	private TextField bilheteCPF;
	@FXML
	private TextField bilheteAno;
	@FXML
	private TextField bilheteMes;
	@FXML
	private TextField bilheteDia;
	@FXML
	private TextField bilheteEvento;
	@FXML
	private TextField bilheteIngresso;
	@FXML
	private TextField bilhetePreco;
	@FXML
	private TextField bilhetePista;
	@FXML
	private TableView<Produto> clienteConsumo;
	@FXML
	private TableColumn<Produto, String> biConCod;
	@FXML
	private TableColumn<Produto, String> biConProd;
	@FXML
	private TableColumn<Produto, String> biConQ;
	@FXML
	private TableColumn<Produto, String> biConPreco;
	@FXML
	private TextField barProduto;
	@FXML
	private TextField barQuantidade;
	@FXML
	private TextField barCliente;
	@FXML
	private TableView<Produto> barTabela;
	@FXML
	private TableColumn<Produto, String> baLiCod;
	@FXML
	private TableColumn<Produto, String> baLiNome;
	@FXML
	private TableColumn<Produto, String> baLiEstoque;
	@FXML
	private TableColumn<Produto, String> baLiPreco;
	@FXML
	private Text funcionarioNomeTop;
	@FXML
	private Text funcaoNaEmpresaTop;

	// Event Listener on TextField[#empresaRua].onKeyReleased
	@FXML
	public void empresaDigitar(KeyEvent event) {
		Facade.getInstance().mudarEmpresa(empresaNome.getText(), empresaN.getText(), empresaRua.getText(),
				empresaBairro.getText(), empresaCep.getText());
	}

	// Evento evento = new Evento();
	@FXML
	public void novoEvento(ActionEvent event) {
		if (calendarioCod.getText().equals("") == false) {
			Evento env = new Evento();
			try {
				env.setCodigo(calendarioCod.getText());
				env.setEvento(calendarioEvento.getText());
				env.setDecoracao(calendarioAnotacoes.getText());

				int d = Integer.valueOf(calendarioDia.getText()).intValue();
				int m = Integer.valueOf(calendarioMes.getText()).intValue();
				int a = Integer.valueOf(calendarioAno.getText()).intValue();

				int c = Integer.valueOf(calendarioCusto.getText()).intValue();
				int r = Integer.valueOf(calendarioLucro.getText()).intValue();

				LocalDate dia = LocalDate.of(a, m, d);
				env.setDia(dia);

				env.setCusto(c);
				env.setReceita(r);

				Facade.getInstance().addEvento(env);

				calendarioTabelaEventos.getItems().clear();
				financeiroEventos.getItems().clear();
				calendarioTabelaEventos.getItems().addAll(RepositorioEventos.getInstance().getCalendario());
				financeiroEventos.getItems().addAll(RepositorioEventos.getInstance().getCalendario());
			} catch (Exception e) {
				calendarioAnotacoes.setText(calendarioAnotacoes.getText() + "\nColoque valores Válidos.");
			}
		}
	}

	// Event Listener on Button.onAction
	@FXML
	public void editarEvento(ActionEvent event) {

		// Evento evn =
		// Facade.getInstance().procurarEvento(calendarioCod.getText());
		// Evento ev2 =
		// Facade.getInstance().procurarEvento(calendarioCod.getText());
		Evento evn = new Evento();
		// System.out.println(calendarioCod.getText());
		// if (evn != null) {
		// System.out.println("gasdj");
		try {
			evn.setCodigo(calendarioCod.getText());
			evn.setEvento(calendarioEvento.getText());
			evn.setDecoracao(calendarioAnotacoes.getText());

			int d = Integer.valueOf(calendarioDia.getText()).intValue();
			int m = Integer.valueOf(calendarioMes.getText()).intValue();
			int a = Integer.valueOf(calendarioAno.getText()).intValue();

			int c = Integer.valueOf(calendarioCusto.getText()).intValue();
			int r = Integer.valueOf(calendarioLucro.getText()).intValue();

			LocalDate dia = LocalDate.of(a, m, d);
			evn.setDia(dia);

			evn.setCusto(c);
			evn.setReceita(r);

			Facade.getInstance().atualizarEvento(calendarioCod.getText(), evn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/*
	 * if (calendarioCod.getText().equals("") == false) {
	 * 
	 * }
	 */

	// Event Listener on TextField[#calendarioCod].onInputMethodTextChanged
	@FXML
	public void procurarEvento(MouseEvent event) {
		Evento evn = Facade.getInstance().procurarEvento(calendarioCod.getText());
		System.out.println(calendarioCod.getText());
		if (evn != null) {
			calendarioCod.setText(evn.getCodigo());
			calendarioEvento.setText(evn.getEvento());
			calendarioDia.setText("" + evn.getDia().getDayOfMonth());
			calendarioMes.setText("" + evn.getDia().getMonth());
			calendarioAno.setText("" + evn.getDia().getYear());
			calendarioCusto.setText("" + evn.getCusto());
			calendarioLucro.setText("" + evn.getReceita());
			calendarioAnotacoes.setText(evn.getDecoracao());
		}
	}

	// Event Listener on Button.onAction
	@FXML
	public void estoqueNovo(ActionEvent event) {
		Produto pro = new Produto();
		try {
			// System.out.println("foi");
			pro.setCodigo(estoqueCodigo.getText());
			pro.setNome(estoqueNome.getText());
			// System.out.println("foi12");

			int q = Integer.valueOf(estoqueQTD.getText()).intValue();
			float p = Float.valueOf(estoquePreco.getText()).floatValue();

			// System.out.println("foi2");
			pro.setQuantidade(q);
			pro.setPreco(p);
			// System.out.println("foi2");

			Facade.getInstance().addProduto(pro);
			// System.out.println("foi3");
			estoqueTable.getItems().clear();
			estoqueTable.getItems().addAll(RepositorioProdutos.getInstance().getProdutos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Event Listener on Button.onAction
	@FXML
	public void estoqueEditar(ActionEvent event) {
		Produto pro = new Produto();
		try {
			pro.setCodigo(estoqueCodigo.getText());
			pro.setNome(estoqueNome.getText());

			int q = Integer.valueOf(estoqueQTD.getText()).intValue();
			float p = Float.valueOf(estoquePreco.getText()).floatValue();

			pro.setQuantidade(q);
			pro.setPreco(p);

			Facade.getInstance().editarProduto(pro.getCodigo(), pro);

			estoqueTable.getItems().clear();
			estoqueTable.getItems().addAll(RepositorioProdutos.getInstance().getProdutos());
		} catch (Exception e) {

		}

	}

	// Event Listener on TextField[#estoqueCodigo].onInputMethodTextChanged
	@FXML
	public void procurarProduto(MouseEvent event) {
		Produto pro = Facade.getInstance().procurarProduto(estoqueCodigo.getText());
		// System.out.println(calendarioCod.getText());
		if (pro != null) {
			estoqueCodigo.setText(pro.getCodigo());
			estoqueNome.setText(pro.getNome());
			estoquePreco.setText("" + pro.getPreco());
			estoqueQTD.setText("" + pro.getQuantidade());
		}
	}

	// Event Listener on TableView[#financeiroEventos].onMouseMoved
	@FXML
	public void financeiroEvento(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void novoFuncionario(ActionEvent event) {
		
		if(funcionarioCPF.getText() != null && funcionarioCPF.getText().equals("") == false)
		{
			//cu
			
		}
		
		// TODO Autogenerated
	}
	
	// Event Listener on Button.onAction
	@FXML
	public void editarFuncionario(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void demitirFuncionario(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on TextField[#funcionarioCPF].onInputMethodTextChanged
	@FXML
	public void procurarFuncionario(MouseEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void funcionarioEscalar(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on TableView[#bilheteClientes].onMouseExited
	@FXML
	public void bilheteTroca(MouseEvent event) {

		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void novoCliente(ActionEvent event) {
		Ingresso novo = new Ingresso();
		Cliente cli = new Cliente();
		// Cliente pessoa;
		if (bilheteIngresso.getText().equals("") != true) {
			try {
				// Cliente pessoa = new Cliente();
				novo.setCodigo(bilheteIngresso.getText());
				novo.setDia(RepositorioEventos.getInstance().procurarEvento(bilheteEvento.getText()));
				cli.setNome(bilheteNome.getText());
				cli.setCpf(bilheteCPF.getText());
				int p = Integer.valueOf(bilhetePreco.getText());
				novo.setPreco(p);
				novo.setNome(cli.getNome());
				cli.setTotalPreco((float) (p));
				//System.out.println("go1");
				// novo.getCliente().setNome(bilheteNome.getText());
				// novo.getCliente().setCpf(bilheteCPF.getText());
				cli.setTotalPreco(p);
				novo.setCliente(cli);
				novo.setEntrada(LocalDateTime.now());
				novo.setPista(bilhetePista.getText());
				System.out.println("go2");

				Facade.getInstance().addIngresso(novo);
				bilheteClientes.getItems().add(novo);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// Event Listener on Button.onAction
	@FXML
	public void EditarCliente(ActionEvent event) {
		Ingresso novo = new Ingresso();
		Cliente cli = new Cliente();
		// Cliente pessoa;
		if (bilheteIngresso.getText().equals("") != true) {
			try {
				// Cliente pessoa = new Cliente();
				novo.setCodigo(bilheteIngresso.getText());
				novo.setDia(RepositorioEventos.getInstance().procurarEvento(bilheteEvento.getText()));
				cli.setNome(bilheteNome.getText());
				cli.setCpf(bilheteCPF.getText());
				int p = Integer.valueOf(bilhetePreco.getText());
				novo.setPreco(p);
				novo.setNome(cli.getNome());
				cli.setTotalPreco((float) (p));

				// novo.getCliente().setNome(bilheteNome.getText());
				// novo.getCliente().setCpf(bilheteCPF.getText());
				novo.setCliente(cli);
				novo.setEntrada(LocalDateTime.now());
				novo.setPista(bilhetePista.getText());

				Facade.getInstance().editarIngresso(bilheteIngresso.getText(), novo);
				System.out.println("edited");
				// Facade.getInstance().addIngresso(novo);
				bilheteClientes.getItems().clear();
				bilheteClientes.getItems().addAll(RepositorioIngresso.getInstance().listarIngressos());
			} catch (Exception e) {
				System.out.println(e.getMessage() + "PQP");
			}
		}
		// TODO Autogenerated
	}

	// Event Listener on Button[#bilheteSair].onAction
	@FXML
	public void clienteFechar(ActionEvent event) {
		
		// TODO Autogenerated
	}

	// Event Listener on Button[#bilheteSair].onMouseMoved
	@FXML
	public void atualizarTotal(MouseEvent event) {

		// TODO Autogenerated
	}

	// Event Listener on TextField[#bilheteIngresso].onInputMethodTextChanged
	@FXML
	public void procurarCliente(MouseEvent event) {
		Ingresso ing = Facade.getInstance().procurarCliente(bilheteIngresso.getText());
		//System.out.println(calendarioCod.getText());
		try{
		if (ing != null) {
			bilheteNome.setText(ing.getNome());
			bilheteCPF.setText(ing.getCliente().getCpf());
			bilhetePreco.setText("" + ing.getPreco());
			bilheteEvento.setText(ing.getDia().getCodigo());
			bilhetePista.setText(ing.getPista());
			bilheteSair.setText("Fechar: R$ " + ing.getCliente().getTotalPreco());
			
			clienteConsumo.getItems().clear();
			clienteConsumo.getItems().addAll(ing.getCliente().getProdutos());
			/*
			calendarioCod.setText(evn.getCodigo());
			calendarioEvento.setText(evn.getEvento());
			calendarioDia.setText("" + evn.getDia().getDayOfMonth());
			calendarioMes.setText("" + evn.getDia().getMonth());
			calendarioAno.setText("" + evn.getDia().getYear());
			calendarioCusto.setText("" + evn.getCusto());
			calendarioLucro.setText("" + evn.getReceita());
			calendarioAnotacoes.setText(evn.getDecoracao());*/
		}}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void barVender(ActionEvent event) {
		int q = Integer.valueOf(barQuantidade.getText());
		Facade.getInstance().vender(barCliente.getText(), barProduto.getText(), q);
		// TODO Autogenerated
	}

	// Event Listener on Button.onAction
	@FXML
	public void sairButton(ActionEvent event) {
		ScreenManager.getInstance().callLogin();
		;
		// TODO Autogenerated
	}

	private boolean t = false;

	@FXML
	public void mouseMoveu(MouseEvent event) {

		// System.out.println("moveu");

		if (t == false) {
			t = true;
			// Inicializar a aba da Empresa;
			empresaNome.setText(RepositorioEventos.getInstance().getEstabelecimento());
			Endereco end = RepositorioEventos.getInstance().getEndereco();
			empresaBairro.setText(end.getBairro());
			empresaCep.setText(end.getCEP());
			empresaN.setText(end.getNumero());
			empresaRua.setText(end.getRua());

			// Iniciar a aba do Você
			Funcionario fL = Facade.getInstance().getFuncionario();
			funcionarioNomeTop.setText(fL.getNome());
			funcaoNaEmpresaTop.setText(fL.getFuncao());

			fNome.setText(fL.getNome());
			fFuncao.setText(fL.getFuncao());
			fCPF.setText(fL.getCpf());
			fSalario.setText("Salário: " + fL.getSalario());
			fcInicio.setCellValueFactory(new PropertyValueFactory<>("escalamento"));
			fcFim.setCellValueFactory(new PropertyValueFactory<>("escalamento"));
			fInicio.getItems().addAll(Facade.getInstance().getInicioExpediente());
			fFim.getItems().addAll(Facade.getInstance().getFimExpediente());
			// fcInicio.setCellValueFactory(new
			// PropertyValueFactory<>("escalamento"));
			// fcInicio.getItems()

			// Iniciar a aba do calendário

			caLiCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
			caLiDia.setCellValueFactory(new PropertyValueFactory<>("dia"));
			calendarioTabelaEventos.getItems().addAll(RepositorioEventos.getInstance().getCalendario());
			/*
			 * Evento evnt = new Evento(); evnt.setDia(LocalDate.now());
			 * evnt.setCodigo("001");
			 * 
			 * Evento evnt1 = new Evento(); evnt1.setDia(LocalDate.now());
			 * evnt1.setCodigo("002");
			 * 
			 * Evento evnt2 = new Evento(); evnt2.setDia(LocalDate.now());
			 * evnt2.setCodigo("003");
			 * 
			 * calendarioTabelaEventos.getItems().add(evnt);
			 * calendarioTabelaEventos.getItems().add(evnt1);
			 * calendarioTabelaEventos.getItems().add(evnt2);
			 */

			// Iniciar aba de estoque
			eTCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
			eTNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			eTPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
			eTQTD.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
			estoqueTable.getItems().addAll(RepositorioProdutos.getInstance().getProdutos());

			// Iniciar Financeiro
			financeiroCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
			financeiroDia.setCellValueFactory(new PropertyValueFactory<>("dia"));
			financeiroEventos.getItems().addAll(RepositorioEventos.getInstance().getCalendario());

			// Iniciar Funcionarios
			fuLiInicio.setCellValueFactory(new PropertyValueFactory<>("escalamento"));
			fuLiFim.setCellValueFactory(new PropertyValueFactory<>("escalamento"));

			fuLiCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			fuLiNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			funcionarioTabela.getItems().addAll(RepositorioFuncionario.getInstance().getAL());

			// Iniciar Bilheteria
			biLiCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
			biLiNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			bilheteClientes.getItems().addAll(RepositorioIngresso.getInstance().listarIngressos());

			biConCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
			biConProd.setCellValueFactory(new PropertyValueFactory<>("nome"));
			biConPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
			biConQ.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

			// Iniciar Bar
			baLiCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
			baLiNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			baLiPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
			baLiEstoque.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
			barTabela.getItems().addAll(RepositorioProdutos.getInstance().getProdutos());

			// Facade.getInstance().iniciar();
			// TODO Auto-generated method stub
		}
		
		barTabela.getItems().clear();
		barTabela.getItems().addAll(RepositorioProdutos.getInstance().listarProdutos());
		
	}
}
