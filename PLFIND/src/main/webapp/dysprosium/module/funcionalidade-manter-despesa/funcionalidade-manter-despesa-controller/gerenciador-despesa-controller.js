var gerenciadorDespesaModule = angular.module('gerenciadorDespesaModule', []);

gerenciadorDespesaModule.controller('gerenciadorDespesaController', function($scope) {

		function initializer() {
			$scope.despesaModel.is_item_unico = "true";
			$scope.despesaModel.is_forma_pagamento_unico = "true";
			$scope.despesaModel.fonte_pagamento = "Selecione";
			$scope.despesaModel.canal_pagamento = "0";
			$scope.despesaModel.responsavel_pagamento = "0";
		};

		var despesaList = 
		[
			{
				codigo: 1,
				favorecido: 'Só Digital Comércio e Serviços de Informática (Rodoviária do Plano Piloto)',
				data_despesa: '04/12/2019',
				is_item_unico: false,
				produto_servico: 'Mouse Óptico sem fio Multilaser',
				valor_despesa: 'R$ 55,00',
				is_forma_pagamento_unico: false,
				fonte_pagamento: 'Carteira Pessoal (Dinheiro)',
				canal_pagamento: 'Pagamento no Caixa do Estabelecimento',
				valor_pagamento_multiplo: 'R$ 55,00',
				responsavel_pagamento: 'Jose Quintin',
			}, 
			{
				codigo: 2,
				favorecido: 'Só Digital Comércio e Serviços de Informática (Rodoviária do Plano Piloto)',
				data_despesa: '04/12/2019',
				is_item_unico: false,
				produto_servico: 'Cabo USB Shinka (Carregador de iPhone)',
				valor_despesa: 'R$ 45,00',
				is_forma_pagamento_unico: false,
				fonte_pagamento: 'Banco Santander do Brasil S.A (Cartão de Crédito)',
				canal_pagamento: 'Pagamento no Caixa do Estabelecimento',
				valor_pagamento_multiplo: 'R$ 55,00',
				responsavel_pagamento: 'Jamile Batista Alves',
			}, 
			// {
			// 	codigo: 3,
			// 	favorecido: 'Supermercado PraVocê (Taguatinga Centro)',
			// 	data_despesa: '05/12/2019',
			// 	is_item_unico: true,
			// 	produto_servico: 'Filé de Tilápia Copacol 800gm',
			// 	valor_despesa: 'R$ 32,95',
			// 	is_forma_pagamento_unico: false,
			// 	fonte_pagamento: 'Banco Nubank do Brasil S.A (Cartão de Crédito)',
			// 	canal_pagamento: 'Pagamento em Caixa do Estabelecimento',
			// 	valor_pagamento_multiplo: 'R$ 55,00',
			// 	responsavel_pagamento: 'Jamile Batista Alves',
			// }
		];

		var fontePagamentoList = [
			{
				codigo: 0,
				nomeFontePagamento: "Selecione",
			},
			{
				codigo: 1,
				nomeFontePagamento: "Banco Santander (Cartão de Crédito)",
			},
			{
				codigo: 2,
				nomeFontePagamento: "Banco Caixa Econômica Federal (Cartão de Débito)",
			},
			{
				codigo: 3,
				nomeFontePagamento: "Banco Nubank (Cartão de Débito)",
			}
		];

		var canalPagamentoList = [
			{
				codigo: 1,
				nomeCanalPagamento: "Pagamento em Caixa",
			},
			{
				codigo: 2,
				nomeCanalPagamento: "Pagamento via Internet Banking",
			},
			{
				codigo: 3,
				nomeCanalPagamento: "Pagamento com Cartão de Crédito",
			},
			{
				codigo: 4,
				nomeCanalPagamento: "Pagamento com Boleto Bancário",
			},
			{
				codigo: 5,
				nomeCanalPagamento: "Pagamento com Cheque Prédatado",
			}
		];

		var responsavelPagamentoList = [
			{
				codigo: 1,
				nomeResponsavelPagamento: "Jamille Batista Alves",
			},
			{
				codigo: 2,
				nomeResponsavelPagamento: "José Quintin",
			}
		];

		$scope.produtoServicoList = [];

		$scope.formaPagamentoList = [];
		
		$scope.despesaList = despesaList;

		$scope.despesaModel = {};

		$scope.isItemUnicoFlag = false;

		$scope.isFormaPagamentoUnicoFlag = false;

		$scope.fontePagamentoList = fontePagamentoList;

		$scope.canalPagamentoList = canalPagamentoList;

		$scope.responsavelPagamentoList = responsavelPagamentoList;

		var produtoServicoModel = {
			codigo: null,
			produtoServico: null,
			valorProdutoServico: null,
		};

		var formaPagamentoModel = {
			codigo: null,
			fontePagamento: null,
			canalPagamento: null,
			responsavelPagamento: null,
		};

		// FIXME [PLFINC] {} -- ""
		$scope.persist = function(despesaModel) {
			console.log(despesaModel);
			if(isValidaDespesaVariavel(despesaModel)) {
				despesaList.push(despesaModel);
				$scope.clearDespesModelAll();
				toastr.success('Dados cadastrados com Sucesso!');
			}
		};

		$scope.cadastrarProdutoServico = function(despesaModel) {
			produtoServicoModel.produtoServico = despesaModel.produto_servico;
			produtoServicoModel.valorProdutoServico = despesaModel.valor_despesa;
			$scope.produtoServicoList.push(angular.copy(produtoServicoModel));
			clearProdutoServico();
		};

		$scope.cadastrarFormaPagamento = function(despesaModel) {
			formaPagamentoModel.fontePagamento = despesaModel.fonte_pagamento;
			formaPagamentoModel.canalPagamento = despesaModel.canal_pagamento;
			formaPagamentoModel.responsavelPagamento = despesaModel.responsavel_pagamento;
			$scope.formaPagamentoList.push(angular.copy(formaPagamentoModel));
			clearFormaPagamento();
		};

		$scope.removeProdutoServico = function(produtoServicoModel) {
			for( let index = 0 ; index < $scope.produtoServicoList.length ; index++ ) {
				if (produtoServicoModel.produtoServico === $scope.produtoServicoList[index].produtoServico && 
					produtoServicoModel.valorProdutoServico === $scope.produtoServicoList[index].valorProdutoServico) {
					$scope.produtoServicoList.splice(index, 1);
				}
			}
		};

		$scope.verificarItemUnico = function(despesaModel) {
			if(despesaModel != undefined) {
				if (despesaModel.is_item_unico == "true") {
					$scope.isItemUnicoFlag = false;
				} else {
					$scope.isItemUnicoFlag = true;
				}
			}
		};

		$scope.verificarFormaPagamentoUnico = function(despesaModel) {
			if(despesaModel != undefined) {
				if (despesaModel.is_forma_pagamento_unico == "true") {
					$scope.isFormaPagamentoUnicoFlag = false;
				} else {
					$scope.isFormaPagamentoUnicoFlag = true;
				}
			}
		};

		// FIXME [PLFINC] {} -- ""
		function isValidaDespesaVariavel(despesaModel) {
			if(despesaModel.favorecido == null || despesaModel.favorecido == undefined) {
				// window.alert("Campo obrigatório não informado!");
				toastr.error('Campo obrigatório não informado!');
				return false;
			}
			return true;
		};

		$scope.clearDespesModelAll = function() {
			$scope.despesaModel = {
				is_item_unico: "true",
				is_forma_pagamento_unico: "true",
				fonte_pagamento: "0",
				canal_pagamento: "0",
				responsavel_pagamento: "0",
			};
			$scope.produtoServicoList = [];
			$scope.formaPagamentoList = [];
			$scope.isItemUnicoFlag = false;
			$scope.isFormaPagamentoUnicoFlag = false;
		};

		function clearProdutoServico() {
			$scope.despesaModel.produto_servico = null;
			$scope.despesaModel.valor_despesa = null;
		};

		function clearFormaPagamento() {
			$scope.despesaModel.fonte_pagamento = null;
			$scope.despesaModel.canal_pagamento = null;
			$scope.despesaModel.responsavel_pagamento = null;
		};

		initializer();

});