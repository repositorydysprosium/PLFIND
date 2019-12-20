var gerenciadorDespesaModule = angular.module('gerenciadorDespesaModule', []);

gerenciadorDespesaModule.controller('gerenciadorDespesaController', function($scope) {

		function initializer() {
			$scope.despesaModel.is_item_unico = "true";
			$scope.despesaModel.is_forma_pagamento_unico = "true";
			$scope.despesaModel.quantidade_produto_servico = 1;
			$scope.despesaModel.fonte_pagamento = null;
			$scope.despesaModel.canal_pagamento = null;
			$scope.despesaModel.responsavel_pagamento = null;
			toastr.options.progressBar = true;
			toastr.options.positionClass = 'toast-top-right';
			toastr.options.timeOut = '10000';
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

		$scope.isCamposFavorecidoInvalidoFlag = false;
		$scope.isCamposDataDespesaInvalidoFlag = false;
		$scope.isCampoProdutoServicoInvalidoFlag = false;
		$scope.isCampoValorDespesaInvalidoFlag = false;
		$scope.isCampoFontePagamentoInvalidoFlag = false;
		$scope.isCampoCanalPagamentoInvalidoFlag = false;
		$scope.isCampoResponsavelPagamentoInvalidoFlag = false;
		$scope.isCampoQuantidadeProdutoServicoInvalidoFlag = false;
		$scope.isCampoObservacaoInvalidoFlag = false;
		
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

		$scope.persist = function(despesaModel) {
			console.log(despesaModel);
			if(isValidaDespesaVariavel(despesaModel)) {
				despesaList.push(despesaModel);
				$scope.clearDespesModelAll();
				toastr.success('Dados cadastrados com Sucesso!', 'Sucesso', {timeOut: 5000})
			}
		};

		$scope.cadastrarProdutoServico = function(despesaModel) {
			if(isValidaDespesaVariavel(despesaModel)) {
				produtoServicoModel.produtoServico = despesaModel.produto_servico;
				produtoServicoModel.valorProdutoServico = despesaModel.valor_despesa;
				$scope.produtoServicoList.push(angular.copy(produtoServicoModel));
				clearProdutoServico();
			}
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

		function isValidaDespesaVariavel(despesaModel) {
			if(isCampoFavorecidoValid(despesaModel) && 
			   isCampoDataDespesaValid(despesaModel) &&
			   isCampoProdutoServicoValid(despesaModel) &&
			   isCampoValorDespesaValid(despesaModel) &&
			   isCampoQuantidadeProdutoServicoValid(despesaModel) &&
			   isCampoFontePagamentoValid(despesaModel) &&
			   isCampoCanalPagamentoValid(despesaModel) && 
			   isCampoResponsavelPagamentoValid(despesaModel) &&
			   isCampoObservacaoValid(despesaModel)) {
				return true;
			}
			return false;
		};

		function isCampoFavorecidoValid(despesaModel) {
			if(despesaModel.favorecido == null || despesaModel.favorecido == undefined || despesaModel.favorecido == "") {
				favorecido_.className = "form-group has-danger";
				$scope.isCamposFavorecidoInvalidoFlag = true;
				return false;
			} else {
				favorecido_.className = "form-group";
				$scope.isCamposFavorecidoInvalidoFlag = false;
			}
			return true;
		}

		function isCampoDataDespesaValid(despesaModel) {
			if(despesaModel.data_despesa == null || despesaModel.data_despesa == undefined || despesaModel.data_despesa == "") {
				data_despesa_.className = "form-group has-danger";
				$scope.isCamposDataDespesaInvalidoFlag = true;
				return false;
			} else {
				data_despesa_.className = "form-group";
				$scope.isCamposDataDespesaInvalidoFlag = false;
			}
			return true;
		}

		function isCampoProdutoServicoValid(despesaModel) {
			if(despesaModel.produto_servico == null || despesaModel.produto_servico == undefined || despesaModel.produto_servico == "") {
				produto_servico_.className = "form-group has-danger";
				$scope.isCampoProdutoServicoInvalidoFlag = true;
				return false;
			} else {
				produto_servico_.className = "form-group";
				$scope.isCampoProdutoServicoInvalidoFlag = false;
			}
			return true;
		}

		function isCampoValorDespesaValid(despesaModel) {
			if(despesaModel.valor_despesa == null || despesaModel.valor_despesa == undefined || despesaModel.valor_despesa == "") {
				valor_despesa_.className = "form-group has-danger";
				$scope.isCampoValorDespesaInvalidoFlag = true;
				return false;
			} else {
				valor_despesa_.className = "form-group";
				$scope.isCampoValorDespesaInvalidoFlag = false;
			}
			return true;
		}

		function isCampoQuantidadeProdutoServicoValid(despesaModel) {
			if(despesaModel.quantidade_produto_servico == null || despesaModel.quantidade_produto_servico == undefined || despesaModel.quantidade_produto_servico == "") {
				quantidade_produto_servico_.className = "form-group has-danger text-danger";
				$scope.isCampoQuantidadeProdutoServicoInvalidoFlag = true;
				return false;
			} else {
				quantidade_produto_servico_.className = "form-group";
				$scope.isCampoQuantidadeProdutoServicoInvalidoFlag = false;
			}
			return true;
		}

		function isCampoFontePagamentoValid(despesaModel) {
			if(despesaModel.fonte_pagamento == null) {
				fonte_pagamento_.className = "form-group has-danger text-danger";
				$scope.isCampoFontePagamentoInvalidoFlag = true;
				return false;
			} else {
				fonte_pagamento_.className = "form-group";
				$scope.isCampoFontePagamentoInvalidoFlag = false;
			}
			return true;
		}

		function isCampoCanalPagamentoValid(despesaModel) {
			if(despesaModel.canal_pagamento == null) {
				canal_pagamento_.className = "form-group has-danger text-danger";
				$scope.isCampoCanalPagamentoInvalidoFlag = true;
				return false;
			} else {
				canal_pagamento_.className = "form-group";
				$scope.isCampoCanalPagamentoInvalidoFlag = false;
			}
			return true;
		}

		function isCampoResponsavelPagamentoValid(despesaModel) {
			if(despesaModel.responsavel_pagamento == null) {
				responsavel_pagamento_.className = "form-group has-danger text-danger";
				$scope.isCampoResponsavelPagamentoInvalidoFlag = true;
				return false;
			} else {
				responsavel_pagamento_.className = "form-group";
				$scope.isCampoResponsavelPagamentoInvalidoFlag = false;
			}
			return true;
		}

		function isCampoObservacaoValid(despesaModel) {
			if(despesaModel.observacao_despesa == null) {
				observacao_despesa_.className = "form-group has-danger text-danger";
				$scope.isCampoObservacaoInvalidoFlag = true;
				return false;
			} else {
				observacao_despesa_.className = "form-group";
				$scope.isCampoObservacaoInvalidoFlag = false;
			}
			return true;
		}

		$scope.clearDespesModelAll = function() {
			$scope.despesaModel = {
				is_item_unico: "true",
				quantidade_item: 1,
				is_forma_pagamento_unico: "true",
				fonte_pagamento: null,
				canal_pagamento: null,
				responsavel_pagamento: null,
			};
			$scope.produtoServicoList = [];
			$scope.formaPagamentoList = [];
			$scope.isItemUnicoFlag = false;
			$scope.isFormaPagamentoUnicoFlag = false;

			$scope.despesaModel.quantidade_produto_servico = 1;

			favorecido_.className = "form-group";
			$scope.isCamposFavorecidoInvalidoFlag = false;

			data_despesa_.className = "form-group";
			$scope.isCamposDataDespesaInvalidoFlag = false;

			produto_servico_.className = "form-group";
			$scope.isCampoProdutoServicoInvalidoFlag = false;

			valor_despesa_.className = "form-group";
			$scope.isCampoValorDespesaInvalidoFlag = false;

			quantidade_produto_servico_.className = "form-group";
			$scope.isCampoQuantidadeProdutoServicoInvalidoFlag = false;

			fonte_pagamento_.className = "form-group";
			$scope.isCampoFontePagamentoInvalidoFlag = false;

			canal_pagamento_.className = "form-group";
			$scope.isCampoCanalPagamentoInvalidoFlag = false;

			responsavel_pagamento_.className = "form-group";
			$scope.isCampoResponsavelPagamentoInvalidoFlag = false;

			observacao_despesa_.className = "form-group";
			$scope.isCampoObservacaoInvalidoFlag = false;
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
